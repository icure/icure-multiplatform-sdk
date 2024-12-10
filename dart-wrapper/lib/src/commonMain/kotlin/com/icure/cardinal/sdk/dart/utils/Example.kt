package com.icure.cardinal.sdk.dart.utils

import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object Example {
	fun doMethodWithCallback(
		dartResultCallback: (
			String?,
			String?,
			String?,
			String?,
		) -> Unit,
		callbackId: String,
		param: String
	) {
		ApiScope.execute(
			dartResultCallback,
			String.serializer(),
		) {
			"Got from dart: ${DartCallbacksHandler.registered.invoke(
				callbackId,
				Json.encodeToString(mapOf("callbackParam" to param.uppercase()))
			)}"
		}
	}
}