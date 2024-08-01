package com.icure.sdk.auth.services

import com.icure.kryptom.crypto.CryptoService
import com.icure.sdk.api.raw.RawAnonymousAuthApi
import com.icure.sdk.auth.AuthSecretDetails
import com.icure.sdk.auth.AuthSecretProvider
import com.icure.sdk.auth.JwtBearerAndRefresh
import com.icure.sdk.auth.SmartTokenProvider
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

	override suspend fun switchGroup(newGroupId: String): AuthProvider = when {
		newGroupId == groupId -> this
		else -> SmartAuthProvider(
			smartTokenProvider = smartTokenProvider.switchedGroup(newGroupId),
			groupId = newGroupId,
		)
	}

	override suspend fun getBearerAndRefreshToken(): JwtBearerAndRefresh =
		smartTokenProvider.getCachedTokensOrLoad()
}
