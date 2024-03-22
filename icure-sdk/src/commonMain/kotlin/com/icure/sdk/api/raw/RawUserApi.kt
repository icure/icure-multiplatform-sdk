package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.PropertyStub
import com.icure.sdk.model.User
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.specializations.JsonString
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.request.`get`
import io.ktor.client.request.`header`
import io.ktor.client.request.delete
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.util.date.GMTDate
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.UserGroup
import com.icure.sdk.model.security.Enable2faRequest
import com.icure.sdk.model.security.TokenWithGroup
import kotlin.Nothing
import kotlin.Unit

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawUserApi(
	private val apiUrl: String,
	private val authService: AuthService,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(additionalHeaders, timeout) {

	// region common endpoints

	suspend fun getCurrentUser(): HttpResponse<User> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","user","current")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun listUsersBy(
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		skipPatients: Boolean? = null,
	): HttpResponse<PaginatedList<User, JsonString>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","user")
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("skipPatients", skipPatients)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun createUser(userDto: User): HttpResponse<User> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","user")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(userDto)
		}.wrap()


	suspend fun getUser(userId: String): HttpResponse<User> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","user",userId)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getUserByEmail(email: String): HttpResponse<User> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","user","byEmail",email)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getUserByPhoneNumber(phoneNumber: String): HttpResponse<User> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","user","byPhoneNumber",phoneNumber)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun findByHcpartyId(id: String): HttpResponse<List<String>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","user","byHealthcarePartyId",id)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun findByPatientId(id: String): HttpResponse<List<String>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","user","byPatientId",id)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun deleteUser(userId: String): HttpResponse<DocIdentifier> = httpClient.delete {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","user",userId)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun modifyUser(userDto: User): HttpResponse<User> = httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","user")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(userDto)
		}.wrap()


	suspend fun assignHealthcareParty(healthcarePartyId: String): HttpResponse<User> =
			httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","user","current","hcparty",healthcarePartyId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()


	suspend fun modifyProperties(userId: String, properties: List<PropertyStub>?):
			HttpResponse<User> = httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","user",userId,"properties")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(properties)
		}.wrap()


	suspend fun getToken(
		userId: String,
		key: String,
		tokenValidity: Long? = null,
		token: String? = null,
	): HttpResponse<String> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","user","token",userId,key)
				parameter("tokenValidity", tokenValidity)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			header("token", token)
		}.wrap()


	suspend fun filterUsersBy(
		startDocumentId: String? = null,
		limit: Int? = null,
		filterChain: FilterChain<User>,
	): HttpResponse<PaginatedList<User, *>> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","user","filter")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(filterChain)
		}.wrap()


	suspend fun matchUsersBy(filter: AbstractFilter<User>): HttpResponse<List<String>> =
			httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","user","match")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(filter)
		}.wrap()

	// endregion

	// region cloud endpoints

	suspend fun getMatchingUsers(): HttpResponse<List<UserGroup>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","user","matches")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun listUsersInGroup(
		groupId: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<User, JsonString>> = httpClient.get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","user","inGroup",groupId)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun createUserInGroup(groupId: String, userDto: User): HttpResponse<User> =
			httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","user","inGroup",groupId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(userDto)
		}.wrap()


	suspend fun modifyUserInGroup(groupId: String, userDto: User): HttpResponse<User> =
			httpClient.put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","user","inGroup",groupId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(userDto)
		}.wrap()


	suspend fun deleteUserInGroup(groupId: String, userId: String): HttpResponse<DocIdentifier>
			= httpClient.delete {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","user","inGroup",groupId,userId)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun addRolesToUser(userId: String, rolesId: ListOfIds): HttpResponse<User> =
			httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","user",userId,"roles","set")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(rolesId)
		}.wrap()


	suspend fun addRolesToUserInGroup(
		userId: String,
		groupId: String,
		rolesId: ListOfIds,
	): HttpResponse<User> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","user",userId,"inGroup",groupId,"roles","set")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(rolesId)
		}.wrap()


	suspend fun removeRolesFromUser(userId: String): HttpResponse<User> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","user",userId,"roles","reset")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()


	suspend fun removeRolesFromUserInGroup(userId: String, groupId: String): HttpResponse<User>
			= httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","user",userId,"inGroup",groupId,"roles","reset")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()


	suspend fun getTokenInGroup(
		groupId: String,
		userId: String,
		key: String,
		token: String? = null,
		tokenValidity: Long? = null,
	): HttpResponse<String> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","user","inGroup",groupId,"token",userId,key)
				parameter("tokenValidity", tokenValidity)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			header("token", token)
		}.wrap()


	suspend fun getTokenInAllGroups(
		userIdentifier: String,
		key: String,
		token: String? = null,
		tokenValidity: Long? = null,
	): HttpResponse<List<TokenWithGroup>> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","user","inAllGroups","token",userIdentifier,key)
				parameter("tokenValidity", tokenValidity)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			header("token", token)
		}.wrap()


	suspend fun filterUsersInGroupBy(
		groupId: String,
		startDocumentId: String? = null,
		limit: Int? = null,
		filterChain: FilterChain<User>,
	): HttpResponse<PaginatedList<User, Nothing>> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","user","filter","inGroup",groupId)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(filterChain)
		}.wrap()


	suspend fun enable2faForUser(
		userId: String,
		groupId: String,
		request: Enable2faRequest,
	): HttpResponse<Unit> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","user",userId,"inGroup",groupId,"2fa")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(request)
		}.wrap()


	suspend fun enable2faForUser(userId: String, request: Enable2faRequest): HttpResponse<Unit>
			= httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","user",userId,"2fa")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(request)
		}.wrap()


	suspend fun disable2faForUser(userId: String, groupId: String): HttpResponse<Unit> =
			httpClient.delete {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","user",userId,"inGroup",groupId,"2fa")
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun disable2faForUser(userId: String): HttpResponse<Unit> = httpClient.delete {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","user",userId,"2fa")
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun createAdminUser(userDto: User): HttpResponse<User> = httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","user","admin")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(userDto)
		}.wrap()


	suspend fun createAdminUserInGroup(groupId: String, userDto: User): HttpResponse<User> =
			httpClient.post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","user","admin","inGroup",groupId)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(userDto)
		}.wrap()

	// endregion

}