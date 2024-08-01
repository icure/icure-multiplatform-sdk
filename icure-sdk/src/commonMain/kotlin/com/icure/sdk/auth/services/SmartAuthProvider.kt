package com.icure.sdk.auth.services

import com.icure.kryptom.crypto.CryptoService
import com.icure.sdk.api.raw.RawAnonymousAuthApi
import com.icure.sdk.auth.AuthSecretDetails
import com.icure.sdk.auth.AuthSecretProvider
import com.icure.sdk.auth.JwtBearerAndRefresh
import com.icure.sdk.auth.SmartTokenProvider
import com.icure.sdk.model.UserGroup
import com.icure.sdk.utils.InternalIcureApi

@InternalIcureApi
internal class SmartAuthProvider private constructor(
	private val smartTokenProvider: SmartTokenProvider,
	private val groupId: String? = null
) : JwtBasedAuthProvider {
	companion object {

		fun initialise(
			authApi: RawAnonymousAuthApi,
			loginUsername: String?,
			secretProvider: AuthSecretProvider,
			initialSecret: AuthSecretDetails.Cacheable?,
			initialAuthToken: String?,
			initialRefreshToken: String?,
			groupId: String?,
			cryptoService: CryptoService,
			passwordClientSideSalt: String?,
		) = SmartAuthProvider(
			SmartTokenProvider(
				loginUsername = loginUsername,
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

	override fun getAuthService() = SmartAuthService(smartTokenProvider)

	suspend fun switchGroup(newGroupId: String, matches: List<UserGroup>): AuthProvider = when {
		newGroupId == groupId -> this
		matches.none { it.groupId == newGroupId } -> throw IllegalArgumentException("New group id not found in matches.")
		else -> SmartAuthProvider(
			smartTokenProvider = smartTokenProvider.switchedGroup(newGroupId),
			groupId = newGroupId,
		)
	}

	override suspend fun getBearerAndRefreshToken(): JwtBearerAndRefresh =
		smartTokenProvider.getCachedTokensOrLoad()
}
