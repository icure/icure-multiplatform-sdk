package com.icure.sdk.api

import com.icure.sdk.api.flavoured.encodeStartKey
import com.icure.sdk.api.raw.RawGroupApi
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
import kotlinx.serialization.json.JsonElement

@OptIn(InternalIcureApi::class)
class GroupApi(
    private val rawApi: RawGroupApi,
) {
    suspend fun listGroups(): List<Group> = rawApi.listGroups().successBody()
    suspend fun getGroup(id: String): Group = rawApi.getGroup(id).successBody()
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
    ): Group = rawApi.createGroup(
        id,
        name,
        type,
        password,
        server,
        q,
        n,
        superGroup,
        initialisationData,
    ).successBody()

    suspend fun registerNewGroupAdministrator(
        type: GroupType? = null,
        role: PermissionType? = null,
        registrationInformation: RegistrationInformation,
    ): RegistrationSuccess = rawApi.registerNewGroupAdministrator(type, role, registrationInformation).successBody()

    suspend fun listApps(): List<Group> = rawApi.listApps().successBody()

    suspend fun findGroups(
        id: String,
        startDocumentId: String? = null,
        limit: Int? = null,
    ): PaginatedList<Group> = rawApi.findGroups(id, startDocumentId, limit).successBody()

    suspend fun findGroupsWithContent(
        id: String,
        searchString: String,
        startKey: JsonElement? = null,
        startDocumentId: String? = null,
        limit: Int? = null,
    ): PaginatedList<Group> =
        rawApi.findGroupsWithContent(id, searchString, startKey.encodeStartKey(), startDocumentId, limit).successBody()

    suspend fun getNameOfGroupParent(id: String): String = rawApi.getNameOfGroupParent(id).successBody()

    suspend fun modifyGroupName(id: String, name: String): Group = rawApi.modifyGroupName(id, name).successBody()

    suspend fun getOperationToken(
        operation: Operation,
        duration: Long?,
        description: String? = null,
    ): String = rawApi.getOperationToken(operation, duration, description).successBody()

    suspend fun deleteOperationToken(tokenId: String): Unit = rawApi.deleteOperationToken(tokenId).successBody()

    suspend fun setDefaultRoles(
        groupId: String,
        userType: String,
        roleIds: ListOfIds,
    ): Group = rawApi.setDefaultRoles(groupId, userType, roleIds).successBody()

    suspend fun getDefaultRoles(groupId: String): Map<UserType, List<RoleConfiguration>> =
        rawApi.getDefaultRoles(groupId).successBody()

    suspend fun deleteGroup(id: String): Group = rawApi.deleteGroup(id).successBody()
    suspend fun changeSuperGroup(childGroupId: String, operationToken: String): Group =
        rawApi.changeSuperGroup(childGroupId, operationToken).successBody()

    suspend fun hardDeleteGroup(id: String): List<GroupDeletionReport> = rawApi.hardDeleteGroup(id).successBody()
    suspend fun modifyGroupProperties(id: String, properties: ListOfProperties): Group =
        rawApi.modifyGroupProperties(id, properties).successBody()

    suspend fun setGroupPassword(id: String, password: String): Group =
        rawApi.setGroupPassword(id, password).successBody()

    suspend fun initDesignDocs(
        id: String,
        clazz: String? = null,
        warmup: Boolean?,
        dryRun: Boolean?
    ): List<DesignDocument> = rawApi.initDesignDocs(id, clazz, warmup, dryRun).successBody()

    suspend fun solveConflicts(id: String, limit: Int?, warmup: Boolean?): List<IdWithRev> =
        rawApi.solveConflicts(id, limit, warmup).successBody()

    suspend fun resetStorage(id: String, q: Int? = null, n: Int? = null, databases: ListOfIds): Unit =
        rawApi.resetStorage(id, q, n, databases).successBody()

    suspend fun getGroupsStorageInfos(groups: ListOfIds): List<GroupDatabasesInfo> =
        rawApi.getGroupsStorageInfos(groups).successBody()

    suspend fun getReplicationInfo(id: String): ReplicationInfo = rawApi.getReplicationInfo(id).successBody()
    suspend fun getHierarchy(id: String): List<String> = rawApi.getHierarchy(id).successBody()
    suspend fun listAllGroupsIds(): List<DocIdentifier> = rawApi.listAllGroupsIds().successBody()
}
