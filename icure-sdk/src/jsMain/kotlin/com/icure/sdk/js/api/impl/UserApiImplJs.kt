// auto-generated file
package com.icure.sdk.js.api.`impl`

import com.icure.sdk.api.UserApi
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefault
import com.icure.sdk.js.api.UserApiJs
import com.icure.sdk.js.api.UserApi_filterUsersBy_Options
import com.icure.sdk.js.api.UserApi_filterUsersInGroupBy_Options
import com.icure.sdk.js.api.UserApi_getTokenInAllGroups_Options
import com.icure.sdk.js.api.UserApi_getTokenInGroup_Options
import com.icure.sdk.js.api.UserApi_getToken_Options
import com.icure.sdk.js.api.UserApi_listUsersBy_Options
import com.icure.sdk.js.api.UserApi_listUsersInGroup_Options
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToInt
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
import com.icure.sdk.js.model.filter.chain.filterChain_fromJs
import com.icure.sdk.js.model.listOfIds_fromJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.js.model.propertyStub_fromJs
import com.icure.sdk.js.model.security.Enable2faRequestJs
import com.icure.sdk.js.model.security.TokenWithGroupJs
import com.icure.sdk.js.model.security.enable2faRequest_fromJs
import com.icure.sdk.js.model.security.tokenWithGroup_toJs
import com.icure.sdk.js.model.userGroup_toJs
import com.icure.sdk.js.model.user_fromJs
import com.icure.sdk.js.model.user_toJs
import com.icure.sdk.model.EncryptedPropertyStub
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.User
import com.icure.sdk.model.UserGroup
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.security.Enable2faRequest
import com.icure.sdk.model.security.TokenWithGroup
import kotlin.Array
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class UserApiImplJs(
	private val userApi: UserApi,
) : UserApiJs {
	override fun getCurrentUser(): Promise<UserJs> = GlobalScope.promise {
		val result = userApi.getCurrentUser(
		)
		user_toJs(result)
	}

	override fun listUsersBy(options: UserApi_listUsersBy_Options?): Promise<PaginatedListJs<UserJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val startKeyConverted: String? = convertingOptionOrDefault(
				_options.startKey,
				null
			) { startKey ->
				startKey
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefault(
				_options.startDocumentId,
				null
			) { startDocumentId ->
				startDocumentId
			}
			val limitConverted: Int? = convertingOptionOrDefault(
				_options.limit,
				null
			) { limit ->
				numberToInt(limit, "limit")
			}
			val skipPatientsConverted: Boolean? = convertingOptionOrDefault(
				_options.skipPatients,
				null
			) { skipPatients ->
				skipPatients
			}
			val result = userApi.listUsersBy(
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
				skipPatientsConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: User ->
					user_toJs(x1)
				},
			)
		}
	}

	override fun createUser(user: UserJs): Promise<UserJs> = GlobalScope.promise {
		val userConverted: User = user_fromJs(user)
		val result = userApi.createUser(
			userConverted,
		)
		user_toJs(result)
	}

	override fun getUser(userId: String): Promise<UserJs> = GlobalScope.promise {
		val userIdConverted: String = userId
		val result = userApi.getUser(
			userIdConverted,
		)
		user_toJs(result)
	}

	override fun getUserByEmail(email: String): Promise<UserJs> = GlobalScope.promise {
		val emailConverted: String = email
		val result = userApi.getUserByEmail(
			emailConverted,
		)
		user_toJs(result)
	}

	override fun getUserByPhoneNumber(phoneNumber: String): Promise<UserJs> = GlobalScope.promise {
		val phoneNumberConverted: String = phoneNumber
		val result = userApi.getUserByPhoneNumber(
			phoneNumberConverted,
		)
		user_toJs(result)
	}

	override fun findByHcpartyId(id: String): Promise<Array<String>> = GlobalScope.promise {
		val idConverted: String = id
		val result = userApi.findByHcpartyId(
			idConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun findByPatientId(id: String): Promise<Array<String>> = GlobalScope.promise {
		val idConverted: String = id
		val result = userApi.findByPatientId(
			idConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun deleteUser(userId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		val userIdConverted: String = userId
		val result = userApi.deleteUser(
			userIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun modifyUser(user: UserJs): Promise<UserJs> = GlobalScope.promise {
		val userConverted: User = user_fromJs(user)
		val result = userApi.modifyUser(
			userConverted,
		)
		user_toJs(result)
	}

	override fun assignHealthcareParty(healthcarePartyId: String): Promise<UserJs> =
			GlobalScope.promise {
		val healthcarePartyIdConverted: String = healthcarePartyId
		val result = userApi.assignHealthcareParty(
			healthcarePartyIdConverted,
		)
		user_toJs(result)
	}

	override fun modifyProperties(userId: String, properties: Array<EncryptedPropertyStubJs>?):
			Promise<UserJs> = GlobalScope.promise {
		val userIdConverted: String = userId
		val propertiesConverted: List<EncryptedPropertyStub>? = arrayToList(
			properties,
			"properties",
			{ x1: EncryptedPropertyStubJs ->
				propertyStub_fromJs(x1)
			},
		)
		val result = userApi.modifyProperties(
			userIdConverted,
			propertiesConverted,
		)
		user_toJs(result)
	}

	override fun getToken(
		userId: String,
		key: String,
		options: UserApi_getToken_Options?,
	): Promise<String> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val userIdConverted: String = userId
			val keyConverted: String = key
			val tokenValidityConverted: Long? = convertingOptionOrDefault(
				_options.tokenValidity,
				null
			) { tokenValidity ->
				numberToLong(tokenValidity, "tokenValidity")
			}
			val tokenConverted: String? = convertingOptionOrDefault(
				_options.token,
				null
			) { token ->
				token
			}
			val result = userApi.getToken(
				userIdConverted,
				keyConverted,
				tokenValidityConverted,
				tokenConverted,
			)
			result
		}
	}

	override fun filterUsersBy(filterChain: FilterChainJs<UserJs>,
			options: UserApi_filterUsersBy_Options?): Promise<PaginatedListJs<UserJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val startDocumentIdConverted: String? = convertingOptionOrDefault(
				_options.startDocumentId,
				null
			) { startDocumentId ->
				startDocumentId
			}
			val limitConverted: Int? = convertingOptionOrDefault(
				_options.limit,
				null
			) { limit ->
				numberToInt(limit, "limit")
			}
			val filterChainConverted: FilterChain<User> = filterChain_fromJs(
				filterChain,
				{ x1: UserJs ->
					user_fromJs(x1)
				},
			)
			val result = userApi.filterUsersBy(
				startDocumentIdConverted,
				limitConverted,
				filterChainConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: User ->
					user_toJs(x1)
				},
			)
		}
	}

	override fun matchUsersBy(filter: AbstractFilterJs<UserJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: AbstractFilter<User> = abstractFilter_fromJs(
			filter,
			{ x1: UserJs ->
				user_fromJs(x1)
			},
		)
		val result = userApi.matchUsersBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun getMatchingUsers(): Promise<Array<UserGroupJs>> = GlobalScope.promise {
		val result = userApi.getMatchingUsers(
		)
		listToArray(
			result,
			{ x1: UserGroup ->
				userGroup_toJs(x1)
			},
		)
	}

	override fun listUsersInGroup(groupId: String, options: UserApi_listUsersInGroup_Options?):
			Promise<PaginatedListJs<UserJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val groupIdConverted: String = groupId
			val startKeyConverted: String? = convertingOptionOrDefault(
				_options.startKey,
				null
			) { startKey ->
				startKey
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefault(
				_options.startDocumentId,
				null
			) { startDocumentId ->
				startDocumentId
			}
			val limitConverted: Int? = convertingOptionOrDefault(
				_options.limit,
				null
			) { limit ->
				numberToInt(limit, "limit")
			}
			val result = userApi.listUsersInGroup(
				groupIdConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: User ->
					user_toJs(x1)
				},
			)
		}
	}

	override fun createUserInGroup(groupId: String, user: UserJs): Promise<UserJs> =
			GlobalScope.promise {
		val groupIdConverted: String = groupId
		val userConverted: User = user_fromJs(user)
		val result = userApi.createUserInGroup(
			groupIdConverted,
			userConverted,
		)
		user_toJs(result)
	}

	override fun modifyUserInGroup(groupId: String, user: UserJs): Promise<UserJs> =
			GlobalScope.promise {
		val groupIdConverted: String = groupId
		val userConverted: User = user_fromJs(user)
		val result = userApi.modifyUserInGroup(
			groupIdConverted,
			userConverted,
		)
		user_toJs(result)
	}

	override fun deleteUserInGroup(groupId: String, userId: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val groupIdConverted: String = groupId
		val userIdConverted: String = userId
		val result = userApi.deleteUserInGroup(
			groupIdConverted,
			userIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun addRolesToUser(userId: String, rolesId: ListOfIdsJs): Promise<UserJs> =
			GlobalScope.promise {
		val userIdConverted: String = userId
		val rolesIdConverted: ListOfIds = listOfIds_fromJs(rolesId)
		val result = userApi.addRolesToUser(
			userIdConverted,
			rolesIdConverted,
		)
		user_toJs(result)
	}

	override fun addRolesToUserInGroup(
		userId: String,
		groupId: String,
		rolesId: ListOfIdsJs,
	): Promise<UserJs> = GlobalScope.promise {
		val userIdConverted: String = userId
		val groupIdConverted: String = groupId
		val rolesIdConverted: ListOfIds = listOfIds_fromJs(rolesId)
		val result = userApi.addRolesToUserInGroup(
			userIdConverted,
			groupIdConverted,
			rolesIdConverted,
		)
		user_toJs(result)
	}

	override fun removeRolesFromUser(userId: String): Promise<UserJs> = GlobalScope.promise {
		val userIdConverted: String = userId
		val result = userApi.removeRolesFromUser(
			userIdConverted,
		)
		user_toJs(result)
	}

	override fun removeRolesFromUserInGroup(userId: String, groupId: String): Promise<UserJs> =
			GlobalScope.promise {
		val userIdConverted: String = userId
		val groupIdConverted: String = groupId
		val result = userApi.removeRolesFromUserInGroup(
			userIdConverted,
			groupIdConverted,
		)
		user_toJs(result)
	}

	override fun getTokenInGroup(
		groupId: String,
		userId: String,
		key: String,
		options: UserApi_getTokenInGroup_Options?,
	): Promise<String> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val groupIdConverted: String = groupId
			val userIdConverted: String = userId
			val keyConverted: String = key
			val tokenConverted: String? = convertingOptionOrDefault(
				_options.token,
				null
			) { token ->
				token
			}
			val tokenValidityConverted: Long? = convertingOptionOrDefault(
				_options.tokenValidity,
				null
			) { tokenValidity ->
				numberToLong(tokenValidity, "tokenValidity")
			}
			val result = userApi.getTokenInGroup(
				groupIdConverted,
				userIdConverted,
				keyConverted,
				tokenConverted,
				tokenValidityConverted,
			)
			result
		}
	}

	override fun getTokenInAllGroups(
		userIdentifier: String,
		key: String,
		options: UserApi_getTokenInAllGroups_Options?,
	): Promise<Array<TokenWithGroupJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val userIdentifierConverted: String = userIdentifier
			val keyConverted: String = key
			val tokenConverted: String? = convertingOptionOrDefault(
				_options.token,
				null
			) { token ->
				token
			}
			val tokenValidityConverted: Long? = convertingOptionOrDefault(
				_options.tokenValidity,
				null
			) { tokenValidity ->
				numberToLong(tokenValidity, "tokenValidity")
			}
			val result = userApi.getTokenInAllGroups(
				userIdentifierConverted,
				keyConverted,
				tokenConverted,
				tokenValidityConverted,
			)
			listToArray(
				result,
				{ x1: TokenWithGroup ->
					tokenWithGroup_toJs(x1)
				},
			)
		}
	}

	override fun filterUsersInGroupBy(
		groupId: String,
		filterChain: FilterChainJs<UserJs>,
		options: UserApi_filterUsersInGroupBy_Options?,
	): Promise<PaginatedListJs<UserJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val groupIdConverted: String = groupId
			val startDocumentIdConverted: String? = convertingOptionOrDefault(
				_options.startDocumentId,
				null
			) { startDocumentId ->
				startDocumentId
			}
			val limitConverted: Int? = convertingOptionOrDefault(
				_options.limit,
				null
			) { limit ->
				numberToInt(limit, "limit")
			}
			val filterChainConverted: FilterChain<User> = filterChain_fromJs(
				filterChain,
				{ x1: UserJs ->
					user_fromJs(x1)
				},
			)
			val result = userApi.filterUsersInGroupBy(
				groupIdConverted,
				startDocumentIdConverted,
				limitConverted,
				filterChainConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: User ->
					user_toJs(x1)
				},
			)
		}
	}

	override fun enable2faForUser(
		userId: String,
		groupId: String,
		request: Enable2faRequestJs,
	): Promise<Unit> = GlobalScope.promise {
		val userIdConverted: String = userId
		val groupIdConverted: String = groupId
		val requestConverted: Enable2faRequest = enable2faRequest_fromJs(request)
		userApi.enable2faForUser(
			userIdConverted,
			groupIdConverted,
			requestConverted,
		)

	}

	override fun enable2faForUser(userId: String, request: Enable2faRequestJs): Promise<Unit> =
			GlobalScope.promise {
		val userIdConverted: String = userId
		val requestConverted: Enable2faRequest = enable2faRequest_fromJs(request)
		userApi.enable2faForUser(
			userIdConverted,
			requestConverted,
		)

	}

	override fun disable2faForUser(userId: String, groupId: String): Promise<Unit> =
			GlobalScope.promise {
		val userIdConverted: String = userId
		val groupIdConverted: String = groupId
		userApi.disable2faForUser(
			userIdConverted,
			groupIdConverted,
		)

	}

	override fun disable2faForUser(userId: String): Promise<Unit> = GlobalScope.promise {
		val userIdConverted: String = userId
		userApi.disable2faForUser(
			userIdConverted,
		)

	}

	override fun createAdminUser(user: UserJs): Promise<UserJs> = GlobalScope.promise {
		val userConverted: User = user_fromJs(user)
		val result = userApi.createAdminUser(
			userConverted,
		)
		user_toJs(result)
	}

	override fun createAdminUserInGroup(groupId: String, user: UserJs): Promise<UserJs> =
			GlobalScope.promise {
		val groupIdConverted: String = groupId
		val userConverted: User = user_fromJs(user)
		val result = userApi.createAdminUserInGroup(
			groupIdConverted,
			userConverted,
		)
		user_toJs(result)
	}
}
