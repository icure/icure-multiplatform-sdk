// auto-generated file
package com.icure.cardinal.sdk.js.model.couchdb

import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.model.couchdb.RemoteAuthentication
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun remoteAuthentication_toJs(obj: RemoteAuthentication): RemoteAuthenticationJs {
	val basic = nullToUndefined(
		obj.basic?.let { nonNull1 ->
			basic_toJs(nonNull1)
		}
	)
	return RemoteAuthenticationJs(js("{" +
		"basic:basic" +
	"}"))
}

public fun remoteAuthentication_fromJs(obj: RemoteAuthenticationJs): RemoteAuthentication {
	val basic = obj.basic?.let { nonNull1 ->
		basic_fromJs(nonNull1)
	}
	return RemoteAuthentication(
		basic = basic,
	)
}
