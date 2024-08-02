package com.icure.sdk.auth

import com.icure.kotp.ShaVersion
import com.icure.kotp.Totp
import com.icure.kryptom.crypto.HmacAlgorithm
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.sdk.IcureSdk
import com.icure.sdk.api.raw.impl.RawAnonymousAuthApiImpl
import com.icure.sdk.api.raw.impl.RawUserApiImpl
import com.icure.sdk.auth.services.AuthProvider
import com.icure.sdk.auth.services.SmartAuthProvider
import com.icure.sdk.model.embed.AuthenticationClass
import com.icure.sdk.model.security.AuthenticationToken
import com.icure.sdk.model.security.Enable2faRequest
import com.icure.sdk.options.ApiOptions
import com.icure.sdk.options.AuthenticationMethod
import com.icure.sdk.options.getAuthProvider
import com.icure.sdk.test.baseUrl
import com.icure.sdk.test.createHcpUser
import com.icure.sdk.test.createUserInMultipleGroups
import com.icure.sdk.test.initialiseTestEnvironment
import com.icure.sdk.test.shouldBeNextRevOf
import com.icure.sdk.test.testGroupAdminAuth
import com.icure.sdk.test.uuid
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.RequestStatusException
import com.icure.sdk.utils.Serialization
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldNotContain
import io.kotest.matchers.maps.shouldNotBeEmpty
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import kotlinx.datetime.Clock

@OptIn(InternalIcureApi::class)
class SmartAuthProviderTest : StringSpec({

	val authApi = RawAnonymousAuthApiImpl(
		apiUrl = baseUrl,
		httpClient = IcureSdk.sharedHttpClient,
		json = Serialization.json
	)

	fun getUserApiWithProvider(authProvider: AuthProvider) = RawUserApiImpl(
		apiUrl = baseUrl,
		authProvider = authProvider,
		httpClient = IcureSdk.sharedHttpClient,
		json = Serialization.json
	)

	beforeAny {
		initialiseTestEnvironment()
	}

	"Should automatically ask for secret to get a new token, and asks again the secret if it is not valid" {
		val hcpDetails = createHcpUser()
		var calls = 0
		val authProvider = SmartAuthProvider.initialise(
			authApi = authApi,
			loginUsername = hcpDetails.username,
			secretProvider = object : AuthSecretProvider {
				override suspend fun getSecret(
					acceptedSecrets: List<AuthenticationClass>,
					previousAttempts: List<AuthSecretDetails>,
				): AuthSecretDetails {
					acceptedSecrets shouldContain AuthenticationClass.Password
					acceptedSecrets shouldContain AuthenticationClass.LongLivedToken
					acceptedSecrets shouldContain AuthenticationClass.ShortLivedToken
					acceptedSecrets shouldNotContain AuthenticationClass.TwoFactorAuthentication
					return when(calls) {
						0 -> {
							previousAttempts.shouldBeEmpty()
							calls++
							AuthSecretDetails.LongLivedTokenDetails("wrong")
						}
						1 -> {
							previousAttempts.size shouldBe 1
							previousAttempts.first().secret shouldBe "wrong"
							previousAttempts.first().type shouldBe AuthenticationClass.LongLivedToken
							calls++
							AuthSecretDetails.LongLivedTokenDetails(hcpDetails.password)
						}
						else -> throw IllegalStateException("Invalid number of attempts: $calls")
					}
				}
			},
			initialSecret = null,
			initialAuthToken = null,
			initialRefreshToken = null,
			groupId = null,
			cryptoService = defaultCryptoService,
			passwordClientSideSalt = null,
			cacheSecrets = true,
			allowSecretRetry = true
		)

		val userApi = getUserApiWithProvider(authProvider)
		val user = userApi.getCurrentUser().successBody()
		user.healthcarePartyId shouldBe hcpDetails.dataOwnerId
		calls shouldBe 2
	}

	"Should automatically ask for a more powerful secret to perform elevated-security operations if the available secret/token is not good enough" {
		val hcpDetails = createHcpUser()
		val api = hcpDetails.api()
		val initialUser = api.user.getCurrentUser()
		val adminUserApi = RawUserApiImpl(baseUrl, testGroupAdminAuth, IcureSdk.sharedHttpClient, json = Serialization.json)
		val userToken = uuid()
		val userPwd = uuid()
		val userWithLongTokenAndPwd = adminUserApi.modifyUser(
			initialUser.copy(
				passwordHash = userPwd,
				authenticationTokens = mapOf(
					"test-long-lived-token" to AuthenticationToken(
						token = userToken,
						creationTime = Clock.System.now().toEpochMilliseconds(),
						validity = 60 * 60 * 24 * 7
					)
				)
			)
		).successBody()
		var calls = 0
		val authProvider = SmartAuthProvider.initialise(
			authApi = authApi,
			loginUsername = hcpDetails.username,
			secretProvider = object : AuthSecretProvider {
				override suspend fun getSecret(
					acceptedSecrets: List<AuthenticationClass>,
					previousAttempts: List<AuthSecretDetails>,
				): AuthSecretDetails {
					return when(calls) {
						0 -> {
							acceptedSecrets shouldContain AuthenticationClass.Password
							acceptedSecrets shouldContain AuthenticationClass.LongLivedToken
							acceptedSecrets shouldContain AuthenticationClass.ShortLivedToken
							acceptedSecrets shouldNotContain AuthenticationClass.TwoFactorAuthentication
							previousAttempts.shouldBeEmpty()
							calls++
							AuthSecretDetails.LongLivedTokenDetails(userToken)
						}
						1 -> {
							acceptedSecrets shouldContain AuthenticationClass.Password
							acceptedSecrets shouldNotContain AuthenticationClass.LongLivedToken
							acceptedSecrets shouldContain AuthenticationClass.ShortLivedToken
							acceptedSecrets shouldNotContain AuthenticationClass.TwoFactorAuthentication
							previousAttempts.shouldBeEmpty()
							calls++
							AuthSecretDetails.PasswordDetails(userPwd)
						}
						else -> throw IllegalStateException("Invalid number of attempts: $calls")
					}
				}
			},
			initialSecret = null,
			initialAuthToken = null,
			initialRefreshToken = null,
			groupId = null,
			cryptoService = defaultCryptoService,
			passwordClientSideSalt = null,
			cacheSecrets = true,
			allowSecretRetry = true
		)

		val userApi = getUserApiWithProvider(authProvider)
		userApi.getCurrentUser().successBody().rev shouldBe userWithLongTokenAndPwd.rev
		calls shouldBe 1
		val newPwd = uuid()
		val userWithNewPwd = userApi.modifyUser(
			userWithLongTokenAndPwd.copy(
				passwordHash = newPwd,
			)
		).successBody()
		userWithNewPwd.rev.shouldNotBeNull() shouldBeNextRevOf userWithLongTokenAndPwd.rev.shouldNotBeNull()
		calls shouldBe 2
		val retrievedWithNewPwd = getUserApiWithProvider(
			AuthenticationMethod.UsingCredentials(UsernamePassword(hcpDetails.username, newPwd)).getAuthProvider(authApi, defaultCryptoService, null, ApiOptions())
		).getCurrentUser().successBody()
		retrievedWithNewPwd shouldBe userWithNewPwd
		shouldThrow<RequestStatusException> {
			getUserApiWithProvider(
				AuthenticationMethod.UsingCredentials(UsernamePassword(hcpDetails.username, userPwd)).getAuthProvider(authApi, defaultCryptoService, null, ApiOptions())
			).getCurrentUser()
		}.statusCode shouldBe 401
	}

	"Should automatically ask for TOTP after password if user has 2fa enabled" {
		val hcpDetails = createHcpUser()
		val api = hcpDetails.api()
		val otpLength = 8
		val initialUser = api.user.getCurrentUser()
		val adminUserApi = RawUserApiImpl(baseUrl, testGroupAdminAuth, IcureSdk.sharedHttpClient, json = Serialization.json)
		val totpSecret = Totp.generateTOTPSecret(32, HmacAlgorithm.HmacSha256)
		val totp = Totp(secret = totpSecret, shaVersion = ShaVersion.Sha256)
		val userPwd = uuid()
		adminUserApi.enable2faForUser(initialUser.id, Enable2faRequest(totpSecret, otpLength))
		val userWithPwdAnd2fa = adminUserApi.modifyUser(
			initialUser.copy(
				passwordHash = userPwd,
			)
		).successBody()
		var calls = 0
		val authProvider = SmartAuthProvider.initialise(
			authApi = authApi,
			loginUsername = hcpDetails.username,
			secretProvider = object : AuthSecretProvider {
				override suspend fun getSecret(
					acceptedSecrets: List<AuthenticationClass>,
					previousAttempts: List<AuthSecretDetails>,
				): AuthSecretDetails {
					return when(calls) {
						0 -> {
							acceptedSecrets shouldContain AuthenticationClass.Password
							acceptedSecrets shouldContain AuthenticationClass.LongLivedToken
							acceptedSecrets shouldContain AuthenticationClass.ShortLivedToken
							acceptedSecrets shouldNotContain AuthenticationClass.TwoFactorAuthentication
							previousAttempts.shouldBeEmpty()
							calls++
							AuthSecretDetails.PasswordDetails(userPwd)
						}
						1, 2 -> {
							acceptedSecrets shouldContain AuthenticationClass.TwoFactorAuthentication
							if(calls == 1) {
								previousAttempts.shouldBeEmpty()
								calls ++
								AuthSecretDetails.TwoFactorAuthTokenDetails(secret = "${totp.generate(digits = otpLength)}13")
							}
							else {
								previousAttempts.size shouldBe 1
								calls++
								AuthSecretDetails.TwoFactorAuthTokenDetails(secret = totp.generate(digits = otpLength))
							}
						}
						else -> throw IllegalStateException("Invalid number of attempts: $calls")
					}
				}
			},
			initialSecret = null,
			initialAuthToken = null,
			initialRefreshToken = null,
			groupId = null,
			cryptoService = defaultCryptoService,
			passwordClientSideSalt = null,
			cacheSecrets = true,
			allowSecretRetry = true
		)

		val userApi = getUserApiWithProvider(authProvider)
		userApi.getCurrentUser().successBody().rev shouldBe userWithPwdAnd2fa.rev
		calls shouldBe 3
	}

	"Should ask for TOTP directly if password is cached" {
		val hcpDetails = createHcpUser()
		val api = hcpDetails.api()
		val otpLength = 8
		val initialUser = api.user.getCurrentUser()
		val adminUserApi = RawUserApiImpl(baseUrl, testGroupAdminAuth, IcureSdk.sharedHttpClient, json = Serialization.json)
		val totpSecret = Totp.generateTOTPSecret(32, HmacAlgorithm.HmacSha256)
		val totp = Totp(secret = totpSecret, shaVersion = ShaVersion.Sha256)
		val userPwd = uuid()
		adminUserApi.enable2faForUser(initialUser.id, Enable2faRequest(totpSecret, otpLength))
		val userWithPwdAnd2fa = adminUserApi.modifyUser(
			initialUser.copy(
				passwordHash = userPwd,
			)
		).successBody()
		var calls = 0
		val authProvider = SmartAuthProvider.initialise(
			authApi = authApi,
			loginUsername = hcpDetails.username,
			secretProvider = object : AuthSecretProvider {
				override suspend fun getSecret(
					acceptedSecrets: List<AuthenticationClass>,
					previousAttempts: List<AuthSecretDetails>,
				): AuthSecretDetails {
					acceptedSecrets shouldContain AuthenticationClass.TwoFactorAuthentication
					previousAttempts.shouldBeEmpty()
					calls++ shouldBe 0
					return AuthSecretDetails.TwoFactorAuthTokenDetails(secret = totp.generate(digits = 8))
				}
			},
			initialSecret = AuthSecretDetails.PasswordDetails(userPwd),
			initialAuthToken = null,
			initialRefreshToken = null,
			groupId = null,
			cryptoService = defaultCryptoService,
			passwordClientSideSalt = null,
			cacheSecrets = true,
			allowSecretRetry = true
		)

		val userApi = getUserApiWithProvider(authProvider)
		userApi.getCurrentUser().successBody().rev shouldBe userWithPwdAnd2fa.rev
		calls shouldBe 1
	}

	"Switched provider should keep cached secrets and should be able to have elevated security context" {
		val details = createUserInMultipleGroups()
		val groups = details.keys.toList()
		val firstUser = details.values.first()
		val authProvider = SmartAuthProvider.initialise(
			authApi = authApi,
			loginUsername = firstUser.username,
			secretProvider = object : AuthSecretProvider {
				override suspend fun getSecret(
					acceptedSecrets: List<AuthenticationClass>,
					previousAttempts: List<AuthSecretDetails>,
				): AuthSecretDetails {
					acceptedSecrets shouldContain AuthenticationClass.Password
					previousAttempts.shouldBeEmpty()
					return AuthSecretDetails.PasswordDetails(firstUser.password)
				}
			},
			initialSecret = null,
			initialAuthToken = null,
			initialRefreshToken = null,
			groupId = null,
			cryptoService = defaultCryptoService,
			passwordClientSideSalt = null,
			cacheSecrets = true,
			allowSecretRetry = true
		)
		val defaultGroupUserApi = getUserApiWithProvider(authProvider)
		val defaultGroupUser = defaultGroupUserApi.getCurrentUser().successBody()
		val otherGroupId = if (defaultGroupUser.groupId == groups[0]) groups[1] else groups[0]
		val matches = defaultGroupUserApi.getMatchingUsers().successBody()
		val switchedUserApi = getUserApiWithProvider(authProvider.switchGroup(otherGroupId))
		val switchedUser = switchedUserApi.getCurrentUser().successBody()
		switchedUser.id shouldNotBe defaultGroupUser.id
		switchedUser.groupId shouldBe otherGroupId
		val updatedDefault = switchedUserApi.modifyUser(switchedUser.copy(
			authenticationTokens = mapOf(
				"test-long-lived-token" to AuthenticationToken(
					token = uuid(),
					creationTime = Clock.System.now().toEpochMilliseconds(),
					validity = 60 * 60 * 24 * 7
				)
			)
		)).successBody()
		updatedDefault.rev.shouldNotBeNull() shouldBeNextRevOf switchedUser.rev.shouldNotBeNull()
		updatedDefault.authenticationTokens.shouldNotBeEmpty()
	}
})
