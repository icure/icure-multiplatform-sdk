package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.model.EntityReference

interface EntityReferenceApi {
	suspend fun getLatest(prefix: String): EntityReference
	suspend fun createEntityReference(entityReference: EntityReference): EntityReference
}

