package com.icure.sdk.js

import com.icure.sdk.IcureSdk
import com.icure.sdk.auth.UsernamePassword
import com.icure.sdk.crypto.impl.BasicCryptoStrategies
import com.icure.sdk.js.api.CryptoApiJs
import com.icure.sdk.js.api.DeviceApiJs
import com.icure.sdk.js.api.PermissionApiJs
import com.icure.sdk.js.api.RecoveryApiJs
import com.icure.sdk.js.api.UserApiJs
import com.icure.sdk.js.api.extended.DataOwnerApiJs
import com.icure.sdk.js.api.extended.IcureMaintenanceTaskApiJs
import com.icure.sdk.js.api.extended.impl.DataOwnerApiImplJs
import com.icure.sdk.js.api.extended.impl.IcureMaintenanceTaskApiImplJs
import com.icure.sdk.js.api.flavoured.AccessLogApiJs
import com.icure.sdk.js.api.flavoured.CalendarItemApiJs
import com.icure.sdk.js.api.flavoured.ClassificationApiJs
import com.icure.sdk.js.api.flavoured.ContactApiJs
import com.icure.sdk.js.api.flavoured.DocumentApiJs
import com.icure.sdk.js.api.flavoured.FormApiJs
import com.icure.sdk.js.api.flavoured.HealthcareElementApiJs
import com.icure.sdk.js.api.flavoured.InvoiceApiJs
import com.icure.sdk.js.api.flavoured.MaintenanceTaskApiJs
import com.icure.sdk.js.api.flavoured.MessageApiJs
import com.icure.sdk.js.api.flavoured.PatientApiJs
import com.icure.sdk.js.api.flavoured.ReceiptApiJs
import com.icure.sdk.js.api.flavoured.TimeTableApiJs
import com.icure.sdk.js.api.flavoured.TopicApiJs
import com.icure.sdk.js.api.flavoured.impl.AccessLogApiImplJs
import com.icure.sdk.js.api.flavoured.impl.CalendarItemApiImplJs
import com.icure.sdk.js.api.flavoured.impl.ClassificationApiImplJs
import com.icure.sdk.js.api.flavoured.impl.ContactApiImplJs
import com.icure.sdk.js.api.flavoured.impl.DocumentApiImplJs
import com.icure.sdk.js.api.flavoured.impl.FormApiImplJs
import com.icure.sdk.js.api.flavoured.impl.HealthcareElementApiImplJs
import com.icure.sdk.js.api.flavoured.impl.InvoiceApiImplJs
import com.icure.sdk.js.api.flavoured.impl.MaintenanceTaskApiImplJs
import com.icure.sdk.js.api.flavoured.impl.MessageApiImplJs
import com.icure.sdk.js.api.flavoured.impl.PatientApiImplJs
import com.icure.sdk.js.api.flavoured.impl.ReceiptApiImplJs
import com.icure.sdk.js.api.flavoured.impl.TimeTableApiImplJs
import com.icure.sdk.js.api.flavoured.impl.TopicApiImplJs
import com.icure.sdk.js.api.impl.CryptoApiImplJs
import com.icure.sdk.js.api.impl.DeviceApiImplJs
import com.icure.sdk.js.api.impl.PermissionApiImplJs
import com.icure.sdk.js.api.impl.RecoveryApiImplJs
import com.icure.sdk.js.api.impl.UserApiImplJs
import com.icure.sdk.js.options.ApiOptionsJs
import com.icure.sdk.js.options.toKt
import com.icure.sdk.options.AuthenticationMethod
import com.icure.sdk.storage.impl.VolatileStorageFacade
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import kotlin.js.Promise

/**
 * SDK for pure typescript. You should not use this from kotlin.
 */
@JsExport
@JsName("IcureSdk")
interface IcureSdkJs {
	val accessLog: AccessLogApiJs
	val calendarItem: CalendarItemApiJs
	val classification: ClassificationApiJs
	val contact: ContactApiJs
	val device: DeviceApiJs
	val document: DocumentApiJs
	val form: FormApiJs
	val healthcareElement: HealthcareElementApiJs
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
}

/**
 * Provides access to the SDK from pure typescript. You should not use this from kotlin.
 */
@JsExport
fun initialiseSdk(
	baseUrl: String,
	username: String,
	password: String,
	options: ApiOptionsJs
): Promise<IcureSdkJs> = GlobalScope.promise {
	IcureSdkJsImpl(IcureSdk.initialise(
		baseUrl,
		AuthenticationMethod.UsingCredentials(UsernamePassword(username, password)),
		VolatileStorageFacade(),
		BasicCryptoStrategies,
		options.toKt()
	))
}

private class IcureSdkJsImpl(
	private val sdk: IcureSdk
) : IcureSdkJs {
	override val accessLog by lazy { AccessLogApiImplJs(sdk.accessLog) }
	override val calendarItem by lazy { CalendarItemApiImplJs(sdk.calendarItem) }
	override val classification by lazy { ClassificationApiImplJs(sdk.classification) }
	override val contact by lazy { ContactApiImplJs(sdk.contact) }
	override val device by lazy { DeviceApiImplJs(sdk.device) }
	override val document by lazy { DocumentApiImplJs(sdk.document) }
	override val form by lazy { FormApiImplJs(sdk.form) }
	override val healthcareElement by lazy { HealthcareElementApiImplJs(sdk.healthElement) }
	override val invoice by lazy { InvoiceApiImplJs(sdk.invoice) }
	override val maintenanceTask by lazy { MaintenanceTaskApiImplJs(sdk.maintenanceTask) }
	override val message by lazy { MessageApiImplJs(sdk.message) }
	override val patient by lazy { PatientApiImplJs(sdk.patient) }
	override val permission by lazy { PermissionApiImplJs(sdk.permission) }
	override val receipt by lazy { ReceiptApiImplJs(sdk.receipt) }
	override val timeTable by lazy { TimeTableApiImplJs(sdk.timeTable) }
	override val topic by lazy { TopicApiImplJs(sdk.topic) }
	override val crypto by lazy { CryptoApiImplJs(sdk.crypto) }
	override val dataOwner by lazy { DataOwnerApiImplJs(sdk.dataOwner) }
	override val user by lazy { UserApiImplJs(sdk.user) }
	override val icureMaintenanceTask by lazy { IcureMaintenanceTaskApiImplJs(sdk.icureMaintenanceTask) }
	override val recovery by lazy { RecoveryApiImplJs(sdk.recovery) }
}
