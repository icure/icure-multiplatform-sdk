// auto-generated file
package com.icure.sdk.js.api.`impl`

import com.icure.sdk.api.InsuranceApi
import com.icure.sdk.js.api.InsuranceApiJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.InsuranceJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.insurance_toJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.model.Insurance
import kotlin.Array
import kotlin.Double
import kotlin.OptIn
import kotlin.String
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class InsuranceApiImplJs(
	private val insuranceApi: InsuranceApi,
) : InsuranceApiJs {
	override fun getInsurance(insuranceId: String): Promise<InsuranceJs> = GlobalScope.promise {
		insurance_toJs(insuranceApi.getInsurance(insuranceId))}


	override fun getInsurances(insuranceIds: Array<String>): Promise<Array<InsuranceJs>> =
			GlobalScope.promise {
		listToArray(
			insuranceApi.getInsurances(arrayToList(
				insuranceIds,
				"insuranceIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: Insurance ->
				insurance_toJs(x1)
			},
		)}


	override fun createInsurance(insurance: InsuranceJs): Promise<InsuranceJs> = GlobalScope.promise {
		insurance_toJs(insuranceApi.createInsurance(com.icure.sdk.js.model.insurance_fromJs(insurance)))}


	override fun deleteInsurance(insuranceId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		docIdentifier_toJs(insuranceApi.deleteInsurance(insuranceId))}


	override fun getAllInsurances(startDocumentId: String?, limit: Double?):
			Promise<PaginatedListJs<InsuranceJs>> = GlobalScope.promise {
		paginatedList_toJs(
			insuranceApi.getAllInsurances(startDocumentId,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
			{ x1: Insurance ->
				insurance_toJs(x1)
			},
		)}


	override fun listInsurancesByCode(insuranceCode: String): Promise<Array<InsuranceJs>> =
			GlobalScope.promise {
		listToArray(
			insuranceApi.listInsurancesByCode(insuranceCode),
			{ x1: Insurance ->
				insurance_toJs(x1)
			},
		)}


	override fun listInsurancesByName(insuranceName: String): Promise<Array<InsuranceJs>> =
			GlobalScope.promise {
		listToArray(
			insuranceApi.listInsurancesByName(insuranceName),
			{ x1: Insurance ->
				insurance_toJs(x1)
			},
		)}


	override fun modifyInsurance(insurance: InsuranceJs): Promise<InsuranceJs> = GlobalScope.promise {
		insurance_toJs(insuranceApi.modifyInsurance(com.icure.sdk.js.model.insurance_fromJs(insurance)))}

}
