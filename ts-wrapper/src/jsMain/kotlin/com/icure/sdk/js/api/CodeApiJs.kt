// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api

import com.icure.sdk.js.model.BooleanResponseJs
import com.icure.sdk.js.model.CodeJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
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
	): Promise<CodeJs>

	public fun getCodes(codeIds: Array<String>): Promise<Array<CodeJs>>

	public fun getCode(codeId: String): Promise<CodeJs>

	public fun getCodeWithParts(
		type: String,
		code: String,
		version: String,
	): Promise<CodeJs>

	public fun modifyCode(codeDto: CodeJs): Promise<CodeJs>

	public fun modifyCodes(codeBatch: Array<CodeJs>): Promise<Array<CodeJs>>

	public fun filterCodesBy(filterChain: FilterChainJs<CodeJs>, options: dynamic):
			Promise<PaginatedListJs<CodeJs>>

	public fun matchCodesBy(filter: AbstractFilterJs<CodeJs>): Promise<Array<String>>

	public fun importCodes(codeType: String): Promise<Unit>
}
