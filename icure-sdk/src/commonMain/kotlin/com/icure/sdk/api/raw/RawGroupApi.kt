package com.icure.sdk.api.raw

import com.icure.sdk.model.DatabaseInitialisation
import com.icure.sdk.model.Group
import com.icure.sdk.model.GroupDeletionReport
import com.icure.sdk.model.IdWithRev
import com.icure.sdk.model.ListOfIds
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
import com.icure.sdk.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Map

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawGroupApi {
	// region cloud endpoints

	suspend fun createGroup(
		id: String,
		name: String,
		type: GroupType? = null,
		password: String,
		server: String? = null,
		q: Int? = null,
		n: Int? = null,
		superGroup: String? = null,
		initialisationData: DatabaseInitialisation,
	): HttpResponse<Group>

	suspend fun registerNewGroupAdministrator(
		type: GroupType? = null,
		role: PermissionType? = null,
		registrationInformation: RegistrationInformation,
	): HttpResponse<RegistrationSuccess>

	suspend fun listGroups(): HttpResponse<List<Group>>

	suspend fun listApps(): HttpResponse<List<Group>>

	suspend fun findGroups(
		id: String,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<Group>>

	suspend fun findGroupsWithContent(
		id: String,
		searchString: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<Group>>

	suspend fun getGroup(id: String): HttpResponse<Group>

	suspend fun getNameOfGroupParent(id: String): HttpResponse<String>

	suspend fun modifyGroupName(
		id: String,
		name: String,
	): HttpResponse<Group>

	suspend fun getOperationToken(
		operation: Operation,
		duration: Long?,
		description: String? = null,
	): HttpResponse<String>

	suspend fun deleteOperationToken(tokenId: String): HttpResponse<Unit>

	suspend fun setDefaultRoles(
		groupId: String,
		userType: String,
		roleIds: ListOfIds,
	): HttpResponse<Group>

	suspend fun getDefaultRoles(groupId: String): HttpResponse<Map<UserType, List<RoleConfiguration>>>

	suspend fun changeSuperGroup(
		childGroupId: String,
		operationToken: String,
	): HttpResponse<Group>

	suspend fun deleteGroup(id: String): HttpResponse<Group>

	suspend fun hardDeleteGroup(id: String): HttpResponse<List<GroupDeletionReport>>

	suspend fun modifyGroupProperties(
		id: String,
		properties: ListOfProperties,
	): HttpResponse<Group>

	suspend fun setGroupPassword(
		id: String,
		password: String,
	): HttpResponse<Group>

	suspend fun initDesignDocs(
		id: String,
		clazz: String? = null,
		warmup: Boolean?,
		dryRun: Boolean?,
	): HttpResponse<List<DesignDocument>>

	suspend fun solveConflicts(
		groupId: String,
		limit: Int?,
		warmup: Boolean?,
	): HttpResponse<List<IdWithRev>>

	suspend fun resetStorage(
		id: String,
		q: Int? = null,
		n: Int? = null,
		databases: ListOfIds,
	): HttpResponse<Unit>

	suspend fun getGroupsStorageInfos(groups: ListOfIds): HttpResponse<List<GroupDatabasesInfo>>

	suspend fun getReplicationInfo(id: String): HttpResponse<ReplicationInfo>

	suspend fun getHierarchy(id: String): HttpResponse<List<String>>

	suspend fun listAllGroupsIds(): HttpResponse<List<DocIdentifier>>
	// endregion
}
