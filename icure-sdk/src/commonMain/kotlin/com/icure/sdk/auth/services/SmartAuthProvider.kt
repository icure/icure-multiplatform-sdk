package com.icure.sdk.auth.services

import com.icure.sdk.api.raw.RawAnonymousAuthApi
import com.icure.sdk.auth.AuthSecretProvider
import com.icure.sdk.auth.CachedSecretType
import com.icure.sdk.auth.ThirdPartyProvider
import com.icure.sdk.auth.TokenProvider
import com.icure.sdk.model.UserGroup
import com.icure.sdk.utils.InternalIcureApi

@OptIn(InternalIcureApi::class)
class SmartAuthProvider private constructor(
	private val tokenProvider: TokenProvider,
	private val groupId: String? = null
) : AuthProvider {

	sealed interface InitialSecret {
		data class PlainSecret(val secret: String) : InitialSecret
		data class OAuthSecret(val oauthToken: String, val oauthType: ThirdPartyProvider): InitialSecret
	}

	companion object {

		fun initialise(
			authApi: RawAnonymousAuthApi,
			login: String,
			secretProvider: AuthSecretProvider,
			initialSecret: InitialSecret? = null,
			initialAuthToken: String? = null,
			initialRefreshToken: String? = null,
			groupId: String? = null
		) = SmartAuthProvider(
			TokenProvider(
				login = login,
				groupId = groupId,
				currentLongLivedSecret = when(initialSecret) {
					null -> null
					is InitialSecret.PlainSecret -> CachedSecretType.UnspecifiedCachedSecret(secret = initialSecret.secret)
					is InitialSecret.OAuthSecret -> CachedSecretType.ExternalAuthenticationCachedSecret(secret = initialSecret.oauthToken, oauthType = initialSecret.oauthType)
				},
				cachedToken = initialAuthToken,
				cachedRefreshToken = initialRefreshToken,
				authApi = authApi,
				authSecretProvider = secretProvider
			),
			groupId
		)

	}

	override fun getAuthService(): AuthService = SmartAuthService(tokenProvider)

	suspend fun switchGroup(newGroupId: String, matches: List<UserGroup>): AuthProvider = when {
		newGroupId == groupId -> this
		matches.none { it.groupId == newGroupId } -> throw IllegalStateException("New group id not found in matches.")
		else -> SmartAuthProvider(
			tokenProvider = tokenProvider.switchedGroup(newGroupId),
			groupId = newGroupId,
		)
	}

}
