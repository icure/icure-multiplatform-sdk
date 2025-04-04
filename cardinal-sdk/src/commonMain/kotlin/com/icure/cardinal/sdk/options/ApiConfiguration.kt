package com.icure.cardinal.sdk.options

import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.auth.services.JwtBasedAuthProvider
import com.icure.cardinal.sdk.crypto.BasicInternalCryptoApi
import com.icure.cardinal.sdk.crypto.InternalCryptoServices
import com.icure.cardinal.sdk.crypto.entities.SdkBoundGroup
import com.icure.cardinal.sdk.storage.CardinalStorageFacade
import com.icure.utils.InternalIcureApi
import kotlinx.coroutines.Job

/**
 * Provides access to general APIs configuration.
 */
@InternalIcureApi
internal interface BasicApiConfiguration {
	val apiUrl: String
	val webSocketAuthProvider: JwtBasedAuthProvider?
	val crypto: BasicInternalCryptoApi
	val encryption: EntitiesEncryptedFieldsManifests
	val rawApiConfig: RawApiConfig
	val boundGroup: SdkBoundGroup?

	fun requireWebSocketAuthProvider(): JwtBasedAuthProvider =
		webSocketAuthProvider ?: throw UnsupportedOperationException("Your chosen authentication method does not support websocket subscriptions")

	/**
	 * - If the group id is null or matches the sdk bound group (if available) returns null
	 * - If the sdk is not bound throws
	 *
	 */
	fun resolveGroupId(groupId: String?): String?
}

@InternalIcureApi
internal interface ApiConfiguration : BasicApiConfiguration {
	val autofillAuthor: Boolean
	val storage: CardinalStorageFacade
	override val crypto: InternalCryptoServices
	val jsonPatcher: JsonPatcher
	val parentJob: Job?
}

@InternalIcureApi
internal data class ApiConfigurationImpl(
	override val apiUrl: String,
	override val webSocketAuthProvider: JwtBasedAuthProvider?,
	override val autofillAuthor: Boolean,
	override val crypto: InternalCryptoServices,
	override val encryption: EntitiesEncryptedFieldsManifests,
	override val storage: CardinalStorageFacade,
	override val jsonPatcher: JsonPatcher,
	override val parentJob: Job?,
	override val rawApiConfig: RawApiConfig,
	override val boundGroup: SdkBoundGroup?,
) : ApiConfiguration

@InternalIcureApi
internal data class BasicApiConfigurationImpl(
	override val apiUrl: String,
	override val webSocketAuthProvider: JwtBasedAuthProvider?,
	override val crypto: BasicInternalCryptoApi,
	override val encryption: EntitiesEncryptedFieldsManifests,
	override val rawApiConfig: RawApiConfig,
	override val boundGroup: SdkBoundGroup?,
) : BasicApiConfiguration
