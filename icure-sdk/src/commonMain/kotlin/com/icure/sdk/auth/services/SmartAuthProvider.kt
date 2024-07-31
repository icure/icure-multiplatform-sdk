package com.icure.sdk.auth.services

import com.icure.kryptom.crypto.CryptoService
import com.icure.sdk.api.raw.RawAnonymousAuthApi
import com.icure.sdk.auth.AuthSecretDetails
import com.icure.sdk.auth.AuthSecretProvider
import com.icure.sdk.auth.TokenProvider
import com.icure.sdk.model.UserGroup
import com.icure.sdk.utils.InternalIcureApi

@OptIn(InternalIcureApi::class)
class SmartAuthProvider private constructor(
	private val tokenProvider: TokenProvider,
	private val groupId: String? = null
) : JwtBasedAuthProvider {
	companion object {

		fun initialise(
			authApi: RawAnonymousAuthApi,
			login: String,
			secretProvider: AuthSecretProvider,
			initialSecret: AuthSecretDetails.Cacheable?,
			initialAuthToken: String?,
			initialRefreshToken: String?,
			groupId: String?,
			cryptoService: CryptoService,
			passwordClientSideSalt: String?,
		) = SmartAuthProvider(
			TokenProvider(
				login = login,
				groupId = groupId,
				currentLongLivedSecret = initialSecret,
				cachedToken = initialAuthToken,
				cachedRefreshToken = initialRefreshToken,
				authApi = authApi,
				authSecretProvider = secretProvider,
				passwordClientSideSalt = passwordClientSideSalt,
				cryptoService = cryptoService
			),
			groupId
		)

	}

	override fun getAuthService() = SmartAuthService(tokenProvider)

	suspend fun switchGroup(newGroupId: String, matches: List<UserGroup>): AuthProvider = when {
		newGroupId == groupId -> this
		matches.none { it.groupId == newGroupId } -> throw IllegalArgumentException("New group id not found in matches.")
		else -> SmartAuthProvider(
			tokenProvider = tokenProvider.switchedGroup(newGroupId),
			groupId = newGroupId,
		)
	}
}
