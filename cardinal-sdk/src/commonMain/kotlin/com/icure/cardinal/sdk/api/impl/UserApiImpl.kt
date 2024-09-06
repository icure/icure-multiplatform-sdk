package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.UserApi
import com.icure.cardinal.sdk.api.raw.RawPermissionApi
import com.icure.cardinal.sdk.api.raw.RawUserApi
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.mapUserFilterOptions
import com.icure.cardinal.sdk.model.EncryptedPropertyStub
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.security.Enable2faRequest
import com.icure.cardinal.sdk.model.security.Permission
import com.icure.utils.InternalIcureApi
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator

@InternalIcureApi
internal class UserApiImpl(
	private val raw: RawUserApi,
	private val rawPermissionApi: RawPermissionApi,
) : UserApi {

	override suspend fun getCurrentUser(): User =
		raw.getCurrentUser().successBody()


	@Deprecated(
		"List methods are deprecated",
		replaceWith = ReplaceWith("filterUsersBy(AllUsersFilter())", "com.icure.cardinal.sdk.model.filter.user.AllUsersFilter")
	)
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

	override suspend fun getUsers(userIds: List<String>) = raw.getUsers(ListOfIds(userIds)).successBody()

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

	override suspend fun matchUsersBy(filter: BaseFilterOptions<User>) =
		raw.matchUsersBy(mapUserFilterOptions(filter)).successBody()

	override suspend fun filterUsersBy(filter: BaseFilterOptions<User>): PaginatedListIterator<User> =
		IdsPageIterator(matchUsersBy(filter), this::getUsers)

	override suspend fun matchUsersBySorted(filter: BaseSortableFilterOptions<User>) =
		matchUsersBy(filter)

	override suspend fun filterUsersBySorted(filter: BaseSortableFilterOptions<User>): PaginatedListIterator<User> =
		filterUsersBy(filter)

	override suspend fun matchUsersInGroupBy(groupId: String, filter: BaseFilterOptions<User>): List<String> =
		raw.matchUsersInGroupBy(groupId, mapUserFilterOptions(filter)).successBody()

	override suspend fun filterUsersInGroupBy(groupId: String, filter: BaseFilterOptions<User>): PaginatedListIterator<User> =
		IdsPageIterator(matchUsersInGroupBy(groupId, filter), this::getUsers)

	override suspend fun matchUsersInGroupBySorted(groupId: String, filter: BaseSortableFilterOptions<User>): List<String> =
		matchUsersInGroupBy(groupId, filter)

	override suspend fun filterUsersInGroupBySorted(groupId: String, filter: BaseSortableFilterOptions<User>): PaginatedListIterator<User> =
		filterUsersInGroupBy(groupId, filter)

	override suspend fun getMatchingUsers() = raw.getMatchingUsers().successBody()

	override suspend fun getUsersInGroup(groupId: String, userIds: List<String>): List<User> = raw.getUsersInGroup(groupId,
		ListOfIds(userIds)
	).successBody()


	@Deprecated(
		"List methods are deprecated",
		replaceWith = ReplaceWith("filterUsersInGroupBy(groupId, AllUsersFilter())", "com.icure.cardinal.sdk.model.filter.user.AllUsersFilter")
	)
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