package com.icure.sdk.auth.services

import com.icure.sdk.auth.AuthToken

interface TokenBasedAuthService<T : AuthToken> : AuthService {
	/**
	 * @return the authentication token [T] provided by the concrete implementation fo this class.
	 */
	suspend fun getToken(): T
}