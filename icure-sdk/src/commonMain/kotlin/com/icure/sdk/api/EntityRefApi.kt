package com.icure.sdk.api

import com.icure.sdk.api.raw.RawEntityReferenceApi
import com.icure.sdk.model.EntityReference
import com.icure.sdk.utils.InternalIcureApi

interface EntityReferenceApi {
	suspend fun getLatest(prefix: String): EntityReference
	suspend fun createEntityReference(entityReference: EntityReference): EntityReference
}

@OptIn(InternalIcureApi::class)
class EntityReferenceApiImpl(
	private val rawApi: RawEntityReferenceApi,
) : EntityReferenceApi {
	override suspend fun getLatest(prefix: String) = rawApi.getLatest(prefix).successBody()
	override suspend fun createEntityReference(entityReference: EntityReference) =
		rawApi.createEntityReference(entityReference).successBody()

}

