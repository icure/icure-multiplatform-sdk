package com.icure.cardinal.sdk.auth

import kotlinx.serialization.Serializable

/**
 * Optional parameters for the authentication process template
 */
@Serializable
data class AuthenticationProcessTemplateParameters(
	/**
	 * First name of the user executing the authentication process.
	 */
	val firstName: String? = null,
	/**
	 * Last name of the user executing the authentication process.
	 */
	val lastName: String? = null
)