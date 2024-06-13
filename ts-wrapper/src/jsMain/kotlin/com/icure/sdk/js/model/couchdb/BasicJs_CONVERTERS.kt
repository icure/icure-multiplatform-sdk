package com.icure.sdk.js.model.couchdb

import com.icure.sdk.model.couchdb.Basic
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun basic_toJs(obj: Basic): BasicJs {
	val username = obj.username
	val password = obj.password
	return BasicJs(js("{" +
		"username:username," +
		"password:password" +
	"}"))
}

public fun basic_fromJs(obj: BasicJs): Basic {
	val username = obj.username
	val password = obj.password
	return Basic(
		username = username,
		password = password,
	)
}
