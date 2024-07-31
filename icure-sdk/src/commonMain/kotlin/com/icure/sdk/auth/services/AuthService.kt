package com.icure.sdk.auth.services

import com.icure.sdk.model.embed.AuthenticationClass
import com.icure.sdk.utils.RequestStatusException
import io.ktor.client.request.HttpRequestBuilder

/**
 * Specifies the behavior for all the services that manage authentication.
 * Some auth services are "single use", meaning that the service can only be used in the scope of a single api method.
 * In the execution of that method the SDK may use the auth service multiple times to perform the same request with
 * different authentication credentials, for example to support mechanisms such as upgrade and retry.
 * However, using a single services for the execution of different methods may cause errors.
 */
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
	suspend fun setAuthenticationInRequest(builder: HttpRequestBuilder, authenticationClass: AuthenticationClass? = null)

	class UnavailableAuthenticationClassException(authenticationClass: AuthenticationClass)
		: Exception("Cannot generate a token with authentication class $authenticationClass")

	/**
	 * Marks the authentication used to perform the last request as invalid.
	 * If [requiredAuthClass] is null the authentication method has become fully invalid and won't be usable to perform
	 * any request.
	 * If [requiredAuthClass] is not null the authentication method may still be valid for some requests, but it is
	 * not secure enough for the latest requests and needs escalation.
	 *
	 * This method should rethrow the error if the auth service can't get a better authentication, or update the state
	 * of the service otherwise.
	 *
	 * @param error the request that failed due to the invalid authentication
	 * @param requiredAuthClass if the request failed due to the authentication not being secure enough
	 */
	suspend fun invalidateCurrentAuthentication(
		error: RequestStatusException,
		requiredAuthClass: AuthenticationClass?
	)
}

/**
 * @see [AuthService.setAuthenticationInRequest]
 */
internal suspend fun HttpRequestBuilder.setAuthorizationWith(service: AuthService, authenticationClass: AuthenticationClass? = null) =
	service.setAuthenticationInRequest(this, authenticationClass)
