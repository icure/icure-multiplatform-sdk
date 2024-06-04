package com.icure.sdk

import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.utils.toHexString
import com.icure.sdk.api.ApiConfiguration
import com.icure.sdk.api.ApiConfigurationImpl
import com.icure.sdk.api.CryptoApi
import com.icure.sdk.api.CryptoApiImpl
import com.icure.sdk.api.DeviceApi
import com.icure.sdk.api.DeviceApiImpl
import com.icure.sdk.api.PermissionApi
import com.icure.sdk.api.PermissionApiImpl
import com.icure.sdk.api.RecoveryApi
import com.icure.sdk.api.RecoveryApiImpl
import com.icure.sdk.api.UserApi
import com.icure.sdk.api.UserApiImpl
import com.icure.sdk.api.crypto.ShamirKeysManagerApiImpl
import com.icure.sdk.api.extended.DataOwnerApi
import com.icure.sdk.api.extended.DataOwnerApiImpl
import com.icure.sdk.api.extended.IcureMaintenanceTaskApi
import com.icure.sdk.api.extended.IcureMaintenanceTaskApiImpl
import com.icure.sdk.api.flavoured.AccessLogApi
import com.icure.sdk.api.flavoured.AccessLogApiImpl
import com.icure.sdk.api.flavoured.CalendarItemApi
import com.icure.sdk.api.flavoured.CalendarItemApiImpl
import com.icure.sdk.api.flavoured.ClassificationApi
import com.icure.sdk.api.flavoured.ClassificationApiImpl
import com.icure.sdk.api.flavoured.ContactApi
import com.icure.sdk.api.flavoured.ContactApiImpl
import com.icure.sdk.api.flavoured.DocumentApi
import com.icure.sdk.api.flavoured.DocumentApiImpl
import com.icure.sdk.api.flavoured.FormApi
import com.icure.sdk.api.flavoured.FormApiImpl
import com.icure.sdk.api.flavoured.HealthcareElementApi
import com.icure.sdk.api.flavoured.HealthcareElementApiImpl
import com.icure.sdk.api.flavoured.InvoiceApi
import com.icure.sdk.api.flavoured.InvoiceApiImpl
import com.icure.sdk.api.flavoured.MaintenanceTaskApi
import com.icure.sdk.api.flavoured.MaintenanceTaskApiImpl
import com.icure.sdk.api.flavoured.MessageApi
import com.icure.sdk.api.flavoured.MessageApiImpl
import com.icure.sdk.api.flavoured.PatientApi
import com.icure.sdk.api.flavoured.PatientApiImpl
import com.icure.sdk.api.flavoured.ReceiptApi
import com.icure.sdk.api.flavoured.ReceiptApiImpl
import com.icure.sdk.api.flavoured.TimeTableApi
import com.icure.sdk.api.flavoured.TimeTableApiImpl
import com.icure.sdk.api.flavoured.TopicApi
import com.icure.sdk.api.flavoured.TopicApiImpl
import com.icure.sdk.api.raw.RawPatientApi
import com.icure.sdk.api.raw.impl.RawAccessLogApiImpl
import com.icure.sdk.api.raw.impl.RawAnonymousAuthApiImpl
import com.icure.sdk.api.raw.impl.RawCalendarItemApiImpl
import com.icure.sdk.api.raw.impl.RawClassificationApiImpl
import com.icure.sdk.api.raw.impl.RawContactApiImpl
import com.icure.sdk.api.raw.impl.RawDataOwnerApiImpl
import com.icure.sdk.api.raw.impl.RawDeviceApiImpl
import com.icure.sdk.api.raw.impl.RawDocumentApiImpl
import com.icure.sdk.api.raw.impl.RawEntityReferenceApiImpl
import com.icure.sdk.api.raw.impl.RawExchangeDataApiImpl
import com.icure.sdk.api.raw.impl.RawExchangeDataMapApiImpl
import com.icure.sdk.api.raw.impl.RawFormApiImpl
import com.icure.sdk.api.raw.impl.RawHealthElementApiImpl
import com.icure.sdk.api.raw.impl.RawHealthcarePartyApiImpl
import com.icure.sdk.api.raw.impl.RawInvoiceApiImpl
import com.icure.sdk.api.raw.impl.RawMaintenanceTaskApiImpl
import com.icure.sdk.api.raw.impl.RawMessageApiImpl
import com.icure.sdk.api.raw.impl.RawPatientApiImpl
import com.icure.sdk.api.raw.impl.RawPermissionApiImpl
import com.icure.sdk.api.raw.impl.RawReceiptApiImpl
import com.icure.sdk.api.raw.impl.RawRecoveryDataApiImpl
import com.icure.sdk.api.raw.impl.RawSecureDelegationKeyMapApiImpl
import com.icure.sdk.api.raw.impl.RawTimeTableApiImpl
import com.icure.sdk.api.raw.impl.RawTopicApiImpl
import com.icure.sdk.api.raw.impl.RawUserApiImpl
import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.sdk.crypto.CryptoStrategies
import com.icure.sdk.crypto.EntityEncryptionService
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleDelegateShareOptionsImpl
import com.icure.sdk.crypto.entities.withTypeInfo
import com.icure.sdk.crypto.impl.AccessControlKeysHeadersProviderImpl
import com.icure.sdk.crypto.impl.BaseExchangeDataManagerImpl
import com.icure.sdk.crypto.impl.BaseExchangeKeysManagerImpl
import com.icure.sdk.crypto.impl.CachedLruExchangeDataManager
import com.icure.sdk.crypto.impl.DelegationsDeAnonymizationImpl
import com.icure.sdk.crypto.impl.EntityEncryptionServiceImpl
import com.icure.sdk.crypto.impl.ExchangeDataMapManagerImpl
import com.icure.sdk.crypto.impl.ExchangeKeysManagerImpl
import com.icure.sdk.crypto.impl.FullyCachedExchangeDataManager
import com.icure.sdk.crypto.impl.IcureKeyRecoveryImpl
import com.icure.sdk.crypto.impl.InternalCryptoApiImpl
import com.icure.sdk.crypto.impl.JsonEncryptionServiceImpl
import com.icure.sdk.crypto.impl.KeyPairRecovererImpl
import com.icure.sdk.crypto.impl.LegacyDelegationsDecryptor
import com.icure.sdk.crypto.impl.NoAccessControlKeysHeadersProvider
import com.icure.sdk.crypto.impl.RecoveryDataEncryptionImpl
import com.icure.sdk.crypto.impl.SecureDelegationsDecryptorImpl
import com.icure.sdk.crypto.impl.SecureDelegationsEncryptionImpl
import com.icure.sdk.crypto.impl.SecureDelegationsManagerImpl
import com.icure.sdk.crypto.impl.ShamirSecretSharingService
import com.icure.sdk.crypto.impl.TransferKeysManagerImpl
import com.icure.sdk.crypto.impl.UserEncryptionKeysManagerImpl
import com.icure.sdk.crypto.impl.UserSignatureKeysManagerImpl
import com.icure.sdk.model.DataOwnerWithType
import com.icure.sdk.model.extensions.toStub
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.options.ApiOptions
import com.icure.sdk.options.AuthenticationMethod
import com.icure.sdk.options.EntitiesEncryptedFieldsManifests
import com.icure.sdk.options.getAuthService
import com.icure.sdk.storage.IcureStorageFacade
import com.icure.sdk.storage.StorageFacade
import com.icure.sdk.storage.impl.DefaultStorageEntryKeysFactory
import com.icure.sdk.storage.impl.JsonAndBase64KeyStorage
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import com.icure.sdk.utils.newPlatformHttpClient
import com.icure.sdk.websocket.WebSocketAuthProvider
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.websocket.WebSockets
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

interface IcureSdk {
	val accessLog: AccessLogApi
	val calendarItem: CalendarItemApi
	val classification: ClassificationApi
	val contact: ContactApi
	val device: DeviceApi
	val document: DocumentApi
	val form: FormApi
	val healthcareElement: HealthcareElementApi
	val invoice: InvoiceApi
	val maintenanceTask: MaintenanceTaskApi
	val message: MessageApi
	val patient: PatientApi
	val permission: PermissionApi
	val receipt: ReceiptApi
	val timeTable: TimeTableApi
	val topic: TopicApi
	val crypto: CryptoApi
	val dataOwner: DataOwnerApi
	val user: UserApi
	val icureMaintenanceTask: IcureMaintenanceTaskApi
	val recovery: RecoveryApi

	companion object {
		/**
		 * A shared http client to use as the default across all instances of iCure.
		 * Initialised only when needed.
		 * Previous versions of the icure SDK (in different languages) did not need explicit disposal, but this is
		 * necessary in the multiplatform sdk. The use of this shared client allows to minimise the resource leaking
		 * when creating multiple instances of the iCure API without proper disposal of the client.
		 */
		internal val sharedHttpClient by lazy {
			newPlatformHttpClient {
				install(ContentNegotiation) {
					json(json = Serialization.json)
				}
				install(HttpTimeout)
				install(WebSockets)
			}
		}

		/**
		 * Close the default http client used for api instances. You should call this method if you want to gracefully
		 * shut down your application, and you have created at least one instance of the iCure API without providing
		 * your own instance of http client.
		 * Not closing the client will prevent the application from terminating (even if the main method terminated).
		 *
		 * Note: closing the client will cause any existing and future api instances that are using the default client
		 * to become unusable, as there is a shared default client used across all instances of the Api. Call this
		 * method only when you want to shut down the application.
		 */
		fun closeSharedClient() {
			sharedHttpClient.close()
		}

		@OptIn(InternalIcureApi::class)
		suspend fun initialise(
			baseUrl: String,
			authenticationMethod: AuthenticationMethod,
			baseStorage: StorageFacade,
			cryptoStrategies: CryptoStrategies,
			options: ApiOptions = ApiOptions()
		): IcureSdk {
			val client = options.httpClient ?: sharedHttpClient
			val json = options.httpClientJson ?: Serialization.json
			val cryptoService = options.cryptoService
			val apiUrl = baseUrl
			val keysStorage = JsonAndBase64KeyStorage(baseStorage)
			val iCureStorage =
				IcureStorageFacade(keysStorage, baseStorage, DefaultStorageEntryKeysFactory, cryptoService, false)
			val authApi = RawAnonymousAuthApiImpl(apiUrl, client, json = json)
			val authService = authenticationMethod.getAuthService(authApi)
			val dataOwnerApi = DataOwnerApiImpl(RawDataOwnerApiImpl(apiUrl, authService, client, json = json))
			val self = dataOwnerApi.getCurrentDataOwner()
			val selfIsAnonymous = cryptoStrategies.dataOwnerRequiresAnonymousDelegation(self.toStub())
			val rawPatientApiNoAccessKeys = RawPatientApiImpl(apiUrl, authService, null, client, json = json)
			val rawHealthcarePartyApi = RawHealthcarePartyApiImpl(apiUrl, authService, client, json = json)
			val rawDeviceApi = RawDeviceApiImpl(apiUrl, authService, client, json = json)
			val exchangeDataMapManager = ExchangeDataMapManagerImpl(
				RawExchangeDataMapApiImpl(apiUrl, authService, client, json = json),
				cryptoService
			)
			val baseExchangeDataManager = BaseExchangeDataManagerImpl(
				RawExchangeDataApiImpl(apiUrl, authService, client, json = json),
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
			val recoveryDataEncryption = RecoveryDataEncryptionImpl(
				cryptoService,
				RawRecoveryDataApiImpl(apiUrl, authService, client, json = json)
			)
			val userEncryptionKeys = UserEncryptionKeysManagerImpl.Factory(
				cryptoService,
				cryptoStrategies,
				dataOwnerApi,
				iCureStorage,
				icureKeyRecovery,
				KeyPairRecovererImpl(recoveryDataEncryption),
				!options.disableParentKeysInitialisation,
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
					!options.disableParentKeysInitialisation,
				).also { it.initialiseCache() }
			else
				CachedLruExchangeDataManager(
					baseExchangeDataManager,
					userEncryptionKeys,
					userSignatureKeysManager,
					cryptoStrategies,
					dataOwnerApi,
					cryptoService,
					!options.disableParentKeysInitialisation,
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
				!options.disableParentKeysInitialisation,
				false // TODO should be true only for MS
			)
			val headersProvider: AccessControlKeysHeadersProvider =
				if (selfIsAnonymous)
					AccessControlKeysHeadersProviderImpl(exchangeDataManager)
				else
					NoAccessControlKeysHeadersProvider
			val crypto = InternalCryptoApiImpl(
				entityEncryptionService,
				cryptoService,
				exchangeDataManager,
				exchangeKeysManager,
				jsonEncryptionService,
				DelegationsDeAnonymizationImpl(
					secureDelegationsDecryptor,
					RawSecureDelegationKeyMapApiImpl(apiUrl, authService, client, json = json),
					headersProvider,
					entityEncryptionService,
					dataOwnerApi,
					cryptoService
				),
				dataOwnerApi,
				userEncryptionKeys,
				recoveryDataEncryption
			)
			val updatedSelf =
				ensureDelegationForSelf(dataOwnerApi, entityEncryptionService, rawPatientApiNoAccessKeys, cryptoService)
			if (options.createTransferKeys) {
				TransferKeysManagerImpl(
					userEncryptionKeys,
					iCureStorage,
					cryptoService,
					exchangeDataManager,
					dataOwnerApi
				).updateTransferKeys(updatedSelf.toStub())
			}

			val webSocketAuthProvider = WebSocketAuthProvider.fromAuthServiceIfSupported(authService)

			val manifests = EntitiesEncryptedFieldsManifests.fromEncryptedFields(options.encryptedFields)
			val config = ApiConfigurationImpl(
				apiUrl,
				client,
				webSocketAuthProvider,
				!selfIsAnonymous,
				crypto,
				manifests
			)
			return IcureApiImpl(
				authService,
				headersProvider,
				json,
				config
			)
		}
	}
}

@OptIn(InternalIcureApi::class)
private class IcureApiImpl(
	private val authService: AuthService,
	private val headersProvider: AccessControlKeysHeadersProvider,
	private val json: Json,
	private val config: ApiConfiguration,
): IcureSdk {
	private val apiUrl get() = config.apiUrl
	private val client get() = config.httpClient

	private val rawDataOwnerApi by lazy { RawDataOwnerApiImpl(apiUrl, authService, client, json = json) }
	private val rawCalendarItemApi by lazy { RawCalendarItemApiImpl(apiUrl, authService, headersProvider, client, json = json) }

	override val calendarItem: CalendarItemApi by lazy {
		CalendarItemApiImpl(
			rawCalendarItemApi,
			rawDataOwnerApi,
			config
		)
	}

	private val rawContactApi by lazy { RawContactApiImpl(apiUrl, authService, headersProvider, client, json = json) }
	private val rawHealthcarePartyApi by lazy { RawHealthcarePartyApiImpl(apiUrl, authService, client, json = json) }

	override val contact: ContactApi by lazy {
		ContactApiImpl(
			rawContactApi,
			config
		)
	}

	private val rawPatientApi by lazy { RawPatientApiImpl(apiUrl, authService, headersProvider, client, json = json) }

	override val patient: PatientApi by lazy {
		PatientApiImpl(
			rawPatientApi,
			rawHealthcarePartyApi,
			rawHealthcareElementApi,
			rawFormApi,
			rawContactApi,
			rawInvoiceApi,
			rawCalendarItemApi,
			rawClassificationApi,
			config
		)
	}

	private val rawHealthcareElementApi by lazy { RawHealthElementApiImpl(apiUrl, authService, headersProvider, client, json = json) }

	override val healthcareElement: HealthcareElementApi by lazy {
		HealthcareElementApiImpl(
			rawHealthcareElementApi,
			config
		)
	}

	override val dataOwner: DataOwnerApi get() = config.crypto.dataOwnerApi

	override val user: UserApi by lazy {
		UserApiImpl(
			RawUserApiImpl(apiUrl, authService, client, json = json),
			RawPermissionApiImpl(apiUrl, authService, client, json = json)
		)
	}
	override val crypto: CryptoApi by lazy {
		CryptoApiImpl(
			ShamirKeysManagerApiImpl(
				config.crypto.dataOwnerApi,
				config.crypto.userEncryptionKeysManager,
				config.crypto.exchangeDataManager,
				config.crypto.primitives,
				ShamirSecretSharingService(config.crypto.primitives.strongRandom)
			),
			config.crypto
		)
	}

	private val rawMaintenanceTaskApi by lazy { RawMaintenanceTaskApiImpl(apiUrl, authService, headersProvider, client, json = json) }

	override val maintenanceTask: MaintenanceTaskApi by lazy {
		MaintenanceTaskApiImpl(
			rawMaintenanceTaskApi,
			config
		)
	}

	override val icureMaintenanceTask: IcureMaintenanceTaskApi by lazy {
		IcureMaintenanceTaskApiImpl(
			config.crypto.exchangeDataManager,
			config.crypto.exchangeKeysManager.base,
			config.crypto.userEncryptionKeysManager,
			maintenanceTask,
			dataOwner,
			config.crypto.primitives.strongRandom,
		)
	}

	private val rawAccessLogApi by lazy { RawAccessLogApiImpl(apiUrl, authService, headersProvider, client, json = json) }

	override val accessLog: AccessLogApi by lazy {
		AccessLogApiImpl(
			rawAccessLogApi,
			config
		)
	}

	private val rawMessageApi by lazy { RawMessageApiImpl(apiUrl, authService, headersProvider, client, json = json) }

	override val message: MessageApi by lazy {
		MessageApiImpl(
			rawMessageApi,
			config
		)
	}

	private val rawTopicApi by lazy { RawTopicApiImpl(apiUrl, authService, headersProvider, client, json = json) }

	override val topic: TopicApi by lazy {
		TopicApiImpl(
			rawTopicApi,
			config
		)
	}

	private val rawDocumentApi by lazy { RawDocumentApiImpl(apiUrl, authService, headersProvider, client, json = json) }

	override val document: DocumentApi by lazy {
		DocumentApiImpl(
			rawDocumentApi,
			config
		)
	}

	private val rawTimeTableApi by lazy { RawTimeTableApiImpl(apiUrl, authService, headersProvider, client, json = json) }

	override val timeTable: TimeTableApi by lazy {
		TimeTableApiImpl(
			rawTimeTableApi,
			config
		)
	}

	private val rawClassificationApi by lazy { RawClassificationApiImpl(apiUrl, authService, headersProvider, client, json = json) }

	override val classification: ClassificationApi by lazy {
		ClassificationApiImpl(
			rawClassificationApi,
			config
		)
	}

	private val rawFormApi by lazy { RawFormApiImpl(apiUrl, authService, headersProvider, client, json = json) }

	override val form: FormApi by lazy {
		FormApiImpl(
			rawFormApi,
			config
		)
	}

	private val rawInvoiceApi by lazy { RawInvoiceApiImpl(apiUrl, authService, headersProvider, client, json = json) }
	private val rawEntityReferenceApi by lazy { RawEntityReferenceApiImpl(apiUrl, authService, client, json = json) }

	override val invoice: InvoiceApi by lazy {
		InvoiceApiImpl(
			rawInvoiceApi,
			rawEntityReferenceApi,
			config
		)
	}

	private val rawReceiptApi by lazy { RawReceiptApiImpl(apiUrl, authService, headersProvider, client, json = json) }

	override val receipt: ReceiptApi by lazy {
		ReceiptApiImpl(
			rawReceiptApi,
			config
		)
	}

	override val recovery: RecoveryApi by lazy {
		RecoveryApiImpl(config.crypto)
	}

	override val device: DeviceApi by lazy {
		DeviceApiImpl(RawDeviceApiImpl(apiUrl, authService, client, json = json))
	}

	override val permission: PermissionApi by lazy {
		PermissionApiImpl(RawPermissionApiImpl(apiUrl, authService, client, json = json))
	}
}

@InternalIcureApi
private suspend fun ensureDelegationForSelf(
	dataOwnerApi: DataOwnerApi,
	encryptionService: EntityEncryptionService,
	patientApi: RawPatientApi,
	cryptoService: CryptoService
): DataOwnerWithType {
	val self = dataOwnerApi.getCurrentDataOwner()
	return if (self is DataOwnerWithType.PatientDataOwner) {
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
				return DataOwnerWithType.PatientDataOwner(patientApi.modifyPatient(updatedPatient).successBody())
			} else {
				encryptionService.simpleShareOrUpdateEncryptedEntityMetadata(
					patientSelf,
					false,
					mapOf(
						self.dataOwner.id to SimpleDelegateShareOptionsImpl(
							shareEncryptionKey = ShareMetadataBehaviour.IfAvailable,
							shareOwningEntityIds = ShareMetadataBehaviour.Never,
							shareSecretIds = setOf(cryptoService.strongRandom.randomUUID()),
							requestedPermissions = RequestedPermission.Root
						)
					),
				) { patientApi.bulkShare(it).successBody() }.updatedEntityOrThrow().let { updatedPatient ->
					DataOwnerWithType.PatientDataOwner(updatedPatient)
				}
			}
		} else self
	} else self
}

