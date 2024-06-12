// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api

import com.icure.sdk.js.model.BooleanResponseJs
import com.icure.sdk.js.model.CodeJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
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
		options: CodeApi_findCodesByLabel_Options?,
	): Promise<PaginatedListJs<CodeJs>>

	public fun findCodesByType(region: String, options: CodeApi_findCodesByType_Options?):
			Promise<PaginatedListJs<CodeJs>>

	public fun findCodesByLink(linkType: String, options: CodeApi_findCodesByLink_Options?):
			Promise<PaginatedListJs<CodeJs>>

	public fun listCodesByRegionTypeCodeVersion(region: String,
			options: CodeApi_listCodesByRegionTypeCodeVersion_Options?): Promise<Array<CodeJs>>

	public fun listCodeTypesBy(options: CodeApi_listCodeTypesBy_Options?): Promise<Array<String>>

	public fun listTagTypesBy(options: CodeApi_listTagTypesBy_Options?): Promise<Array<String>>

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

	public fun filterCodesBy(filterChain: FilterChainJs<CodeJs>,
			options: CodeApi_filterCodesBy_Options?): Promise<PaginatedListJs<CodeJs>>

	public fun matchCodesBy(filter: AbstractFilterJs<CodeJs>): Promise<Array<String>>

	public fun importCodes(codeType: String): Promise<Unit>
}

public external interface CodeApi_findCodesByLabel_Options {
	public val version: String?

	public val startKey: dynamic

	public val startDocumentId: String?

	public val limit: Double?
}

public external interface CodeApi_findCodesByType_Options {
	public val type: String?

	public val code: String?

	public val version: String?

	public val startKey: dynamic

	public val startDocumentId: String?

	public val limit: Double?
}

public external interface CodeApi_findCodesByLink_Options {
	public val linkedId: String?

	public val startKey: dynamic

	public val startDocumentId: String?

	public val limit: Double?
}

public external interface CodeApi_listCodesByRegionTypeCodeVersion_Options {
	public val type: String?

	public val code: String?

	public val version: String?
}

public external interface CodeApi_listCodeTypesBy_Options {
	public val region: String?

	public val type: String?
}

public external interface CodeApi_listTagTypesBy_Options {
	public val region: String?

	public val type: String?
}

public external interface CodeApi_filterCodesBy_Options {
	public val startKey: dynamic

	public val startDocumentId: String?

	public val limit: Double?

	public val skip: Double?

	public val sort: String?

	public val desc: Boolean?
}
