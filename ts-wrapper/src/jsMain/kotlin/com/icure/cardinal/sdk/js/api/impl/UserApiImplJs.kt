// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.UserApi
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.UserApiJs
import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.baseFilterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.baseSortableFilterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.filterOptions_fromJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.EncryptedPropertyStubJs
import com.icure.cardinal.sdk.js.model.ListOfIdsJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.UserGroupJs
import com.icure.cardinal.sdk.js.model.UserJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.cardinal.sdk.js.model.listOfIds_fromJs
import com.icure.cardinal.sdk.js.model.paginatedList_toJs
import com.icure.cardinal.sdk.js.model.propertyStub_fromJs
import com.icure.cardinal.sdk.js.model.security.Enable2faRequestJs
import com.icure.cardinal.sdk.js.model.security.LoginIdentifierJs
import com.icure.cardinal.sdk.js.model.security.TokenWithGroupJs
import com.icure.cardinal.sdk.js.model.security.enable2faRequest_fromJs
import com.icure.cardinal.sdk.js.model.security.loginIdentifier_fromJs
import com.icure.cardinal.sdk.js.model.security.tokenWithGroup_toJs
import com.icure.cardinal.sdk.js.model.userGroup_toJs
import com.icure.cardinal.sdk.js.model.user_fromJs
import com.icure.cardinal.sdk.js.model.user_toJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionConfigurationJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.subscription.entitySubscriptionConfiguration_fromJs
import com.icure.cardinal.sdk.js.subscription.entitySubscription_toJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.EncryptedPropertyStub
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.UserGroup
import com.icure.cardinal.sdk.model.security.Enable2faRequest
import com.icure.cardinal.sdk.model.security.LoginIdentifier
import com.icure.cardinal.sdk.model.security.TokenWithGroup
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Set
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class UserApiImplJs(
	private val userApi: UserApi,
) : UserApiJs {
	override fun deleteUserUnsafe(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = userApi.deleteUserUnsafe(
			entityIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun getCurrentUser(): Promise<UserJs> = GlobalScope.promise {
		val result = userApi.getCurrentUser(
		)
		user_toJs(result)
	}

	override fun listUsersBy(options: dynamic): Promise<PaginatedListJs<UserJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val startKeyConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startKey",
				null
			) { startKey: String? ->
				undefinedToNull(startKey)
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startDocumentId",
				null
			) { startDocumentId: String? ->
				undefinedToNull(startDocumentId)
			}
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val skipPatientsConverted: Boolean? = convertingOptionOrDefaultNullable(
				_options,
				"skipPatients",
				null
			) { skipPatients: Boolean? ->
				undefinedToNull(skipPatients)
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

	override fun getUser(userId: String): Promise<UserJs?> = GlobalScope.promise {
		val userIdConverted: String = userId
		val result = userApi.getUser(
			userIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				user_toJs(nonNull1)
			}
		)
	}

	override fun getUsers(userIds: Array<String>): Promise<Array<UserJs>> = GlobalScope.promise {
		val userIdsConverted: List<String> = arrayToList(
			userIds,
			"userIds",
			{ x1: String ->
				x1
			},
		)
		val result = userApi.getUsers(
			userIdsConverted,
		)
		listToArray(
			result,
			{ x1: User ->
				user_toJs(x1)
			},
		)
	}

	override fun getUserByEmail(email: String): Promise<UserJs?> = GlobalScope.promise {
		val emailConverted: String = email
		val result = userApi.getUserByEmail(
			emailConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				user_toJs(nonNull1)
			}
		)
	}

	override fun getUserByPhoneNumber(phoneNumber: String): Promise<UserJs?> = GlobalScope.promise {
		val phoneNumberConverted: String = phoneNumber
		val result = userApi.getUserByPhoneNumber(
			phoneNumberConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				user_toJs(nonNull1)
			}
		)
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
		options: dynamic,
	): Promise<String> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val userIdConverted: String = userId
			val keyConverted: String = key
			val tokenValidityConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"tokenValidity",
				null
			) { tokenValidity: Double? ->
				numberToLong(tokenValidity, "tokenValidity")
			}
			val tokenConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"token",
				null
			) { token: String? ->
				undefinedToNull(token)
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

	override fun filterUsersBy(filter: BaseFilterOptionsJs<UserJs>):
			Promise<PaginatedListIteratorJs<UserJs>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<User> = baseFilterOptions_fromJs(filter)
		val result = userApi.filterUsersBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: User ->
				user_toJs(x1)
			},
		)
	}

	override fun matchUsersBy(filter: BaseFilterOptionsJs<UserJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: BaseFilterOptions<User> = baseFilterOptions_fromJs(filter)
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

	override fun filterUsersBySorted(filter: BaseSortableFilterOptionsJs<UserJs>):
			Promise<PaginatedListIteratorJs<UserJs>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<User> = baseSortableFilterOptions_fromJs(filter)
		val result = userApi.filterUsersBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: User ->
				user_toJs(x1)
			},
		)
	}

	override fun matchUsersBySorted(filter: BaseSortableFilterOptionsJs<UserJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<User> = baseSortableFilterOptions_fromJs(filter)
		val result = userApi.matchUsersBySorted(
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

	override fun getUsersInGroup(groupId: String, userIds: Array<String>): Promise<Array<UserJs>> =
			GlobalScope.promise {
		val groupIdConverted: String = groupId
		val userIdsConverted: List<String> = arrayToList(
			userIds,
			"userIds",
			{ x1: String ->
				x1
			},
		)
		val result = userApi.getUsersInGroup(
			groupIdConverted,
			userIdsConverted,
		)
		listToArray(
			result,
			{ x1: User ->
				user_toJs(x1)
			},
		)
	}

	override fun listUsersInGroup(groupId: String, options: dynamic):
			Promise<PaginatedListJs<UserJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val groupIdConverted: String = groupId
			val startKeyConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startKey",
				null
			) { startKey: String? ->
				undefinedToNull(startKey)
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startDocumentId",
				null
			) { startDocumentId: String? ->
				undefinedToNull(startDocumentId)
			}
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
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

	override fun setUserRoles(userId: String, rolesId: ListOfIdsJs): Promise<UserJs> =
			GlobalScope.promise {
		val userIdConverted: String = userId
		val rolesIdConverted: ListOfIds = listOfIds_fromJs(rolesId)
		val result = userApi.setUserRoles(
			userIdConverted,
			rolesIdConverted,
		)
		user_toJs(result)
	}

	override fun setUserRolesInGroup(
		userId: String,
		groupId: String,
		rolesId: ListOfIdsJs,
	): Promise<UserJs> = GlobalScope.promise {
		val userIdConverted: String = userId
		val groupIdConverted: String = groupId
		val rolesIdConverted: ListOfIds = listOfIds_fromJs(rolesId)
		val result = userApi.setUserRolesInGroup(
			userIdConverted,
			groupIdConverted,
			rolesIdConverted,
		)
		user_toJs(result)
	}

	override fun resetUserRoles(userId: String): Promise<UserJs> = GlobalScope.promise {
		val userIdConverted: String = userId
		val result = userApi.resetUserRoles(
			userIdConverted,
		)
		user_toJs(result)
	}

	override fun resetUserRolesInGroup(userId: String, groupId: String): Promise<UserJs> =
			GlobalScope.promise {
		val userIdConverted: String = userId
		val groupIdConverted: String = groupId
		val result = userApi.resetUserRolesInGroup(
			userIdConverted,
			groupIdConverted,
		)
		user_toJs(result)
	}

	override fun getTokenInGroup(
		groupId: String,
		userId: String,
		key: String,
		options: dynamic,
	): Promise<String> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val groupIdConverted: String = groupId
			val userIdConverted: String = userId
			val keyConverted: String = key
			val tokenConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"token",
				null
			) { token: String? ->
				undefinedToNull(token)
			}
			val tokenValidityConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"tokenValidity",
				null
			) { tokenValidity: Double? ->
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
		options: dynamic,
	): Promise<Array<TokenWithGroupJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val userIdentifierConverted: String = userIdentifier
			val keyConverted: String = key
			val tokenConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"token",
				null
			) { token: String? ->
				undefinedToNull(token)
			}
			val tokenValidityConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"tokenValidity",
				null
			) { tokenValidity: Double? ->
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

	override fun filterUsersInGroupBy(groupId: String, filter: BaseFilterOptionsJs<UserJs>):
			Promise<PaginatedListIteratorJs<UserJs>> = GlobalScope.promise {
		val groupIdConverted: String = groupId
		val filterConverted: BaseFilterOptions<User> = baseFilterOptions_fromJs(filter)
		val result = userApi.filterUsersInGroupBy(
			groupIdConverted,
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: User ->
				user_toJs(x1)
			},
		)
	}

	override fun matchUsersInGroupBy(groupId: String, filter: BaseFilterOptionsJs<UserJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val groupIdConverted: String = groupId
		val filterConverted: BaseFilterOptions<User> = baseFilterOptions_fromJs(filter)
		val result = userApi.matchUsersInGroupBy(
			groupIdConverted,
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun filterUsersInGroupBySorted(groupId: String,
			filter: BaseSortableFilterOptionsJs<UserJs>): Promise<PaginatedListIteratorJs<UserJs>> =
			GlobalScope.promise {
		val groupIdConverted: String = groupId
		val filterConverted: BaseSortableFilterOptions<User> = baseSortableFilterOptions_fromJs(filter)
		val result = userApi.filterUsersInGroupBySorted(
			groupIdConverted,
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: User ->
				user_toJs(x1)
			},
		)
	}

	override fun matchUsersInGroupBySorted(groupId: String,
			filter: BaseSortableFilterOptionsJs<UserJs>): Promise<Array<String>> = GlobalScope.promise {
		val groupIdConverted: String = groupId
		val filterConverted: BaseSortableFilterOptions<User> = baseSortableFilterOptions_fromJs(filter)
		val result = userApi.matchUsersInGroupBySorted(
			groupIdConverted,
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
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

	override fun deleteUserById(entityId: String, rev: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = userApi.deleteUserById(
			entityIdConverted,
			revConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteUserInGroupById(
		groupId: String,
		entityId: String,
		rev: String,
	): Promise<DocIdentifierJs> = GlobalScope.promise {
		val groupIdConverted: String = groupId
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = userApi.deleteUserInGroupById(
			groupIdConverted,
			entityIdConverted,
			revConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun purgeUserById(id: String, rev: String): Promise<Unit> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		userApi.purgeUserById(
			idConverted,
			revConverted,
		)

	}

	override fun undeleteUserById(id: String, rev: String): Promise<UserJs> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = userApi.undeleteUserById(
			idConverted,
			revConverted,
		)
		user_toJs(result)
	}

	override fun deleteUser(user: UserJs): Promise<DocIdentifierJs> = GlobalScope.promise {
		val userConverted: User = user_fromJs(user)
		val result = userApi.deleteUser(
			userConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteUserInGroup(groupId: String, user: UserJs): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val groupIdConverted: String = groupId
		val userConverted: User = user_fromJs(user)
		val result = userApi.deleteUserInGroup(
			groupIdConverted,
			userConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun purgeUser(user: UserJs): Promise<Unit> = GlobalScope.promise {
		val userConverted: User = user_fromJs(user)
		userApi.purgeUser(
			userConverted,
		)

	}

	override fun undeleteUser(user: UserJs): Promise<UserJs> = GlobalScope.promise {
		val userConverted: User = user_fromJs(user)
		val result = userApi.undeleteUser(
			userConverted,
		)
		user_toJs(result)
	}

	override fun setUserInheritsPermissions(
		userId: String,
		groupId: String,
		`value`: Boolean,
	): Promise<String> = GlobalScope.promise {
		val userIdConverted: String = userId
		val groupIdConverted: String = groupId
		val valueConverted: Boolean = value
		val result = userApi.setUserInheritsPermissions(
			userIdConverted,
			groupIdConverted,
			valueConverted,
		)
		result
	}

	override fun setLoginIdentifiers(
		userId: String,
		groupId: String,
		identifier: LoginIdentifierJs,
		replaceExisting: Boolean,
	): Promise<Boolean> = GlobalScope.promise {
		val userIdConverted: String = userId
		val groupIdConverted: String = groupId
		val identifierConverted: LoginIdentifier = loginIdentifier_fromJs(identifier)
		val replaceExistingConverted: Boolean = replaceExisting
		val result = userApi.setLoginIdentifiers(
			userIdConverted,
			groupIdConverted,
			identifierConverted,
			replaceExistingConverted,
		)
		result
	}

	override fun setExternalJwtAuthByIdentifiersForCurrentUser(externalJwtConfigId: String,
			externalAuthenticationToken: String): Promise<Boolean> = GlobalScope.promise {
		val externalJwtConfigIdConverted: String = externalJwtConfigId
		val externalAuthenticationTokenConverted: String = externalAuthenticationToken
		val result = userApi.setExternalJwtAuthByIdentifiersForCurrentUser(
			externalJwtConfigIdConverted,
			externalAuthenticationTokenConverted,
		)
		result
	}

	override fun subscribeToEvents(
		events: Array<String>,
		filter: FilterOptionsJs<UserJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<UserJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val eventsConverted: Set<SubscriptionEventType> = arrayToSet(
				events,
				"events",
				{ x1: String ->
					SubscriptionEventType.valueOf(x1)
				},
			)
			val filterConverted: FilterOptions<User> = filterOptions_fromJs(filter)
			val subscriptionConfigConverted: EntitySubscriptionConfiguration? =
					convertingOptionOrDefaultNullable(
				_options,
				"subscriptionConfig",
				null
			) { subscriptionConfig: EntitySubscriptionConfigurationJs? ->
				subscriptionConfig?.let { nonNull1 ->
					entitySubscriptionConfiguration_fromJs(nonNull1)
				}
			}
			val result = userApi.subscribeToEvents(
				eventsConverted,
				filterConverted,
				subscriptionConfigConverted,
			)
			entitySubscription_toJs(
				result,
				{ x1: User ->
					user_toJs(x1)
				},
			)
		}
	}
}
