package com.icure.sdk.test

import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.kryptom.utils.toHexString
import com.icure.sdk.IcureSdk
import com.icure.sdk.api.raw.RawMessageGatewayApi
import com.icure.sdk.api.raw.impl.RawAnonymousAuthApiImpl
import com.icure.sdk.auth.UsernamePassword
import com.icure.sdk.crypto.CryptoStrategies
import com.icure.sdk.crypto.impl.BasicCryptoStrategies
import com.icure.sdk.model.DataOwnerWithType
import com.icure.sdk.model.specializations.SpkiHexString
import com.icure.sdk.options.ApiOptions
import com.icure.sdk.options.AuthenticationMethod
import com.icure.sdk.options.getAuthProvider
import com.icure.sdk.storage.IcureStorageFacade
import com.icure.sdk.storage.impl.DefaultStorageEntryKeysFactory
import com.icure.sdk.storage.impl.JsonAndBase64KeyStorage
import com.icure.sdk.storage.impl.VolatileStorageFacade
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization

@OptIn(InternalIcureApi::class)
@ConsistentCopyVisibility
data class DataOwnerDetails private constructor (
	val dataOwnerId: String,
	val username: String,
	val password: String,
	val keypair: RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>,
	val parent: DataOwnerDetails?,
	val publicKeySpki: SpkiHexString
) {
	companion object {
		fun testEmailForLogin(login: String) = "$login@test.com"

		suspend operator fun invoke(
			dataOwnerId: String,
			username: String,
			password: String,
			keypair: RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>,
			parent: DataOwnerDetails?
		) = DataOwnerDetails(
			dataOwnerId = dataOwnerId,
			username = username,
			password = password,
			keypair = keypair,
			parent = parent,
			publicKeySpki = SpkiHexString(defaultCryptoService.rsa.exportPublicKeySpki(keypair.public).toHexString())
		)
	}

	val testEmail: String get() = testEmailForLogin(username)

	/**
	 * Creates a new api with access to the original key of the user and his parents.
	 */
	suspend fun api(cryptoStrategies: CryptoStrategies = BasicCryptoStrategies): IcureSdk =
		initApi(cryptoStrategies) { addInitialKeysToStorage(it) }

	/**
	 * Creates a new api with access to the provided keys.
	 * All the keys must be keys of the data owner and not of parents.
	 */
	suspend fun apiWithKeys(
		vararg keys: RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>,
		cryptoStrategies: CryptoStrategies = BasicCryptoStrategies
	): IcureSdk =
		initApi(cryptoStrategies) { storage ->
			keys.forEach { key ->
				storage.saveEncryptionKeypair(
					dataOwnerId,
					key,
					true
				)
			}
		}

	/**
	 * Creates an api simulating the loss of all keys for the user, prompting the creation of a new key.
	 * @return the api and the new key
	 */
	suspend fun apiWithLostKeys(cryptoStrategies: CryptoStrategies = BasicCryptoStrategies): Pair<IcureSdk, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>> {
		val newKey = defaultCryptoService.rsa.generateKeyPair(RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256)
		return Pair(
			initApi(
				object : CryptoStrategies by cryptoStrategies {
					override suspend fun generateNewKeyForDataOwner(
						self: DataOwnerWithType,
						cryptoPrimitives: CryptoService,
					): CryptoStrategies.KeyGenerationRequestResult {
						val customResult = kotlin.runCatching {
							cryptoStrategies.generateNewKeyForDataOwner(self, cryptoPrimitives)
						}
						require(
							customResult.isSuccess
								&& customResult.getOrThrow() !is CryptoStrategies.KeyGenerationRequestResult.Use
						) {
							"`apiWithLostKeys` overrides the key generation strategy, so it should not provide a custom key or throw an exception."
						}
						return CryptoStrategies.KeyGenerationRequestResult.Use(newKey)
					}

				}
			) { storage ->
				storage.saveEncryptionKeypair(
					dataOwnerId,
					newKey,
					true
				)
			},
			newKey
		)
	}

	internal fun authService() =
		AuthenticationMethod.UsingCredentials(
			UsernamePassword(username, password),
		).getAuthProvider(
			RawAnonymousAuthApiImpl(baseUrl, IcureSdk.sharedHttpClient, json = Serialization.json),
			defaultCryptoService,
			null,
			ApiOptions(saltPasswordWithApplicationId = false),
			messageGatewayApi = RawMessageGatewayApi(IcureSdk.sharedHttpClient)
		)


	@OptIn(InternalIcureApi::class)
	private suspend fun initApi(
		cryptoStrategies: CryptoStrategies,
		fillStorage: suspend (storage: IcureStorageFacade) -> Unit
	): IcureSdk =
		IcureSdk.initialize(
			null,
			baseUrl,
			AuthenticationMethod.UsingCredentials(UsernamePassword(username, password)),
			VolatileStorageFacade().also {
				IcureStorageFacade(
					JsonAndBase64KeyStorage(it),
					it,
					DefaultStorageEntryKeysFactory,
					defaultCryptoService,
					false
				).also { fillStorage(it) }
			},
			ApiOptions(
				disableParentKeysInitialisation = false,
				cryptoStrategies = cryptoStrategies
			)
		)

	private suspend fun addInitialKeysToStorage(storage: IcureStorageFacade) {
		storage.saveEncryptionKeypair(
			dataOwnerId,
			keypair,
			true
		)
		parent?.addInitialKeysToStorage(storage)
	}

	fun hierarchy(): List<String> = parent?.hierarchy().orEmpty() + dataOwnerId
}
