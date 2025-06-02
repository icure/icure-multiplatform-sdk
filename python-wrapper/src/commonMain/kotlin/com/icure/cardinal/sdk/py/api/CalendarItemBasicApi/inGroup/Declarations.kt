// auto-generated file
package com.icure.cardinal.sdk.py.api.CalendarItemBasicApi.inGroup

import com.icure.cardinal.sdk.CardinalBaseApis
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.EncryptedCalendarItem
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.py.utils.PyResult
import com.icure.cardinal.sdk.py.utils.failureToPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyResult
import com.icure.cardinal.sdk.py.utils.toPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.serialization.PaginatedListIteratorWithSerializer
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Byte
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
private class MatchCalendarItemsByParams(
	public val groupId: String,
	public val filter: BaseFilterOptions<CalendarItem>,
)

@OptIn(InternalIcureApi::class)
public fun matchCalendarItemsByBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchCalendarItemsByParams>(params)
	runBlocking {
		sdk.calendarItem.inGroup.matchCalendarItemsBy(
			decodedParams.groupId,
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchCalendarItemsByAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchCalendarItemsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.inGroup.matchCalendarItemsBy(
				decodedParams.groupId,
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchCalendarItemsBySortedParams(
	public val groupId: String,
	public val filter: BaseSortableFilterOptions<CalendarItem>,
)

@OptIn(InternalIcureApi::class)
public fun matchCalendarItemsBySortedBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<MatchCalendarItemsBySortedParams>(params)
	runBlocking {
		sdk.calendarItem.inGroup.matchCalendarItemsBySorted(
			decodedParams.groupId,
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchCalendarItemsBySortedAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<MatchCalendarItemsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.inGroup.matchCalendarItemsBySorted(
				decodedParams.groupId,
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterCalendarItemsByParams(
	public val groupId: String,
	public val filter: BaseFilterOptions<CalendarItem>,
)

@OptIn(InternalIcureApi::class)
public fun filterCalendarItemsByBlocking(sdk: CardinalBaseApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterCalendarItemsByParams>(params)
	runBlocking {
		sdk.calendarItem.inGroup.filterCalendarItemsBy(
			decodedParams.groupId,
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it,
			GroupScoped.serializer(EncryptedCalendarItem.serializer()))}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterCalendarItemsByAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterCalendarItemsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.inGroup.filterCalendarItemsBy(
				decodedParams.groupId,
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it,
					GroupScoped.serializer(EncryptedCalendarItem.serializer()))}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterCalendarItemsBySortedParams(
	public val groupId: String,
	public val filter: BaseSortableFilterOptions<CalendarItem>,
)

@OptIn(InternalIcureApi::class)
public fun filterCalendarItemsBySortedBlocking(sdk: CardinalBaseApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterCalendarItemsBySortedParams>(params)
	runBlocking {
		sdk.calendarItem.inGroup.filterCalendarItemsBySorted(
			decodedParams.groupId,
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it,
			GroupScoped.serializer(EncryptedCalendarItem.serializer()))}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterCalendarItemsBySortedAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterCalendarItemsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.inGroup.filterCalendarItemsBySorted(
				decodedParams.groupId,
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it,
					GroupScoped.serializer(EncryptedCalendarItem.serializer()))}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class DeleteCalendarItemByIdParams(
	public val entityId: GroupScoped<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun deleteCalendarItemByIdBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteCalendarItemByIdParams>(params)
	runBlocking {
		sdk.calendarItem.inGroup.deleteCalendarItemById(
			decodedParams.entityId,
		)
	}
}.toPyString(GroupScoped.serializer(StoredDocumentIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteCalendarItemByIdAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteCalendarItemByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.inGroup.deleteCalendarItemById(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(StoredDocumentIdentifier.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteCalendarItemsByIdsParams(
	public val entityIds: List<GroupScoped<StoredDocumentIdentifier>>,
)

@OptIn(InternalIcureApi::class)
public fun deleteCalendarItemsByIdsBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteCalendarItemsByIdsParams>(params)
	runBlocking {
		sdk.calendarItem.inGroup.deleteCalendarItemsByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteCalendarItemsByIdsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteCalendarItemsByIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.inGroup.deleteCalendarItemsByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteCalendarItemParams(
	public val calendarItem: GroupScoped<CalendarItem>,
)

@OptIn(InternalIcureApi::class)
public fun deleteCalendarItemBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteCalendarItemParams>(params)
	runBlocking {
		sdk.calendarItem.inGroup.deleteCalendarItem(
			decodedParams.calendarItem,
		)
	}
}.toPyString(GroupScoped.serializer(StoredDocumentIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteCalendarItemAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteCalendarItemParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.inGroup.deleteCalendarItem(
				decodedParams.calendarItem,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(StoredDocumentIdentifier.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteCalendarItemsParams(
	public val calendarItems: List<GroupScoped<CalendarItem>>,
)

@OptIn(InternalIcureApi::class)
public fun deleteCalendarItemsBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteCalendarItemsParams>(params)
	runBlocking {
		sdk.calendarItem.inGroup.deleteCalendarItems(
			decodedParams.calendarItems,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteCalendarItemsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteCalendarItemsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.inGroup.deleteCalendarItems(
				decodedParams.calendarItems,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateCalendarItemParams(
	public val entity: GroupScoped<EncryptedCalendarItem>,
)

@OptIn(InternalIcureApi::class)
public fun createCalendarItemBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateCalendarItemParams>(params)
	runBlocking {
		sdk.calendarItem.inGroup.createCalendarItem(
			decodedParams.entity,
		)
	}
}.toPyString(GroupScoped.serializer(EncryptedCalendarItem.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createCalendarItemAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateCalendarItemParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.inGroup.createCalendarItem(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(EncryptedCalendarItem.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyCalendarItemParams(
	public val entity: GroupScoped<EncryptedCalendarItem>,
)

@OptIn(InternalIcureApi::class)
public fun modifyCalendarItemBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyCalendarItemParams>(params)
	runBlocking {
		sdk.calendarItem.inGroup.modifyCalendarItem(
			decodedParams.entity,
		)
	}
}.toPyString(GroupScoped.serializer(EncryptedCalendarItem.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyCalendarItemAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyCalendarItemParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.inGroup.modifyCalendarItem(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(EncryptedCalendarItem.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetCalendarItemParams(
	public val groupId: String,
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun getCalendarItemBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetCalendarItemParams>(params)
	runBlocking {
		sdk.calendarItem.inGroup.getCalendarItem(
			decodedParams.groupId,
			decodedParams.entityId,
		)
	}
}.toPyString(GroupScoped.serializer(EncryptedCalendarItem.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getCalendarItemAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetCalendarItemParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.inGroup.getCalendarItem(
				decodedParams.groupId,
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(EncryptedCalendarItem.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetCalendarItemsParams(
	public val groupId: String,
	public val entityIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getCalendarItemsBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetCalendarItemsParams>(params)
	runBlocking {
		sdk.calendarItem.inGroup.getCalendarItems(
			decodedParams.groupId,
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(EncryptedCalendarItem.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getCalendarItemsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetCalendarItemsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.inGroup.getCalendarItems(
				decodedParams.groupId,
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(EncryptedCalendarItem.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
