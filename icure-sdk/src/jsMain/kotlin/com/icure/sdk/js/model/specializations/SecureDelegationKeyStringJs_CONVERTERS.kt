package com.icure.sdk.js.model.specializations

import com.icure.sdk.model.specializations.SecureDelegationKeyString
import kotlin.String

public fun secureDelegationKeyString_toJs(obj: SecureDelegationKeyString): String = obj.s

public fun secureDelegationKeyString_fromJs(obj: String): SecureDelegationKeyString =
		SecureDelegationKeyString(obj)