package com.icure.sdk.crypto.entities

import com.icure.sdk.utils.InternalIcureApi

@InternalIcureApi
data class MinimalBulkShareResult(
	val updatedEntitiesIds: List<String>,
	val unmodifiedEntitiesIds: List<String>,
	val updateErrors: List<FailedRequestDetails>
)