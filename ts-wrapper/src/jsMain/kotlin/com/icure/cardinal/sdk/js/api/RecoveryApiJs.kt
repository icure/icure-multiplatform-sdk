// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.RecoveryResultJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.kryptom.crypto.`external`.XRsaKeypair
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("RecoveryApi")
public external interface RecoveryApiJs {
	public fun createRecoveryInfoForAvailableKeyPairs(options: dynamic): Promise<String>

	public fun recoverKeyPairs(recoveryKey: String, autoDelete: Boolean):
			Promise<RecoveryResultJs<Record<String, Record<String, XRsaKeypair>>>>

	public fun createExchangeDataRecoveryInfo(delegateId: String, options: dynamic): Promise<String>

	public fun recoverExchangeData(recoveryKey: String): Promise<String?>

	public fun purgeRecoveryInfo(recoveryKey: String): Promise<Unit>

	public fun deleteAllRecoveryInfoFor(dataOwnerId: String): Promise<Double>

	public fun deleteAllKeyPairRecoveryInfoFor(dataOwnerId: String): Promise<Double>

	public fun deleteAllExchangeDataRecoveryInfoFor(dataOwnerId: String): Promise<Double>
}
