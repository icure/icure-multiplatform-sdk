package com.icure.sdk

import com.icure.sdk.IcureSdk.Companion.sharedHttpClient
import com.icure.sdk.api.AuthenticationMethod
import com.icure.sdk.options.BasicApiConfiguration
import com.icure.sdk.api.BasicApiConfigurationImpl
import com.icure.sdk.api.CodeApi
import com.icure.sdk.api.CodeApiImpl
import com.icure.sdk.api.DeviceApi
import com.icure.sdk.api.DeviceApiImpl
import com.icure.sdk.api.GroupApi
import com.icure.sdk.api.GroupApiImpl
import com.icure.sdk.api.HealthcarePartyApi
import com.icure.sdk.api.HealthcarePartyApiImpl
import com.icure.sdk.api.PermissionApi
import com.icure.sdk.api.PermissionApiImpl
import com.icure.sdk.api.UserApi
import com.icure.sdk.api.UserApiImpl
import com.icure.sdk.api.flavoured.AccessLogBasicApi
import com.icure.sdk.api.flavoured.AccessLogBasicApiImpl
import com.icure.sdk.api.flavoured.CalendarItemBasicApi
import com.icure.sdk.api.flavoured.CalendarItemBasicApiImpl
import com.icure.sdk.api.flavoured.ClassificationBasicApi
import com.icure.sdk.api.flavoured.ClassificationBasicApiImpl
import com.icure.sdk.api.flavoured.ContactBasicApi
import com.icure.sdk.api.flavoured.ContactBasicApiImpl
import com.icure.sdk.api.flavoured.DocumentBasicApi
import com.icure.sdk.api.flavoured.DocumentBasicApiImpl
import com.icure.sdk.api.flavoured.FormBasicApi
import com.icure.sdk.api.flavoured.FormBasicApiImpl
import com.icure.sdk.api.flavoured.HealthcareElementBasicApi
import com.icure.sdk.api.flavoured.HealthcareElementBasicApiImpl
import com.icure.sdk.api.flavoured.InvoiceBasicApi
import com.icure.sdk.api.flavoured.InvoiceBasicApiImpl
import com.icure.sdk.api.flavoured.MaintenanceTaskBasicApi
import com.icure.sdk.api.flavoured.MaintenanceTaskBasicApiImpl
import com.icure.sdk.api.flavoured.MessageBasicApi
import com.icure.sdk.api.flavoured.MessageBasicApiImpl
import com.icure.sdk.api.flavoured.PatientBasicApi
import com.icure.sdk.api.flavoured.PatientBasicApiImpl
import com.icure.sdk.api.flavoured.ReceiptBasicApi
import com.icure.sdk.api.flavoured.ReceiptBasicApiImpl
import com.icure.sdk.api.flavoured.TimeTableBasicApi
import com.icure.sdk.api.flavoured.TimeTableBasicApiImpl
import com.icure.sdk.api.flavoured.TopicBasicApi
import com.icure.sdk.api.flavoured.TopicBasicApiImpl
import com.icure.sdk.options.getAuthService
import com.icure.sdk.api.raw.impl.RawAccessLogApiImpl
import com.icure.sdk.api.raw.impl.RawAnonymousAuthApiImpl
import com.icure.sdk.api.raw.impl.RawCalendarItemApiImpl
import com.icure.sdk.api.raw.impl.RawClassificationApiImpl
import com.icure.sdk.api.raw.impl.RawCodeApiImpl
import com.icure.sdk.api.raw.impl.RawContactApiImpl
import com.icure.sdk.api.raw.impl.RawDeviceApiImpl
import com.icure.sdk.api.raw.impl.RawDocumentApiImpl
import com.icure.sdk.api.raw.impl.RawFormApiImpl
import com.icure.sdk.api.raw.impl.RawGroupApiImpl
import com.icure.sdk.api.raw.impl.RawHealthElementApiImpl
import com.icure.sdk.api.raw.impl.RawHealthcarePartyApiImpl
import com.icure.sdk.api.raw.impl.RawInvoiceApiImpl
import com.icure.sdk.api.raw.impl.RawMaintenanceTaskApiImpl
import com.icure.sdk.api.raw.impl.RawMessageApiImpl
import com.icure.sdk.api.raw.impl.RawPatientApiImpl
import com.icure.sdk.api.raw.impl.RawPermissionApiImpl
import com.icure.sdk.api.raw.impl.RawReceiptApiImpl
import com.icure.sdk.api.raw.impl.RawTimeTableApiImpl
import com.icure.sdk.api.raw.impl.RawTopicApiImpl
import com.icure.sdk.api.raw.impl.RawUserApiImpl
import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.sdk.crypto.impl.BasicInternalCryptoApiImpl
import com.icure.sdk.crypto.impl.EntityValidationServiceImpl
import com.icure.sdk.crypto.impl.JsonEncryptionServiceImpl
import com.icure.sdk.crypto.impl.NoAccessControlKeysHeadersProvider
import com.icure.sdk.options.BasicApiOptions
import com.icure.sdk.options.EntitiesEncryptedFieldsManifests
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import com.icure.sdk.websocket.WebSocketAuthProvider
import kotlinx.serialization.json.Json

interface IcureBaseSdk {
	val accessLog: AccessLogBasicApi
	val calendarItem: CalendarItemBasicApi
	val classification: ClassificationBasicApi
	val code: CodeApi
	val contact: ContactBasicApi
	val device: DeviceApi
	val document: DocumentBasicApi
	val form: FormBasicApi
	val group: GroupApi
	val healthcareElement: HealthcareElementBasicApi
	val healthcareParty: HealthcarePartyApi
	val invoice: InvoiceBasicApi
	val maintenanceTask: MaintenanceTaskBasicApi
	val message: MessageBasicApi
	val patient: PatientBasicApi
	val permission: PermissionApi
	val receipt: ReceiptBasicApi
	val timeTable: TimeTableBasicApi
	val topic: TopicBasicApi
	val user: UserApi

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
}
