package com.icure.sdk.api

import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.kryptom.utils.toHexString
import com.icure.sdk.api.extended.AnonymousAuthApiImpl
import com.icure.sdk.api.extended.DataOwnerApi
import com.icure.sdk.api.raw.RawContactApi
import com.icure.sdk.api.raw.RawDataownerApi
import com.icure.sdk.api.raw.RawDeviceApi
import com.icure.sdk.api.raw.RawExchangeDataApi
import com.icure.sdk.api.raw.RawExchangeDataMapApi
import com.icure.sdk.api.raw.RawHealthElementApi
import com.icure.sdk.api.raw.RawHealthcarePartyApi
import com.icure.sdk.api.raw.RawPatientApi
import com.icure.sdk.auth.UsernamePassword
import com.icure.sdk.auth.services.JwtAuthService
import com.icure.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.sdk.crypto.EntityEncryptionService
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleDelegateShareOptions
import com.icure.sdk.crypto.impl.AccessControlKeysHeadersProviderImpl
import com.icure.sdk.crypto.impl.BaseExchangeDataManagerImpl
import com.icure.sdk.crypto.impl.BaseExchangeKeysManagerImpl
import com.icure.sdk.crypto.impl.BasicCryptoStrategies
import com.icure.sdk.crypto.impl.CachedLruExchangeDataManager
import com.icure.sdk.crypto.impl.EntityEncryptionServiceImpl
import com.icure.sdk.crypto.impl.ExchangeDataMapManagerImpl
import com.icure.sdk.crypto.impl.ExchangeKeysManagerImpl
import com.icure.sdk.crypto.impl.FullyCachedExchangeDataManager
import com.icure.sdk.crypto.impl.JsonEncryptionServiceImpl
import com.icure.sdk.crypto.impl.LegacyDelegationsDecryptor
import com.icure.sdk.crypto.impl.NoAccessControlKeysHeadersProvider
import com.icure.sdk.crypto.impl.NoopIcureKeyRecovery
import com.icure.sdk.crypto.impl.NoopKeyRecoverer
import com.icure.sdk.crypto.impl.SecureDelegationsDecryptorImpl
import com.icure.sdk.crypto.impl.SecureDelegationsEncryptionImpl
import com.icure.sdk.crypto.impl.SecureDelegationsManagerImpl
import com.icure.sdk.crypto.impl.UserEncryptionKeysManagerImpl
import com.icure.sdk.crypto.impl.UserSignatureKeysManagerImpl
import com.icure.sdk.model.DataOwnerWithType
import com.icure.sdk.model.RequestedPermission
import com.icure.sdk.model.extensions.toStub
import com.icure.sdk.storage.IcureStorageFacade
import com.icure.sdk.storage.StorageFacade
import com.icure.sdk.storage.impl.DefaultStorageEntryKeysFactory
import com.icure.sdk.storage.impl.JsonAndBase64KeyStorage
import com.icure.sdk.utils.InternalIcureApi
import kotlin.js.JsExport

interface IcureApi {
	val contact: ContactApi
	val patient: PatientApi
	val healthElement: HealthElementApi
	val dataOwner: DataOwnerApi

	companion object {
		@OptIn(InternalIcureApi::class)
		suspend fun initialise(
			baseUrl: String,
			usernamePassword: UsernamePassword,
			baseStorage: StorageFacade,
			useParentKeys: Boolean
		): IcureApi {
			val cryptoStrategies = BasicCryptoStrategies
			val cryptoService = defaultCryptoService
			val apiUrl = "$baseUrl"
			val keysStorage = JsonAndBase64KeyStorage(baseStorage)
			val iCureStorage = IcureStorageFacade(keysStorage, baseStorage, DefaultStorageEntryKeysFactory, cryptoService, false)
			val authApi = AnonymousAuthApiImpl(apiUrl)
			val authService = JwtAuthService(authApi, usernamePassword)
			val dataOwnerApi = DataOwnerApi(RawDataownerApi(apiUrl, authService))
			val self = dataOwnerApi.getCurrentDataOwner()
			val selfIsAnonymous = cryptoStrategies.dataOwnerRequiresAnonymousDelegation(self.toStub())
			val rawPatientApiNoAccessKeys = RawPatientApi(apiUrl, authService, null)
			val rawHealthcarePartyApi = RawHealthcarePartyApi(apiUrl, authService)
			val rawDeviceApi = RawDeviceApi(apiUrl, authService)
			val exchangeDataMapManager = ExchangeDataMapManagerImpl(
				RawExchangeDataMapApi(apiUrl, authService),
				cryptoService
			)
			val baseExchangeDataManager = BaseExchangeDataManagerImpl(
				RawExchangeDataApi(apiUrl, authService),
				dataOwnerApi,
				cryptoService,
				selfIsAnonymous
			)
			val userEncryptionKeys = UserEncryptionKeysManagerImpl.Factory(
				cryptoService,
				cryptoStrategies,
				dataOwnerApi,
				iCureStorage,
				NoopIcureKeyRecovery,
				NoopKeyRecoverer,
				useParentKeys,
			).initialise().also { initInfo ->
				initInfo.newKey?.let {
					println("GOT NEW KEY")
					println(cryptoService.rsa.exportPrivateKeyPkcs8(it.key.private).toHexString())
				}
			}.manager
			val userSignatureKeysManager = UserSignatureKeysManagerImpl(
				iCureStorage,
				dataOwnerApi,
				cryptoService
			)
			val exchangeDataManager = if (selfIsAnonymous)
				FullyCachedExchangeDataManager(
					baseExchangeDataManager,
					userEncryptionKeys,
					userSignatureKeysManager,
					cryptoStrategies,
					dataOwnerApi,
					cryptoService,
					useParentKeys,
				).also { it.initialiseCache() }
			else
				CachedLruExchangeDataManager(
					baseExchangeDataManager,
					userEncryptionKeys,
					userSignatureKeysManager,
					cryptoStrategies,
					dataOwnerApi,
					cryptoService,
					useParentKeys,
					100
				)
			val secureDelegationsEncryption = SecureDelegationsEncryptionImpl(
				userEncryptionKeys,
				cryptoService
			)
			val secureDelegationsManager = SecureDelegationsManagerImpl(
				exchangeDataManager,
				exchangeDataMapManager,
				secureDelegationsEncryption,
				userEncryptionKeys,
				cryptoService,
				dataOwnerApi,
				cryptoStrategies,
				selfIsAnonymous
			)
			val secureDelegationsDecryptor = SecureDelegationsDecryptorImpl(
				exchangeDataManager,
				exchangeDataMapManager,
				secureDelegationsEncryption,
				dataOwnerApi
			)
			val baseExchangeKeysManager = BaseExchangeKeysManagerImpl(
				cryptoService,
				dataOwnerApi,
				rawPatientApiNoAccessKeys,
				rawDeviceApi,
				rawHealthcarePartyApi,
			)
			val exchangeKeysManager = ExchangeKeysManagerImpl(
				dataOwnerApi,
				baseExchangeKeysManager,
				userEncryptionKeys
			)
			val legacyDelegationsDecryptor = LegacyDelegationsDecryptor(
				cryptoService,
				exchangeKeysManager
			)
			val entityEncryptionService = EntityEncryptionServiceImpl(
				secureDelegationsManager,
				secureDelegationsDecryptor,
				legacyDelegationsDecryptor,
				dataOwnerApi,
				cryptoService,
				JsonEncryptionServiceImpl(cryptoService),
				useParentKeys,
				false // TODO should be true only for MS
			)
			val headersProvider: AccessControlKeysHeadersProvider =
				if (selfIsAnonymous)
					AccessControlKeysHeadersProviderImpl(exchangeDataManager)
				else
					NoAccessControlKeysHeadersProvider
			val patientApi = PatientApi(
				RawPatientApi(apiUrl, authService, headersProvider),
				entityEncryptionService,
			)
			ensureDelegationForSelf(dataOwnerApi, entityEncryptionService, patientApi, cryptoService)
			return IcureApiImpl(
				ContactApi(
					RawContactApi(apiUrl, authService, headersProvider),
					entityEncryptionService,
				),
				patientApi,
				HealthElementApi(
					RawHealthElementApi(apiUrl, authService, headersProvider),
					entityEncryptionService,
				),
				dataOwnerApi
			)
		}
	}
}

private class IcureApiImpl(
	override val contact: ContactApi,
	override val patient: PatientApi,
	override val healthElement: HealthElementApi,
	override val dataOwner: DataOwnerApi
): IcureApi

@InternalIcureApi
private suspend fun ensureDelegationForSelf(
	dataOwnerApi: DataOwnerApi,
	encryptionService: EntityEncryptionService,
	patientApi: PatientApi,
	cryptoService: CryptoService
) {
	val self = dataOwnerApi.getCurrentDataOwner()
	if (self is DataOwnerWithType.PatientDataOwner) {
		val availableSecretIds = patientApi.getSecretIdsOf(self.dataOwner)
		if (availableSecretIds.isEmpty()) {
			if (encryptionService.hasEmptyEncryptionMetadata(self.dataOwner)) {
				val updatedPatient = encryptionService.entityWithInitialisedEncryptedMetadata(
					entity = self.dataOwner,
					owningEntityId = null,
					owningEntitySecretId = null,
					initialiseEncryptionKey = true,
					initialiseSecretId = true,
					autoDelegations = emptyMap()
				).updatedEntity
				patientApi.tryEncryptAndUpdatePatient(updatedPatient)
			} else {
				encryptionService.simpleShareOrUpdateEncryptedEntityMetadata(
					self.dataOwner,
					false,
					mapOf(
						self.dataOwner.id to SimpleDelegateShareOptions(
							shareEncryptionKeys = ShareMetadataBehaviour.IfAvailable,
							shareOwningEntityIds = ShareMetadataBehaviour.Never,
							shareSecretIds = setOf(cryptoService.strongRandom.randomUUID()),
							requestedPermissions = RequestedPermission.Root
						)
					),
				) { patientApi.rawApi.bulkShare(it).successBody() }.updatedEntityOrThrow()
			}
		}
	}
}
