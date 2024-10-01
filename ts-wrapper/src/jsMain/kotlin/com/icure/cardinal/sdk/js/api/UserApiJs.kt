// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.EncryptedPropertyStubJs
import com.icure.cardinal.sdk.js.model.ListOfIdsJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.UserGroupJs
import com.icure.cardinal.sdk.js.model.UserJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.model.security.Enable2faRequestJs
import com.icure.cardinal.sdk.js.model.security.TokenWithGroupJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("UserApi")
public external interface UserApiJs {
	@JsName("deleteUserUnsafe")
	public fun deleteUser(entityId: String): Promise<DocIdentifierJs>

	public fun getCurrentUser(): Promise<UserJs>

	public fun listUsersBy(options: dynamic): Promise<PaginatedListJs<UserJs>>

	public fun createUser(user: UserJs): Promise<UserJs>

	public fun getUser(userId: String): Promise<UserJs>

	public fun getUsers(userIds: Array<String>): Promise<Array<UserJs>>

	public fun getUserByEmail(email: String): Promise<UserJs>

	public fun getUserByPhoneNumber(phoneNumber: String): Promise<UserJs>

	public fun findByHcpartyId(id: String): Promise<Array<String>>

	public fun findByPatientId(id: String): Promise<Array<String>>

	public fun modifyUser(user: UserJs): Promise<UserJs>

	public fun assignHealthcareParty(healthcarePartyId: String): Promise<UserJs>

	public fun modifyProperties(userId: String, properties: Array<EncryptedPropertyStubJs>?):
			Promise<UserJs>

	public fun getToken(
		userId: String,
		key: String,
		options: dynamic,
	): Promise<String>

	public fun filterUsersBy(filter: BaseFilterOptionsJs<UserJs>):
			Promise<PaginatedListIteratorJs<UserJs>>

	public fun matchUsersBy(filter: BaseFilterOptionsJs<UserJs>): Promise<Array<String>>

	public fun filterUsersBySorted(filter: BaseSortableFilterOptionsJs<UserJs>):
			Promise<PaginatedListIteratorJs<UserJs>>

	public fun matchUsersBySorted(filter: BaseSortableFilterOptionsJs<UserJs>): Promise<Array<String>>

	public fun getMatchingUsers(): Promise<Array<UserGroupJs>>

	public fun getUsersInGroup(groupId: String, userIds: Array<String>): Promise<Array<UserJs>>

	public fun listUsersInGroup(groupId: String, options: dynamic): Promise<PaginatedListJs<UserJs>>

	public fun createUserInGroup(groupId: String, user: UserJs): Promise<UserJs>

	public fun modifyUserInGroup(groupId: String, user: UserJs): Promise<UserJs>

	public fun setUserRoles(userId: String, rolesId: ListOfIdsJs): Promise<UserJs>

	public fun setUserRolesInGroup(
		userId: String,
		groupId: String,
		rolesId: ListOfIdsJs,
	): Promise<UserJs>

	public fun resetUserRoles(userId: String): Promise<UserJs>

	public fun resetUserRolesInGroup(userId: String, groupId: String): Promise<UserJs>

	public fun getTokenInGroup(
		groupId: String,
		userId: String,
		key: String,
		options: dynamic,
	): Promise<String>

	public fun getTokenInAllGroups(
		userIdentifier: String,
		key: String,
		options: dynamic,
	): Promise<Array<TokenWithGroupJs>>

	public fun filterUsersInGroupBy(groupId: String, filter: BaseFilterOptionsJs<UserJs>):
			Promise<PaginatedListIteratorJs<UserJs>>

	public fun matchUsersInGroupBy(groupId: String, filter: BaseFilterOptionsJs<UserJs>):
			Promise<Array<String>>

	public fun filterUsersInGroupBySorted(groupId: String,
			filter: BaseSortableFilterOptionsJs<UserJs>): Promise<PaginatedListIteratorJs<UserJs>>

	public fun matchUsersInGroupBySorted(groupId: String, filter: BaseSortableFilterOptionsJs<UserJs>):
			Promise<Array<String>>

	@JsName("enable2faForUserWithGroup")
	public fun enable2faForUser(
		userId: String,
		groupId: String,
		request: Enable2faRequestJs,
	): Promise<Unit>

	public fun enable2faForUser(userId: String, request: Enable2faRequestJs): Promise<Unit>

	@JsName("disable2faForUserWithGroup")
	public fun disable2faForUser(userId: String, groupId: String): Promise<Unit>

	public fun disable2faForUser(userId: String): Promise<Unit>

	public fun createAdminUser(user: UserJs): Promise<UserJs>

	public fun createAdminUserInGroup(groupId: String, user: UserJs): Promise<UserJs>

	public fun deleteUser(entityId: String, rev: String): Promise<DocIdentifierJs>

	public fun deleteUserInGroup(
		groupId: String,
		entityId: String,
		rev: String,
	): Promise<DocIdentifierJs>

	public fun purgeUser(id: String, rev: String): Promise<Unit>

	public fun undeleteUser(id: String, rev: String): Promise<UserJs>
}
