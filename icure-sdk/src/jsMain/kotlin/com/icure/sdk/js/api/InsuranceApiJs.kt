// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api

import com.icure.sdk.js.model.InsuranceJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("InsuranceApi")
public external interface InsuranceApiJs {
	public fun getInsurance(insuranceId: String): Promise<InsuranceJs>

	public fun getInsurances(insuranceIds: Array<String>): Promise<Array<InsuranceJs>>

	public fun createInsurance(insurance: InsuranceJs): Promise<InsuranceJs>

	public fun deleteInsurance(insuranceId: String): Promise<DocIdentifierJs>

	public fun getAllInsurances(startDocumentId: String?, limit: Double?):
			Promise<PaginatedListJs<InsuranceJs>>

	public fun listInsurancesByCode(insuranceCode: String): Promise<Array<InsuranceJs>>

	public fun listInsurancesByName(insuranceName: String): Promise<Array<InsuranceJs>>

	public fun modifyInsurance(insurance: InsuranceJs): Promise<InsuranceJs>
}
