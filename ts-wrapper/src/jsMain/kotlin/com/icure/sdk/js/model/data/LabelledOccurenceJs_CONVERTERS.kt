// auto-generated file
package com.icure.sdk.js.model.`data`

import com.icure.sdk.js.model.CheckedConverters.longToNumber
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.model.`data`.LabelledOccurence
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun labelledOccurence_toJs(obj: LabelledOccurence): LabelledOccurenceJs {
	val label = obj.label
	val occurence = longToNumber(obj.occurence)
	return LabelledOccurenceJs(js("{" +
		"label:label," +
		"occurence:occurence" +
	"}"))
}

public fun labelledOccurence_fromJs(obj: LabelledOccurenceJs): LabelledOccurence {
	val label = obj.label
	val occurence = numberToLong(obj.occurence, "obj.occurence")
	return LabelledOccurence(
		label = label,
		occurence = occurence,
	)
}
