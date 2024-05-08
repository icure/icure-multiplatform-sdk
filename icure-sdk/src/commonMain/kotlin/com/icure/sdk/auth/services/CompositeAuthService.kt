package com.icure.sdk.auth.services

import com.icure.sdk.auth.AuthenticationClass
import io.ktor.client.request.HttpRequestBuilder

/**
 * Meta auth service that combines multiple auth services by adding all headers from multiple services.
 */
class CompositeAuthService(
	val services: List<AuthService>
) : AuthService {
	override suspend fun setAuthorizationInRequest(
		builder: HttpRequestBuilder,
		authenticationClass: AuthenticationClass?
	) = services.forEach { it.setAuthorizationInRequest(builder, authenticationClass) }
}