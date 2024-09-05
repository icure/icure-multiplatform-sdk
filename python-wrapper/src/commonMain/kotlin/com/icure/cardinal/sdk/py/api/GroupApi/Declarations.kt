// auto-generated file
package com.icure.cardinal.sdk.py.api.GroupApi

import com.icure.cardinal.sdk.CardinalNonCryptoApis
import com.icure.cardinal.sdk.model.DatabaseInitialisation
import com.icure.cardinal.sdk.model.Group
import com.icure.cardinal.sdk.model.GroupDeletionReport
import com.icure.cardinal.sdk.model.IdWithRev
import com.icure.cardinal.sdk.model.ListOfProperties
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.RegistrationInformation
import com.icure.cardinal.sdk.model.RegistrationSuccess
import com.icure.cardinal.sdk.model.ReplicationInfo
import com.icure.cardinal.sdk.model.couchdb.DesignDocument
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.couchdb.GroupDatabasesInfo
import com.icure.cardinal.sdk.model.embed.GroupType
import com.icure.cardinal.sdk.model.embed.RoleConfiguration
import com.icure.cardinal.sdk.model.embed.UserType
import com.icure.cardinal.sdk.model.security.Operation
import com.icure.cardinal.sdk.model.security.PermissionType
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.utils.Serialization.json
import kotlin.Boolean
import kotlin.Byte
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlinx.cinterop.ByteVarOf
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CValues
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.JsonElement

public fun listGroupsBlocking(sdk: CardinalNonCryptoApis): String = kotlin.runCatching {
	runBlocking {
		sdk.group.listGroups()
	}
}.toPyString(ListSerializer(Group.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listGroupsAsync(sdk: CardinalNonCryptoApis,
		resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
		CValues<ByteVarOf<Byte>>?) -> Unit>>): Unit = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.listGroups()
		}.toPyStringAsyncCallback(ListSerializer(Group.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetGroupParams(
	public val id: String,
)

public fun getGroupBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetGroupParams>(params)
	runBlocking {
		sdk.group.getGroup(
			decodedParams.id,
		)
	}
}.toPyString(Group.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getGroupAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.getGroup(
				decodedParams.id,
			)
		}.toPyStringAsyncCallback(Group.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateGroupParams(
	public val id: String,
	public val name: String,
	public val type: GroupType? = null,
	public val password: String,
	public val server: String? = null,
	public val q: Int? = null,
	public val n: Int? = null,
	public val superGroup: String? = null,
	public val applicationId: String? = null,
	public val initialisationData: DatabaseInitialisation,
)

public fun createGroupBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateGroupParams>(params)
	runBlocking {
		sdk.group.createGroup(
			decodedParams.id,
			decodedParams.name,
			decodedParams.type,
			decodedParams.password,
			decodedParams.server,
			decodedParams.q,
			decodedParams.n,
			decodedParams.superGroup,
			decodedParams.applicationId,
			decodedParams.initialisationData,
		)
	}
}.toPyString(Group.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun createGroupAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.createGroup(
				decodedParams.id,
				decodedParams.name,
				decodedParams.type,
				decodedParams.password,
				decodedParams.server,
				decodedParams.q,
				decodedParams.n,
				decodedParams.superGroup,
				decodedParams.applicationId,
				decodedParams.initialisationData,
			)
		}.toPyStringAsyncCallback(Group.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class RegisterNewGroupAdministratorParams(
	public val type: GroupType? = null,
	public val role: PermissionType? = null,
	public val registrationInformation: RegistrationInformation,
)

public fun registerNewGroupAdministratorBlocking(sdk: CardinalNonCryptoApis, params: String): String
		= kotlin.runCatching {
	val decodedParams = json.decodeFromString<RegisterNewGroupAdministratorParams>(params)
	runBlocking {
		sdk.group.registerNewGroupAdministrator(
			decodedParams.type,
			decodedParams.role,
			decodedParams.registrationInformation,
		)
	}
}.toPyString(RegistrationSuccess.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun registerNewGroupAdministratorAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<RegisterNewGroupAdministratorParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.registerNewGroupAdministrator(
				decodedParams.type,
				decodedParams.role,
				decodedParams.registrationInformation,
			)
		}.toPyStringAsyncCallback(RegistrationSuccess.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

public fun listAppsBlocking(sdk: CardinalNonCryptoApis): String = kotlin.runCatching {
	runBlocking {
		sdk.group.listApps()
	}
}.toPyString(ListSerializer(Group.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listAppsAsync(sdk: CardinalNonCryptoApis,
		resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
		CValues<ByteVarOf<Byte>>?) -> Unit>>): Unit = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.listApps()
		}.toPyStringAsyncCallback(ListSerializer(Group.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindGroupsParams(
	public val id: String,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
)

public fun findGroupsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindGroupsParams>(params)
	runBlocking {
		sdk.group.findGroups(
			decodedParams.id,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(Group.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findGroupsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindGroupsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.findGroups(
				decodedParams.id,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(Group.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindGroupsWithContentParams(
	public val id: String,
	public val searchString: String,
	public val startKey: JsonElement? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
)

public fun findGroupsWithContentBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindGroupsWithContentParams>(params)
	runBlocking {
		sdk.group.findGroupsWithContent(
			decodedParams.id,
			decodedParams.searchString,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(Group.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findGroupsWithContentAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindGroupsWithContentParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.findGroupsWithContent(
				decodedParams.id,
				decodedParams.searchString,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(Group.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetNameOfGroupParentParams(
	public val id: String,
)

public fun getNameOfGroupParentBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetNameOfGroupParentParams>(params)
	runBlocking {
		sdk.group.getNameOfGroupParent(
			decodedParams.id,
		)
	}
}.toPyString(String.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getNameOfGroupParentAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetNameOfGroupParentParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.getNameOfGroupParent(
				decodedParams.id,
			)
		}.toPyStringAsyncCallback(String.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyGroupNameParams(
	public val id: String,
	public val name: String,
)

public fun modifyGroupNameBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyGroupNameParams>(params)
	runBlocking {
		sdk.group.modifyGroupName(
			decodedParams.id,
			decodedParams.name,
		)
	}
}.toPyString(Group.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyGroupNameAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyGroupNameParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.modifyGroupName(
				decodedParams.id,
				decodedParams.name,
			)
		}.toPyStringAsyncCallback(Group.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetOperationTokenParams(
	public val operation: Operation,
	public val duration: Long?,
	public val description: String? = null,
)

public fun getOperationTokenBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetOperationTokenParams>(params)
	runBlocking {
		sdk.group.getOperationToken(
			decodedParams.operation,
			decodedParams.duration,
			decodedParams.description,
		)
	}
}.toPyString(String.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getOperationTokenAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetOperationTokenParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.getOperationToken(
				decodedParams.operation,
				decodedParams.duration,
				decodedParams.description,
			)
		}.toPyStringAsyncCallback(String.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteOperationTokenParams(
	public val tokenId: String,
)

public fun deleteOperationTokenBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteOperationTokenParams>(params)
	runBlocking {
		sdk.group.deleteOperationToken(
			decodedParams.tokenId,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun deleteOperationTokenAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteOperationTokenParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.deleteOperationToken(
				decodedParams.tokenId,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SetDefaultRolesParams(
	public val groupId: String,
	public val userType: String,
	public val roleIds: List<String>,
)

public fun setDefaultRolesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<SetDefaultRolesParams>(params)
	runBlocking {
		sdk.group.setDefaultRoles(
			decodedParams.groupId,
			decodedParams.userType,
			decodedParams.roleIds,
		)
	}
}.toPyString(Group.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun setDefaultRolesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<SetDefaultRolesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.setDefaultRoles(
				decodedParams.groupId,
				decodedParams.userType,
				decodedParams.roleIds,
			)
		}.toPyStringAsyncCallback(Group.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetDefaultRolesParams(
	public val groupId: String,
)

public fun getDefaultRolesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetDefaultRolesParams>(params)
	runBlocking {
		sdk.group.getDefaultRoles(
			decodedParams.groupId,
		)
	}
}.toPyString(MapSerializer(UserType.serializer(), ListSerializer(RoleConfiguration.serializer())))

@OptIn(ExperimentalForeignApi::class)
public fun getDefaultRolesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetDefaultRolesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.getDefaultRoles(
				decodedParams.groupId,
			)
		}.toPyStringAsyncCallback(MapSerializer(UserType.serializer(),
				ListSerializer(RoleConfiguration.serializer())), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteGroupParams(
	public val id: String,
)

public fun deleteGroupBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteGroupParams>(params)
	runBlocking {
		sdk.group.deleteGroup(
			decodedParams.id,
		)
	}
}.toPyString(Group.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun deleteGroupAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.deleteGroup(
				decodedParams.id,
			)
		}.toPyStringAsyncCallback(Group.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ChangeSuperGroupParams(
	public val childGroupId: String,
	public val operationToken: String,
)

public fun changeSuperGroupBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ChangeSuperGroupParams>(params)
	runBlocking {
		sdk.group.changeSuperGroup(
			decodedParams.childGroupId,
			decodedParams.operationToken,
		)
	}
}.toPyString(Group.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun changeSuperGroupAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ChangeSuperGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.changeSuperGroup(
				decodedParams.childGroupId,
				decodedParams.operationToken,
			)
		}.toPyStringAsyncCallback(Group.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class HardDeleteGroupParams(
	public val id: String,
)

public fun hardDeleteGroupBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<HardDeleteGroupParams>(params)
	runBlocking {
		sdk.group.hardDeleteGroup(
			decodedParams.id,
		)
	}
}.toPyString(ListSerializer(GroupDeletionReport.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun hardDeleteGroupAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<HardDeleteGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.hardDeleteGroup(
				decodedParams.id,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupDeletionReport.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyGroupPropertiesParams(
	public val id: String,
	public val properties: ListOfProperties,
)

public fun modifyGroupPropertiesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyGroupPropertiesParams>(params)
	runBlocking {
		sdk.group.modifyGroupProperties(
			decodedParams.id,
			decodedParams.properties,
		)
	}
}.toPyString(Group.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyGroupPropertiesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyGroupPropertiesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.modifyGroupProperties(
				decodedParams.id,
				decodedParams.properties,
			)
		}.toPyStringAsyncCallback(Group.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SetGroupPasswordParams(
	public val id: String,
	public val password: String,
)

public fun setGroupPasswordBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<SetGroupPasswordParams>(params)
	runBlocking {
		sdk.group.setGroupPassword(
			decodedParams.id,
			decodedParams.password,
		)
	}
}.toPyString(Group.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun setGroupPasswordAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<SetGroupPasswordParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.setGroupPassword(
				decodedParams.id,
				decodedParams.password,
			)
		}.toPyStringAsyncCallback(Group.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class InitDesignDocsParams(
	public val id: String,
	public val clazz: String? = null,
	public val warmup: Boolean?,
	public val dryRun: Boolean?,
)

public fun initDesignDocsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<InitDesignDocsParams>(params)
	runBlocking {
		sdk.group.initDesignDocs(
			decodedParams.id,
			decodedParams.clazz,
			decodedParams.warmup,
			decodedParams.dryRun,
		)
	}
}.toPyString(ListSerializer(DesignDocument.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun initDesignDocsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<InitDesignDocsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.initDesignDocs(
				decodedParams.id,
				decodedParams.clazz,
				decodedParams.warmup,
				decodedParams.dryRun,
			)
		}.toPyStringAsyncCallback(ListSerializer(DesignDocument.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SolveConflictsParams(
	public val id: String,
	public val limit: Int?,
	public val warmup: Boolean?,
)

public fun solveConflictsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<SolveConflictsParams>(params)
	runBlocking {
		sdk.group.solveConflicts(
			decodedParams.id,
			decodedParams.limit,
			decodedParams.warmup,
		)
	}
}.toPyString(ListSerializer(IdWithRev.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun solveConflictsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<SolveConflictsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.solveConflicts(
				decodedParams.id,
				decodedParams.limit,
				decodedParams.warmup,
			)
		}.toPyStringAsyncCallback(ListSerializer(IdWithRev.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ResetStorageParams(
	public val id: String,
	public val q: Int? = null,
	public val n: Int? = null,
	public val databases: List<String>,
)

public fun resetStorageBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ResetStorageParams>(params)
	runBlocking {
		sdk.group.resetStorage(
			decodedParams.id,
			decodedParams.q,
			decodedParams.n,
			decodedParams.databases,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun resetStorageAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ResetStorageParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.resetStorage(
				decodedParams.id,
				decodedParams.q,
				decodedParams.n,
				decodedParams.databases,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetGroupsStorageInfosParams(
	public val groups: List<String>,
)

public fun getGroupsStorageInfosBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetGroupsStorageInfosParams>(params)
	runBlocking {
		sdk.group.getGroupsStorageInfos(
			decodedParams.groups,
		)
	}
}.toPyString(ListSerializer(GroupDatabasesInfo.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getGroupsStorageInfosAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetGroupsStorageInfosParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.getGroupsStorageInfos(
				decodedParams.groups,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupDatabasesInfo.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetReplicationInfoParams(
	public val id: String,
)

public fun getReplicationInfoBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetReplicationInfoParams>(params)
	runBlocking {
		sdk.group.getReplicationInfo(
			decodedParams.id,
		)
	}
}.toPyString(ReplicationInfo.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getReplicationInfoAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetReplicationInfoParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.getReplicationInfo(
				decodedParams.id,
			)
		}.toPyStringAsyncCallback(ReplicationInfo.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetHierarchyParams(
	public val id: String,
)

public fun getHierarchyBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetHierarchyParams>(params)
	runBlocking {
		sdk.group.getHierarchy(
			decodedParams.id,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getHierarchyAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetHierarchyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.getHierarchy(
				decodedParams.id,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

public fun listAllGroupsIdsBlocking(sdk: CardinalNonCryptoApis): String = kotlin.runCatching {
	runBlocking {
		sdk.group.listAllGroupsIds()
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listAllGroupsIdsAsync(sdk: CardinalNonCryptoApis,
		resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
		CValues<ByteVarOf<Byte>>?) -> Unit>>): Unit = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.listAllGroupsIds()
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
