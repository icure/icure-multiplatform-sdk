package com.icure.sdk.options

import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.defaultCryptoService
import io.ktor.client.HttpClient
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

interface CommonOptions {
	val encryptedFields: EncryptedFieldsConfiguration
	/**
	 * Specify which client to use for performing http requests (rest).
	 * You will be responsible for closing the client after you are done using the sdk.
	 *
	 * This client must support json serialization.
	 *
	 * If null an http client instance shared across all sdks will be used.
	 */
	val httpClient: HttpClient?
	/**
	 * Specify which client to use for performing websocket requests.
	 * You will be responsible for closing the client after you are done using the sdk.
	 *
	 * If [httpClient] is not null and this is null the sdk will use the [httpClient] also to perform the websocket
	 * requests. This means that if [httpClient] is not null and does not support websockets you must also provide
	 * a value for this, else you will not be able to use features that rely on websockets, such as realtime
	 * notifications.
	 *
	 * If both this and [httpClient] are null a shared instance of the client will be used.
	 */
	val websocketClient: HttpClient?
	/**
	 * The instance of [Json] used by the provided [httpClient] (leave null if [httpClient] is null).
	 */
	val httpClientJson: Json?
	val cryptoService: CryptoService
}

data class ApiOptions(
	override val encryptedFields: EncryptedFieldsConfiguration = EncryptedFieldsConfiguration(),
	val disableParentKeysInitialisation: Boolean = false,
	override val httpClient: HttpClient? = null,
	override val websocketClient: HttpClient? = null,
	override val httpClientJson: Json? = null,
	val createTransferKeys: Boolean = true,
	override val cryptoService: CryptoService = defaultCryptoService,
): CommonOptions

data class BasicApiOptions(
	override val encryptedFields: EncryptedFieldsConfiguration = EncryptedFieldsConfiguration(),
	override val httpClient: HttpClient? = null,
	override val websocketClient: HttpClient? = null,
	override val httpClientJson: Json? = null,
	override val cryptoService: CryptoService = defaultCryptoService,
): CommonOptions

@Serializable
data class EncryptedFieldsConfiguration(
	val accessLog: Set<String> = setOf("detail", "objectId"),
	val calendarItem: Set<String> = setOf("details", "title", "patientId"),
	val contact: Set<String> = setOf("descr", "notes[].markdown"),
	val service: Set<String> = setOf("notes[].markdown"),
	val healthElement: Set<String> = setOf("descr", "note", "notes[].markdown"),
	val maintenanceTask: Set<String> = setOf("properties"),
	val patient: Set<String> = setOf("note", "notes[].markdown"),
	val message: Set<String> = emptySet(),
	val topic: Set<String> = setOf("description", "linkedServices", "linkedHealthElements"),
	val document: Set<String> = emptySet(),
	val form: Set<String> = emptySet(),
	val receipt: Set<String> = emptySet(),
	val classification: Set<String> = emptySet(),
	val timeTable: Set<String> = emptySet(),
	val invoice: Set<String> = emptySet(),
)
