package com.icure.sdk.api.raw

import com.icure.sdk.model.Insurance
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.utils.InternalIcureApi
import kotlin.Int
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawInsuranceApi {
	// region common endpoints

	suspend fun getAllInsurances(
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<Insurance>>

	suspend fun createInsurance(insuranceDto: Insurance): HttpResponse<Insurance>

	suspend fun deleteInsurance(insuranceId: String): HttpResponse<DocIdentifier>

	suspend fun getInsurance(insuranceId: String): HttpResponse<Insurance>

	suspend fun getInsurances(insuranceIds: ListOfIds): HttpResponse<List<Insurance>>

	suspend fun listInsurancesByCode(insuranceCode: String): HttpResponse<List<Insurance>>

	suspend fun listInsurancesByName(insuranceName: String): HttpResponse<List<Insurance>>

	suspend fun modifyInsurance(insuranceDto: Insurance): HttpResponse<Insurance>
	// endregion
}
