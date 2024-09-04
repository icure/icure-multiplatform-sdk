// auto-generated file
package com.icure.sdk.py.api.HealthElementBasicApi

import com.icure.sdk.CardinalBaseApis
import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.model.EncryptedHealthElement
import com.icure.sdk.model.HealthElement
import com.icure.sdk.model.IcureStub
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.py.subscription.EntitySubscription.EntitySubscriptionWithSerializer
import com.icure.sdk.py.utils.PaginatedListIterator.PaginatedListIteratorAndSerializer
import com.icure.sdk.py.utils.PyResult
import com.icure.sdk.py.utils.failureToPyResultAsyncCallback
import com.icure.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.sdk.py.utils.toPyResult
import com.icure.sdk.py.utils.toPyResultAsyncCallback
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.py.utils.toPyStringAsyncCallback
import com.icure.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.sdk.subscription.SubscriptionEventType
import com.icure.sdk.utils.Serialization.json
import kotlin.Byte
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
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
import kotlinx.serialization.builtins.serializer

@Serializable
private class MatchHealthElementsByParams(
	public val filter: BaseFilterOptions<HealthElement>,
)

public fun matchHealthElementsByBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchHealthElementsByParams>(params)
	runBlocking {
		sdk.healthElement.matchHealthElementsBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun matchHealthElementsByAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchHealthElementsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthElement.matchHealthElementsBy(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchHealthElementsBySortedParams(
	public val filter: BaseSortableFilterOptions<HealthElement>,
)

public fun matchHealthElementsBySortedBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchHealthElementsBySortedParams>(params)
	runBlocking {
		sdk.healthElement.matchHealthElementsBySorted(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun matchHealthElementsBySortedAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchHealthElementsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthElement.matchHealthElementsBySorted(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterHealthElementsByParams(
	public val filter: BaseFilterOptions<HealthElement>,
)

public fun filterHealthElementsByBlocking(sdk: CardinalBaseApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterHealthElementsByParams>(params)
	runBlocking {
		sdk.healthElement.filterHealthElementsBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, EncryptedHealthElement.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun filterHealthElementsByAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterHealthElementsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthElement.filterHealthElementsBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, EncryptedHealthElement.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterHealthElementsBySortedParams(
	public val filter: BaseSortableFilterOptions<HealthElement>,
)

public fun filterHealthElementsBySortedBlocking(sdk: CardinalBaseApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterHealthElementsBySortedParams>(params)
	runBlocking {
		sdk.healthElement.filterHealthElementsBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, EncryptedHealthElement.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun filterHealthElementsBySortedAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterHealthElementsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthElement.filterHealthElementsBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, EncryptedHealthElement.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class DeleteHealthElementParams(
	public val entityId: String,
)

public fun deleteHealthElementBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteHealthElementParams>(params)
	runBlocking {
		sdk.healthElement.deleteHealthElement(
			decodedParams.entityId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun deleteHealthElementAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteHealthElementParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthElement.deleteHealthElement(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteHealthElementsParams(
	public val entityIds: List<String>,
)

public fun deleteHealthElementsBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteHealthElementsParams>(params)
	runBlocking {
		sdk.healthElement.deleteHealthElements(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun deleteHealthElementsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteHealthElementsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthElement.deleteHealthElements(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindHealthElementsDelegationsStubsByHcPartyPatientForeignKeysParams(
	public val hcPartyId: String,
	public val secretPatientKeys: List<String>,
)

public fun findHealthElementsDelegationsStubsByHcPartyPatientForeignKeysBlocking(sdk: CardinalBaseApis,
                                                                                 params: String): String = kotlin.runCatching {
	val decodedParams =
			json.decodeFromString<FindHealthElementsDelegationsStubsByHcPartyPatientForeignKeysParams>(params)
	runBlocking {
		sdk.healthElement.findHealthElementsDelegationsStubsByHcPartyPatientForeignKeys(
			decodedParams.hcPartyId,
			decodedParams.secretPatientKeys,
		)
	}
}.toPyString(ListSerializer(IcureStub.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findHealthElementsDelegationsStubsByHcPartyPatientForeignKeysAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			json.decodeFromString<FindHealthElementsDelegationsStubsByHcPartyPatientForeignKeysParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthElement.findHealthElementsDelegationsStubsByHcPartyPatientForeignKeys(
				decodedParams.hcPartyId,
				decodedParams.secretPatientKeys,
			)
		}.toPyStringAsyncCallback(ListSerializer(IcureStub.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyHealthElementParams(
	public val entity: EncryptedHealthElement,
)

public fun modifyHealthElementBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyHealthElementParams>(params)
	runBlocking {
		sdk.healthElement.modifyHealthElement(
			decodedParams.entity,
		)
	}
}.toPyString(EncryptedHealthElement.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyHealthElementAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyHealthElementParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthElement.modifyHealthElement(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(EncryptedHealthElement.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyHealthElementsParams(
	public val entities: List<EncryptedHealthElement>,
)

public fun modifyHealthElementsBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyHealthElementsParams>(params)
	runBlocking {
		sdk.healthElement.modifyHealthElements(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(EncryptedHealthElement.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun modifyHealthElementsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyHealthElementsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthElement.modifyHealthElements(
				decodedParams.entities,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedHealthElement.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetHealthElementParams(
	public val entityId: String,
)

public fun getHealthElementBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetHealthElementParams>(params)
	runBlocking {
		sdk.healthElement.getHealthElement(
			decodedParams.entityId,
		)
	}
}.toPyString(EncryptedHealthElement.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getHealthElementAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetHealthElementParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthElement.getHealthElement(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(EncryptedHealthElement.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetHealthElementsParams(
	public val entityIds: List<String>,
)

public fun getHealthElementsBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetHealthElementsParams>(params)
	runBlocking {
		sdk.healthElement.getHealthElements(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(EncryptedHealthElement.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getHealthElementsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetHealthElementsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthElement.getHealthElements(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedHealthElement.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindHealthElementsByHcPartyPatientForeignKeysParams(
	public val hcPartyId: String,
	public val secretPatientKeys: List<String>,
)

public fun findHealthElementsByHcPartyPatientForeignKeysBlocking(sdk: CardinalBaseApis,
                                                                 params: String): String = kotlin.runCatching {
	val decodedParams =
			json.decodeFromString<FindHealthElementsByHcPartyPatientForeignKeysParams>(params)
	runBlocking {
		sdk.healthElement.findHealthElementsByHcPartyPatientForeignKeys(
			decodedParams.hcPartyId,
			decodedParams.secretPatientKeys,
		)
	}
}.toPyString(ListSerializer(EncryptedHealthElement.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findHealthElementsByHcPartyPatientForeignKeysAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			json.decodeFromString<FindHealthElementsByHcPartyPatientForeignKeysParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthElement.findHealthElementsByHcPartyPatientForeignKeys(
				decodedParams.hcPartyId,
				decodedParams.secretPatientKeys,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedHealthElement.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SubscribeToEventsParams(
	public val events: Set<SubscriptionEventType>,
	public val filter: BaseFilterOptions<HealthElement>,
	public val subscriptionConfig: EntitySubscriptionConfiguration? = null,
)

public fun subscribeToEventsBlocking(sdk: CardinalBaseApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<SubscribeToEventsParams>(params)
	runBlocking {
		sdk.healthElement.subscribeToEvents(
			decodedParams.events,
			decodedParams.filter,
			decodedParams.subscriptionConfig,
		)
	}
}.toPyResult {
	EntitySubscriptionWithSerializer(it, EncryptedHealthElement.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun subscribeToEventsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<SubscribeToEventsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthElement.subscribeToEvents(
				decodedParams.events,
				decodedParams.filter,
				decodedParams.subscriptionConfig,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			EntitySubscriptionWithSerializer(it, EncryptedHealthElement.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)
