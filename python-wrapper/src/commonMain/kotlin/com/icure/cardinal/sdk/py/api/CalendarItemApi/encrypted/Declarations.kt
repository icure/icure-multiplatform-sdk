// auto-generated file
package com.icure.cardinal.sdk.py.api.CalendarItemApi.encrypted

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.CalendarItemShareOptions
import com.icure.cardinal.sdk.crypto.entities.SimpleShareResult
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.EncryptedCalendarItem
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.py.serialization.CalendarItemSerializer
import com.icure.cardinal.sdk.py.serialization.PatientSerializer
import com.icure.cardinal.sdk.py.utils.PaginatedListIterator.PaginatedListIteratorAndSerializer
import com.icure.cardinal.sdk.py.utils.PyResult
import com.icure.cardinal.sdk.py.utils.failureToPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyResult
import com.icure.cardinal.sdk.py.utils.toPyResultAsyncCallback
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
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer

@Serializable
private class ShareWithParams(
	public val delegateId: String,
	public val calendarItem: EncryptedCalendarItem,
	public val options: CalendarItemShareOptions? = null,
)

public fun shareWithBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.calendarItem.encrypted.shareWith(
			decodedParams.delegateId,
			decodedParams.calendarItem,
			decodedParams.options,
		)
	}
}.toPyString(SimpleShareResult.serializer(EncryptedCalendarItem.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun shareWithAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.encrypted.shareWith(
				decodedParams.delegateId,
				decodedParams.calendarItem,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(EncryptedCalendarItem.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryShareWithManyParams(
	public val calendarItem: EncryptedCalendarItem,
	public val delegates: Map<String, CalendarItemShareOptions>,
)

public fun tryShareWithManyBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryShareWithManyParams>(params)
	runBlocking {
		sdk.calendarItem.encrypted.tryShareWithMany(
			decodedParams.calendarItem,
			decodedParams.delegates,
		)
	}
}.toPyString(SimpleShareResult.serializer(EncryptedCalendarItem.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun tryShareWithManyAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryShareWithManyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.encrypted.tryShareWithMany(
				decodedParams.calendarItem,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(EncryptedCalendarItem.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val calendarItem: EncryptedCalendarItem,
	public val delegates: Map<String, CalendarItemShareOptions>,
)

public fun shareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.calendarItem.encrypted.shareWithMany(
			decodedParams.calendarItem,
			decodedParams.delegates,
		)
	}
}.toPyString(EncryptedCalendarItem.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun shareWithManyAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithManyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.encrypted.shareWithMany(
				decodedParams.calendarItem,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(EncryptedCalendarItem.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindCalendarItemsByHcPartyPatientParams(
	public val hcPartyId: String,
	@Serializable(PatientSerializer::class)
	public val patient: Patient,
	public val startDate: Long? = null,
	public val endDate: Long? = null,
	public val descending: Boolean? = null,
)

public fun findCalendarItemsByHcPartyPatientBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindCalendarItemsByHcPartyPatientParams>(params)
	runBlocking {
		sdk.calendarItem.encrypted.findCalendarItemsByHcPartyPatient(
			decodedParams.hcPartyId,
			decodedParams.patient,
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.descending,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, EncryptedCalendarItem.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun findCalendarItemsByHcPartyPatientAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindCalendarItemsByHcPartyPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.encrypted.findCalendarItemsByHcPartyPatient(
				decodedParams.hcPartyId,
				decodedParams.patient,
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.descending,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, EncryptedCalendarItem.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class LinkToPatientParams(
	@Serializable(CalendarItemSerializer::class)
	public val calendarItem: CalendarItem,
	@Serializable(PatientSerializer::class)
	public val patient: Patient,
	public val shareLinkWithDelegates: Set<String>,
)

public fun linkToPatientBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<LinkToPatientParams>(params)
	runBlocking {
		sdk.calendarItem.encrypted.linkToPatient(
			decodedParams.calendarItem,
			decodedParams.patient,
			decodedParams.shareLinkWithDelegates,
		)
	}
}.toPyString(EncryptedCalendarItem.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun linkToPatientAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<LinkToPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.encrypted.linkToPatient(
				decodedParams.calendarItem,
				decodedParams.patient,
				decodedParams.shareLinkWithDelegates,
			)
		}.toPyStringAsyncCallback(EncryptedCalendarItem.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterCalendarItemsByParams(
	public val filter: FilterOptions<CalendarItem>,
)

public fun filterCalendarItemsByBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterCalendarItemsByParams>(params)
	runBlocking {
		sdk.calendarItem.encrypted.filterCalendarItemsBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, EncryptedCalendarItem.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun filterCalendarItemsByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterCalendarItemsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.encrypted.filterCalendarItemsBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, EncryptedCalendarItem.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterCalendarItemsBySortedParams(
	public val filter: SortableFilterOptions<CalendarItem>,
)

public fun filterCalendarItemsBySortedBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterCalendarItemsBySortedParams>(params)
	runBlocking {
		sdk.calendarItem.encrypted.filterCalendarItemsBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, EncryptedCalendarItem.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun filterCalendarItemsBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterCalendarItemsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.encrypted.filterCalendarItemsBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, EncryptedCalendarItem.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class ModifyCalendarItemParams(
	public val entity: EncryptedCalendarItem,
)

public fun modifyCalendarItemBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyCalendarItemParams>(params)
	runBlocking {
		sdk.calendarItem.encrypted.modifyCalendarItem(
			decodedParams.entity,
		)
	}
}.toPyString(EncryptedCalendarItem.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyCalendarItemAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyCalendarItemParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.encrypted.modifyCalendarItem(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(EncryptedCalendarItem.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetCalendarItemParams(
	public val entityId: String,
)

public fun getCalendarItemBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetCalendarItemParams>(params)
	runBlocking {
		sdk.calendarItem.encrypted.getCalendarItem(
			decodedParams.entityId,
		)
	}
}.toPyString(EncryptedCalendarItem.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getCalendarItemAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetCalendarItemParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.encrypted.getCalendarItem(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(EncryptedCalendarItem.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetCalendarItemsParams(
	public val entityIds: List<String>,
)

public fun getCalendarItemsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetCalendarItemsParams>(params)
	runBlocking {
		sdk.calendarItem.encrypted.getCalendarItems(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(EncryptedCalendarItem.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getCalendarItemsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetCalendarItemsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.encrypted.getCalendarItems(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedCalendarItem.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetCalendarItemsByPeriodAndHcPartyIdParams(
	public val startDate: Long,
	public val endDate: Long,
	public val hcPartyId: String,
)

public fun getCalendarItemsByPeriodAndHcPartyIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetCalendarItemsByPeriodAndHcPartyIdParams>(params)
	runBlocking {
		sdk.calendarItem.encrypted.getCalendarItemsByPeriodAndHcPartyId(
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.hcPartyId,
		)
	}
}.toPyString(ListSerializer(EncryptedCalendarItem.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getCalendarItemsByPeriodAndHcPartyIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetCalendarItemsByPeriodAndHcPartyIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.encrypted.getCalendarItemsByPeriodAndHcPartyId(
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.hcPartyId,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedCalendarItem.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetCalendarsByPeriodAndAgendaIdParams(
	public val startDate: Long,
	public val endDate: Long,
	public val agendaId: String,
)

public fun getCalendarsByPeriodAndAgendaIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetCalendarsByPeriodAndAgendaIdParams>(params)
	runBlocking {
		sdk.calendarItem.encrypted.getCalendarsByPeriodAndAgendaId(
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.agendaId,
		)
	}
}.toPyString(ListSerializer(EncryptedCalendarItem.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getCalendarsByPeriodAndAgendaIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetCalendarsByPeriodAndAgendaIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.encrypted.getCalendarsByPeriodAndAgendaId(
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.agendaId,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedCalendarItem.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindCalendarItemsByRecurrenceIdParams(
	public val recurrenceId: String,
	public val startKey: String?,
	public val startDocumentId: String?,
	public val limit: Int,
)

public fun findCalendarItemsByRecurrenceIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindCalendarItemsByRecurrenceIdParams>(params)
	runBlocking {
		sdk.calendarItem.encrypted.findCalendarItemsByRecurrenceId(
			decodedParams.recurrenceId,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(EncryptedCalendarItem.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findCalendarItemsByRecurrenceIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindCalendarItemsByRecurrenceIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.calendarItem.encrypted.findCalendarItemsByRecurrenceId(
				decodedParams.recurrenceId,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(EncryptedCalendarItem.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
