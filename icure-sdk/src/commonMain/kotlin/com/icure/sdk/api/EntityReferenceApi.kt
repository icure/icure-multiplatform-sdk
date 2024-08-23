package com.icure.sdk.api

import com.icure.sdk.model.EntityReference

interface EntityReferenceApi {
	suspend fun getLatest(prefix: String): EntityReference
	suspend fun createEntityReference(entityReference: EntityReference): EntityReference
}

