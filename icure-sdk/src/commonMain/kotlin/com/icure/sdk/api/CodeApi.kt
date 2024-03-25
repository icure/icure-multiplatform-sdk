package com.icure.sdk.api

import com.icure.sdk.api.raw.RawCodeApi
import com.icure.sdk.model.BooleanResponse
import com.icure.sdk.model.Code
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.utils.InternalIcureApi

@OptIn(InternalIcureApi::class)
class CodeApi(
    private val rawApi: RawCodeApi,
) {
    suspend fun findCodesByLabel(
        region: String?,
        types: String,
        language: String,
        label: String,
        version: String? = null,
        startKey: String? = null,
        startDocumentId: String? = null,
        limit: Int? = null,
    ): PaginatedList<Code, String> = rawApi.findCodesByLabel(region, types, language, label, version, startKey, startDocumentId, limit).successBody()

    suspend fun findCodesByType(
        region: String,
        type: String? = null,
        code: String? = null,
        version: String? = null,
        startKey: String? = null,
        startDocumentId: String? = null,
        limit: Int? = null,
    ): PaginatedList<Code, String> = rawApi.findCodesByType(region, type, code, version, startKey, startDocumentId, limit).successBody()

    suspend fun findCodesByLink(
        linkType: String,
        linkedId: String? = null,
        startKey: String? = null,
        startDocumentId: String? = null,
        limit: Int? = null,
    ): PaginatedList<Code, String> = rawApi.findCodesByLink(linkType, linkedId, startKey, startDocumentId, limit).successBody()

    suspend fun listCodesByRegionTypeCodeVersion(
        region: String,
        type: String? = null,
        code: String? = null,
        version: String? = null,
    ): List<Code> = rawApi.listCodesByRegionTypeCodeVersion(region, type, code, version).successBody()

    suspend fun listCodeTypesBy(region: String? = null, type: String? = null): List<String> = rawApi.listCodeTypesBy(region, type).successBody()

    suspend fun listTagTypesBy(region: String? = null, type: String? = null): List<String> = rawApi.listTagTypesBy(region, type).successBody()

    suspend fun createCode(c: Code): Code = rawApi.createCode(c).successBody()

    suspend fun createCodes(codeBatch: List<Code>): List<Code> = rawApi.createCodes(codeBatch).successBody()

    suspend fun isCodeValid(
        type: String,
        code: String,
        version: String?,
    ): BooleanResponse = rawApi.isCodeValid(type, code, version).successBody()

    suspend fun getCodeByRegionLanguageTypeLabel(
        region: String,
        label: String,
        type: String,
        languages: String?,
    ): Code = rawApi.getCodeByRegionLanguageTypeLabel(region, label, type, languages).successBody()

    suspend fun getCodes(codeIds: ListOfIds): List<Code> = rawApi.getCodes(codeIds).successBody()

    suspend fun getCode(codeId: String): Code = rawApi.getCode(codeId).successBody()

    suspend fun getCodeWithParts(
        type: String,
        code: String,
        version: String,
    ): Code = rawApi.getCodeWithParts(type, code, version).successBody()

    suspend fun modifyCode(codeDto: Code): Code = rawApi.modifyCode(codeDto).successBody()

    suspend fun modifyCodes(codeBatch: List<Code>): List<Code> = rawApi.modifyCodes(codeBatch).successBody()

    suspend fun filterCodesBy(
        startKey: String? = null,
        startDocumentId: String? = null,
        limit: Int? = null,
        skip: Int? = null,
        sort: String? = null,
        desc: Boolean? = null,
        filterChain: FilterChain<Code>,
    ): PaginatedList<Code, *> = rawApi.filterCodesBy(startKey, startDocumentId, limit, skip, sort, desc, filterChain).successBody()

    suspend fun matchCodesBy(filter: AbstractFilter<Code>): List<String> = rawApi.matchCodesBy(filter).successBody()

    suspend fun importCodes(codeType: String): Unit = rawApi.importCodes(codeType).successBody()
}
