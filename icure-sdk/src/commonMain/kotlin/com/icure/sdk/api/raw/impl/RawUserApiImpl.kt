package com.icure.sdk.api.raw.`impl`

import com.icure.sdk.api.raw.BaseRawApi
import com.icure.sdk.api.raw.HttpResponse
import com.icure.sdk.api.raw.RawUserApi
import com.icure.sdk.api.raw.wrap
import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.EncryptedPropertyStub
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.User
import com.icure.sdk.model.UserGroup
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.security.Enable2faRequest
import com.icure.sdk.model.security.TokenWithGroup
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.request.`header`
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawUserApiImpl(
	private val apiUrl: String,
	private val authService: AuthService,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(httpClient, additionalHeaders, timeout), RawUserApi {
	// region common endpoints

	override suspend fun getCurrentUser(): HttpResponse<User> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "current")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun listUsersBy(
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		skipPatients: Boolean?,
	): HttpResponse<PaginatedList<User>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user")
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("skipPatients", skipPatients)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun createUser(userDto: User): HttpResponse<User> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(userDto)
		}.wrap()

	override suspend fun getUser(userId: String): HttpResponse<User> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", userId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun getUserByEmail(email: String): HttpResponse<User> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "byEmail", email)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun getUserByPhoneNumber(phoneNumber: String): HttpResponse<User> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "byPhoneNumber", phoneNumber)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun findByHcpartyId(id: String): HttpResponse<List<String>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "byHealthcarePartyId", id)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun findByPatientId(id: String): HttpResponse<List<String>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "byPatientId", id)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun deleteUser(userId: String): HttpResponse<DocIdentifier> =
		delete {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", userId)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun modifyUser(userDto: User): HttpResponse<User> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(userDto)
		}.wrap()

	override suspend fun assignHealthcareParty(healthcarePartyId: String): HttpResponse<User> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "current", "hcparty", healthcarePartyId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()

	override suspend fun modifyProperties(
		userId: String,
		properties: List<EncryptedPropertyStub>?,
	): HttpResponse<User> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", userId, "properties")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(properties)
		}.wrap()

	override suspend fun getToken(
		userId: String,
		key: String,
		tokenValidity: Long?,
		token: String?,
	): HttpResponse<String> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "token", userId, key)
				parameter("tokenValidity", tokenValidity)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			header("token", token)
		}.wrap()

	override suspend fun filterUsersBy(
		startDocumentId: String?,
		limit: Int?,
		filterChain: FilterChain<User>,
	): HttpResponse<PaginatedList<User>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "filter")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(filterChain)
		}.wrap()

	override suspend fun matchUsersBy(filter: AbstractFilter<User>): HttpResponse<List<String>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "match")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(filter)
		}.wrap()

	// endregion

	// region cloud endpoints

	override suspend fun getMatchingUsers(): HttpResponse<List<UserGroup>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "matches")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun listUsersInGroup(
		groupId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<User>> =
		get {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "inGroup", groupId)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun createUserInGroup(
		groupId: String,
		userDto: User,
	): HttpResponse<User> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "inGroup", groupId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(userDto)
		}.wrap()

	override suspend fun modifyUserInGroup(
		groupId: String,
		userDto: User,
	): HttpResponse<User> =
		put {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "inGroup", groupId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(userDto)
		}.wrap()

	override suspend fun deleteUserInGroup(
		groupId: String,
		userId: String,
	): HttpResponse<DocIdentifier> =
		delete {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "inGroup", groupId, userId)
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun addRolesToUser(
		userId: String,
		rolesId: ListOfIds,
	): HttpResponse<User> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", userId, "roles", "set")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(rolesId)
		}.wrap()

	override suspend fun addRolesToUserInGroup(
		userId: String,
		groupId: String,
		rolesId: ListOfIds,
	): HttpResponse<User> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", userId, "inGroup", groupId, "roles", "set")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(rolesId)
		}.wrap()

	override suspend fun removeRolesFromUser(userId: String): HttpResponse<User> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", userId, "roles", "reset")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()

	override suspend fun removeRolesFromUserInGroup(
		userId: String,
		groupId: String,
	): HttpResponse<User> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", userId, "inGroup", groupId, "roles", "reset")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()

	override suspend fun getTokenInGroup(
		groupId: String,
		userId: String,
		key: String,
		token: String?,
		tokenValidity: Long?,
	): HttpResponse<String> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "inGroup", groupId, "token", userId, key)
				parameter("tokenValidity", tokenValidity)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			header("token", token)
		}.wrap()

	override suspend fun getTokenInAllGroups(
		userIdentifier: String,
		key: String,
		token: String?,
		tokenValidity: Long?,
	): HttpResponse<List<TokenWithGroup>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "inAllGroups", "token", userIdentifier, key)
				parameter("tokenValidity", tokenValidity)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			header("token", token)
		}.wrap()

	override suspend fun filterUsersInGroupBy(
		groupId: String,
		startDocumentId: String?,
		limit: Int?,
		filterChain: FilterChain<User>,
	): HttpResponse<PaginatedList<User>> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "filter", "inGroup", groupId)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(filterChain)
		}.wrap()

	override suspend fun enable2faForUser(
		userId: String,
		groupId: String,
		request: Enable2faRequest,
	): HttpResponse<Unit> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", userId, "inGroup", groupId, "2fa")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun disable2faForUser(
		userId: String,
		groupId: String,
	): HttpResponse<Unit> =
		delete {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", userId, "inGroup", groupId, "2fa")
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun enable2faForUser(
		userId: String,
		request: Enable2faRequest,
	): HttpResponse<Unit> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", userId, "2fa")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun disable2faForUser(userId: String): HttpResponse<Unit> =
		delete {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", userId, "2fa")
			}
			setAuthorizationWith(authService)
		}.wrap()

	override suspend fun createAdminUser(userDto: User): HttpResponse<User> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "admin")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(userDto)
		}.wrap()

	override suspend fun createAdminUserInGroup(
		groupId: String,
		userDto: User,
	): HttpResponse<User> =
		post {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "admin", "inGroup", groupId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(userDto)
		}.wrap()

	// endregion
}
