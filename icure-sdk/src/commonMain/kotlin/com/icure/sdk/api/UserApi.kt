package com.icure.sdk.api

import com.icure.sdk.api.raw.RawPermissionApi
import com.icure.sdk.api.raw.RawUserApi
import com.icure.sdk.model.EncryptedPropertyStub
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.User
import com.icure.sdk.model.UserGroup
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.security.Enable2faRequest
import com.icure.sdk.model.security.Permission
import com.icure.sdk.model.security.TokenWithGroup
import com.icure.sdk.utils.InternalIcureApi

interface UserApi {
	suspend fun getCurrentUser(): User
	suspend fun listUsersBy(
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		skipPatients: Boolean? = null,
	): PaginatedList<User>

	suspend fun createUser(user: User): User
	suspend fun getUser(userId: String): User
	suspend fun getUserByEmail(email: String): User
	suspend fun getUserByPhoneNumber(phoneNumber: String): User
	suspend fun findByHcpartyId(id: String): List<String>
	suspend fun findByPatientId(id: String): List<String>
	suspend fun deleteUser(userId: String): DocIdentifier
	suspend fun modifyUser(user: User): User
	suspend fun assignHealthcareParty(healthcarePartyId: String): User
	suspend fun modifyProperties(
		userId: String,
		properties: List<EncryptedPropertyStub>?,
	): User

	suspend fun getToken(
		userId: String,
		key: String,
		tokenValidity: Long? = null,
		token: String? = null,
	): String

	suspend fun filterUsersBy(
		startDocumentId: String? = null,
		limit: Int? = null,
		filterChain: FilterChain<User>,
	): PaginatedList<User>

	suspend fun matchUsersBy(filter: AbstractFilter<User>): List<String>
	suspend fun getMatchingUsers(): List<UserGroup>
	suspend fun listUsersInGroup(
		groupId: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): PaginatedList<User>

	suspend fun createUserInGroup(
		groupId: String,
		user: User,
	): User

	suspend fun modifyUserInGroup(
		groupId: String,
		user: User,
	): User

	suspend fun deleteUserInGroup(
		groupId: String,
		userId: String,
	): DocIdentifier

	suspend fun addRolesToUser(
		userId: String,
		rolesId: ListOfIds,
	): User

	suspend fun addRolesToUserInGroup(
		userId: String,
		groupId: String,
		rolesId: ListOfIds,
	): User

	suspend fun removeRolesFromUser(userId: String): User
	suspend fun removeRolesFromUserInGroup(
		userId: String,
		groupId: String,
	): User

	suspend fun getTokenInGroup(
		groupId: String,
		userId: String,
		key: String,
		token: String? = null,
		tokenValidity: Long? = null,
	): String

	suspend fun getTokenInAllGroups(
		userIdentifier: String,
		key: String,
		token: String? = null,
		tokenValidity: Long? = null,
	): List<TokenWithGroup>

	suspend fun filterUsersInGroupBy(
		groupId: String,
		startDocumentId: String? = null,
		limit: Int? = null,
		filterChain: FilterChain<User>,
	): PaginatedList<User>

	suspend fun enable2faForUser(
		userId: String,
		groupId: String,
		request: Enable2faRequest,
	)

	suspend fun enable2faForUser(
		userId: String,
		request: Enable2faRequest,
	)

	suspend fun disable2faForUser(
		userId: String,
		groupId: String,
	)

	suspend fun disable2faForUser(userId: String)
	suspend fun createAdminUser(user: User): User
	suspend fun createAdminUserInGroup(
		groupId: String,
		user: User,
	): User

}

@InternalIcureApi
internal class UserApiImpl(
	private val raw: RawUserApi,
	private val rawPermissionApi: RawPermissionApi,
) : UserApi {

	override suspend fun getCurrentUser(): User =
		raw.getCurrentUser().successBody()


	override suspend fun listUsersBy(
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		skipPatients: Boolean?,
	) =
		raw.listUsersBy(
			startKey = startKey,
			startDocumentId = startDocumentId,
			limit = limit,
			skipPatients = skipPatients,
		).successBody()


	override suspend fun createUser(user: User) =
		raw.createUser(user).successBody()


	override suspend fun getUser(userId: String) = raw.getUser(userId).successBody()


	override suspend fun getUserByEmail(email: String) = raw.getUserByEmail(email).successBody()


	override suspend fun getUserByPhoneNumber(phoneNumber: String) = raw.getUserByPhoneNumber(phoneNumber).successBody()


	override suspend fun findByHcpartyId(id: String) = raw.findByHcpartyId(id).successBody()


	override suspend fun findByPatientId(id: String) = raw.findByPatientId(id).successBody()

	override suspend fun deleteUser(userId: String) = raw.deleteUser(userId).successBody()

	override suspend fun modifyUser(user: User) = raw.modifyUser(user).successBody()

	override suspend fun assignHealthcareParty(healthcarePartyId: String) = raw.assignHealthcareParty(healthcarePartyId).successBody()

	override suspend fun modifyProperties(
		userId: String,
		properties: List<EncryptedPropertyStub>?,
	) = raw.modifyProperties(userId, properties).successBody()

	override suspend fun getToken(
		userId: String,
		key: String,
		tokenValidity: Long?,
		token: String?,
	) = raw.getToken(userId, key, tokenValidity, token).successBody()

	override suspend fun filterUsersBy(
		startDocumentId: String?,
		limit: Int?,
		filterChain: FilterChain<User>,
	) = raw.filterUsersBy(startDocumentId, limit, filterChain).successBody()

	override suspend fun matchUsersBy(filter: AbstractFilter<User>) = raw.matchUsersBy(filter).successBody()

	override suspend fun getMatchingUsers() = raw.getMatchingUsers().successBody()

	override suspend fun listUsersInGroup(
		groupId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	) = raw.listUsersInGroup(groupId, startKey, startDocumentId, limit).successBody()

	override suspend fun createUserInGroup(
		groupId: String,
		user: User,
	) = raw.createUserInGroup(groupId, user).successBody()

	override suspend fun modifyUserInGroup(
		groupId: String,
		user: User,
	) = raw.modifyUserInGroup(groupId, user).successBody()

	override suspend fun deleteUserInGroup(
		groupId: String,
		userId: String,
	) = raw.deleteUserInGroup(groupId, userId).successBody()

	override suspend fun addRolesToUser(
		userId: String,
		rolesId: ListOfIds,
	) = raw.addRolesToUser(userId, rolesId).successBody()

	override suspend fun addRolesToUserInGroup(
		userId: String,
		groupId: String,
		rolesId: ListOfIds,
	) = raw.addRolesToUserInGroup(userId, groupId, rolesId).successBody()

	override suspend fun removeRolesFromUser(userId: String) = raw.removeRolesFromUser(userId).successBody()

	override suspend fun removeRolesFromUserInGroup(
		userId: String,
		groupId: String,
	) = raw.removeRolesFromUserInGroup(userId, groupId).successBody()

	override suspend fun getTokenInGroup(
		groupId: String,
		userId: String,
		key: String,
		token: String?,
		tokenValidity: Long?,
	) = raw.getTokenInGroup(groupId, userId, key, token, tokenValidity).successBody()

	override suspend fun getTokenInAllGroups(
		userIdentifier: String,
		key: String,
		token: String?,
		tokenValidity: Long?,
	) = raw.getTokenInAllGroups(userIdentifier, key, token, tokenValidity).successBody()

	override suspend fun filterUsersInGroupBy(
		groupId: String,
		startDocumentId: String?,
		limit: Int?,
		filterChain: FilterChain<User>,
	) = raw.filterUsersInGroupBy(groupId, startDocumentId, limit, filterChain).successBody()

	override suspend fun enable2faForUser(
		userId: String,
		groupId: String,
		request: Enable2faRequest,
	) = raw.enable2faForUser(userId, groupId, request).successBody()

	override suspend fun enable2faForUser(
		userId: String,
		request: Enable2faRequest,
	) = raw.enable2faForUser(userId, request).successBody()

	override suspend fun disable2faForUser(
		userId: String,
		groupId: String,
	) = raw.disable2faForUser(userId, groupId).successBody()

	override suspend fun disable2faForUser(userId: String) = raw.disable2faForUser(userId).successBody()

	override suspend fun createAdminUser(user: User) = raw.createAdminUser(user).successBody()

	override suspend fun createAdminUserInGroup(
		groupId: String,
		user: User,
	) = raw.createAdminUserInGroup(groupId, user).successBody()

	suspend fun modifyUserPermissions(
		userId: String,
		permissions: Permission,
	) = rawPermissionApi.modifyUserPermissions(userId, permissions).successBody()
}

