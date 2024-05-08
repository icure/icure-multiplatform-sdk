package com.icure.sdk.api

import io.ktor.client.HttpClient

data class ApiOptions(
	val encryptedFields: EncryptedFields = EncryptedFields(),
	val disableParentKeysInitialisation: Boolean = false,
	val httpClient: HttpClient? = null,
	val createTransferKeys: Boolean = true
)

data class EncryptedFields(
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