// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.CheckedConverters.intToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.mapToObject
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMapNullsafe
import com.icure.cardinal.sdk.model.IndexingInfo
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun indexingInfo_toJs(obj: IndexingInfo): IndexingInfoJs {
	val statuses = nullToUndefined(
		mapToObject(
			obj.statuses,
			{ x1: String ->
				x1
			},
			{ x1: Int ->
				intToNumber(x1)
			},
		)
	)
	return IndexingInfoJs(js("{" +
		"statuses:statuses" +
	"}"))
}

public fun indexingInfo_fromJs(obj: IndexingInfoJs): IndexingInfo {
	val statuses = objectToMapNullsafe(
		obj.statuses,
		"obj.statuses",
		{ x1: String ->
			x1
		},
		{ x1: Double ->
			numberToInt(x1, "x1")
		},
	)
	return IndexingInfo(
		statuses = statuses,
	)
}
