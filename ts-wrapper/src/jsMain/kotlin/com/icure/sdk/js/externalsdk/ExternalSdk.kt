@file:JsQualifier("sdk")
package com.icure.sdk.js.externalsdk

import com.icure.sdk.js.api.AgendaApiJs
import com.icure.sdk.js.api.ApplicationSettingsApiJs
import com.icure.sdk.js.api.CodeApiJs
import com.icure.sdk.js.api.CryptoApiJs
import com.icure.sdk.js.api.DeviceApiJs
import com.icure.sdk.js.api.DocumentTemplateApiJs
import com.icure.sdk.js.api.EntityReferenceApiJs
import com.icure.sdk.js.api.EntityTemplateApiJs
import com.icure.sdk.js.api.FrontEndMigrationApiJs
import com.icure.sdk.js.api.GroupApiJs
import com.icure.sdk.js.api.HealthcarePartyApiJs
import com.icure.sdk.js.api.ICureApiJs
import com.icure.sdk.js.api.InsuranceApiJs
import com.icure.sdk.js.api.KeywordApiJs
import com.icure.sdk.js.api.MedicalLocationApiJs
import com.icure.sdk.js.api.PermissionApiJs
import com.icure.sdk.js.api.PlaceApiJs
import com.icure.sdk.js.api.RecoveryApiJs
import com.icure.sdk.js.api.RoleApiJs
import com.icure.sdk.js.api.TarificationApiJs
import com.icure.sdk.js.api.UserApiJs
import com.icure.sdk.js.api.DataOwnerApiJs
import com.icure.sdk.js.api.IcureMaintenanceTaskApiJs
import com.icure.sdk.js.api.AccessLogApiJs
import com.icure.sdk.js.api.AccessLogBasicApiJs
import com.icure.sdk.js.api.CalendarItemApiJs
import com.icure.sdk.js.api.CalendarItemBasicApiJs
import com.icure.sdk.js.api.ClassificationApiJs
import com.icure.sdk.js.api.ClassificationBasicApiJs
import com.icure.sdk.js.api.ContactApiJs
import com.icure.sdk.js.api.ContactBasicApiJs
import com.icure.sdk.js.api.DocumentApiJs
import com.icure.sdk.js.api.DocumentBasicApiJs
import com.icure.sdk.js.api.FormApiJs
import com.icure.sdk.js.api.FormBasicApiJs
import com.icure.sdk.js.api.HealthElementApiJs
import com.icure.sdk.js.api.HealthElementBasicApiJs
import com.icure.sdk.js.api.InvoiceApiJs
import com.icure.sdk.js.api.InvoiceBasicApiJs
import com.icure.sdk.js.api.MaintenanceTaskApiJs
import com.icure.sdk.js.api.MaintenanceTaskBasicApiJs
import com.icure.sdk.js.api.MessageApiJs
import com.icure.sdk.js.api.MessageBasicApiJs
import com.icure.sdk.js.api.PatientApiJs
import com.icure.sdk.js.api.PatientBasicApiJs
import com.icure.sdk.js.api.ReceiptApiJs
import com.icure.sdk.js.api.ReceiptBasicApiJs
import com.icure.sdk.js.api.TimeTableApiJs
import com.icure.sdk.js.api.TimeTableBasicApiJs
import com.icure.sdk.js.api.TopicApiJs
import com.icure.sdk.js.api.TopicBasicApiJs
import kotlin.js.Promise

@JsName("IcureSdk")
external interface IcureSdkJs {
	val applicationSettings: ApplicationSettingsApiJs
	val code: CodeApiJs
	val device: DeviceApiJs
	val documentTemplate: DocumentTemplateApiJs
	val entityReference: EntityReferenceApiJs
	val entityTemplate: EntityTemplateApiJs
	val frontEndMigration: FrontEndMigrationApiJs
	val group: GroupApiJs
	val healthcareParty: HealthcarePartyApiJs
	val iCure: ICureApiJs
	val insurance: InsuranceApiJs
	val keyword: KeywordApiJs
	val permission: PermissionApiJs
	val place: PlaceApiJs
	val role: RoleApiJs
	val tarification: TarificationApiJs
	val user: UserApiJs
	val medicalLocationApi: MedicalLocationApiJs
	val agendaApi: AgendaApiJs
	val accessLog: AccessLogApiJs
	val calendarItem: CalendarItemApiJs
	val classification: ClassificationApiJs
	val contact: ContactApiJs
	val document: DocumentApiJs
	val form: FormApiJs
	val healthElement: HealthElementApiJs
	val invoice: InvoiceApiJs
	val maintenanceTask: MaintenanceTaskApiJs
	val message: MessageApiJs
	val patient: PatientApiJs
	val receipt: ReceiptApiJs
	val timeTable: TimeTableApiJs
	val topic: TopicApiJs
	val crypto: CryptoApiJs
	val recovery: RecoveryApiJs
	val icureMaintenanceTask: IcureMaintenanceTaskApiJs
	val dataOwner: DataOwnerApiJs

	fun switchGroup(groupId: String): Promise<IcureSdkJs>
}

@JsName("IcureBaseSdk")
external interface IcureBaseSdkJs {
	val applicationSettings: ApplicationSettingsApiJs
	val code: CodeApiJs
	val device: DeviceApiJs
	val documentTemplate: DocumentTemplateApiJs
	val entityReference: EntityReferenceApiJs
	val entityTemplate: EntityTemplateApiJs
	val frontEndMigration: FrontEndMigrationApiJs
	val group: GroupApiJs
	val healthcareParty: HealthcarePartyApiJs
	val iCure: ICureApiJs
	val insurance: InsuranceApiJs
	val keyword: KeywordApiJs
	val permission: PermissionApiJs
	val place: PlaceApiJs
	val role: RoleApiJs
	val tarification: TarificationApiJs
	val user: UserApiJs
	val medicalLocationApi: MedicalLocationApiJs
	val agendaApi: AgendaApiJs
	val accessLog: AccessLogBasicApiJs
	val calendarItem: CalendarItemBasicApiJs
	val classification: ClassificationBasicApiJs
	val contact: ContactBasicApiJs
	val document: DocumentBasicApiJs
	val form: FormBasicApiJs
	val healthElement: HealthElementBasicApiJs
	val invoice: InvoiceBasicApiJs
	val maintenanceTask: MaintenanceTaskBasicApiJs
	val message: MessageBasicApiJs
	val patient: PatientBasicApiJs
	val receipt: ReceiptBasicApiJs
	val timeTable: TimeTableBasicApiJs
	val topic: TopicBasicApiJs

	fun switchGroup(groupId: String): Promise<IcureBaseSdkJs>
}
