package com.icure.sdk.auth.services

import com.icure.sdk.auth.AuthToken
import com.icure.sdk.utils.InternalIcureApi

@InternalIcureApi
interface TokenBasedAuthService<T : AuthToken> : AuthService {
	/**
	 * @return the authentication token [T] provided by the concrete implementation fo this class.
	 */
	suspend fun getToken(): T
}