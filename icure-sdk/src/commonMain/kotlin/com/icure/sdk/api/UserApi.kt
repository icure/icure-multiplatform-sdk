package com.icure.sdk.api

import com.icure.sdk.api.raw.RawUserApi
import com.icure.sdk.model.User
import com.icure.sdk.utils.InternalIcureApi

@OptIn(InternalIcureApi::class)
class UserApi(
	private val raw: RawUserApi
) {
	suspend fun getCurrentUser(): User =
		raw.getCurrentUser().successBody()
}
