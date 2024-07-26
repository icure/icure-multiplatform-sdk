package com.icure.sdk.auth.services

import com.icure.sdk.auth.ServerAuthenticationClass
import com.icure.sdk.crypto.impl.FullyCachedExchangeDataManager
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.RequestStatusException
import io.ktor.client.request.HttpRequestBuilder

@InternalIcureApi
class AccessControlKeysAuthService(
	val accessControlKeysHeadersProvider: FullyCachedExchangeDataManager
) : AuthService, AuthProvider {
	override suspend fun setAuthorizationInRequest(
		builder: HttpRequestBuilder,
		authenticationClass: ServerAuthenticationClass?
	) {
		builder.headers[""] = ""
	}

	override fun getAuthService() = this

	override suspend fun invalidateCurrentToken(error: RequestStatusException) {}
}
