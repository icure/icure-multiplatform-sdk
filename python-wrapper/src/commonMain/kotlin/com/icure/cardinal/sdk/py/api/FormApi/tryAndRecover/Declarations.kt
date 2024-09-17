// auto-generated file
package com.icure.cardinal.sdk.py.api.FormApi.tryAndRecover

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.FormShareOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.Form
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.py.utils.PaginatedListIterator.PaginatedListIteratorAndSerializer
import com.icure.cardinal.sdk.py.utils.PyResult
import com.icure.cardinal.sdk.py.utils.failureToPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyResult
import com.icure.cardinal.sdk.py.utils.toPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
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
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer

@Serializable
private class ShareWithParams(
	public val delegateId: String,
	public val form: Form,
	public val options: FormShareOptions? = null,
)

@OptIn(InternalIcureApi::class)
public fun shareWithBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.form.tryAndRecover.shareWith(
			decodedParams.delegateId,
			decodedParams.form,
			decodedParams.options,
		)
	}
}.toPyString(PolymorphicSerializer(Form::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun shareWithAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.tryAndRecover.shareWith(
				decodedParams.delegateId,
				decodedParams.form,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Form::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val form: Form,
	public val delegates: Map<String, FormShareOptions>,
)

@OptIn(InternalIcureApi::class)
public fun shareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.form.tryAndRecover.shareWithMany(
			decodedParams.form,
			decodedParams.delegates,
		)
	}
}.toPyString(PolymorphicSerializer(Form::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun shareWithManyAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithManyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.tryAndRecover.shareWithMany(
				decodedParams.form,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Form::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindFormsByHcPartyPatientParams(
	public val hcPartyId: String,
	public val patient: Patient,
	public val startDate: Long? = null,
	public val endDate: Long? = null,
	public val descending: Boolean? = null,
)

@OptIn(InternalIcureApi::class)
public fun findFormsByHcPartyPatientBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindFormsByHcPartyPatientParams>(params)
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
	PaginatedListIteratorAndSerializer(it, PolymorphicSerializer(Form::class))}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findFormsByHcPartyPatientAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindFormsByHcPartyPatientParams>(params)
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
			PaginatedListIteratorAndSerializer(it, PolymorphicSerializer(Form::class))}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterFormsByParams(
	public val filter: FilterOptions<Form>,
)

@OptIn(InternalIcureApi::class)
public fun filterFormsByBlocking(sdk: CardinalApis, params: String): PyResult = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterFormsByParams>(params)
	runBlocking {
		sdk.form.tryAndRecover.filterFormsBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, PolymorphicSerializer(Form::class))}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterFormsByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterFormsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.tryAndRecover.filterFormsBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, PolymorphicSerializer(Form::class))}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterFormsBySortedParams(
	public val filter: SortableFilterOptions<Form>,
)

@OptIn(InternalIcureApi::class)
public fun filterFormsBySortedBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterFormsBySortedParams>(params)
	runBlocking {
		sdk.form.tryAndRecover.filterFormsBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, PolymorphicSerializer(Form::class))}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterFormsBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterFormsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.tryAndRecover.filterFormsBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, PolymorphicSerializer(Form::class))}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class ModifyFormParams(
	public val entity: Form,
)

@OptIn(InternalIcureApi::class)
public fun modifyFormBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyFormParams>(params)
	runBlocking {
		sdk.form.tryAndRecover.modifyForm(
			decodedParams.entity,
		)
	}
}.toPyString(PolymorphicSerializer(Form::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyFormAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyFormParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.tryAndRecover.modifyForm(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Form::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyFormsParams(
	public val entities: List<Form>,
)

@OptIn(InternalIcureApi::class)
public fun modifyFormsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyFormsParams>(params)
	runBlocking {
		sdk.form.tryAndRecover.modifyForms(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Form::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyFormsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyFormsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.tryAndRecover.modifyForms(
				decodedParams.entities,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Form::class)), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetFormParams(
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun getFormBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetFormParams>(params)
	runBlocking {
		sdk.form.tryAndRecover.getForm(
			decodedParams.entityId,
		)
	}
}.toPyString(PolymorphicSerializer(Form::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getFormAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetFormParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.tryAndRecover.getForm(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Form::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetFormsParams(
	public val entityIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getFormsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetFormsParams>(params)
	runBlocking {
		sdk.form.tryAndRecover.getForms(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Form::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getFormsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetFormsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.tryAndRecover.getForms(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Form::class)), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetLatestFormByLogicalUuidParams(
	public val logicalUuid: String,
)

@OptIn(InternalIcureApi::class)
public fun getLatestFormByLogicalUuidBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetLatestFormByLogicalUuidParams>(params)
	runBlocking {
		sdk.form.tryAndRecover.getLatestFormByLogicalUuid(
			decodedParams.logicalUuid,
		)
	}
}.toPyString(PolymorphicSerializer(Form::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getLatestFormByLogicalUuidAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetLatestFormByLogicalUuidParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.tryAndRecover.getLatestFormByLogicalUuid(
				decodedParams.logicalUuid,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Form::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetLatestFormByUniqueIdParams(
	public val uniqueId: String,
)

@OptIn(InternalIcureApi::class)
public fun getLatestFormByUniqueIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetLatestFormByUniqueIdParams>(params)
	runBlocking {
		sdk.form.tryAndRecover.getLatestFormByUniqueId(
			decodedParams.uniqueId,
		)
	}
}.toPyString(PolymorphicSerializer(Form::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getLatestFormByUniqueIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetLatestFormByUniqueIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.tryAndRecover.getLatestFormByUniqueId(
				decodedParams.uniqueId,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Form::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetFormsByLogicalUuidParams(
	public val logicalUuid: String,
)

@OptIn(InternalIcureApi::class)
public fun getFormsByLogicalUuidBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetFormsByLogicalUuidParams>(params)
	runBlocking {
		sdk.form.tryAndRecover.getFormsByLogicalUuid(
			decodedParams.logicalUuid,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Form::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getFormsByLogicalUuidAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetFormsByLogicalUuidParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.tryAndRecover.getFormsByLogicalUuid(
				decodedParams.logicalUuid,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Form::class)), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetFormsByUniqueIdParams(
	public val uniqueId: String,
)

@OptIn(InternalIcureApi::class)
public fun getFormsByUniqueIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetFormsByUniqueIdParams>(params)
	runBlocking {
		sdk.form.tryAndRecover.getFormsByUniqueId(
			decodedParams.uniqueId,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Form::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getFormsByUniqueIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetFormsByUniqueIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.tryAndRecover.getFormsByUniqueId(
				decodedParams.uniqueId,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Form::class)), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetChildrenFormsParams(
	public val hcPartyId: String,
	public val parentId: String,
)

@OptIn(InternalIcureApi::class)
public fun getChildrenFormsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetChildrenFormsParams>(params)
	runBlocking {
		sdk.form.tryAndRecover.getChildrenForms(
			decodedParams.hcPartyId,
			decodedParams.parentId,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Form::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getChildrenFormsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetChildrenFormsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.tryAndRecover.getChildrenForms(
				decodedParams.hcPartyId,
				decodedParams.parentId,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Form::class)), resultCallback)
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
public fun listFormsByHCPartyAndPatientForeignKeysBlocking(sdk: CardinalApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListFormsByHCPartyAndPatientForeignKeysParams>(params)
	runBlocking {
		sdk.form.tryAndRecover.listFormsByHCPartyAndPatientForeignKeys(
			decodedParams.hcPartyId,
			decodedParams.secretFKeys,
			decodedParams.healthElementId,
			decodedParams.planOfActionId,
			decodedParams.formTemplateId,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Form::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listFormsByHCPartyAndPatientForeignKeysAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListFormsByHCPartyAndPatientForeignKeysParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.form.tryAndRecover.listFormsByHCPartyAndPatientForeignKeys(
				decodedParams.hcPartyId,
				decodedParams.secretFKeys,
				decodedParams.healthElementId,
				decodedParams.planOfActionId,
				decodedParams.formTemplateId,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Form::class)), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
