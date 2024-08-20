// auto-generated file
package com.icure.sdk.py.api.CodeApi

import com.icure.sdk.IcureNonCryptoApis
import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.model.BooleanResponse
import com.icure.sdk.model.Code
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.py.utils.PaginatedListIterator.PaginatedListIteratorAndSerializer
import com.icure.sdk.py.utils.PyResult
import com.icure.sdk.py.utils.failureToPyResultAsyncCallback
import com.icure.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.sdk.py.utils.toPyResult
import com.icure.sdk.py.utils.toPyResultAsyncCallback
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.py.utils.toPyStringAsyncCallback
import com.icure.sdk.utils.Serialization.json
import kotlin.Byte
import kotlin.Int
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
import kotlinx.serialization.json.JsonElement

@Serializable
private class FindCodesByLabelParams(
	public val region: String?,
	public val types: String,
	public val language: String,
	public val label: String,
	public val version: String? = null,
	public val startKey: JsonElement? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
)

public fun findCodesByLabelBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindCodesByLabelParams>(params)
	runBlocking {
		sdk.code.findCodesByLabel(
			decodedParams.region,
			decodedParams.types,
			decodedParams.language,
			decodedParams.label,
			decodedParams.version,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(Code.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findCodesByLabelAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindCodesByLabelParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.code.findCodesByLabel(
				decodedParams.region,
				decodedParams.types,
				decodedParams.language,
				decodedParams.label,
				decodedParams.version,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(Code.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindCodesByTypeParams(
	public val region: String,
	public val type: String? = null,
	public val code: String? = null,
	public val version: String? = null,
	public val startKey: JsonElement? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
)

public fun findCodesByTypeBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindCodesByTypeParams>(params)
	runBlocking {
		sdk.code.findCodesByType(
			decodedParams.region,
			decodedParams.type,
			decodedParams.code,
			decodedParams.version,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(Code.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findCodesByTypeAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindCodesByTypeParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.code.findCodesByType(
				decodedParams.region,
				decodedParams.type,
				decodedParams.code,
				decodedParams.version,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(Code.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindCodesByLinkParams(
	public val linkType: String,
	public val linkedId: String? = null,
	public val startKey: JsonElement? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
)

public fun findCodesByLinkBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindCodesByLinkParams>(params)
	runBlocking {
		sdk.code.findCodesByLink(
			decodedParams.linkType,
			decodedParams.linkedId,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(Code.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findCodesByLinkAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindCodesByLinkParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.code.findCodesByLink(
				decodedParams.linkType,
				decodedParams.linkedId,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(Code.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListCodesByRegionTypeCodeVersionParams(
	public val region: String,
	public val type: String? = null,
	public val code: String? = null,
	public val version: String? = null,
)

public fun listCodesByRegionTypeCodeVersionBlocking(sdk: IcureNonCryptoApis, params: String): String
		= kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListCodesByRegionTypeCodeVersionParams>(params)
	runBlocking {
		sdk.code.listCodesByRegionTypeCodeVersion(
			decodedParams.region,
			decodedParams.type,
			decodedParams.code,
			decodedParams.version,
		)
	}
}.toPyString(ListSerializer(Code.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listCodesByRegionTypeCodeVersionAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListCodesByRegionTypeCodeVersionParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.code.listCodesByRegionTypeCodeVersion(
				decodedParams.region,
				decodedParams.type,
				decodedParams.code,
				decodedParams.version,
			)
		}.toPyStringAsyncCallback(ListSerializer(Code.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListCodeTypesByParams(
	public val region: String? = null,
	public val type: String? = null,
)

public fun listCodeTypesByBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListCodeTypesByParams>(params)
	runBlocking {
		sdk.code.listCodeTypesBy(
			decodedParams.region,
			decodedParams.type,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listCodeTypesByAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListCodeTypesByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.code.listCodeTypesBy(
				decodedParams.region,
				decodedParams.type,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListTagTypesByParams(
	public val region: String? = null,
	public val type: String? = null,
)

public fun listTagTypesByBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListTagTypesByParams>(params)
	runBlocking {
		sdk.code.listTagTypesBy(
			decodedParams.region,
			decodedParams.type,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listTagTypesByAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListTagTypesByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.code.listTagTypesBy(
				decodedParams.region,
				decodedParams.type,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateCodeParams(
	public val c: Code,
)

public fun createCodeBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateCodeParams>(params)
	runBlocking {
		sdk.code.createCode(
			decodedParams.c,
		)
	}
}.toPyString(Code.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun createCodeAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateCodeParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.code.createCode(
				decodedParams.c,
			)
		}.toPyStringAsyncCallback(Code.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateCodesParams(
	public val codeBatch: List<Code>,
)

public fun createCodesBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateCodesParams>(params)
	runBlocking {
		sdk.code.createCodes(
			decodedParams.codeBatch,
		)
	}
}.toPyString(ListSerializer(Code.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun createCodesAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateCodesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.code.createCodes(
				decodedParams.codeBatch,
			)
		}.toPyStringAsyncCallback(ListSerializer(Code.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateCodesInGroupParams(
	public val groupId: String,
	public val codeBatch: List<Code>,
)

public fun createCodesInGroupBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateCodesInGroupParams>(params)
	runBlocking {
		sdk.code.createCodes(
			decodedParams.groupId,
			decodedParams.codeBatch,
		)
	}
}.toPyString(ListSerializer(Code.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun createCodesInGroupAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateCodesInGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.code.createCodes(
				decodedParams.groupId,
				decodedParams.codeBatch,
			)
		}.toPyStringAsyncCallback(ListSerializer(Code.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class IsCodeValidParams(
	public val type: String,
	public val code: String,
	public val version: String?,
)

public fun isCodeValidBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<IsCodeValidParams>(params)
	runBlocking {
		sdk.code.isCodeValid(
			decodedParams.type,
			decodedParams.code,
			decodedParams.version,
		)
	}
}.toPyString(BooleanResponse.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun isCodeValidAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<IsCodeValidParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.code.isCodeValid(
				decodedParams.type,
				decodedParams.code,
				decodedParams.version,
			)
		}.toPyStringAsyncCallback(BooleanResponse.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetCodeByRegionLanguageTypeLabelParams(
	public val region: String,
	public val label: String,
	public val type: String,
	public val languages: String?,
)

public fun getCodeByRegionLanguageTypeLabelBlocking(sdk: IcureNonCryptoApis, params: String): String
		= kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetCodeByRegionLanguageTypeLabelParams>(params)
	runBlocking {
		sdk.code.getCodeByRegionLanguageTypeLabel(
			decodedParams.region,
			decodedParams.label,
			decodedParams.type,
			decodedParams.languages,
		)
	}
}.toPyString(Code.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getCodeByRegionLanguageTypeLabelAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetCodeByRegionLanguageTypeLabelParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.code.getCodeByRegionLanguageTypeLabel(
				decodedParams.region,
				decodedParams.label,
				decodedParams.type,
				decodedParams.languages,
			)
		}.toPyStringAsyncCallback(Code.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetCodesParams(
	public val codeIds: List<String>,
)

public fun getCodesBlocking(sdk: IcureNonCryptoApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetCodesParams>(params)
	runBlocking {
		sdk.code.getCodes(
			decodedParams.codeIds,
		)
	}
}.toPyString(ListSerializer(Code.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getCodesAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetCodesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.code.getCodes(
				decodedParams.codeIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(Code.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetCodesInGroupParams(
	public val groupId: String,
	public val codeIds: List<String>,
)

public fun getCodesInGroupBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetCodesInGroupParams>(params)
	runBlocking {
		sdk.code.getCodes(
			decodedParams.groupId,
			decodedParams.codeIds,
		)
	}
}.toPyString(ListSerializer(Code.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getCodesInGroupAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetCodesInGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.code.getCodes(
				decodedParams.groupId,
				decodedParams.codeIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(Code.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetCodeParams(
	public val codeId: String,
)

public fun getCodeBlocking(sdk: IcureNonCryptoApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetCodeParams>(params)
	runBlocking {
		sdk.code.getCode(
			decodedParams.codeId,
		)
	}
}.toPyString(Code.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getCodeAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetCodeParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.code.getCode(
				decodedParams.codeId,
			)
		}.toPyStringAsyncCallback(Code.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetCodeWithPartsParams(
	public val type: String,
	public val code: String,
	public val version: String,
)

public fun getCodeWithPartsBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetCodeWithPartsParams>(params)
	runBlocking {
		sdk.code.getCodeWithParts(
			decodedParams.type,
			decodedParams.code,
			decodedParams.version,
		)
	}
}.toPyString(Code.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getCodeWithPartsAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetCodeWithPartsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.code.getCodeWithParts(
				decodedParams.type,
				decodedParams.code,
				decodedParams.version,
			)
		}.toPyStringAsyncCallback(Code.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyCodeParams(
	public val codeDto: Code,
)

public fun modifyCodeBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyCodeParams>(params)
	runBlocking {
		sdk.code.modifyCode(
			decodedParams.codeDto,
		)
	}
}.toPyString(Code.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyCodeAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyCodeParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.code.modifyCode(
				decodedParams.codeDto,
			)
		}.toPyStringAsyncCallback(Code.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyCodesParams(
	public val codeBatch: List<Code>,
)

public fun modifyCodesBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyCodesParams>(params)
	runBlocking {
		sdk.code.modifyCodes(
			decodedParams.codeBatch,
		)
	}
}.toPyString(ListSerializer(Code.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun modifyCodesAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyCodesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.code.modifyCodes(
				decodedParams.codeBatch,
			)
		}.toPyStringAsyncCallback(ListSerializer(Code.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyCodesInGroupParams(
	public val groupId: String,
	public val codeBatch: List<Code>,
)

public fun modifyCodesInGroupBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyCodesInGroupParams>(params)
	runBlocking {
		sdk.code.modifyCodes(
			decodedParams.groupId,
			decodedParams.codeBatch,
		)
	}
}.toPyString(ListSerializer(Code.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun modifyCodesInGroupAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyCodesInGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.code.modifyCodes(
				decodedParams.groupId,
				decodedParams.codeBatch,
			)
		}.toPyStringAsyncCallback(ListSerializer(Code.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterCodesByParams(
	public val filter: BaseFilterOptions<Code>,
)

public fun filterCodesByBlocking(sdk: IcureNonCryptoApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterCodesByParams>(params)
	runBlocking {
		sdk.code.filterCodesBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, Code.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun filterCodesByAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterCodesByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.code.filterCodesBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, Code.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterCodesBySortedParams(
	public val filter: BaseSortableFilterOptions<Code>,
)

public fun filterCodesBySortedBlocking(sdk: IcureNonCryptoApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterCodesBySortedParams>(params)
	runBlocking {
		sdk.code.filterCodesBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, Code.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun filterCodesBySortedAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterCodesBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.code.filterCodesBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, Code.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class MatchCodesByParams(
	public val filter: BaseFilterOptions<Code>,
)

public fun matchCodesByBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchCodesByParams>(params)
	runBlocking {
		sdk.code.matchCodesBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun matchCodesByAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchCodesByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.code.matchCodesBy(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchCodesBySortedParams(
	public val filter: BaseSortableFilterOptions<Code>,
)

public fun matchCodesBySortedBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchCodesBySortedParams>(params)
	runBlocking {
		sdk.code.matchCodesBySorted(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun matchCodesBySortedAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchCodesBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.code.matchCodesBySorted(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ImportCodesParams(
	public val codeType: String,
)

public fun importCodesBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ImportCodesParams>(params)
	runBlocking {
		sdk.code.importCodes(
			decodedParams.codeType,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun importCodesAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ImportCodesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.code.importCodes(
				decodedParams.codeType,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
