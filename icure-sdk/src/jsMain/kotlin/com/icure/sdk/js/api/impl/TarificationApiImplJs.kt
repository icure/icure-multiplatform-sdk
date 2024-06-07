// auto-generated file
package com.icure.sdk.js.api.`impl`

import com.icure.sdk.api.TarificationApi
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefault
import com.icure.sdk.js.api.TarificationApiJs
import com.icure.sdk.js.api.TarificationApi_findTarificationsByLabel_Options
import com.icure.sdk.js.api.TarificationApi_findTarificationsBy_Options
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.TarificationJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.js.model.tarification_fromJs
import com.icure.sdk.js.model.tarification_toJs
import com.icure.sdk.model.Tarification
import kotlin.Array
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.collections.List
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class TarificationApiImplJs(
	private val tarificationApi: TarificationApi,
) : TarificationApiJs {
	override fun getTarification(tarificationId: String): Promise<TarificationJs> =
			GlobalScope.promise {
		val tarificationIdConverted: String = tarificationId
		val result = tarificationApi.getTarification(
			tarificationIdConverted,
		)
		tarification_toJs(result)
	}

	override fun createTarification(tarification: TarificationJs): Promise<TarificationJs> =
			GlobalScope.promise {
		val tarificationConverted: Tarification = tarification_fromJs(tarification)
		val result = tarificationApi.createTarification(
			tarificationConverted,
		)
		tarification_toJs(result)
	}

	override fun getTarifications(tarificationIds: Array<String>): Promise<Array<TarificationJs>> =
			GlobalScope.promise {
		val tarificationIdsConverted: List<String> = arrayToList(
			tarificationIds,
			"tarificationIds",
			{ x1: String ->
				x1
			},
		)
		val result = tarificationApi.getTarifications(
			tarificationIdsConverted,
		)
		listToArray(
			result,
			{ x1: Tarification ->
				tarification_toJs(x1)
			},
		)
	}

	override fun modifyTarification(tarification: TarificationJs): Promise<TarificationJs> =
			GlobalScope.promise {
		val tarificationConverted: Tarification = tarification_fromJs(tarification)
		val result = tarificationApi.modifyTarification(
			tarificationConverted,
		)
		tarification_toJs(result)
	}

	override fun findTarificationsByLabel(options: TarificationApi_findTarificationsByLabel_Options?):
			Promise<PaginatedListJs<TarificationJs>> {
		val _options: TarificationApi_findTarificationsByLabel_Options = options ?: js("{}")
		return GlobalScope.promise {
			val regionConverted: String? = convertingOptionOrDefault(
				_options.region,
				null
			) { region ->
				region
			}
			val typesConverted: String? = convertingOptionOrDefault(
				_options.types,
				null
			) { types ->
				types
			}
			val languageConverted: String? = convertingOptionOrDefault(
				_options.language,
				null
			) { language ->
				language
			}
			val labelConverted: String? = convertingOptionOrDefault(
				_options.label,
				null
			) { label ->
				label
			}
			val startKeyConverted: String? = convertingOptionOrDefault(
				_options.startKey,
				null
			) { startKey ->
				startKey
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
			val result = tarificationApi.findTarificationsByLabel(
				regionConverted,
				typesConverted,
				languageConverted,
				labelConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: Tarification ->
					tarification_toJs(x1)
				},
			)
		}
	}

	override fun findTarificationsBy(options: TarificationApi_findTarificationsBy_Options?):
			Promise<PaginatedListJs<TarificationJs>> {
		val _options: TarificationApi_findTarificationsBy_Options = options ?: js("{}")
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
			val tarificationConverted: String? = convertingOptionOrDefault(
				_options.tarification,
				null
			) { tarification ->
				tarification
			}
			val versionConverted: String? = convertingOptionOrDefault(
				_options.version,
				null
			) { version ->
				version
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefault(
				_options.startDocumentId,
				null
			) { startDocumentId ->
				startDocumentId
			}
			val startKeyConverted: String? = convertingOptionOrDefault(
				_options.startKey,
				null
			) { startKey ->
				startKey
			}
			val limitConverted: Int? = convertingOptionOrDefault(
				_options.limit,
				null
			) { limit ->
				numberToInt(limit, "limit")
			}
			val result = tarificationApi.findTarificationsBy(
				regionConverted,
				typeConverted,
				tarificationConverted,
				versionConverted,
				startDocumentIdConverted,
				startKeyConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: Tarification ->
					tarification_toJs(x1)
				},
			)
		}
	}

	override fun getTarificationWithParts(
		type: String,
		tarification: String,
		version: String,
	): Promise<TarificationJs> = GlobalScope.promise {
		val typeConverted: String = type
		val tarificationConverted: String = tarification
		val versionConverted: String = version
		val result = tarificationApi.getTarificationWithParts(
			typeConverted,
			tarificationConverted,
			versionConverted,
		)
		tarification_toJs(result)
	}
}
