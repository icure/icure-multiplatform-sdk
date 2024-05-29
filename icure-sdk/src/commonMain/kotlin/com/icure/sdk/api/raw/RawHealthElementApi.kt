package com.icure.sdk.api.raw

import com.icure.sdk.model.EncryptedHealthElement
import com.icure.sdk.model.HealthElement
import com.icure.sdk.model.IcureStub
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.requests.EntityBulkShareResult
import com.icure.sdk.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.Nothing
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawHealthElementApi {
	// region common endpoints

	suspend fun createHealthElement(c: EncryptedHealthElement): HttpResponse<EncryptedHealthElement>

	suspend fun getHealthElement(healthElementId: String): HttpResponse<EncryptedHealthElement>

	suspend fun getHealthElements(healthElementIds: ListOfIds): HttpResponse<List<EncryptedHealthElement>>

	suspend fun listHealthElementsByHCPartyAndPatientForeignKeys(
		hcPartyId: String,
		secretFKeys: String,
	): HttpResponse<List<EncryptedHealthElement>>

	suspend fun listHealthElementIdsByDataOwnerPatientOpeningDate(
		dataOwnerId: String,
		startDate: Long? = null,
		endDate: Long? = null,
		descending: Boolean? = null,
		secretPatientKeys: ListOfIds,
	): HttpResponse<List<String>>

	suspend fun findHealthElementsByHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	): HttpResponse<List<EncryptedHealthElement>>

	public suspend fun listHealthElementsDelegationsStubsByHCPartyAndPatientForeignKeys(
		hcPartyId: String,
		secretFKeys: String,
	): HttpResponse<List<IcureStub>>

	suspend fun findHealthElementsDelegationsStubsByHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	): HttpResponse<List<IcureStub>>

	suspend fun deleteHealthElements(healthElementIds: ListOfIds): HttpResponse<List<DocIdentifier>>

	suspend fun deleteHealthElement(healthElementId: String): HttpResponse<DocIdentifier>

	suspend fun modifyHealthElement(healthElementDto: EncryptedHealthElement): HttpResponse<EncryptedHealthElement>

	suspend fun modifyHealthElements(healthElementDtos: List<EncryptedHealthElement>): HttpResponse<List<EncryptedHealthElement>>

	suspend fun createHealthElements(healthElementDtos: List<EncryptedHealthElement>): HttpResponse<List<EncryptedHealthElement>>

	suspend fun filterHealthElementsBy(
		startDocumentId: String? = null,
		limit: Int? = null,
		filterChain: FilterChain<HealthElement>,
	): HttpResponse<PaginatedList<EncryptedHealthElement>>

	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedHealthElement>>>

	suspend fun matchHealthElementsBy(filter: AbstractFilter<HealthElement>): HttpResponse<List<String>>

	suspend fun bulkShareMinimal(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<Nothing>>>
	// endregion
}
