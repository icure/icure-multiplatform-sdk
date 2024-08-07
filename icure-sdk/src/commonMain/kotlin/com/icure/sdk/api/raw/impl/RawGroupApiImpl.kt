package com.icure.sdk.api.raw.`impl`

import com.icure.sdk.api.raw.BaseRawApi
import com.icure.sdk.api.raw.HttpResponse
import com.icure.sdk.api.raw.RawGroupApi
import com.icure.sdk.api.raw.wrap
import com.icure.sdk.auth.services.AuthProvider
import com.icure.sdk.model.DatabaseInitialisation
import com.icure.sdk.model.Group
import com.icure.sdk.model.GroupDeletionReport
import com.icure.sdk.model.IdWithRev
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.ListOfProperties
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.RegistrationInformation
import com.icure.sdk.model.RegistrationSuccess
import com.icure.sdk.model.ReplicationInfo
import com.icure.sdk.model.couchdb.DesignDocument
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.couchdb.GroupDatabasesInfo
import com.icure.sdk.model.embed.GroupType
import com.icure.sdk.model.embed.RoleConfiguration
import com.icure.sdk.model.embed.UserType
import com.icure.sdk.model.security.Operation
import com.icure.sdk.model.security.PermissionType
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.request.accept
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType.Application
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import kotlinx.serialization.json.Json
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawGroupApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
	json: Json,
) : BaseRawApi(httpClient, additionalHeaders, timeout, json), RawGroupApi {
	// region cloud endpoints

	override suspend fun createGroup(
		id: String,
		name: String,
		type: GroupType?,
		password: String,
		server: String?,
		q: Int?,
		n: Int?,
		superGroup: String?,
		applicationId: String?,
		initialisationData: DatabaseInitialisation,
	): HttpResponse<Group> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "group", id)
				parameter("name", name)
				parameter("type", type)
				parameter("server", server)
				parameter("q", q)
				parameter("n", n)
				parameter("superGroup", superGroup)
				parameter("applicationId", applicationId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			`header`("password", password)
			setBody(initialisationData)
		}.wrap()

	override suspend fun registerNewGroupAdministrator(
		type: GroupType?,
		role: PermissionType?,
		registrationInformation: RegistrationInformation,
	): HttpResponse<RegistrationSuccess> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "group", "register", "trial")
				parameter("type", type)
				parameter("role", role)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(registrationInformation)
		}.wrap()

	override suspend fun listGroups(): HttpResponse<List<Group>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "group")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun listApps(): HttpResponse<List<Group>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "group", "apps")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun findGroups(
		id: String,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<Group>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "group", id, "children")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun findGroupsWithContent(
		id: String,
		searchString: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<Group>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "group", id, "children", "search")
				parameter("searchString", searchString)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getGroup(id: String): HttpResponse<Group> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "group", id)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getNameOfGroupParent(id: String): HttpResponse<String> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "group", id, "parent", "name")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun modifyGroupName(
		id: String,
		name: String,
	): HttpResponse<Group> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "group", id, "name", name)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun modifyGroupApplicationId(
		id: String,
		applicationId: String,
	): HttpResponse<Group> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "group", id, "applicationId", applicationId)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun getOperationToken(
		operation: Operation,
		duration: Long?,
		description: String?,
	): HttpResponse<String> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "group", "operationToken")
				parameter("operation", operation)
				parameter("duration", duration)
				parameter("description", description)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun deleteOperationToken(tokenId: String): HttpResponse<Unit> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "group", "operationToken", tokenId)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun setDefaultRoles(
		groupId: String,
		userType: String,
		roleIds: ListOfIds,
	): HttpResponse<Group> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "group", groupId, "defaultRoles")
				parameter("userType", userType)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(roleIds)
		}.wrap()

	override suspend fun getDefaultRoles(groupId: String): HttpResponse<Map<UserType, List<RoleConfiguration>>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "group", groupId, "defaultRoles")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun changeSuperGroup(
		childGroupId: String,
		operationToken: String,
	): HttpResponse<Group> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "group", childGroupId, "transfer")
			}
			contentType(Application.Json)
			accept(Application.Json)
			`header`("Operation-Token", operationToken)
		}.wrap()

	override suspend fun deleteGroup(id: String): HttpResponse<Group> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "group", id)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun hardDeleteGroup(id: String): HttpResponse<List<GroupDeletionReport>> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "group", "hard", id)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun modifyGroupProperties(
		id: String,
		properties: ListOfProperties,
	): HttpResponse<Group> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "group", id, "properties")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(properties)
		}.wrap()

	override suspend fun setGroupPassword(
		id: String,
		password: String,
	): HttpResponse<Group> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "group", id, "password")
			}
			contentType(Application.Json)
			accept(Application.Json)
			`header`("password", password)
		}.wrap()

	override suspend fun initDesignDocs(
		id: String,
		clazz: String?,
		warmup: Boolean?,
		dryRun: Boolean?,
	): HttpResponse<List<DesignDocument>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "group", id, "dd")
				parameter("clazz", clazz)
				parameter("warmup", warmup)
				parameter("dryRun", dryRun)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun solveConflicts(
		groupId: String,
		limit: Int?,
		warmup: Boolean?,
	): HttpResponse<List<IdWithRev>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "group", groupId, "conflicts")
				parameter("limit", limit)
				parameter("warmup", warmup)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun resetStorage(
		id: String,
		q: Int?,
		n: Int?,
		databases: ListOfIds,
	): HttpResponse<Unit> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "group", id, "reset", "storage")
				parameter("q", q)
				parameter("n", n)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(databases)
		}.wrap()

	override suspend fun getGroupsStorageInfos(groups: ListOfIds): HttpResponse<List<GroupDatabasesInfo>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "group", "storage", "info")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(groups)
		}.wrap()

	override suspend fun getReplicationInfo(id: String): HttpResponse<ReplicationInfo> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "group", id, "r")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getHierarchy(id: String): HttpResponse<List<String>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "group", id, "hierarchy")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun listAllGroupsIds(): HttpResponse<List<DocIdentifier>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "group", "all")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	// endregion
}
