package com.icure.sdk.crypto.entities

import kotlinx.serialization.Serializable

@Serializable
data class FailedRequestDetails(
	val entityId: String,
	val delegateId: String,
	val updatedForMigration: Boolean,
	val code: Int?,
	val reason: String?,
	val request: DelegateShareOptions?
)
