package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.InsuranceApi
import com.icure.cardinal.sdk.api.raw.RawInsuranceApi
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.model.Insurance
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.utils.InternalIcureApi

@InternalIcureApi
internal class InsuranceApiImpl(
	private val rawApi: RawInsuranceApi,
) : InsuranceApi {
	override suspend fun getInsurance(insuranceId: String) = rawApi.getInsurance(insuranceId).successBody()

	override suspend fun getInsurances(insuranceIds: List<String>) = rawApi.getInsurances(
		ListOfIds(insuranceIds)
	).successBody()

	override suspend fun createInsurance(insurance: Insurance) = rawApi.createInsurance(insurance).successBody()

	override suspend fun deleteInsurance(insuranceId: String) = rawApi.deleteInsurance(insuranceId).successBody()

	override suspend fun getAllInsurances(
		startDocumentId: String?,
		limit: Int?,
	) = rawApi.getAllInsurances(startDocumentId, limit).successBody()

	override suspend fun listInsurancesByCode(insuranceCode: String) = rawApi.listInsurancesByCode(insuranceCode).successBody()

	override suspend fun listInsurancesByName(insuranceName: String) = rawApi.listInsurancesByName(insuranceName).successBody()

	override suspend fun modifyInsurance(insurance: Insurance) = rawApi.modifyInsurance(insurance).successBodyOrThrowRevisionConflict()
}