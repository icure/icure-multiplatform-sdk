// auto-generated file
package com.icure.sdk.js.crypto.entities

import com.icure.sdk.crypto.entities.ShamirUpdateRequest
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.intToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.setToArray
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun shamirUpdateRequest_toJs(obj: ShamirUpdateRequest): ShamirUpdateRequestJs {
	val notariesIds = setToArray(
		obj.notariesIds,
		{ x1: String ->
			x1
		},
	)
	val minShares = intToNumber(obj.minShares)
	return ShamirUpdateRequestJs(js("{" +
		"notariesIds:notariesIds," +
		"minShares:minShares" +
	"}"))
}

public fun shamirUpdateRequest_fromJs(obj: ShamirUpdateRequestJs): ShamirUpdateRequest {
	val notariesIds = arrayToSet(
		obj.notariesIds,
		"obj.notariesIds",
		{ x1: String ->
			x1
		},
	)
	val minShares = numberToInt(obj.minShares, "obj.minShares")
	return ShamirUpdateRequest(
		notariesIds = notariesIds,
		minShares = minShares,
	)
}
