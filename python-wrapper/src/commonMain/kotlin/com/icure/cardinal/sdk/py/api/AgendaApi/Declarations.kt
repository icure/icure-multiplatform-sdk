// auto-generated file
package com.icure.cardinal.sdk.py.api.AgendaApi

import com.icure.cardinal.sdk.CardinalNonCryptoApis
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.Agenda
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.py.utils.PaginatedListIterator.PaginatedListIteratorAndSerializer
import com.icure.cardinal.sdk.py.utils.PyResult
import com.icure.cardinal.sdk.py.utils.failureToPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyResult
import com.icure.cardinal.sdk.py.utils.toPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.utils.Serialization.json
import kotlin.Byte
import kotlin.Int
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
private class GetAllAgendasParams(
	public val startDocumentId: String?,
	public val limit: Int?,
)

public fun getAllAgendasBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetAllAgendasParams>(params)
	runBlocking {
		sdk.agenda.getAllAgendas(
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(Agenda.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getAllAgendasAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetAllAgendasParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.agenda.getAllAgendas(
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(Agenda.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateAgendaParams(
	public val agendaDto: Agenda,
)

public fun createAgendaBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateAgendaParams>(params)
	runBlocking {
		sdk.agenda.createAgenda(
			decodedParams.agendaDto,
		)
	}
}.toPyString(Agenda.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun createAgendaAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateAgendaParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.agenda.createAgenda(
				decodedParams.agendaDto,
			)
		}.toPyStringAsyncCallback(Agenda.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteAgendasParams(
	public val agendaIds: ListOfIds,
)

public fun deleteAgendasBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteAgendasParams>(params)
	runBlocking {
		sdk.agenda.deleteAgendas(
			decodedParams.agendaIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun deleteAgendasAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteAgendasParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.agenda.deleteAgendas(
				decodedParams.agendaIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteAgendaParams(
	public val agendaId: String,
)

public fun deleteAgendaBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteAgendaParams>(params)
	runBlocking {
		sdk.agenda.deleteAgenda(
			decodedParams.agendaId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun deleteAgendaAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteAgendaParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.agenda.deleteAgenda(
				decodedParams.agendaId,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetAgendaParams(
	public val agendaId: String,
)

public fun getAgendaBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetAgendaParams>(params)
	runBlocking {
		sdk.agenda.getAgenda(
			decodedParams.agendaId,
		)
	}
}.toPyString(Agenda.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getAgendaAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetAgendaParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.agenda.getAgenda(
				decodedParams.agendaId,
			)
		}.toPyStringAsyncCallback(Agenda.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetAgendasParams(
	public val agendaIds: List<String>,
)

public fun getAgendasBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetAgendasParams>(params)
	runBlocking {
		sdk.agenda.getAgendas(
			decodedParams.agendaIds,
		)
	}
}.toPyString(ListSerializer(Agenda.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getAgendasAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetAgendasParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.agenda.getAgendas(
				decodedParams.agendaIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(Agenda.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetAgendasForUserParams(
	public val userId: String,
)

public fun getAgendasForUserBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetAgendasForUserParams>(params)
	runBlocking {
		sdk.agenda.getAgendasForUser(
			decodedParams.userId,
		)
	}
}.toPyString(Agenda.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getAgendasForUserAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetAgendasForUserParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.agenda.getAgendasForUser(
				decodedParams.userId,
			)
		}.toPyStringAsyncCallback(Agenda.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetReadableAgendasForUserParams(
	public val userId: String,
)

public fun getReadableAgendasForUserBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetReadableAgendasForUserParams>(params)
	runBlocking {
		sdk.agenda.getReadableAgendasForUser(
			decodedParams.userId,
		)
	}
}.toPyString(ListSerializer(Agenda.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getReadableAgendasForUserAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetReadableAgendasForUserParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.agenda.getReadableAgendasForUser(
				decodedParams.userId,
			)
		}.toPyStringAsyncCallback(ListSerializer(Agenda.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyAgendaParams(
	public val agendaDto: Agenda,
)

public fun modifyAgendaBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyAgendaParams>(params)
	runBlocking {
		sdk.agenda.modifyAgenda(
			decodedParams.agendaDto,
		)
	}
}.toPyString(Agenda.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyAgendaAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyAgendaParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.agenda.modifyAgenda(
				decodedParams.agendaDto,
			)
		}.toPyStringAsyncCallback(Agenda.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchAgendasByParams(
	public val filter: BaseFilterOptions<Agenda>,
)

public fun matchAgendasByBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchAgendasByParams>(params)
	runBlocking {
		sdk.agenda.matchAgendasBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun matchAgendasByAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchAgendasByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.agenda.matchAgendasBy(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchAgendasBySortedParams(
	public val filter: BaseSortableFilterOptions<Agenda>,
)

public fun matchAgendasBySortedBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchAgendasBySortedParams>(params)
	runBlocking {
		sdk.agenda.matchAgendasBySorted(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun matchAgendasBySortedAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchAgendasBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.agenda.matchAgendasBySorted(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterAgendasByParams(
	public val filter: BaseFilterOptions<Agenda>,
)

public fun filterAgendasByBlocking(sdk: CardinalNonCryptoApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterAgendasByParams>(params)
	runBlocking {
		sdk.agenda.filterAgendasBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, Agenda.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun filterAgendasByAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterAgendasByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.agenda.filterAgendasBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, Agenda.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterAgendasBySortedParams(
	public val filter: BaseSortableFilterOptions<Agenda>,
)

public fun filterAgendasBySortedBlocking(sdk: CardinalNonCryptoApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterAgendasBySortedParams>(params)
	runBlocking {
		sdk.agenda.filterAgendasBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, Agenda.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun filterAgendasBySortedAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterAgendasBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.agenda.filterAgendasBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, Agenda.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)
