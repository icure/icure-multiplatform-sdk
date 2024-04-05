package com.icure.sdk.api

import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.kryptom.utils.toHexString
import com.icure.sdk.api.extended.DataOwnerApi
import com.icure.sdk.api.extended.IcureMaintenanceTaskApi
import com.icure.sdk.api.flavoured.CalendarItemApi
import com.icure.sdk.api.flavoured.CalendarItemApiImpl
import com.icure.sdk.api.flavoured.ContactApi
import com.icure.sdk.api.flavoured.ContactApiImpl
import com.icure.sdk.api.flavoured.HealthcareElementApi
import com.icure.sdk.api.flavoured.HealthcareElementApiImpl
import com.icure.sdk.api.flavoured.MaintenanceTaskApi
import com.icure.sdk.api.flavoured.MaintenanceTaskApiImpl
import com.icure.sdk.api.raw.RawAnonymousAuthApi
import com.icure.sdk.api.raw.RawCalendarItemApi
import com.icure.sdk.api.raw.RawContactApi
import com.icure.sdk.api.raw.RawDataOwnerApi
import com.icure.sdk.api.raw.RawDeviceApi
import com.icure.sdk.api.raw.RawExchangeDataApi
import com.icure.sdk.api.raw.RawExchangeDataMapApi
import com.icure.sdk.api.raw.RawHealthElementApi
import com.icure.sdk.api.raw.RawHealthcarePartyApi
import com.icure.sdk.api.raw.RawMaintenanceTaskApi
import com.icure.sdk.api.raw.RawPatientApi
import com.icure.sdk.api.raw.RawUserApi
import com.icure.sdk.auth.UsernamePassword
import com.icure.sdk.auth.services.JwtAuthService
import com.icure.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.sdk.crypto.CryptoStrategies
import com.icure.sdk.crypto.EntityEncryptionService
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleDelegateShareOptions
import com.icure.sdk.crypto.entities.withTypeInfo
import com.icure.sdk.crypto.impl.AccessControlKeysHeadersProviderImpl
import com.icure.sdk.crypto.impl.BaseExchangeDataManagerImpl
import com.icure.sdk.crypto.impl.BaseExchangeKeysManagerImpl
import com.icure.sdk.crypto.impl.CachedLruExchangeDataManager
import com.icure.sdk.crypto.impl.EntityEncryptionServiceImpl
import com.icure.sdk.crypto.impl.ExchangeDataMapManagerImpl
import com.icure.sdk.crypto.impl.ExchangeKeysManagerImpl
import com.icure.sdk.crypto.impl.FullyCachedExchangeDataManager
import com.icure.sdk.crypto.impl.IcureKeyRecoveryImpl
import com.icure.sdk.crypto.impl.JsonEncryptionServiceImpl
import com.icure.sdk.crypto.impl.LegacyDelegationsDecryptor
import com.icure.sdk.crypto.impl.NoAccessControlKeysHeadersProvider
import com.icure.sdk.crypto.impl.NoopKeyRecoverer
import com.icure.sdk.crypto.impl.SecureDelegationsDecryptorImpl
import com.icure.sdk.crypto.impl.SecureDelegationsEncryptionImpl
import com.icure.sdk.crypto.impl.SecureDelegationsManagerImpl
import com.icure.sdk.crypto.impl.ShamirKeysManagerImpl
import com.icure.sdk.crypto.impl.ShamirSecretSharingService
import com.icure.sdk.crypto.impl.UserEncryptionKeysManagerImpl
import com.icure.sdk.crypto.impl.UserSignatureKeysManagerImpl
import com.icure.sdk.model.DataOwnerWithType
import com.icure.sdk.model.extensions.toStub
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.storage.IcureStorageFacade
import com.icure.sdk.storage.StorageFacade
import com.icure.sdk.storage.impl.DefaultStorageEntryKeysFactory
import com.icure.sdk.storage.impl.JsonAndBase64KeyStorage
import com.icure.sdk.utils.InternalIcureApi

interface IcureApi {
	val calendarItem: CalendarItemApi
	val contact: ContactApi
	val patient: PatientApi
	val healthElement: HealthcareElementApi
	val dataOwner: DataOwnerApi
	val user: UserApi
	val crypto: CryptoApi
	val icureMaintenanceTask: IcureMaintenanceTaskApi
	val maintenanceTask: MaintenanceTaskApi

	companion object {
		@OptIn(InternalIcureApi::class)
		suspend fun initialise(
			baseUrl: String,
			usernamePassword: UsernamePassword,
			baseStorage: StorageFacade,
			useParentKeys: Boolean,
			cryptoStrategies: CryptoStrategies
		): IcureApi {
			val cryptoService = defaultCryptoService
			val apiUrl = baseUrl
			val keysStorage = JsonAndBase64KeyStorage(baseStorage)
			val iCureStorage = IcureStorageFacade(keysStorage, baseStorage, DefaultStorageEntryKeysFactory, cryptoService, false)
			val authApi = RawAnonymousAuthApi(apiUrl)
			val authService = JwtAuthService(authApi, usernamePassword)
			val dataOwnerApi = DataOwnerApi(RawDataOwnerApi(apiUrl, authService))
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
			val baseExchangeKeysManager = BaseExchangeKeysManagerImpl(
				cryptoService,
				dataOwnerApi,
				rawPatientApiNoAccessKeys,
				rawDeviceApi,
				rawHealthcarePartyApi,
			)
			val shamirService = ShamirSecretSharingService(cryptoService.strongRandom)
			val icureKeyRecovery = IcureKeyRecoveryImpl(
				baseExchangeKeysManager,
				baseExchangeDataManager,
				cryptoService,
				shamirService
			)
			val userEncryptionKeys = UserEncryptionKeysManagerImpl.Factory(
				cryptoService,
				cryptoStrategies,
				dataOwnerApi,
				iCureStorage,
				icureKeyRecovery,
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
			val exchangeKeysManager = ExchangeKeysManagerImpl(
				dataOwnerApi,
				baseExchangeKeysManager,
				userEncryptionKeys
			)
			val legacyDelegationsDecryptor = LegacyDelegationsDecryptor(
				cryptoService,
				exchangeKeysManager
			)
			val jsonEncryptionService = JsonEncryptionServiceImpl(cryptoService)
			val entityEncryptionService = EntityEncryptionServiceImpl(
				secureDelegationsManager,
				secureDelegationsDecryptor,
				legacyDelegationsDecryptor,
				dataOwnerApi,
				cryptoService,
				jsonEncryptionService,
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
			ensureDelegationForSelf(dataOwnerApi, entityEncryptionService, patientApi.rawApi, cryptoService)
			val maintenanceTaskApi = MaintenanceTaskApiImpl(
				RawMaintenanceTaskApi(apiUrl, authService, headersProvider),
				entityEncryptionService,
				cryptoService.strongRandom
			)
			return IcureApiImpl(
				calendarItem = CalendarItemApiImpl(
					RawCalendarItemApi(apiUrl, authService, headersProvider),
					entityEncryptionService,
					exchangeDataManager
				),
				contact = ContactApiImpl(
					RawContactApi(apiUrl, authService, headersProvider),
					entityEncryptionService,
					jsonEncryptionService
				),
				patient = patientApi,
				healthElement = HealthcareElementApiImpl(
					RawHealthElementApi(apiUrl, authService, headersProvider),
					entityEncryptionService,
				),
				dataOwner = dataOwnerApi,
				user = UserApi(RawUserApi(apiUrl, authService)),
				crypto = CryptoApi(
					ShamirKeysManagerImpl(
						dataOwnerApi,
						userEncryptionKeys,
						exchangeDataManager,
						cryptoService,
						shamirService
					)
				),
				maintenanceTask = maintenanceTaskApi,
				icureMaintenanceTask = IcureMaintenanceTaskApi(
					exchangeDataManager,
					baseExchangeKeysManager,
					userEncryptionKeys,
					maintenanceTaskApi,
					RawExchangeDataApi(apiUrl, authService),
					dataOwnerApi,
					cryptoService.strongRandom,
				)
			)
		}
	}
}

private class IcureApiImpl(
	override val calendarItem: CalendarItemApi,
	override val contact: ContactApi,
	override val patient: PatientApi,
	override val healthElement: HealthcareElementApi,
	override val dataOwner: DataOwnerApi,
	override val user: UserApi,
	override val crypto: CryptoApi,
	override val icureMaintenanceTask: IcureMaintenanceTaskApi,
	override val maintenanceTask : MaintenanceTaskApi
): IcureApi

@InternalIcureApi
private suspend fun ensureDelegationForSelf(
	dataOwnerApi: DataOwnerApi,
	encryptionService: EntityEncryptionService,
	patientApi: RawPatientApi,
	cryptoService: CryptoService
) {
	val self = dataOwnerApi.getCurrentDataOwner()
	if (self is DataOwnerWithType.PatientDataOwner) {
		val availableSecretIds = encryptionService.secretIdsOf(self.dataOwner.withTypeInfo(), null)
		if (availableSecretIds.isEmpty()) {
			val patientSelf = self.dataOwner.withTypeInfo()
			if (encryptionService.hasEmptyEncryptionMetadata(patientSelf)) {
				val updatedPatient = encryptionService.entityWithInitialisedEncryptedMetadata(
					entity = patientSelf,
					owningEntityId = null,
					owningEntitySecretId = null,
					initialiseEncryptionKey = true,
					initialiseSecretId = true,
					autoDelegations = emptyMap()
				).updatedEntity
				patientApi.modifyPatient(updatedPatient)
			} else {
				encryptionService.simpleShareOrUpdateEncryptedEntityMetadata(
					patientSelf,
					false,
					mapOf(
						self.dataOwner.id to SimpleDelegateShareOptions(
							shareEncryptionKeys = ShareMetadataBehaviour.IfAvailable,
							shareOwningEntityIds = ShareMetadataBehaviour.Never,
							shareSecretIds = setOf(cryptoService.strongRandom.randomUUID()),
							requestedPermissions = RequestedPermission.Root
						)
					),
				) { patientApi.bulkShare(it).successBody() }.updatedEntityOrThrow()
			}
		}
	}
}
