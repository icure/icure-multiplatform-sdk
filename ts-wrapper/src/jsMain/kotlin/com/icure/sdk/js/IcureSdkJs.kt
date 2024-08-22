package com.icure.sdk.js

import com.icure.sdk.IcureSdk
import com.icure.sdk.js.api.extended.impl.DataOwnerApiImplJs
import com.icure.sdk.js.api.extended.impl.IcureMaintenanceTaskApiImplJs
import com.icure.sdk.js.api.flavoured.HealthElementApiJs
import com.icure.sdk.js.api.flavoured.impl.AccessLogApiImplJs
import com.icure.sdk.js.api.flavoured.impl.CalendarItemApiImplJs
import com.icure.sdk.js.api.flavoured.impl.ClassificationApiImplJs
import com.icure.sdk.js.api.flavoured.impl.ContactApiImplJs
import com.icure.sdk.js.api.flavoured.impl.DocumentApiImplJs
import com.icure.sdk.js.api.flavoured.impl.FormApiImplJs
import com.icure.sdk.js.api.flavoured.impl.HealthElementApiImplJs
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
import com.icure.sdk.js.externalsdk.IcureSdkJs
import com.icure.sdk.js.options.external.ApiOptionsJs
import com.icure.sdk.js.options.external.AuthenticationMethodJs
import com.icure.sdk.js.options.toKt
import com.icure.sdk.js.storage.loadStorageOptions
import com.icure.sdk.options.ApiOptions
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
		options: ApiOptionsJs?
	): Promise<IcureSdkJs> = GlobalScope.promise {
		IcureSdkJsImpl(IcureSdk.initialize(
			applicationId,
			baseUrl,
			authenticationMethod.toKt(),
			loadStorageOptions(storageFacade),
			options?.toKt() ?: ApiOptions(),
		))
	}
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
	override val healthcareElement: HealthElementApiJs by lazy { HealthElementApiImplJs(sdk.healthElement) }
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

	override fun switchGroup(groupId: String): Promise<IcureSdkJs> = GlobalScope.promise {
		IcureSdkJsImpl(sdk.switchGroup(groupId))
	}
}
