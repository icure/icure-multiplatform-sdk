@file:JsQualifier("sdk")
package com.icure.sdk.js.externalsdk

import com.icure.sdk.js.api.CryptoApiJs
import com.icure.sdk.js.api.DeviceApiJs
import com.icure.sdk.js.api.PermissionApiJs
import com.icure.sdk.js.api.RecoveryApiJs
import com.icure.sdk.js.api.UserApiJs
import com.icure.sdk.js.api.extended.DataOwnerApiJs
import com.icure.sdk.js.api.extended.IcureMaintenanceTaskApiJs
import com.icure.sdk.js.api.flavoured.AccessLogApiJs
import com.icure.sdk.js.api.flavoured.CalendarItemApiJs
import com.icure.sdk.js.api.flavoured.ClassificationApiJs
import com.icure.sdk.js.api.flavoured.ContactApiJs
import com.icure.sdk.js.api.flavoured.DocumentApiJs
import com.icure.sdk.js.api.flavoured.FormApiJs
import com.icure.sdk.js.api.flavoured.HealthElementApiJs
import com.icure.sdk.js.api.flavoured.InvoiceApiJs
import com.icure.sdk.js.api.flavoured.MaintenanceTaskApiJs
import com.icure.sdk.js.api.flavoured.MessageApiJs
import com.icure.sdk.js.api.flavoured.PatientApiJs
import com.icure.sdk.js.api.flavoured.ReceiptApiJs
import com.icure.sdk.js.api.flavoured.TimeTableApiJs
import com.icure.sdk.js.api.flavoured.TopicApiJs
import kotlin.js.Promise

/**
 * SDK for pure typescript. You should not use this from kotlin.
 */
@JsName("IcureSdk")
external interface IcureSdkJs {
	val accessLog: AccessLogApiJs
	val calendarItem: CalendarItemApiJs
	val classification: ClassificationApiJs
	val contact: ContactApiJs
	val device: DeviceApiJs
	val document: DocumentApiJs
	val form: FormApiJs
	val healthcareElement: HealthElementApiJs
	val invoice: InvoiceApiJs
	val maintenanceTask: MaintenanceTaskApiJs
	val message: MessageApiJs
	val patient: PatientApiJs
	val permission: PermissionApiJs
	val receipt: ReceiptApiJs
	val timeTable: TimeTableApiJs
	val topic: TopicApiJs
	val crypto: CryptoApiJs
	val dataOwner: DataOwnerApiJs
	val user: UserApiJs
	val icureMaintenanceTask: IcureMaintenanceTaskApiJs
	val recovery: RecoveryApiJs

	fun switchGroup(groupId: String): Promise<IcureSdkJs>
}