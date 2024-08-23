package com.icure.sdk.api

import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.model.EncryptedPropertyStub
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.User
import com.icure.sdk.model.UserGroup
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.security.Enable2faRequest
import com.icure.sdk.model.security.TokenWithGroup
import com.icure.sdk.utils.DefaultValue
import com.icure.sdk.utils.pagination.PaginatedListIterator
import kotlin.js.JsName

interface UserApi {
	suspend fun getCurrentUser(): User

	@Deprecated(
		"List methods are deprecated",
		ReplaceWith(
			expression = "filterUsersBy(AllUsersFilter())",
			imports = arrayOf("com.icure.sdk.model.filter.user.AllUsersFilter")
		)
	)
	suspend fun listUsersBy(
		@DefaultValue("null")
		startKey: String? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
		@DefaultValue("null")
		skipPatients: Boolean? = null,
	): PaginatedList<User>

	suspend fun createUser(user: User): User
	suspend fun getUser(userId: String): User
	suspend fun getUsers(userIds: List<String>): List<User>
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
		@DefaultValue("null")
		tokenValidity: Long? = null,
		@DefaultValue("null")
		token: String? = null,
	): String

	suspend fun filterUsersBy(filter: BaseFilterOptions<User>): PaginatedListIterator<User>
	suspend fun matchUsersBy(filter: BaseFilterOptions<User>): List<String>
	suspend fun filterUsersBySorted(filter: BaseSortableFilterOptions<User>): PaginatedListIterator<User>
	suspend fun matchUsersBySorted(filter: BaseSortableFilterOptions<User>): List<String>


	suspend fun getMatchingUsers(): List<UserGroup>

	suspend fun getUsersInGroup(groupId: String, userIds: List<String>): List<User>

	@Deprecated(
		"List methods are deprecated",
		ReplaceWith(
			expression = "filterUsersInGroupBy(groupId, AllUsersFilter())",
			imports = arrayOf("com.icure.sdk.model.filter.user.AllUsersFilter")
		)
	)
	suspend fun listUsersInGroup(
		groupId: String,
		@DefaultValue("null")
		startKey: String? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
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
		@DefaultValue("null")
		token: String? = null,
		@DefaultValue("null")
		tokenValidity: Long? = null,
	): String

	suspend fun getTokenInAllGroups(
		userIdentifier: String,
		key: String,
		@DefaultValue("null")
		token: String? = null,
		@DefaultValue("null")
		tokenValidity: Long? = null,
	): List<TokenWithGroup>

	suspend fun filterUsersInGroupBy(
		groupId: String,
		filter: BaseFilterOptions<User>,
	): PaginatedListIterator<User>

	suspend fun matchUsersInGroupBy(groupId: String, filter: BaseFilterOptions<User>): List<String>

	suspend fun filterUsersInGroupBySorted(
		groupId: String,
		filter: BaseSortableFilterOptions<User>,
	): PaginatedListIterator<User>

	suspend fun matchUsersInGroupBySorted(groupId: String, filter: BaseSortableFilterOptions<User>): List<String>

	@JsName("enable2faForUserWithGroup")
	suspend fun enable2faForUser(
		userId: String,
		groupId: String,
		request: Enable2faRequest,
	)

	suspend fun enable2faForUser(
		userId: String,
		request: Enable2faRequest,
	)

	@JsName("disable2faForUserWithGroup")
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

