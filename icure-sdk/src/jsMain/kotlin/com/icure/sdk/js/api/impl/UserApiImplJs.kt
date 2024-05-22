// auto-generated file
package com.icure.sdk.js.api.`impl`

import com.icure.sdk.api.UserApi
import com.icure.sdk.js.api.UserApiJs
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.EncryptedPropertyStubJs
import com.icure.sdk.js.model.ListOfIdsJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.UserGroupJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.abstractFilter_fromJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.js.model.security.Enable2faRequestJs
import com.icure.sdk.js.model.security.TokenWithGroupJs
import com.icure.sdk.js.model.security.enable2faRequest_fromJs
import com.icure.sdk.js.model.security.tokenWithGroup_toJs
import com.icure.sdk.js.model.userGroup_toJs
import com.icure.sdk.js.model.user_fromJs
import com.icure.sdk.js.model.user_toJs
import com.icure.sdk.model.User
import com.icure.sdk.model.UserGroup
import com.icure.sdk.model.security.TokenWithGroup
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
public class UserApiImplJs private constructor(
	private val userApi: UserApi,
) : UserApiJs {
	override fun getCurrentUser(): Promise<UserJs> = GlobalScope.promise {
		user_toJs(userApi.getCurrentUser())}


	override fun listUsersBy(
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
		skipPatients: Boolean?,
	): Promise<PaginatedListJs<UserJs>> = GlobalScope.promise {
		paginatedList_toJs(
			userApi.listUsersBy(startKey, startDocumentId,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit"), skipPatients),
			{ x1: User ->
				user_toJs(x1)
			},
		)}


	override fun createUser(user: UserJs): Promise<UserJs> = GlobalScope.promise {
		user_toJs(userApi.createUser(com.icure.sdk.js.model.user_fromJs(user)))}


	override fun getUser(userId: String): Promise<UserJs> = GlobalScope.promise {
		user_toJs(userApi.getUser(userId))}


	override fun getUserByEmail(email: String): Promise<UserJs> = GlobalScope.promise {
		user_toJs(userApi.getUserByEmail(email))}


	override fun getUserByPhoneNumber(phoneNumber: String): Promise<UserJs> = GlobalScope.promise {
		user_toJs(userApi.getUserByPhoneNumber(phoneNumber))}


	override fun findByHcpartyId(id: String): Promise<Array<String>> = GlobalScope.promise {
		listToArray(
			userApi.findByHcpartyId(id),
			{ x1: String ->
				x1
			},
		)}


	override fun findByPatientId(id: String): Promise<Array<String>> = GlobalScope.promise {
		listToArray(
			userApi.findByPatientId(id),
			{ x1: String ->
				x1
			},
		)}


	override fun deleteUser(userId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		docIdentifier_toJs(userApi.deleteUser(userId))}


	override fun modifyUser(user: UserJs): Promise<UserJs> = GlobalScope.promise {
		user_toJs(userApi.modifyUser(com.icure.sdk.js.model.user_fromJs(user)))}


	override fun assignHealthcareParty(healthcarePartyId: String): Promise<UserJs> =
			GlobalScope.promise {
		user_toJs(userApi.assignHealthcareParty(healthcarePartyId))}


	override fun modifyProperties(userId: String, properties: Array<EncryptedPropertyStubJs>?):
			Promise<UserJs> = GlobalScope.promise {
		user_toJs(userApi.modifyProperties(userId, com.icure.sdk.js.model.CheckedConverters.arrayToList(
		  properties,
		  "properties",
		  { x1: com.icure.sdk.js.model.EncryptedPropertyStubJs ->
		    com.icure.sdk.js.model.propertyStub_fromJs(x1)
		  },
		)))}


	override fun getToken(
		userId: String,
		key: String,
		tokenValidity: Double?,
		token: String?,
	): Promise<String> = GlobalScope.promise {
		userApi.getToken(userId, key, numberToLong(tokenValidity, "tokenValidity"), token)}


	override fun filterUsersBy(
		startDocumentId: String?,
		limit: Double?,
		filterChain: FilterChainJs<UserJs>,
	): Promise<PaginatedListJs<UserJs>> = GlobalScope.promise {
		paginatedList_toJs(
			userApi.filterUsersBy(startDocumentId,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit"),
					com.icure.sdk.js.model.filter.chain.filterChain_fromJs(
			  filterChain,
			  { x1: com.icure.sdk.js.model.UserJs ->
			    com.icure.sdk.js.model.user_fromJs(x1)
			  },
			)),
			{ x1: User ->
				user_toJs(x1)
			},
		)}


	override fun matchUsersBy(filter: AbstractFilterJs<UserJs>): Promise<Array<String>> =
			GlobalScope.promise {
		listToArray(
			userApi.matchUsersBy(abstractFilter_fromJs(
				filter,
				{ x1: UserJs ->
					user_fromJs(x1)
				},
			)),
			{ x1: String ->
				x1
			},
		)}


	override fun getMatchingUsers(): Promise<Array<UserGroupJs>> = GlobalScope.promise {
		listToArray(
			userApi.getMatchingUsers(),
			{ x1: UserGroup ->
				userGroup_toJs(x1)
			},
		)}


	override fun listUsersInGroup(
		groupId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<UserJs>> = GlobalScope.promise {
		paginatedList_toJs(
			userApi.listUsersInGroup(groupId, startKey, startDocumentId,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
			{ x1: User ->
				user_toJs(x1)
			},
		)}


	override fun createUserInGroup(groupId: String, user: UserJs): Promise<UserJs> =
			GlobalScope.promise {
		user_toJs(userApi.createUserInGroup(groupId, com.icure.sdk.js.model.user_fromJs(user)))}


	override fun modifyUserInGroup(groupId: String, user: UserJs): Promise<UserJs> =
			GlobalScope.promise {
		user_toJs(userApi.modifyUserInGroup(groupId, com.icure.sdk.js.model.user_fromJs(user)))}


	override fun deleteUserInGroup(groupId: String, userId: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		docIdentifier_toJs(userApi.deleteUserInGroup(groupId, userId))}


	override fun addRolesToUser(userId: String, rolesId: ListOfIdsJs): Promise<UserJs> =
			GlobalScope.promise {
		user_toJs(userApi.addRolesToUser(userId, com.icure.sdk.js.model.listOfIds_fromJs(rolesId)))}


	override fun addRolesToUserInGroup(
		userId: String,
		groupId: String,
		rolesId: ListOfIdsJs,
	): Promise<UserJs> = GlobalScope.promise {
		user_toJs(userApi.addRolesToUserInGroup(userId, groupId,
				com.icure.sdk.js.model.listOfIds_fromJs(rolesId)))}


	override fun removeRolesFromUser(userId: String): Promise<UserJs> = GlobalScope.promise {
		user_toJs(userApi.removeRolesFromUser(userId))}


	override fun removeRolesFromUserInGroup(userId: String, groupId: String): Promise<UserJs> =
			GlobalScope.promise {
		user_toJs(userApi.removeRolesFromUserInGroup(userId, groupId))}


	override fun getTokenInGroup(
		groupId: String,
		userId: String,
		key: String,
		token: String?,
		tokenValidity: Double?,
	): Promise<String> = GlobalScope.promise {
		userApi.getTokenInGroup(groupId, userId, key, token, numberToLong(tokenValidity,
				"tokenValidity"))}


	override fun getTokenInAllGroups(
		userIdentifier: String,
		key: String,
		token: String?,
		tokenValidity: Double?,
	): Promise<Array<TokenWithGroupJs>> = GlobalScope.promise {
		listToArray(
			userApi.getTokenInAllGroups(userIdentifier, key, token, numberToLong(tokenValidity,
					"tokenValidity")),
			{ x1: TokenWithGroup ->
				tokenWithGroup_toJs(x1)
			},
		)}


	override fun filterUsersInGroupBy(
		groupId: String,
		startDocumentId: String?,
		limit: Double?,
		filterChain: FilterChainJs<UserJs>,
	): Promise<PaginatedListJs<UserJs>> = GlobalScope.promise {
		paginatedList_toJs(
			userApi.filterUsersInGroupBy(groupId, startDocumentId,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit"),
					com.icure.sdk.js.model.filter.chain.filterChain_fromJs(
			  filterChain,
			  { x1: com.icure.sdk.js.model.UserJs ->
			    com.icure.sdk.js.model.user_fromJs(x1)
			  },
			)),
			{ x1: User ->
				user_toJs(x1)
			},
		)}


	override fun enable2faForUser(
		userId: String,
		groupId: String,
		request: Enable2faRequestJs,
	): Promise<Unit> = GlobalScope.promise {
		userApi.enable2faForUser(userId, groupId, enable2faRequest_fromJs(request))}


	override fun enable2faForUser(userId: String, request: Enable2faRequestJs): Promise<Unit> =
			GlobalScope.promise {
		userApi.enable2faForUser(userId, enable2faRequest_fromJs(request))}


	override fun disable2faForUser(userId: String, groupId: String): Promise<Unit> =
			GlobalScope.promise {
		userApi.disable2faForUser(userId, groupId)}


	override fun disable2faForUser(userId: String): Promise<Unit> = GlobalScope.promise {
		userApi.disable2faForUser(userId)}


	override fun createAdminUser(user: UserJs): Promise<UserJs> = GlobalScope.promise {
		user_toJs(userApi.createAdminUser(com.icure.sdk.js.model.user_fromJs(user)))}


	override fun createAdminUserInGroup(groupId: String, user: UserJs): Promise<UserJs> =
			GlobalScope.promise {
		user_toJs(userApi.createAdminUserInGroup(groupId, com.icure.sdk.js.model.user_fromJs(user)))}

}
