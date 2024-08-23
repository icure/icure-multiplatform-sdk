package com.icure.sdk.api

import com.icure.sdk.model.Insurance
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.utils.DefaultValue

interface InsuranceApi {
	suspend fun getInsurance(insuranceId: String): Insurance
	suspend fun getInsurances(insuranceIds: List<String>): List<Insurance>
	suspend fun createInsurance(insurance: Insurance): Insurance
	suspend fun deleteInsurance(insuranceId: String): DocIdentifier

	suspend fun getAllInsurances(
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null
	): PaginatedList<Insurance>
	suspend fun listInsurancesByCode(insuranceCode: String): List<Insurance>
	suspend fun listInsurancesByName(insuranceName: String): List<Insurance>
	suspend fun modifyInsurance(insurance: Insurance): Insurance
}

