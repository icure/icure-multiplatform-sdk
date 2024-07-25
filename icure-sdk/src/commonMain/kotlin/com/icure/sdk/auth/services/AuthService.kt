package com.icure.sdk.auth.services

import com.icure.sdk.auth.ServerAuthenticationClass
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.RequestStatusException
import io.ktor.client.request.HttpRequestBuilder

/**
 * Specifies the behaviour for all the services that manage authentication.
 * Each implementation is responsible for providing a valid authentication token [T].
 */
@OptIn(InternalIcureApi::class)
interface AuthService {

	/**
	 * Configures the authentication mechanism in a ktor request.
	 *
	 * @param builder the [HttpRequestBuilder] of the request to configure.
	 * @param authenticationClass if specified, the request will be authorized with an authentication class greater or
	 * equal to the one provided.
	 * @throws UnavailableAuthenticationClassException if it is not possible to generate a token with the specified
	 * authentication class.
	 */
	suspend fun setAuthorizationInRequest(builder: HttpRequestBuilder, authenticationClass: ServerAuthenticationClass? = null)

	class UnavailableAuthenticationClassException(authenticationClass: ServerAuthenticationClass)
		: Exception("Cannot generate a token with authentication class $authenticationClass")

	suspend fun invalidateCurrentToken(error: RequestStatusException)
}

/**
 * @see [AuthService.setAuthorizationInRequest]
 */
@OptIn(InternalIcureApi::class)
suspend fun HttpRequestBuilder.setAuthorizationWith(service: AuthService, authenticationClass: ServerAuthenticationClass? = null) =
	service.setAuthorizationInRequest(this, authenticationClass)
