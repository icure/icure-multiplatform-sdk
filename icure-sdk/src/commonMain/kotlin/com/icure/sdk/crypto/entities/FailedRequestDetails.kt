package com.icure.sdk.crypto.entities

data class FailedRequestDetails(
	val entityId: String,
	val delegateId: String,
	val updatedForMigration: Boolean,
	val code: Int?,
	val reason: String?,
	val request: DelegateShareOptions?
)
