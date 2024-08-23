package com.icure.sdk.api.impl

import com.icure.sdk.api.InsuranceApi
import com.icure.sdk.api.raw.RawInsuranceApi
import com.icure.sdk.model.Insurance
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.utils.InternalIcureApi

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

	override suspend fun modifyInsurance(insurance: Insurance) = rawApi.modifyInsurance(insurance).successBody()
}