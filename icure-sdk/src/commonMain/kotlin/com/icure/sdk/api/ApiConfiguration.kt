package com.icure.sdk.api

import com.icure.sdk.crypto.BasicInternalCryptoApi
import com.icure.sdk.crypto.InternalCryptoServices
import com.icure.sdk.options.EntitiesEncryptedFieldsManifests
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.websocket.WebSocketAuthProvider
import io.ktor.client.HttpClient

/**
 * Provides access to general APIs configuration.
 */
@InternalIcureApi
internal interface BasicApiConfiguration {
	val apiUrl: String
	val httpClient: HttpClient
	val webSocketAuthProvider: WebSocketAuthProvider?
	val crypto: BasicInternalCryptoApi
	val encryption: EntitiesEncryptedFieldsManifests

	fun requireWebSocketAuthProvider(): WebSocketAuthProvider =
		webSocketAuthProvider ?: throw UnsupportedOperationException("Your chosen authentication method does not support websocket subscriptions")
}

@InternalIcureApi
internal interface ApiConfiguration : BasicApiConfiguration {
	val autofillAuthor: Boolean
	override val crypto: InternalCryptoServices
}

@InternalIcureApi
internal data class ApiConfigurationImpl(
	override val apiUrl: String,
	override val httpClient: HttpClient,
	override val webSocketAuthProvider: WebSocketAuthProvider?,
	override val autofillAuthor: Boolean,
	override val crypto: InternalCryptoServices,
	override val encryption: EntitiesEncryptedFieldsManifests
) : ApiConfiguration

@InternalIcureApi
internal data class BasicApiConfigurationImpl(
	override val apiUrl: String,
	override val httpClient: HttpClient,
	override val webSocketAuthProvider: WebSocketAuthProvider?,
	override val crypto: BasicInternalCryptoApi,
	override val encryption: EntitiesEncryptedFieldsManifests
) : BasicApiConfiguration