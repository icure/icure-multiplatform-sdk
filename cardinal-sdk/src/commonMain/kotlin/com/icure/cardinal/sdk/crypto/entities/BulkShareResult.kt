package com.icure.cardinal.sdk.crypto.entities

import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.utils.InternalIcureApi

@InternalIcureApi
data class BulkShareResult<T : HasEncryptionMetadata>(
	val updatedEntities: List<T>,
	val unmodifiedEntitiesIds: Set<String>,
	val updateErrors: List<FailedRequestDetails>
)