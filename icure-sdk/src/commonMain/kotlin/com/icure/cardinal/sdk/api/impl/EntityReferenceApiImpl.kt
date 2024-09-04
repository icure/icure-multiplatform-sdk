package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.EntityReferenceApi
import com.icure.cardinal.sdk.api.raw.RawEntityReferenceApi
import com.icure.cardinal.sdk.model.EntityReference
import com.icure.utils.InternalIcureApi

@InternalIcureApi
internal class EntityReferenceApiImpl(
	private val rawApi: RawEntityReferenceApi,
) : EntityReferenceApi {
	override suspend fun getLatest(prefix: String) = rawApi.getLatest(prefix).successBody()
	override suspend fun createEntityReference(entityReference: EntityReference) =
		rawApi.createEntityReference(entityReference).successBody()
}