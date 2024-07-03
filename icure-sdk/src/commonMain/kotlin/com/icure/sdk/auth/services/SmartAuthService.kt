package com.icure.sdk.auth.services

import com.icure.sdk.auth.ServerAuthenticationClass
import com.icure.sdk.auth.TokenProvider
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.RequestStatusException
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.bearerAuth

private sealed interface SmartAuthServiceState {

	data object Initial : SmartAuthServiceState
	data class DoneInitial(val token: String) : SmartAuthServiceState
	data class Reattempt(val token: String, val initialError: RequestStatusException) : SmartAuthServiceState
	data object ReattemptedWithNewUnboundToken : SmartAuthServiceState
	data object ReattemptedWithAuthClassSpecificToken : SmartAuthServiceState
	data class ExpectRequestWithSpecificAuthClass(val errorFromNewToken: RequestStatusException)
	data class TerminalError(val error: RequestStatusException)
}

@InternalIcureApi
class SmartAuthService(
	private val tokenProvider: TokenProvider
) : AuthService {

	private var currentState: SmartAuthServiceState = SmartAuthServiceState.Initial

	override suspend fun setAuthorizationInRequest(builder: HttpRequestBuilder, authenticationClass: ServerAuthenticationClass?) {
		when(currentState) {
			is SmartAuthServiceState.Initial -> {
				if(authenticationClass != null) {
					throw IllegalStateException("Illegal state: cannot ask for a specific auth class level at the first request attempt.")
				} else {
					val tokens = tokenProvider.getCachedOrRefreshedOrNewToken()
					currentState = SmartAuthServiceState.DoneInitial(tokens.jwt)
					builder.bearerAuth(tokens.jwt)
				}
			}
			is SmartAuthServiceState.Reattempt -> {
				if(authenticationClass != null) {
					val token = tokenProvider.getNewTokenWithClass(authenticationClass)
					currentState = SmartAuthServiceState.ReattemptedWithAuthClassSpecificToken
					builder.bearerAuth(token)
				} else {
					val tokens = tokenProvider.getCachedOrRefreshedOrNewToken()
					if(tokens.jwt == currentState)
				}
			}
		}
	}

	override suspend fun invalidateCurrentHeader(error: RequestStatusException) {
		TODO("Not yet implemented")
	}

}
