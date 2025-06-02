// auto-generated file
package com.icure.cardinal.sdk.py.api.ClassificationApi.encrypted

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.ClassificationShareOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.Classification
import com.icure.cardinal.sdk.model.EncryptedClassification
import com.icure.cardinal.sdk.model.Patient
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
	public val classification: EncryptedClassification,
	public val options: ClassificationShareOptions? = null,
)

@OptIn(InternalIcureApi::class)
public fun shareWithBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.classification.encrypted.shareWith(
			decodedParams.delegateId,
			decodedParams.classification,
			decodedParams.options,
		)
	}
}.toPyString(EncryptedClassification.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun shareWithAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.classification.encrypted.shareWith(
				decodedParams.delegateId,
				decodedParams.classification,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(EncryptedClassification.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val classification: EncryptedClassification,
	public val delegates: Map<String, ClassificationShareOptions>,
)

@OptIn(InternalIcureApi::class)
public fun shareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.classification.encrypted.shareWithMany(
			decodedParams.classification,
			decodedParams.delegates,
		)
	}
}.toPyString(EncryptedClassification.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun shareWithManyAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithManyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.classification.encrypted.shareWithMany(
				decodedParams.classification,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(EncryptedClassification.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindClassificationsByHcPartyPatientParams(
	public val hcPartyId: String,
	public val patient: Patient,
	public val startDate: Long? = null,
	public val endDate: Long? = null,
	public val descending: Boolean? = null,
)

@OptIn(InternalIcureApi::class)
public fun findClassificationsByHcPartyPatientBlocking(sdk: CardinalApis, params: String): PyResult
		= kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindClassificationsByHcPartyPatientParams>(params)
	runBlocking {
		sdk.classification.encrypted.findClassificationsByHcPartyPatient(
			decodedParams.hcPartyId,
			decodedParams.patient,
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.descending,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, EncryptedClassification.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findClassificationsByHcPartyPatientAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindClassificationsByHcPartyPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.classification.encrypted.findClassificationsByHcPartyPatient(
				decodedParams.hcPartyId,
				decodedParams.patient,
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.descending,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, EncryptedClassification.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterClassificationsByParams(
	public val filter: FilterOptions<Classification>,
)

@OptIn(InternalIcureApi::class)
public fun filterClassificationsByBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterClassificationsByParams>(params)
	runBlocking {
		sdk.classification.encrypted.filterClassificationsBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, EncryptedClassification.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterClassificationsByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterClassificationsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.classification.encrypted.filterClassificationsBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, EncryptedClassification.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterClassificationsBySortedParams(
	public val filter: SortableFilterOptions<Classification>,
)

@OptIn(InternalIcureApi::class)
public fun filterClassificationsBySortedBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterClassificationsBySortedParams>(params)
	runBlocking {
		sdk.classification.encrypted.filterClassificationsBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, EncryptedClassification.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterClassificationsBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterClassificationsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.classification.encrypted.filterClassificationsBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, EncryptedClassification.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class CreateClassificationParams(
	public val entity: EncryptedClassification,
)

@OptIn(InternalIcureApi::class)
public fun createClassificationBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateClassificationParams>(params)
	runBlocking {
		sdk.classification.encrypted.createClassification(
			decodedParams.entity,
		)
	}
}.toPyString(EncryptedClassification.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createClassificationAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateClassificationParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.classification.encrypted.createClassification(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(EncryptedClassification.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyClassificationParams(
	public val entity: EncryptedClassification,
)

@OptIn(InternalIcureApi::class)
public fun modifyClassificationBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyClassificationParams>(params)
	runBlocking {
		sdk.classification.encrypted.modifyClassification(
			decodedParams.entity,
		)
	}
}.toPyString(EncryptedClassification.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyClassificationAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyClassificationParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.classification.encrypted.modifyClassification(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(EncryptedClassification.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetClassificationParams(
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun getClassificationBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetClassificationParams>(params)
	runBlocking {
		sdk.classification.encrypted.getClassification(
			decodedParams.entityId,
		)
	}
}.toPyString(EncryptedClassification.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getClassificationAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetClassificationParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.classification.encrypted.getClassification(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(EncryptedClassification.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetClassificationsParams(
	public val entityIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getClassificationsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetClassificationsParams>(params)
	runBlocking {
		sdk.classification.encrypted.getClassifications(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(EncryptedClassification.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getClassificationsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetClassificationsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.classification.encrypted.getClassifications(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedClassification.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
