package com.icure.sdk.js.model.couchdb

import com.icure.sdk.model.couchdb.View
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun view_toJs(obj: View): ViewJs {
	val map = obj.map
	val reduce = obj.reduce
	return ViewJs(js("{" +
		"map:map," +
		"reduce:reduce" +
	"}"))
}

public fun view_fromJs(obj: ViewJs): View {
	val map = obj.map
	val reduce = obj.reduce
	return View(
		map = map,
		reduce = reduce,
	)
}
