package com.icure.sdk.api

import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.model.BooleanResponse
import com.icure.sdk.model.Code
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.utils.DefaultValue
import com.icure.sdk.utils.pagination.PaginatedListIterator
import kotlinx.serialization.json.JsonElement
import kotlin.js.JsName

interface CodeApi {
	// TODO: Implement filter for this method
	@Deprecated("Find methods are deprecated", ReplaceWith("filterCodesBy()"))
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

	// TODO: Implement filter for this method
	@Deprecated("Find methods are deprecated", ReplaceWith("filterCodesBy(filter)"))
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

	// TODO: Implement filter for this method
	@Deprecated("Find methods are deprecated", ReplaceWith("filterCodesBy(filter)"))
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
		filter: BaseFilterOptions<Code>
	): PaginatedListIterator<Code>

	suspend fun filterCodesBySorted(
		filter: BaseSortableFilterOptions<Code>
	): PaginatedListIterator<Code>

	suspend fun matchCodesBy(filter: BaseFilterOptions<Code>): List<String>

	suspend fun matchCodesBySorted(filter: BaseSortableFilterOptions<Code>): List<String>

	suspend fun importCodes(codeType: String)
}

