package com.icure.sdk.api.raw

import com.icure.sdk.model.EncryptedTopic
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.requests.EntityBulkShareResult
import com.icure.sdk.model.requests.topic.AddParticipant
import com.icure.sdk.model.requests.topic.RemoveParticipant
import com.icure.sdk.utils.InternalIcureApi
import kotlin.Int
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawTopicApi {
	// region cloud endpoints

	suspend fun getTopic(topicId: String): HttpResponse<EncryptedTopic>

	suspend fun getTopics(topicIds: ListOfIds): HttpResponse<List<EncryptedTopic>>

	suspend fun createTopic(ft: EncryptedTopic): HttpResponse<EncryptedTopic>

	suspend fun modifyTopic(topicDto: EncryptedTopic): HttpResponse<EncryptedTopic>

	suspend fun deleteTopics(topicIds: ListOfIds): HttpResponse<List<DocIdentifier>>

	suspend fun deleteTopic(topicId: String): HttpResponse<DocIdentifier>

	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedTopic>>>

	suspend fun filterTopicsBy(
		startDocumentId: String? = null,
		limit: Int? = null,
		filterChain: FilterChain<EncryptedTopic>,
	): HttpResponse<PaginatedList<EncryptedTopic>>

	suspend fun matchTopicsBy(filter: AbstractFilter<EncryptedTopic>): HttpResponse<List<String>>

	suspend fun addParticipant(
		topicId: String,
		request: AddParticipant,
	): HttpResponse<EncryptedTopic>

	suspend fun removeParticipant(
		topicId: String,
		request: RemoveParticipant,
	): HttpResponse<EncryptedTopic>
	// endregion
}
