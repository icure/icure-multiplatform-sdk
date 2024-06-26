// auto-generated file
package com.icure.sdk.py.api.flavoured.FormBasicApi

import com.icure.sdk.IcureBaseApis
import com.icure.sdk.model.EncryptedForm
import com.icure.sdk.model.FormTemplate
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.py.utils.toPyStringAsyncCallback
import com.icure.sdk.utils.Serialization.json
import kotlin.Boolean
import kotlin.Byte
import kotlin.ByteArray
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlinx.cinterop.ByteVarOf
import kotlinx.cinterop.CFunction
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
private class DeleteFormParams(
	public val entityId: String,
)

public fun deleteFormBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteFormParams>(params)
	runBlocking {
		sdk.form.deleteForm(
			decodedParams.entityId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun deleteFormAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteFormParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.deleteForm(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteFormsParams(
	public val entityIds: List<String>,
)

public fun deleteFormsBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteFormsParams>(params)
	runBlocking {
		sdk.form.deleteForms(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun deleteFormsAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteFormsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.deleteForms(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetFormTemplateParams(
	public val formTemplateId: String,
	public val raw: Boolean? = null,
)

public fun getFormTemplateBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFormTemplateParams>(params)
	runBlocking {
		sdk.form.getFormTemplate(
			decodedParams.formTemplateId,
			decodedParams.raw,
		)
	}
}.toPyString(FormTemplate.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getFormTemplateAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFormTemplateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.getFormTemplate(
				decodedParams.formTemplateId,
				decodedParams.raw,
			)
		}.toPyStringAsyncCallback(FormTemplate.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetFormTemplatesByGuidParams(
	public val formTemplateGuid: String,
	public val specialityCode: String,
	public val raw: Boolean?,
)

public fun getFormTemplatesByGuidBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFormTemplatesByGuidParams>(params)
	runBlocking {
		sdk.form.getFormTemplatesByGuid(
			decodedParams.formTemplateGuid,
			decodedParams.specialityCode,
			decodedParams.raw,
		)
	}
}.toPyString(ListSerializer(FormTemplate.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getFormTemplatesByGuidAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFormTemplatesByGuidParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.getFormTemplatesByGuid(
				decodedParams.formTemplateGuid,
				decodedParams.specialityCode,
				decodedParams.raw,
			)
		}.toPyStringAsyncCallback(ListSerializer(FormTemplate.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListFormTemplatesBySpecialityParams(
	public val specialityCode: String,
	public val raw: Boolean? = null,
)

public fun listFormTemplatesBySpecialityBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListFormTemplatesBySpecialityParams>(params)
	runBlocking {
		sdk.form.listFormTemplatesBySpeciality(
			decodedParams.specialityCode,
			decodedParams.raw,
		)
	}
}.toPyString(ListSerializer(FormTemplate.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listFormTemplatesBySpecialityAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListFormTemplatesBySpecialityParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.listFormTemplatesBySpeciality(
				decodedParams.specialityCode,
				decodedParams.raw,
			)
		}.toPyStringAsyncCallback(ListSerializer(FormTemplate.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetFormTemplatesParams(
	public val loadLayout: Boolean? = null,
	public val raw: Boolean? = null,
)

public fun getFormTemplatesBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFormTemplatesParams>(params)
	runBlocking {
		sdk.form.getFormTemplates(
			decodedParams.loadLayout,
			decodedParams.raw,
		)
	}
}.toPyString(ListSerializer(FormTemplate.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getFormTemplatesAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFormTemplatesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.getFormTemplates(
				decodedParams.loadLayout,
				decodedParams.raw,
			)
		}.toPyStringAsyncCallback(ListSerializer(FormTemplate.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateFormTemplateParams(
	public val formTemplate: FormTemplate,
)

public fun createFormTemplateBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateFormTemplateParams>(params)
	runBlocking {
		sdk.form.createFormTemplate(
			decodedParams.formTemplate,
		)
	}
}.toPyString(FormTemplate.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun createFormTemplateAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateFormTemplateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.createFormTemplate(
				decodedParams.formTemplate,
			)
		}.toPyStringAsyncCallback(FormTemplate.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteFormTemplateParams(
	public val formTemplateId: String,
)

public fun deleteFormTemplateBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteFormTemplateParams>(params)
	runBlocking {
		sdk.form.deleteFormTemplate(
			decodedParams.formTemplateId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun deleteFormTemplateAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteFormTemplateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.deleteFormTemplate(
				decodedParams.formTemplateId,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UpdateFormTemplateParams(
	public val formTemplate: FormTemplate,
)

public fun updateFormTemplateBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<UpdateFormTemplateParams>(params)
	runBlocking {
		sdk.form.updateFormTemplate(
			decodedParams.formTemplate,
		)
	}
}.toPyString(FormTemplate.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun updateFormTemplateAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<UpdateFormTemplateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.updateFormTemplate(
				decodedParams.formTemplate,
			)
		}.toPyStringAsyncCallback(FormTemplate.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SetTemplateAttachmentParams(
	public val formTemplateId: String,
	public val payload: ByteArray,
)

public fun setTemplateAttachmentBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<SetTemplateAttachmentParams>(params)
	runBlocking {
		sdk.form.setTemplateAttachment(
			decodedParams.formTemplateId,
			decodedParams.payload,
		)
	}
}.toPyString(String.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun setTemplateAttachmentAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<SetTemplateAttachmentParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.setTemplateAttachment(
				decodedParams.formTemplateId,
				decodedParams.payload,
			)
		}.toPyStringAsyncCallback(String.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyFormParams(
	public val entity: EncryptedForm,
)

public fun modifyFormBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyFormParams>(params)
	runBlocking {
		sdk.form.modifyForm(
			decodedParams.entity,
		)
	}
}.toPyString(EncryptedForm.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyFormAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyFormParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.modifyForm(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(EncryptedForm.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyFormsParams(
	public val entities: List<EncryptedForm>,
)

public fun modifyFormsBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyFormsParams>(params)
	runBlocking {
		sdk.form.modifyForms(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(EncryptedForm.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun modifyFormsAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyFormsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.modifyForms(
				decodedParams.entities,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedForm.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetFormParams(
	public val entityId: String,
)

public fun getFormBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFormParams>(params)
	runBlocking {
		sdk.form.getForm(
			decodedParams.entityId,
		)
	}
}.toPyString(EncryptedForm.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getFormAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFormParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.getForm(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(EncryptedForm.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetFormsParams(
	public val entityIds: List<String>,
)

public fun getFormsBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFormsParams>(params)
	runBlocking {
		sdk.form.getForms(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(EncryptedForm.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getFormsAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFormsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.getForms(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedForm.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetFormByLogicalUuidParams(
	public val logicalUuid: String,
)

public fun getFormByLogicalUuidBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFormByLogicalUuidParams>(params)
	runBlocking {
		sdk.form.getFormByLogicalUuid(
			decodedParams.logicalUuid,
		)
	}
}.toPyString(EncryptedForm.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getFormByLogicalUuidAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFormByLogicalUuidParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.getFormByLogicalUuid(
				decodedParams.logicalUuid,
			)
		}.toPyStringAsyncCallback(EncryptedForm.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetFormsByLogicalUuidParams(
	public val logicalUuid: String,
)

public fun getFormsByLogicalUuidBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFormsByLogicalUuidParams>(params)
	runBlocking {
		sdk.form.getFormsByLogicalUuid(
			decodedParams.logicalUuid,
		)
	}
}.toPyString(ListSerializer(EncryptedForm.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getFormsByLogicalUuidAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFormsByLogicalUuidParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.getFormsByLogicalUuid(
				decodedParams.logicalUuid,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedForm.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetFormsByUniqueIdParams(
	public val uniqueId: String,
)

public fun getFormsByUniqueIdBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFormsByUniqueIdParams>(params)
	runBlocking {
		sdk.form.getFormsByUniqueId(
			decodedParams.uniqueId,
		)
	}
}.toPyString(ListSerializer(EncryptedForm.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getFormsByUniqueIdAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFormsByUniqueIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.getFormsByUniqueId(
				decodedParams.uniqueId,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedForm.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetFormByUniqueIdParams(
	public val uniqueId: String,
)

public fun getFormByUniqueIdBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFormByUniqueIdParams>(params)
	runBlocking {
		sdk.form.getFormByUniqueId(
			decodedParams.uniqueId,
		)
	}
}.toPyString(EncryptedForm.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getFormByUniqueIdAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFormByUniqueIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.getFormByUniqueId(
				decodedParams.uniqueId,
			)
		}.toPyStringAsyncCallback(EncryptedForm.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetChildrenFormsParams(
	public val hcPartyId: String,
	public val parentId: String,
)

public fun getChildrenFormsBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetChildrenFormsParams>(params)
	runBlocking {
		sdk.form.getChildrenForms(
			decodedParams.hcPartyId,
			decodedParams.parentId,
		)
	}
}.toPyString(ListSerializer(EncryptedForm.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getChildrenFormsAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetChildrenFormsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.getChildrenForms(
				decodedParams.hcPartyId,
				decodedParams.parentId,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedForm.serializer()), resultCallback)
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

public fun listFormsByHCPartyAndPatientForeignKeysBlocking(sdk: IcureBaseApis, params: String):
		String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListFormsByHCPartyAndPatientForeignKeysParams>(params)
	runBlocking {
		sdk.form.listFormsByHCPartyAndPatientForeignKeys(
			decodedParams.hcPartyId,
			decodedParams.secretFKeys,
			decodedParams.healthElementId,
			decodedParams.planOfActionId,
			decodedParams.formTemplateId,
		)
	}
}.toPyString(ListSerializer(EncryptedForm.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listFormsByHCPartyAndPatientForeignKeysAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListFormsByHCPartyAndPatientForeignKeysParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.listFormsByHCPartyAndPatientForeignKeys(
				decodedParams.hcPartyId,
				decodedParams.secretFKeys,
				decodedParams.healthElementId,
				decodedParams.planOfActionId,
				decodedParams.formTemplateId,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedForm.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
