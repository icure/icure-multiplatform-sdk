package com.icure.sdk.model.requests

import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.Map

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class EntityBulkShareResult<T>(
	public val updatedEntity: T? = null,
	public val entityId: String,
	public val entityRev: String? = null,
	public val rejectedRequests: Map<String, RejectedShareOrMetadataUpdateRequest> = emptyMap(),
) {
	@Serializable
	public data class RejectedShareOrMetadataUpdateRequest(
		public val code: Int,
		public val shouldRetry: Boolean,
		public val reason: String,
	)
	// region EntityBulkShareResult-EntityBulkShareResult

	// endregion
}
