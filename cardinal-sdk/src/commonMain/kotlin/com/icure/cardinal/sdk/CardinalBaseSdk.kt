package com.icure.cardinal.sdk

import com.icure.cardinal.sdk.CardinalSdk.Companion.sharedHttpClient
import com.icure.cardinal.sdk.api.AgendaApi
import com.icure.cardinal.sdk.api.ApplicationSettingsApi
import com.icure.cardinal.sdk.api.DocumentTemplateApi
import com.icure.cardinal.sdk.api.EntityReferenceApi
import com.icure.cardinal.sdk.api.EntityTemplateApi
import com.icure.cardinal.sdk.api.FrontEndMigrationApi
import com.icure.cardinal.sdk.api.GroupApi
import com.icure.cardinal.sdk.api.InsuranceApi
import com.icure.cardinal.sdk.api.KeywordApi
import com.icure.cardinal.sdk.api.MedicalLocationApi
import com.icure.cardinal.sdk.api.PlaceApi
import com.icure.cardinal.sdk.api.RoleApi
import com.icure.cardinal.sdk.api.SystemApi
import com.icure.cardinal.sdk.api.TarificationApi
import com.icure.cardinal.sdk.api.UserApi
import com.icure.cardinal.sdk.api.impl.AccessLogBasicApiImpl
import com.icure.cardinal.sdk.api.impl.AgendaApiImpl
import com.icure.cardinal.sdk.api.impl.ApplicationSettingsApiImpl
import com.icure.cardinal.sdk.api.impl.CalendarItemBasicApiImpl
import com.icure.cardinal.sdk.api.impl.ClassificationBasicApiImpl
import com.icure.cardinal.sdk.api.impl.CodeApiImpl
import com.icure.cardinal.sdk.api.impl.ContactBasicApiImpl
import com.icure.cardinal.sdk.api.impl.DeviceApiImpl
import com.icure.cardinal.sdk.api.impl.DocumentBasicApiImpl
import com.icure.cardinal.sdk.api.impl.DocumentTemplateApiImpl
import com.icure.cardinal.sdk.api.impl.EntityReferenceApiImpl
import com.icure.cardinal.sdk.api.impl.EntityTemplateApiImpl
import com.icure.cardinal.sdk.api.impl.FormBasicApiImpl
import com.icure.cardinal.sdk.api.impl.FrontEndMigrationApiImpl
import com.icure.cardinal.sdk.api.impl.GroupApiImpl
import com.icure.cardinal.sdk.api.impl.HealthElementBasicApiImpl
import com.icure.cardinal.sdk.api.impl.HealthcarePartyApiImpl
import com.icure.cardinal.sdk.api.impl.InsuranceApiImpl
import com.icure.cardinal.sdk.api.impl.InvoiceBasicApiImpl
import com.icure.cardinal.sdk.api.impl.KeywordApiImpl
import com.icure.cardinal.sdk.api.impl.MaintenanceTaskBasicApiImpl
import com.icure.cardinal.sdk.api.impl.MedicalLocationApiImpl
import com.icure.cardinal.sdk.api.impl.MessageBasicApiImpl
import com.icure.cardinal.sdk.api.impl.PatientBasicApiImpl
import com.icure.cardinal.sdk.api.impl.PermissionApiImpl
import com.icure.cardinal.sdk.api.impl.PlaceApiImpl
import com.icure.cardinal.sdk.api.impl.ReceiptBasicApiImpl
import com.icure.cardinal.sdk.api.impl.RoleApiImpl
import com.icure.cardinal.sdk.api.impl.SystemApiImpl
import com.icure.cardinal.sdk.api.impl.TarificationApiImpl
import com.icure.cardinal.sdk.api.impl.TimeTableBasicApiImpl
import com.icure.cardinal.sdk.api.impl.TopicBasicApiImpl
import com.icure.cardinal.sdk.api.impl.UserApiImpl
import com.icure.cardinal.sdk.api.raw.RawMessageGatewayApi
import com.icure.cardinal.sdk.api.raw.impl.RawAccessLogApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawAgendaApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawAnonymousAuthApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawApplicationSettingsApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawCalendarItemApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawClassificationApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawCodeApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawContactApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawDeviceApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawDocumentApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawDocumentTemplateApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawEntityReferenceApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawEntityTemplateApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawFormApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawFrontEndMigrationApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawGroupApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawHealthElementApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawHealthcarePartyApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawICureApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawInsuranceApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawInvoiceApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawKeywordApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawMaintenanceTaskApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawMedicalLocationApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawMessageApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawPatientApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawPermissionApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawPlaceApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawReceiptApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawRoleApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawTarificationApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawTimeTableApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawTopicApiImpl
import com.icure.cardinal.sdk.api.raw.impl.RawUserApiImpl
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.auth.services.JwtBasedAuthProvider
import com.icure.cardinal.sdk.crypto.impl.BasicInternalCryptoApiImpl
import com.icure.cardinal.sdk.crypto.impl.EntityValidationServiceImpl
import com.icure.cardinal.sdk.crypto.impl.JsonEncryptionServiceImpl
import com.icure.cardinal.sdk.crypto.impl.NoAccessControlKeysHeadersProvider
import com.icure.cardinal.sdk.options.AuthenticationMethod
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.options.BasicApiConfigurationImpl
import com.icure.cardinal.sdk.options.BasicSdkOptions
import com.icure.cardinal.sdk.options.EntitiesEncryptedFieldsManifests
import com.icure.cardinal.sdk.options.getAuthProvider
import com.icure.cardinal.sdk.options.getAuthProviderInGroup
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json

/**
 * Similar to the [CardinalBaseSdk] but is not bound to a specific user and/or group.
 * This allows using proxy authentication methods.
 */
@InternalIcureApi
interface CardinalUnboundBaseSdk : CardinalBaseApis {
	companion object {
		/**
		 * Initialize a new instance of icure base sdks that is not bound to a specific user.
		 * Each request may be done as a different user, depending on the provided authentication method.
		 *
		 * This allows implementing services between the end user and the icure backend that act as proxy and perform
		 * some requests on behalf of the user.
		 *
		 * @param baseUrl the url of the iCure backend to use
		 * @param authenticationMethod specifies how the sdk should authenticate.
		 * @param options optional parameters for the initialization of the sdk.
		 */
		@InternalIcureApi
		fun initialize(
			baseUrl: String,
			authenticationMethod: AuthenticationMethod,
			options: BasicSdkOptions = BasicSdkOptions()
		): CardinalUnboundBaseSdk {
			require(options.groupSelector == null) { "Group selector should be null for unbound based sdk" }
			val client = options.httpClient ?: sharedHttpClient
			val json = options.httpClientJson ?: Serialization.json
			val cryptoService = options.cryptoService
			val apiUrl = baseUrl
			val rawAuthApi = RawAnonymousAuthApiImpl(apiUrl, client, json = Serialization.json)
			val authProvider = authenticationMethod.getAuthProvider(
				rawAuthApi,
				cryptoService,
				null,
				options,
				RawMessageGatewayApi(client, cryptoService)
			)

			val manifests = EntitiesEncryptedFieldsManifests.fromEncryptedFields(options.encryptedFields)

			val jsonEncryptionService = JsonEncryptionServiceImpl(cryptoService)
			val config = BasicApiConfigurationImpl(
				apiUrl,
				client,
				json,
				if (authProvider is JwtBasedAuthProvider) authProvider else null,
				BasicInternalCryptoApiImpl(jsonEncryptionService, EntityValidationServiceImpl(jsonEncryptionService)),
				manifests
			)
			return object : CardinalUnboundBaseSdk, CardinalBaseApis by CardinalBaseSdkImpl(
				authProvider,
				json,
				config
			) {}
		}
	}
}

interface CardinalBaseSdk : CardinalBaseApis {
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
	suspend fun switchGroup(groupId: String): CardinalBaseSdk

	companion object {
		/**
		 * Initialize a new instance of icure base sdks for a specific user.
		 *
		 * @param applicationId a string to uniquely identify your iCure application.
		 * @param baseUrl the url of the iCure backend to use
		 * @param authenticationMethod specifies how the sdk should authenticate.
		 * @param options optional parameters for the initialization of the sdk.
		 */
		@OptIn(InternalIcureApi::class)
		suspend fun initialize(
			applicationId: String?,
			baseUrl: String,
			authenticationMethod: AuthenticationMethod,
			options: BasicSdkOptions = BasicSdkOptions()
		): CardinalBaseSdk {
			val client = options.httpClient ?: sharedHttpClient
			val json = options.httpClientJson ?: Serialization.json
			val cryptoService = options.cryptoService
			val apiUrl = baseUrl
			val authProvider = authenticationMethod.getAuthProviderInGroup(
				apiUrl,
				client,
				cryptoService,
				applicationId,
				options,
				options.groupSelector
			)

			val manifests = EntitiesEncryptedFieldsManifests.fromEncryptedFields(options.encryptedFields)

			val jsonEncryptionService = JsonEncryptionServiceImpl(cryptoService)
			val config = BasicApiConfigurationImpl(
				apiUrl,
				client,
				json,
				if (authProvider is JwtBasedAuthProvider) authProvider else null,
				BasicInternalCryptoApiImpl(jsonEncryptionService, EntityValidationServiceImpl(jsonEncryptionService)),
				manifests
			)
			return CardinalBaseSdkImpl(
				authProvider,
				json,
				config
			)
		}
	}
}

@OptIn(InternalIcureApi::class)
private class CardinalBaseApisImpl(
	private val authProvider: AuthProvider,
	private val httpClientJson: Json,
	private val config: BasicApiConfiguration
) : CardinalBaseApis {
	private val apiUrl get() = config.apiUrl
	private val client get() = config.httpClient

	override val accessLog by lazy {
		AccessLogBasicApiImpl(
			RawAccessLogApiImpl(
				apiUrl,
				authProvider,
				NoAccessControlKeysHeadersProvider,
				client,
				json = httpClientJson
			), config
		)
	}
	override val calendarItem by lazy {
		CalendarItemBasicApiImpl(
			RawCalendarItemApiImpl(
				apiUrl,
				authProvider,
				NoAccessControlKeysHeadersProvider,
				client,
				json = httpClientJson
			), config
		)
	}
	override val classification by lazy {
		ClassificationBasicApiImpl(
			RawClassificationApiImpl(
				apiUrl,
				authProvider,
				NoAccessControlKeysHeadersProvider,
				client,
				json = httpClientJson
			), config
		)
	}
	override val code by lazy { CodeApiImpl(RawCodeApiImpl(apiUrl, authProvider, client, json = httpClientJson)) }
	override val contact by lazy {
		ContactBasicApiImpl(
			RawContactApiImpl(
				apiUrl,
				authProvider,
				NoAccessControlKeysHeadersProvider,
				client,
				json = httpClientJson
			), config
		)
	}
	override val device by lazy { DeviceApiImpl(RawDeviceApiImpl(apiUrl, authProvider, client, json = httpClientJson), config) }
	override val document by lazy {
		DocumentBasicApiImpl(
			RawDocumentApiImpl(
				apiUrl,
				authProvider,
				NoAccessControlKeysHeadersProvider,
				client,
				json = httpClientJson
			), config
		)
	}
	override val form by lazy {
		FormBasicApiImpl(
			RawFormApiImpl(
				apiUrl,
				authProvider,
				NoAccessControlKeysHeadersProvider,
				client,
				json = httpClientJson
			), config
		)
	}
	override val group: GroupApi by lazy {
		GroupApiImpl(
			RawGroupApiImpl(
				apiUrl,
				authProvider,
				client,
				json = httpClientJson
			)
		)
	}
	override val healthElement by lazy {
		HealthElementBasicApiImpl(
			RawHealthElementApiImpl(
				apiUrl,
				authProvider,
				NoAccessControlKeysHeadersProvider,
				client,
				json = httpClientJson
			), config
		)
	}
	override val healthcareParty by lazy {
		HealthcarePartyApiImpl(
			RawHealthcarePartyApiImpl(
				apiUrl,
				authProvider,
				client,
				json = httpClientJson
			),
			config
		)
	}
	override val invoice by lazy {
		InvoiceBasicApiImpl(
			RawInvoiceApiImpl(
				apiUrl,
				authProvider,
				NoAccessControlKeysHeadersProvider,
				client,
				json = httpClientJson
			), config
		)
	}
	override val maintenanceTask by lazy {
		MaintenanceTaskBasicApiImpl(
			RawMaintenanceTaskApiImpl(
				apiUrl,
				authProvider,
				NoAccessControlKeysHeadersProvider,
				client,
				json = httpClientJson
			), config
		)
	}
	override val message by lazy {
		MessageBasicApiImpl(
			RawMessageApiImpl(
				apiUrl,
				authProvider,
				NoAccessControlKeysHeadersProvider,
				client,
				json = httpClientJson
			), config
		)
	}
	override val patient by lazy {
		PatientBasicApiImpl(
			RawPatientApiImpl(
				apiUrl,
				authProvider,
				NoAccessControlKeysHeadersProvider,
				client,
				json = httpClientJson
			), config
		)
	}
	override val permission by lazy {
		PermissionApiImpl(
			RawPermissionApiImpl(
				apiUrl,
				authProvider,
				client,
				json = httpClientJson
			)
		)
	}
	override val receipt by lazy {
		ReceiptBasicApiImpl(
			RawReceiptApiImpl(
				apiUrl,
				authProvider,
				NoAccessControlKeysHeadersProvider,
				client,
				json = httpClientJson
			), config
		)
	}
	override val timeTable by lazy {
		TimeTableBasicApiImpl(
			RawTimeTableApiImpl(
				apiUrl,
				authProvider,
				NoAccessControlKeysHeadersProvider,
				client,
				json = httpClientJson
			), config
		)
	}
	override val topic by lazy {
		TopicBasicApiImpl(
			RawTopicApiImpl(
				apiUrl,
				authProvider,
				NoAccessControlKeysHeadersProvider,
				client,
				json = httpClientJson
			), config
		)
	}
	override val user: UserApi by lazy {
		UserApiImpl(
			RawUserApiImpl(apiUrl, authProvider, client, json = httpClientJson),
			RawPermissionApiImpl(apiUrl, authProvider, client, json = httpClientJson),
			config
		)
	}

	override val applicationSettings: ApplicationSettingsApi by lazy {
		ApplicationSettingsApiImpl(RawApplicationSettingsApiImpl(apiUrl, authProvider, client, json = httpClientJson))
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
	override val system: SystemApi by lazy {
		SystemApiImpl(RawICureApiImpl(apiUrl, authProvider, client, json = httpClientJson))
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
	override val medicalLocation: MedicalLocationApi by lazy {
		MedicalLocationApiImpl(RawMedicalLocationApiImpl(apiUrl, authProvider, client, json = httpClientJson))
	}
	override val agenda: AgendaApi by lazy {
		AgendaApiImpl(RawAgendaApiImpl(apiUrl, authProvider, client, json = httpClientJson))
	}
}

@InternalIcureApi
private class CardinalBaseSdkImpl(
	private val authProvider: AuthProvider,
	private val httpClientJson: Json,
	private val config: BasicApiConfiguration
) : CardinalBaseSdk, CardinalBaseApis by CardinalBaseApisImpl(authProvider, httpClientJson, config) {
	override suspend fun switchGroup(groupId: String): CardinalBaseSdk = CardinalBaseSdkImpl(
		authProvider.switchGroup(groupId),
		httpClientJson,
		config
	)
}
