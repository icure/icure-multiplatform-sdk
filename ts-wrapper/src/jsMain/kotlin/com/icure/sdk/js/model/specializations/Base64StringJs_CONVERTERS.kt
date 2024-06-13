package com.icure.sdk.js.model.specializations

import com.icure.sdk.model.specializations.Base64String
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun base64String_toJs(obj: Base64String): String = obj.s

public fun base64String_fromJs(obj: String): Base64String = Base64String(obj)
