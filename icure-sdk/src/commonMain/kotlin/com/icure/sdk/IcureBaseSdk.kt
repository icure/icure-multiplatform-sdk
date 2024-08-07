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
import com.icure.sdk.api.flavoured.HealthElementBasicApiImpl
import com.icure.sdk.api.flavoured.InvoiceBasicApiImpl
import com.icure.sdk.api.flavoured.MaintenanceTaskBasicApiImpl
import com.icure.sdk.api.flavoured.MessageBasicApiImpl
import com.icure.sdk.api.flavoured.PatientBasicApiImpl
import com.icure.sdk.api.flavoured.ReceiptBasicApiImpl
import com.icure.sdk.api.flavoured.TimeTableBasicApiImpl
import com.icure.sdk.api.flavoured.TopicBasicApiImpl
import com.icure.sdk.api.raw.RawMessageGatewayApi
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
import com.icure.sdk.auth.services.AuthProvider
import com.icure.sdk.auth.services.JwtBasedAuthProvider
import com.icure.sdk.crypto.impl.BasicInternalCryptoApiImpl
import com.icure.sdk.crypto.impl.EntityValidationServiceImpl
import com.icure.sdk.crypto.impl.JsonEncryptionServiceImpl
import com.icure.sdk.crypto.impl.NoAccessControlKeysHeadersProvider
import com.icure.sdk.options.AuthenticationMethod
import com.icure.sdk.options.BasicApiConfiguration
import com.icure.sdk.options.BasicApiConfigurationImpl
import com.icure.sdk.options.BasicApiOptions
import com.icure.sdk.options.EntitiesEncryptedFieldsManifests
import com.icure.sdk.options.getAuthProvider
import com.icure.sdk.options.getAuthProviderInGroup
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import kotlinx.serialization.json.Json

/**
 * Similar to the [IcureBaseSdk] but is not bound to a specific user and/or group.
 * This allows using proxy authentication methods.
 */
@InternalIcureApi
interface IcureUnboundBaseSdk : IcureBaseApis {
	companion object {
		/**
		 * Initialise a new instance of icure base sdks that is not bound to a specific user.
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
		fun initialise(
			baseUrl: String,
			authenticationMethod: AuthenticationMethod,
			options: BasicApiOptions = BasicApiOptions()
		): IcureUnboundBaseSdk {
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
				RawMessageGatewayApi(client)
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
			return object : IcureUnboundBaseSdk, IcureBaseApis by IcureBaseSdkImpl(
				authProvider,
				json,
				config
			) {}
		}
	}
}

interface IcureBaseSdk : IcureBaseApis {
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
	suspend fun switchGroup(groupId: String): IcureBaseSdk

	companion object {
		/**
		 * Initialise a new instance of icure base sdks for a specific user.
		 *
		 * @param applicationId a string to uniquely identify your iCure application.
		 * @param baseUrl the url of the iCure backend to use
		 * @param authenticationMethod specifies how the sdk should authenticate.
		 * @param options optional parameters for the initialization of the sdk.
		 */
		@OptIn(InternalIcureApi::class)
		suspend fun initialise(
			applicationId: String?,
			baseUrl: String,
			authenticationMethod: AuthenticationMethod,
			options: BasicApiOptions = BasicApiOptions()
		): IcureBaseSdk {
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
			return IcureBaseSdkImpl(
				authProvider,
				json,
				config
			)
		}
	}
}

@OptIn(InternalIcureApi::class)
private class IcureBaseApisImpl(
	private val authProvider: AuthProvider,
	private val httpClientJson: Json,
	private val config: BasicApiConfiguration
) : IcureBaseApis {
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
	override val device by lazy { DeviceApiImpl(RawDeviceApiImpl(apiUrl, authProvider, client, json = httpClientJson)) }
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
			)
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
			RawPermissionApiImpl(apiUrl, authProvider, client, json = httpClientJson)
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
}

@InternalIcureApi
private class IcureBaseSdkImpl(
	private val authProvider: AuthProvider,
	private val httpClientJson: Json,
	private val config: BasicApiConfiguration
) : IcureBaseSdk, IcureBaseApis by IcureBaseApisImpl(authProvider, httpClientJson, config) {
	override suspend fun switchGroup(groupId: String): IcureBaseSdk = IcureBaseSdkImpl(
		authProvider.switchGroup(groupId),
		httpClientJson,
		config
	)
}
