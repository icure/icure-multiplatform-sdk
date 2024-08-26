// auto-generated file
package com.icure.sdk.py.api.FormApi

import com.icure.sdk.IcureApis
import com.icure.sdk.crypto.entities.FormShareOptions
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.filters.FilterOptions
import com.icure.sdk.filters.SortableFilterOptions
import com.icure.sdk.model.DecryptedForm
import com.icure.sdk.model.EncryptedForm
import com.icure.sdk.model.Form
import com.icure.sdk.model.FormTemplate
import com.icure.sdk.model.Patient
import com.icure.sdk.model.User
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.specializations.HexString
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
import com.icure.sdk.serialization.ByteArraySerializer
import com.icure.sdk.utils.Serialization.json
import kotlin.Boolean
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Map
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
import kotlinx.serialization.builtins.SetSerializer
import kotlinx.serialization.builtins.serializer

@Serializable
private class CreateFormParams(
	public val entity: DecryptedForm,
)

public fun createFormBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateFormParams>(params)
	runBlocking {
		sdk.form.createForm(
			decodedParams.entity,
		)
	}
}.toPyString(DecryptedForm.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun createFormAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateFormParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.createForm(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(DecryptedForm.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateFormsParams(
	public val entities: List<DecryptedForm>,
)

public fun createFormsBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateFormsParams>(params)
	runBlocking {
		sdk.form.createForms(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(DecryptedForm.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun createFormsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateFormsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.createForms(
				decodedParams.entities,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedForm.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class WithEncryptionMetadataParams(
	public val base: DecryptedForm?,
	@Serializable(PatientSerializer::class)
	public val patient: Patient,
	public val user: User? = null,
	public val delegates: Map<String, AccessLevel> = emptyMap(),
	public val secretId: SecretIdOption =
			com.icure.sdk.crypto.entities.SecretIdOption.UseAnySharedWithParent,
)

public fun withEncryptionMetadataBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<WithEncryptionMetadataParams>(params)
	runBlocking {
		sdk.form.withEncryptionMetadata(
			decodedParams.base,
			decodedParams.patient,
			decodedParams.user,
			decodedParams.delegates,
			decodedParams.secretId,
		)
	}
}.toPyString(DecryptedForm.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun withEncryptionMetadataAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<WithEncryptionMetadataParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.withEncryptionMetadata(
				decodedParams.base,
				decodedParams.patient,
				decodedParams.user,
				decodedParams.delegates,
				decodedParams.secretId,
			)
		}.toPyStringAsyncCallback(DecryptedForm.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetEncryptionKeysOfParams(
	@Serializable(FormSerializer::class)
	public val form: Form,
)

public fun getEncryptionKeysOfBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetEncryptionKeysOfParams>(params)
	runBlocking {
		sdk.form.getEncryptionKeysOf(
			decodedParams.form,
		)
	}
}.toPyString(SetSerializer(HexString.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getEncryptionKeysOfAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetEncryptionKeysOfParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.getEncryptionKeysOf(
				decodedParams.form,
			)
		}.toPyStringAsyncCallback(SetSerializer(HexString.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class HasWriteAccessParams(
	@Serializable(FormSerializer::class)
	public val form: Form,
)

public fun hasWriteAccessBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<HasWriteAccessParams>(params)
	runBlocking {
		sdk.form.hasWriteAccess(
			decodedParams.form,
		)
	}
}.toPyString(Boolean.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun hasWriteAccessAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<HasWriteAccessParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.hasWriteAccess(
				decodedParams.form,
			)
		}.toPyStringAsyncCallback(Boolean.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DecryptPatientIdOfParams(
	@Serializable(FormSerializer::class)
	public val form: Form,
)

public fun decryptPatientIdOfBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DecryptPatientIdOfParams>(params)
	runBlocking {
		sdk.form.decryptPatientIdOf(
			decodedParams.form,
		)
	}
}.toPyString(SetSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun decryptPatientIdOfAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DecryptPatientIdOfParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.decryptPatientIdOf(
				decodedParams.form,
			)
		}.toPyStringAsyncCallback(SetSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateDelegationDeAnonymizationMetadataParams(
	@Serializable(FormSerializer::class)
	public val entity: Form,
	public val delegates: Set<String>,
)

public fun createDelegationDeAnonymizationMetadataBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateDelegationDeAnonymizationMetadataParams>(params)
	runBlocking {
		sdk.form.createDelegationDeAnonymizationMetadata(
			decodedParams.entity,
			decodedParams.delegates,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun createDelegationDeAnonymizationMetadataAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateDelegationDeAnonymizationMetadataParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.createDelegationDeAnonymizationMetadata(
				decodedParams.entity,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DecryptParams(
	public val form: EncryptedForm,
)

public fun decryptBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DecryptParams>(params)
	runBlocking {
		sdk.form.decrypt(
			decodedParams.form,
		)
	}
}.toPyString(DecryptedForm.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun decryptAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DecryptParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.decrypt(
				decodedParams.form,
			)
		}.toPyStringAsyncCallback(DecryptedForm.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryDecryptParams(
	public val form: EncryptedForm,
)

public fun tryDecryptBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryDecryptParams>(params)
	runBlocking {
		sdk.form.tryDecrypt(
			decodedParams.form,
		)
	}
}.toPyString(FormSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun tryDecryptAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryDecryptParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.tryDecrypt(
				decodedParams.form,
			)
		}.toPyStringAsyncCallback(FormSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchFormsByParams(
	public val filter: FilterOptions<Form>,
)

public fun matchFormsByBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchFormsByParams>(params)
	runBlocking {
		sdk.form.matchFormsBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun matchFormsByAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchFormsByParams>(params)
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
	public val filter: SortableFilterOptions<Form>,
)

public fun matchFormsBySortedBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchFormsBySortedParams>(params)
	runBlocking {
		sdk.form.matchFormsBySorted(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun matchFormsBySortedAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchFormsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.matchFormsBySorted(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteFormParams(
	public val entityId: String,
)

public fun deleteFormBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteFormParams>(params)
	runBlocking {
		sdk.form.deleteForm(
			decodedParams.entityId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun deleteFormAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
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

public fun deleteFormsBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteFormsParams>(params)
	runBlocking {
		sdk.form.deleteForms(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun deleteFormsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
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

public fun getFormTemplateBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
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
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
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

public fun getFormTemplatesByGuidBlocking(sdk: IcureApis, params: String): String =
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
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
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

public fun listFormTemplatesBySpecialityBlocking(sdk: IcureApis, params: String): String =
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
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
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

public fun getFormTemplatesBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
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
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
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

public fun createFormTemplateBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateFormTemplateParams>(params)
	runBlocking {
		sdk.form.createFormTemplate(
			decodedParams.formTemplate,
		)
	}
}.toPyString(FormTemplate.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun createFormTemplateAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
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

public fun deleteFormTemplateBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteFormTemplateParams>(params)
	runBlocking {
		sdk.form.deleteFormTemplate(
			decodedParams.formTemplateId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun deleteFormTemplateAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
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

public fun updateFormTemplateBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<UpdateFormTemplateParams>(params)
	runBlocking {
		sdk.form.updateFormTemplate(
			decodedParams.formTemplate,
		)
	}
}.toPyString(FormTemplate.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun updateFormTemplateAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
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
	@Serializable(ByteArraySerializer::class)
	public val payload: ByteArray,
)

public fun setTemplateAttachmentBlocking(sdk: IcureApis, params: String): String =
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
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
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
private class ShareWithParams(
	public val delegateId: String,
	public val form: DecryptedForm,
	public val options: FormShareOptions? = null,
)

public fun shareWithBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.form.shareWith(
			decodedParams.delegateId,
			decodedParams.form,
			decodedParams.options,
		)
	}
}.toPyString(SimpleShareResult.serializer(DecryptedForm.serializer()))

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
			sdk.form.shareWith(
				decodedParams.delegateId,
				decodedParams.form,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(DecryptedForm.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryShareWithManyParams(
	public val form: DecryptedForm,
	public val delegates: Map<String, FormShareOptions>,
)

public fun tryShareWithManyBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryShareWithManyParams>(params)
	runBlocking {
		sdk.form.tryShareWithMany(
			decodedParams.form,
			decodedParams.delegates,
		)
	}
}.toPyString(SimpleShareResult.serializer(DecryptedForm.serializer()))

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
			sdk.form.tryShareWithMany(
				decodedParams.form,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(DecryptedForm.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val form: DecryptedForm,
	public val delegates: Map<String, FormShareOptions>,
)

public fun shareWithManyBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.form.shareWithMany(
			decodedParams.form,
			decodedParams.delegates,
		)
	}
}.toPyString(DecryptedForm.serializer())

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
			sdk.form.shareWithMany(
				decodedParams.form,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(DecryptedForm.serializer(), resultCallback)
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
		sdk.form.findFormsByHcPartyPatient(
			decodedParams.hcPartyId,
			decodedParams.patient,
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.descending,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, DecryptedForm.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun findFormsByHcPartyPatientAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindFormsByHcPartyPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.findFormsByHcPartyPatient(
				decodedParams.hcPartyId,
				decodedParams.patient,
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.descending,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, DecryptedForm.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterFormsByParams(
	public val filter: FilterOptions<Form>,
)

public fun filterFormsByBlocking(sdk: IcureApis, params: String): PyResult = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterFormsByParams>(params)
	runBlocking {
		sdk.form.filterFormsBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, DecryptedForm.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun filterFormsByAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterFormsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.filterFormsBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, DecryptedForm.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterFormsBySortedParams(
	public val filter: SortableFilterOptions<Form>,
)

public fun filterFormsBySortedBlocking(sdk: IcureApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterFormsBySortedParams>(params)
	runBlocking {
		sdk.form.filterFormsBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, DecryptedForm.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun filterFormsBySortedAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterFormsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.filterFormsBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, DecryptedForm.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class ModifyFormParams(
	public val entity: DecryptedForm,
)

public fun modifyFormBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyFormParams>(params)
	runBlocking {
		sdk.form.modifyForm(
			decodedParams.entity,
		)
	}
}.toPyString(DecryptedForm.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyFormAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyFormParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.modifyForm(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(DecryptedForm.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyFormsParams(
	public val entities: List<DecryptedForm>,
)

public fun modifyFormsBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyFormsParams>(params)
	runBlocking {
		sdk.form.modifyForms(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(DecryptedForm.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun modifyFormsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyFormsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.modifyForms(
				decodedParams.entities,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedForm.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetFormParams(
	public val entityId: String,
)

public fun getFormBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFormParams>(params)
	runBlocking {
		sdk.form.getForm(
			decodedParams.entityId,
		)
	}
}.toPyString(DecryptedForm.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getFormAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFormParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.getForm(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(DecryptedForm.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetFormsParams(
	public val entityIds: List<String>,
)

public fun getFormsBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFormsParams>(params)
	runBlocking {
		sdk.form.getForms(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DecryptedForm.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getFormsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFormsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.getForms(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedForm.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetLatestFormByLogicalUuidParams(
	public val logicalUuid: String,
)

public fun getLatestFormByLogicalUuidBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetLatestFormByLogicalUuidParams>(params)
	runBlocking {
		sdk.form.getLatestFormByLogicalUuid(
			decodedParams.logicalUuid,
		)
	}
}.toPyString(DecryptedForm.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getLatestFormByLogicalUuidAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetLatestFormByLogicalUuidParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.getLatestFormByLogicalUuid(
				decodedParams.logicalUuid,
			)
		}.toPyStringAsyncCallback(DecryptedForm.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetLatestFormByUniqueIdParams(
	public val uniqueId: String,
)

public fun getLatestFormByUniqueIdBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetLatestFormByUniqueIdParams>(params)
	runBlocking {
		sdk.form.getLatestFormByUniqueId(
			decodedParams.uniqueId,
		)
	}
}.toPyString(DecryptedForm.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getLatestFormByUniqueIdAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetLatestFormByUniqueIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.getLatestFormByUniqueId(
				decodedParams.uniqueId,
			)
		}.toPyStringAsyncCallback(DecryptedForm.serializer(), resultCallback)
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
		sdk.form.getFormsByLogicalUuid(
			decodedParams.logicalUuid,
		)
	}
}.toPyString(ListSerializer(DecryptedForm.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getFormsByLogicalUuidAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFormsByLogicalUuidParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.getFormsByLogicalUuid(
				decodedParams.logicalUuid,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedForm.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetFormsByUniqueIdParams(
	public val uniqueId: String,
)

public fun getFormsByUniqueIdBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFormsByUniqueIdParams>(params)
	runBlocking {
		sdk.form.getFormsByUniqueId(
			decodedParams.uniqueId,
		)
	}
}.toPyString(ListSerializer(DecryptedForm.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getFormsByUniqueIdAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFormsByUniqueIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.getFormsByUniqueId(
				decodedParams.uniqueId,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedForm.serializer()), resultCallback)
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
		sdk.form.getChildrenForms(
			decodedParams.hcPartyId,
			decodedParams.parentId,
		)
	}
}.toPyString(ListSerializer(DecryptedForm.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getChildrenFormsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetChildrenFormsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.getChildrenForms(
				decodedParams.hcPartyId,
				decodedParams.parentId,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedForm.serializer()), resultCallback)
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
		sdk.form.listFormsByHCPartyAndPatientForeignKeys(
			decodedParams.hcPartyId,
			decodedParams.secretFKeys,
			decodedParams.healthElementId,
			decodedParams.planOfActionId,
			decodedParams.formTemplateId,
		)
	}
}.toPyString(ListSerializer(DecryptedForm.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listFormsByHCPartyAndPatientForeignKeysAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
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
		}.toPyStringAsyncCallback(ListSerializer(DecryptedForm.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
