// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.model.BooleanResponse
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun booleanResponse_toJs(obj: BooleanResponse): BooleanResponseJs {
	val response = obj.response
	return BooleanResponseJs(js("{" +
		"response:response" +
	"}"))
}

public fun booleanResponse_fromJs(obj: BooleanResponseJs): BooleanResponse {
	val response = obj.response
	return BooleanResponse(
		response = response,
	)
}
