// auto-generated file
package com.icure.cardinal.sdk.js.model.couchdb

import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.model.couchdb.View
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun view_toJs(obj: View): ViewJs {
	val map = obj.map
	val reduce = nullToUndefined(
		obj.reduce
	)
	return ViewJs(js("{" +
		"map:map," +
		"reduce:reduce" +
	"}"))
}

public fun view_fromJs(obj: ViewJs): View {
	val map = obj.map
	val reduce = undefinedToNull(obj.reduce)
	return View(
		map = map,
		reduce = reduce,
	)
}
