package com.icure.sdk.js.model.specializations

import com.icure.sdk.model.specializations.Sha256HexString
import kotlin.String

public fun sha256HexString_toJs(obj: Sha256HexString): String = obj.s

public fun sha256HexString_fromJs(obj: String): Sha256HexString = Sha256HexString(obj)
