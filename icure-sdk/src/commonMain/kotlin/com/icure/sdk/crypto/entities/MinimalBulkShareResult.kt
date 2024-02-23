package com.icure.sdk.crypto.entities

import com.icure.sdk.utils.InternalIcureApi

@InternalIcureApi
data class MinimalBulkShareResult(
	val successfulUpdates: Set<MinimalRequestDetails>,
	val unmodifiedEntitiesIds: Set<String>,
	val updateErrors: List<FailedRequestDetails>
) {
	data class MinimalRequestDetails(
		val delegateId: String,
		val entityId: String
	)
}