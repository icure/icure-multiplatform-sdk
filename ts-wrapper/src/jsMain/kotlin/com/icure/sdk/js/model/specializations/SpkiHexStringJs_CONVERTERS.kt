package com.icure.sdk.js.model.specializations

import com.icure.sdk.model.specializations.SpkiHexString
import kotlin.String

public fun spkiHexString_toJs(obj: SpkiHexString): String = obj.s

public fun spkiHexString_fromJs(obj: String): SpkiHexString = SpkiHexString(obj)
