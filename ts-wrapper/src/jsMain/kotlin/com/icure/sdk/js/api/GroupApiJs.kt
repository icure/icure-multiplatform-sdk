// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api

import com.icure.sdk.js.model.DatabaseInitialisationJs
import com.icure.sdk.js.model.GroupDeletionReportJs
import com.icure.sdk.js.model.GroupJs
import com.icure.sdk.js.model.IdWithRevJs
import com.icure.sdk.js.model.ListOfPropertiesJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.RegistrationInformationJs
import com.icure.sdk.js.model.RegistrationSuccessJs
import com.icure.sdk.js.model.ReplicationInfoJs
import com.icure.sdk.js.model.couchdb.DesignDocumentJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.GroupDatabasesInfoJs
import com.icure.sdk.js.model.embed.RoleConfigurationJs
import com.icure.sdk.js.utils.Record
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("GroupApi")
public external interface GroupApiJs {
	public fun listGroups(): Promise<Array<GroupJs>>

	public fun getGroup(id: String): Promise<GroupJs>

	public fun createGroup(
		id: String,
		name: String,
		password: String,
		initialisationData: DatabaseInitialisationJs,
		options: GroupApi_createGroup_Options?,
	): Promise<GroupJs>

	public fun registerNewGroupAdministrator(registrationInformation: RegistrationInformationJs,
			options: GroupApi_registerNewGroupAdministrator_Options?): Promise<RegistrationSuccessJs>

	public fun listApps(): Promise<Array<GroupJs>>

	public fun findGroups(id: String, options: GroupApi_findGroups_Options?):
			Promise<PaginatedListJs<GroupJs>>

	public fun findGroupsWithContent(
		id: String,
		searchString: String,
		options: GroupApi_findGroupsWithContent_Options?,
	): Promise<PaginatedListJs<GroupJs>>

	public fun getNameOfGroupParent(id: String): Promise<String>

	public fun modifyGroupName(id: String, name: String): Promise<GroupJs>

	public fun getOperationToken(
		operation: String,
		duration: Double?,
		options: GroupApi_getOperationToken_Options?,
	): Promise<String>

	public fun deleteOperationToken(tokenId: String): Promise<Unit>

	public fun setDefaultRoles(
		groupId: String,
		userType: String,
		roleIds: Array<String>,
	): Promise<GroupJs>

	public fun getDefaultRoles(groupId: String): Promise<Record<String, Array<RoleConfigurationJs>>>

	public fun deleteGroup(id: String): Promise<GroupJs>

	public fun changeSuperGroup(childGroupId: String, operationToken: String): Promise<GroupJs>

	public fun hardDeleteGroup(id: String): Promise<Array<GroupDeletionReportJs>>

	public fun modifyGroupProperties(id: String, properties: ListOfPropertiesJs): Promise<GroupJs>

	public fun setGroupPassword(id: String, password: String): Promise<GroupJs>

	public fun initDesignDocs(
		id: String,
		warmup: Boolean?,
		dryRun: Boolean?,
		options: GroupApi_initDesignDocs_Options?,
	): Promise<Array<DesignDocumentJs>>

	public fun solveConflicts(
		id: String,
		limit: Double?,
		warmup: Boolean?,
	): Promise<Array<IdWithRevJs>>

	public fun resetStorage(
		id: String,
		databases: Array<String>,
		options: GroupApi_resetStorage_Options?,
	): Promise<Unit>

	public fun getGroupsStorageInfos(groups: Array<String>): Promise<Array<GroupDatabasesInfoJs>>

	public fun getReplicationInfo(id: String): Promise<ReplicationInfoJs>

	public fun getHierarchy(id: String): Promise<Array<String>>

	public fun listAllGroupsIds(): Promise<Array<DocIdentifierJs>>
}

public external interface GroupApi_createGroup_Options {
	public val type: String?

	public val server: String?

	public val q: Double?

	public val n: Double?

	public val superGroup: String?
}

public external interface GroupApi_registerNewGroupAdministrator_Options {
	public val type: String?

	public val role: String?
}

public external interface GroupApi_findGroups_Options {
	public val startDocumentId: String?

	public val limit: Double?
}

public external interface GroupApi_findGroupsWithContent_Options {
	public val startKey: dynamic

	public val startDocumentId: String?

	public val limit: Double?
}

public external interface GroupApi_getOperationToken_Options {
	public val description: String?
}

public external interface GroupApi_initDesignDocs_Options {
	public val clazz: String?
}

public external interface GroupApi_resetStorage_Options {
	public val q: Double?

	public val n: Double?
}
