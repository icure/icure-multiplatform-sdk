package com.icure.sdk.auth

import com.icure.sdk.model.Group
import com.icure.sdk.model.User

sealed interface Credentials

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

data class ThirdPartyTokens(
	val tokens: Map<ThirdPartyProvider, String>
) : Credentials

data class JwtCredentials(
	val initialBearer: JwtBearer?,
	val refresh: JwtRefresh
) : Credentials