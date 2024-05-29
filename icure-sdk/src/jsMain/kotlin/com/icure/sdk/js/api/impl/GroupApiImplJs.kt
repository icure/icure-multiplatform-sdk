// auto-generated file
package com.icure.sdk.js.api.`impl`

import com.icure.sdk.api.GroupApi
import com.icure.sdk.js.api.GroupApiJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.mapToObject
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.numberToLong
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
import com.icure.sdk.js.model.couchdb.designDocument_toJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.couchdb.groupDatabasesInfo_toJs
import com.icure.sdk.js.model.embed.RoleConfigurationJs
import com.icure.sdk.js.model.embed.roleConfiguration_toJs
import com.icure.sdk.js.model.groupDeletionReport_toJs
import com.icure.sdk.js.model.group_toJs
import com.icure.sdk.js.model.idWithRev_toJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.js.model.registrationSuccess_toJs
import com.icure.sdk.js.model.replicationInfo_toJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.model.Group
import com.icure.sdk.model.GroupDeletionReport
import com.icure.sdk.model.IdWithRev
import com.icure.sdk.model.couchdb.DesignDocument
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.couchdb.GroupDatabasesInfo
import com.icure.sdk.model.embed.RoleConfiguration
import com.icure.sdk.model.embed.UserType
import com.icure.sdk.model.security.Operation
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class GroupApiImplJs(
	private val groupApi: GroupApi,
) : GroupApiJs {
	override fun listGroups(): Promise<Array<GroupJs>> = GlobalScope.promise {
		listToArray(
			groupApi.listGroups(),
			{ x1: Group ->
				group_toJs(x1)
			},
		)}


	override fun getGroup(id: String): Promise<GroupJs> = GlobalScope.promise {
		group_toJs(groupApi.getGroup(id))}


	override fun createGroup(
		id: String,
		name: String,
		type: String?,
		password: String,
		server: String?,
		q: Double?,
		n: Double?,
		superGroup: String?,
		initialisationData: DatabaseInitialisationJs,
	): Promise<GroupJs> = GlobalScope.promise {
		group_toJs(groupApi.createGroup(id, name, type?.let { nonNull1 ->
		  com.icure.sdk.model.embed.GroupType.valueOf(nonNull1)
		}, password, server, com.icure.sdk.js.model.CheckedConverters.numberToInt(q, "q"),
				com.icure.sdk.js.model.CheckedConverters.numberToInt(n, "n"), superGroup,
				com.icure.sdk.js.model.databaseInitialisation_fromJs(initialisationData)))}


	override fun registerNewGroupAdministrator(
		type: String?,
		role: String?,
		registrationInformation: RegistrationInformationJs,
	): Promise<RegistrationSuccessJs> = GlobalScope.promise {
		registrationSuccess_toJs(groupApi.registerNewGroupAdministrator(type?.let { nonNull1 ->
		  com.icure.sdk.model.embed.GroupType.valueOf(nonNull1)
		}, role?.let { nonNull1 ->
		  com.icure.sdk.model.security.PermissionType.valueOf(nonNull1)
		}, com.icure.sdk.js.model.registrationInformation_fromJs(registrationInformation)))}


	override fun listApps(): Promise<Array<GroupJs>> = GlobalScope.promise {
		listToArray(
			groupApi.listApps(),
			{ x1: Group ->
				group_toJs(x1)
			},
		)}


	override fun findGroups(
		id: String,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<GroupJs>> = GlobalScope.promise {
		paginatedList_toJs(
			groupApi.findGroups(id, startDocumentId,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
			{ x1: Group ->
				group_toJs(x1)
			},
		)}


	override fun findGroupsWithContent(
		id: String,
		searchString: String,
		startKey: dynamic,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<GroupJs>> = GlobalScope.promise {
		paginatedList_toJs(
			groupApi.findGroupsWithContent(id, searchString,
					com.icure.sdk.js.model.CheckedConverters.dynamicToJsonNullsafe(startKey, "startKey"),
					startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
			{ x1: Group ->
				group_toJs(x1)
			},
		)}


	override fun getNameOfGroupParent(id: String): Promise<String> = GlobalScope.promise {
		groupApi.getNameOfGroupParent(id)}


	override fun modifyGroupName(id: String, name: String): Promise<GroupJs> = GlobalScope.promise {
		group_toJs(groupApi.modifyGroupName(id, name))}


	override fun getOperationToken(
		operation: String,
		duration: Double?,
		description: String?,
	): Promise<String> = GlobalScope.promise {
		groupApi.getOperationToken(Operation.valueOf(operation), numberToLong(duration, "duration"),
				description)}


	override fun deleteOperationToken(tokenId: String): Promise<Unit> = GlobalScope.promise {
		groupApi.deleteOperationToken(tokenId)}


	override fun setDefaultRoles(
		groupId: String,
		userType: String,
		roleIds: Array<String>,
	): Promise<GroupJs> = GlobalScope.promise {
		group_toJs(groupApi.setDefaultRoles(groupId, userType,
				com.icure.sdk.js.model.CheckedConverters.arrayToList(
		  roleIds,
		  "roleIds",
		  { x1: kotlin.String ->
		    x1
		  },
		)))}


	override fun getDefaultRoles(groupId: String): Promise<Record<String, Array<RoleConfigurationJs>>>
			= GlobalScope.promise {
		mapToObject(
			groupApi.getDefaultRoles(groupId),
			{ x1: UserType ->
				x1.name
			},
			{ x1: List<RoleConfiguration> ->
				listToArray(
					x1,
					{ x2: RoleConfiguration ->
						roleConfiguration_toJs(x2)
					},
				)
			},
		)}


	override fun deleteGroup(id: String): Promise<GroupJs> = GlobalScope.promise {
		group_toJs(groupApi.deleteGroup(id))}


	override fun changeSuperGroup(childGroupId: String, operationToken: String): Promise<GroupJs> =
			GlobalScope.promise {
		group_toJs(groupApi.changeSuperGroup(childGroupId, operationToken))}


	override fun hardDeleteGroup(id: String): Promise<Array<GroupDeletionReportJs>> =
			GlobalScope.promise {
		listToArray(
			groupApi.hardDeleteGroup(id),
			{ x1: GroupDeletionReport ->
				groupDeletionReport_toJs(x1)
			},
		)}


	override fun modifyGroupProperties(id: String, properties: ListOfPropertiesJs): Promise<GroupJs> =
			GlobalScope.promise {
		group_toJs(groupApi.modifyGroupProperties(id,
				com.icure.sdk.js.model.listOfProperties_fromJs(properties)))}


	override fun setGroupPassword(id: String, password: String): Promise<GroupJs> =
			GlobalScope.promise {
		group_toJs(groupApi.setGroupPassword(id, password))}


	override fun initDesignDocs(
		id: String,
		clazz: String?,
		warmup: Boolean?,
		dryRun: Boolean?,
	): Promise<Array<DesignDocumentJs>> = GlobalScope.promise {
		listToArray(
			groupApi.initDesignDocs(id, clazz, warmup, dryRun),
			{ x1: DesignDocument ->
				designDocument_toJs(x1)
			},
		)}


	override fun solveConflicts(
		id: String,
		limit: Double?,
		warmup: Boolean?,
	): Promise<Array<IdWithRevJs>> = GlobalScope.promise {
		listToArray(
			groupApi.solveConflicts(id, numberToInt(limit, "limit"), warmup),
			{ x1: IdWithRev ->
				idWithRev_toJs(x1)
			},
		)}


	override fun resetStorage(
		id: String,
		q: Double?,
		n: Double?,
		databases: Array<String>,
	): Promise<Unit> = GlobalScope.promise {
		groupApi.resetStorage(id, numberToInt(q, "q"), numberToInt(n, "n"), arrayToList(
			databases,
			"databases",
			{ x1: String ->
				x1
			},
		))}


	override fun getGroupsStorageInfos(groups: Array<String>): Promise<Array<GroupDatabasesInfoJs>> =
			GlobalScope.promise {
		listToArray(
			groupApi.getGroupsStorageInfos(arrayToList(
				groups,
				"groups",
				{ x1: String ->
					x1
				},
			)),
			{ x1: GroupDatabasesInfo ->
				groupDatabasesInfo_toJs(x1)
			},
		)}


	override fun getReplicationInfo(id: String): Promise<ReplicationInfoJs> = GlobalScope.promise {
		replicationInfo_toJs(groupApi.getReplicationInfo(id))}


	override fun getHierarchy(id: String): Promise<Array<String>> = GlobalScope.promise {
		listToArray(
			groupApi.getHierarchy(id),
			{ x1: String ->
				x1
			},
		)}


	override fun listAllGroupsIds(): Promise<Array<DocIdentifierJs>> = GlobalScope.promise {
		listToArray(
			groupApi.listAllGroupsIds(),
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)}

}
