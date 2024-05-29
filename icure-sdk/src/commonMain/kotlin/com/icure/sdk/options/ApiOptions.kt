package com.icure.sdk.options

import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.defaultCryptoService
import io.ktor.client.*
import kotlinx.serialization.json.Json

interface CommonOptions {
	val encryptedFields: EncryptedFieldsConfiguration
	val httpClient: HttpClient?
	val httpClientJson: Json?
	val cryptoService: CryptoService
}

data class ApiOptions(
	override val encryptedFields: EncryptedFieldsConfiguration = EncryptedFieldsConfiguration(),
	val disableParentKeysInitialisation: Boolean = false,
	override val httpClient: HttpClient? = null,
	override val httpClientJson: Json? = null,
	val createTransferKeys: Boolean = true,
	override val cryptoService: CryptoService = defaultCryptoService,
): CommonOptions

data class BasicApiOptions(
	override val encryptedFields: EncryptedFieldsConfiguration = EncryptedFieldsConfiguration(),
	override val httpClient: HttpClient? = null,
	override val httpClientJson: Json? = null,
	override val cryptoService: CryptoService = defaultCryptoService,
): CommonOptions

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
