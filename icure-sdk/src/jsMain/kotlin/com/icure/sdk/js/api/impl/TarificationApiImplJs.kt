// auto-generated file
package com.icure.sdk.js.api.`impl`

import com.icure.sdk.api.TarificationApi
import com.icure.sdk.js.api.TarificationApiJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.TarificationJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.js.model.tarification_toJs
import com.icure.sdk.model.Tarification
import kotlin.Array
import kotlin.Double
import kotlin.OptIn
import kotlin.String
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
		tarification_toJs(tarificationApi.getTarification(tarificationId))}


	override fun createTarification(tarification: TarificationJs): Promise<TarificationJs> =
			GlobalScope.promise {
		tarification_toJs(tarificationApi.createTarification(com.icure.sdk.js.model.tarification_fromJs(tarification)))}


	override fun getTarifications(tarificationIds: Array<String>): Promise<Array<TarificationJs>> =
			GlobalScope.promise {
		listToArray(
			tarificationApi.getTarifications(arrayToList(
				tarificationIds,
				"tarificationIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: Tarification ->
				tarification_toJs(x1)
			},
		)}


	override fun modifyTarification(tarification: TarificationJs): Promise<TarificationJs> =
			GlobalScope.promise {
		tarification_toJs(tarificationApi.modifyTarification(com.icure.sdk.js.model.tarification_fromJs(tarification)))}


	override fun findTarificationsByLabel(
		region: String?,
		types: String?,
		language: String?,
		label: String?,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<TarificationJs>> = GlobalScope.promise {
		paginatedList_toJs(
			tarificationApi.findTarificationsByLabel(region, types, language, label, startKey,
					startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
			{ x1: Tarification ->
				tarification_toJs(x1)
			},
		)}


	override fun findTarificationsBy(
		region: String?,
		type: String?,
		tarification: String?,
		version: String?,
		startDocumentId: String?,
		startKey: String?,
		limit: Double?,
	): Promise<PaginatedListJs<TarificationJs>> = GlobalScope.promise {
		paginatedList_toJs(
			tarificationApi.findTarificationsBy(region, type, tarification, version, startDocumentId,
					startKey, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
			{ x1: Tarification ->
				tarification_toJs(x1)
			},
		)}


	override fun getTarificationWithParts(
		type: String,
		tarification: String,
		version: String,
	): Promise<TarificationJs> = GlobalScope.promise {
		tarification_toJs(tarificationApi.getTarificationWithParts(type, tarification, version))}

}
