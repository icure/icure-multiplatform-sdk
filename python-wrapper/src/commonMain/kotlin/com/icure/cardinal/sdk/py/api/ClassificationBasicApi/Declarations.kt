// auto-generated file
package com.icure.cardinal.sdk.py.api.ClassificationBasicApi

import com.icure.cardinal.sdk.CardinalBaseApis
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.Classification
import com.icure.cardinal.sdk.model.EncryptedClassification
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
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
private class MatchClassificationsByParams(
	public val filter: BaseFilterOptions<Classification>,
)

@OptIn(InternalIcureApi::class)
public fun matchClassificationsByBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchClassificationsByParams>(params)
	runBlocking {
		sdk.classification.matchClassificationsBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchClassificationsByAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchClassificationsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.classification.matchClassificationsBy(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchClassificationsBySortedParams(
	public val filter: BaseSortableFilterOptions<Classification>,
)

@OptIn(InternalIcureApi::class)
public fun matchClassificationsBySortedBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<MatchClassificationsBySortedParams>(params)
	runBlocking {
		sdk.classification.matchClassificationsBySorted(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchClassificationsBySortedAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<MatchClassificationsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.classification.matchClassificationsBySorted(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterClassificationsByParams(
	public val filter: BaseFilterOptions<Classification>,
)

@OptIn(InternalIcureApi::class)
public fun filterClassificationsByBlocking(sdk: CardinalBaseApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterClassificationsByParams>(params)
	runBlocking {
		sdk.classification.filterClassificationsBy(
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
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterClassificationsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.classification.filterClassificationsBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, EncryptedClassification.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterClassificationsBySortedParams(
	public val filter: BaseSortableFilterOptions<Classification>,
)

@OptIn(InternalIcureApi::class)
public fun filterClassificationsBySortedBlocking(sdk: CardinalBaseApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterClassificationsBySortedParams>(params)
	runBlocking {
		sdk.classification.filterClassificationsBySorted(
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
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FilterClassificationsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.classification.filterClassificationsBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, EncryptedClassification.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class DeleteClassificationParams(
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun deleteClassificationBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteClassificationParams>(params)
	runBlocking {
		sdk.classification.deleteClassification(
			decodedParams.entityId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteClassificationAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteClassificationParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.classification.deleteClassification(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteClassificationsParams(
	public val entityIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun deleteClassificationsBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteClassificationsParams>(params)
	runBlocking {
		sdk.classification.deleteClassifications(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteClassificationsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteClassificationsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.classification.deleteClassifications(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyClassificationParams(
	public val entity: EncryptedClassification,
)

@OptIn(InternalIcureApi::class)
public fun modifyClassificationBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyClassificationParams>(params)
	runBlocking {
		sdk.classification.modifyClassification(
			decodedParams.entity,
		)
	}
}.toPyString(EncryptedClassification.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyClassificationAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyClassificationParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.classification.modifyClassification(
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
public fun getClassificationBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetClassificationParams>(params)
	runBlocking {
		sdk.classification.getClassification(
			decodedParams.entityId,
		)
	}
}.toPyString(EncryptedClassification.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getClassificationAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetClassificationParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.classification.getClassification(
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
public fun getClassificationsBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetClassificationsParams>(params)
	runBlocking {
		sdk.classification.getClassifications(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(EncryptedClassification.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getClassificationsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetClassificationsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.classification.getClassifications(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedClassification.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
