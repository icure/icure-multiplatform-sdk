package com.icure.sdk.js.model.couchdb

import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.model.couchdb.Remote
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun remote_toJs(obj: Remote): RemoteJs {
	val url = obj.url
	val auth = nullToUndefined(
		obj.auth?.let { nonNull1 ->
			remoteAuthentication_toJs(nonNull1)
		}
	)
	return RemoteJs(js("{" +
		"url:url," +
		"auth:auth" +
	"}"))
}

public fun remote_fromJs(obj: RemoteJs): Remote {
	val url = obj.url
	val auth = obj.auth?.let { nonNull1 ->
		remoteAuthentication_fromJs(nonNull1)
	}
	return Remote(
		url = url,
		auth = auth,
	)
}
