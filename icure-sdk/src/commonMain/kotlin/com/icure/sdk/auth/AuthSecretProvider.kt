package com.icure.sdk.auth

import com.icure.sdk.model.embed.AuthenticationClass

/**
 * Needed by a [SmartAuthProvider] to get the secrets (password, token, etc.) for authentication to the iCure SDK as needed.
 */
interface AuthSecretProvider {
	/**
	 * Provides a secret for authentication to the iCure SDK.
	 *
	 * ## Accepted secrets
	 *
	 * The method will be provided with an array of the secrets types that are acceptable [acceptedSecrets]. Usually this array will contain multiple
	 * elements, but this depends on the group configuration, the user (if he has 2fa setup or not), or the operation being performed. For groups using
	 * default configurations and for patients without 2fa enabled for example the array will always contain the [AuthenticationClass.PASSWORD] element.
	 * Usually the array contain also the [AuthenticationClass.LONG_LIVED_TOKEN] element, but if the user is attempting to perform a sensitive operations
	 * such as changing his password the default group configuration does not allow for the user to authenticate using a JWT obtained from a long-lived
	 * token for this operation, meaning the array will not contain the [AuthenticationClass.LONG_LIVED_TOKEN] element.
	 *
	 * Regardless of the number of elements in the array only one secret of the accepted types is sufficient for the operation to succeed.
	 *
	 * ## [AuthenticationClass.TWO_FACTOR_AUTHENTICATION_TOKEN] secret type
	 *
	 * The [AuthenticationClass.TWO_FACTOR_AUTHENTICATION_TOKEN] secret type is only used when the user has 2fa enabled. In this case the SDK will call
	 * this method twice, once containing the [AuthenticationClass.PASSWORD] element in the [acceptedSecrets] array, and if the provided secret is a
	 * valid password the SDK will immediately call this method again, this time containing the [AuthenticationClass.TWO_FACTOR_AUTHENTICATION_TOKEN]
	 * instead of the [AuthenticationClass.PASSWORD] element.
	 *
	 * Any future call to this method from the same provider instance will not contain the [AuthenticationClass.PASSWORD] element anymore, as it is
	 * cached, but it may contain the [AuthenticationClass.TWO_FACTOR_AUTHENTICATION_TOKEN] element instead.
	 *
	 * Note that the 2fa token is not needed for logging in through a long-lived or short-lived token, it is only used in combination with a password.
	 * If the user is using 2fa, and you get in input as [acceptedSecrets] an array `[PASSWORD, LONG_LIVED_TOKEN, SHORT_LIVED_TOKEN]`, and you pass to
	 * authenticate a long-lived token, the SDK will not call this method again to ask for the 2fa token.
	 *
	 * @param acceptedSecrets the types of secrets that are acceptable for the operation being performed.
	 * @param previousAttempts the secrets that were previously attempted by the SDK for this operation. This array will be empty the first time this
	 * method is called for a given operation, but it may contain multiple elements if the SDK has already called this method multiple times because the
	 * previously returned secrets were not valid. The first element is the first secret that was attempted, and the last element is the most recently
	 * attempted.
	 * @param authProcessApi an api which can be used to request sms or email short-lived tokens for the user.
	 * @return a promise that resolves with the secret and the secret type to use for authentication. If the promise rejects then the ongoing SDK
	 * operation will fail without being re-attempted.
	 */
	suspend fun getSecret(
		acceptedSecrets: List<AuthenticationClass>,
		previousAttempts: List<AuthSecretDetails>,
		authProcessApi: AuthenticationProcessApi
	): AuthSecretDetails
}
