package com.icure.cardinal.sdk.crypto.entities

import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import kotlinx.serialization.Serializable

@Serializable
data class FailedRequestDetails(
	val entityId: String,
	val delegateReference: EntityReferenceInGroup,
	val updatedForMigration: Boolean,
	val code: Int?,
	val reason: String?,
	val request: DelegateShareOptions?,
	val shouldRetry: Boolean
)
