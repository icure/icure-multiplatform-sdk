// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api

import com.icure.kryptom.crypto.`external`.XRsaKeypair
import com.icure.sdk.js.crypto.entities.RecoveryResultJs
import com.icure.sdk.js.utils.Record
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("RecoveryApi")
public external interface RecoveryApiJs {
	public fun createRecoveryInfoForAvailableKeyPairs(includeParentsKeys: Boolean,
			lifetimeSeconds: Double?): Promise<String>

	public fun recoverKeyPairs(recoveryKey: String, autoDelete: Boolean):
			Promise<RecoveryResultJs<Record<String, Record<String, XRsaKeypair>>>>

	public fun createExchangeDataRecoveryInfo(delegateId: String, lifetimeSeconds: Double?):
			Promise<String>

	public fun recoverExchangeData(recoveryKey: String): Promise<String?>

	public fun deleteRecoveryInfo(recoveryKey: String): Promise<Unit>

	public fun deleteAllRecoveryInfoFor(dataOwnerId: String): Promise<Double>

	public fun deleteAllKeyPairRecoveryInfoFor(dataOwnerId: String): Promise<Double>

	public fun deleteAllExchangeDataRecoveryInfoFor(dataOwnerId: String): Promise<Double>
}
