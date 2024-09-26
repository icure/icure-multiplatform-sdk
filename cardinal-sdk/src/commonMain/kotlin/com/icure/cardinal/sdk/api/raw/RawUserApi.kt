package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.EncryptedPropertyStub
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.UserGroup
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.chain.FilterChain
import com.icure.cardinal.sdk.model.security.Enable2faRequest
import com.icure.cardinal.sdk.model.security.TokenWithGroup
import com.icure.utils.InternalIcureApi
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

	suspend fun getUsers(userIds: ListOfIds): HttpResponse<List<User>>

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

	suspend fun listUsersInAllGroups(
		username: String? = null,
		email: String? = null,
		phone: String? = null,
	): HttpResponse<List<User>>

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

	suspend fun setRolesForUser(
		userId: String,
		rolesId: ListOfIds,
	): HttpResponse<User>

	suspend fun setRolesForUserInGroup(
		userId: String,
		groupId: String,
		rolesId: ListOfIds,
	): HttpResponse<User>

	suspend fun resetUserRoles(userId: String): HttpResponse<User>

	suspend fun resetUserRolesInGroup(
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

	suspend fun getUsersInGroup(
		groupId: String,
		userIds: ListOfIds,
	): HttpResponse<List<User>>

	suspend fun matchUsersInGroupBy(
		groupId: String,
		filter: AbstractFilter<User>,
	): HttpResponse<List<String>>

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

	suspend fun matchUsersBy(
		groupId: String,
		filter: AbstractFilter<User>,
	): HttpResponse<List<String>>
	// endregion
}
