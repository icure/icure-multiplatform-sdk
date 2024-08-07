package com.icure.sdk.auth.services

import com.icure.kryptom.crypto.CryptoService
import com.icure.sdk.api.raw.RawAnonymousAuthApi
import com.icure.sdk.api.raw.RawMessageGatewayApi
import com.icure.sdk.auth.AuthSecretDetails
import com.icure.sdk.auth.AuthSecretProvider
import com.icure.sdk.auth.JwtBearerAndRefresh
import com.icure.sdk.auth.SmartTokenProvider
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.isJwtExpiredOrInvalid

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
			applicationId: String?,
			cryptoService: CryptoService,
			passwordClientSideSalt: String?,
			cacheSecrets: Boolean,
			allowSecretRetry: Boolean,
			messageGatewayApi: RawMessageGatewayApi
		) = SmartAuthProvider(
			SmartTokenProvider(
				loginUsername = loginUsername,
				groupId = groupId,
				applicationId = applicationId,
				currentLongLivedSecret = if (
					cacheSecrets || initialRefreshToken == null || isJwtExpiredOrInvalid(initialRefreshToken)
				) initialSecret else null, // Even if cache secret is false, in case the initial refresh token is not valid the secret will actually be cached until the first request
				cachedToken = initialAuthToken,
				cachedRefreshToken = initialRefreshToken,
				authApi = authApi,
				authSecretProvider = secretProvider,
				passwordClientSideSalt = passwordClientSideSalt,
				cacheSecrets = cacheSecrets,
				cryptoService = cryptoService,
				allowSecretRetry = allowSecretRetry,
				messageGatewayApi = messageGatewayApi
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
