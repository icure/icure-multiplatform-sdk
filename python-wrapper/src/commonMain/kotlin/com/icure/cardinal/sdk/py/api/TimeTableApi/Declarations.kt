// auto-generated file
package com.icure.cardinal.sdk.py.api.TimeTableApi

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.crypto.entities.SimpleShareResult
import com.icure.cardinal.sdk.crypto.entities.TimeTableShareOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.DecryptedTimeTable
import com.icure.cardinal.sdk.model.EncryptedTimeTable
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.TimeTable
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
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
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import kotlinx.cinterop.ByteVarOf
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CValues
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.SetSerializer
import kotlinx.serialization.builtins.serializer

@Serializable
private class CreateTimeTableParams(
	public val entity: DecryptedTimeTable,
)

@OptIn(InternalIcureApi::class)
public fun createTimeTableBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateTimeTableParams>(params)
	runBlocking {
		sdk.timeTable.createTimeTable(
			decodedParams.entity,
		)
	}
}.toPyString(DecryptedTimeTable.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createTimeTableAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateTimeTableParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.createTimeTable(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(DecryptedTimeTable.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class WithEncryptionMetadataParams(
	public val base: DecryptedTimeTable?,
	public val patient: Patient?,
	public val user: User? = null,
	public val delegates: Map<String, AccessLevel> = emptyMap(),
	public val secretId: SecretIdUseOption =
			com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent,
)

@OptIn(InternalIcureApi::class)
public fun withEncryptionMetadataBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<WithEncryptionMetadataParams>(params)
	runBlocking {
		sdk.timeTable.withEncryptionMetadata(
			decodedParams.base,
			decodedParams.patient,
			decodedParams.user,
			decodedParams.delegates,
			decodedParams.secretId,
		)
	}
}.toPyString(DecryptedTimeTable.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun withEncryptionMetadataAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<WithEncryptionMetadataParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.withEncryptionMetadata(
				decodedParams.base,
				decodedParams.patient,
				decodedParams.user,
				decodedParams.delegates,
				decodedParams.secretId,
			)
		}.toPyStringAsyncCallback(DecryptedTimeTable.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetEncryptionKeysOfParams(
	public val timeTable: TimeTable,
)

@OptIn(InternalIcureApi::class)
public fun getEncryptionKeysOfBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetEncryptionKeysOfParams>(params)
	runBlocking {
		sdk.timeTable.getEncryptionKeysOf(
			decodedParams.timeTable,
		)
	}
}.toPyString(SetSerializer(HexString.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getEncryptionKeysOfAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetEncryptionKeysOfParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.getEncryptionKeysOf(
				decodedParams.timeTable,
			)
		}.toPyStringAsyncCallback(SetSerializer(HexString.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class HasWriteAccessParams(
	public val timeTable: TimeTable,
)

@OptIn(InternalIcureApi::class)
public fun hasWriteAccessBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<HasWriteAccessParams>(params)
	runBlocking {
		sdk.timeTable.hasWriteAccess(
			decodedParams.timeTable,
		)
	}
}.toPyString(Boolean.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun hasWriteAccessAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<HasWriteAccessParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.hasWriteAccess(
				decodedParams.timeTable,
			)
		}.toPyStringAsyncCallback(Boolean.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DecryptPatientIdOfParams(
	public val timeTable: TimeTable,
)

@OptIn(InternalIcureApi::class)
public fun decryptPatientIdOfBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DecryptPatientIdOfParams>(params)
	runBlocking {
		sdk.timeTable.decryptPatientIdOf(
			decodedParams.timeTable,
		)
	}
}.toPyString(SetSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun decryptPatientIdOfAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DecryptPatientIdOfParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.decryptPatientIdOf(
				decodedParams.timeTable,
			)
		}.toPyStringAsyncCallback(SetSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateDelegationDeAnonymizationMetadataParams(
	public val entity: TimeTable,
	public val delegates: Set<String>,
)

@OptIn(InternalIcureApi::class)
public fun createDelegationDeAnonymizationMetadataBlocking(sdk: CardinalApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<CreateDelegationDeAnonymizationMetadataParams>(params)
	runBlocking {
		sdk.timeTable.createDelegationDeAnonymizationMetadata(
			decodedParams.entity,
			decodedParams.delegates,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createDelegationDeAnonymizationMetadataAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<CreateDelegationDeAnonymizationMetadataParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.createDelegationDeAnonymizationMetadata(
				decodedParams.entity,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DecryptParams(
	public val timeTable: EncryptedTimeTable,
)

@OptIn(InternalIcureApi::class)
public fun decryptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DecryptParams>(params)
	runBlocking {
		sdk.timeTable.decrypt(
			decodedParams.timeTable,
		)
	}
}.toPyString(DecryptedTimeTable.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun decryptAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DecryptParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.decrypt(
				decodedParams.timeTable,
			)
		}.toPyStringAsyncCallback(DecryptedTimeTable.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryDecryptParams(
	public val timeTable: EncryptedTimeTable,
)

@OptIn(InternalIcureApi::class)
public fun tryDecryptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<TryDecryptParams>(params)
	runBlocking {
		sdk.timeTable.tryDecrypt(
			decodedParams.timeTable,
		)
	}
}.toPyString(PolymorphicSerializer(TimeTable::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun tryDecryptAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<TryDecryptParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.tryDecrypt(
				decodedParams.timeTable,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(TimeTable::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchTimeTablesByParams(
	public val filter: FilterOptions<TimeTable>,
)

@OptIn(InternalIcureApi::class)
public fun matchTimeTablesByBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchTimeTablesByParams>(params)
	runBlocking {
		sdk.timeTable.matchTimeTablesBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchTimeTablesByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchTimeTablesByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.matchTimeTablesBy(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchTimeTablesBySortedParams(
	public val filter: SortableFilterOptions<TimeTable>,
)

@OptIn(InternalIcureApi::class)
public fun matchTimeTablesBySortedBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchTimeTablesBySortedParams>(params)
	runBlocking {
		sdk.timeTable.matchTimeTablesBySorted(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchTimeTablesBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchTimeTablesBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.matchTimeTablesBySorted(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteTimeTableParams(
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun deleteTimeTableBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteTimeTableParams>(params)
	runBlocking {
		sdk.timeTable.deleteTimeTable(
			decodedParams.entityId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteTimeTableAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteTimeTableParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.deleteTimeTable(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteTimeTablesParams(
	public val entityIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun deleteTimeTablesBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteTimeTablesParams>(params)
	runBlocking {
		sdk.timeTable.deleteTimeTables(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteTimeTablesAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteTimeTablesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.deleteTimeTables(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithParams(
	public val delegateId: String,
	public val timeTable: DecryptedTimeTable,
	public val options: TimeTableShareOptions? = null,
)

@OptIn(InternalIcureApi::class)
public fun shareWithBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.timeTable.shareWith(
			decodedParams.delegateId,
			decodedParams.timeTable,
			decodedParams.options,
		)
	}
}.toPyString(SimpleShareResult.serializer(DecryptedTimeTable.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun shareWithAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.shareWith(
				decodedParams.delegateId,
				decodedParams.timeTable,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(DecryptedTimeTable.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryShareWithManyParams(
	public val timeTable: DecryptedTimeTable,
	public val delegates: Map<String, TimeTableShareOptions>,
)

@OptIn(InternalIcureApi::class)
public fun tryShareWithManyBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<TryShareWithManyParams>(params)
	runBlocking {
		sdk.timeTable.tryShareWithMany(
			decodedParams.timeTable,
			decodedParams.delegates,
		)
	}
}.toPyString(SimpleShareResult.serializer(DecryptedTimeTable.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun tryShareWithManyAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<TryShareWithManyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.tryShareWithMany(
				decodedParams.timeTable,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(DecryptedTimeTable.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val timeTable: DecryptedTimeTable,
	public val delegates: Map<String, TimeTableShareOptions>,
)

@OptIn(InternalIcureApi::class)
public fun shareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.timeTable.shareWithMany(
			decodedParams.timeTable,
			decodedParams.delegates,
		)
	}
}.toPyString(DecryptedTimeTable.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun shareWithManyAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithManyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.shareWithMany(
				decodedParams.timeTable,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(DecryptedTimeTable.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterTimeTablesByParams(
	public val filter: FilterOptions<TimeTable>,
)

@OptIn(InternalIcureApi::class)
public fun filterTimeTablesByBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterTimeTablesByParams>(params)
	runBlocking {
		sdk.timeTable.filterTimeTablesBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, DecryptedTimeTable.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterTimeTablesByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterTimeTablesByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.filterTimeTablesBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, DecryptedTimeTable.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterTimeTablesBySortedParams(
	public val filter: SortableFilterOptions<TimeTable>,
)

@OptIn(InternalIcureApi::class)
public fun filterTimeTablesBySortedBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterTimeTablesBySortedParams>(params)
	runBlocking {
		sdk.timeTable.filterTimeTablesBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, DecryptedTimeTable.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterTimeTablesBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterTimeTablesBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.filterTimeTablesBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, DecryptedTimeTable.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class ModifyTimeTableParams(
	public val entity: DecryptedTimeTable,
)

@OptIn(InternalIcureApi::class)
public fun modifyTimeTableBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyTimeTableParams>(params)
	runBlocking {
		sdk.timeTable.modifyTimeTable(
			decodedParams.entity,
		)
	}
}.toPyString(DecryptedTimeTable.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyTimeTableAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyTimeTableParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.modifyTimeTable(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(DecryptedTimeTable.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetTimeTableParams(
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun getTimeTableBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetTimeTableParams>(params)
	runBlocking {
		sdk.timeTable.getTimeTable(
			decodedParams.entityId,
		)
	}
}.toPyString(DecryptedTimeTable.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getTimeTableAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetTimeTableParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.getTimeTable(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(DecryptedTimeTable.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetTimeTablesParams(
	public val timeTableIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getTimeTablesBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetTimeTablesParams>(params)
	runBlocking {
		sdk.timeTable.getTimeTables(
			decodedParams.timeTableIds,
		)
	}
}.toPyString(ListSerializer(DecryptedTimeTable.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getTimeTablesAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetTimeTablesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.getTimeTables(
				decodedParams.timeTableIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedTimeTable.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetTimeTablesByPeriodAndAgendaIdParams(
	public val startDate: Long,
	public val endDate: Long,
	public val agendaId: String,
)

@OptIn(InternalIcureApi::class)
public fun getTimeTablesByPeriodAndAgendaIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetTimeTablesByPeriodAndAgendaIdParams>(params)
	runBlocking {
		sdk.timeTable.getTimeTablesByPeriodAndAgendaId(
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.agendaId,
		)
	}
}.toPyString(ListSerializer(DecryptedTimeTable.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getTimeTablesByPeriodAndAgendaIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetTimeTablesByPeriodAndAgendaIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.getTimeTablesByPeriodAndAgendaId(
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.agendaId,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedTimeTable.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetTimeTablesByAgendaIdParams(
	public val agendaId: String,
)

@OptIn(InternalIcureApi::class)
public fun getTimeTablesByAgendaIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetTimeTablesByAgendaIdParams>(params)
	runBlocking {
		sdk.timeTable.getTimeTablesByAgendaId(
			decodedParams.agendaId,
		)
	}
}.toPyString(ListSerializer(DecryptedTimeTable.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getTimeTablesByAgendaIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetTimeTablesByAgendaIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.timeTable.getTimeTablesByAgendaId(
				decodedParams.agendaId,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedTimeTable.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
