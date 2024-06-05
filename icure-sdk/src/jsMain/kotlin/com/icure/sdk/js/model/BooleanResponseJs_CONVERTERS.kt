package com.icure.sdk.js.model

import com.icure.sdk.model.BooleanResponse

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
