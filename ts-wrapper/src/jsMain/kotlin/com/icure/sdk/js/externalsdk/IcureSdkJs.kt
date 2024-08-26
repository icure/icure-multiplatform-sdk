@file:JsQualifier("sdk")
package com.icure.sdk.js.externalsdk

import com.icure.sdk.js.api.AccessLogApiJs
import com.icure.sdk.js.api.CalendarItemApiJs
import com.icure.sdk.js.api.ClassificationApiJs
import com.icure.sdk.js.api.ContactApiJs
import com.icure.sdk.js.api.CryptoApiJs
import com.icure.sdk.js.api.DataOwnerApiJs
import com.icure.sdk.js.api.DeviceApiJs
import com.icure.sdk.js.api.DocumentApiJs
import com.icure.sdk.js.api.FormApiJs
import com.icure.sdk.js.api.HealthElementApiJs
import com.icure.sdk.js.api.IcureMaintenanceTaskApiJs
import com.icure.sdk.js.api.InvoiceApiJs
import com.icure.sdk.js.api.MaintenanceTaskApiJs
import com.icure.sdk.js.api.MessageApiJs
import com.icure.sdk.js.api.PatientApiJs
import com.icure.sdk.js.api.PermissionApiJs
import com.icure.sdk.js.api.ReceiptApiJs
import com.icure.sdk.js.api.RecoveryApiJs
import com.icure.sdk.js.api.TimeTableApiJs
import com.icure.sdk.js.api.TopicApiJs
import com.icure.sdk.js.api.UserApiJs
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