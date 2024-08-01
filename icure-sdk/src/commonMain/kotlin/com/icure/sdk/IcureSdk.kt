package com.icure.sdk

import com.icure.kryptom.crypto.CryptoService
import com.icure.sdk.api.ApplicationSettingsApi
import com.icure.sdk.api.ApplicationSettingsApiImpl
import com.icure.sdk.api.CodeApi
import com.icure.sdk.api.CodeApiImpl
import com.icure.sdk.api.CryptoApi
import com.icure.sdk.api.CryptoApiImpl
import com.icure.sdk.api.DeviceApi
import com.icure.sdk.api.DeviceApiImpl
import com.icure.sdk.api.DocumentTemplateApi
import com.icure.sdk.api.DocumentTemplateApiImpl
import com.icure.sdk.api.EntityReferenceApi
import com.icure.sdk.api.EntityReferenceApiImpl
import com.icure.sdk.api.EntityTemplateApi
import com.icure.sdk.api.EntityTemplateApiImpl
import com.icure.sdk.api.FrontEndMigrationApi
import com.icure.sdk.api.FrontEndMigrationApiImpl
import com.icure.sdk.api.GroupApi
import com.icure.sdk.api.GroupApiImpl
import com.icure.sdk.api.HealthcarePartyApi
import com.icure.sdk.api.HealthcarePartyApiImpl
import com.icure.sdk.api.ICureApi
import com.icure.sdk.api.ICureApiImpl
import com.icure.sdk.api.InsuranceApi
import com.icure.sdk.api.InsuranceApiImpl
import com.icure.sdk.api.KeywordApi
import com.icure.sdk.api.KeywordApiImpl
import com.icure.sdk.api.PermissionApi
import com.icure.sdk.api.PermissionApiImpl
import com.icure.sdk.api.PlaceApi
import com.icure.sdk.api.PlaceApiImpl
import com.icure.sdk.api.RecoveryApi
import com.icure.sdk.api.RecoveryApiImpl
import com.icure.sdk.api.RoleApi
import com.icure.sdk.api.RoleApiImpl
import com.icure.sdk.api.TarificationApi
import com.icure.sdk.api.TarificationApiImpl
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
import com.icure.sdk.api.flavoured.HealthElementApi
import com.icure.sdk.api.flavoured.HealthElementApiImpl
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
import com.icure.sdk.api.raw.impl.RawApplicationSettingsApiImpl
import com.icure.sdk.api.raw.impl.RawCalendarItemApiImpl
import com.icure.sdk.api.raw.impl.RawClassificationApiImpl
import com.icure.sdk.api.raw.impl.RawCodeApiImpl
import com.icure.sdk.api.raw.impl.RawContactApiImpl
import com.icure.sdk.api.raw.impl.RawDataOwnerApiImpl
import com.icure.sdk.api.raw.impl.RawDeviceApiImpl
import com.icure.sdk.api.raw.impl.RawDocumentApiImpl
import com.icure.sdk.api.raw.impl.RawDocumentTemplateApiImpl
import com.icure.sdk.api.raw.impl.RawEntityReferenceApiImpl
import com.icure.sdk.api.raw.impl.RawEntityTemplateApiImpl
import com.icure.sdk.api.raw.impl.RawExchangeDataApiImpl
import com.icure.sdk.api.raw.impl.RawExchangeDataMapApiImpl
import com.icure.sdk.api.raw.impl.RawFormApiImpl
import com.icure.sdk.api.raw.impl.RawFrontEndMigrationApiImpl
import com.icure.sdk.api.raw.impl.RawGroupApiImpl
import com.icure.sdk.api.raw.impl.RawHealthElementApiImpl
import com.icure.sdk.api.raw.impl.RawHealthcarePartyApiImpl
import com.icure.sdk.api.raw.impl.RawICureApiImpl
import com.icure.sdk.api.raw.impl.RawInsuranceApiImpl
import com.icure.sdk.api.raw.impl.RawInvoiceApiImpl
import com.icure.sdk.api.raw.impl.RawKeywordApiImpl
import com.icure.sdk.api.raw.impl.RawMaintenanceTaskApiImpl
import com.icure.sdk.api.raw.impl.RawMessageApiImpl
import com.icure.sdk.api.raw.impl.RawPatientApiImpl
import com.icure.sdk.api.raw.impl.RawPermissionApiImpl
import com.icure.sdk.api.raw.impl.RawPlaceApiImpl
import com.icure.sdk.api.raw.impl.RawReceiptApiImpl
import com.icure.sdk.api.raw.impl.RawRecoveryDataApiImpl
import com.icure.sdk.api.raw.impl.RawRoleApiImpl
import com.icure.sdk.api.raw.impl.RawSecureDelegationKeyMapApiImpl
import com.icure.sdk.api.raw.impl.RawTarificationApiImpl
import com.icure.sdk.api.raw.impl.RawTimeTableApiImpl
import com.icure.sdk.api.raw.impl.RawTopicApiImpl
import com.icure.sdk.api.raw.impl.RawUserApiImpl
import com.icure.sdk.auth.services.AuthProvider
import com.icure.sdk.auth.services.JwtBasedAuthProvider
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
import com.icure.sdk.options.ApiConfiguration
import com.icure.sdk.options.ApiConfigurationImpl
import com.icure.sdk.options.ApiOptions
import com.icure.sdk.options.AuthenticationMethod
import com.icure.sdk.options.EntitiesEncryptedFieldsManifests
import com.icure.sdk.options.getAuthProviderInGroup
import com.icure.sdk.storage.IcureStorageFacade
import com.icure.sdk.storage.StorageFacade
import com.icure.sdk.storage.impl.DefaultStorageEntryKeysFactory
import com.icure.sdk.storage.impl.JsonAndBase64KeyStorage
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import com.icure.sdk.utils.newPlatformHttpClient
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.websocket.WebSockets
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

interface IcureSdk : IcureApis {
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

		/**
		 * Initialise a new instance of the icure sdk for a specific user.
		 *
		 * @param applicationId a string to uniquely identify your iCure application.
		 * @param baseUrl the url of the iCure backend to use
		 * @param authenticationMethod specifies how the sdk should authenticate.
		 * @param baseStorage an implementation of the [StorageFacade], used for persistent storage of various
		 * information including the user keys if [ApiOptions.keyStorage] is not provided.
		 * @param cryptoStrategies implementation of crypto strategies for your application
		 * @param options optional parameters for the initialization of the sdk.
		 */
		@OptIn(InternalIcureApi::class)
		suspend fun initialise(
			applicationId: String?,
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
			val keysStorage = options.keyStorage ?: JsonAndBase64KeyStorage(baseStorage)
			val iCureStorage =
				IcureStorageFacade(keysStorage, baseStorage, DefaultStorageEntryKeysFactory, cryptoService, false)
			val authProvider = authenticationMethod.getAuthProviderInGroup(
				apiUrl,
				client,
				cryptoService,
				applicationId,
				options,
				options.groupSelector
			)
			return IcureApiImpl(
				authProvider,
				json,
				initializeApiCrypto(
					apiUrl,
					authProvider,
					client,
					json,
					cryptoStrategies,
					cryptoService,
					iCureStorage,
					options,
				),
				options
			)
		}
	}

	/**
	 * Get a new sdk using the same configurations and user authentication methods but for a different group.
	 * To use this method, the authentication method provided at initialization of this sdk must be valid also for the
	 * new group.
	 *
	 * Note that the switched sdk will reuse components like the http client.
	 * Don't close the client of this sdk while you are using the new sdk.
	 *
	 * @param groupId the id of the new group to switch to
	 * @return a new sdk for executing requests in the provided group
	 */
	suspend fun switchGroup(groupId: String): IcureSdk
}

@InternalIcureApi
private suspend fun initializeApiCrypto(
	apiUrl: String,
	authProvider: AuthProvider,
	client: HttpClient,
	json: Json,
	cryptoStrategies: CryptoStrategies,
	cryptoService: CryptoService,
	iCureStorage: IcureStorageFacade,
	options: ApiOptions
): ApiConfiguration {
	val dataOwnerApi = DataOwnerApiImpl(RawDataOwnerApiImpl(apiUrl, authProvider, client, json = json))
	val self = dataOwnerApi.getCurrentDataOwner()
	val selfIsAnonymous = cryptoStrategies.dataOwnerRequiresAnonymousDelegation(self.toStub())
	val rawPatientApiNoAccessKeys = RawPatientApiImpl(apiUrl, authProvider, null, client, json = json)
	val rawHealthcarePartyApi = RawHealthcarePartyApiImpl(apiUrl, authProvider, client, json = json)
	val rawDeviceApi = RawDeviceApiImpl(apiUrl, authProvider, client, json = json)
	val exchangeDataMapManager = ExchangeDataMapManagerImpl(
		RawExchangeDataMapApiImpl(apiUrl, authProvider, client, json = json),
		cryptoService
	)
	val baseExchangeDataManager = BaseExchangeDataManagerImpl(
		RawExchangeDataApiImpl(apiUrl, authProvider, client, json = json),
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
		RawRecoveryDataApiImpl(apiUrl, authProvider, client, json = json)
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
		initInfo.newKey
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
		options.autoCreateEncryptionKeyForExistingLegacyData
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
			RawSecureDelegationKeyMapApiImpl(apiUrl, authProvider, client, json = json),
			headersProvider,
			entityEncryptionService,
			dataOwnerApi,
			cryptoService
		),
		dataOwnerApi,
		userEncryptionKeys,
		recoveryDataEncryption,
		headersProvider,
		cryptoStrategies
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

	val manifests = EntitiesEncryptedFieldsManifests.fromEncryptedFields(options.encryptedFields)
	return ApiConfigurationImpl(
		apiUrl,
		client,
		json,
		if (authProvider is JwtBasedAuthProvider) authProvider else null,
		!selfIsAnonymous,
		crypto,
		manifests,
		iCureStorage
	)
}

@OptIn(InternalIcureApi::class)
private class IcureApiImpl(
	private val authProvider: AuthProvider,
	private val httpClientJson: Json,
	private val config: ApiConfiguration,
	private val options: ApiOptions
): IcureSdk {
	private val apiUrl get() = config.apiUrl
	private val client get() = config.httpClient

	private val rawDataOwnerApi by lazy { RawDataOwnerApiImpl(apiUrl, authProvider, client, json = httpClientJson) }
	private val rawCalendarItemApi by lazy { RawCalendarItemApiImpl(apiUrl, authProvider, config.crypto.headersProvider, client, json = httpClientJson) }

	override val calendarItem: CalendarItemApi by lazy {
		CalendarItemApiImpl(
			rawCalendarItemApi,
			rawDataOwnerApi,
			config
		)
	}

	private val rawContactApi by lazy { RawContactApiImpl(apiUrl, authProvider, config.crypto.headersProvider, client, json = httpClientJson) }
	private val rawHealthcarePartyApi by lazy { RawHealthcarePartyApiImpl(apiUrl, authProvider, client, json = httpClientJson) }

	override val contact: ContactApi by lazy {
		ContactApiImpl(
			rawContactApi,
			config
		)
	}

	private val rawPatientApi by lazy { RawPatientApiImpl(apiUrl, authProvider, config.crypto.headersProvider, client, json = httpClientJson) }

	override val patient: PatientApi by lazy {
		PatientApiImpl(
			rawPatientApi,
			rawHealthcarePartyApi,
			rawHealthElementApi,
			rawFormApi,
			rawContactApi,
			rawInvoiceApi,
			rawCalendarItemApi,
			rawClassificationApi,
			config
		)
	}

	private val rawHealthElementApi by lazy { RawHealthElementApiImpl(apiUrl, authProvider, config.crypto.headersProvider, client, json = httpClientJson) }

	override val healthElement: HealthElementApi by lazy {
		HealthElementApiImpl(
			rawHealthElementApi,
			config
		)
	}

	override val dataOwner: DataOwnerApi get() = config.crypto.dataOwnerApi

	override val user: UserApi by lazy {
		UserApiImpl(
			RawUserApiImpl(apiUrl, authProvider, client, json = httpClientJson),
			RawPermissionApiImpl(apiUrl, authProvider, client, json = httpClientJson)
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

	private val rawMaintenanceTaskApi by lazy { RawMaintenanceTaskApiImpl(apiUrl, authProvider, config.crypto.headersProvider, client, json = httpClientJson) }

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

	private val rawAccessLogApi by lazy { RawAccessLogApiImpl(apiUrl, authProvider, config.crypto.headersProvider, client, json = httpClientJson) }

	override val accessLog: AccessLogApi by lazy {
		AccessLogApiImpl(
			rawAccessLogApi,
			config
		)
	}

	private val rawMessageApi by lazy { RawMessageApiImpl(apiUrl, authProvider, config.crypto.headersProvider, client, json = httpClientJson) }

	override val message: MessageApi by lazy {
		MessageApiImpl(
			rawMessageApi,
			config
		)
	}

	private val rawTopicApi by lazy { RawTopicApiImpl(apiUrl, authProvider, config.crypto.headersProvider, client, json = httpClientJson) }

	override val topic: TopicApi by lazy {
		TopicApiImpl(
			rawTopicApi,
			config
		)
	}

	private val rawDocumentApi by lazy { RawDocumentApiImpl(apiUrl, authProvider, config.crypto.headersProvider, client, json = httpClientJson) }

	override val document: DocumentApi by lazy {
		DocumentApiImpl(
			rawDocumentApi,
			config
		)
	}

	private val rawTimeTableApi by lazy { RawTimeTableApiImpl(apiUrl, authProvider, config.crypto.headersProvider, client, json = httpClientJson) }

	override val timeTable: TimeTableApi by lazy {
		TimeTableApiImpl(
			rawTimeTableApi,
			config
		)
	}

	private val rawClassificationApi by lazy { RawClassificationApiImpl(apiUrl, authProvider, config.crypto.headersProvider, client, json = httpClientJson) }

	override val classification: ClassificationApi by lazy {
		ClassificationApiImpl(
			rawClassificationApi,
			config
		)
	}

	private val rawFormApi by lazy { RawFormApiImpl(apiUrl, authProvider, config.crypto.headersProvider, client, json = httpClientJson) }

	override val form: FormApi by lazy {
		FormApiImpl(
			rawFormApi,
			config
		)
	}

	private val rawInvoiceApi by lazy { RawInvoiceApiImpl(apiUrl, authProvider, config.crypto.headersProvider, client, json = httpClientJson) }
	private val rawEntityReferenceApi by lazy { RawEntityReferenceApiImpl(apiUrl, authProvider, client, json = httpClientJson) }

	override val invoice: InvoiceApi by lazy {
		InvoiceApiImpl(
			rawInvoiceApi,
			rawEntityReferenceApi,
			config
		)
	}

	private val rawReceiptApi by lazy { RawReceiptApiImpl(apiUrl, authProvider, config.crypto.headersProvider, client, json = httpClientJson) }

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
		DeviceApiImpl(RawDeviceApiImpl(apiUrl, authProvider, client, json = httpClientJson))
	}

	override val permission: PermissionApi by lazy {
		PermissionApiImpl(RawPermissionApiImpl(apiUrl, authProvider, client, json = httpClientJson))
	}

	override val applicationSettings: ApplicationSettingsApi by lazy {
		ApplicationSettingsApiImpl(RawApplicationSettingsApiImpl(apiUrl, authProvider, client, json = httpClientJson))
	}
	override val code: CodeApi by lazy {
		CodeApiImpl(RawCodeApiImpl(apiUrl, authProvider, client, json = httpClientJson))
	}
	override val documentTemplate: DocumentTemplateApi by lazy {
		DocumentTemplateApiImpl(apiUrl, RawDocumentTemplateApiImpl(apiUrl, authProvider, client, json = httpClientJson))
	}
	override val entityReference: EntityReferenceApi by lazy {
		EntityReferenceApiImpl(RawEntityReferenceApiImpl(apiUrl, authProvider, client, json = httpClientJson))
	}
	override val entityTemplate: EntityTemplateApi by lazy {
		EntityTemplateApiImpl(RawEntityTemplateApiImpl(apiUrl, authProvider, client, json = httpClientJson))
	}
	override val frontEndMigration: FrontEndMigrationApi by lazy {
		FrontEndMigrationApiImpl(RawFrontEndMigrationApiImpl(apiUrl, authProvider, client, json = httpClientJson))
	}
	override val group: GroupApi by lazy {
		GroupApiImpl(RawGroupApiImpl(apiUrl, authProvider, client, json = httpClientJson))
	}
	override val healthcareParty: HealthcarePartyApi by lazy {
		HealthcarePartyApiImpl(RawHealthcarePartyApiImpl(apiUrl, authProvider, client, json = httpClientJson))
	}
	override val iCure: ICureApi by lazy {
		ICureApiImpl(RawICureApiImpl(apiUrl, authProvider, client, json = httpClientJson))
	}
	override val insurance: InsuranceApi by lazy {
		InsuranceApiImpl(RawInsuranceApiImpl(apiUrl, authProvider, client, json = httpClientJson))
	}
	override val keyword: KeywordApi by lazy {
		KeywordApiImpl(RawKeywordApiImpl(apiUrl, authProvider, client, json = httpClientJson))
	}
	override val place: PlaceApi by lazy {
		PlaceApiImpl(RawPlaceApiImpl(apiUrl, authProvider, client, json = httpClientJson))
	}
	override val role: RoleApi by lazy {
		RoleApiImpl(RawRoleApiImpl(apiUrl, authProvider, client, json = httpClientJson))
	}
	override val tarification: TarificationApi by lazy {
		TarificationApiImpl(RawTarificationApiImpl(apiUrl, authProvider, client, json = httpClientJson))
	}

	override suspend fun switchGroup(groupId: String): IcureSdk {
		val switchedProvider = authProvider.switchGroup(groupId)
		val switchedCryptoConfigs = initializeApiCrypto(
			config.apiUrl,
			switchedProvider,
			config.httpClient,
			config.clientJson,
			config.crypto.strategies,
			config.crypto.primitives,
			config.storage,
			options
		)
		return IcureApiImpl(
			switchedProvider,
			httpClientJson,
			switchedCryptoConfigs,
			options
		)
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

