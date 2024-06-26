// auto-generated file
package com.icure.sdk.py.api.flavoured.FormApi.tryAndRecover

import com.icure.sdk.IcureApis
import com.icure.sdk.crypto.entities.FormShareOptions
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.model.Form
import com.icure.sdk.model.Patient
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.py.serialization.FormSerializer
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
	public val form: Form,
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
		sdk.form.tryAndRecover.shareWith(
			decodedParams.delegateId,
			decodedParams.form,
			decodedParams.shareEncryptionKeys,
			decodedParams.shareOwningEntityIds,
			decodedParams.requestedPermission,
		)
	}
}.toPyString(SimpleShareResult.serializer(FormSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun shareWithAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.tryAndRecover.shareWith(
				decodedParams.delegateId,
				decodedParams.form,
				decodedParams.shareEncryptionKeys,
				decodedParams.shareOwningEntityIds,
				decodedParams.requestedPermission,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(FormSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryShareWithManyParams(
	public val form: Form,
	public val delegates: Map<String, FormShareOptions>,
)

public fun tryShareWithManyBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryShareWithManyParams>(params)
	runBlocking {
		sdk.form.tryAndRecover.tryShareWithMany(
			decodedParams.form,
			decodedParams.delegates,
		)
	}
}.toPyString(SimpleShareResult.serializer(FormSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun tryShareWithManyAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryShareWithManyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.tryAndRecover.tryShareWithMany(
				decodedParams.form,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(FormSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val form: Form,
	public val delegates: Map<String, FormShareOptions>,
)

public fun shareWithManyBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.form.tryAndRecover.shareWithMany(
			decodedParams.form,
			decodedParams.delegates,
		)
	}
}.toPyString(FormSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun shareWithManyAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithManyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.tryAndRecover.shareWithMany(
				decodedParams.form,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(FormSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindFormsByHcPartyPatientParams(
	public val hcPartyId: String,
	@Serializable(PatientSerializer::class)
	public val patient: Patient,
	public val startDate: Long? = null,
	public val endDate: Long? = null,
	public val descending: Boolean? = null,
)

public fun findFormsByHcPartyPatientBlocking(sdk: IcureApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindFormsByHcPartyPatientParams>(params)
	runBlocking {
		sdk.form.tryAndRecover.findFormsByHcPartyPatient(
			decodedParams.hcPartyId,
			decodedParams.patient,
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.descending,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, FormSerializer)}

@OptIn(ExperimentalForeignApi::class)
public fun findFormsByHcPartyPatientAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<COpaquePointer?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindFormsByHcPartyPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.tryAndRecover.findFormsByHcPartyPatient(
				decodedParams.hcPartyId,
				decodedParams.patient,
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.descending,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, FormSerializer)}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class ModifyFormParams(
	public val entity: Form,
)

public fun modifyFormBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyFormParams>(params)
	runBlocking {
		sdk.form.tryAndRecover.modifyForm(
			decodedParams.entity,
		)
	}
}.toPyString(FormSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun modifyFormAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyFormParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.tryAndRecover.modifyForm(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(FormSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyFormsParams(
	public val entities: List<Form>,
)

public fun modifyFormsBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyFormsParams>(params)
	runBlocking {
		sdk.form.tryAndRecover.modifyForms(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(FormSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun modifyFormsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyFormsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.tryAndRecover.modifyForms(
				decodedParams.entities,
			)
		}.toPyStringAsyncCallback(ListSerializer(FormSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetFormParams(
	public val entityId: String,
)

public fun getFormBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFormParams>(params)
	runBlocking {
		sdk.form.tryAndRecover.getForm(
			decodedParams.entityId,
		)
	}
}.toPyString(FormSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun getFormAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFormParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.tryAndRecover.getForm(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(FormSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetFormsParams(
	public val entityIds: List<String>,
)

public fun getFormsBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFormsParams>(params)
	runBlocking {
		sdk.form.tryAndRecover.getForms(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(FormSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun getFormsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFormsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.tryAndRecover.getForms(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(FormSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetFormByLogicalUuidParams(
	public val logicalUuid: String,
)

public fun getFormByLogicalUuidBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFormByLogicalUuidParams>(params)
	runBlocking {
		sdk.form.tryAndRecover.getFormByLogicalUuid(
			decodedParams.logicalUuid,
		)
	}
}.toPyString(FormSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun getFormByLogicalUuidAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFormByLogicalUuidParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.tryAndRecover.getFormByLogicalUuid(
				decodedParams.logicalUuid,
			)
		}.toPyStringAsyncCallback(FormSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetFormsByLogicalUuidParams(
	public val logicalUuid: String,
)

public fun getFormsByLogicalUuidBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFormsByLogicalUuidParams>(params)
	runBlocking {
		sdk.form.tryAndRecover.getFormsByLogicalUuid(
			decodedParams.logicalUuid,
		)
	}
}.toPyString(ListSerializer(FormSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun getFormsByLogicalUuidAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFormsByLogicalUuidParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.tryAndRecover.getFormsByLogicalUuid(
				decodedParams.logicalUuid,
			)
		}.toPyStringAsyncCallback(ListSerializer(FormSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetFormsByUniqueIdParams(
	public val uniqueId: String,
)

public fun getFormsByUniqueIdBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFormsByUniqueIdParams>(params)
	runBlocking {
		sdk.form.tryAndRecover.getFormsByUniqueId(
			decodedParams.uniqueId,
		)
	}
}.toPyString(ListSerializer(FormSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun getFormsByUniqueIdAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFormsByUniqueIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.tryAndRecover.getFormsByUniqueId(
				decodedParams.uniqueId,
			)
		}.toPyStringAsyncCallback(ListSerializer(FormSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetFormByUniqueIdParams(
	public val uniqueId: String,
)

public fun getFormByUniqueIdBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFormByUniqueIdParams>(params)
	runBlocking {
		sdk.form.tryAndRecover.getFormByUniqueId(
			decodedParams.uniqueId,
		)
	}
}.toPyString(FormSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun getFormByUniqueIdAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFormByUniqueIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.tryAndRecover.getFormByUniqueId(
				decodedParams.uniqueId,
			)
		}.toPyStringAsyncCallback(FormSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetChildrenFormsParams(
	public val hcPartyId: String,
	public val parentId: String,
)

public fun getChildrenFormsBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetChildrenFormsParams>(params)
	runBlocking {
		sdk.form.tryAndRecover.getChildrenForms(
			decodedParams.hcPartyId,
			decodedParams.parentId,
		)
	}
}.toPyString(ListSerializer(FormSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun getChildrenFormsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetChildrenFormsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.tryAndRecover.getChildrenForms(
				decodedParams.hcPartyId,
				decodedParams.parentId,
			)
		}.toPyStringAsyncCallback(ListSerializer(FormSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListFormsByHCPartyAndPatientForeignKeysParams(
	public val hcPartyId: String,
	public val secretFKeys: String,
	public val healthElementId: String? = null,
	public val planOfActionId: String? = null,
	public val formTemplateId: String? = null,
)

public fun listFormsByHCPartyAndPatientForeignKeysBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListFormsByHCPartyAndPatientForeignKeysParams>(params)
	runBlocking {
		sdk.form.tryAndRecover.listFormsByHCPartyAndPatientForeignKeys(
			decodedParams.hcPartyId,
			decodedParams.secretFKeys,
			decodedParams.healthElementId,
			decodedParams.planOfActionId,
			decodedParams.formTemplateId,
		)
	}
}.toPyString(ListSerializer(FormSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun listFormsByHCPartyAndPatientForeignKeysAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListFormsByHCPartyAndPatientForeignKeysParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.tryAndRecover.listFormsByHCPartyAndPatientForeignKeys(
				decodedParams.hcPartyId,
				decodedParams.secretFKeys,
				decodedParams.healthElementId,
				decodedParams.planOfActionId,
				decodedParams.formTemplateId,
			)
		}.toPyStringAsyncCallback(ListSerializer(FormSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
