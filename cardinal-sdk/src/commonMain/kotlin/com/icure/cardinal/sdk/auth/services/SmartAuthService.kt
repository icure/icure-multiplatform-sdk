package com.icure.cardinal.sdk.auth.services

import com.icure.cardinal.sdk.auth.JwtBearer
import com.icure.cardinal.sdk.auth.SmartTokenProvider
import com.icure.cardinal.sdk.model.embed.AuthenticationClass
import com.icure.cardinal.sdk.utils.InternalCardinalException
import com.icure.cardinal.sdk.utils.RequestStatusException
import com.icure.utils.InternalIcureApi
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.bearerAuth

private sealed interface SmartAuthServiceState {

	data object Initial : SmartAuthServiceState
	data class DoneInitial(val token: String) : SmartAuthServiceState
	data class Reattempt(val token: String, val initialError: RequestStatusException) : SmartAuthServiceState
	data object ReattemptedWithNewUnboundToken : SmartAuthServiceState
	data object ReattemptedWithAuthClassSpecificToken : SmartAuthServiceState
	data class ExpectRequestWithSpecificAuthClass(val errorFromNewToken: RequestStatusException): SmartAuthServiceState
}

@InternalIcureApi
internal class SmartAuthService(
	private val smartTokenProvider: SmartTokenProvider
) : TokenBasedAuthService<JwtBearer>, AuthService {

	private var currentState: SmartAuthServiceState = SmartAuthServiceState.Initial

	private suspend fun getTokenInState(authenticationClass: AuthenticationClass?): String = when(val immutableCurrentState = currentState) {
		is SmartAuthServiceState.Initial, is SmartAuthServiceState.DoneInitial -> {
			if(authenticationClass != null) {
				throw InternalCardinalException("Illegal state: cannot ask for a specific auth class level at the first request attempt.")
			} else if (immutableCurrentState is SmartAuthServiceState.DoneInitial) {
				// Needed for reattempts on connection errors or 500
				immutableCurrentState.token
			} else {
				val tokens = smartTokenProvider.getCachedOrRefreshedOrNewToken()
				currentState = SmartAuthServiceState.DoneInitial(tokens.jwt)
				tokens.jwt
			}
		}
		is SmartAuthServiceState.Reattempt -> {
			if(authenticationClass != null) {
				val token = smartTokenProvider.getTokenForClass(authenticationClass)
				currentState = SmartAuthServiceState.ReattemptedWithAuthClassSpecificToken
				token
			} else {
				val tokens = smartTokenProvider.getCachedOrRefreshedOrNewToken()
				if (tokens.jwt == immutableCurrentState.token) {
					throw immutableCurrentState.initialError
				}
				currentState = SmartAuthServiceState.ReattemptedWithNewUnboundToken
				tokens.jwt
			}
		}
		is SmartAuthServiceState.ExpectRequestWithSpecificAuthClass -> {
			if(authenticationClass != null) {
				val token = smartTokenProvider.getTokenForClass(authenticationClass)
				currentState = SmartAuthServiceState.ReattemptedWithAuthClassSpecificToken
				token
			} else {
				throw immutableCurrentState.errorFromNewToken
			}
		}
		else -> throw InternalCardinalException("Illegal state: cannot get token in state: ${immutableCurrentState::class.simpleName}")
	}

	override suspend fun getToken(): JwtBearer = JwtBearer(getTokenInState(null))

	override suspend fun setAuthenticationInRequest(builder: HttpRequestBuilder, authenticationClass: AuthenticationClass?) {
		builder.bearerAuth(getTokenInState(authenticationClass))
	}

	override suspend fun invalidateCurrentAuthentication(
		error: RequestStatusException,
		requiredAuthClass: AuthenticationClass?
	) {
		currentState = when(val immutableCurrentState = currentState) {
			is SmartAuthServiceState.DoneInitial -> SmartAuthServiceState.Reattempt(token = immutableCurrentState.token, initialError = error)
			is SmartAuthServiceState.ReattemptedWithNewUnboundToken -> SmartAuthServiceState.ExpectRequestWithSpecificAuthClass(errorFromNewToken = error)
			is SmartAuthServiceState.ReattemptedWithAuthClassSpecificToken -> throw error
			else -> throw InternalCardinalException("Illegal state: cannot invalidate header in state: ${immutableCurrentState::class.simpleName}")
		}
	}

}
