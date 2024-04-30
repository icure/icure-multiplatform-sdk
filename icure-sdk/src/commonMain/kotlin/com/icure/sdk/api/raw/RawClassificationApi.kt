package com.icure.sdk.api.raw

import com.icure.sdk.model.EncryptedClassification
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.requests.EntityBulkShareResult
import com.icure.sdk.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawClassificationApi {
	// region common endpoints

	suspend fun createClassification(c: EncryptedClassification): HttpResponse<EncryptedClassification>

	suspend fun getClassification(classificationId: String): HttpResponse<EncryptedClassification>

	suspend fun getClassificationByHcPartyId(ids: String): HttpResponse<List<EncryptedClassification>>

	suspend fun findClassificationsByHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretFKeys: String,
	): HttpResponse<List<EncryptedClassification>>

	suspend fun listClassificationIdsByDataOwnerPatientCreated(
		dataOwnerId: String,
		startDate: Long? = null,
		endDate: Long? = null,
		descending: Boolean? = null,
		secretPatientKeys: ListOfIds,
	): HttpResponse<List<String>>

	suspend fun deleteClassifications(classificationIds: ListOfIds): HttpResponse<List<DocIdentifier>>

	suspend fun deleteClassification(classificationId: String): HttpResponse<DocIdentifier>

	suspend fun modifyClassification(classificationDto: EncryptedClassification): HttpResponse<EncryptedClassification>

	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedClassification>>>

	suspend fun bulkShareMinimal(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedClassification>>>
	// endregion
}
