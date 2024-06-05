// auto-generated file
package com.icure.sdk.js.api.extended.`impl`

import com.icure.sdk.api.extended.IcureMaintenanceTaskApi
import com.icure.sdk.js.api.extended.IcureMaintenanceTaskApiJs
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.sdk.KeyPairUpdateNotificationJs
import com.icure.sdk.js.model.sdk.keyPairUpdateNotification_fromJs
import com.icure.sdk.js.model.specializations.spkiHexString_fromJs
import com.icure.sdk.model.DataOwnerType
import kotlin.Array
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class IcureMaintenanceTaskApiImplJs(
	private val icureMaintenanceTaskApi: IcureMaintenanceTaskApi,
) : IcureMaintenanceTaskApiJs {
	override fun applyKeyPairUpdate(updateRequest: KeyPairUpdateNotificationJs): Promise<Unit> =
			GlobalScope.promise {
		icureMaintenanceTaskApi.applyKeyPairUpdate(keyPairUpdateNotification_fromJs(updateRequest))}


	override fun createKeyPairUpdateNotificationsToAllDelegationCounterparts(key: String,
			requestToOwnerTypes: Array<String>?): Promise<Unit> = GlobalScope.promise {
		icureMaintenanceTaskApi.createKeyPairUpdateNotificationsToAllDelegationCounterparts(spkiHexString_fromJs(key),
				arrayToSet(
			requestToOwnerTypes,
			"requestToOwnerTypes",
			{ x1: String ->
				DataOwnerType.valueOf(x1)
			},
		))}


	override fun createKeyPairUpdateNotificationTo(dataOwnerId: String, key: String): Promise<Unit> =
			GlobalScope.promise {
		icureMaintenanceTaskApi.createKeyPairUpdateNotificationTo(dataOwnerId, spkiHexString_fromJs(key))}

}
