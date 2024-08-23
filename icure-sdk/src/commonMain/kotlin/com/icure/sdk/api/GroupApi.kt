package com.icure.sdk.api

import com.icure.sdk.model.DatabaseInitialisation
import com.icure.sdk.model.Group
import com.icure.sdk.model.GroupDeletionReport
import com.icure.sdk.model.IdWithRev
import com.icure.sdk.model.ListOfProperties
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.RegistrationInformation
import com.icure.sdk.model.RegistrationSuccess
import com.icure.sdk.model.ReplicationInfo
import com.icure.sdk.model.couchdb.DesignDocument
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.couchdb.GroupDatabasesInfo
import com.icure.sdk.model.embed.GroupType
import com.icure.sdk.model.embed.RoleConfiguration
import com.icure.sdk.model.embed.UserType
import com.icure.sdk.model.security.Operation
import com.icure.sdk.model.security.PermissionType
import com.icure.sdk.utils.DefaultValue
import kotlinx.serialization.json.JsonElement

interface GroupApi {
	suspend fun listGroups(): List<Group>
	suspend fun getGroup(id: String): Group
	suspend fun createGroup(
		id: String,
		name: String,
		@DefaultValue("null")
		type: GroupType? = null,
		password: String,
		@DefaultValue("null")
		server: String? = null,
		@DefaultValue("null")
		q: Int? = null,
		@DefaultValue("null")
		n: Int? = null,
		@DefaultValue("null")
		superGroup: String? = null,
		@DefaultValue("null")
		applicationId: String? = null,
		initialisationData: DatabaseInitialisation,
	): Group

	suspend fun registerNewGroupAdministrator(
		@DefaultValue("null")
		type: GroupType? = null,
		@DefaultValue("null")
		role: PermissionType? = null,
		registrationInformation: RegistrationInformation,
	): RegistrationSuccess

	suspend fun listApps(): List<Group>
	suspend fun findGroups(
		id: String,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
	): PaginatedList<Group>

	suspend fun findGroupsWithContent(
		id: String,
		searchString: String,
		@DefaultValue("null")
		startKey: JsonElement? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
	): PaginatedList<Group>

	suspend fun getNameOfGroupParent(id: String): String
	suspend fun modifyGroupName(id: String, name: String): Group
	suspend fun getOperationToken(
		operation: Operation,
		duration: Long?,
		@DefaultValue("null")
		description: String? = null,
	): String

	suspend fun deleteOperationToken(tokenId: String)
	suspend fun setDefaultRoles(
		groupId: String,
		userType: String,
		roleIds: List<String>,
	): Group

	suspend fun getDefaultRoles(groupId: String): Map<UserType, List<RoleConfiguration>>
	suspend fun deleteGroup(id: String): Group
	suspend fun changeSuperGroup(childGroupId: String, operationToken: String): Group
	suspend fun hardDeleteGroup(id: String): List<GroupDeletionReport>
	suspend fun modifyGroupProperties(id: String, properties: ListOfProperties): Group
	suspend fun setGroupPassword(id: String, password: String): Group
	suspend fun initDesignDocs(
		id: String,
		@DefaultValue("null")
		clazz: String? = null,
		warmup: Boolean?,
		dryRun: Boolean?
	): List<DesignDocument>

	suspend fun solveConflicts(id: String, limit: Int?, warmup: Boolean?): List<IdWithRev>
	suspend fun resetStorage(
		id: String,
		@DefaultValue("null")
		q: Int? = null,
		@DefaultValue("null")
		n: Int? = null,
		databases: List<String>
	)
	suspend fun getGroupsStorageInfos(groups: List<String>): List<GroupDatabasesInfo>
	suspend fun getReplicationInfo(id: String): ReplicationInfo
	suspend fun getHierarchy(id: String): List<String>
	suspend fun listAllGroupsIds(): List<DocIdentifier>
}

