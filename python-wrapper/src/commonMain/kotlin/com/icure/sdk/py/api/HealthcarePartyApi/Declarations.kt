// auto-generated file
package com.icure.sdk.py.api.HealthcarePartyApi

import com.icure.sdk.IcureNonCryptoApis
import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.model.DataOwnerRegistrationSuccess
import com.icure.sdk.model.HealthcareParty
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.PublicKey
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.py.utils.PaginatedListIterator.PaginatedListIteratorAndSerializer
import com.icure.sdk.py.utils.PyResult
import com.icure.sdk.py.utils.failureToPyResultAsyncCallback
import com.icure.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.sdk.py.utils.toPyResult
import com.icure.sdk.py.utils.toPyResultAsyncCallback
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.py.utils.toPyStringAsyncCallback
import com.icure.sdk.utils.Serialization.json
import kotlin.Boolean
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
private class GetHealthcarePartyParams(
	public val deviceId: String,
)

public fun getHealthcarePartyBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetHealthcarePartyParams>(params)
	runBlocking {
		sdk.healthcareParty.getHealthcareParty(
			decodedParams.deviceId,
		)
	}
}.toPyString(HealthcareParty.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getHealthcarePartyAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetHealthcarePartyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.getHealthcareParty(
				decodedParams.deviceId,
			)
		}.toPyStringAsyncCallback(HealthcareParty.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateHealthcarePartyParams(
	public val p: HealthcareParty,
)

public fun createHealthcarePartyBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateHealthcarePartyParams>(params)
	runBlocking {
		sdk.healthcareParty.createHealthcareParty(
			decodedParams.p,
		)
	}
}.toPyString(HealthcareParty.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun createHealthcarePartyAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateHealthcarePartyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.createHealthcareParty(
				decodedParams.p,
			)
		}.toPyStringAsyncCallback(HealthcareParty.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteHealthcarePartyParams(
	public val deviceId: String,
)

public fun deleteHealthcarePartyBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteHealthcarePartyParams>(params)
	runBlocking {
		sdk.healthcareParty.deleteHealthcareParty(
			decodedParams.deviceId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun deleteHealthcarePartyAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteHealthcarePartyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.deleteHealthcareParty(
				decodedParams.deviceId,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyHealthcarePartyInGroupParams(
	public val groupId: String,
	public val device: HealthcareParty,
)

public fun modifyHealthcarePartyInGroupBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyHealthcarePartyInGroupParams>(params)
	runBlocking {
		sdk.healthcareParty.modifyHealthcarePartyInGroup(
			decodedParams.groupId,
			decodedParams.device,
		)
	}
}.toPyString(HealthcareParty.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyHealthcarePartyInGroupAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyHealthcarePartyInGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.modifyHealthcarePartyInGroup(
				decodedParams.groupId,
				decodedParams.device,
			)
		}.toPyStringAsyncCallback(HealthcareParty.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateHealthcarePartyInGroupParams(
	public val groupId: String,
	public val device: HealthcareParty,
)

public fun createHealthcarePartyInGroupBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateHealthcarePartyInGroupParams>(params)
	runBlocking {
		sdk.healthcareParty.createHealthcarePartyInGroup(
			decodedParams.groupId,
			decodedParams.device,
		)
	}
}.toPyString(HealthcareParty.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun createHealthcarePartyInGroupAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateHealthcarePartyInGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.createHealthcarePartyInGroup(
				decodedParams.groupId,
				decodedParams.device,
			)
		}.toPyStringAsyncCallback(HealthcareParty.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

public fun getCurrentHealthcarePartyBlocking(sdk: IcureNonCryptoApis): String = kotlin.runCatching {
	runBlocking {
		sdk.healthcareParty.getCurrentHealthcareParty()
	}
}.toPyString(HealthcareParty.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getCurrentHealthcarePartyAsync(sdk: IcureNonCryptoApis,
		resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
		CValues<ByteVarOf<Byte>>?) -> Unit>>): Unit = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.getCurrentHealthcareParty()
		}.toPyStringAsyncCallback(HealthcareParty.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindHealthcarePartiesByParams(
	public val startKey: String? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
	public val desc: Boolean? = null,
)

public fun findHealthcarePartiesByBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindHealthcarePartiesByParams>(params)
	runBlocking {
		sdk.healthcareParty.findHealthcarePartiesBy(
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
			decodedParams.desc,
		)
	}
}.toPyString(PaginatedList.serializer(HealthcareParty.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findHealthcarePartiesByAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindHealthcarePartiesByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.findHealthcarePartiesBy(
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
				decodedParams.desc,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(HealthcareParty.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindHealthcarePartiesByNameParams(
	public val name: String? = null,
	public val startKey: String? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
	public val desc: Boolean? = null,
)

public fun findHealthcarePartiesByNameBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindHealthcarePartiesByNameParams>(params)
	runBlocking {
		sdk.healthcareParty.findHealthcarePartiesByName(
			decodedParams.name,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
			decodedParams.desc,
		)
	}
}.toPyString(PaginatedList.serializer(HealthcareParty.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findHealthcarePartiesByNameAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindHealthcarePartiesByNameParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.findHealthcarePartiesByName(
				decodedParams.name,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
				decodedParams.desc,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(HealthcareParty.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindHealthcarePartiesBySsinOrNihiiParams(
	public val searchValue: String,
	public val startKey: String? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
	public val desc: Boolean = false,
)

public fun findHealthcarePartiesBySsinOrNihiiBlocking(sdk: IcureNonCryptoApis, params: String):
		String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindHealthcarePartiesBySsinOrNihiiParams>(params)
	runBlocking {
		sdk.healthcareParty.findHealthcarePartiesBySsinOrNihii(
			decodedParams.searchValue,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
			decodedParams.desc,
		)
	}
}.toPyString(PaginatedList.serializer(HealthcareParty.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findHealthcarePartiesBySsinOrNihiiAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindHealthcarePartiesBySsinOrNihiiParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.findHealthcarePartiesBySsinOrNihii(
				decodedParams.searchValue,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
				decodedParams.desc,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(HealthcareParty.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListHealthcarePartiesByNameParams(
	public val name: String,
)

public fun listHealthcarePartiesByNameBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListHealthcarePartiesByNameParams>(params)
	runBlocking {
		sdk.healthcareParty.listHealthcarePartiesByName(
			decodedParams.name,
		)
	}
}.toPyString(ListSerializer(HealthcareParty.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listHealthcarePartiesByNameAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListHealthcarePartiesByNameParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.listHealthcarePartiesByName(
				decodedParams.name,
			)
		}.toPyStringAsyncCallback(ListSerializer(HealthcareParty.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindHealthcarePartiesBySpecialityAndPostCodeParams(
	public val type: String,
	public val spec: String,
	public val firstCode: String,
	public val lastCode: String,
	public val startKey: String? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
)

public fun findHealthcarePartiesBySpecialityAndPostCodeBlocking(sdk: IcureNonCryptoApis,
		params: String): String = kotlin.runCatching {
	val decodedParams =
			json.decodeFromString<FindHealthcarePartiesBySpecialityAndPostCodeParams>(params)
	runBlocking {
		sdk.healthcareParty.findHealthcarePartiesBySpecialityAndPostCode(
			decodedParams.type,
			decodedParams.spec,
			decodedParams.firstCode,
			decodedParams.lastCode,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(HealthcareParty.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findHealthcarePartiesBySpecialityAndPostCodeAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			json.decodeFromString<FindHealthcarePartiesBySpecialityAndPostCodeParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.findHealthcarePartiesBySpecialityAndPostCode(
				decodedParams.type,
				decodedParams.spec,
				decodedParams.firstCode,
				decodedParams.lastCode,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(HealthcareParty.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetHealthcarePartiesParams(
	public val healthcarePartyIds: List<String>,
)

public fun getHealthcarePartiesBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetHealthcarePartiesParams>(params)
	runBlocking {
		sdk.healthcareParty.getHealthcareParties(
			decodedParams.healthcarePartyIds,
		)
	}
}.toPyString(ListSerializer(HealthcareParty.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getHealthcarePartiesAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetHealthcarePartiesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.getHealthcareParties(
				decodedParams.healthcarePartyIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(HealthcareParty.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListHealthcarePartiesByParentIdParams(
	public val parentId: String,
)

public fun listHealthcarePartiesByParentIdBlocking(sdk: IcureNonCryptoApis, params: String): String
		= kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListHealthcarePartiesByParentIdParams>(params)
	runBlocking {
		sdk.healthcareParty.listHealthcarePartiesByParentId(
			decodedParams.parentId,
		)
	}
}.toPyString(ListSerializer(HealthcareParty.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listHealthcarePartiesByParentIdAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListHealthcarePartiesByParentIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.listHealthcarePartiesByParentId(
				decodedParams.parentId,
			)
		}.toPyStringAsyncCallback(ListSerializer(HealthcareParty.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetPublicKeyParams(
	public val healthcarePartyId: String,
)

public fun getPublicKeyBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetPublicKeyParams>(params)
	runBlocking {
		sdk.healthcareParty.getPublicKey(
			decodedParams.healthcarePartyId,
		)
	}
}.toPyString(PublicKey.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getPublicKeyAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetPublicKeyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.getPublicKey(
				decodedParams.healthcarePartyId,
			)
		}.toPyStringAsyncCallback(PublicKey.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteHealthcarePartiesParams(
	public val healthcarePartyIds: List<String>,
)

public fun deleteHealthcarePartiesBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteHealthcarePartiesParams>(params)
	runBlocking {
		sdk.healthcareParty.deleteHealthcareParties(
			decodedParams.healthcarePartyIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun deleteHealthcarePartiesAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteHealthcarePartiesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.deleteHealthcareParties(
				decodedParams.healthcarePartyIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyHealthcarePartyParams(
	public val healthcarePartyDto: HealthcareParty,
)

public fun modifyHealthcarePartyBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyHealthcarePartyParams>(params)
	runBlocking {
		sdk.healthcareParty.modifyHealthcareParty(
			decodedParams.healthcarePartyDto,
		)
	}
}.toPyString(HealthcareParty.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyHealthcarePartyAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyHealthcarePartyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.modifyHealthcareParty(
				decodedParams.healthcarePartyDto,
			)
		}.toPyStringAsyncCallback(HealthcareParty.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchHealthcarePartiesByParams(
	public val filter: BaseFilterOptions<HealthcareParty>,
)

public fun matchHealthcarePartiesByBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchHealthcarePartiesByParams>(params)
	runBlocking {
		sdk.healthcareParty.matchHealthcarePartiesBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun matchHealthcarePartiesByAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchHealthcarePartiesByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.matchHealthcarePartiesBy(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterHealthPartiesByParams(
	public val filter: BaseFilterOptions<HealthcareParty>,
)

public fun filterHealthPartiesByBlocking(sdk: IcureNonCryptoApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterHealthPartiesByParams>(params)
	runBlocking {
		sdk.healthcareParty.filterHealthPartiesBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, HealthcareParty.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun filterHealthPartiesByAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterHealthPartiesByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.filterHealthPartiesBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, HealthcareParty.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class MatchHealthcarePartiesBySortedParams(
	public val filter: BaseSortableFilterOptions<HealthcareParty>,
)

public fun matchHealthcarePartiesBySortedBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchHealthcarePartiesBySortedParams>(params)
	runBlocking {
		sdk.healthcareParty.matchHealthcarePartiesBySorted(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun matchHealthcarePartiesBySortedAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchHealthcarePartiesBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.matchHealthcarePartiesBySorted(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterHealthPartiesBySortedParams(
	public val filter: BaseSortableFilterOptions<HealthcareParty>,
)

public fun filterHealthPartiesBySortedBlocking(sdk: IcureNonCryptoApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterHealthPartiesBySortedParams>(params)
	runBlocking {
		sdk.healthcareParty.filterHealthPartiesBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, HealthcareParty.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun filterHealthPartiesBySortedAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterHealthPartiesBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.filterHealthPartiesBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, HealthcareParty.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class GetHealthcarePartiesInGroupParams(
	public val groupId: String,
	public val healthcarePartyIds: List<String>? = null,
)

public fun getHealthcarePartiesInGroupBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetHealthcarePartiesInGroupParams>(params)
	runBlocking {
		sdk.healthcareParty.getHealthcarePartiesInGroup(
			decodedParams.groupId,
			decodedParams.healthcarePartyIds,
		)
	}
}.toPyString(ListSerializer(HealthcareParty.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getHealthcarePartiesInGroupAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetHealthcarePartiesInGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.getHealthcarePartiesInGroup(
				decodedParams.groupId,
				decodedParams.healthcarePartyIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(HealthcareParty.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteHealthcarePartiesInGroupParams(
	public val groupId: String,
	public val healthcarePartyIds: List<String>,
)

public fun deleteHealthcarePartiesInGroupBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteHealthcarePartiesInGroupParams>(params)
	runBlocking {
		sdk.healthcareParty.deleteHealthcarePartiesInGroup(
			decodedParams.groupId,
			decodedParams.healthcarePartyIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun deleteHealthcarePartiesInGroupAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteHealthcarePartiesInGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.deleteHealthcarePartiesInGroup(
				decodedParams.groupId,
				decodedParams.healthcarePartyIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteHealthcarePartyInGroupParams(
	public val healthcarePartyId: String,
	public val groupId: String,
)

public fun deleteHealthcarePartyInGroupBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteHealthcarePartyInGroupParams>(params)
	runBlocking {
		sdk.healthcareParty.deleteHealthcarePartyInGroup(
			decodedParams.healthcarePartyId,
			decodedParams.groupId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun deleteHealthcarePartyInGroupAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteHealthcarePartyInGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.deleteHealthcarePartyInGroup(
				decodedParams.healthcarePartyId,
				decodedParams.groupId,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class RegisterPatientParams(
	public val groupId: String,
	public val parentHcPartyId: String? = null,
	public val token: String? = null,
	public val useShortToken: Boolean? = null,
	public val hcp: HealthcareParty,
)

public fun registerPatientBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<RegisterPatientParams>(params)
	runBlocking {
		sdk.healthcareParty.registerPatient(
			decodedParams.groupId,
			decodedParams.parentHcPartyId,
			decodedParams.token,
			decodedParams.useShortToken,
			decodedParams.hcp,
		)
	}
}.toPyString(DataOwnerRegistrationSuccess.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun registerPatientAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<RegisterPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareParty.registerPatient(
				decodedParams.groupId,
				decodedParams.parentHcPartyId,
				decodedParams.token,
				decodedParams.useShortToken,
				decodedParams.hcp,
			)
		}.toPyStringAsyncCallback(DataOwnerRegistrationSuccess.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
