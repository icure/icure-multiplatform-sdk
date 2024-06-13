package com.icure.sdk.js.crypto.entities

import com.icure.sdk.crypto.entities.RecoveryDataKey
import com.icure.sdk.js.model.specializations.hexString_fromJs
import com.icure.sdk.js.model.specializations.hexString_toJs
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun recoveryDataKey_toJs(obj: RecoveryDataKey): String = hexString_toJs(obj.hex)

public fun recoveryDataKey_fromJs(obj: String): RecoveryDataKey =
		RecoveryDataKey(hexString_fromJs(obj))
