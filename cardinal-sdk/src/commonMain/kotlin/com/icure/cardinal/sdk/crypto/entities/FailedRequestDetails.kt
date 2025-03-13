package com.icure.cardinal.sdk.crypto.entities

import kotlinx.serialization.Serializable

@Serializable
data class FailedRequestDetails(
	val entityId: String,
	val delegateReference: DataOwnerReferenceInGroup,
	val updatedForMigration: Boolean,
	val code: Int?,
	val reason: String?,
	val request: DelegateShareOptions?,
	val shouldRetry: Boolean
)
