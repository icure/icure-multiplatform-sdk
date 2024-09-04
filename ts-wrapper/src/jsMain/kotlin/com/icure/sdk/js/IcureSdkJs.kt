package com.icure.sdk.js

import com.icure.sdk.CardinalBaseSdk
import com.icure.sdk.CardinalSdk
import com.icure.sdk.auth.AuthenticationProcessCaptchaType
import com.icure.sdk.auth.AuthenticationProcessTelecomType
import com.icure.sdk.auth.AuthenticationProcessTemplateParameters
import com.icure.sdk.js.api.AccessLogApiJs
import com.icure.sdk.js.api.AccessLogBasicApiJs
import com.icure.sdk.js.api.AgendaApiJs
import com.icure.sdk.js.api.ApplicationSettingsApiJs
import com.icure.sdk.js.api.CalendarItemApiJs
import com.icure.sdk.js.api.CalendarItemBasicApiJs
import com.icure.sdk.js.api.ClassificationApiJs
import com.icure.sdk.js.api.ClassificationBasicApiJs
import com.icure.sdk.js.api.CodeApiJs
import com.icure.sdk.js.api.ContactApiJs
import com.icure.sdk.js.api.ContactBasicApiJs
import com.icure.sdk.js.api.CryptoApiJs
import com.icure.sdk.js.api.DataOwnerApiJs
import com.icure.sdk.js.api.DeviceApiJs
import com.icure.sdk.js.api.DocumentApiJs
import com.icure.sdk.js.api.DocumentBasicApiJs
import com.icure.sdk.js.api.DocumentTemplateApiJs
import com.icure.sdk.js.api.EntityReferenceApiJs
import com.icure.sdk.js.api.EntityTemplateApiJs
import com.icure.sdk.js.api.FormApiJs
import com.icure.sdk.js.api.FormBasicApiJs
import com.icure.sdk.js.api.FrontEndMigrationApiJs
import com.icure.sdk.js.api.GroupApiJs
import com.icure.sdk.js.api.HealthElementApiJs
import com.icure.sdk.js.api.HealthElementBasicApiJs
import com.icure.sdk.js.api.HealthcarePartyApiJs
import com.icure.sdk.js.api.ICureApiJs
import com.icure.sdk.js.api.IcureMaintenanceTaskApiJs
import com.icure.sdk.js.api.InsuranceApiJs
import com.icure.sdk.js.api.InvoiceApiJs
import com.icure.sdk.js.api.InvoiceBasicApiJs
import com.icure.sdk.js.api.KeywordApiJs
import com.icure.sdk.js.api.MaintenanceTaskApiJs
import com.icure.sdk.js.api.MaintenanceTaskBasicApiJs
import com.icure.sdk.js.api.MedicalLocationApiJs
import com.icure.sdk.js.api.MessageApiJs
import com.icure.sdk.js.api.MessageBasicApiJs
import com.icure.sdk.js.api.PatientApiJs
import com.icure.sdk.js.api.PatientBasicApiJs
import com.icure.sdk.js.api.PermissionApiJs
import com.icure.sdk.js.api.PlaceApiJs
import com.icure.sdk.js.api.ReceiptApiJs
import com.icure.sdk.js.api.ReceiptBasicApiJs
import com.icure.sdk.js.api.RecoveryApiJs
import com.icure.sdk.js.api.RoleApiJs
import com.icure.sdk.js.api.TarificationApiJs
import com.icure.sdk.js.api.TimeTableApiJs
import com.icure.sdk.js.api.TimeTableBasicApiJs
import com.icure.sdk.js.api.TopicApiJs
import com.icure.sdk.js.api.TopicBasicApiJs
import com.icure.sdk.js.api.UserApiJs
import com.icure.sdk.js.api.impl.AccessLogApiImplJs
import com.icure.sdk.js.api.impl.AccessLogBasicApiImplJs
import com.icure.sdk.js.api.impl.AgendaApiImplJs
import com.icure.sdk.js.api.impl.ApplicationSettingsApiImplJs
import com.icure.sdk.js.api.impl.CalendarItemApiImplJs
import com.icure.sdk.js.api.impl.CalendarItemBasicApiImplJs
import com.icure.sdk.js.api.impl.ClassificationApiImplJs
import com.icure.sdk.js.api.impl.ClassificationBasicApiImplJs
import com.icure.sdk.js.api.impl.CodeApiImplJs
import com.icure.sdk.js.api.impl.ContactApiImplJs
import com.icure.sdk.js.api.impl.ContactBasicApiImplJs
import com.icure.sdk.js.api.impl.CryptoApiImplJs
import com.icure.sdk.js.api.impl.DataOwnerApiImplJs
import com.icure.sdk.js.api.impl.DeviceApiImplJs
import com.icure.sdk.js.api.impl.DocumentApiImplJs
import com.icure.sdk.js.api.impl.DocumentBasicApiImplJs
import com.icure.sdk.js.api.impl.DocumentTemplateApiImplJs
import com.icure.sdk.js.api.impl.EntityReferenceApiImplJs
import com.icure.sdk.js.api.impl.EntityTemplateApiImplJs
import com.icure.sdk.js.api.impl.FormApiImplJs
import com.icure.sdk.js.api.impl.FormBasicApiImplJs
import com.icure.sdk.js.api.impl.FrontEndMigrationApiImplJs
import com.icure.sdk.js.api.impl.GroupApiImplJs
import com.icure.sdk.js.api.impl.HealthElementApiImplJs
import com.icure.sdk.js.api.impl.HealthElementBasicApiImplJs
import com.icure.sdk.js.api.impl.HealthcarePartyApiImplJs
import com.icure.sdk.js.api.impl.ICureApiImplJs
import com.icure.sdk.js.api.impl.IcureMaintenanceTaskApiImplJs
import com.icure.sdk.js.api.impl.InsuranceApiImplJs
import com.icure.sdk.js.api.impl.InvoiceApiImplJs
import com.icure.sdk.js.api.impl.InvoiceBasicApiImplJs
import com.icure.sdk.js.api.impl.KeywordApiImplJs
import com.icure.sdk.js.api.impl.MaintenanceTaskApiImplJs
import com.icure.sdk.js.api.impl.MaintenanceTaskBasicApiImplJs
import com.icure.sdk.js.api.impl.MedicalLocationApiImplJs
import com.icure.sdk.js.api.impl.MessageApiImplJs
import com.icure.sdk.js.api.impl.MessageBasicApiImplJs
import com.icure.sdk.js.api.impl.PatientApiImplJs
import com.icure.sdk.js.api.impl.PatientBasicApiImplJs
import com.icure.sdk.js.api.impl.PermissionApiImplJs
import com.icure.sdk.js.api.impl.PlaceApiImplJs
import com.icure.sdk.js.api.impl.ReceiptApiImplJs
import com.icure.sdk.js.api.impl.ReceiptBasicApiImplJs
import com.icure.sdk.js.api.impl.RecoveryApiImplJs
import com.icure.sdk.js.api.impl.RoleApiImplJs
import com.icure.sdk.js.api.impl.TarificationApiImplJs
import com.icure.sdk.js.api.impl.TimeTableApiImplJs
import com.icure.sdk.js.api.impl.TimeTableBasicApiImplJs
import com.icure.sdk.js.api.impl.TopicApiImplJs
import com.icure.sdk.js.api.impl.TopicBasicApiImplJs
import com.icure.sdk.js.api.impl.UserApiImplJs
import com.icure.sdk.js.externalsdk.AuthenticationWithProcessStepJs
import com.icure.sdk.js.externalsdk.IcureBaseSdkJs
import com.icure.sdk.js.externalsdk.IcureSdkJs
import com.icure.sdk.js.options.external.SdkOptionsJs
import com.icure.sdk.js.options.external.AuthenticationMethodJs
import com.icure.sdk.js.options.external.AuthenticationProcessTemplateParametersJs
import com.icure.sdk.js.options.external.BasicSdkOptionsJs
import com.icure.sdk.js.options.toKt
import com.icure.sdk.js.storage.loadStorageOptions
import com.icure.sdk.options.SdkOptions
import com.icure.sdk.options.BasicSdkOptions
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import kotlin.js.Promise


@JsExport
object InternalSdkInitializers {
	fun initializeSdk(
		applicationId: String?,
		baseUrl: String,
		authenticationMethod: AuthenticationMethodJs,
		storageFacade: dynamic,
		options: SdkOptionsJs?
	): Promise<IcureSdkJs> = GlobalScope.promise {
		IcureSdkJsImpl(CardinalSdk.initialize(
			applicationId,
			baseUrl,
			authenticationMethod.toKt(),
			loadStorageOptions(storageFacade),
			options?.toKt() ?: SdkOptions(),
		))
	}

	fun initializeWithProcess(
		applicationId: String?,
		baseUrl: String,
		messageGatewayUrl: String,
		externalServicesSpecId: String,
		processId: String,
		userTelecomType: String,
		userTelecom: String,
		captchaType: String,
		captchaKey: String,
		baseStorage: dynamic,
		authenticationProcessTemplateParameters: AuthenticationProcessTemplateParametersJs?,
		options: SdkOptionsJs?
	): Promise<AuthenticationWithProcessStepJs> = GlobalScope.promise {
		val ktStep = CardinalSdk.initializeWithProcess(
			applicationId,
			baseUrl,
			messageGatewayUrl,
			externalServicesSpecId,
			processId,
			AuthenticationProcessTelecomType.valueOf(userTelecomType),
			userTelecom,
			AuthenticationProcessCaptchaType.valueOf(captchaType),
			captchaKey,
			loadStorageOptions(baseStorage),
			authenticationProcessTemplateParameters?.toKt() ?: AuthenticationProcessTemplateParameters(),
			options?.toKt() ?: SdkOptions()
		)
		object : AuthenticationWithProcessStepJs {
			override fun completeAuthentication(validationCode: String): Promise<IcureSdkJs> = GlobalScope.promise {
				IcureSdkJsImpl(ktStep.completeAuthentication(validationCode))
			}
		}
	}

	fun initializeBase(
		applicationId: String?,
		baseUrl: String,
		authenticationMethod: AuthenticationMethodJs,
		options: BasicSdkOptionsJs?
	): Promise<IcureBaseSdkJs> = GlobalScope.promise {
		IcureBaseSdkJsImpl(CardinalBaseSdk.initialize(
			applicationId,
			baseUrl,
			authenticationMethod.toKt(),
			options?.toKt() ?: BasicSdkOptions()
		))
	}
}

private class IcureSdkJsImpl(
	private val sdk: CardinalSdk
) : IcureSdkJs {
	override val applicationSettings: ApplicationSettingsApiJs by lazy { ApplicationSettingsApiImplJs(sdk.applicationSettings) }
	override val code: CodeApiJs by lazy { CodeApiImplJs(sdk.code) }
	override val device: DeviceApiJs by lazy { DeviceApiImplJs(sdk.device) }
	override val documentTemplate: DocumentTemplateApiJs by lazy { DocumentTemplateApiImplJs(sdk.documentTemplate) }
	override val entityReference: EntityReferenceApiJs by lazy { EntityReferenceApiImplJs(sdk.entityReference) }
	override val entityTemplate: EntityTemplateApiJs by lazy { EntityTemplateApiImplJs(sdk.entityTemplate) }
	override val frontEndMigration: FrontEndMigrationApiJs by lazy { FrontEndMigrationApiImplJs(sdk.frontEndMigration) }
	override val group: GroupApiJs by lazy { GroupApiImplJs(sdk.group) }
	override val healthcareParty: HealthcarePartyApiJs by lazy { HealthcarePartyApiImplJs(sdk.healthcareParty) }
	override val iCure: ICureApiJs by lazy { ICureApiImplJs(sdk.iCure) }
	override val insurance: InsuranceApiJs by lazy { InsuranceApiImplJs(sdk.insurance) }
	override val keyword: KeywordApiJs by lazy { KeywordApiImplJs(sdk.keyword) }
	override val permission: PermissionApiJs by lazy { PermissionApiImplJs(sdk.permission) }
	override val place: PlaceApiJs by lazy { PlaceApiImplJs(sdk.place) }
	override val role: RoleApiJs by lazy { RoleApiImplJs(sdk.role) }
	override val tarification: TarificationApiJs by lazy { TarificationApiImplJs(sdk.tarification) }
	override val user: UserApiJs by lazy { UserApiImplJs(sdk.user) }
	override val medicalLocationApi: MedicalLocationApiJs by lazy { MedicalLocationApiImplJs(sdk.medicalLocation) }
	override val agendaApi: AgendaApiJs by lazy { AgendaApiImplJs(sdk.agenda) }
	override val accessLog: AccessLogApiJs by lazy { AccessLogApiImplJs(sdk.accessLog) }
	override val calendarItem: CalendarItemApiJs by lazy { CalendarItemApiImplJs(sdk.calendarItem) }
	override val classification: ClassificationApiJs by lazy { ClassificationApiImplJs(sdk.classification) }
	override val contact: ContactApiJs by lazy { ContactApiImplJs(sdk.contact) }
	override val document: DocumentApiJs by lazy { DocumentApiImplJs(sdk.document) }
	override val form: FormApiJs by lazy { FormApiImplJs(sdk.form) }
	override val healthElement: HealthElementApiJs by lazy { HealthElementApiImplJs(sdk.healthElement) }
	override val invoice: InvoiceApiJs by lazy { InvoiceApiImplJs(sdk.invoice) }
	override val maintenanceTask: MaintenanceTaskApiJs by lazy { MaintenanceTaskApiImplJs(sdk.maintenanceTask) }
	override val message: MessageApiJs by lazy { MessageApiImplJs(sdk.message) }
	override val patient: PatientApiJs by lazy { PatientApiImplJs(sdk.patient) }
	override val receipt: ReceiptApiJs by lazy { ReceiptApiImplJs(sdk.receipt) }
	override val timeTable: TimeTableApiJs by lazy { TimeTableApiImplJs(sdk.timeTable) }
	override val topic: TopicApiJs by lazy { TopicApiImplJs(sdk.topic) }
	override val crypto: CryptoApiJs by lazy { CryptoApiImplJs(sdk.crypto) }
	override val recovery: RecoveryApiJs by lazy { RecoveryApiImplJs(sdk.recovery) }
	override val icureMaintenanceTask: IcureMaintenanceTaskApiJs by lazy { IcureMaintenanceTaskApiImplJs(sdk.icureMaintenanceTask) }
	override val dataOwner: DataOwnerApiJs by lazy { DataOwnerApiImplJs(sdk.dataOwner) }

	override fun switchGroup(groupId: String): Promise<IcureSdkJs> = GlobalScope.promise {
		IcureSdkJsImpl(sdk.switchGroup(groupId))
	}
}

private class IcureBaseSdkJsImpl(
	private val sdk: CardinalBaseSdk
) : IcureBaseSdkJs {
	override val applicationSettings: ApplicationSettingsApiJs by lazy { ApplicationSettingsApiImplJs(sdk.applicationSettings) }
	override val code: CodeApiJs by lazy { CodeApiImplJs(sdk.code) }
	override val device: DeviceApiJs by lazy { DeviceApiImplJs(sdk.device) }
	override val documentTemplate: DocumentTemplateApiJs by lazy { DocumentTemplateApiImplJs(sdk.documentTemplate) }
	override val entityReference: EntityReferenceApiJs by lazy { EntityReferenceApiImplJs(sdk.entityReference) }
	override val entityTemplate: EntityTemplateApiJs by lazy { EntityTemplateApiImplJs(sdk.entityTemplate) }
	override val frontEndMigration: FrontEndMigrationApiJs by lazy { FrontEndMigrationApiImplJs(sdk.frontEndMigration) }
	override val group: GroupApiJs by lazy { GroupApiImplJs(sdk.group) }
	override val healthcareParty: HealthcarePartyApiJs by lazy { HealthcarePartyApiImplJs(sdk.healthcareParty) }
	override val iCure: ICureApiJs by lazy { ICureApiImplJs(sdk.iCure) }
	override val insurance: InsuranceApiJs by lazy { InsuranceApiImplJs(sdk.insurance) }
	override val keyword: KeywordApiJs by lazy { KeywordApiImplJs(sdk.keyword) }
	override val permission: PermissionApiJs by lazy { PermissionApiImplJs(sdk.permission) }
	override val place: PlaceApiJs by lazy { PlaceApiImplJs(sdk.place) }
	override val role: RoleApiJs by lazy { RoleApiImplJs(sdk.role) }
	override val tarification: TarificationApiJs by lazy { TarificationApiImplJs(sdk.tarification) }
	override val user: UserApiJs by lazy { UserApiImplJs(sdk.user) }
	override val medicalLocationApi: MedicalLocationApiJs by lazy { MedicalLocationApiImplJs(sdk.medicalLocation) }
	override val agendaApi: AgendaApiJs by lazy { AgendaApiImplJs(sdk.agenda) }
	override val accessLog: AccessLogBasicApiJs by lazy { AccessLogBasicApiImplJs(sdk.accessLog) }
	override val calendarItem: CalendarItemBasicApiJs by lazy { CalendarItemBasicApiImplJs(sdk.calendarItem) }
	override val classification: ClassificationBasicApiJs by lazy { ClassificationBasicApiImplJs(sdk.classification) }
	override val contact: ContactBasicApiJs by lazy { ContactBasicApiImplJs(sdk.contact) }
	override val document: DocumentBasicApiJs by lazy { DocumentBasicApiImplJs(sdk.document) }
	override val form: FormBasicApiJs by lazy { FormBasicApiImplJs(sdk.form) }
	override val healthElement: HealthElementBasicApiJs by lazy { HealthElementBasicApiImplJs(sdk.healthElement) }
	override val invoice: InvoiceBasicApiJs by lazy { InvoiceBasicApiImplJs(sdk.invoice) }
	override val maintenanceTask: MaintenanceTaskBasicApiJs by lazy { MaintenanceTaskBasicApiImplJs(sdk.maintenanceTask) }
	override val message: MessageBasicApiJs by lazy { MessageBasicApiImplJs(sdk.message) }
	override val patient: PatientBasicApiJs by lazy { PatientBasicApiImplJs(sdk.patient) }
	override val receipt: ReceiptBasicApiJs by lazy { ReceiptBasicApiImplJs(sdk.receipt) }
	override val timeTable: TimeTableBasicApiJs by lazy { TimeTableBasicApiImplJs(sdk.timeTable) }
	override val topic: TopicBasicApiJs by lazy { TopicBasicApiImplJs(sdk.topic) }

	override fun switchGroup(groupId: String): Promise<IcureBaseSdkJs> = GlobalScope.promise {
		IcureBaseSdkJsImpl(sdk.switchGroup(groupId))
	}
}