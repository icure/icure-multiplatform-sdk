// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.RecoveryDataKeyJs
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
	public fun createRecoveryInfoForAvailableKeyPairs(options: dynamic): Promise<RecoveryDataKeyJs>

	public fun recoverKeyPairs(recoveryKey: RecoveryDataKeyJs, autoDelete: Boolean):
			Promise<RecoveryResultJs<Record<String, Record<String, XRsaKeypair>>>>

	public fun createExchangeDataRecoveryInfo(delegateId: String, options: dynamic):
			Promise<RecoveryDataKeyJs>

	public fun recoverExchangeData(recoveryKey: RecoveryDataKeyJs): Promise<String?>

	public fun purgeRecoveryInfo(recoveryKey: RecoveryDataKeyJs): Promise<Unit>

	public fun deleteAllRecoveryInfoFor(dataOwnerId: String): Promise<Double>

	public fun deleteAllKeyPairRecoveryInfoFor(dataOwnerId: String): Promise<Double>

	public fun deleteAllExchangeDataRecoveryInfoFor(dataOwnerId: String): Promise<Double>
}
