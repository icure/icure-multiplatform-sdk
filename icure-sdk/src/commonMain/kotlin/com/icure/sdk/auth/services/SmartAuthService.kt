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
	data class ExpectRequestWithSpecificAuthClass(val errorFromNewToken: RequestStatusException): SmartAuthServiceState
	data class TerminalError(val error: RequestStatusException): SmartAuthServiceState
}

@InternalIcureApi
class SmartAuthService(
	private val tokenProvider: TokenProvider
) : AuthService {

	private var currentState: SmartAuthServiceState = SmartAuthServiceState.Initial

	override suspend fun setAuthorizationInRequest(builder: HttpRequestBuilder, authenticationClass: ServerAuthenticationClass?) {
		when(val immutableCurrentState = currentState) {
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
					if(tokens.jwt == immutableCurrentState.token) {
						throw immutableCurrentState.initialError
					}
					currentState = SmartAuthServiceState.ReattemptedWithNewUnboundToken
					builder.bearerAuth(tokens.jwt)
				}
			}
			is SmartAuthServiceState.ExpectRequestWithSpecificAuthClass -> {
				if(authenticationClass != null) {
					val token = tokenProvider.getNewTokenWithClass(authenticationClass)
					currentState = SmartAuthServiceState.ReattemptedWithAuthClassSpecificToken
					builder.bearerAuth(token)
				} else {
					throw immutableCurrentState.errorFromNewToken
				}
			}
			is SmartAuthServiceState.TerminalError -> throw immutableCurrentState.error
			else -> throw IllegalStateException("Illegal state: cannot get token in state: ${immutableCurrentState::class.simpleName}")
		}
	}

	override suspend fun invalidateCurrentHeader(error: RequestStatusException) {
		currentState = when(val immutableCurrentState = currentState) {
			is SmartAuthServiceState.DoneInitial -> SmartAuthServiceState.Reattempt(token = immutableCurrentState.token, initialError = error)
			is SmartAuthServiceState.ReattemptedWithNewUnboundToken -> SmartAuthServiceState.ExpectRequestWithSpecificAuthClass(errorFromNewToken = error)
			is SmartAuthServiceState.ReattemptedWithAuthClassSpecificToken -> SmartAuthServiceState.TerminalError(error = error)
			else -> throw IllegalStateException("Illegal state: cannot invalidate header in state: ${immutableCurrentState::class.simpleName}")
		}
	}

}
