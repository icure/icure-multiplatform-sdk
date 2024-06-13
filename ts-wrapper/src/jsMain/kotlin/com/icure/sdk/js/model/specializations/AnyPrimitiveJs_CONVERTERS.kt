package com.icure.sdk.js.model.specializations

import com.icure.sdk.model.specializations.AnyPrimitive
import kotlin.Any
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun anyPrimitive_toJs(obj: AnyPrimitive): Any = obj.v

public fun anyPrimitive_fromJs(obj: Any): AnyPrimitive = AnyPrimitive(obj)
