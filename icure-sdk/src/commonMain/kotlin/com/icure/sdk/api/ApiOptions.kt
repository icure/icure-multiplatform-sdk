package com.icure.sdk.api

data class ApiOptions(
	val encryptedFields: EncryptedFields? = null,
	val disableParentKeysInitialisation: Boolean = false
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
	val topic: Set<String>? = null
)