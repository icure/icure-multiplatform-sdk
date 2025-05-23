package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.exceptions.RevisionConflictException
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.model.EncryptedPropertyStub
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.UserGroup
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.security.Enable2faRequest
import com.icure.cardinal.sdk.model.security.LoginIdentifier
import com.icure.cardinal.sdk.model.security.TokenWithGroup
import com.icure.cardinal.sdk.subscription.Subscribable
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import kotlin.js.JsName

interface UserApi: Subscribable<User, User, FilterOptions<User>> {
	@Deprecated("Deletion without rev is unsafe")
	suspend fun deleteUserUnsafe(entityId: String): DocIdentifier
	suspend fun getCurrentUser(): User

	@Deprecated(
		"List methods are deprecated",
		ReplaceWith(
			expression = "filterUsersBy(AllUsersFilter())",
			imports = arrayOf("com.icure.cardinal.sdk.model.filter.user.AllUsersFilter")
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
	suspend fun getUser(userId: String): User?
	suspend fun getUsers(userIds: List<String>): List<User>
	suspend fun getUserByEmail(email: String): User?
	suspend fun getUserByPhoneNumber(phoneNumber: String): User?
	suspend fun findByHcpartyId(id: String): List<String>
	suspend fun findByPatientId(id: String): List<String>
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
			imports = arrayOf("com.icure.cardinal.sdk.model.filter.user.AllUsersFilter")
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

	suspend fun setUserRoles(
		userId: String,
		rolesId: ListOfIds,
	): User

	suspend fun setUserRolesInGroup(
		userId: String,
		groupId: String,
		rolesId: ListOfIds,
	): User

	suspend fun resetUserRoles(userId: String): User
	suspend fun resetUserRolesInGroup(
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

	/**
	 * Deletes a user. If you don't have write access to the user the method will fail.
	 * @param entityId id of the user.
	 * @param rev the latest known rev of the user to delete
	 * @return the id and revision of the deleted user.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun deleteUserById(entityId: String, rev: String): DocIdentifier

	/**
	 * Deletes a user in a specific group. If you don't have write access to the user the method will fail.
	 * @param entityId id of the user.
	 * @param rev the latest known rev of the user to delete
	 * @param groupId the group of the user
	 * @return the id and revision of the deleted user.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun deleteUserInGroupById(groupId: String, entityId: String, rev: String): DocIdentifier

	/**
	 * Permanently deletes a user.
	 * @param id id of the user to purge
	 * @param rev latest revision of the user
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun purgeUserById(id: String, rev: String)

	/**
	 * Restores a user that was marked as deleted.
	 * @param id the id of the entity
	 * @param rev the latest revision of the entity.
	 * @return the restored entity.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun undeleteUserById(id: String, rev: String): User

	/**
	 * Deletes a user. If you don't have write access to the user the method will fail.
	 * @param user the user to delete
	 * @return the id and revision of the deleted user.
	 * @throws RevisionConflictException if the provided user doesn't match the latest known revision
	 */
	suspend fun deleteUser(user: User): DocIdentifier =
		deleteUserById(user.id, requireNotNull(user.rev) { "Can't delete a user that has no rev" })

	/**
	 * Deletes a user in a specific group. If you don't have write access to the user the method will fail.
	 * @param groupId the group of the user
	 * @param user the user to delete
	 * @return the id and revision of the deleted user.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun deleteUserInGroup(groupId: String, user: User): DocIdentifier =
		deleteUserInGroupById(groupId, user.id, requireNotNull(user.rev) { "Can't delete a user that has no rev" })
	/**
	 * Permanently deletes a user.
	 * @param user the user to purge.
	 * @throws RevisionConflictException if the provided user doesn't match the latest known revision
	 */
	suspend fun purgeUser(user: User) {
		purgeUserById(user.id, requireNotNull(user.rev) { "Can't delete a user that has no rev" })
	}
	/**
	 * Restores a user that was marked as deleted.
	 * @param user the user to undelete
	 * @return the restored user.
	 * @throws RevisionConflictException if the provided user doesn't match the latest known revision
	 */
	suspend fun undeleteUser(user: User): User =
		undeleteUserById(user.id, requireNotNull(user.rev) { "Can't delete a user that has no rev" })

	/**
	 * Defines if a user inherits the permission they have in their group in all the groups that are children of their group.
	 *
	 * @param userId the id of the user to update.
	 * @param groupId the id of the group of the user.
	 * @param value true if the user should inherit the permissions, false otherwise.
	 */
	suspend fun setUserInheritsPermissions(
		userId: String,
		groupId: String,
		value: Boolean,
	): String

	suspend fun setLoginIdentifiers(
		userId: String,
		groupId: String,
		identifier: LoginIdentifier,
		replaceExisting: Boolean,
	): Boolean

	suspend fun setExternalJwtAuthByIdentifiersForCurrentUser(
		externalJwtConfigId: String,
		externalAuthenticationToken: String,
	): Boolean
}

