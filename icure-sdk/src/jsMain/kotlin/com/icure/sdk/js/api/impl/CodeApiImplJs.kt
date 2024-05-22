// auto-generated file
package com.icure.sdk.js.api.`impl`

import com.icure.sdk.api.CodeApi
import com.icure.sdk.js.api.CodeApiJs
import com.icure.sdk.js.model.BooleanResponseJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CodeJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.booleanResponse_toJs
import com.icure.sdk.js.model.code_fromJs
import com.icure.sdk.js.model.code_toJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.abstractFilter_fromJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.model.Code
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
public class CodeApiImplJs private constructor(
	private val codeApi: CodeApi,
) : CodeApiJs {
	override fun findCodesByLabel(
		region: String?,
		types: String,
		language: String,
		label: String,
		version: String?,
		startKey: dynamic,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<CodeJs>> = GlobalScope.promise {
		paginatedList_toJs(
			codeApi.findCodesByLabel(region, types, language, label, version,
					com.icure.sdk.js.model.CheckedConverters.dynamicToJsonNullsafe(startKey, "startKey"),
					startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
			{ x1: Code ->
				code_toJs(x1)
			},
		)}


	override fun findCodesByType(
		region: String,
		type: String?,
		code: String?,
		version: String?,
		startKey: dynamic,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<CodeJs>> = GlobalScope.promise {
		paginatedList_toJs(
			codeApi.findCodesByType(region, type, code, version,
					com.icure.sdk.js.model.CheckedConverters.dynamicToJsonNullsafe(startKey, "startKey"),
					startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
			{ x1: Code ->
				code_toJs(x1)
			},
		)}


	override fun findCodesByLink(
		linkType: String,
		linkedId: String?,
		startKey: dynamic,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<CodeJs>> = GlobalScope.promise {
		paginatedList_toJs(
			codeApi.findCodesByLink(linkType, linkedId,
					com.icure.sdk.js.model.CheckedConverters.dynamicToJsonNullsafe(startKey, "startKey"),
					startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
			{ x1: Code ->
				code_toJs(x1)
			},
		)}


	override fun listCodesByRegionTypeCodeVersion(
		region: String,
		type: String?,
		code: String?,
		version: String?,
	): Promise<Array<CodeJs>> = GlobalScope.promise {
		listToArray(
			codeApi.listCodesByRegionTypeCodeVersion(region, type, code, version),
			{ x1: Code ->
				code_toJs(x1)
			},
		)}


	override fun listCodeTypesBy(region: String?, type: String?): Promise<Array<String>> =
			GlobalScope.promise {
		listToArray(
			codeApi.listCodeTypesBy(region, type),
			{ x1: String ->
				x1
			},
		)}


	override fun listTagTypesBy(region: String?, type: String?): Promise<Array<String>> =
			GlobalScope.promise {
		listToArray(
			codeApi.listTagTypesBy(region, type),
			{ x1: String ->
				x1
			},
		)}


	override fun createCode(c: CodeJs): Promise<CodeJs> = GlobalScope.promise {
		code_toJs(codeApi.createCode(com.icure.sdk.js.model.code_fromJs(c)))}


	override fun createCodes(codeBatch: Array<CodeJs>): Promise<Array<CodeJs>> = GlobalScope.promise {
		listToArray(
			codeApi.createCodes(arrayToList(
				codeBatch,
				"codeBatch",
				{ x1: CodeJs ->
					code_fromJs(x1)
				},
			)),
			{ x1: Code ->
				code_toJs(x1)
			},
		)}


	override fun isCodeValid(
		type: String,
		code: String,
		version: String?,
	): Promise<BooleanResponseJs> = GlobalScope.promise {
		booleanResponse_toJs(codeApi.isCodeValid(type, code, version))}


	override fun getCodeByRegionLanguageTypeLabel(
		region: String,
		label: String,
		type: String,
		languages: String?,
	): Promise<CodeJs> = GlobalScope.promise {
		code_toJs(codeApi.getCodeByRegionLanguageTypeLabel(region, label, type, languages))}


	override fun getCodes(codeIds: Array<String>): Promise<Array<CodeJs>> = GlobalScope.promise {
		listToArray(
			codeApi.getCodes(arrayToList(
				codeIds,
				"codeIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: Code ->
				code_toJs(x1)
			},
		)}


	override fun getCode(codeId: String): Promise<CodeJs> = GlobalScope.promise {
		code_toJs(codeApi.getCode(codeId))}


	override fun getCodeWithParts(
		type: String,
		code: String,
		version: String,
	): Promise<CodeJs> = GlobalScope.promise {
		code_toJs(codeApi.getCodeWithParts(type, code, version))}


	override fun modifyCode(codeDto: CodeJs): Promise<CodeJs> = GlobalScope.promise {
		code_toJs(codeApi.modifyCode(com.icure.sdk.js.model.code_fromJs(codeDto)))}


	override fun modifyCodes(codeBatch: Array<CodeJs>): Promise<Array<CodeJs>> = GlobalScope.promise {
		listToArray(
			codeApi.modifyCodes(arrayToList(
				codeBatch,
				"codeBatch",
				{ x1: CodeJs ->
					code_fromJs(x1)
				},
			)),
			{ x1: Code ->
				code_toJs(x1)
			},
		)}


	override fun filterCodesBy(
		startKey: dynamic,
		startDocumentId: String?,
		limit: Double?,
		skip: Double?,
		sort: String?,
		desc: Boolean?,
		filterChain: FilterChainJs<CodeJs>,
	): Promise<PaginatedListJs<CodeJs>> = GlobalScope.promise {
		paginatedList_toJs(
			codeApi.filterCodesBy(com.icure.sdk.js.model.CheckedConverters.dynamicToJsonNullsafe(startKey,
					"startKey"), startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit,
					"limit"), com.icure.sdk.js.model.CheckedConverters.numberToInt(skip, "skip"), sort, desc,
					com.icure.sdk.js.model.filter.chain.filterChain_fromJs(
			  filterChain,
			  { x1: com.icure.sdk.js.model.CodeJs ->
			    com.icure.sdk.js.model.code_fromJs(x1)
			  },
			)),
			{ x1: Code ->
				code_toJs(x1)
			},
		)}


	override fun matchCodesBy(filter: AbstractFilterJs<CodeJs>): Promise<Array<String>> =
			GlobalScope.promise {
		listToArray(
			codeApi.matchCodesBy(abstractFilter_fromJs(
				filter,
				{ x1: CodeJs ->
					code_fromJs(x1)
				},
			)),
			{ x1: String ->
				x1
			},
		)}


	override fun importCodes(codeType: String): Promise<Unit> = GlobalScope.promise {
		codeApi.importCodes(codeType)}

}
