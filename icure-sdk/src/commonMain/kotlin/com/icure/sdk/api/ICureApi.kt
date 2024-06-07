package com.icure.sdk.api

import com.icure.sdk.api.raw.RawICureApi
import com.icure.sdk.model.IdWithRev
import com.icure.sdk.model.IndexingInfo
import com.icure.sdk.model.ReplicationInfo
import com.icure.sdk.model.couchdb.ReplicatorDocument
import com.icure.sdk.utils.DefaultValue
import com.icure.sdk.utils.InternalIcureApi

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

@InternalIcureApi
internal class ICureApiImpl(
	private val rawApi: RawICureApi,
) : ICureApi {
	override suspend fun getVersion() = rawApi.getVersion().successBody()
	override suspend fun isReady() = rawApi.isReady().successBody()
	override suspend fun getProcessInfo() = rawApi.getProcessInfo().successBody()
	override suspend fun getIndexingInfo() = rawApi.getIndexingInfo().successBody()
	override suspend fun getReplicationInfo() = rawApi.getReplicationInfo().successBody()
	override suspend fun updateDesignDoc(
		entityName: String,
		warmup: Boolean?,
	) = rawApi.updateDesignDoc(entityName, warmup).successBody()

	override suspend fun resolvePatientsConflicts(limit: Int?) = rawApi.resolvePatientsConflicts(limit).successBody()
	override suspend fun resolveContactsConflicts(limit: Int?) = rawApi.resolveContactsConflicts(limit).successBody()
	override suspend fun resolveFormsConflicts(limit: Int?) = rawApi.resolveFormsConflicts(limit).successBody()
	override suspend fun resolveHealthElementsConflicts(limit: Int?) = rawApi.resolveHealthElementsConflicts(limit).successBody()
	override suspend fun resolveInvoicesConflicts(limit: Int?) = rawApi.resolveInvoicesConflicts(limit).successBody()
	override suspend fun resolveMessagesConflicts(limit: Int?) = rawApi.resolveMessagesConflicts(limit).successBody()
	override suspend fun resolveDocumentsConflicts(
		ids: String?,
		limit: Int?,
	) = rawApi.resolveDocumentsConflicts(ids, limit).successBody()

	override suspend fun getIndexingInfoByGroup(groupId: String) = rawApi.getIndexingInfoByGroup(groupId).successBody()
	override suspend fun getReplicatorInfo(id: String) = rawApi.getReplicatorInfo(id).successBody()
	override suspend fun evictAllFromMap(mapName: String) = rawApi.evictAllFromMap(mapName).successBody()
}

