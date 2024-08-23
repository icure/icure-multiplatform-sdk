package com.icure.sdk.api

import com.icure.sdk.model.IdWithRev
import com.icure.sdk.model.IndexingInfo
import com.icure.sdk.model.ReplicationInfo
import com.icure.sdk.model.couchdb.ReplicatorDocument
import com.icure.sdk.utils.DefaultValue

interface ICureApi {
	suspend fun getVersion(): String
	suspend fun isReady(): String
	suspend fun getProcessInfo(): String
	suspend fun getIndexingInfo(): IndexingInfo
	suspend fun getReplicationInfo(): ReplicationInfo
	suspend fun updateDesignDoc(
		entityName: String,
		@DefaultValue("null")
		warmup: Boolean? = null,
	): Boolean

	suspend fun resolvePatientsConflicts(
		@DefaultValue("null")
		limit: Int? = null
	): List<IdWithRev>
	suspend fun resolveContactsConflicts(
		@DefaultValue("null")
		limit: Int? = null
	): List<IdWithRev>
	suspend fun resolveFormsConflicts(
		@DefaultValue("null")
		limit: Int? = null
	): List<IdWithRev>
	suspend fun resolveHealthElementsConflicts(
		@DefaultValue("null")
		limit: Int? = null
	): List<IdWithRev>
	suspend fun resolveInvoicesConflicts(
		@DefaultValue("null")
		limit: Int? = null
	): List<IdWithRev>
	suspend fun resolveMessagesConflicts(
		@DefaultValue("null")
		limit: Int? = null
	): List<IdWithRev>
	suspend fun resolveDocumentsConflicts(
		@DefaultValue("null")
		ids: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
	): List<IdWithRev>

	suspend fun getIndexingInfoByGroup(groupId: String): IndexingInfo
	suspend fun getReplicatorInfo(id: String): ReplicatorDocument
	suspend fun evictAllFromMap(mapName: String): String
}

