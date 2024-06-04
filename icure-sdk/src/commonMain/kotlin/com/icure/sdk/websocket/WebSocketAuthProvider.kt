package com.icure.sdk.websocket

import com.icure.sdk.auth.Jwt
import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.TokenBasedAuthService

class WebSocketAuthProvider(
	private val authService: TokenBasedAuthService<Jwt>
) {
	companion object {
		suspend fun fromAuthServiceIfSupported(authService: AuthService): WebSocketAuthProvider? {
			return if (authService is TokenBasedAuthService<*>) {
				val token = authService.getToken()
				if (token is Jwt)
					@Suppress("UNCHECKED_CAST")
					WebSocketAuthProvider(authService as TokenBasedAuthService<Jwt>)
				else
					null
			} else {
				null
			}
		}
	}

	suspend fun getBearerToken(): String {
		return authService.getToken().jwt
	}
}
