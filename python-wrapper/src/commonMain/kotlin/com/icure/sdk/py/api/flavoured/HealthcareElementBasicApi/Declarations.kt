// auto-generated file
package com.icure.sdk.py.api.flavoured.HealthcareElementBasicApi

import com.icure.sdk.IcureBaseApis
import com.icure.sdk.model.EncryptedHealthElement
import com.icure.sdk.model.HealthElement
import com.icure.sdk.model.IcureStub
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.notification.SubscriptionEventType
import com.icure.sdk.py.subscription.EntitySubscription.EntitySubscriptionWithSerializer
import com.icure.sdk.py.utils.PyResult
import com.icure.sdk.py.utils.failureToPyResultAsyncCallback
import com.icure.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.sdk.py.utils.toPyResult
import com.icure.sdk.py.utils.toPyResultAsyncCallback
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.py.utils.toPyStringAsyncCallback
import com.icure.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.sdk.utils.Serialization.json
import kotlin.Byte
import kotlin.Int
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
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer

@Serializable
private class MatchHealthcareElementsByParams(
	@Contextual
	public val filter: AbstractFilter<HealthElement>,
)

public fun matchHealthcareElementsByBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchHealthcareElementsByParams>(params)
	runBlocking {
		sdk.healthcareElement.matchHealthcareElementsBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun matchHealthcareElementsByAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchHealthcareElementsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareElement.matchHealthcareElementsBy(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteHealthcareElementParams(
	public val entityId: String,
)

public fun deleteHealthcareElementBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteHealthcareElementParams>(params)
	runBlocking {
		sdk.healthcareElement.deleteHealthcareElement(
			decodedParams.entityId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun deleteHealthcareElementAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteHealthcareElementParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareElement.deleteHealthcareElement(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteHealthcareElementsParams(
	public val entityIds: List<String>,
)

public fun deleteHealthcareElementsBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteHealthcareElementsParams>(params)
	runBlocking {
		sdk.healthcareElement.deleteHealthcareElements(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun deleteHealthcareElementsAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteHealthcareElementsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareElement.deleteHealthcareElements(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindHealthcareElementsDelegationsStubsByHcPartyPatientForeignKeysParams(
	public val hcPartyId: String,
	public val secretPatientKeys: List<String>,
)

public
		fun findHealthcareElementsDelegationsStubsByHcPartyPatientForeignKeysBlocking(sdk: IcureBaseApis,
		params: String): String = kotlin.runCatching {
	val decodedParams =
			json.decodeFromString<FindHealthcareElementsDelegationsStubsByHcPartyPatientForeignKeysParams>(params)
	runBlocking {
		sdk.healthcareElement.findHealthcareElementsDelegationsStubsByHcPartyPatientForeignKeys(
			decodedParams.hcPartyId,
			decodedParams.secretPatientKeys,
		)
	}
}.toPyString(ListSerializer(IcureStub.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findHealthcareElementsDelegationsStubsByHcPartyPatientForeignKeysAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			json.decodeFromString<FindHealthcareElementsDelegationsStubsByHcPartyPatientForeignKeysParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareElement.findHealthcareElementsDelegationsStubsByHcPartyPatientForeignKeys(
				decodedParams.hcPartyId,
				decodedParams.secretPatientKeys,
			)
		}.toPyStringAsyncCallback(ListSerializer(IcureStub.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SubscribeToEventsParams(
	public val events: Set<SubscriptionEventType>,
	@Contextual
	public val filter: AbstractFilter<HealthElement>,
	public val subscriptionConfig: EntitySubscriptionConfiguration? = null,
)

public fun subscribeToEventsBlocking(sdk: IcureBaseApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<SubscribeToEventsParams>(params)
	runBlocking {
		sdk.healthcareElement.subscribeToEvents(
			decodedParams.events,
			decodedParams.filter,
			decodedParams.subscriptionConfig,
		)
	}
}.toPyResult {
	EntitySubscriptionWithSerializer(it, EncryptedHealthElement.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun subscribeToEventsAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<SubscribeToEventsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareElement.subscribeToEvents(
				decodedParams.events,
				decodedParams.filter,
				decodedParams.subscriptionConfig,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			EntitySubscriptionWithSerializer(it, EncryptedHealthElement.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class ModifyHealthcareElementParams(
	public val entity: EncryptedHealthElement,
)

public fun modifyHealthcareElementBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyHealthcareElementParams>(params)
	runBlocking {
		sdk.healthcareElement.modifyHealthcareElement(
			decodedParams.entity,
		)
	}
}.toPyString(EncryptedHealthElement.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyHealthcareElementAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyHealthcareElementParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareElement.modifyHealthcareElement(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(EncryptedHealthElement.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyHealthcareElementsParams(
	public val entities: List<EncryptedHealthElement>,
)

public fun modifyHealthcareElementsBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyHealthcareElementsParams>(params)
	runBlocking {
		sdk.healthcareElement.modifyHealthcareElements(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(EncryptedHealthElement.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun modifyHealthcareElementsAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyHealthcareElementsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareElement.modifyHealthcareElements(
				decodedParams.entities,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedHealthElement.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetHealthcareElementParams(
	public val entityId: String,
)

public fun getHealthcareElementBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetHealthcareElementParams>(params)
	runBlocking {
		sdk.healthcareElement.getHealthcareElement(
			decodedParams.entityId,
		)
	}
}.toPyString(EncryptedHealthElement.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getHealthcareElementAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetHealthcareElementParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareElement.getHealthcareElement(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(EncryptedHealthElement.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetHealthcareElementsParams(
	public val entityIds: List<String>,
)

public fun getHealthcareElementsBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetHealthcareElementsParams>(params)
	runBlocking {
		sdk.healthcareElement.getHealthcareElements(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(EncryptedHealthElement.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getHealthcareElementsAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetHealthcareElementsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareElement.getHealthcareElements(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedHealthElement.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterHealthcareElementsByParams(
	public val filterChain: FilterChain<HealthElement>,
	public val startDocumentId: String?,
	public val limit: Int?,
)

public fun filterHealthcareElementsByBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterHealthcareElementsByParams>(params)
	runBlocking {
		sdk.healthcareElement.filterHealthcareElementsBy(
			decodedParams.filterChain,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(EncryptedHealthElement.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun filterHealthcareElementsByAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterHealthcareElementsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareElement.filterHealthcareElementsBy(
				decodedParams.filterChain,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(EncryptedHealthElement.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindHealthcareElementsByHcPartyPatientForeignKeysParams(
	public val hcPartyId: String,
	public val secretPatientKeys: List<String>,
)

public fun findHealthcareElementsByHcPartyPatientForeignKeysBlocking(sdk: IcureBaseApis,
		params: String): String = kotlin.runCatching {
	val decodedParams =
			json.decodeFromString<FindHealthcareElementsByHcPartyPatientForeignKeysParams>(params)
	runBlocking {
		sdk.healthcareElement.findHealthcareElementsByHcPartyPatientForeignKeys(
			decodedParams.hcPartyId,
			decodedParams.secretPatientKeys,
		)
	}
}.toPyString(ListSerializer(EncryptedHealthElement.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findHealthcareElementsByHcPartyPatientForeignKeysAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			json.decodeFromString<FindHealthcareElementsByHcPartyPatientForeignKeysParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareElement.findHealthcareElementsByHcPartyPatientForeignKeys(
				decodedParams.hcPartyId,
				decodedParams.secretPatientKeys,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedHealthElement.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
