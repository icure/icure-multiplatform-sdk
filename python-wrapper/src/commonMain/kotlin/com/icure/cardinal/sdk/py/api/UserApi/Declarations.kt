// auto-generated file
package com.icure.cardinal.sdk.py.api.UserApi

import com.icure.cardinal.sdk.CardinalNonCryptoApis
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.EncryptedPropertyStub
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.UserGroup
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.security.Enable2faRequest
import com.icure.cardinal.sdk.model.security.TokenWithGroup
import com.icure.cardinal.sdk.py.utils.PaginatedListIterator.PaginatedListIteratorAndSerializer
import com.icure.cardinal.sdk.py.utils.PyResult
import com.icure.cardinal.sdk.py.utils.failureToPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyResult
import com.icure.cardinal.sdk.py.utils.toPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
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
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CValues
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer

@Serializable
private class DeleteUserUnsafeParams(
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun deleteUserUnsafeBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteUserUnsafeParams>(params)
	runBlocking {
		sdk.user.deleteUser(
			decodedParams.entityId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteUserUnsafeAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteUserUnsafeParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.deleteUser(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

public fun getCurrentUserBlocking(sdk: CardinalNonCryptoApis): String = kotlin.runCatching {
	runBlocking {
		sdk.user.getCurrentUser()
	}
}.toPyString(User.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getCurrentUserAsync(sdk: CardinalNonCryptoApis,
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

@OptIn(InternalIcureApi::class)
public fun listUsersByBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListUsersByParams>(params)
	runBlocking {
		sdk.user.listUsersBy(
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
			decodedParams.skipPatients,
		)
	}
}.toPyString(PaginatedList.serializer(User.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listUsersByAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListUsersByParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun createUserBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateUserParams>(params)
	runBlocking {
		sdk.user.createUser(
			decodedParams.user,
		)
	}
}.toPyString(User.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createUserAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateUserParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun getUserBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetUserParams>(params)
	runBlocking {
		sdk.user.getUser(
			decodedParams.userId,
		)
	}
}.toPyString(User.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getUserAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetUserParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.getUser(
				decodedParams.userId,
			)
		}.toPyStringAsyncCallback(User.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetUsersParams(
	public val userIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getUsersBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetUsersParams>(params)
	runBlocking {
		sdk.user.getUsers(
			decodedParams.userIds,
		)
	}
}.toPyString(ListSerializer(User.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getUsersAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetUsersParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.getUsers(
				decodedParams.userIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(User.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetUserByEmailParams(
	public val email: String,
)

@OptIn(InternalIcureApi::class)
public fun getUserByEmailBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetUserByEmailParams>(params)
	runBlocking {
		sdk.user.getUserByEmail(
			decodedParams.email,
		)
	}
}.toPyString(User.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getUserByEmailAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetUserByEmailParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun getUserByPhoneNumberBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetUserByPhoneNumberParams>(params)
	runBlocking {
		sdk.user.getUserByPhoneNumber(
			decodedParams.phoneNumber,
		)
	}
}.toPyString(User.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getUserByPhoneNumberAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetUserByPhoneNumberParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun findByHcpartyIdBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindByHcpartyIdParams>(params)
	runBlocking {
		sdk.user.findByHcpartyId(
			decodedParams.id,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findByHcpartyIdAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindByHcpartyIdParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun findByPatientIdBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindByPatientIdParams>(params)
	runBlocking {
		sdk.user.findByPatientId(
			decodedParams.id,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findByPatientIdAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindByPatientIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.findByPatientId(
				decodedParams.id,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyUserParams(
	public val user: User,
)

@OptIn(InternalIcureApi::class)
public fun modifyUserBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyUserParams>(params)
	runBlocking {
		sdk.user.modifyUser(
			decodedParams.user,
		)
	}
}.toPyString(User.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyUserAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyUserParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun assignHealthcarePartyBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<AssignHealthcarePartyParams>(params)
	runBlocking {
		sdk.user.assignHealthcareParty(
			decodedParams.healthcarePartyId,
		)
	}
}.toPyString(User.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun assignHealthcarePartyAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<AssignHealthcarePartyParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun modifyPropertiesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyPropertiesParams>(params)
	runBlocking {
		sdk.user.modifyProperties(
			decodedParams.userId,
			decodedParams.properties,
		)
	}
}.toPyString(User.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyPropertiesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyPropertiesParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun getTokenBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetTokenParams>(params)
	runBlocking {
		sdk.user.getToken(
			decodedParams.userId,
			decodedParams.key,
			decodedParams.tokenValidity,
			decodedParams.token,
		)
	}
}.toPyString(String.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getTokenAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetTokenParams>(params)
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
	public val filter: BaseFilterOptions<User>,
)

@OptIn(InternalIcureApi::class)
public fun filterUsersByBlocking(sdk: CardinalNonCryptoApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterUsersByParams>(params)
	runBlocking {
		sdk.user.filterUsersBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, User.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterUsersByAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterUsersByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.filterUsersBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, User.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class MatchUsersByParams(
	public val filter: BaseFilterOptions<User>,
)

@OptIn(InternalIcureApi::class)
public fun matchUsersByBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchUsersByParams>(params)
	runBlocking {
		sdk.user.matchUsersBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchUsersByAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchUsersByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.matchUsersBy(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterUsersBySortedParams(
	public val filter: BaseSortableFilterOptions<User>,
)

@OptIn(InternalIcureApi::class)
public fun filterUsersBySortedBlocking(sdk: CardinalNonCryptoApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterUsersBySortedParams>(params)
	runBlocking {
		sdk.user.filterUsersBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, User.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterUsersBySortedAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterUsersBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.filterUsersBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, User.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class MatchUsersBySortedParams(
	public val filter: BaseSortableFilterOptions<User>,
)

@OptIn(InternalIcureApi::class)
public fun matchUsersBySortedBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchUsersBySortedParams>(params)
	runBlocking {
		sdk.user.matchUsersBySorted(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchUsersBySortedAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchUsersBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.matchUsersBySorted(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

public fun getMatchingUsersBlocking(sdk: CardinalNonCryptoApis): String = kotlin.runCatching {
	runBlocking {
		sdk.user.getMatchingUsers()
	}
}.toPyString(ListSerializer(UserGroup.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getMatchingUsersAsync(sdk: CardinalNonCryptoApis,
		resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
		CValues<ByteVarOf<Byte>>?) -> Unit>>): Unit = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.getMatchingUsers()
		}.toPyStringAsyncCallback(ListSerializer(UserGroup.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetUsersInGroupParams(
	public val groupId: String,
	public val userIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getUsersInGroupBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetUsersInGroupParams>(params)
	runBlocking {
		sdk.user.getUsersInGroup(
			decodedParams.groupId,
			decodedParams.userIds,
		)
	}
}.toPyString(ListSerializer(User.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getUsersInGroupAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetUsersInGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.getUsersInGroup(
				decodedParams.groupId,
				decodedParams.userIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(User.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListUsersInGroupParams(
	public val groupId: String,
	public val startKey: String? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
)

@OptIn(InternalIcureApi::class)
public fun listUsersInGroupBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListUsersInGroupParams>(params)
	runBlocking {
		sdk.user.listUsersInGroup(
			decodedParams.groupId,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(User.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listUsersInGroupAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListUsersInGroupParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun createUserInGroupBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateUserInGroupParams>(params)
	runBlocking {
		sdk.user.createUserInGroup(
			decodedParams.groupId,
			decodedParams.user,
		)
	}
}.toPyString(User.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createUserInGroupAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateUserInGroupParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun modifyUserInGroupBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyUserInGroupParams>(params)
	runBlocking {
		sdk.user.modifyUserInGroup(
			decodedParams.groupId,
			decodedParams.user,
		)
	}
}.toPyString(User.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyUserInGroupAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyUserInGroupParams>(params)
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
private class SetUserRolesParams(
	public val userId: String,
	public val rolesId: ListOfIds,
)

@OptIn(InternalIcureApi::class)
public fun setUserRolesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SetUserRolesParams>(params)
	runBlocking {
		sdk.user.setUserRoles(
			decodedParams.userId,
			decodedParams.rolesId,
		)
	}
}.toPyString(User.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun setUserRolesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SetUserRolesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.setUserRoles(
				decodedParams.userId,
				decodedParams.rolesId,
			)
		}.toPyStringAsyncCallback(User.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SetUserRolesInGroupParams(
	public val userId: String,
	public val groupId: String,
	public val rolesId: ListOfIds,
)

@OptIn(InternalIcureApi::class)
public fun setUserRolesInGroupBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SetUserRolesInGroupParams>(params)
	runBlocking {
		sdk.user.setUserRolesInGroup(
			decodedParams.userId,
			decodedParams.groupId,
			decodedParams.rolesId,
		)
	}
}.toPyString(User.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun setUserRolesInGroupAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SetUserRolesInGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.setUserRolesInGroup(
				decodedParams.userId,
				decodedParams.groupId,
				decodedParams.rolesId,
			)
		}.toPyStringAsyncCallback(User.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ResetUserRolesParams(
	public val userId: String,
)

@OptIn(InternalIcureApi::class)
public fun resetUserRolesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ResetUserRolesParams>(params)
	runBlocking {
		sdk.user.resetUserRoles(
			decodedParams.userId,
		)
	}
}.toPyString(User.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun resetUserRolesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ResetUserRolesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.resetUserRoles(
				decodedParams.userId,
			)
		}.toPyStringAsyncCallback(User.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ResetUserRolesInGroupParams(
	public val userId: String,
	public val groupId: String,
)

@OptIn(InternalIcureApi::class)
public fun resetUserRolesInGroupBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ResetUserRolesInGroupParams>(params)
	runBlocking {
		sdk.user.resetUserRolesInGroup(
			decodedParams.userId,
			decodedParams.groupId,
		)
	}
}.toPyString(User.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun resetUserRolesInGroupAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ResetUserRolesInGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.resetUserRolesInGroup(
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

@OptIn(InternalIcureApi::class)
public fun getTokenInGroupBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetTokenInGroupParams>(params)
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

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getTokenInGroupAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetTokenInGroupParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun getTokenInAllGroupsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetTokenInAllGroupsParams>(params)
	runBlocking {
		sdk.user.getTokenInAllGroups(
			decodedParams.userIdentifier,
			decodedParams.key,
			decodedParams.token,
			decodedParams.tokenValidity,
		)
	}
}.toPyString(ListSerializer(TokenWithGroup.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getTokenInAllGroupsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetTokenInAllGroupsParams>(params)
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
	public val filter: BaseFilterOptions<User>,
)

@OptIn(InternalIcureApi::class)
public fun filterUsersInGroupByBlocking(sdk: CardinalNonCryptoApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterUsersInGroupByParams>(params)
	runBlocking {
		sdk.user.filterUsersInGroupBy(
			decodedParams.groupId,
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, User.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterUsersInGroupByAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterUsersInGroupByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.filterUsersInGroupBy(
				decodedParams.groupId,
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, User.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class MatchUsersInGroupByParams(
	public val groupId: String,
	public val filter: BaseFilterOptions<User>,
)

@OptIn(InternalIcureApi::class)
public fun matchUsersInGroupByBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchUsersInGroupByParams>(params)
	runBlocking {
		sdk.user.matchUsersInGroupBy(
			decodedParams.groupId,
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchUsersInGroupByAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchUsersInGroupByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.matchUsersInGroupBy(
				decodedParams.groupId,
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterUsersInGroupBySortedParams(
	public val groupId: String,
	public val filter: BaseSortableFilterOptions<User>,
)

@OptIn(InternalIcureApi::class)
public fun filterUsersInGroupBySortedBlocking(sdk: CardinalNonCryptoApis, params: String): PyResult
		= kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterUsersInGroupBySortedParams>(params)
	runBlocking {
		sdk.user.filterUsersInGroupBySorted(
			decodedParams.groupId,
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, User.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterUsersInGroupBySortedAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterUsersInGroupBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.filterUsersInGroupBySorted(
				decodedParams.groupId,
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, User.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class MatchUsersInGroupBySortedParams(
	public val groupId: String,
	public val filter: BaseSortableFilterOptions<User>,
)

@OptIn(InternalIcureApi::class)
public fun matchUsersInGroupBySortedBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<MatchUsersInGroupBySortedParams>(params)
	runBlocking {
		sdk.user.matchUsersInGroupBySorted(
			decodedParams.groupId,
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchUsersInGroupBySortedAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<MatchUsersInGroupBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.matchUsersInGroupBySorted(
				decodedParams.groupId,
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class Enable2faForUserWithGroupParams(
	public val userId: String,
	public val groupId: String,
	public val request: Enable2faRequest,
)

@OptIn(InternalIcureApi::class)
public fun enable2faForUserWithGroupBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<Enable2faForUserWithGroupParams>(params)
	runBlocking {
		sdk.user.enable2faForUser(
			decodedParams.userId,
			decodedParams.groupId,
			decodedParams.request,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun enable2faForUserWithGroupAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<Enable2faForUserWithGroupParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun enable2faForUserBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<Enable2faForUserParams>(params)
	runBlocking {
		sdk.user.enable2faForUser(
			decodedParams.userId,
			decodedParams.request,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun enable2faForUserAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<Enable2faForUserParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun disable2faForUserWithGroupBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<Disable2faForUserWithGroupParams>(params)
	runBlocking {
		sdk.user.disable2faForUser(
			decodedParams.userId,
			decodedParams.groupId,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun disable2faForUserWithGroupAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<Disable2faForUserWithGroupParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun disable2faForUserBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<Disable2faForUserParams>(params)
	runBlocking {
		sdk.user.disable2faForUser(
			decodedParams.userId,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun disable2faForUserAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<Disable2faForUserParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun createAdminUserBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateAdminUserParams>(params)
	runBlocking {
		sdk.user.createAdminUser(
			decodedParams.user,
		)
	}
}.toPyString(User.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createAdminUserAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateAdminUserParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun createAdminUserInGroupBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateAdminUserInGroupParams>(params)
	runBlocking {
		sdk.user.createAdminUserInGroup(
			decodedParams.groupId,
			decodedParams.user,
		)
	}
}.toPyString(User.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createAdminUserInGroupAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateAdminUserInGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.createAdminUserInGroup(
				decodedParams.groupId,
				decodedParams.user,
			)
		}.toPyStringAsyncCallback(User.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteUserByIdParams(
	public val entityId: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun deleteUserByIdBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteUserByIdParams>(params)
	runBlocking {
		sdk.user.deleteUserById(
			decodedParams.entityId,
			decodedParams.rev,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteUserByIdAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteUserByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.deleteUserById(
				decodedParams.entityId,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteUserInGroupByIdParams(
	public val groupId: String,
	public val entityId: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun deleteUserInGroupByIdBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteUserInGroupByIdParams>(params)
	runBlocking {
		sdk.user.deleteUserInGroupById(
			decodedParams.groupId,
			decodedParams.entityId,
			decodedParams.rev,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteUserInGroupByIdAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteUserInGroupByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.deleteUserInGroupById(
				decodedParams.groupId,
				decodedParams.entityId,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeUserByIdParams(
	public val id: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun purgeUserByIdBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeUserByIdParams>(params)
	runBlocking {
		sdk.user.purgeUserById(
			decodedParams.id,
			decodedParams.rev,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeUserByIdAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeUserByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.purgeUserById(
				decodedParams.id,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteUserByIdParams(
	public val id: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun undeleteUserByIdBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteUserByIdParams>(params)
	runBlocking {
		sdk.user.undeleteUserById(
			decodedParams.id,
			decodedParams.rev,
		)
	}
}.toPyString(User.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteUserByIdAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteUserByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.undeleteUserById(
				decodedParams.id,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(User.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteUserParams(
	public val user: User,
)

@OptIn(InternalIcureApi::class)
public fun deleteUserBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteUserParams>(params)
	runBlocking {
		sdk.user.deleteUser(
			decodedParams.user,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteUserAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteUserParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.deleteUser(
				decodedParams.user,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteUserInGroupParams(
	public val groupId: String,
	public val user: User,
)

@OptIn(InternalIcureApi::class)
public fun deleteUserInGroupBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteUserInGroupParams>(params)
	runBlocking {
		sdk.user.deleteUserInGroup(
			decodedParams.groupId,
			decodedParams.user,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteUserInGroupAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteUserInGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.deleteUserInGroup(
				decodedParams.groupId,
				decodedParams.user,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeUserParams(
	public val user: User,
)

@OptIn(InternalIcureApi::class)
public fun purgeUserBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeUserParams>(params)
	runBlocking {
		sdk.user.purgeUser(
			decodedParams.user,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeUserAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeUserParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.purgeUser(
				decodedParams.user,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteUserParams(
	public val user: User,
)

@OptIn(InternalIcureApi::class)
public fun undeleteUserBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteUserParams>(params)
	runBlocking {
		sdk.user.undeleteUser(
			decodedParams.user,
		)
	}
}.toPyString(User.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteUserAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteUserParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.undeleteUser(
				decodedParams.user,
			)
		}.toPyStringAsyncCallback(User.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
