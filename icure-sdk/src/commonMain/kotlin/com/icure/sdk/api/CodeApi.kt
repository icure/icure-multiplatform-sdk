package com.icure.sdk.api

import com.icure.sdk.api.flavoured.encodeStartKey
import com.icure.sdk.api.raw.RawCodeApi
import com.icure.sdk.model.BooleanResponse
import com.icure.sdk.model.Code
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.utils.DefaultValue
import com.icure.sdk.utils.InternalIcureApi
import kotlinx.serialization.json.JsonElement
import kotlin.js.JsName

interface CodeApi {
	suspend fun findCodesByLabel(
		region: String?,
		types: String,
		language: String,
		label: String,
		@DefaultValue("null")
		version: String? = null,
		@DefaultValue("null")
		startKey: JsonElement? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
): PaginatedList<Code>

	suspend fun findCodesByType(
		region: String,
		@DefaultValue("null")
		type: String? = null,
		@DefaultValue("null")
		code: String? = null,
		@DefaultValue("null")
		version: String? = null,
		@DefaultValue("null")
		startKey: JsonElement? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
): PaginatedList<Code>

	suspend fun findCodesByLink(
		linkType: String,
		@DefaultValue("null")
		linkedId: String? = null,
		@DefaultValue("null")
		startKey: JsonElement? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
): PaginatedList<Code>

	suspend fun listCodesByRegionTypeCodeVersion(
		region: String,
		@DefaultValue("null")
		type: String? = null,
		@DefaultValue("null")
		code: String? = null,
		@DefaultValue("null")
		version: String? = null,
): List<Code>

	suspend fun listCodeTypesBy(
		@DefaultValue("null")
		region: String? = null,
		@DefaultValue("null")
		type: String? = null
	): List<String>
	suspend fun listTagTypesBy(
		@DefaultValue("null")
		region: String? = null,
		@DefaultValue("null")
		type: String? = null
	): List<String>
	suspend fun createCode(c: Code): Code
	suspend fun createCodes(codeBatch: List<Code>): List<Code>
	@JsName("createCodesInGroup")
	suspend fun createCodes(groupId: String, codeBatch: List<Code>): List<Code>
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

	suspend fun getCodes(codeIds: List<String>): List<Code>
	@JsName("getCodesInGroup")
	suspend fun getCodes(groupId: String, codeIds: List<String>): List<Code>
	suspend fun getCode(codeId: String): Code
	suspend fun getCodeWithParts(
		type: String,
		code: String,
		version: String,
	): Code

	suspend fun modifyCode(codeDto: Code): Code
	suspend fun modifyCodes(codeBatch: List<Code>): List<Code>
	@JsName("modifyCodesInGroup")
	suspend fun modifyCodes(groupId: String, codeBatch: List<Code>): List<Code>
	suspend fun filterCodesBy(
		@DefaultValue("null")
		startKey: JsonElement? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
		@DefaultValue("null")
		skip: Int? = null,
		@DefaultValue("null")
		sort: String? = null,
		@DefaultValue("null")
		desc: Boolean? = null,
		filterChain: FilterChain<Code>,
	): PaginatedList<Code>

	suspend fun matchCodesBy(filter: AbstractFilter<Code>): List<String>
	suspend fun importCodes(codeType: String)

}

@InternalIcureApi
internal class CodeApiImpl(
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

    override suspend fun getCodes(codeIds: List<String>): List<Code> = rawApi.getCodes(
		ListOfIds(codeIds)).successBody()

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

	override suspend fun createCodes(groupId: String, codeBatch: List<Code>): List<Code> = rawApi.createCodesInGroup(groupId, codeBatch).successBody()

	override suspend fun getCodes(groupId: String, codeIds: List<String>): List<Code> = rawApi.getCodes(groupId, ListOfIds(ids = codeIds)).successBody()

	override suspend fun modifyCodes(groupId: String, codeBatch: List<Code>): List<Code> = rawApi.modifyCodesInGroup(groupId, codeBatch).successBody()
}

