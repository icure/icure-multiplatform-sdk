// auto-generated file
package com.icure.sdk.py.api.flavoured.HealthcareElementApi.encrypted

import com.icure.sdk.IcureApis
import com.icure.sdk.crypto.entities.HealthElementShareOptions
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.model.EncryptedHealthElement
import com.icure.sdk.model.HealthElement
import com.icure.sdk.model.Patient
import com.icure.sdk.model.filter.AbstractFilter
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
	public val healthcareElement: EncryptedHealthElement,
	public val options: HealthElementShareOptions? = null,
)

public fun shareWithBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.healthElement.encrypted.shareWith(
			decodedParams.delegateId,
			decodedParams.healthcareElement,
			decodedParams.options,
		)
	}
}.toPyString(SimpleShareResult.serializer(EncryptedHealthElement.serializer()))

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
			sdk.healthElement.encrypted.shareWith(
				decodedParams.delegateId,
				decodedParams.healthcareElement,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(EncryptedHealthElement.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryShareWithManyParams(
	public val healthElement: EncryptedHealthElement,
	public val delegates: Map<String, HealthElementShareOptions>,
)

public fun tryShareWithManyBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryShareWithManyParams>(params)
	runBlocking {
		sdk.healthElement.encrypted.tryShareWithMany(
			decodedParams.healthElement,
			decodedParams.delegates,
		)
	}
}.toPyString(SimpleShareResult.serializer(EncryptedHealthElement.serializer()))

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
			sdk.healthElement.encrypted.tryShareWithMany(
				decodedParams.healthElement,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(EncryptedHealthElement.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val healthElement: EncryptedHealthElement,
	public val delegates: Map<String, HealthElementShareOptions>,
)

public fun shareWithManyBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.healthElement.encrypted.shareWithMany(
			decodedParams.healthElement,
			decodedParams.delegates,
		)
	}
}.toPyString(EncryptedHealthElement.serializer())

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
			sdk.healthElement.encrypted.shareWithMany(
				decodedParams.healthElement,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(EncryptedHealthElement.serializer(), resultCallback)
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
		sdk.healthElement.encrypted.findHealthElementsByHcPartyPatient(
			decodedParams.hcPartyId,
			decodedParams.patient,
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.descending,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, EncryptedHealthElement.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun findHealthcareElementsByHcPartyPatientAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindHealthcareElementsByHcPartyPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthElement.encrypted.findHealthElementsByHcPartyPatient(
				decodedParams.hcPartyId,
				decodedParams.patient,
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.descending,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, EncryptedHealthElement.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class ModifyHealthcareElementParams(
	public val entity: EncryptedHealthElement,
)

public fun modifyHealthcareElementBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyHealthcareElementParams>(params)
	runBlocking {
		sdk.healthElement.encrypted.modifyHealthElement(
			decodedParams.entity,
		)
	}
}.toPyString(EncryptedHealthElement.serializer())

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
			sdk.healthElement.encrypted.modifyHealthElement(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(EncryptedHealthElement.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyHealthcareElementsParams(
	public val entities: List<EncryptedHealthElement>,
)

public fun modifyHealthcareElementsBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyHealthcareElementsParams>(params)
	runBlocking {
		sdk.healthElement.encrypted.modifyHealthElements(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(EncryptedHealthElement.serializer()))

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
			sdk.healthElement.encrypted.modifyHealthElements(
				decodedParams.entities,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedHealthElement.serializer()), resultCallback)
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
		sdk.healthElement.encrypted.getHealthElement(
			decodedParams.entityId,
		)
	}
}.toPyString(EncryptedHealthElement.serializer())

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
			sdk.healthElement.encrypted.getHealthElement(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(EncryptedHealthElement.serializer(), resultCallback)
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
		sdk.healthElement.encrypted.getHealthElements(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(EncryptedHealthElement.serializer()))

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
			sdk.healthElement.encrypted.getHealthElements(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedHealthElement.serializer()), resultCallback)
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
		sdk.healthElement.encrypted.filterHealthElementsBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, EncryptedHealthElement.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun filterHealthcareElementsByAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterHealthcareElementsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthElement.encrypted.filterHealthElementsBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, EncryptedHealthElement.serializer())}
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
		sdk.healthElement.encrypted.findHealthElementsByHcPartyPatientForeignKeys(
			decodedParams.hcPartyId,
			decodedParams.secretPatientKeys,
		)
	}
}.toPyString(ListSerializer(EncryptedHealthElement.serializer()))

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
			sdk.healthElement.encrypted.findHealthElementsByHcPartyPatientForeignKeys(
				decodedParams.hcPartyId,
				decodedParams.secretPatientKeys,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedHealthElement.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
