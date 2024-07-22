package com.icure.sdk

import com.icure.sdk.api.ApplicationSettingsApi
import com.icure.sdk.api.CodeApi
import com.icure.sdk.api.CryptoApi
import com.icure.sdk.api.DeviceApi
import com.icure.sdk.api.DocumentTemplateApi
import com.icure.sdk.api.EntityReferenceApi
import com.icure.sdk.api.EntityTemplateApi
import com.icure.sdk.api.FrontEndMigrationApi
import com.icure.sdk.api.GroupApi
import com.icure.sdk.api.HealthcarePartyApi
import com.icure.sdk.api.ICureApi
import com.icure.sdk.api.InsuranceApi
import com.icure.sdk.api.KeywordApi
import com.icure.sdk.api.PermissionApi
import com.icure.sdk.api.PlaceApi
import com.icure.sdk.api.RecoveryApi
import com.icure.sdk.api.RoleApi
import com.icure.sdk.api.TarificationApi
import com.icure.sdk.api.UserApi
import com.icure.sdk.api.extended.DataOwnerApi
import com.icure.sdk.api.extended.IcureMaintenanceTaskApi
import com.icure.sdk.api.flavoured.AccessLogApi
import com.icure.sdk.api.flavoured.AccessLogBasicApi
import com.icure.sdk.api.flavoured.CalendarItemApi
import com.icure.sdk.api.flavoured.CalendarItemBasicApi
import com.icure.sdk.api.flavoured.ClassificationApi
import com.icure.sdk.api.flavoured.ClassificationBasicApi
import com.icure.sdk.api.flavoured.ContactApi
import com.icure.sdk.api.flavoured.ContactBasicApi
import com.icure.sdk.api.flavoured.DocumentApi
import com.icure.sdk.api.flavoured.DocumentBasicApi
import com.icure.sdk.api.flavoured.FormApi
import com.icure.sdk.api.flavoured.FormBasicApi
import com.icure.sdk.api.flavoured.HealthElementApi
import com.icure.sdk.api.flavoured.HealthElementBasicApi
import com.icure.sdk.api.flavoured.InvoiceApi
import com.icure.sdk.api.flavoured.InvoiceBasicApi
import com.icure.sdk.api.flavoured.MaintenanceTaskApi
import com.icure.sdk.api.flavoured.MaintenanceTaskBasicApi
import com.icure.sdk.api.flavoured.MessageApi
import com.icure.sdk.api.flavoured.MessageBasicApi
import com.icure.sdk.api.flavoured.PatientApi
import com.icure.sdk.api.flavoured.PatientBasicApi
import com.icure.sdk.api.flavoured.ReceiptApi
import com.icure.sdk.api.flavoured.ReceiptBasicApi
import com.icure.sdk.api.flavoured.TimeTableApi
import com.icure.sdk.api.flavoured.TimeTableBasicApi
import com.icure.sdk.api.flavoured.TopicApi
import com.icure.sdk.api.flavoured.TopicBasicApi

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
	val invoice: InvoiceApi
	val maintenanceTask: MaintenanceTaskApi
	val message: MessageApi
	val patient: PatientApi
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
	val invoice: InvoiceBasicApi
	val maintenanceTask: MaintenanceTaskBasicApi
	val message: MessageBasicApi
	val patient: PatientBasicApi
	val receipt: ReceiptBasicApi
	val timeTable: TimeTableBasicApi
	val topic: TopicBasicApi
}