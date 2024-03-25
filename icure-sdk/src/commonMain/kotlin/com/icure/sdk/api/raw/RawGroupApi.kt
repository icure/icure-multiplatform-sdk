package com.icure.sdk.api.raw

import com.icure.sdk.auth.services.AuthService
import com.icure.sdk.auth.services.setAuthorizationWith
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
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawGroupApi(
	private val apiUrl: String,
	private val authService: AuthService,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
) : BaseRawApi(additionalHeaders, timeout) {

	// region cloud endpoints

	suspend fun createGroup(
		id: String,
		name: String,
		type: GroupType? = null,
		password: String,
		server: String? = null,
		q: Int? = null,
		n: Int? = null,
		superGroup: String? = null,
		initialisationData: DatabaseInitialisation,
	): HttpResponse<Group> = post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","group",id)
				parameter("name", name)
				parameter("type", type)
				parameter("server", server)
				parameter("q", q)
				parameter("n", n)
				parameter("superGroup", superGroup)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			header("password", password)
			setBody(initialisationData)
		}.wrap()


	suspend fun registerNewGroupAdministrator(
		type: GroupType? = null,
		role: PermissionType? = null,
		registrationInformation: RegistrationInformation,
	): HttpResponse<RegistrationSuccess> = post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","group","register","trial")
				parameter("type", type)
				parameter("role", role)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(registrationInformation)
		}.wrap()


	suspend fun listGroups(): HttpResponse<List<Group>> = get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","group")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun listApps(): HttpResponse<List<Group>> = get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","group","apps")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun findGroups(
		id: String,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<Group, JsonString>> = get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","group",id,"children")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun findGroupsWithContent(
		id: String,
		searchString: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<Group, JsonString>> = get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","group",id,"children","search")
				parameter("searchString", searchString)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getGroup(id: String): HttpResponse<Group> = get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","group",id)
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getNameOfGroupParent(id: String): HttpResponse<String> = get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","group",id,"parent","name")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun modifyGroupName(id: String, name: String): HttpResponse<Group> = put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","group",id,"name",name)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()


	suspend fun getOperationToken(
		operation: Operation,
		duration: Long?,
		description: String? = null,
	): HttpResponse<String> = post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","group","operationToken")
				parameter("operation", operation)
				parameter("duration", duration)
				parameter("description", description)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()


	suspend fun deleteOperationToken(tokenId: String): HttpResponse<Unit> = delete {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","group","operationToken",tokenId)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun setDefaultRoles(
		groupId: String,
		userType: String,
		roleIds: ListOfIds,
	): HttpResponse<Group> = post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","group",groupId,"defaultRoles")
				parameter("userType", userType)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(roleIds)
		}.wrap()


	suspend fun getDefaultRoles(groupId: String): HttpResponse<Map<UserType, RoleConfiguration>>
			= get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","group",groupId,"defaultRoles")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun changeSuperGroup(childGroupId: String, operationToken: String):
			HttpResponse<Group> = post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","group",childGroupId,"transfer")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			header("Operation-Token", operationToken)
		}.wrap()


	suspend fun deleteGroup(id: String): HttpResponse<Group> = delete {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","group",id)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun hardDeleteGroup(id: String): HttpResponse<List<GroupDeletionReport>> = delete {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","group","hard",id)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun modifyGroupProperties(id: String, properties: ListOfProperties):
			HttpResponse<Group> = put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","group",id,"properties")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(properties)
		}.wrap()


	suspend fun setGroupPassword(id: String, password: String): HttpResponse<Group> = put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","group",id,"password")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			header("password", password)
		}.wrap()


	suspend fun initDesignDocs(
		id: String,
		clazz: String? = null,
		warmup: Boolean?,
		dryRun: Boolean?,
	): HttpResponse<List<DesignDocument>> = put {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","group",id,"dd")
				parameter("clazz", clazz)
				parameter("warmup", warmup)
				parameter("dryRun", dryRun)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()


	suspend fun solveConflicts(
		id: String,
		limit: Int?,
		warmup: Boolean?,
	): HttpResponse<List<IdWithRev>> = post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","group",id,"conflicts")
				parameter("limit", limit)
				parameter("warmup", warmup)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
		}.wrap()


	suspend fun resetStorage(
		id: String,
		q: Int? = null,
		n: Int? = null,
		databases: ListOfIds,
	): HttpResponse<Unit> = post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","group",id,"reset","storage")
				parameter("q", q)
				parameter("n", n)
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(databases)
		}.wrap()


	suspend fun getGroupsStorageInfos(groups: ListOfIds): HttpResponse<List<GroupDatabasesInfo>>
			= post {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","group","storage","info")
			}
			setAuthorizationWith(authService)
			contentType(ContentType.Application.Json)
			setBody(groups)
		}.wrap()


	suspend fun getReplicationInfo(id: String): HttpResponse<ReplicationInfo> = get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","group",id,"r")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun getHierarchy(id: String): HttpResponse<List<String>> = get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","group",id,"hierarchy")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()


	suspend fun listAllGroupsIds(): HttpResponse<List<DocIdentifier>> = get {
			url {
				host = apiUrl
				appendPathSegments("rest","v2","group","all")
				parameter("ts", GMTDate().timestamp)
			}
			setAuthorizationWith(authService)
		}.wrap()

	// endregion

}
