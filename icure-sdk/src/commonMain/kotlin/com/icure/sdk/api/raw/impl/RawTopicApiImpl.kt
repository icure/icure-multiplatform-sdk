package com.icure.sdk.api.raw.`impl`

import com.icure.sdk.api.raw.BaseRawApi
import com.icure.sdk.api.raw.HttpResponse
import com.icure.sdk.api.raw.RawTopicApi
import com.icure.sdk.api.raw.wrap
import com.icure.sdk.auth.services.AuthProvider
import com.icure.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.sdk.model.EncryptedTopic
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.Topic
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.requests.EntityBulkShareResult
import com.icure.sdk.model.requests.topic.AddParticipant
import com.icure.sdk.model.requests.topic.RemoveParticipant
import com.icure.sdk.serialization.FilterChainSerializer
import com.icure.sdk.serialization.TopicAbstractFilterSerializer
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.request.accept
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType.Application
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import kotlinx.serialization.json.Json
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawTopicApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	private val accessControlKeysHeadersProvider: AccessControlKeysHeadersProvider?,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
	json: Json,
) : BaseRawApi(httpClient, additionalHeaders, timeout, json), RawTopicApi {
	// region cloud endpoints

	override suspend fun getTopic(topicId: String): HttpResponse<EncryptedTopic> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", topicId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getTopics(topicIds: ListOfIds): HttpResponse<List<EncryptedTopic>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(topicIds)
		}.wrap()

	override suspend fun createTopic(ft: EncryptedTopic): HttpResponse<EncryptedTopic> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(ft)
		}.wrap()

	override suspend fun modifyTopic(topicDto: EncryptedTopic): HttpResponse<EncryptedTopic> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(topicDto)
		}.wrap()

	override suspend fun deleteTopics(topicIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(topicIds)
		}.wrap()

	override suspend fun deleteTopic(topicId: String): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", topicId)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedTopic>>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", "bulkSharedMetadataUpdate")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun filterTopicsBy(
		startDocumentId: String?,
		limit: Int?,
		filterChain: FilterChain<Topic>,
	): HttpResponse<PaginatedList<EncryptedTopic>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", "filter")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(FilterChainSerializer(TopicAbstractFilterSerializer), filterChain)
		}.wrap()

	override suspend fun matchTopicsBy(filter: AbstractFilter<Topic>): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(TopicAbstractFilterSerializer, filter)
		}.wrap()

	override suspend fun matchTopicsBy(
		groupId: String,
		filter: AbstractFilter<Topic>,
	): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", "inGroup", groupId, "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(TopicAbstractFilterSerializer, filter)
		}.wrap()

	override suspend fun addParticipant(
		topicId: String,
		request: AddParticipant,
	): HttpResponse<EncryptedTopic> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", topicId, "addParticipant")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun removeParticipant(
		topicId: String,
		request: RemoveParticipant,
	): HttpResponse<EncryptedTopic> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "topic", topicId, "removeParticipant")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	// endregion
}
