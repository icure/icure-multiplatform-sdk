package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.utils.InternalIcureApi
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import com.icure.cardinal.sdk.model.Insurance as ModelInsurance
import org.taktik.icure.entities.Insurance as EntitiesInsurance

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawInsuranceApi {
	// region common endpoints

	suspend fun getAllInsurances(
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<ModelInsurance>>

	suspend fun createInsurance(insuranceDto: ModelInsurance): HttpResponse<ModelInsurance>

	suspend fun deleteInsurance(insuranceId: String): HttpResponse<EntitiesInsurance>

	suspend fun getInsurance(insuranceId: String): HttpResponse<ModelInsurance>

	suspend fun getInsurances(insuranceIds: ListOfIds): HttpResponse<List<ModelInsurance>>

	suspend fun listInsurancesByCode(insuranceCode: String): HttpResponse<List<ModelInsurance>>

	suspend fun listInsurancesByName(insuranceName: String): HttpResponse<List<ModelInsurance>>

	suspend fun modifyInsurance(insuranceDto: ModelInsurance): HttpResponse<ModelInsurance>
	// endregion
}
