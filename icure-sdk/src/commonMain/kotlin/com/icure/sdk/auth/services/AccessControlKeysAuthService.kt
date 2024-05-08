package com.icure.sdk.auth.services

import com.icure.sdk.auth.AuthenticationClass
import com.icure.sdk.crypto.impl.FullyCachedExchangeDataManager
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.request.HttpRequestBuilder

@InternalIcureApi
class AccessControlKeysAuthService(
	val accessControlKeysHeadersProvider: FullyCachedExchangeDataManager
) : AuthService {
	override suspend fun setAuthorizationInRequest(
		builder: HttpRequestBuilder,
		authenticationClass: AuthenticationClass?
	) {
		builder.headers[""] = ""
	}
}