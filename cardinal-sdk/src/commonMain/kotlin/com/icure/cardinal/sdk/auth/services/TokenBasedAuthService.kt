package com.icure.cardinal.sdk.auth.services

import com.icure.cardinal.sdk.auth.AuthToken
import com.icure.utils.InternalIcureApi

@InternalIcureApi
interface TokenBasedAuthService<T : AuthToken> : AuthService {
	/**
	 * @return the authentication token [T] provided by the concrete implementation fo this class.
	 */
	suspend fun getToken(): T
}