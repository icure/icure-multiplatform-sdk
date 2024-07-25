package com.icure.sdk.auth.services

import com.icure.sdk.auth.ServerAuthenticationClass
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.RequestStatusException
import io.ktor.client.request.HttpRequestBuilder

/**
 * Meta auth service that combines multiple auth services by adding all headers from multiple services.
 */
@OptIn(InternalIcureApi::class)
class CompositeAuthService(
	val services: List<AuthService>
) : AuthService, AuthProvider {
	override suspend fun setAuthorizationInRequest(
		builder: HttpRequestBuilder,
		authenticationClass: ServerAuthenticationClass?
	) = services.forEach { it.setAuthorizationInRequest(builder, authenticationClass) }

	override fun getAuthService(): AuthService = this

	override suspend fun invalidateCurrentToken(error: RequestStatusException) = services.forEach { it.invalidateCurrentToken(error) }
}
