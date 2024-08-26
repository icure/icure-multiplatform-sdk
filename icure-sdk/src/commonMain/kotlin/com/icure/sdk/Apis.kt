package com.icure.sdk

import com.icure.sdk.api.AccessLogApi
import com.icure.sdk.api.AccessLogBasicApi
import com.icure.sdk.api.AgendaApi
import com.icure.sdk.api.ApplicationSettingsApi
import com.icure.sdk.api.CalendarItemApi
import com.icure.sdk.api.CalendarItemBasicApi
import com.icure.sdk.api.ClassificationApi
import com.icure.sdk.api.ClassificationBasicApi
import com.icure.sdk.api.CodeApi
import com.icure.sdk.api.ContactApi
import com.icure.sdk.api.ContactBasicApi
import com.icure.sdk.api.CryptoApi
import com.icure.sdk.api.DataOwnerApi
import com.icure.sdk.api.DeviceApi
import com.icure.sdk.api.DocumentApi
import com.icure.sdk.api.DocumentBasicApi
import com.icure.sdk.api.DocumentTemplateApi
import com.icure.sdk.api.EntityReferenceApi
import com.icure.sdk.api.EntityTemplateApi
import com.icure.sdk.api.FormApi
import com.icure.sdk.api.FormBasicApi
import com.icure.sdk.api.FrontEndMigrationApi
import com.icure.sdk.api.GroupApi
import com.icure.sdk.api.HealthElementApi
import com.icure.sdk.api.HealthElementBasicApi
import com.icure.sdk.api.HealthcarePartyApi
import com.icure.sdk.api.ICureApi
import com.icure.sdk.api.IcureMaintenanceTaskApi
import com.icure.sdk.api.InsuranceApi
import com.icure.sdk.api.InvoiceApi
import com.icure.sdk.api.InvoiceBasicApi
import com.icure.sdk.api.KeywordApi
import com.icure.sdk.api.MaintenanceTaskApi
import com.icure.sdk.api.MaintenanceTaskBasicApi
import com.icure.sdk.api.MedicalLocationApi
import com.icure.sdk.api.MessageApi
import com.icure.sdk.api.MessageBasicApi
import com.icure.sdk.api.PatientApi
import com.icure.sdk.api.PatientBasicApi
import com.icure.sdk.api.PermissionApi
import com.icure.sdk.api.PlaceApi
import com.icure.sdk.api.ReceiptApi
import com.icure.sdk.api.ReceiptBasicApi
import com.icure.sdk.api.RecoveryApi
import com.icure.sdk.api.RoleApi
import com.icure.sdk.api.TarificationApi
import com.icure.sdk.api.TimeTableApi
import com.icure.sdk.api.TimeTableBasicApi
import com.icure.sdk.api.TopicApi
import com.icure.sdk.api.TopicBasicApi
import com.icure.sdk.api.UserApi

/**
 * Apis that are completely independent of the cryptographic context.
 */
interface IcureNonCryptoApis {
	// api root
	val applicationSettings: ApplicationSettingsApi
	val code: CodeApi
	val device: DeviceApi
	val documentTemplate: DocumentTemplateApi
	val entityReference: EntityReferenceApi
	val entityTemplate: EntityTemplateApi
	val frontEndMigration: FrontEndMigrationApi
	val group: GroupApi
	val healthcareParty: HealthcarePartyApi
	val iCure: ICureApi
	val insurance: InsuranceApi
	val keyword: KeywordApi
	val permission: PermissionApi
	val place: PlaceApi
	val role: RoleApi
	val tarification: TarificationApi
	val user: UserApi
	val medicalLocation: MedicalLocationApi
	val agenda: AgendaApi
}

/**
 * Adds to [IcureNonCryptoApis] the apis that require a data owner cryptographic context.
 * The apis added by this interface can only be used if the logged user is a data owner.
 */
interface IcureApis : IcureNonCryptoApis {
	// flavoured
	val accessLog: AccessLogApi
	val calendarItem: CalendarItemApi
	val classification: ClassificationApi
	val contact: ContactApi
	val document: DocumentApi
	val form: FormApi
	val healthElement: HealthElementApi
	@Deprecated("The invoice API and model are highly specialised for the belgian market. They will be provided as a separate package in future")
	val invoice: InvoiceApi
	val maintenanceTask: MaintenanceTaskApi
	val message: MessageApi
	val patient: PatientApi
	@Deprecated("The receipt API and model are highly specialised for the belgian market. They will be provided as a separate package in future")
	val receipt: ReceiptApi
	val timeTable: TimeTableApi
	val topic: TopicApi
	// api root
	val crypto: CryptoApi
	val recovery: RecoveryApi
	// extended
	val icureMaintenanceTask: IcureMaintenanceTaskApi
	val dataOwner: DataOwnerApi
}

/**
 * Adds to [IcureNonCryptoApis] the apis that require a limited cryptographic context, for example only the information
 * about which fields need to be encrypted for each entity, but there is no need to perform any actual cryptographic
 * operations.
 * The apis added by this interface can only be used even if the logged user is not a data owner
 */
interface IcureBaseApis : IcureNonCryptoApis {
	val accessLog: AccessLogBasicApi
	val calendarItem: CalendarItemBasicApi
	val classification: ClassificationBasicApi
	val contact: ContactBasicApi
	val document: DocumentBasicApi
	val form: FormBasicApi
	val healthElement: HealthElementBasicApi
	@Deprecated("The invoice API and model are highly specialised for the belgian market. They will be provided as a separate package in future")
	val invoice: InvoiceBasicApi
	val maintenanceTask: MaintenanceTaskBasicApi
	val message: MessageBasicApi
	val patient: PatientBasicApi
	@Deprecated("The receipt API and model are highly specialised for the belgian market. They will be provided as a separate package in future")
	val receipt: ReceiptBasicApi
	val timeTable: TimeTableBasicApi
	val topic: TopicBasicApi
}