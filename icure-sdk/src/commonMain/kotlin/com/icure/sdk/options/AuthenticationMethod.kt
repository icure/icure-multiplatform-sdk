package com.icure.sdk.options

import com.icure.kryptom.crypto.CryptoService
import com.icure.sdk.api.raw.RawAnonymousAuthApi
import com.icure.sdk.api.raw.RawMessageGatewayApi
import com.icure.sdk.api.raw.impl.RawAnonymousAuthApiImpl
import com.icure.sdk.api.raw.impl.RawUserApiImpl
import com.icure.sdk.auth.AuthSecretDetails
import com.icure.sdk.auth.AuthSecretProvider
import com.icure.sdk.auth.AuthenticationProcessApi
import com.icure.sdk.auth.Credentials
import com.icure.sdk.auth.JwtCredentials
import com.icure.sdk.auth.ThirdPartyAuthentication
import com.icure.sdk.auth.ThirdPartyProvider
import com.icure.sdk.auth.UsernameLongToken
import com.icure.sdk.auth.UsernamePassword
import com.icure.sdk.auth.services.AuthProvider
import com.icure.sdk.auth.services.JwtAuthProvider
import com.icure.sdk.auth.services.SmartAuthProvider
import com.icure.sdk.model.Group
import com.icure.sdk.model.User
import com.icure.sdk.model.embed.AuthenticationClass
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import com.icure.sdk.utils.ensureNonNull
import io.ktor.client.HttpClient

sealed interface AuthenticationMethod {
	/**
	 * The sdk will perform requests using jwt obtained from the provided credentials.
	 *
	 * When using this authentication method, the sdk will cache the credentials and will automatically request updated
	 * tokens as needed.
	 * However, if the provided credentials expire, the SDK will become unusable.
	 *
	 * This authentication method can also be used for the execution of requests that require an elevated security context
	 * as long as the credentials provided can be used to create a suitable token.
	 *
	 * Not that when using this authentication method the provided credentials will be cached (in volatile memory)
	 * without expiration.
	 */
	data class UsingCredentials(
		/**
		 * Credentials of the user.
		 */
		val credentials: Credentials
	) : AuthenticationMethod

	/**
	 * The sdk will perform requests using a specific authentication provider.
	 */
	@InternalIcureApi
	data class UsingAuthProvider(
		/**
		 * The authentication provider to use for the requests.
		 */
		val authProvider: AuthProvider
	) : AuthenticationMethod

	/**
	 * Allows the SDK to perform authentication using secrets obtained from an [AuthSecretProvider].
	  *
	 * The iCure SDK can authenticate to the backend using different kinds of secrets, such as passwords, long-lived authentication tokens, and
	 * short-lived authentication tokens generated through the message gateway.
	 * iCure associates to each kind of secret a certain security level, and for some sensitive operations, depending on the configurations of
	 * the user and his group, some operations may require a secret of a certain security level.
	 *
	 * For example, with the default configurations, to change his own email the user can't have logged in with a long-lived token, but he
	 * needs to provide his current password or a short-lived token.
	  *
	 * By using this authentication option, the iCure SDK will automatically request and cache the secret from the [AuthSecretProvider] only when
	 * needed, which should help to minimize the interaction with the user.
	  *
	 * Another advantage of using this authentication option over others is that in case all the cached tokens and secrets were to expire while
	 * performing a request, instead of having the request fail the SDK will ask for a new secret from the [SmartAuthProvider] and the request will
	 * automatically be retried with the new secret.
	 */
	data class UsingSecretProvider(
		/**
		 * A public identifier of the user logging in. This could be:
		 * - [User.id]
		 * - [Group.id]:[User.id]
		 * - [User.login]
		 * - [User.email]
		 * This value is optional because authentication using external methods (e.g. Google or digital ids) does not
		 * require explicitly providing the username. However, if not provided, the authentication will be locked to
		 * only use these external authentication methods.
		 */
		val loginUsername: String?,
		/**
		 * An initial secret for the login.
		 * If not null, the authentication provider will attempt to use it when needed before asking the secret
		 * provider.
		 */
		val initialSecret: InitialSecret? = null,
		/**
		 * If not null the authentication provider will use the jwt while valid.
		 */
		val existingJwt: String? = null,
		/**
		 * If not null the authentication provider will use the refresh jwt while valid.
		 */
		val existingRefreshJwt: String? = null,
		/**
		 * Secret provider to use for authentication. Will handle interaction with the GUI.
		 */
		val secretProvider: AuthSecretProvider,
		/**
		 * If set to true the secrets used by the authentication provider will be cached without expiration
		 * (in volatile memory).
		 * This minimizes the interaction with the end user, but may not be suitable for your security policy.
		 */
		val cacheSecrets: Boolean = false
	) : AuthenticationMethod {
		sealed interface InitialSecret {
			data class Password(val password: String) : InitialSecret
			data class LongLivedToken(val token: String) : InitialSecret
			data class OAuth(val secret: String, val oauthType: ThirdPartyProvider) : InitialSecret
		}
	}
}

private fun CommonOptions.getPasswordClientSideSalt(applicationId: String?) =
	applicationId?.takeIf { saltPasswordWithApplicationId }

@InternalIcureApi
internal fun AuthenticationMethod.getAuthProvider(
	authApi: RawAnonymousAuthApi,
	cryptoService: CryptoService,
	applicationId: String?,
	options: CommonOptions,
	messageGatewayApi: RawMessageGatewayApi
): AuthProvider = when(this) {
	is AuthenticationMethod.UsingCredentials -> when (this.credentials) {
		is ThirdPartyAuthentication -> smartAuthWithConstantSecret(
			authApi,
			cryptoService,
			options.getPasswordClientSideSalt(applicationId),
			AuthSecretDetails.ExternalAuthenticationDetails(this.credentials.token, this.credentials.provider),
			null,
			messageGatewayApi,
			applicationId
		)
		is UsernameLongToken -> smartAuthWithConstantSecret(
			authApi,
			cryptoService,
			options.getPasswordClientSideSalt(applicationId),
			AuthSecretDetails.LongLivedTokenDetails(this.credentials.token),
			this.credentials.username,
			messageGatewayApi,
			applicationId
		)
		is UsernamePassword -> smartAuthWithConstantSecret(
			authApi,
			cryptoService,
			options.getPasswordClientSideSalt(applicationId),
			AuthSecretDetails.PasswordDetails(this.credentials.password),
			this.credentials.username,
			messageGatewayApi,
			applicationId
		)
		is JwtCredentials -> JwtAuthProvider(authApi, this.credentials.initialBearer, this.credentials.refresh)
	}
	is AuthenticationMethod.UsingAuthProvider -> this.authProvider
	is AuthenticationMethod.UsingSecretProvider -> SmartAuthProvider.initialize(
		authApi = authApi,
		loginUsername = loginUsername,
		secretProvider = secretProvider,
		initialAuthToken = existingJwt,
		initialRefreshToken = existingRefreshJwt,
		initialSecret = when (initialSecret) {
			is AuthenticationMethod.UsingSecretProvider.InitialSecret.LongLivedToken ->
				AuthSecretDetails.LongLivedTokenDetails(initialSecret.token)
			is AuthenticationMethod.UsingSecretProvider.InitialSecret.OAuth ->
				AuthSecretDetails.ExternalAuthenticationDetails(initialSecret.secret, initialSecret.oauthType)
			is AuthenticationMethod.UsingSecretProvider.InitialSecret.Password ->
				AuthSecretDetails.PasswordDetails(initialSecret.password)
			null -> null
		},
		groupId = null,
		applicationId = applicationId,
		passwordClientSideSalt = options.getPasswordClientSideSalt(applicationId),
		cryptoService = cryptoService,
		cacheSecrets = false,
		allowSecretRetry = true,
		messageGatewayApi = messageGatewayApi
	)
}

/**
 * Get an authentication provider and bind it to a group.
 */
@InternalIcureApi
internal suspend fun AuthenticationMethod.getAuthProviderInGroup(
	apiUrl: String,
	httpClient: HttpClient,
	cryptoService: CryptoService,
	applicationId: String?,
	options: CommonOptions,
	groupSelector: GroupSelector?
): AuthProvider {
	val rawAuthApi = RawAnonymousAuthApiImpl(apiUrl, httpClient, json = Serialization.json)
	val messageGatewayApi = RawMessageGatewayApi(httpClient)
	val authProvider = getAuthProvider(rawAuthApi, cryptoService, applicationId, options, messageGatewayApi)
	val userApi = RawUserApiImpl(apiUrl, authProvider, httpClient, json = Serialization.json)
	val matches = userApi.getMatchingUsers().successBody()
	val chosenGroupId = if (matches.size > 1) {
		 requireNotNull(groupSelector) {
			"The provided credentials allow the user to login to multiple groups, but no group selector is provided"
		}.invoke(matches)
	} else {
		ensureNonNull(matches.first().groupId) { "Group id of single match is null" }
	}
	return authProvider.switchGroup(chosenGroupId)
}

@InternalIcureApi
private fun smartAuthWithConstantSecret(
	authApi: RawAnonymousAuthApi,
	cryptoService: CryptoService,
	passwordClientSideSalt: String?,
	authSecretDetails: AuthSecretDetails.Cacheable,
	login: String?,
	messageGatewayApi: RawMessageGatewayApi,
	applicationId: String?
) = SmartAuthProvider.initialize(
	authApi = authApi,
	loginUsername = login,
	secretProvider = ConstantSecretProvider(authSecretDetails),
	initialAuthToken = null,
	initialRefreshToken = null,
	initialSecret = authSecretDetails,
	groupId = null,
	applicationId = applicationId,
	passwordClientSideSalt = passwordClientSideSalt,
	cryptoService = cryptoService,
	cacheSecrets = true,
	allowSecretRetry = false,
	messageGatewayApi = messageGatewayApi
)

private class ConstantSecretProvider(
	private val authSecretDetails: AuthSecretDetails.Cacheable
) : AuthSecretProvider {
	override suspend fun getSecret(
		acceptedSecrets: List<AuthenticationClass>,
		previousAttempts: List<AuthSecretDetails>,
		authProcessApi: AuthenticationProcessApi
	): AuthSecretDetails {
		if (authSecretDetails.type in acceptedSecrets) {
			if (previousAttempts.isEmpty())
				return authSecretDetails
			else throw IllegalStateException("Provided credentials can't be used to request new tokens. This method can't be used")
		} else throw IllegalStateException("This method can't be used when logged in with a secret of type ${authSecretDetails.type}")
	}
}