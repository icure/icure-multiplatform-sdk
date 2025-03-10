package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.Classification
import com.icure.cardinal.sdk.model.EncryptedClassification
import com.icure.cardinal.sdk.model.IcureStub
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.cardinal.sdk.model.requests.EntityBulkShareResult
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Long
import kotlin.Nothing
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawClassificationApi {
	// region common endpoints

	suspend fun createClassification(c: EncryptedClassification): HttpResponse<EncryptedClassification>

	suspend fun getClassification(classificationId: String): HttpResponse<EncryptedClassification>

	suspend fun getClassifications(classificationIds: ListOfIds): HttpResponse<List<EncryptedClassification>>

	suspend fun listClassificationIdsByDataOwnerPatientCreated(
		dataOwnerId: String,
		startDate: Long? = null,
		endDate: Long? = null,
		descending: Boolean? = null,
		secretPatientKeys: ListOfIds,
	): HttpResponse<List<String>>

	suspend fun deleteClassifications(classificationIds: ListOfIds): HttpResponse<List<DocIdentifier>>

	suspend fun deleteClassificationsWithRev(classificationIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun deleteClassification(
		classificationId: String,
		rev: String? = null,
	): HttpResponse<DocIdentifier>

	suspend fun undeleteClassification(
		classificationId: String,
		rev: String,
	): HttpResponse<EncryptedClassification>

	suspend fun purgeClassification(
		classificationId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun modifyClassification(classificationDto: EncryptedClassification): HttpResponse<EncryptedClassification>

	suspend fun findClassificationsDelegationsStubsByIds(classificationIds: ListOfIds): HttpResponse<List<IcureStub>>

	suspend fun matchClassificationBy(filter: AbstractFilter<Classification>): HttpResponse<List<String>>

	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedClassification>>>

	suspend fun bulkShareMinimal(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<Nothing>>>
	// endregion
}
