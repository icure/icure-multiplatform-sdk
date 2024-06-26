// auto-generated file
package com.icure.sdk.py.api.flavoured.ClassificationApi.encrypted

import com.icure.sdk.IcureApis
import com.icure.sdk.crypto.entities.ClassificationShareOptions
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.model.EncryptedClassification
import com.icure.sdk.model.Patient
import com.icure.sdk.model.requests.RequestedPermission
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
	public val classification: EncryptedClassification,
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
		sdk.classification.encrypted.shareWith(
			decodedParams.delegateId,
			decodedParams.classification,
			decodedParams.shareEncryptionKeys,
			decodedParams.shareOwningEntityIds,
			decodedParams.requestedPermission,
		)
	}
}.toPyString(SimpleShareResult.serializer(EncryptedClassification.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun shareWithAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.classification.encrypted.shareWith(
				decodedParams.delegateId,
				decodedParams.classification,
				decodedParams.shareEncryptionKeys,
				decodedParams.shareOwningEntityIds,
				decodedParams.requestedPermission,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(EncryptedClassification.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryShareWithManyParams(
	public val classification: EncryptedClassification,
	public val delegates: Map<String, ClassificationShareOptions>,
)

public fun tryShareWithManyBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryShareWithManyParams>(params)
	runBlocking {
		sdk.classification.encrypted.tryShareWithMany(
			decodedParams.classification,
			decodedParams.delegates,
		)
	}
}.toPyString(SimpleShareResult.serializer(EncryptedClassification.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun tryShareWithManyAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryShareWithManyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.classification.encrypted.tryShareWithMany(
				decodedParams.classification,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(EncryptedClassification.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val classification: EncryptedClassification,
	public val delegates: Map<String, ClassificationShareOptions>,
)

public fun shareWithManyBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.classification.encrypted.shareWithMany(
			decodedParams.classification,
			decodedParams.delegates,
		)
	}
}.toPyString(EncryptedClassification.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun shareWithManyAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithManyParams>(params)
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
	@Serializable(PatientSerializer::class)
	public val patient: Patient,
	public val startDate: Long? = null,
	public val endDate: Long? = null,
	public val descending: Boolean? = null,
)

public fun findClassificationsByHcPartyPatientBlocking(sdk: IcureApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindClassificationsByHcPartyPatientParams>(params)
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
	PaginatedListIteratorAndSerializer(it, EncryptedClassification.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun findClassificationsByHcPartyPatientAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<COpaquePointer?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindClassificationsByHcPartyPatientParams>(params)
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
			PaginatedListIteratorAndSerializer(it, EncryptedClassification.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class ModifyClassificationParams(
	public val entity: EncryptedClassification,
)

public fun modifyClassificationBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyClassificationParams>(params)
	runBlocking {
		sdk.classification.encrypted.modifyClassification(
			decodedParams.entity,
		)
	}
}.toPyString(EncryptedClassification.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyClassificationAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyClassificationParams>(params)
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

public fun getClassificationBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetClassificationParams>(params)
	runBlocking {
		sdk.classification.encrypted.getClassification(
			decodedParams.entityId,
		)
	}
}.toPyString(EncryptedClassification.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getClassificationAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetClassificationParams>(params)
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

public fun getClassificationsBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetClassificationsParams>(params)
	runBlocking {
		sdk.classification.encrypted.getClassifications(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(EncryptedClassification.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getClassificationsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetClassificationsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.classification.encrypted.getClassifications(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedClassification.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
