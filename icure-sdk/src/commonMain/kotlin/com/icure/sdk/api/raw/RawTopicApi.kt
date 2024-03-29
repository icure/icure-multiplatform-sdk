package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
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
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import kotlin.Int
import kotlin.Nothing
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawTopicApi(
	private val apiUrl: String,
	private val authService: AuthService,
	private val accessControlKeysHeadersProvider: AccessControlKeysHeadersProvider?,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(additionalHeaders, timeout) {

	// region cloud endpoints

	suspend fun getTopic(topicId: String): HttpResponse<EncryptedTopic> = get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","topic",topicId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getTopics(topicIds: ListOfIds): HttpResponse<List<EncryptedTopic>> = post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","topic","byIds")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(topicIds)
		}.wrap()


	suspend fun createTopic(ft: Topic): HttpResponse<EncryptedTopic> = post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","topic")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(ft)
		}.wrap()


	suspend fun modifyTopic(topicDto: Topic): HttpResponse<EncryptedTopic> = put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","topic")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(topicDto)
		}.wrap()


	suspend fun deleteTopics(topicIds: ListOfIds): HttpResponse<List<DocIdentifier>> = post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","topic","delete","batch")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(topicIds)
		}.wrap()


	suspend fun deleteTopic(topicId: String): HttpResponse<DocIdentifier> = delete {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","topic",topicId)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams):
			HttpResponse<List<EntityBulkShareResult<EncryptedTopic>>> = put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","topic","bulkSharedMetadataUpdate")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(request)
		}.wrap()


	suspend fun filterTopicsBy(
		startDocumentId: String? = null,
		limit: Int? = null,
		filterChain: FilterChain<Topic>,
	): HttpResponse<PaginatedList<EncryptedTopic, Nothing>> = post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","topic","filter")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(filterChain)
		}.wrap()


	suspend fun matchTopicsBy(filter: AbstractFilter<Topic>): HttpResponse<List<String>> =
			post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","topic","match")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(filter)
		}.wrap()


	suspend fun addParticipant(topicId: String, request: AddParticipant):
			HttpResponse<EncryptedTopic> = post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","topic",topicId,"addParticipant")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(request)
		}.wrap()


	suspend fun removeParticipant(topicId: String, request: RemoveParticipant):
			HttpResponse<EncryptedTopic> = post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest","v2","topic",topicId,"removeParticipant")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(request)
		}.wrap()

	// endregion

}
