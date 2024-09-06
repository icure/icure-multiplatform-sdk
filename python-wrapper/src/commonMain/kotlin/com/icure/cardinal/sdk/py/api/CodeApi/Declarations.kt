// auto-generated file
package com.icure.cardinal.sdk.py.api.CodeApi

import com.icure.cardinal.sdk.CardinalNonCryptoApis
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.BooleanResponse
import com.icure.cardinal.sdk.model.Code
import com.icure.cardinal.sdk.model.PaginatedList
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

@OptIn(InternalIcureApi::class)
public fun findCodesByLabelBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindCodesByLabelParams>(params)
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

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findCodesByLabelAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindCodesByLabelParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun findCodesByTypeBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindCodesByTypeParams>(params)
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

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findCodesByTypeAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindCodesByTypeParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun findCodesByLinkBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindCodesByLinkParams>(params)
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

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findCodesByLinkAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindCodesByLinkParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun listCodesByRegionTypeCodeVersionBlocking(sdk: CardinalNonCryptoApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListCodesByRegionTypeCodeVersionParams>(params)
	runBlocking {
		sdk.code.listCodesByRegionTypeCodeVersion(
			decodedParams.region,
			decodedParams.type,
			decodedParams.code,
			decodedParams.version,
		)
	}
}.toPyString(ListSerializer(Code.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listCodesByRegionTypeCodeVersionAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListCodesByRegionTypeCodeVersionParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun listCodeTypesByBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListCodeTypesByParams>(params)
	runBlocking {
		sdk.code.listCodeTypesBy(
			decodedParams.region,
			decodedParams.type,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listCodeTypesByAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListCodeTypesByParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun listTagTypesByBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListTagTypesByParams>(params)
	runBlocking {
		sdk.code.listTagTypesBy(
			decodedParams.region,
			decodedParams.type,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listTagTypesByAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListTagTypesByParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun createCodeBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateCodeParams>(params)
	runBlocking {
		sdk.code.createCode(
			decodedParams.c,
		)
	}
}.toPyString(Code.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createCodeAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateCodeParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun createCodesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateCodesParams>(params)
	runBlocking {
		sdk.code.createCodes(
			decodedParams.codeBatch,
		)
	}
}.toPyString(ListSerializer(Code.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createCodesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateCodesParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun createCodesInGroupBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateCodesInGroupParams>(params)
	runBlocking {
		sdk.code.createCodes(
			decodedParams.groupId,
			decodedParams.codeBatch,
		)
	}
}.toPyString(ListSerializer(Code.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createCodesInGroupAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateCodesInGroupParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun isCodeValidBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<IsCodeValidParams>(params)
	runBlocking {
		sdk.code.isCodeValid(
			decodedParams.type,
			decodedParams.code,
			decodedParams.version,
		)
	}
}.toPyString(BooleanResponse.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun isCodeValidAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<IsCodeValidParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun getCodeByRegionLanguageTypeLabelBlocking(sdk: CardinalNonCryptoApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetCodeByRegionLanguageTypeLabelParams>(params)
	runBlocking {
		sdk.code.getCodeByRegionLanguageTypeLabel(
			decodedParams.region,
			decodedParams.label,
			decodedParams.type,
			decodedParams.languages,
		)
	}
}.toPyString(Code.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getCodeByRegionLanguageTypeLabelAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetCodeByRegionLanguageTypeLabelParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun getCodesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetCodesParams>(params)
	runBlocking {
		sdk.code.getCodes(
			decodedParams.codeIds,
		)
	}
}.toPyString(ListSerializer(Code.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getCodesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetCodesParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun getCodesInGroupBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetCodesInGroupParams>(params)
	runBlocking {
		sdk.code.getCodes(
			decodedParams.groupId,
			decodedParams.codeIds,
		)
	}
}.toPyString(ListSerializer(Code.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getCodesInGroupAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetCodesInGroupParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun getCodeBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetCodeParams>(params)
	runBlocking {
		sdk.code.getCode(
			decodedParams.codeId,
		)
	}
}.toPyString(Code.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getCodeAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetCodeParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun getCodeWithPartsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetCodeWithPartsParams>(params)
	runBlocking {
		sdk.code.getCodeWithParts(
			decodedParams.type,
			decodedParams.code,
			decodedParams.version,
		)
	}
}.toPyString(Code.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getCodeWithPartsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetCodeWithPartsParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun modifyCodeBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyCodeParams>(params)
	runBlocking {
		sdk.code.modifyCode(
			decodedParams.codeDto,
		)
	}
}.toPyString(Code.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyCodeAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyCodeParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun modifyCodesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyCodesParams>(params)
	runBlocking {
		sdk.code.modifyCodes(
			decodedParams.codeBatch,
		)
	}
}.toPyString(ListSerializer(Code.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyCodesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyCodesParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun modifyCodesInGroupBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyCodesInGroupParams>(params)
	runBlocking {
		sdk.code.modifyCodes(
			decodedParams.groupId,
			decodedParams.codeBatch,
		)
	}
}.toPyString(ListSerializer(Code.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyCodesInGroupAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyCodesInGroupParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun filterCodesByBlocking(sdk: CardinalNonCryptoApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterCodesByParams>(params)
	runBlocking {
		sdk.code.filterCodesBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, Code.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterCodesByAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterCodesByParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun filterCodesBySortedBlocking(sdk: CardinalNonCryptoApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterCodesBySortedParams>(params)
	runBlocking {
		sdk.code.filterCodesBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, Code.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterCodesBySortedAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterCodesBySortedParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun matchCodesByBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchCodesByParams>(params)
	runBlocking {
		sdk.code.matchCodesBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchCodesByAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchCodesByParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun matchCodesBySortedBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchCodesBySortedParams>(params)
	runBlocking {
		sdk.code.matchCodesBySorted(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchCodesBySortedAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchCodesBySortedParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun importCodesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ImportCodesParams>(params)
	runBlocking {
		sdk.code.importCodes(
			decodedParams.codeType,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun importCodesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ImportCodesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.code.importCodes(
				decodedParams.codeType,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
