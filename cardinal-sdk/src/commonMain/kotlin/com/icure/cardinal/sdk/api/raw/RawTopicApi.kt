package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.EncryptedTopic
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.Topic
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.chain.FilterChain
import com.icure.cardinal.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.cardinal.sdk.model.requests.EntityBulkShareResult
import com.icure.cardinal.sdk.model.requests.topic.AddParticipant
import com.icure.cardinal.sdk.model.requests.topic.RemoveParticipant
import com.icure.utils.InternalIcureApi
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

	suspend fun deleteTopicsWithRev(topicIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun deleteTopic(topicId: String): HttpResponse<DocIdentifier>

	suspend fun undeleteTopic(topicId: String): HttpResponse<EncryptedTopic>

	suspend fun purgeTopic(topicId: String): HttpResponse<DocIdentifier>

	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedTopic>>>

	suspend fun filterTopicsBy(
		startDocumentId: String? = null,
		limit: Int? = null,
		filterChain: FilterChain<Topic>,
	): HttpResponse<PaginatedList<EncryptedTopic>>

	suspend fun matchTopicsBy(filter: AbstractFilter<Topic>): HttpResponse<List<String>>

	suspend fun matchTopicsBy(
		groupId: String,
		filter: AbstractFilter<Topic>,
	): HttpResponse<List<String>>

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
