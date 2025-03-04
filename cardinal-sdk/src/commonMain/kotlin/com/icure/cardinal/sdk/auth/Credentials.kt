package com.icure.cardinal.sdk.auth

import com.icure.cardinal.sdk.model.Group
import com.icure.cardinal.sdk.model.User
import com.icure.utils.InternalIcureApi

sealed interface Credentials

/**
 * A JWT from an external trusted source recognized by the backend that can be used to receive a Cardinal JWT.
 * The external source must be configured at group level to be used.
 */
data class ExternalToken(
	val initialBearer: String? = null,
	val tokenProvider: suspend () -> String
) : Credentials

data class UsernamePassword(
	/**
	 * A public identifier of the user logging in. This could be:
	 * - [User.id]
	 * - [Group.id]:[User.id]
	 * - [User.login]
	 * - [User.email]
	 */
	val username: String,
	/**
	 * The password of the user
	 */
	val password: String
) : Credentials

data class UsernameLongToken(
	/**
	 * A public identifier of the user logging in. This could be:
	 * - [User.id]
	 * - [Group.id]:[User.id]
	 * - [User.login]
	 * - [User.email]
	 */
	val username: String,
	/**
	 * A long-lived authentication token generated through iCure (cockpit or sdk)
	 */
	val token: String,
) : Credentials

data class ThirdPartyAuthentication(
	/**
	 * A token used to perform the third party authentication
	 */
	val token: String,
	/**
	 * The authentication provider
	 */
	val provider: ThirdPartyProvider
) : Credentials

@InternalIcureApi
data class JwtCredentials(
	val initialBearer: JwtBearer?,
	val refresh: JwtRefresh
) : Credentials
