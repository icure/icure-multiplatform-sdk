package com.icure.sdk.websocket

import com.icure.sdk.auth.Jwt
import com.icure.sdk.auth.services.TokenBasedAuthService

class WebSocketAuthProvider(
	private val authService: TokenBasedAuthService<Jwt>
) {
	suspend fun getBearerToken(): String {
		return authService.getToken().jwt
	}
}
