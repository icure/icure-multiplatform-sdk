package com.icure.sdk.crypto.entities

import com.icure.sdk.model.Encryptable
import com.icure.sdk.utils.InternalIcureApi

@InternalIcureApi
data class BulkShareResult<T : Encryptable>(
	val updatedEntities: List<T>,
	val unmodifiedEntitiesIds: Set<String>,
	val updateErrors: List<FailedRequestDetails>
)