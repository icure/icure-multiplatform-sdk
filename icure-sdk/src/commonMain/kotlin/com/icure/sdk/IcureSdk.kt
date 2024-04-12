package com.icure.sdk

import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.kryptom.utils.toHexString
import com.icure.sdk.api.ApiOptions
import com.icure.sdk.api.CryptoApi
import com.icure.sdk.api.EncryptedFields
import com.icure.sdk.api.UserApi
import com.icure.sdk.api.UserApiImpl
import com.icure.sdk.api.extended.DataOwnerApi
import com.icure.sdk.api.extended.DataOwnerApiImpl
import com.icure.sdk.api.extended.IcureMaintenanceTaskApi
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
import com.icure.sdk.api.raw.RawAccessLogApi
import com.icure.sdk.api.raw.RawAnonymousAuthApi
import com.icure.sdk.api.raw.RawCalendarItemApi
import com.icure.sdk.api.raw.RawClassificationApi
import com.icure.sdk.api.raw.RawContactApi
import com.icure.sdk.api.raw.RawDataOwnerApi
import com.icure.sdk.api.raw.RawDeviceApi
import com.icure.sdk.api.raw.RawDocumentApi
import com.icure.sdk.api.raw.RawExchangeDataApi
import com.icure.sdk.api.raw.RawExchangeDataMapApi
import com.icure.sdk.api.raw.RawFormApi
import com.icure.sdk.api.raw.RawHealthElementApi
import com.icure.sdk.api.raw.RawHealthcarePartyApi
import com.icure.sdk.api.raw.RawInvoiceApi
import com.icure.sdk.api.raw.RawMaintenanceTaskApi
import com.icure.sdk.api.raw.RawMessageApi
import com.icure.sdk.api.raw.RawPatientApi
import com.icure.sdk.api.raw.RawPermissionApi
import com.icure.sdk.api.raw.RawReceiptApi
import com.icure.sdk.api.raw.RawSecureDelegationKeyMapApi
import com.icure.sdk.api.raw.RawTimeTableApi
import com.icure.sdk.api.raw.RawTopicApi
import com.icure.sdk.api.raw.RawUserApi
import com.icure.sdk.auth.UsernamePassword
import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.JwtAuthService
import com.icure.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.sdk.crypto.CryptoStrategies
import com.icure.sdk.crypto.EntityEncryptionService
import com.icure.sdk.crypto.JsonEncryptionService
import com.icure.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleDelegateShareOptions
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
import com.icure.sdk.crypto.impl.LegacyDelegationsDecryptor
import com.icure.sdk.crypto.impl.NoAccessControlKeysHeadersProvider
import com.icure.sdk.crypto.impl.NoopKeyRecoverer
import com.icure.sdk.crypto.impl.SecureDelegationsDecryptorImpl
import com.icure.sdk.crypto.impl.SecureDelegationsEncryptionImpl
import com.icure.sdk.crypto.impl.SecureDelegationsManagerImpl
import com.icure.sdk.crypto.impl.ShamirKeysManagerImpl
import com.icure.sdk.crypto.impl.ShamirSecretSharingService
import com.icure.sdk.crypto.impl.TransferKeysManagerImpl
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
import com.icure.sdk.utils.Serialization
import com.icure.sdk.utils.newPlatformHttpClient
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json

interface IcureSdk {
	val accessLog: AccessLogApi
	val calendarItem: CalendarItemApi
	val classification: ClassificationApi
	val contact: ContactApi
	val document: DocumentApi
	val form: FormApi
	val healthcareElement: HealthcareElementApi
	val invoice: InvoiceApi
	val maintenanceTask: MaintenanceTaskApi
	val message: MessageApi
	val patient: PatientApi
	val receipt: ReceiptApi
	val timeTable: TimeTableApi
	val topic: TopicApi
	val crypto: CryptoApi
	val dataOwner: DataOwnerApi
	val user: UserApi
	val icureMaintenanceTask: IcureMaintenanceTaskApi

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
			usernamePassword: UsernamePassword,
			baseStorage: StorageFacade,
			cryptoStrategies: CryptoStrategies,
			options: ApiOptions = ApiOptions()
		): IcureSdk {
			val client = options.httpClient ?: sharedHttpClient
			val cryptoService = defaultCryptoService
			val apiUrl = baseUrl
			val keysStorage = JsonAndBase64KeyStorage(baseStorage)
			val iCureStorage =
				IcureStorageFacade(keysStorage, baseStorage, DefaultStorageEntryKeysFactory, cryptoService, false)
			val authApi = RawAnonymousAuthApi(apiUrl, client)
			val authService = JwtAuthService(authApi, usernamePassword)
			val dataOwnerApi = DataOwnerApiImpl(RawDataOwnerApi(apiUrl, authService, client))
			val self = dataOwnerApi.getCurrentDataOwner()
			val selfIsAnonymous = cryptoStrategies.dataOwnerRequiresAnonymousDelegation(self.toStub())
			val rawPatientApiNoAccessKeys = RawPatientApi(apiUrl, authService, null, client)
			val rawHealthcarePartyApi = RawHealthcarePartyApi(apiUrl, authService, client)
			val rawDeviceApi = RawDeviceApi(apiUrl, authService, client)
			val exchangeDataMapManager = ExchangeDataMapManagerImpl(
				RawExchangeDataMapApi(apiUrl, authService, client),
				cryptoService
			)
			val baseExchangeDataManager = BaseExchangeDataManagerImpl(
				RawExchangeDataApi(apiUrl, authService, client),
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
					RawSecureDelegationKeyMapApi(apiUrl, authService, client),
					headersProvider,
					entityEncryptionService,
					dataOwnerApi,
					cryptoService
				),
				dataOwnerApi,
				userEncryptionKeys
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
			return IcureApiImpl(
				crypto,
				apiUrl,
				authService,
				headersProvider,
				client,
				manifests,
				!selfIsAnonymous
			)
		}
	}
}

@OptIn(InternalIcureApi::class)
private class IcureApiImpl(
	private val internalCrypto: InternalCryptoApiImpl,
	private val apiUrl: String,
	private val authService: AuthService,
	private val headersProvider: AccessControlKeysHeadersProvider,
	private val client: HttpClient,
	private val encryptedFieldsManifests: EntitiesEncryptedFieldsManifests,
	private val autofillAuthor: Boolean
): IcureSdk {
	private val rawCalendarItemApi by lazy { RawCalendarItemApi(apiUrl, authService, headersProvider, client) }

	override val calendarItem: CalendarItemApi by lazy {
		CalendarItemApiImpl(
			rawCalendarItemApi,
			internalCrypto,
			encryptedFieldsManifests.calendarItem,
			autofillAuthor
		)
	}

	private val rawContactApi by lazy { RawContactApi(apiUrl, authService, headersProvider, client) }

	override val contact: ContactApi by lazy {
		ContactApiImpl(
			rawContactApi,
			internalCrypto,
			encryptedFieldsManifests.contact,
			encryptedFieldsManifests.service,
			autofillAuthor
		)
	}

	private val rawPatientApi by lazy { RawPatientApi(apiUrl, authService, headersProvider, client) }

	override val patient: PatientApi by lazy {
		PatientApiImpl(
			rawPatientApi,
			internalCrypto,
			encryptedFieldsManifests.patient,
			autofillAuthor
		)
	}

	private val rawHealthcareElementApi by lazy { RawHealthElementApi(apiUrl, authService, headersProvider, client) }

	override val healthcareElement: HealthcareElementApi by lazy {
		HealthcareElementApiImpl(
			rawHealthcareElementApi,
			internalCrypto,
			encryptedFieldsManifests.healthElement,
			autofillAuthor
		)
	}

	override val dataOwner: DataOwnerApi get() = internalCrypto.dataOwnerApi

	override val user: UserApi by lazy {
		UserApiImpl(
			RawUserApi(apiUrl, authService, client),
			RawPermissionApi(apiUrl, authService, client)
		)
	}
	override val crypto: CryptoApi by lazy {
		CryptoApi(
			ShamirKeysManagerImpl(
				internalCrypto.dataOwnerApi,
				internalCrypto.userEncryptionKeysManager,
				internalCrypto.exchangeDataManager,
				internalCrypto.primitives,
				ShamirSecretSharingService(internalCrypto.primitives.strongRandom)
			),
			internalCrypto
		)
	}

	private val rawMaintenanceTaskApi by lazy { RawMaintenanceTaskApi(apiUrl, authService, headersProvider, client) }

	override val maintenanceTask: MaintenanceTaskApi by lazy {
		MaintenanceTaskApiImpl(
			rawMaintenanceTaskApi,
			internalCrypto,
			encryptedFieldsManifests.maintenanceTask,
			autofillAuthor
		)
	}

	override val icureMaintenanceTask: IcureMaintenanceTaskApi by lazy {
		IcureMaintenanceTaskApi(
			internalCrypto.exchangeDataManager,
			internalCrypto.exchangeKeysManager.base,
			internalCrypto.userEncryptionKeysManager,
			maintenanceTask,
			internalCrypto.dataOwnerApi,
			internalCrypto.primitives.strongRandom,
		)
	}

	private val rawAccessLogApi by lazy { RawAccessLogApi(apiUrl, authService, headersProvider, client) }

	override val accessLog: AccessLogApi by lazy {
		AccessLogApiImpl(
			rawAccessLogApi,
			internalCrypto,
			encryptedFieldsManifests.accessLog,
			autofillAuthor
		)
	}

	private val rawMessageApi by lazy { RawMessageApi(apiUrl, authService, headersProvider, client) }

	override val message: MessageApi by lazy {
		MessageApiImpl(
			rawMessageApi,
			internalCrypto,
			encryptedFieldsManifests.message,
			autofillAuthor
		)
	}

	private val rawTopicApi by lazy { RawTopicApi(apiUrl, authService, headersProvider, client) }

	override val topic: TopicApi by lazy {
		TopicApiImpl(
			rawTopicApi,
			internalCrypto,
			encryptedFieldsManifests.topic,
			autofillAuthor
		)
	}

	private val rawDocumentApi by lazy { RawDocumentApi(apiUrl, authService, headersProvider, client) }

	override val document: DocumentApi by lazy {
		DocumentApiImpl(
			rawDocumentApi,
			internalCrypto,
			encryptedFieldsManifests.document,
			autofillAuthor
		)
	}

	private val rawTimeTableApi by lazy { RawTimeTableApi(apiUrl, authService, headersProvider, client) }

	override val timeTable: TimeTableApi by lazy {
		TimeTableApiImpl(
			rawTimeTableApi,
			internalCrypto,
			encryptedFieldsManifests.timeTable,
			autofillAuthor
		)
	}

	private val rawClassificationApi by lazy { RawClassificationApi(apiUrl, authService, headersProvider, client) }

	override val classification: ClassificationApi by lazy {
		ClassificationApiImpl(
			rawClassificationApi,
			internalCrypto,
			encryptedFieldsManifests.classification,
			autofillAuthor
		)
	}

	private val rawFormApi by lazy { RawFormApi(apiUrl, authService, headersProvider, client) }

	override val form: FormApi by lazy {
		FormApiImpl(
			rawFormApi,
			internalCrypto,
			encryptedFieldsManifests.form,
			autofillAuthor
		)
	}

	private val rawInvoiceApi by lazy { RawInvoiceApi(apiUrl, authService, headersProvider, client) }

	override val invoice: InvoiceApi by lazy {
		InvoiceApiImpl(
			rawInvoiceApi,
			internalCrypto,
			encryptedFieldsManifests.invoice,
			autofillAuthor
		)
	}

	private val rawReceiptApi by lazy { RawReceiptApi(apiUrl, authService, headersProvider, client) }

	override val receipt: ReceiptApi by lazy {
		ReceiptApiImpl(
			rawReceiptApi,
			internalCrypto,
			encryptedFieldsManifests.receipt,
			autofillAuthor
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
						self.dataOwner.id to SimpleDelegateShareOptions(
							shareEncryptionKeys = ShareMetadataBehaviour.IfAvailable,
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

/**
 * Parse the fields on api initialization to avoid late throw of errors
 */
@InternalIcureApi
private class EntitiesEncryptedFieldsManifests private constructor(
	val accessLog: EncryptedFieldsManifest,
	val calendarItem: EncryptedFieldsManifest,
	val contact: EncryptedFieldsManifest,
	val service: EncryptedFieldsManifest,
	val healthElement: EncryptedFieldsManifest,
	val maintenanceTask: EncryptedFieldsManifest,
	val patient: EncryptedFieldsManifest,
	val message: EncryptedFieldsManifest,
	val topic: EncryptedFieldsManifest,
	val document: EncryptedFieldsManifest,
	val timeTable: EncryptedFieldsManifest,
	val classification: EncryptedFieldsManifest,
	val form: EncryptedFieldsManifest,
	val invoice: EncryptedFieldsManifest,
	val receipt: EncryptedFieldsManifest
) {
	companion object {
		fun fromEncryptedFields(encryptedFields: EncryptedFields): EntitiesEncryptedFieldsManifests {
			val contactManifest = JsonEncryptionService.parseEncryptedFields(
				encryptedFields.contact,
				"Contact."
			)
			require("services" !in contactManifest.allKeys) {
				"You can't customise encryption of the `services` field of Contact. Use the serviceEncryptedKeys parameter instead."
			}
			val serviceManifest = JsonEncryptionService.parseEncryptedFields(
				encryptedFields.service,
				"Service."
			)
			require("content" !in serviceManifest.allKeys) {
				"You can't customise encryption of the `content` of a Service. The content values for services is automatically encrypted."
			}
			return EntitiesEncryptedFieldsManifests(
				contact = contactManifest,
				service = serviceManifest,
				accessLog = JsonEncryptionService.parseEncryptedFields(
					encryptedFields.accessLog,
					"AccessLog."
				),
				calendarItem = JsonEncryptionService.parseEncryptedFields(
					encryptedFields.calendarItem,
					"CalendarItem."
				),
				healthElement = JsonEncryptionService.parseEncryptedFields(
					encryptedFields.healthElement,
					"HealthElement."
				),
				maintenanceTask = JsonEncryptionService.parseEncryptedFields(
					encryptedFields.maintenanceTask,
					"MaintenanceTask."
				),
				patient = JsonEncryptionService.parseEncryptedFields(
					encryptedFields.patient,
					"Patient."
				),
				message = JsonEncryptionService.parseEncryptedFields(
					encryptedFields.message,
					"Message."
				),
				topic = JsonEncryptionService.parseEncryptedFields(
					encryptedFields.topic,
					"Topic."
				),
				document = JsonEncryptionService.parseEncryptedFields(
					encryptedFields.document,
					"Document."
				),
				timeTable = JsonEncryptionService.parseEncryptedFields(
					encryptedFields.timeTable,
					"TimeTable."
				),
				classification = JsonEncryptionService.parseEncryptedFields(
					encryptedFields.classification,
					"Classification."
				),
				form = JsonEncryptionService.parseEncryptedFields(
					encryptedFields.form,
					"Form."
				),
				invoice = JsonEncryptionService.parseEncryptedFields(
					encryptedFields.invoice,
					"Invoice."
				),
				receipt = JsonEncryptionService.parseEncryptedFields(
					encryptedFields.receipt ,
					"Receipt."
				)
			)
		}
	}
}
