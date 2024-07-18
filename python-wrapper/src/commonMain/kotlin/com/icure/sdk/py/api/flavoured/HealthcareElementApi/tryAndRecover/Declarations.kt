// auto-generated file
package com.icure.sdk.py.api.flavoured.HealthcareElementApi.tryAndRecover

import com.icure.sdk.IcureApis
import com.icure.sdk.crypto.entities.HealthElementShareOptions
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.model.HealthElement
import com.icure.sdk.model.Patient
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.requests.RequestedPermission
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
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer

@Serializable
private class ShareWithParams(
	public val delegateId: String,
	public val healthcareElement: HealthElement,
	public val shareEncryptionKeys: ShareMetadataBehaviour =
			com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable,
	public val shareOwningEntityIds: ShareMetadataBehaviour =
			com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable,
	public val requestedPermission: RequestedPermission =
			com.icure.sdk.model.requests.RequestedPermission.MaxWrite,
)

public fun shareWithBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.healthcareElement.tryAndRecover.shareWith(
			decodedParams.delegateId,
			decodedParams.healthcareElement,
			decodedParams.shareEncryptionKeys,
			decodedParams.shareOwningEntityIds,
			decodedParams.requestedPermission,
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
			sdk.healthcareElement.tryAndRecover.shareWith(
				decodedParams.delegateId,
				decodedParams.healthcareElement,
				decodedParams.shareEncryptionKeys,
				decodedParams.shareOwningEntityIds,
				decodedParams.requestedPermission,
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
		sdk.healthcareElement.tryAndRecover.tryShareWithMany(
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
			sdk.healthcareElement.tryAndRecover.tryShareWithMany(
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
		sdk.healthcareElement.tryAndRecover.shareWithMany(
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
			sdk.healthcareElement.tryAndRecover.shareWithMany(
				decodedParams.healthElement,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(HealthElementSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindHealthcareElementsByHcPartyPatientParams(
	public val hcPartyId: String,
	@Serializable(PatientSerializer::class)
	public val patient: Patient,
	public val startDate: Long? = null,
	public val endDate: Long? = null,
	public val descending: Boolean? = null,
)

public fun findHealthcareElementsByHcPartyPatientBlocking(sdk: IcureApis, params: String): PyResult
		= kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindHealthcareElementsByHcPartyPatientParams>(params)
	runBlocking {
		sdk.healthcareElement.tryAndRecover.findHealthcareElementsByHcPartyPatient(
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
public fun findHealthcareElementsByHcPartyPatientAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindHealthcareElementsByHcPartyPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareElement.tryAndRecover.findHealthcareElementsByHcPartyPatient(
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
private class ModifyHealthcareElementParams(
	public val entity: HealthElement,
)

public fun modifyHealthcareElementBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyHealthcareElementParams>(params)
	runBlocking {
		sdk.healthcareElement.tryAndRecover.modifyHealthcareElement(
			decodedParams.entity,
		)
	}
}.toPyString(HealthElementSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun modifyHealthcareElementAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyHealthcareElementParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareElement.tryAndRecover.modifyHealthcareElement(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(HealthElementSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyHealthcareElementsParams(
	public val entities: List<HealthElement>,
)

public fun modifyHealthcareElementsBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyHealthcareElementsParams>(params)
	runBlocking {
		sdk.healthcareElement.tryAndRecover.modifyHealthcareElements(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(HealthElementSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun modifyHealthcareElementsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyHealthcareElementsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareElement.tryAndRecover.modifyHealthcareElements(
				decodedParams.entities,
			)
		}.toPyStringAsyncCallback(ListSerializer(HealthElementSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetHealthcareElementParams(
	public val entityId: String,
)

public fun getHealthcareElementBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetHealthcareElementParams>(params)
	runBlocking {
		sdk.healthcareElement.tryAndRecover.getHealthcareElement(
			decodedParams.entityId,
		)
	}
}.toPyString(HealthElementSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun getHealthcareElementAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetHealthcareElementParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareElement.tryAndRecover.getHealthcareElement(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(HealthElementSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetHealthcareElementsParams(
	public val entityIds: List<String>,
)

public fun getHealthcareElementsBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetHealthcareElementsParams>(params)
	runBlocking {
		sdk.healthcareElement.tryAndRecover.getHealthcareElements(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(HealthElementSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun getHealthcareElementsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetHealthcareElementsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareElement.tryAndRecover.getHealthcareElements(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(HealthElementSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterHealthcareElementsByParams(
	@Contextual
	public val filter: AbstractFilter<HealthElement>,
)

public fun filterHealthcareElementsByBlocking(sdk: IcureApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterHealthcareElementsByParams>(params)
	runBlocking {
		sdk.healthcareElement.tryAndRecover.filterHealthcareElementsBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, HealthElementSerializer)}

@OptIn(ExperimentalForeignApi::class)
public fun filterHealthcareElementsByAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterHealthcareElementsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareElement.tryAndRecover.filterHealthcareElementsBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, HealthElementSerializer)}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FindHealthcareElementsByHcPartyPatientForeignKeysParams(
	public val hcPartyId: String,
	public val secretPatientKeys: List<String>,
)

public fun findHealthcareElementsByHcPartyPatientForeignKeysBlocking(sdk: IcureApis,
		params: String): String = kotlin.runCatching {
	val decodedParams =
			json.decodeFromString<FindHealthcareElementsByHcPartyPatientForeignKeysParams>(params)
	runBlocking {
		sdk.healthcareElement.tryAndRecover.findHealthcareElementsByHcPartyPatientForeignKeys(
			decodedParams.hcPartyId,
			decodedParams.secretPatientKeys,
		)
	}
}.toPyString(ListSerializer(HealthElementSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun findHealthcareElementsByHcPartyPatientForeignKeysAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			json.decodeFromString<FindHealthcareElementsByHcPartyPatientForeignKeysParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthcareElement.tryAndRecover.findHealthcareElementsByHcPartyPatientForeignKeys(
				decodedParams.hcPartyId,
				decodedParams.secretPatientKeys,
			)
		}.toPyStringAsyncCallback(ListSerializer(HealthElementSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
