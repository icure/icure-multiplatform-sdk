package com.icure.sdk.api

import com.icure.sdk.api.flavoured.encodeStartKey
import com.icure.sdk.api.raw.RawCodeApi
import com.icure.sdk.model.BooleanResponse
import com.icure.sdk.model.Code
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.utils.InternalIcureApi
import kotlinx.serialization.json.JsonElement

interface CodeApi {
	suspend fun findCodesByLabel(
		region: String?,
		types: String,
		language: String,
		label: String,
		version: String? = null,
		startKey: JsonElement? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
): PaginatedList<Code>

	suspend fun findCodesByType(
		region: String,
		type: String? = null,
		code: String? = null,
		version: String? = null,
		startKey: JsonElement? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
): PaginatedList<Code>

	suspend fun findCodesByLink(
		linkType: String,
		linkedId: String? = null,
		startKey: JsonElement? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
): PaginatedList<Code>

	suspend fun listCodesByRegionTypeCodeVersion(
		region: String,
		type: String? = null,
		code: String? = null,
		version: String? = null,
): List<Code>

	suspend fun listCodeTypesBy(region: String? = null, type: String? = null): List<String>
	suspend fun listTagTypesBy(region: String? = null, type: String? = null): List<String>
	suspend fun createCode(c: Code): Code
	suspend fun createCodes(codeBatch: List<Code>): List<Code>
	suspend fun isCodeValid(
		type: String,
		code: String,
		version: String?,
	): BooleanResponse

	suspend fun getCodeByRegionLanguageTypeLabel(
		region: String,
		label: String,
		type: String,
		languages: String?,
	): Code

	suspend fun getCodes(codeIds: ListOfIds): List<Code>
	suspend fun getCode(codeId: String): Code
	suspend fun getCodeWithParts(
		type: String,
		code: String,
		version: String,
	): Code

	suspend fun modifyCode(codeDto: Code): Code
	suspend fun modifyCodes(codeBatch: List<Code>): List<Code>
	suspend fun filterCodesBy(
		startKey: JsonElement? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		skip: Int? = null,
		sort: String? = null,
		desc: Boolean? = null,
		filterChain: FilterChain<Code>,
	): PaginatedList<Code>

	suspend fun matchCodesBy(filter: AbstractFilter<Code>): List<String>
	suspend fun importCodes(codeType: String): Unit

}

@OptIn(InternalIcureApi::class)
class CodeApiImpl(
    private val rawApi: RawCodeApi,
) : CodeApi {
    override suspend fun findCodesByLabel(
		region: String?,
		types: String,
		language: String,
		label: String,
		version: String?,
		startKey: JsonElement?,
		startDocumentId: String?,
		limit: Int?,
    ): PaginatedList<Code> = rawApi.findCodesByLabel(region, types, language, label, version, startKey.encodeStartKey(), startDocumentId, limit).successBody()

    override suspend fun findCodesByType(
		region: String,
		type: String?,
		code: String?,
		version: String?,
		startKey: JsonElement?,
		startDocumentId: String?,
		limit: Int?,
    ): PaginatedList<Code> = rawApi.findCodesByType(region, type, code, version, startKey.encodeStartKey(), startDocumentId, limit).successBody()

    override suspend fun findCodesByLink(
		linkType: String,
		linkedId: String?,
		startKey: JsonElement?,
		startDocumentId: String?,
		limit: Int?,
    ): PaginatedList<Code> = rawApi.findCodesByLink(linkType, linkedId, startKey.encodeStartKey(), startDocumentId, limit).successBody()

    override suspend fun listCodesByRegionTypeCodeVersion(
		region: String,
		type: String?,
		code: String?,
		version: String?,
    ): List<Code> = rawApi.listCodesByRegionTypeCodeVersion(region, type, code, version).successBody()

    override suspend fun listCodeTypesBy(region: String?, type: String?): List<String> = rawApi.listCodeTypesBy(region, type).successBody()

    override suspend fun listTagTypesBy(region: String?, type: String?): List<String> = rawApi.listTagTypesBy(region, type).successBody()

    override suspend fun createCode(c: Code): Code = rawApi.createCode(c).successBody()

    override suspend fun createCodes(codeBatch: List<Code>): List<Code> = rawApi.createCodes(codeBatch).successBody()

    override suspend fun isCodeValid(
        type: String,
        code: String,
        version: String?,
    ): BooleanResponse = rawApi.isCodeValid(type, code, version).successBody()

    override suspend fun getCodeByRegionLanguageTypeLabel(
        region: String,
        label: String,
        type: String,
        languages: String?,
    ): Code = rawApi.getCodeByRegionLanguageTypeLabel(region, label, type, languages).successBody()

    override suspend fun getCodes(codeIds: ListOfIds): List<Code> = rawApi.getCodes(codeIds).successBody()

    override suspend fun getCode(codeId: String): Code = rawApi.getCode(codeId).successBody()

    override suspend fun getCodeWithParts(
        type: String,
        code: String,
        version: String,
    ): Code = rawApi.getCodeWithParts(type, code, version).successBody()

    override suspend fun modifyCode(codeDto: Code): Code = rawApi.modifyCode(codeDto).successBody()

    override suspend fun modifyCodes(codeBatch: List<Code>): List<Code> = rawApi.modifyCodes(codeBatch).successBody()

    override suspend fun filterCodesBy(
		startKey: JsonElement?,
		startDocumentId: String?,
		limit: Int?,
		skip: Int?,
		sort: String?,
		desc: Boolean?,
		filterChain: FilterChain<Code>,
    ): PaginatedList<Code> = rawApi.filterCodesBy(startKey.encodeStartKey(), startDocumentId, limit, skip, sort, desc, filterChain).successBody()

    override suspend fun matchCodesBy(filter: AbstractFilter<Code>): List<String> = rawApi.matchCodesBy(filter).successBody()

    override suspend fun importCodes(codeType: String): Unit = rawApi.importCodes(codeType).successBody()
}

