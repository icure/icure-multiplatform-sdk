package com.icure.cardinal.sdk.options

import com.icure.cardinal.sdk.auth.services.JwtBasedAuthProvider
import com.icure.cardinal.sdk.crypto.BasicInternalCryptoApi
import com.icure.cardinal.sdk.crypto.InternalCryptoServices
import com.icure.cardinal.sdk.storage.CardinalStorageFacade
import com.icure.utils.InternalIcureApi
import io.ktor.client.HttpClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.serialization.json.Json

/**
 * Provides access to general APIs configuration.
 */
@InternalIcureApi
internal interface BasicApiConfiguration {
	val apiUrl: String
	val httpClient: HttpClient
	val clientJson: Json
	val webSocketAuthProvider: JwtBasedAuthProvider?
	val crypto: BasicInternalCryptoApi
	val encryption: EntitiesEncryptedFieldsManifests

	fun requireWebSocketAuthProvider(): JwtBasedAuthProvider =
		webSocketAuthProvider ?: throw UnsupportedOperationException("Your chosen authentication method does not support websocket subscriptions")
}

@InternalIcureApi
internal interface ApiConfiguration : BasicApiConfiguration {
	val autofillAuthor: Boolean
	val storage: CardinalStorageFacade
	override val crypto: InternalCryptoServices
	val jsonPatcher: JsonPatcher
	val sdkScope: CoroutineScope
}

@InternalIcureApi
internal data class ApiConfigurationImpl(
	override val apiUrl: String,
	override val httpClient: HttpClient,
	override val clientJson: Json,
	override val webSocketAuthProvider: JwtBasedAuthProvider?,
	override val autofillAuthor: Boolean,
	override val crypto: InternalCryptoServices,
	override val encryption: EntitiesEncryptedFieldsManifests,
	override val storage: CardinalStorageFacade,
	override val jsonPatcher: JsonPatcher,
	override val sdkScope: CoroutineScope
) : ApiConfiguration

@InternalIcureApi
internal data class BasicApiConfigurationImpl(
	override val apiUrl: String,
	override val httpClient: HttpClient,
	override val clientJson: Json,
	override val webSocketAuthProvider: JwtBasedAuthProvider?,
	override val crypto: BasicInternalCryptoApi,
	override val encryption: EntitiesEncryptedFieldsManifests
) : BasicApiConfiguration
