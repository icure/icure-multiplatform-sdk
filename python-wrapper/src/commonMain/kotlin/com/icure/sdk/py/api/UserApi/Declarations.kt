// auto-generated file
package com.icure.sdk.py.api.UserApi

import com.icure.sdk.IcureNonCryptoApis
import com.icure.sdk.model.EncryptedPropertyStub
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.User
import com.icure.sdk.model.UserGroup
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.security.Enable2faRequest
import com.icure.sdk.model.security.TokenWithGroup
import com.icure.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.py.utils.toPyStringAsyncCallback
import com.icure.sdk.utils.Serialization.json
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
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer

public fun getCurrentUserBlocking(sdk: IcureNonCryptoApis): String = kotlin.runCatching {
	runBlocking {
		sdk.user.getCurrentUser()
	}
}.toPyString(User.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getCurrentUserAsync(sdk: IcureNonCryptoApis,
		resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
		CValues<ByteVarOf<Byte>>?) -> Unit>>): Unit = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.getCurrentUser()
		}.toPyStringAsyncCallback(User.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListUsersByParams(
	public val startKey: String? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
	public val skipPatients: Boolean? = null,
)

public fun listUsersByBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListUsersByParams>(params)
	runBlocking {
		sdk.user.listUsersBy(
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
			decodedParams.skipPatients,
		)
	}
}.toPyString(PaginatedList.serializer(User.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listUsersByAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListUsersByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.listUsersBy(
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
				decodedParams.skipPatients,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(User.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateUserParams(
	public val user: User,
)

public fun createUserBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateUserParams>(params)
	runBlocking {
		sdk.user.createUser(
			decodedParams.user,
		)
	}
}.toPyString(User.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun createUserAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateUserParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.createUser(
				decodedParams.user,
			)
		}.toPyStringAsyncCallback(User.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetUserParams(
	public val userId: String,
)

public fun getUserBlocking(sdk: IcureNonCryptoApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetUserParams>(params)
	runBlocking {
		sdk.user.getUser(
			decodedParams.userId,
		)
	}
}.toPyString(User.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getUserAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetUserParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.getUser(
				decodedParams.userId,
			)
		}.toPyStringAsyncCallback(User.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetUserByEmailParams(
	public val email: String,
)

public fun getUserByEmailBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetUserByEmailParams>(params)
	runBlocking {
		sdk.user.getUserByEmail(
			decodedParams.email,
		)
	}
}.toPyString(User.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getUserByEmailAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetUserByEmailParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.getUserByEmail(
				decodedParams.email,
			)
		}.toPyStringAsyncCallback(User.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetUserByPhoneNumberParams(
	public val phoneNumber: String,
)

public fun getUserByPhoneNumberBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetUserByPhoneNumberParams>(params)
	runBlocking {
		sdk.user.getUserByPhoneNumber(
			decodedParams.phoneNumber,
		)
	}
}.toPyString(User.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getUserByPhoneNumberAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetUserByPhoneNumberParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.getUserByPhoneNumber(
				decodedParams.phoneNumber,
			)
		}.toPyStringAsyncCallback(User.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindByHcpartyIdParams(
	public val id: String,
)

public fun findByHcpartyIdBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindByHcpartyIdParams>(params)
	runBlocking {
		sdk.user.findByHcpartyId(
			decodedParams.id,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findByHcpartyIdAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindByHcpartyIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.findByHcpartyId(
				decodedParams.id,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindByPatientIdParams(
	public val id: String,
)

public fun findByPatientIdBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindByPatientIdParams>(params)
	runBlocking {
		sdk.user.findByPatientId(
			decodedParams.id,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findByPatientIdAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindByPatientIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.findByPatientId(
				decodedParams.id,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteUserParams(
	public val userId: String,
)

public fun deleteUserBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteUserParams>(params)
	runBlocking {
		sdk.user.deleteUser(
			decodedParams.userId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun deleteUserAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteUserParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.deleteUser(
				decodedParams.userId,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyUserParams(
	public val user: User,
)

public fun modifyUserBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyUserParams>(params)
	runBlocking {
		sdk.user.modifyUser(
			decodedParams.user,
		)
	}
}.toPyString(User.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyUserAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyUserParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.modifyUser(
				decodedParams.user,
			)
		}.toPyStringAsyncCallback(User.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class AssignHealthcarePartyParams(
	public val healthcarePartyId: String,
)

public fun assignHealthcarePartyBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<AssignHealthcarePartyParams>(params)
	runBlocking {
		sdk.user.assignHealthcareParty(
			decodedParams.healthcarePartyId,
		)
	}
}.toPyString(User.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun assignHealthcarePartyAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<AssignHealthcarePartyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.assignHealthcareParty(
				decodedParams.healthcarePartyId,
			)
		}.toPyStringAsyncCallback(User.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyPropertiesParams(
	public val userId: String,
	public val properties: List<EncryptedPropertyStub>?,
)

public fun modifyPropertiesBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyPropertiesParams>(params)
	runBlocking {
		sdk.user.modifyProperties(
			decodedParams.userId,
			decodedParams.properties,
		)
	}
}.toPyString(User.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyPropertiesAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyPropertiesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.modifyProperties(
				decodedParams.userId,
				decodedParams.properties,
			)
		}.toPyStringAsyncCallback(User.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetTokenParams(
	public val userId: String,
	public val key: String,
	public val tokenValidity: Long? = null,
	public val token: String? = null,
)

public fun getTokenBlocking(sdk: IcureNonCryptoApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetTokenParams>(params)
	runBlocking {
		sdk.user.getToken(
			decodedParams.userId,
			decodedParams.key,
			decodedParams.tokenValidity,
			decodedParams.token,
		)
	}
}.toPyString(String.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getTokenAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetTokenParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.getToken(
				decodedParams.userId,
				decodedParams.key,
				decodedParams.tokenValidity,
				decodedParams.token,
			)
		}.toPyStringAsyncCallback(String.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterUsersByParams(
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
	public val filterChain: FilterChain<User>,
)

public fun filterUsersByBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterUsersByParams>(params)
	runBlocking {
		sdk.user.filterUsersBy(
			decodedParams.startDocumentId,
			decodedParams.limit,
			decodedParams.filterChain,
		)
	}
}.toPyString(PaginatedList.serializer(User.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun filterUsersByAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterUsersByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.filterUsersBy(
				decodedParams.startDocumentId,
				decodedParams.limit,
				decodedParams.filterChain,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(User.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchUsersByParams(
	@Contextual
	public val filter: AbstractFilter<User>,
)

public fun matchUsersByBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchUsersByParams>(params)
	runBlocking {
		sdk.user.matchUsersBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun matchUsersByAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchUsersByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.matchUsersBy(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

public fun getMatchingUsersBlocking(sdk: IcureNonCryptoApis): String = kotlin.runCatching {
	runBlocking {
		sdk.user.getMatchingUsers()
	}
}.toPyString(ListSerializer(UserGroup.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getMatchingUsersAsync(sdk: IcureNonCryptoApis,
		resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
		CValues<ByteVarOf<Byte>>?) -> Unit>>): Unit = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.getMatchingUsers()
		}.toPyStringAsyncCallback(ListSerializer(UserGroup.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListUsersInGroupParams(
	public val groupId: String,
	public val startKey: String? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
)

public fun listUsersInGroupBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListUsersInGroupParams>(params)
	runBlocking {
		sdk.user.listUsersInGroup(
			decodedParams.groupId,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(User.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listUsersInGroupAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListUsersInGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.listUsersInGroup(
				decodedParams.groupId,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(User.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateUserInGroupParams(
	public val groupId: String,
	public val user: User,
)

public fun createUserInGroupBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateUserInGroupParams>(params)
	runBlocking {
		sdk.user.createUserInGroup(
			decodedParams.groupId,
			decodedParams.user,
		)
	}
}.toPyString(User.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun createUserInGroupAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateUserInGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.createUserInGroup(
				decodedParams.groupId,
				decodedParams.user,
			)
		}.toPyStringAsyncCallback(User.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyUserInGroupParams(
	public val groupId: String,
	public val user: User,
)

public fun modifyUserInGroupBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyUserInGroupParams>(params)
	runBlocking {
		sdk.user.modifyUserInGroup(
			decodedParams.groupId,
			decodedParams.user,
		)
	}
}.toPyString(User.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyUserInGroupAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyUserInGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.modifyUserInGroup(
				decodedParams.groupId,
				decodedParams.user,
			)
		}.toPyStringAsyncCallback(User.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteUserInGroupParams(
	public val groupId: String,
	public val userId: String,
)

public fun deleteUserInGroupBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteUserInGroupParams>(params)
	runBlocking {
		sdk.user.deleteUserInGroup(
			decodedParams.groupId,
			decodedParams.userId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun deleteUserInGroupAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteUserInGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.deleteUserInGroup(
				decodedParams.groupId,
				decodedParams.userId,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class AddRolesToUserParams(
	public val userId: String,
	public val rolesId: ListOfIds,
)

public fun addRolesToUserBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<AddRolesToUserParams>(params)
	runBlocking {
		sdk.user.addRolesToUser(
			decodedParams.userId,
			decodedParams.rolesId,
		)
	}
}.toPyString(User.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun addRolesToUserAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<AddRolesToUserParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.addRolesToUser(
				decodedParams.userId,
				decodedParams.rolesId,
			)
		}.toPyStringAsyncCallback(User.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class AddRolesToUserInGroupParams(
	public val userId: String,
	public val groupId: String,
	public val rolesId: ListOfIds,
)

public fun addRolesToUserInGroupBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<AddRolesToUserInGroupParams>(params)
	runBlocking {
		sdk.user.addRolesToUserInGroup(
			decodedParams.userId,
			decodedParams.groupId,
			decodedParams.rolesId,
		)
	}
}.toPyString(User.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun addRolesToUserInGroupAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<AddRolesToUserInGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.addRolesToUserInGroup(
				decodedParams.userId,
				decodedParams.groupId,
				decodedParams.rolesId,
			)
		}.toPyStringAsyncCallback(User.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class RemoveRolesFromUserParams(
	public val userId: String,
)

public fun removeRolesFromUserBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<RemoveRolesFromUserParams>(params)
	runBlocking {
		sdk.user.removeRolesFromUser(
			decodedParams.userId,
		)
	}
}.toPyString(User.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun removeRolesFromUserAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<RemoveRolesFromUserParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.removeRolesFromUser(
				decodedParams.userId,
			)
		}.toPyStringAsyncCallback(User.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class RemoveRolesFromUserInGroupParams(
	public val userId: String,
	public val groupId: String,
)

public fun removeRolesFromUserInGroupBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<RemoveRolesFromUserInGroupParams>(params)
	runBlocking {
		sdk.user.removeRolesFromUserInGroup(
			decodedParams.userId,
			decodedParams.groupId,
		)
	}
}.toPyString(User.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun removeRolesFromUserInGroupAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<RemoveRolesFromUserInGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.removeRolesFromUserInGroup(
				decodedParams.userId,
				decodedParams.groupId,
			)
		}.toPyStringAsyncCallback(User.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetTokenInGroupParams(
	public val groupId: String,
	public val userId: String,
	public val key: String,
	public val token: String? = null,
	public val tokenValidity: Long? = null,
)

public fun getTokenInGroupBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetTokenInGroupParams>(params)
	runBlocking {
		sdk.user.getTokenInGroup(
			decodedParams.groupId,
			decodedParams.userId,
			decodedParams.key,
			decodedParams.token,
			decodedParams.tokenValidity,
		)
	}
}.toPyString(String.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getTokenInGroupAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetTokenInGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.getTokenInGroup(
				decodedParams.groupId,
				decodedParams.userId,
				decodedParams.key,
				decodedParams.token,
				decodedParams.tokenValidity,
			)
		}.toPyStringAsyncCallback(String.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetTokenInAllGroupsParams(
	public val userIdentifier: String,
	public val key: String,
	public val token: String? = null,
	public val tokenValidity: Long? = null,
)

public fun getTokenInAllGroupsBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetTokenInAllGroupsParams>(params)
	runBlocking {
		sdk.user.getTokenInAllGroups(
			decodedParams.userIdentifier,
			decodedParams.key,
			decodedParams.token,
			decodedParams.tokenValidity,
		)
	}
}.toPyString(ListSerializer(TokenWithGroup.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getTokenInAllGroupsAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetTokenInAllGroupsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.getTokenInAllGroups(
				decodedParams.userIdentifier,
				decodedParams.key,
				decodedParams.token,
				decodedParams.tokenValidity,
			)
		}.toPyStringAsyncCallback(ListSerializer(TokenWithGroup.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterUsersInGroupByParams(
	public val groupId: String,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
	public val filterChain: FilterChain<User>,
)

public fun filterUsersInGroupByBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterUsersInGroupByParams>(params)
	runBlocking {
		sdk.user.filterUsersInGroupBy(
			decodedParams.groupId,
			decodedParams.startDocumentId,
			decodedParams.limit,
			decodedParams.filterChain,
		)
	}
}.toPyString(PaginatedList.serializer(User.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun filterUsersInGroupByAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterUsersInGroupByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.filterUsersInGroupBy(
				decodedParams.groupId,
				decodedParams.startDocumentId,
				decodedParams.limit,
				decodedParams.filterChain,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(User.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class Enable2faForUserWithGroupParams(
	public val userId: String,
	public val groupId: String,
	public val request: Enable2faRequest,
)

public fun enable2faForUserWithGroupBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<Enable2faForUserWithGroupParams>(params)
	runBlocking {
		sdk.user.enable2faForUser(
			decodedParams.userId,
			decodedParams.groupId,
			decodedParams.request,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun enable2faForUserWithGroupAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<Enable2faForUserWithGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.enable2faForUser(
				decodedParams.userId,
				decodedParams.groupId,
				decodedParams.request,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class Enable2faForUserParams(
	public val userId: String,
	public val request: Enable2faRequest,
)

public fun enable2faForUserBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<Enable2faForUserParams>(params)
	runBlocking {
		sdk.user.enable2faForUser(
			decodedParams.userId,
			decodedParams.request,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun enable2faForUserAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<Enable2faForUserParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.enable2faForUser(
				decodedParams.userId,
				decodedParams.request,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class Disable2faForUserWithGroupParams(
	public val userId: String,
	public val groupId: String,
)

public fun disable2faForUserWithGroupBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<Disable2faForUserWithGroupParams>(params)
	runBlocking {
		sdk.user.disable2faForUser(
			decodedParams.userId,
			decodedParams.groupId,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun disable2faForUserWithGroupAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<Disable2faForUserWithGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.disable2faForUser(
				decodedParams.userId,
				decodedParams.groupId,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class Disable2faForUserParams(
	public val userId: String,
)

public fun disable2faForUserBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<Disable2faForUserParams>(params)
	runBlocking {
		sdk.user.disable2faForUser(
			decodedParams.userId,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun disable2faForUserAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<Disable2faForUserParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.disable2faForUser(
				decodedParams.userId,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateAdminUserParams(
	public val user: User,
)

public fun createAdminUserBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateAdminUserParams>(params)
	runBlocking {
		sdk.user.createAdminUser(
			decodedParams.user,
		)
	}
}.toPyString(User.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun createAdminUserAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateAdminUserParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.createAdminUser(
				decodedParams.user,
			)
		}.toPyStringAsyncCallback(User.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateAdminUserInGroupParams(
	public val groupId: String,
	public val user: User,
)

public fun createAdminUserInGroupBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateAdminUserInGroupParams>(params)
	runBlocking {
		sdk.user.createAdminUserInGroup(
			decodedParams.groupId,
			decodedParams.user,
		)
	}
}.toPyString(User.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun createAdminUserInGroupAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateAdminUserInGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.createAdminUserInGroup(
				decodedParams.groupId,
				decodedParams.user,
			)
		}.toPyStringAsyncCallback(User.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
