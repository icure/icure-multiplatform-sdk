// auto-generated file
package com.icure.cardinal.sdk.py.api.FormBasicApi

import com.icure.cardinal.sdk.CardinalBaseApis
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.EncryptedForm
import com.icure.cardinal.sdk.model.Form
import com.icure.cardinal.sdk.model.FormTemplate
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.py.utils.PaginatedListIterator.PaginatedListIteratorAndSerializer
import com.icure.cardinal.sdk.py.utils.PyResult
import com.icure.cardinal.sdk.py.utils.failureToPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyResult
import com.icure.cardinal.sdk.py.utils.toPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.serialization.ByteArraySerializer
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Byte
import kotlin.ByteArray
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
private class MatchFormsByParams(
	public val filter: BaseFilterOptions<Form>,
)

@OptIn(InternalIcureApi::class)
public fun matchFormsByBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchFormsByParams>(params)
	runBlocking {
		sdk.form.matchFormsBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchFormsByAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchFormsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.matchFormsBy(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchFormsBySortedParams(
	public val filter: BaseSortableFilterOptions<Form>,
)

@OptIn(InternalIcureApi::class)
public fun matchFormsBySortedBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchFormsBySortedParams>(params)
	runBlocking {
		sdk.form.matchFormsBySorted(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchFormsBySortedAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchFormsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.matchFormsBySorted(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterFormsByParams(
	public val filter: BaseFilterOptions<Form>,
)

@OptIn(InternalIcureApi::class)
public fun filterFormsByBlocking(sdk: CardinalBaseApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterFormsByParams>(params)
	runBlocking {
		sdk.form.filterFormsBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, EncryptedForm.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterFormsByAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterFormsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.filterFormsBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, EncryptedForm.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterFormsBySortedParams(
	public val filter: BaseSortableFilterOptions<Form>,
)

@OptIn(InternalIcureApi::class)
public fun filterFormsBySortedBlocking(sdk: CardinalBaseApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterFormsBySortedParams>(params)
	runBlocking {
		sdk.form.filterFormsBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, EncryptedForm.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterFormsBySortedAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterFormsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.filterFormsBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, EncryptedForm.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class DeleteFormParams(
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun deleteFormBlocking(sdk: CardinalBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteFormParams>(params)
	runBlocking {
		sdk.form.deleteForm(
			decodedParams.entityId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteFormAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteFormParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun deleteFormsBlocking(sdk: CardinalBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteFormsParams>(params)
	runBlocking {
		sdk.form.deleteForms(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteFormsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteFormsParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun getFormTemplateBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetFormTemplateParams>(params)
	runBlocking {
		sdk.form.getFormTemplate(
			decodedParams.formTemplateId,
			decodedParams.raw,
		)
	}
}.toPyString(FormTemplate.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getFormTemplateAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetFormTemplateParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun getFormTemplatesByGuidBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetFormTemplatesByGuidParams>(params)
	runBlocking {
		sdk.form.getFormTemplatesByGuid(
			decodedParams.formTemplateGuid,
			decodedParams.specialityCode,
			decodedParams.raw,
		)
	}
}.toPyString(ListSerializer(FormTemplate.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getFormTemplatesByGuidAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetFormTemplatesByGuidParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun listFormTemplatesBySpecialityBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListFormTemplatesBySpecialityParams>(params)
	runBlocking {
		sdk.form.listFormTemplatesBySpeciality(
			decodedParams.specialityCode,
			decodedParams.raw,
		)
	}
}.toPyString(ListSerializer(FormTemplate.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listFormTemplatesBySpecialityAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListFormTemplatesBySpecialityParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun getFormTemplatesBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetFormTemplatesParams>(params)
	runBlocking {
		sdk.form.getFormTemplates(
			decodedParams.loadLayout,
			decodedParams.raw,
		)
	}
}.toPyString(ListSerializer(FormTemplate.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getFormTemplatesAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetFormTemplatesParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun createFormTemplateBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateFormTemplateParams>(params)
	runBlocking {
		sdk.form.createFormTemplate(
			decodedParams.formTemplate,
		)
	}
}.toPyString(FormTemplate.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createFormTemplateAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateFormTemplateParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun deleteFormTemplateBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteFormTemplateParams>(params)
	runBlocking {
		sdk.form.deleteFormTemplate(
			decodedParams.formTemplateId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteFormTemplateAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteFormTemplateParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun updateFormTemplateBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UpdateFormTemplateParams>(params)
	runBlocking {
		sdk.form.updateFormTemplate(
			decodedParams.formTemplate,
		)
	}
}.toPyString(FormTemplate.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun updateFormTemplateAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UpdateFormTemplateParams>(params)
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
	@Serializable(ByteArraySerializer::class)
	public val payload: ByteArray,
)

@OptIn(InternalIcureApi::class)
public fun setTemplateAttachmentBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SetTemplateAttachmentParams>(params)
	runBlocking {
		sdk.form.setTemplateAttachment(
			decodedParams.formTemplateId,
			decodedParams.payload,
		)
	}
}.toPyString(String.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun setTemplateAttachmentAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SetTemplateAttachmentParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun modifyFormBlocking(sdk: CardinalBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyFormParams>(params)
	runBlocking {
		sdk.form.modifyForm(
			decodedParams.entity,
		)
	}
}.toPyString(EncryptedForm.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyFormAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyFormParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun modifyFormsBlocking(sdk: CardinalBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyFormsParams>(params)
	runBlocking {
		sdk.form.modifyForms(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(EncryptedForm.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyFormsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyFormsParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun getFormBlocking(sdk: CardinalBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetFormParams>(params)
	runBlocking {
		sdk.form.getForm(
			decodedParams.entityId,
		)
	}
}.toPyString(EncryptedForm.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getFormAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetFormParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun getFormsBlocking(sdk: CardinalBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetFormsParams>(params)
	runBlocking {
		sdk.form.getForms(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(EncryptedForm.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getFormsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetFormsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.getForms(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedForm.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetLatestFormByLogicalUuidParams(
	public val logicalUuid: String,
)

@OptIn(InternalIcureApi::class)
public fun getLatestFormByLogicalUuidBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetLatestFormByLogicalUuidParams>(params)
	runBlocking {
		sdk.form.getLatestFormByLogicalUuid(
			decodedParams.logicalUuid,
		)
	}
}.toPyString(EncryptedForm.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getLatestFormByLogicalUuidAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetLatestFormByLogicalUuidParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.getLatestFormByLogicalUuid(
				decodedParams.logicalUuid,
			)
		}.toPyStringAsyncCallback(EncryptedForm.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetLatestFormByUniqueIdParams(
	public val uniqueId: String,
)

@OptIn(InternalIcureApi::class)
public fun getLatestFormByUniqueIdBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetLatestFormByUniqueIdParams>(params)
	runBlocking {
		sdk.form.getLatestFormByUniqueId(
			decodedParams.uniqueId,
		)
	}
}.toPyString(EncryptedForm.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getLatestFormByUniqueIdAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetLatestFormByUniqueIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.getLatestFormByUniqueId(
				decodedParams.uniqueId,
			)
		}.toPyStringAsyncCallback(EncryptedForm.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetFormsByLogicalUuidParams(
	public val logicalUuid: String,
)

@OptIn(InternalIcureApi::class)
public fun getFormsByLogicalUuidBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetFormsByLogicalUuidParams>(params)
	runBlocking {
		sdk.form.getFormsByLogicalUuid(
			decodedParams.logicalUuid,
		)
	}
}.toPyString(ListSerializer(EncryptedForm.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getFormsByLogicalUuidAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetFormsByLogicalUuidParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun getFormsByUniqueIdBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetFormsByUniqueIdParams>(params)
	runBlocking {
		sdk.form.getFormsByUniqueId(
			decodedParams.uniqueId,
		)
	}
}.toPyString(ListSerializer(EncryptedForm.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getFormsByUniqueIdAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetFormsByUniqueIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.getFormsByUniqueId(
				decodedParams.uniqueId,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedForm.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetChildrenFormsParams(
	public val hcPartyId: String,
	public val parentId: String,
)

@OptIn(InternalIcureApi::class)
public fun getChildrenFormsBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetChildrenFormsParams>(params)
	runBlocking {
		sdk.form.getChildrenForms(
			decodedParams.hcPartyId,
			decodedParams.parentId,
		)
	}
}.toPyString(ListSerializer(EncryptedForm.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getChildrenFormsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetChildrenFormsParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun listFormsByHCPartyAndPatientForeignKeysBlocking(sdk: CardinalBaseApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListFormsByHCPartyAndPatientForeignKeysParams>(params)
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

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listFormsByHCPartyAndPatientForeignKeysAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListFormsByHCPartyAndPatientForeignKeysParams>(params)
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
