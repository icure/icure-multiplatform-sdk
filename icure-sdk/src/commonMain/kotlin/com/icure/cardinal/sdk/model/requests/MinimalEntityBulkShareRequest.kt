package com.icure.cardinal.sdk.model.requests

import kotlinx.serialization.Serializable

/**
 * Result of a bulk share operation.
 */
@Serializable
data class MinimalEntityBulkShareResult(
	/**
	 * Id of the entity for which the update was requested.
	 */
	val entityId: String,
	/**
	 * Last known revision of the entity before any update, non-null only if an entity matching the requests could be
	 * found. This can help to understand if an error is caused by an outdated version of the entity on the client-side.
	 */
	val entityRev: String? = null,
	/**
	 * If a `bulkShare` method fails to apply any of the share requests for an entity this map associates the id of the
	 * original failed request to the reason of failure.
	 */
	val rejectedRequests: Map<String, EntityBulkShareResult.RejectedShareOrMetadataUpdateRequest> = emptyMap()
)
