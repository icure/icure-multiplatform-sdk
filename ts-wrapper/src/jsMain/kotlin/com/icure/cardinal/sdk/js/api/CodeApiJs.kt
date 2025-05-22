// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.BooleanResponseJs
import com.icure.cardinal.sdk.js.model.CodeJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("CodeApi")
public external interface CodeApiJs {
	public fun findCodesByLabel(
		region: String?,
		types: String,
		language: String,
		label: String,
		options: dynamic,
	): Promise<PaginatedListJs<CodeJs>>

	public fun findCodesByType(region: String, options: dynamic): Promise<PaginatedListJs<CodeJs>>

	public fun findCodesByLink(linkType: String, options: dynamic): Promise<PaginatedListJs<CodeJs>>

	public fun listCodesByRegionTypeCodeVersion(region: String, options: dynamic):
			Promise<Array<CodeJs>>

	public fun listCodeTypesBy(options: dynamic): Promise<Array<String>>

	public fun listTagTypesBy(options: dynamic): Promise<Array<String>>

	public fun createCode(c: CodeJs): Promise<CodeJs>

	public fun createCodes(codeBatch: Array<CodeJs>): Promise<Array<CodeJs>>

	@JsName("createCodesInGroup")
	public fun createCodes(groupId: String, codeBatch: Array<CodeJs>): Promise<Array<CodeJs>>

	public fun isCodeValid(
		type: String,
		code: String,
		version: String?,
	): Promise<BooleanResponseJs>

	public fun getCodeByRegionLanguageTypeLabel(
		region: String,
		label: String,
		type: String,
		languages: String?,
	): Promise<CodeJs?>

	public fun getCodes(codeIds: Array<String>): Promise<Array<CodeJs>>

	@JsName("getCodesInGroup")
	public fun getCodes(groupId: String, codeIds: Array<String>): Promise<Array<CodeJs>>

	public fun getCode(codeId: String): Promise<CodeJs?>

	public fun getCodeWithParts(
		type: String,
		code: String,
		version: String,
	): Promise<CodeJs?>

	public fun modifyCode(codeDto: CodeJs): Promise<CodeJs>

	public fun modifyCodes(codeBatch: Array<CodeJs>): Promise<Array<CodeJs>>

	@JsName("modifyCodesInGroup")
	public fun modifyCodes(groupId: String, codeBatch: Array<CodeJs>): Promise<Array<CodeJs>>

	public fun filterCodesBy(filter: BaseFilterOptionsJs<CodeJs>):
			Promise<PaginatedListIteratorJs<CodeJs>>

	public fun filterCodesBySorted(filter: BaseSortableFilterOptionsJs<CodeJs>):
			Promise<PaginatedListIteratorJs<CodeJs>>

	public fun matchCodesBy(filter: BaseFilterOptionsJs<CodeJs>): Promise<Array<String>>

	public fun matchCodesBySorted(filter: BaseSortableFilterOptionsJs<CodeJs>): Promise<Array<String>>

	public fun importCodes(codeType: String): Promise<Unit>
}
