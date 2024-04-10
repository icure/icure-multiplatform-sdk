package com.icure.sdk.api

import io.ktor.client.HttpClient

data class ApiOptions(
	val encryptedFields: EncryptedFields? = null,
	val disableParentKeysInitialisation: Boolean = false,
	val httpClient: HttpClient? = null
)

data class EncryptedFields(
	val default: Set<String>? = null,
	val accessLog: Set<String>? = null,
	val calendarItem: Set<String>? = null,
	val contact: Set<String>? = null,
	val service: Set<String>? = null,
	val healthElement: Set<String>? = null,
	val maintenanceTask: Set<String>? = null,
	val patient: Set<String>? = null,
	val message: Set<String>? = null,
	val topic: Set<String>? = null,
	val document: Set<String>? = null,
	val form: Set<String>? = null,
	val receipt: Set<String>? = null,
	val classification: Set<String>? = null,
	val timeTable: Set<String>? = null,
	val invoice: Set<String>? = null,
)