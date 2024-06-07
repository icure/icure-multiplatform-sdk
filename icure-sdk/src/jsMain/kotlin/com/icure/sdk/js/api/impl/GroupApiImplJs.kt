// auto-generated file
package com.icure.sdk.js.api.`impl`

import com.icure.sdk.api.GroupApi
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefault
import com.icure.sdk.js.api.GroupApiJs
import com.icure.sdk.js.api.GroupApi_createGroup_Options
import com.icure.sdk.js.api.GroupApi_findGroupsWithContent_Options
import com.icure.sdk.js.api.GroupApi_findGroups_Options
import com.icure.sdk.js.api.GroupApi_getOperationToken_Options
import com.icure.sdk.js.api.GroupApi_initDesignDocs_Options
import com.icure.sdk.js.api.GroupApi_registerNewGroupAdministrator_Options
import com.icure.sdk.js.api.GroupApi_resetStorage_Options
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.dynamicToJsonNullsafe
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
import com.icure.sdk.js.model.databaseInitialisation_fromJs
import com.icure.sdk.js.model.embed.RoleConfigurationJs
import com.icure.sdk.js.model.embed.roleConfiguration_toJs
import com.icure.sdk.js.model.groupDeletionReport_toJs
import com.icure.sdk.js.model.group_toJs
import com.icure.sdk.js.model.idWithRev_toJs
import com.icure.sdk.js.model.listOfProperties_fromJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.js.model.registrationInformation_fromJs
import com.icure.sdk.js.model.registrationSuccess_toJs
import com.icure.sdk.js.model.replicationInfo_toJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.model.DatabaseInitialisation
import com.icure.sdk.model.Group
import com.icure.sdk.model.GroupDeletionReport
import com.icure.sdk.model.IdWithRev
import com.icure.sdk.model.ListOfProperties
import com.icure.sdk.model.RegistrationInformation
import com.icure.sdk.model.couchdb.DesignDocument
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.couchdb.GroupDatabasesInfo
import com.icure.sdk.model.embed.GroupType
import com.icure.sdk.model.embed.RoleConfiguration
import com.icure.sdk.model.embed.UserType
import com.icure.sdk.model.security.Operation
import com.icure.sdk.model.security.PermissionType
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import kotlinx.serialization.json.JsonElement

@OptIn(DelicateCoroutinesApi::class)
internal class GroupApiImplJs(
	private val groupApi: GroupApi,
) : GroupApiJs {
	override fun listGroups(): Promise<Array<GroupJs>> = GlobalScope.promise {
		val result = groupApi.listGroups(
		)
		listToArray(
			result,
			{ x1: Group ->
				group_toJs(x1)
			},
		)
	}

	override fun getGroup(id: String): Promise<GroupJs> = GlobalScope.promise {
		val idConverted: String = id
		val result = groupApi.getGroup(
			idConverted,
		)
		group_toJs(result)
	}

	override fun createGroup(
		id: String,
		name: String,
		password: String,
		initialisationData: DatabaseInitialisationJs,
		options: GroupApi_createGroup_Options?,
	): Promise<GroupJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val idConverted: String = id
			val nameConverted: String = name
			val typeConverted: GroupType? = convertingOptionOrDefault(
				_options.type,
				null
			) { type ->
				type?.let { nonNull1 ->
					GroupType.valueOf(nonNull1)
				}
			}
			val passwordConverted: String = password
			val serverConverted: String? = convertingOptionOrDefault(
				_options.server,
				null
			) { server ->
				server
			}
			val qConverted: Int? = convertingOptionOrDefault(
				_options.q,
				null
			) { q ->
				numberToInt(q, "q")
			}
			val nConverted: Int? = convertingOptionOrDefault(
				_options.n,
				null
			) { n ->
				numberToInt(n, "n")
			}
			val superGroupConverted: String? = convertingOptionOrDefault(
				_options.superGroup,
				null
			) { superGroup ->
				superGroup
			}
			val initialisationDataConverted: DatabaseInitialisation =
					databaseInitialisation_fromJs(initialisationData)
			val result = groupApi.createGroup(
				idConverted,
				nameConverted,
				typeConverted,
				passwordConverted,
				serverConverted,
				qConverted,
				nConverted,
				superGroupConverted,
				initialisationDataConverted,
			)
			group_toJs(result)
		}
	}

	override fun registerNewGroupAdministrator(registrationInformation: RegistrationInformationJs,
			options: GroupApi_registerNewGroupAdministrator_Options?): Promise<RegistrationSuccessJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val typeConverted: GroupType? = convertingOptionOrDefault(
				_options.type,
				null
			) { type ->
				type?.let { nonNull1 ->
					GroupType.valueOf(nonNull1)
				}
			}
			val roleConverted: PermissionType? = convertingOptionOrDefault(
				_options.role,
				null
			) { role ->
				role?.let { nonNull1 ->
					PermissionType.valueOf(nonNull1)
				}
			}
			val registrationInformationConverted: RegistrationInformation =
					registrationInformation_fromJs(registrationInformation)
			val result = groupApi.registerNewGroupAdministrator(
				typeConverted,
				roleConverted,
				registrationInformationConverted,
			)
			registrationSuccess_toJs(result)
		}
	}

	override fun listApps(): Promise<Array<GroupJs>> = GlobalScope.promise {
		val result = groupApi.listApps(
		)
		listToArray(
			result,
			{ x1: Group ->
				group_toJs(x1)
			},
		)
	}

	override fun findGroups(id: String, options: GroupApi_findGroups_Options?):
			Promise<PaginatedListJs<GroupJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val idConverted: String = id
			val startDocumentIdConverted: String? = convertingOptionOrDefault(
				_options.startDocumentId,
				null
			) { startDocumentId ->
				startDocumentId
			}
			val limitConverted: Int? = convertingOptionOrDefault(
				_options.limit,
				null
			) { limit ->
				numberToInt(limit, "limit")
			}
			val result = groupApi.findGroups(
				idConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: Group ->
					group_toJs(x1)
				},
			)
		}
	}

	override fun findGroupsWithContent(
		id: String,
		searchString: String,
		options: GroupApi_findGroupsWithContent_Options?,
	): Promise<PaginatedListJs<GroupJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val idConverted: String = id
			val searchStringConverted: String = searchString
			val startKeyConverted: JsonElement? = convertingOptionOrDefault(
				_options.startKey,
				null
			) { startKey ->
				dynamicToJsonNullsafe(startKey, "startKey")
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefault(
				_options.startDocumentId,
				null
			) { startDocumentId ->
				startDocumentId
			}
			val limitConverted: Int? = convertingOptionOrDefault(
				_options.limit,
				null
			) { limit ->
				numberToInt(limit, "limit")
			}
			val result = groupApi.findGroupsWithContent(
				idConverted,
				searchStringConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: Group ->
					group_toJs(x1)
				},
			)
		}
	}

	override fun getNameOfGroupParent(id: String): Promise<String> = GlobalScope.promise {
		val idConverted: String = id
		val result = groupApi.getNameOfGroupParent(
			idConverted,
		)
		result
	}

	override fun modifyGroupName(id: String, name: String): Promise<GroupJs> = GlobalScope.promise {
		val idConverted: String = id
		val nameConverted: String = name
		val result = groupApi.modifyGroupName(
			idConverted,
			nameConverted,
		)
		group_toJs(result)
	}

	override fun getOperationToken(
		operation: String,
		duration: Double?,
		options: GroupApi_getOperationToken_Options?,
	): Promise<String> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val operationConverted: Operation = Operation.valueOf(operation)
			val durationConverted: Long? = numberToLong(duration, "duration")
			val descriptionConverted: String? = convertingOptionOrDefault(
				_options.description,
				null
			) { description ->
				description
			}
			val result = groupApi.getOperationToken(
				operationConverted,
				durationConverted,
				descriptionConverted,
			)
			result
		}
	}

	override fun deleteOperationToken(tokenId: String): Promise<Unit> = GlobalScope.promise {
		val tokenIdConverted: String = tokenId
		groupApi.deleteOperationToken(
			tokenIdConverted,
		)

	}

	override fun setDefaultRoles(
		groupId: String,
		userType: String,
		roleIds: Array<String>,
	): Promise<GroupJs> = GlobalScope.promise {
		val groupIdConverted: String = groupId
		val userTypeConverted: String = userType
		val roleIdsConverted: List<String> = arrayToList(
			roleIds,
			"roleIds",
			{ x1: String ->
				x1
			},
		)
		val result = groupApi.setDefaultRoles(
			groupIdConverted,
			userTypeConverted,
			roleIdsConverted,
		)
		group_toJs(result)
	}

	override fun getDefaultRoles(groupId: String): Promise<Record<String, Array<RoleConfigurationJs>>>
			= GlobalScope.promise {
		val groupIdConverted: String = groupId
		val result = groupApi.getDefaultRoles(
			groupIdConverted,
		)
		mapToObject(
			result,
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
		)
	}

	override fun deleteGroup(id: String): Promise<GroupJs> = GlobalScope.promise {
		val idConverted: String = id
		val result = groupApi.deleteGroup(
			idConverted,
		)
		group_toJs(result)
	}

	override fun changeSuperGroup(childGroupId: String, operationToken: String): Promise<GroupJs> =
			GlobalScope.promise {
		val childGroupIdConverted: String = childGroupId
		val operationTokenConverted: String = operationToken
		val result = groupApi.changeSuperGroup(
			childGroupIdConverted,
			operationTokenConverted,
		)
		group_toJs(result)
	}

	override fun hardDeleteGroup(id: String): Promise<Array<GroupDeletionReportJs>> =
			GlobalScope.promise {
		val idConverted: String = id
		val result = groupApi.hardDeleteGroup(
			idConverted,
		)
		listToArray(
			result,
			{ x1: GroupDeletionReport ->
				groupDeletionReport_toJs(x1)
			},
		)
	}

	override fun modifyGroupProperties(id: String, properties: ListOfPropertiesJs): Promise<GroupJs> =
			GlobalScope.promise {
		val idConverted: String = id
		val propertiesConverted: ListOfProperties = listOfProperties_fromJs(properties)
		val result = groupApi.modifyGroupProperties(
			idConverted,
			propertiesConverted,
		)
		group_toJs(result)
	}

	override fun setGroupPassword(id: String, password: String): Promise<GroupJs> =
			GlobalScope.promise {
		val idConverted: String = id
		val passwordConverted: String = password
		val result = groupApi.setGroupPassword(
			idConverted,
			passwordConverted,
		)
		group_toJs(result)
	}

	override fun initDesignDocs(
		id: String,
		warmup: Boolean?,
		dryRun: Boolean?,
		options: GroupApi_initDesignDocs_Options?,
	): Promise<Array<DesignDocumentJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val idConverted: String = id
			val clazzConverted: String? = convertingOptionOrDefault(
				_options.clazz,
				null
			) { clazz ->
				clazz
			}
			val warmupConverted: Boolean? = warmup
			val dryRunConverted: Boolean? = dryRun
			val result = groupApi.initDesignDocs(
				idConverted,
				clazzConverted,
				warmupConverted,
				dryRunConverted,
			)
			listToArray(
				result,
				{ x1: DesignDocument ->
					designDocument_toJs(x1)
				},
			)
		}
	}

	override fun solveConflicts(
		id: String,
		limit: Double?,
		warmup: Boolean?,
	): Promise<Array<IdWithRevJs>> = GlobalScope.promise {
		val idConverted: String = id
		val limitConverted: Int? = numberToInt(limit, "limit")
		val warmupConverted: Boolean? = warmup
		val result = groupApi.solveConflicts(
			idConverted,
			limitConverted,
			warmupConverted,
		)
		listToArray(
			result,
			{ x1: IdWithRev ->
				idWithRev_toJs(x1)
			},
		)
	}

	override fun resetStorage(
		id: String,
		databases: Array<String>,
		options: GroupApi_resetStorage_Options?,
	): Promise<Unit> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val idConverted: String = id
			val qConverted: Int? = convertingOptionOrDefault(
				_options.q,
				null
			) { q ->
				numberToInt(q, "q")
			}
			val nConverted: Int? = convertingOptionOrDefault(
				_options.n,
				null
			) { n ->
				numberToInt(n, "n")
			}
			val databasesConverted: List<String> = arrayToList(
				databases,
				"databases",
				{ x1: String ->
					x1
				},
			)
			groupApi.resetStorage(
				idConverted,
				qConverted,
				nConverted,
				databasesConverted,
			)

		}
	}

	override fun getGroupsStorageInfos(groups: Array<String>): Promise<Array<GroupDatabasesInfoJs>> =
			GlobalScope.promise {
		val groupsConverted: List<String> = arrayToList(
			groups,
			"groups",
			{ x1: String ->
				x1
			},
		)
		val result = groupApi.getGroupsStorageInfos(
			groupsConverted,
		)
		listToArray(
			result,
			{ x1: GroupDatabasesInfo ->
				groupDatabasesInfo_toJs(x1)
			},
		)
	}

	override fun getReplicationInfo(id: String): Promise<ReplicationInfoJs> = GlobalScope.promise {
		val idConverted: String = id
		val result = groupApi.getReplicationInfo(
			idConverted,
		)
		replicationInfo_toJs(result)
	}

	override fun getHierarchy(id: String): Promise<Array<String>> = GlobalScope.promise {
		val idConverted: String = id
		val result = groupApi.getHierarchy(
			idConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun listAllGroupsIds(): Promise<Array<DocIdentifierJs>> = GlobalScope.promise {
		val result = groupApi.listAllGroupsIds(
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}
}
