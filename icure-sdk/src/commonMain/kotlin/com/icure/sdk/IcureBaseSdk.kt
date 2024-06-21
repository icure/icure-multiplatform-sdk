package com.icure.sdk

import com.icure.sdk.IcureSdk.Companion.sharedHttpClient
import com.icure.sdk.api.ApplicationSettingsApi
import com.icure.sdk.api.ApplicationSettingsApiImpl
import com.icure.sdk.api.CodeApiImpl
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
import com.icure.sdk.api.HealthcarePartyApiImpl
import com.icure.sdk.api.ICureApi
import com.icure.sdk.api.ICureApiImpl
import com.icure.sdk.api.InsuranceApi
import com.icure.sdk.api.InsuranceApiImpl
import com.icure.sdk.api.KeywordApi
import com.icure.sdk.api.KeywordApiImpl
import com.icure.sdk.api.PermissionApiImpl
import com.icure.sdk.api.PlaceApi
import com.icure.sdk.api.PlaceApiImpl
import com.icure.sdk.api.RoleApi
import com.icure.sdk.api.RoleApiImpl
import com.icure.sdk.api.TarificationApi
import com.icure.sdk.api.TarificationApiImpl
import com.icure.sdk.api.UserApi
import com.icure.sdk.api.UserApiImpl
import com.icure.sdk.api.flavoured.AccessLogBasicApiImpl
import com.icure.sdk.api.flavoured.CalendarItemBasicApiImpl
import com.icure.sdk.api.flavoured.ClassificationBasicApiImpl
import com.icure.sdk.api.flavoured.ContactBasicApiImpl
import com.icure.sdk.api.flavoured.DocumentBasicApiImpl
import com.icure.sdk.api.flavoured.FormBasicApiImpl
import com.icure.sdk.api.flavoured.HealthcareElementBasicApiImpl
import com.icure.sdk.api.flavoured.InvoiceBasicApiImpl
import com.icure.sdk.api.flavoured.MaintenanceTaskBasicApiImpl
import com.icure.sdk.api.flavoured.MessageBasicApiImpl
import com.icure.sdk.api.flavoured.PatientBasicApiImpl
import com.icure.sdk.api.flavoured.ReceiptBasicApiImpl
import com.icure.sdk.api.flavoured.TimeTableBasicApiImpl
import com.icure.sdk.api.flavoured.TopicBasicApiImpl
import com.icure.sdk.api.raw.impl.RawAccessLogApiImpl
import com.icure.sdk.api.raw.impl.RawAnonymousAuthApiImpl
import com.icure.sdk.api.raw.impl.RawApplicationSettingsApiImpl
import com.icure.sdk.api.raw.impl.RawCalendarItemApiImpl
import com.icure.sdk.api.raw.impl.RawClassificationApiImpl
import com.icure.sdk.api.raw.impl.RawCodeApiImpl
import com.icure.sdk.api.raw.impl.RawContactApiImpl
import com.icure.sdk.api.raw.impl.RawDeviceApiImpl
import com.icure.sdk.api.raw.impl.RawDocumentApiImpl
import com.icure.sdk.api.raw.impl.RawDocumentTemplateApiImpl
import com.icure.sdk.api.raw.impl.RawEntityReferenceApiImpl
import com.icure.sdk.api.raw.impl.RawEntityTemplateApiImpl
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
import com.icure.sdk.api.raw.impl.RawRoleApiImpl
import com.icure.sdk.api.raw.impl.RawTarificationApiImpl
import com.icure.sdk.api.raw.impl.RawTimeTableApiImpl
import com.icure.sdk.api.raw.impl.RawTopicApiImpl
import com.icure.sdk.api.raw.impl.RawUserApiImpl
import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.sdk.crypto.impl.BasicInternalCryptoApiImpl
import com.icure.sdk.crypto.impl.EntityValidationServiceImpl
import com.icure.sdk.crypto.impl.JsonEncryptionServiceImpl
import com.icure.sdk.crypto.impl.NoAccessControlKeysHeadersProvider
import com.icure.sdk.options.AuthenticationMethod
import com.icure.sdk.options.BasicApiConfiguration
import com.icure.sdk.options.BasicApiConfigurationImpl
import com.icure.sdk.options.BasicApiOptions
import com.icure.sdk.options.EntitiesEncryptedFieldsManifests
import com.icure.sdk.options.getAuthService
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import com.icure.sdk.websocket.WebSocketAuthProvider
import kotlinx.serialization.json.Json

interface IcureBaseSdk : IcureBaseApis {
	companion object {
		@OptIn(InternalIcureApi::class)
		suspend fun initialise(
			baseUrl: String,
			authenticationMethod: AuthenticationMethod,
			options: BasicApiOptions = BasicApiOptions()
		): IcureBaseSdk {
			val client = options.httpClient ?: sharedHttpClient
			val json = options.httpClientJson ?: Serialization.json
			val apiUrl = baseUrl
			val authApi = RawAnonymousAuthApiImpl(apiUrl = apiUrl, httpClient = client, json = json)
			val authService = authenticationMethod.getAuthService(authApi)

			val manifests = EntitiesEncryptedFieldsManifests.fromEncryptedFields(options.encryptedFields)

			val webSocketAuthProvider = WebSocketAuthProvider.fromAuthServiceIfSupported(authService)

			val jsonEncryptionService = JsonEncryptionServiceImpl(options.cryptoService)
			val config = BasicApiConfigurationImpl(
				apiUrl,
				client,
				webSocketAuthProvider,
				BasicInternalCryptoApiImpl(jsonEncryptionService, EntityValidationServiceImpl(jsonEncryptionService)),
				manifests
			)
			return IcureBaseApiImpl(
				authService,
				NoAccessControlKeysHeadersProvider,
				json,
				config
			)
		}
	}
}

@OptIn(InternalIcureApi::class)
private class IcureBaseApiImpl(
	private val authService: AuthService,
	private val headersProvider: AccessControlKeysHeadersProvider,
	private val httpClientJson: Json,
	private val config: BasicApiConfiguration
) : IcureBaseSdk {
	private val apiUrl get() = config.apiUrl
	private val client get() = config.httpClient

	override val accessLog by lazy {
		AccessLogBasicApiImpl(
			RawAccessLogApiImpl(
				apiUrl,
				authService,
				headersProvider,
				client,
				json = httpClientJson
			), config
		)
	}
	override val calendarItem by lazy {
		CalendarItemBasicApiImpl(
			RawCalendarItemApiImpl(
				apiUrl,
				authService,
				headersProvider,
				client,
				json = httpClientJson
			), config
		)
	}
	override val classification by lazy {
		ClassificationBasicApiImpl(
			RawClassificationApiImpl(
				apiUrl,
				authService,
				headersProvider,
				client,
				json = httpClientJson
			), config
		)
	}
	override val code by lazy { CodeApiImpl(RawCodeApiImpl(apiUrl, authService, client, json = httpClientJson)) }
	override val contact by lazy {
		ContactBasicApiImpl(
			RawContactApiImpl(
				apiUrl,
				authService,
				headersProvider,
				client,
				json = httpClientJson
			), config
		)
	}
	override val device by lazy { DeviceApiImpl(RawDeviceApiImpl(apiUrl, authService, client, json = httpClientJson)) }
	override val document by lazy {
		DocumentBasicApiImpl(
			RawDocumentApiImpl(
				apiUrl,
				authService,
				headersProvider,
				client,
				json = httpClientJson
			), config
		)
	}
	override val form by lazy {
		FormBasicApiImpl(
			RawFormApiImpl(
				apiUrl,
				authService,
				headersProvider,
				client,
				json = httpClientJson
			), config
		)
	}
	override val group: GroupApi by lazy {
		GroupApiImpl(
			RawGroupApiImpl(
				apiUrl,
				authService,
				client,
				json = httpClientJson
			)
		)
	}
	override val healthcareElement by lazy {
		HealthcareElementBasicApiImpl(
			RawHealthElementApiImpl(
				apiUrl,
				authService,
				headersProvider,
				client,
				json = httpClientJson
			), config
		)
	}
	override val healthcareParty by lazy {
		HealthcarePartyApiImpl(
			RawHealthcarePartyApiImpl(
				apiUrl,
				authService,
				client,
				json = httpClientJson
			)
		)
	}
	override val invoice by lazy {
		InvoiceBasicApiImpl(
			RawInvoiceApiImpl(
				apiUrl,
				authService,
				headersProvider,
				client,
				json = httpClientJson
			), config
		)
	}
	override val maintenanceTask by lazy {
		MaintenanceTaskBasicApiImpl(
			RawMaintenanceTaskApiImpl(
				apiUrl,
				authService,
				headersProvider,
				client,
				json = httpClientJson
			), config
		)
	}
	override val message by lazy {
		MessageBasicApiImpl(
			RawMessageApiImpl(
				apiUrl,
				authService,
				headersProvider,
				client,
				json = httpClientJson
			), config
		)
	}
	override val patient by lazy {
		PatientBasicApiImpl(
			RawPatientApiImpl(
				apiUrl,
				authService,
				headersProvider,
				client,
				json = httpClientJson
			), config
		)
	}
	override val permission by lazy {
		PermissionApiImpl(
			RawPermissionApiImpl(
				apiUrl,
				authService,
				client,
				json = httpClientJson
			)
		)
	}
	override val receipt by lazy {
		ReceiptBasicApiImpl(
			RawReceiptApiImpl(
				apiUrl,
				authService,
				headersProvider,
				client,
				json = httpClientJson
			), config
		)
	}
	override val timeTable by lazy {
		TimeTableBasicApiImpl(
			RawTimeTableApiImpl(
				apiUrl,
				authService,
				headersProvider,
				client,
				json = httpClientJson
			), config
		)
	}
	override val topic by lazy {
		TopicBasicApiImpl(
			RawTopicApiImpl(
				apiUrl,
				authService,
				headersProvider,
				client,
				json = httpClientJson
			), config
		)
	}
	override val user: UserApi by lazy {
		UserApiImpl(
			RawUserApiImpl(apiUrl, authService, client, json = httpClientJson),
			RawPermissionApiImpl(apiUrl, authService, client, json = httpClientJson)
		)
	}

	override val applicationSettings: ApplicationSettingsApi by lazy {
		ApplicationSettingsApiImpl(RawApplicationSettingsApiImpl(apiUrl, authService, client, json = httpClientJson))
	}
	override val documentTemplate: DocumentTemplateApi by lazy {
		DocumentTemplateApiImpl(apiUrl, RawDocumentTemplateApiImpl(apiUrl, authService, client, json = httpClientJson))
	}
	override val entityReference: EntityReferenceApi by lazy {
		EntityReferenceApiImpl(RawEntityReferenceApiImpl(apiUrl, authService, client, json = httpClientJson))
	}
	override val entityTemplate: EntityTemplateApi by lazy {
		EntityTemplateApiImpl(RawEntityTemplateApiImpl(apiUrl, authService, client, json = httpClientJson))
	}
	override val frontEndMigration: FrontEndMigrationApi by lazy {
		FrontEndMigrationApiImpl(RawFrontEndMigrationApiImpl(apiUrl, authService, client, json = httpClientJson))
	}
	override val iCure: ICureApi by lazy {
		ICureApiImpl(RawICureApiImpl(apiUrl, authService, client, json = httpClientJson))
	}
	override val insurance: InsuranceApi by lazy {
		InsuranceApiImpl(RawInsuranceApiImpl(apiUrl, authService, client, json = httpClientJson))
	}
	override val keyword: KeywordApi by lazy {
		KeywordApiImpl(RawKeywordApiImpl(apiUrl, authService, client, json = httpClientJson))
	}
	override val place: PlaceApi by lazy {
		PlaceApiImpl(RawPlaceApiImpl(apiUrl, authService, client, json = httpClientJson))
	}
	override val role: RoleApi by lazy {
		RoleApiImpl(RawRoleApiImpl(apiUrl, authService, client, json = httpClientJson))
	}
	override val tarification: TarificationApi by lazy {
		TarificationApiImpl(RawTarificationApiImpl(apiUrl, authService, client, json = httpClientJson))
	}
}
