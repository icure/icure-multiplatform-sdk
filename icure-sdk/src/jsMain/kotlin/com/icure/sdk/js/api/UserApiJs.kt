// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api

import com.icure.sdk.js.model.EncryptedPropertyStubJs
import com.icure.sdk.js.model.ListOfIdsJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.UserGroupJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.model.security.Enable2faRequestJs
import com.icure.sdk.js.model.security.TokenWithGroupJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("UserApi")
public external interface UserApiJs {
	public fun getCurrentUser(): Promise<UserJs>

	public fun listUsersBy(
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
		skipPatients: Boolean?,
	): Promise<PaginatedListJs<UserJs>>

	public fun createUser(user: UserJs): Promise<UserJs>

	public fun getUser(userId: String): Promise<UserJs>

	public fun getUserByEmail(email: String): Promise<UserJs>

	public fun getUserByPhoneNumber(phoneNumber: String): Promise<UserJs>

	public fun findByHcpartyId(id: String): Promise<Array<String>>

	public fun findByPatientId(id: String): Promise<Array<String>>

	public fun deleteUser(userId: String): Promise<DocIdentifierJs>

	public fun modifyUser(user: UserJs): Promise<UserJs>

	public fun assignHealthcareParty(healthcarePartyId: String): Promise<UserJs>

	public fun modifyProperties(userId: String, properties: Array<EncryptedPropertyStubJs>?):
			Promise<UserJs>

	public fun getToken(
		userId: String,
		key: String,
		tokenValidity: Double?,
		token: String?,
	): Promise<String>

	public fun filterUsersBy(
		startDocumentId: String?,
		limit: Double?,
		filterChain: FilterChainJs<UserJs>,
	): Promise<PaginatedListJs<UserJs>>

	public fun matchUsersBy(filter: AbstractFilterJs<UserJs>): Promise<Array<String>>

	public fun getMatchingUsers(): Promise<Array<UserGroupJs>>

	public fun listUsersInGroup(
		groupId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<UserJs>>

	public fun createUserInGroup(groupId: String, user: UserJs): Promise<UserJs>

	public fun modifyUserInGroup(groupId: String, user: UserJs): Promise<UserJs>

	public fun deleteUserInGroup(groupId: String, userId: String): Promise<DocIdentifierJs>

	public fun addRolesToUser(userId: String, rolesId: ListOfIdsJs): Promise<UserJs>

	public fun addRolesToUserInGroup(
		userId: String,
		groupId: String,
		rolesId: ListOfIdsJs,
	): Promise<UserJs>

	public fun removeRolesFromUser(userId: String): Promise<UserJs>

	public fun removeRolesFromUserInGroup(userId: String, groupId: String): Promise<UserJs>

	public fun getTokenInGroup(
		groupId: String,
		userId: String,
		key: String,
		token: String?,
		tokenValidity: Double?,
	): Promise<String>

	public fun getTokenInAllGroups(
		userIdentifier: String,
		key: String,
		token: String?,
		tokenValidity: Double?,
	): Promise<Array<TokenWithGroupJs>>

	public fun filterUsersInGroupBy(
		groupId: String,
		startDocumentId: String?,
		limit: Double?,
		filterChain: FilterChainJs<UserJs>,
	): Promise<PaginatedListJs<UserJs>>

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
}
