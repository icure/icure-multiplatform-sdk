package com.icure.sdk.api.raw

import com.icure.sdk.utils.InternalIcureApi
import kotlin.String

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawAuthApi {
	// region common endpoints

	suspend fun token(
		method: String,
		path: String,
	): HttpResponse<String>
	// endregion
}
