// auto-generated file
package com.icure.sdk.py.api.HealthElementApi.tryAndRecover

import com.icure.sdk.IcureApis
import com.icure.sdk.crypto.entities.HealthElementShareOptions
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.filters.FilterOptions
import com.icure.sdk.filters.SortableFilterOptions
import com.icure.sdk.model.HealthElement
import com.icure.sdk.model.Patient
import com.icure.sdk.py.serialization.HealthElementSerializer
import com.icure.sdk.py.serialization.PatientSerializer
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
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Map
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
	public val healthElement: HealthElement,
	public val options: HealthElementShareOptions? = null,
)

public fun shareWithBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.healthElement.tryAndRecover.shareWith(
			decodedParams.delegateId,
			decodedParams.healthElement,
			decodedParams.options,
		)
	}
}.toPyString(SimpleShareResult.serializer(HealthElementSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun shareWithAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthElement.tryAndRecover.shareWith(
				decodedParams.delegateId,
				decodedParams.healthElement,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(HealthElementSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryShareWithManyParams(
	public val healthElement: HealthElement,
	public val delegates: Map<String, HealthElementShareOptions>,
)

public fun tryShareWithManyBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryShareWithManyParams>(params)
	runBlocking {
		sdk.healthElement.tryAndRecover.tryShareWithMany(
			decodedParams.healthElement,
			decodedParams.delegates,
		)
	}
}.toPyString(SimpleShareResult.serializer(HealthElementSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun tryShareWithManyAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryShareWithManyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthElement.tryAndRecover.tryShareWithMany(
				decodedParams.healthElement,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(HealthElementSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val healthElement: HealthElement,
	public val delegates: Map<String, HealthElementShareOptions>,
)

public fun shareWithManyBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.healthElement.tryAndRecover.shareWithMany(
			decodedParams.healthElement,
			decodedParams.delegates,
		)
	}
}.toPyString(HealthElementSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun shareWithManyAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithManyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthElement.tryAndRecover.shareWithMany(
				decodedParams.healthElement,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(HealthElementSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindHealthElementsByHcPartyPatientParams(
	public val hcPartyId: String,
	@Serializable(PatientSerializer::class)
	public val patient: Patient,
	public val startDate: Long? = null,
	public val endDate: Long? = null,
	public val descending: Boolean? = null,
)

public fun findHealthElementsByHcPartyPatientBlocking(sdk: IcureApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindHealthElementsByHcPartyPatientParams>(params)
	runBlocking {
		sdk.healthElement.tryAndRecover.findHealthElementsByHcPartyPatient(
			decodedParams.hcPartyId,
			decodedParams.patient,
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.descending,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, HealthElementSerializer)}

@OptIn(ExperimentalForeignApi::class)
public fun findHealthElementsByHcPartyPatientAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindHealthElementsByHcPartyPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthElement.tryAndRecover.findHealthElementsByHcPartyPatient(
				decodedParams.hcPartyId,
				decodedParams.patient,
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.descending,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, HealthElementSerializer)}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterHealthElementsByParams(
	public val filter: FilterOptions<HealthElement>,
)

public fun filterHealthElementsByBlocking(sdk: IcureApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterHealthElementsByParams>(params)
	runBlocking {
		sdk.healthElement.tryAndRecover.filterHealthElementsBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, HealthElementSerializer)}

@OptIn(ExperimentalForeignApi::class)
public fun filterHealthElementsByAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterHealthElementsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthElement.tryAndRecover.filterHealthElementsBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, HealthElementSerializer)}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterHealthElementsBySortedParams(
	public val filter: SortableFilterOptions<HealthElement>,
)

public fun filterHealthElementsBySortedBlocking(sdk: IcureApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterHealthElementsBySortedParams>(params)
	runBlocking {
		sdk.healthElement.tryAndRecover.filterHealthElementsBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, HealthElementSerializer)}

@OptIn(ExperimentalForeignApi::class)
public fun filterHealthElementsBySortedAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterHealthElementsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthElement.tryAndRecover.filterHealthElementsBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, HealthElementSerializer)}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class ModifyHealthElementParams(
	public val entity: HealthElement,
)

public fun modifyHealthElementBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyHealthElementParams>(params)
	runBlocking {
		sdk.healthElement.tryAndRecover.modifyHealthElement(
			decodedParams.entity,
		)
	}
}.toPyString(HealthElementSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun modifyHealthElementAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyHealthElementParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthElement.tryAndRecover.modifyHealthElement(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(HealthElementSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyHealthElementsParams(
	public val entities: List<HealthElement>,
)

public fun modifyHealthElementsBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyHealthElementsParams>(params)
	runBlocking {
		sdk.healthElement.tryAndRecover.modifyHealthElements(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(HealthElementSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun modifyHealthElementsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyHealthElementsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthElement.tryAndRecover.modifyHealthElements(
				decodedParams.entities,
			)
		}.toPyStringAsyncCallback(ListSerializer(HealthElementSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetHealthElementParams(
	public val entityId: String,
)

public fun getHealthElementBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetHealthElementParams>(params)
	runBlocking {
		sdk.healthElement.tryAndRecover.getHealthElement(
			decodedParams.entityId,
		)
	}
}.toPyString(HealthElementSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun getHealthElementAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetHealthElementParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthElement.tryAndRecover.getHealthElement(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(HealthElementSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetHealthElementsParams(
	public val entityIds: List<String>,
)

public fun getHealthElementsBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetHealthElementsParams>(params)
	runBlocking {
		sdk.healthElement.tryAndRecover.getHealthElements(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(HealthElementSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun getHealthElementsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetHealthElementsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthElement.tryAndRecover.getHealthElements(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(HealthElementSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindHealthElementsByHcPartyPatientForeignKeysParams(
	public val hcPartyId: String,
	public val secretPatientKeys: List<String>,
)

public fun findHealthElementsByHcPartyPatientForeignKeysBlocking(sdk: IcureApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			json.decodeFromString<FindHealthElementsByHcPartyPatientForeignKeysParams>(params)
	runBlocking {
		sdk.healthElement.tryAndRecover.findHealthElementsByHcPartyPatientForeignKeys(
			decodedParams.hcPartyId,
			decodedParams.secretPatientKeys,
		)
	}
}.toPyString(ListSerializer(HealthElementSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun findHealthElementsByHcPartyPatientForeignKeysAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			json.decodeFromString<FindHealthElementsByHcPartyPatientForeignKeysParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthElement.tryAndRecover.findHealthElementsByHcPartyPatientForeignKeys(
				decodedParams.hcPartyId,
				decodedParams.secretPatientKeys,
			)
		}.toPyStringAsyncCallback(ListSerializer(HealthElementSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)