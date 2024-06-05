// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.extended

import com.icure.sdk.js.model.sdk.KeyPairUpdateNotificationJs
import kotlin.Array
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("IcureMaintenanceTaskApi")
public external interface IcureMaintenanceTaskApiJs {
	public fun applyKeyPairUpdate(updateRequest: KeyPairUpdateNotificationJs): Promise<Unit>

	public fun createKeyPairUpdateNotificationsToAllDelegationCounterparts(key: String,
			requestToOwnerTypes: Array<String>?): Promise<Unit>

	public fun createKeyPairUpdateNotificationTo(dataOwnerId: String, key: String): Promise<Unit>
}
