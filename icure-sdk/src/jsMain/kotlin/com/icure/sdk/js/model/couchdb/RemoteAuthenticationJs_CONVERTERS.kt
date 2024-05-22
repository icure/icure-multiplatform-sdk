package com.icure.sdk.js.model.couchdb

import com.icure.sdk.model.couchdb.RemoteAuthentication

public fun remoteAuthentication_toJs(obj: RemoteAuthentication): RemoteAuthenticationJs {
	val basic = obj.basic?.let { nonNull1 ->
		basic_toJs(nonNull1)
	}
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
