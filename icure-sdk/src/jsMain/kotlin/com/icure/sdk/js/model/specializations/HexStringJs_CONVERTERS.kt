package com.icure.sdk.js.model.specializations

import com.icure.sdk.model.specializations.HexString
import kotlin.String

public fun hexString_toJs(obj: HexString): String = obj.s

public fun hexString_fromJs(obj: String): HexString = HexString(obj)