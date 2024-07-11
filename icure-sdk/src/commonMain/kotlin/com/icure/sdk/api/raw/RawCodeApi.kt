package com.icure.sdk.api.raw

import com.icure.sdk.model.BooleanResponse
import com.icure.sdk.model.Code
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawCodeApi {
	// region common endpoints

	suspend fun findCodesByLabel(
		region: String?,
		types: String,
		language: String,
		label: String,
		version: String? = null,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<Code>>

	suspend fun findCodesByType(
		region: String,
		type: String? = null,
		code: String? = null,
		version: String? = null,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<Code>>

	suspend fun findCodesByLink(
		linkType: String,
		linkedId: String? = null,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<Code>>

	suspend fun listCodesByRegionTypeCodeVersion(
		region: String,
		type: String? = null,
		code: String? = null,
		version: String? = null,
	): HttpResponse<List<Code>>

	suspend fun listCodeTypesBy(
		region: String? = null,
		type: String? = null,
	): HttpResponse<List<String>>

	suspend fun listTagTypesBy(
		region: String? = null,
		type: String? = null,
	): HttpResponse<List<String>>

	suspend fun createCode(c: Code): HttpResponse<Code>

	suspend fun createCodes(codeBatch: List<Code>): HttpResponse<List<Code>>

	suspend fun isCodeValid(
		type: String,
		code: String,
		version: String?,
	): HttpResponse<BooleanResponse>

	suspend fun getCodeByRegionLanguageTypeLabel(
		region: String,
		label: String,
		type: String,
		languages: String?,
	): HttpResponse<Code>

	suspend fun getCodes(codeIds: ListOfIds): HttpResponse<List<Code>>

	suspend fun getCode(codeId: String): HttpResponse<Code>

	suspend fun getCodeWithParts(
		type: String,
		code: String,
		version: String,
	): HttpResponse<Code>

	suspend fun modifyCode(codeDto: Code): HttpResponse<Code>

	suspend fun modifyCodes(codeBatch: List<Code>): HttpResponse<List<Code>>

	suspend fun filterCodesBy(
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		skip: Int? = null,
		sort: String? = null,
		desc: Boolean? = null,
		filterChain: FilterChain<Code>,
	): HttpResponse<PaginatedList<Code>>

	suspend fun matchCodesBy(filter: AbstractFilter<Code>): HttpResponse<List<String>>

	suspend fun importCodes(codeType: String): HttpResponse<Unit>
	// endregion

	// region cloud endpoints

	suspend fun createCodesInGroup(
		groupId: String,
		codeBatch: List<Code>,
	): HttpResponse<List<Code>>

	suspend fun getCodesInGroup(
		groupId: String,
		codeIds: String,
	): HttpResponse<List<Code>>

	suspend fun modifyCodesInGroup(
		groupId: String,
		codeBatch: List<Code>,
	): HttpResponse<List<Code>>
	// endregion
}
