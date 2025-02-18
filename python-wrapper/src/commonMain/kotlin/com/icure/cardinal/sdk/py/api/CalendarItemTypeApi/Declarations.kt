// auto-generated file
package com.icure.cardinal.sdk.py.api.CalendarItemTypeApi

import com.icure.cardinal.sdk.CardinalNonCryptoApis
import com.icure.cardinal.sdk.model.CalendarItemType
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Byte
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
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

@Serializable
private class GetCalendarItemTypesParams(
	public val startDocumentId: String?,
	public val limit: Int?,
)

@OptIn(InternalIcureApi::class)
public fun getCalendarItemTypesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetCalendarItemTypesParams>(params)
	runBlocking {
		sdk.calendarItemType.getCalendarItemTypes(
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(CalendarItemType.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getCalendarItemTypesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetCalendarItemTypesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItemType.getCalendarItemTypes(
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(CalendarItemType.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetCalendarItemTypesIncludingDeletedParams(
	public val startKey: String?,
	public val startDocumentId: String?,
	public val limit: Int?,
)

@OptIn(InternalIcureApi::class)
public fun getCalendarItemTypesIncludingDeletedBlocking(sdk: CardinalNonCryptoApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetCalendarItemTypesIncludingDeletedParams>(params)
	runBlocking {
		sdk.calendarItemType.getCalendarItemTypesIncludingDeleted(
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(CalendarItemType.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getCalendarItemTypesIncludingDeletedAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetCalendarItemTypesIncludingDeletedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItemType.getCalendarItemTypesIncludingDeleted(
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(CalendarItemType.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateCalendarItemTypeParams(
	public val calendarItemTypeDto: CalendarItemType,
)

@OptIn(InternalIcureApi::class)
public fun createCalendarItemTypeBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateCalendarItemTypeParams>(params)
	runBlocking {
		sdk.calendarItemType.createCalendarItemType(
			decodedParams.calendarItemTypeDto,
		)
	}
}.toPyString(CalendarItemType.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createCalendarItemTypeAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateCalendarItemTypeParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItemType.createCalendarItemType(
				decodedParams.calendarItemTypeDto,
			)
		}.toPyStringAsyncCallback(CalendarItemType.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteCalendarItemTypesParams(
	public val calendarItemTypeIds: ListOfIds,
)

@OptIn(InternalIcureApi::class)
public fun deleteCalendarItemTypesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteCalendarItemTypesParams>(params)
	runBlocking {
		sdk.calendarItemType.deleteCalendarItemTypes(
			decodedParams.calendarItemTypeIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteCalendarItemTypesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteCalendarItemTypesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItemType.deleteCalendarItemTypes(
				decodedParams.calendarItemTypeIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetCalendarItemTypeParams(
	public val calendarItemTypeId: String,
)

@OptIn(InternalIcureApi::class)
public fun getCalendarItemTypeBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetCalendarItemTypeParams>(params)
	runBlocking {
		sdk.calendarItemType.getCalendarItemType(
			decodedParams.calendarItemTypeId,
		)
	}
}.toPyString(CalendarItemType.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getCalendarItemTypeAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetCalendarItemTypeParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItemType.getCalendarItemType(
				decodedParams.calendarItemTypeId,
			)
		}.toPyStringAsyncCallback(CalendarItemType.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyCalendarItemTypeParams(
	public val calendarItemTypeDto: CalendarItemType,
)

@OptIn(InternalIcureApi::class)
public fun modifyCalendarItemTypeBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyCalendarItemTypeParams>(params)
	runBlocking {
		sdk.calendarItemType.modifyCalendarItemType(
			decodedParams.calendarItemTypeDto,
		)
	}
}.toPyString(CalendarItemType.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyCalendarItemTypeAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyCalendarItemTypeParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItemType.modifyCalendarItemType(
				decodedParams.calendarItemTypeDto,
			)
		}.toPyStringAsyncCallback(CalendarItemType.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
