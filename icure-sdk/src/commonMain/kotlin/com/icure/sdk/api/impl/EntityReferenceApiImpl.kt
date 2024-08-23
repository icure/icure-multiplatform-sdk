package com.icure.sdk.api.impl

import com.icure.sdk.api.EntityReferenceApi
import com.icure.sdk.api.raw.RawEntityReferenceApi
import com.icure.sdk.model.EntityReference
import com.icure.sdk.utils.InternalIcureApi

@InternalIcureApi
internal class EntityReferenceApiImpl(
	private val rawApi: RawEntityReferenceApi,
) : EntityReferenceApi {
	override suspend fun getLatest(prefix: String) = rawApi.getLatest(prefix).successBody()
	override suspend fun createEntityReference(entityReference: EntityReference) =
		rawApi.createEntityReference(entityReference).successBody()
}