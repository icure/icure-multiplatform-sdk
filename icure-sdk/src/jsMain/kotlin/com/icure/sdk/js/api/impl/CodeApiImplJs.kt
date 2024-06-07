// auto-generated file
package com.icure.sdk.js.api.`impl`

import com.icure.sdk.api.CodeApi
import com.icure.sdk.js.api.CodeApiJs
import com.icure.sdk.js.api.CodeApi_filterCodesBy_Options
import com.icure.sdk.js.api.CodeApi_findCodesByLabel_Options
import com.icure.sdk.js.api.CodeApi_findCodesByLink_Options
import com.icure.sdk.js.api.CodeApi_findCodesByType_Options
import com.icure.sdk.js.api.CodeApi_listCodeTypesBy_Options
import com.icure.sdk.js.api.CodeApi_listCodesByRegionTypeCodeVersion_Options
import com.icure.sdk.js.api.CodeApi_listTagTypesBy_Options
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefault
import com.icure.sdk.js.model.BooleanResponseJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.dynamicToJsonNullsafe
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CodeJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.booleanResponse_toJs
import com.icure.sdk.js.model.code_fromJs
import com.icure.sdk.js.model.code_toJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.abstractFilter_fromJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.model.filter.chain.filterChain_fromJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.model.Code
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import kotlin.Array
import kotlin.Boolean
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import kotlinx.serialization.json.JsonElement

@OptIn(DelicateCoroutinesApi::class)
internal class CodeApiImplJs(
	private val codeApi: CodeApi,
) : CodeApiJs {
	override fun findCodesByLabel(
		region: String?,
		types: String,
		language: String,
		label: String,
		options: CodeApi_findCodesByLabel_Options?,
	): Promise<PaginatedListJs<CodeJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val regionConverted: String? = region
			val typesConverted: String = types
			val languageConverted: String = language
			val labelConverted: String = label
			val versionConverted: String? = convertingOptionOrDefault(
				_options.version,
				null
			) { version ->
				version
			}
			val startKeyConverted: JsonElement? = convertingOptionOrDefault(
				_options.startKey,
				null
			) { startKey ->
				dynamicToJsonNullsafe(startKey, "startKey")
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefault(
				_options.startDocumentId,
				null
			) { startDocumentId ->
				startDocumentId
			}
			val limitConverted: Int? = convertingOptionOrDefault(
				_options.limit,
				null
			) { limit ->
				numberToInt(limit, "limit")
			}
			val result = codeApi.findCodesByLabel(
				regionConverted,
				typesConverted,
				languageConverted,
				labelConverted,
				versionConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: Code ->
					code_toJs(x1)
				},
			)
		}
	}

	override fun findCodesByType(region: String, options: CodeApi_findCodesByType_Options?):
			Promise<PaginatedListJs<CodeJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val regionConverted: String = region
			val typeConverted: String? = convertingOptionOrDefault(
				_options.type,
				null
			) { type ->
				type
			}
			val codeConverted: String? = convertingOptionOrDefault(
				_options.code,
				null
			) { code ->
				code
			}
			val versionConverted: String? = convertingOptionOrDefault(
				_options.version,
				null
			) { version ->
				version
			}
			val startKeyConverted: JsonElement? = convertingOptionOrDefault(
				_options.startKey,
				null
			) { startKey ->
				dynamicToJsonNullsafe(startKey, "startKey")
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefault(
				_options.startDocumentId,
				null
			) { startDocumentId ->
				startDocumentId
			}
			val limitConverted: Int? = convertingOptionOrDefault(
				_options.limit,
				null
			) { limit ->
				numberToInt(limit, "limit")
			}
			val result = codeApi.findCodesByType(
				regionConverted,
				typeConverted,
				codeConverted,
				versionConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: Code ->
					code_toJs(x1)
				},
			)
		}
	}

	override fun findCodesByLink(linkType: String, options: CodeApi_findCodesByLink_Options?):
			Promise<PaginatedListJs<CodeJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val linkTypeConverted: String = linkType
			val linkedIdConverted: String? = convertingOptionOrDefault(
				_options.linkedId,
				null
			) { linkedId ->
				linkedId
			}
			val startKeyConverted: JsonElement? = convertingOptionOrDefault(
				_options.startKey,
				null
			) { startKey ->
				dynamicToJsonNullsafe(startKey, "startKey")
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefault(
				_options.startDocumentId,
				null
			) { startDocumentId ->
				startDocumentId
			}
			val limitConverted: Int? = convertingOptionOrDefault(
				_options.limit,
				null
			) { limit ->
				numberToInt(limit, "limit")
			}
			val result = codeApi.findCodesByLink(
				linkTypeConverted,
				linkedIdConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: Code ->
					code_toJs(x1)
				},
			)
		}
	}

	override fun listCodesByRegionTypeCodeVersion(region: String,
			options: CodeApi_listCodesByRegionTypeCodeVersion_Options?): Promise<Array<CodeJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val regionConverted: String = region
			val typeConverted: String? = convertingOptionOrDefault(
				_options.type,
				null
			) { type ->
				type
			}
			val codeConverted: String? = convertingOptionOrDefault(
				_options.code,
				null
			) { code ->
				code
			}
			val versionConverted: String? = convertingOptionOrDefault(
				_options.version,
				null
			) { version ->
				version
			}
			val result = codeApi.listCodesByRegionTypeCodeVersion(
				regionConverted,
				typeConverted,
				codeConverted,
				versionConverted,
			)
			listToArray(
				result,
				{ x1: Code ->
					code_toJs(x1)
				},
			)
		}
	}

	override fun listCodeTypesBy(options: CodeApi_listCodeTypesBy_Options?): Promise<Array<String>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val regionConverted: String? = convertingOptionOrDefault(
				_options.region,
				null
			) { region ->
				region
			}
			val typeConverted: String? = convertingOptionOrDefault(
				_options.type,
				null
			) { type ->
				type
			}
			val result = codeApi.listCodeTypesBy(
				regionConverted,
				typeConverted,
			)
			listToArray(
				result,
				{ x1: String ->
					x1
				},
			)
		}
	}

	override fun listTagTypesBy(options: CodeApi_listTagTypesBy_Options?): Promise<Array<String>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val regionConverted: String? = convertingOptionOrDefault(
				_options.region,
				null
			) { region ->
				region
			}
			val typeConverted: String? = convertingOptionOrDefault(
				_options.type,
				null
			) { type ->
				type
			}
			val result = codeApi.listTagTypesBy(
				regionConverted,
				typeConverted,
			)
			listToArray(
				result,
				{ x1: String ->
					x1
				},
			)
		}
	}

	override fun createCode(c: CodeJs): Promise<CodeJs> = GlobalScope.promise {
		val cConverted: Code = code_fromJs(c)
		val result = codeApi.createCode(
			cConverted,
		)
		code_toJs(result)
	}

	override fun createCodes(codeBatch: Array<CodeJs>): Promise<Array<CodeJs>> = GlobalScope.promise {
		val codeBatchConverted: List<Code> = arrayToList(
			codeBatch,
			"codeBatch",
			{ x1: CodeJs ->
				code_fromJs(x1)
			},
		)
		val result = codeApi.createCodes(
			codeBatchConverted,
		)
		listToArray(
			result,
			{ x1: Code ->
				code_toJs(x1)
			},
		)
	}

	override fun isCodeValid(
		type: String,
		code: String,
		version: String?,
	): Promise<BooleanResponseJs> = GlobalScope.promise {
		val typeConverted: String = type
		val codeConverted: String = code
		val versionConverted: String? = version
		val result = codeApi.isCodeValid(
			typeConverted,
			codeConverted,
			versionConverted,
		)
		booleanResponse_toJs(result)
	}

	override fun getCodeByRegionLanguageTypeLabel(
		region: String,
		label: String,
		type: String,
		languages: String?,
	): Promise<CodeJs> = GlobalScope.promise {
		val regionConverted: String = region
		val labelConverted: String = label
		val typeConverted: String = type
		val languagesConverted: String? = languages
		val result = codeApi.getCodeByRegionLanguageTypeLabel(
			regionConverted,
			labelConverted,
			typeConverted,
			languagesConverted,
		)
		code_toJs(result)
	}

	override fun getCodes(codeIds: Array<String>): Promise<Array<CodeJs>> = GlobalScope.promise {
		val codeIdsConverted: List<String> = arrayToList(
			codeIds,
			"codeIds",
			{ x1: String ->
				x1
			},
		)
		val result = codeApi.getCodes(
			codeIdsConverted,
		)
		listToArray(
			result,
			{ x1: Code ->
				code_toJs(x1)
			},
		)
	}

	override fun getCode(codeId: String): Promise<CodeJs> = GlobalScope.promise {
		val codeIdConverted: String = codeId
		val result = codeApi.getCode(
			codeIdConverted,
		)
		code_toJs(result)
	}

	override fun getCodeWithParts(
		type: String,
		code: String,
		version: String,
	): Promise<CodeJs> = GlobalScope.promise {
		val typeConverted: String = type
		val codeConverted: String = code
		val versionConverted: String = version
		val result = codeApi.getCodeWithParts(
			typeConverted,
			codeConverted,
			versionConverted,
		)
		code_toJs(result)
	}

	override fun modifyCode(codeDto: CodeJs): Promise<CodeJs> = GlobalScope.promise {
		val codeDtoConverted: Code = code_fromJs(codeDto)
		val result = codeApi.modifyCode(
			codeDtoConverted,
		)
		code_toJs(result)
	}

	override fun modifyCodes(codeBatch: Array<CodeJs>): Promise<Array<CodeJs>> = GlobalScope.promise {
		val codeBatchConverted: List<Code> = arrayToList(
			codeBatch,
			"codeBatch",
			{ x1: CodeJs ->
				code_fromJs(x1)
			},
		)
		val result = codeApi.modifyCodes(
			codeBatchConverted,
		)
		listToArray(
			result,
			{ x1: Code ->
				code_toJs(x1)
			},
		)
	}

	override fun filterCodesBy(filterChain: FilterChainJs<CodeJs>,
			options: CodeApi_filterCodesBy_Options?): Promise<PaginatedListJs<CodeJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val startKeyConverted: JsonElement? = convertingOptionOrDefault(
				_options.startKey,
				null
			) { startKey ->
				dynamicToJsonNullsafe(startKey, "startKey")
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefault(
				_options.startDocumentId,
				null
			) { startDocumentId ->
				startDocumentId
			}
			val limitConverted: Int? = convertingOptionOrDefault(
				_options.limit,
				null
			) { limit ->
				numberToInt(limit, "limit")
			}
			val skipConverted: Int? = convertingOptionOrDefault(
				_options.skip,
				null
			) { skip ->
				numberToInt(skip, "skip")
			}
			val sortConverted: String? = convertingOptionOrDefault(
				_options.sort,
				null
			) { sort ->
				sort
			}
			val descConverted: Boolean? = convertingOptionOrDefault(
				_options.desc,
				null
			) { desc ->
				desc
			}
			val filterChainConverted: FilterChain<Code> = filterChain_fromJs(
				filterChain,
				{ x1: CodeJs ->
					code_fromJs(x1)
				},
			)
			val result = codeApi.filterCodesBy(
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
				skipConverted,
				sortConverted,
				descConverted,
				filterChainConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: Code ->
					code_toJs(x1)
				},
			)
		}
	}

	override fun matchCodesBy(filter: AbstractFilterJs<CodeJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: AbstractFilter<Code> = abstractFilter_fromJs(
			filter,
			{ x1: CodeJs ->
				code_fromJs(x1)
			},
		)
		val result = codeApi.matchCodesBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun importCodes(codeType: String): Promise<Unit> = GlobalScope.promise {
		val codeTypeConverted: String = codeType
		codeApi.importCodes(
			codeTypeConverted,
		)

	}
}
