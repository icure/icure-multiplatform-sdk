package com.icure.sdk.api.raw

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
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawUserApi {
	// region common endpoints

	suspend fun getCurrentUser(): HttpResponse<User>

	suspend fun listUsersBy(
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		skipPatients: Boolean? = null,
	): HttpResponse<PaginatedList<User>>

	suspend fun createUser(userDto: User): HttpResponse<User>

	suspend fun getUser(userId: String): HttpResponse<User>

	suspend fun getUserByEmail(email: String): HttpResponse<User>

	suspend fun getUserByPhoneNumber(phoneNumber: String): HttpResponse<User>

	suspend fun findByHcpartyId(id: String): HttpResponse<List<String>>

	suspend fun findByPatientId(id: String): HttpResponse<List<String>>

	suspend fun deleteUser(userId: String): HttpResponse<DocIdentifier>

	suspend fun modifyUser(userDto: User): HttpResponse<User>

	suspend fun assignHealthcareParty(healthcarePartyId: String): HttpResponse<User>

	suspend fun modifyProperties(
		userId: String,
		properties: List<EncryptedPropertyStub>?,
	): HttpResponse<User>

	suspend fun getToken(
		userId: String,
		key: String,
		tokenValidity: Long? = null,
		token: String? = null,
	): HttpResponse<String>

	suspend fun filterUsersBy(
		startDocumentId: String? = null,
		limit: Int? = null,
		filterChain: FilterChain<User>,
	): HttpResponse<PaginatedList<User>>

	suspend fun matchUsersBy(filter: AbstractFilter<User>): HttpResponse<List<String>>
	// endregion

	// region cloud endpoints

	suspend fun getMatchingUsers(): HttpResponse<List<UserGroup>>

	suspend fun listUsersInGroup(
		groupId: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<User>>

	suspend fun createUserInGroup(
		groupId: String,
		userDto: User,
	): HttpResponse<User>

	suspend fun modifyUserInGroup(
		groupId: String,
		userDto: User,
	): HttpResponse<User>

	suspend fun deleteUserInGroup(
		groupId: String,
		userId: String,
	): HttpResponse<DocIdentifier>

	suspend fun addRolesToUser(
		userId: String,
		rolesId: ListOfIds,
	): HttpResponse<User>

	suspend fun addRolesToUserInGroup(
		userId: String,
		groupId: String,
		rolesId: ListOfIds,
	): HttpResponse<User>

	suspend fun removeRolesFromUser(userId: String): HttpResponse<User>

	suspend fun removeRolesFromUserInGroup(
		userId: String,
		groupId: String,
	): HttpResponse<User>

	suspend fun getTokenInGroup(
		groupId: String,
		userId: String,
		key: String,
		token: String? = null,
		tokenValidity: Long? = null,
	): HttpResponse<String>

	suspend fun getTokenInAllGroups(
		userIdentifier: String,
		key: String,
		token: String? = null,
		tokenValidity: Long? = null,
	): HttpResponse<List<TokenWithGroup>>

	suspend fun filterUsersInGroupBy(
		groupId: String,
		startDocumentId: String? = null,
		limit: Int? = null,
		filterChain: FilterChain<User>,
	): HttpResponse<PaginatedList<User>>

	suspend fun enable2faForUser(
		userId: String,
		groupId: String,
		request: Enable2faRequest,
	): HttpResponse<Unit>

	suspend fun disable2faForUser(
		userId: String,
		groupId: String,
	): HttpResponse<Unit>

	suspend fun enable2faForUser(
		userId: String,
		request: Enable2faRequest,
	): HttpResponse<Unit>

	suspend fun disable2faForUser(userId: String): HttpResponse<Unit>

	suspend fun createAdminUser(userDto: User): HttpResponse<User>

	suspend fun createAdminUserInGroup(
		groupId: String,
		userDto: User,
	): HttpResponse<User>
	// endregion
}
