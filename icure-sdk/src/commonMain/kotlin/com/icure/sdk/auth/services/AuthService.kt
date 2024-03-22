package com.icure.sdk.auth.services

import com.icure.sdk.auth.AuthToken
import com.icure.sdk.auth.AuthenticationClass
import io.ktor.client.request.HttpRequestBuilder

/**
 * Specifies the behaviour for all the services that manage authentication.
 * Each implementation is responsible for providing a valid authentication token [T].
 */
sealed interface AuthService {

	/**
	 * Configures the authentication mechanism in a ktor request.
	 *
	 * @param builder the [HttpRequestBuilder] of the request to configure.
	 * @param authenticationClass if specified, the request will be authorized with an authentication class greater or
	 * equal to the one provided.
	 * @throws UnavailableAuthenticationClassException if it is not possible to generate a token with the specified
	 * authentication class.
	 */
	suspend fun setAuthorizationInRequest(builder: HttpRequestBuilder, authenticationClass: AuthenticationClass? = null)

	class UnavailableAuthenticationClassException(authenticationClass: AuthenticationClass)
		: Exception("Cannot generate a token with authentication class $authenticationClass")

}

/**
 * @see [AuthService.setAuthorizationInRequest]
 */
suspend fun HttpRequestBuilder.setAuthorizationWith(service: AuthService, authenticationClass: AuthenticationClass? = null) =
	service.setAuthorizationInRequest(this, authenticationClass)
