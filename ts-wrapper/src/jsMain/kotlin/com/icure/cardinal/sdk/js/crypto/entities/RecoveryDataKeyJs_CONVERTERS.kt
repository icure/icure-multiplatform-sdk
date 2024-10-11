package com.icure.cardinal.sdk.js.crypto.entities

import com.icure.cardinal.sdk.crypto.entities.RecoveryDataKey

fun recoveryDataKey_toJs(recoveryDataKey: RecoveryDataKey): RecoveryDataKeyJs =
	RecoveryDataKeyJs_fromHexString(recoveryDataKey.asHexString().s)

fun recoveryDataKey_fromJs(recoveryDataKey: RecoveryDataKeyJs): RecoveryDataKey =
	RecoveryDataKey.fromHexString(recoveryDataKey.asHexString())