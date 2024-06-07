package com.icure.sdk.test

import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.kryptom.utils.toHexString
import com.icure.sdk.IcureSdk
import com.icure.sdk.api.raw.impl.RawAnonymousAuthApiImpl
import com.icure.sdk.auth.UsernamePassword
import com.icure.sdk.auth.services.JwtAuthService
import com.icure.sdk.crypto.CryptoStrategies
import com.icure.sdk.crypto.impl.BasicCryptoStrategies
import com.icure.sdk.model.DataOwnerWithType
import com.icure.sdk.model.specializations.SpkiHexString
import com.icure.sdk.options.ApiOptions
import com.icure.sdk.options.AuthenticationMethod
import com.icure.sdk.storage.IcureStorageFacade
import com.icure.sdk.storage.impl.DefaultStorageEntryKeysFactory
import com.icure.sdk.storage.impl.JsonAndBase64KeyStorage
import com.icure.sdk.storage.impl.VolatileStorageFacade
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import io.kotest.common.runBlocking

@OptIn(InternalIcureApi::class)
data class DataOwnerDetails(
	val dataOwnerId: String,
	val username: String,
	val password: String,
	val keypair: RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>,
	val parent: DataOwnerDetails?
) {
	val publicKeySpki = runBlocking { SpkiHexString(defaultCryptoService.rsa.exportPublicKeySpki(keypair.public).toHexString()) }

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

	fun authService() =
		JwtAuthService(RawAnonymousAuthApiImpl(baseUrl, IcureSdk.sharedHttpClient, json = Serialization.json), UsernamePassword(username, password))

	@OptIn(InternalIcureApi::class)
	private suspend fun initApi(
		cryptoStrategies: CryptoStrategies,
		fillStorage: suspend (storage: IcureStorageFacade) -> Unit
	): IcureSdk =
		IcureSdk.initialise(
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
			cryptoStrategies,
			ApiOptions(
				disableParentKeysInitialisation = false
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
