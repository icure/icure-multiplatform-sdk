// auto-generated file
package com.icure.sdk.js.api.`impl`

import com.icure.sdk.api.CodeApi
import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.js.api.CodeApiJs
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.sdk.js.filters.BaseFilterOptionsJs
import com.icure.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.sdk.js.filters.baseFilterOptions_fromJs
import com.icure.sdk.js.filters.baseSortableFilterOptions_fromJs
import com.icure.sdk.js.model.BooleanResponseJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.dynamicToJsonNullsafe
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.js.model.CodeJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.booleanResponse_toJs
import com.icure.sdk.js.model.code_fromJs
import com.icure.sdk.js.model.code_toJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.sdk.model.Code
import kotlin.Array
import kotlin.Double
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
		options: dynamic,
	): Promise<PaginatedListJs<CodeJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val regionConverted: String? = undefinedToNull(region)
			val typesConverted: String = types
			val languageConverted: String = language
			val labelConverted: String = label
			val versionConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"version",
				null
			) { version: String? ->
				undefinedToNull(version)
			}
			val startKeyConverted: JsonElement? = convertingOptionOrDefaultNullable(
				_options,
				"startKey",
				null
			) { startKey: dynamic ->
				dynamicToJsonNullsafe(startKey, "startKey")
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startDocumentId",
				null
			) { startDocumentId: String? ->
				undefinedToNull(startDocumentId)
			}
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
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

	override fun findCodesByType(region: String, options: dynamic): Promise<PaginatedListJs<CodeJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val regionConverted: String = region
			val typeConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"type",
				null
			) { type: String? ->
				undefinedToNull(type)
			}
			val codeConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"code",
				null
			) { code: String? ->
				undefinedToNull(code)
			}
			val versionConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"version",
				null
			) { version: String? ->
				undefinedToNull(version)
			}
			val startKeyConverted: JsonElement? = convertingOptionOrDefaultNullable(
				_options,
				"startKey",
				null
			) { startKey: dynamic ->
				dynamicToJsonNullsafe(startKey, "startKey")
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startDocumentId",
				null
			) { startDocumentId: String? ->
				undefinedToNull(startDocumentId)
			}
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
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

	override fun findCodesByLink(linkType: String, options: dynamic):
			Promise<PaginatedListJs<CodeJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val linkTypeConverted: String = linkType
			val linkedIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"linkedId",
				null
			) { linkedId: String? ->
				undefinedToNull(linkedId)
			}
			val startKeyConverted: JsonElement? = convertingOptionOrDefaultNullable(
				_options,
				"startKey",
				null
			) { startKey: dynamic ->
				dynamicToJsonNullsafe(startKey, "startKey")
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startDocumentId",
				null
			) { startDocumentId: String? ->
				undefinedToNull(startDocumentId)
			}
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
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

	override fun listCodesByRegionTypeCodeVersion(region: String, options: dynamic):
			Promise<Array<CodeJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val regionConverted: String = region
			val typeConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"type",
				null
			) { type: String? ->
				undefinedToNull(type)
			}
			val codeConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"code",
				null
			) { code: String? ->
				undefinedToNull(code)
			}
			val versionConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"version",
				null
			) { version: String? ->
				undefinedToNull(version)
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

	override fun listCodeTypesBy(options: dynamic): Promise<Array<String>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val regionConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"region",
				null
			) { region: String? ->
				undefinedToNull(region)
			}
			val typeConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"type",
				null
			) { type: String? ->
				undefinedToNull(type)
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

	override fun listTagTypesBy(options: dynamic): Promise<Array<String>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val regionConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"region",
				null
			) { region: String? ->
				undefinedToNull(region)
			}
			val typeConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"type",
				null
			) { type: String? ->
				undefinedToNull(type)
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

	override fun createCodes(groupId: String, codeBatch: Array<CodeJs>): Promise<Array<CodeJs>> =
			GlobalScope.promise {
		val groupIdConverted: String = groupId
		val codeBatchConverted: List<Code> = arrayToList(
			codeBatch,
			"codeBatch",
			{ x1: CodeJs ->
				code_fromJs(x1)
			},
		)
		val result = codeApi.createCodes(
			groupIdConverted,
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
		val versionConverted: String? = undefinedToNull(version)
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
		val languagesConverted: String? = undefinedToNull(languages)
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

	override fun getCodes(groupId: String, codeIds: Array<String>): Promise<Array<CodeJs>> =
			GlobalScope.promise {
		val groupIdConverted: String = groupId
		val codeIdsConverted: List<String> = arrayToList(
			codeIds,
			"codeIds",
			{ x1: String ->
				x1
			},
		)
		val result = codeApi.getCodes(
			groupIdConverted,
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

	override fun modifyCodes(groupId: String, codeBatch: Array<CodeJs>): Promise<Array<CodeJs>> =
			GlobalScope.promise {
		val groupIdConverted: String = groupId
		val codeBatchConverted: List<Code> = arrayToList(
			codeBatch,
			"codeBatch",
			{ x1: CodeJs ->
				code_fromJs(x1)
			},
		)
		val result = codeApi.modifyCodes(
			groupIdConverted,
			codeBatchConverted,
		)
		listToArray(
			result,
			{ x1: Code ->
				code_toJs(x1)
			},
		)
	}

	override fun filterCodesBy(filter: BaseFilterOptionsJs<CodeJs>):
			Promise<PaginatedListIteratorJs<CodeJs>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Code> = baseFilterOptions_fromJs(filter)
		val result = codeApi.filterCodesBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: Code ->
				code_toJs(x1)
			},
		)
	}

	override fun filterCodesBySorted(filter: BaseSortableFilterOptionsJs<CodeJs>):
			Promise<PaginatedListIteratorJs<CodeJs>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Code> = baseSortableFilterOptions_fromJs(filter)
		val result = codeApi.filterCodesBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: Code ->
				code_toJs(x1)
			},
		)
	}

	override fun matchCodesBy(filter: BaseFilterOptionsJs<CodeJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Code> = baseFilterOptions_fromJs(filter)
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

	override fun matchCodesBySorted(filter: BaseSortableFilterOptionsJs<CodeJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Code> = baseSortableFilterOptions_fromJs(filter)
		val result = codeApi.matchCodesBySorted(
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
