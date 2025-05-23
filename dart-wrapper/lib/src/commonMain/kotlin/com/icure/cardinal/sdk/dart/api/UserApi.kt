// auto-generated file
package com.icure.cardinal.sdk.dart.api

import com.icure.cardinal.sdk.CardinalNonCryptoApis
import com.icure.cardinal.sdk.dart.utils.ApiScope
import com.icure.cardinal.sdk.dart.utils.NativeReferences
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.model.EncryptedPropertyStub
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.UserGroup
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.security.Enable2faRequest
import com.icure.cardinal.sdk.model.security.LoginIdentifier
import com.icure.cardinal.sdk.model.security.TokenWithGroup
import com.icure.cardinal.sdk.serialization.EntitySubscriptionWithSerializer
import com.icure.cardinal.sdk.serialization.PaginatedListIteratorWithSerializer
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.SetSerializer
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

@OptIn(InternalIcureApi::class)
public object UserApi {
  public fun getCurrentUser(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, sdkId: String) {
    ApiScope.execute(
      dartResultCallback,
      User.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.getCurrentUser()
    }
  }

  public fun createUser(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    userString: String,
  ) {
    val user = fullLanguageInteropJson.decodeFromString(
      User.serializer(),
      userString
    )
    ApiScope.execute(
      dartResultCallback,
      User.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.createUser(
        user,
      )
    }
  }

  public fun getUser(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    userIdString: String,
  ) {
    val userId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      userIdString
    )
    ApiScope.execute(
      dartResultCallback,
      User.serializer().nullable) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.getUser(
        userId,
      )
    }
  }

  public fun getUsers(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    userIdsString: String,
  ) {
    val userIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      userIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(User.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.getUsers(
        userIds,
      )
    }
  }

  public fun getUserByEmail(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    emailString: String,
  ) {
    val email = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      emailString
    )
    ApiScope.execute(
      dartResultCallback,
      User.serializer().nullable) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.getUserByEmail(
        email,
      )
    }
  }

  public fun getUserByPhoneNumber(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    phoneNumberString: String,
  ) {
    val phoneNumber = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      phoneNumberString
    )
    ApiScope.execute(
      dartResultCallback,
      User.serializer().nullable) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.getUserByPhoneNumber(
        phoneNumber,
      )
    }
  }

  public fun findByHcpartyId(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    idString: String,
  ) {
    val id = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      idString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.findByHcpartyId(
        id,
      )
    }
  }

  public fun findByPatientId(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    idString: String,
  ) {
    val id = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      idString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.findByPatientId(
        id,
      )
    }
  }

  public fun modifyUser(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    userString: String,
  ) {
    val user = fullLanguageInteropJson.decodeFromString(
      User.serializer(),
      userString
    )
    ApiScope.execute(
      dartResultCallback,
      User.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.modifyUser(
        user,
      )
    }
  }

  public fun assignHealthcareParty(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    healthcarePartyIdString: String,
  ) {
    val healthcarePartyId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      healthcarePartyIdString
    )
    ApiScope.execute(
      dartResultCallback,
      User.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.assignHealthcareParty(
        healthcarePartyId,
      )
    }
  }

  public fun modifyProperties(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    userIdString: String,
    propertiesString: String,
  ) {
    val userId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      userIdString
    )
    val properties = fullLanguageInteropJson.decodeFromString(
      ListSerializer(EncryptedPropertyStub.serializer()).nullable,
      propertiesString
    )
    ApiScope.execute(
      dartResultCallback,
      User.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.modifyProperties(
        userId,
        properties,
      )
    }
  }

  public fun getToken(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    userIdString: String,
    keyString: String,
    tokenValidityString: String,
    tokenString: String,
  ) {
    val userId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      userIdString
    )
    val key = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      keyString
    )
    val tokenValidity = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      tokenValidityString
    )
    val token = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      tokenString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.getToken(
        userId,
        key,
        tokenValidity,
        token,
      )
    }
  }

  public fun filterUsersBy(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseFilterOptions.serializer(User.serializer()),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.filterUsersBy(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        User.serializer()
      ))
    }
  }

  public fun matchUsersBy(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseFilterOptions.serializer(User.serializer()),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.matchUsersBy(
        filter,
      )
    }
  }

  public fun filterUsersBySorted(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseSortableFilterOptions.serializer(User.serializer()),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.filterUsersBySorted(
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        User.serializer()
      ))
    }
  }

  public fun matchUsersBySorted(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    filterString: String,
  ) {
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseSortableFilterOptions.serializer(User.serializer()),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.matchUsersBySorted(
        filter,
      )
    }
  }

  public fun getMatchingUsers(dartResultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit, sdkId: String) {
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(UserGroup.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.getMatchingUsers()
    }
  }

  public fun getUsersInGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    groupIdString: String,
    userIdsString: String,
  ) {
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    val userIds = fullLanguageInteropJson.decodeFromString(
      ListSerializer(String.serializer()),
      userIdsString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(User.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.getUsersInGroup(
        groupId,
        userIds,
      )
    }
  }

  public fun createUserInGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    groupIdString: String,
    userString: String,
  ) {
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    val user = fullLanguageInteropJson.decodeFromString(
      User.serializer(),
      userString
    )
    ApiScope.execute(
      dartResultCallback,
      User.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.createUserInGroup(
        groupId,
        user,
      )
    }
  }

  public fun modifyUserInGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    groupIdString: String,
    userString: String,
  ) {
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    val user = fullLanguageInteropJson.decodeFromString(
      User.serializer(),
      userString
    )
    ApiScope.execute(
      dartResultCallback,
      User.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.modifyUserInGroup(
        groupId,
        user,
      )
    }
  }

  public fun setUserRoles(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    userIdString: String,
    rolesIdString: String,
  ) {
    val userId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      userIdString
    )
    val rolesId = fullLanguageInteropJson.decodeFromString(
      ListOfIds.serializer(),
      rolesIdString
    )
    ApiScope.execute(
      dartResultCallback,
      User.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.setUserRoles(
        userId,
        rolesId,
      )
    }
  }

  public fun setUserRolesInGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    userIdString: String,
    groupIdString: String,
    rolesIdString: String,
  ) {
    val userId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      userIdString
    )
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    val rolesId = fullLanguageInteropJson.decodeFromString(
      ListOfIds.serializer(),
      rolesIdString
    )
    ApiScope.execute(
      dartResultCallback,
      User.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.setUserRolesInGroup(
        userId,
        groupId,
        rolesId,
      )
    }
  }

  public fun resetUserRoles(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    userIdString: String,
  ) {
    val userId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      userIdString
    )
    ApiScope.execute(
      dartResultCallback,
      User.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.resetUserRoles(
        userId,
      )
    }
  }

  public fun resetUserRolesInGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    userIdString: String,
    groupIdString: String,
  ) {
    val userId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      userIdString
    )
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    ApiScope.execute(
      dartResultCallback,
      User.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.resetUserRolesInGroup(
        userId,
        groupId,
      )
    }
  }

  public fun getTokenInGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    groupIdString: String,
    userIdString: String,
    keyString: String,
    tokenString: String,
    tokenValidityString: String,
  ) {
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    val userId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      userIdString
    )
    val key = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      keyString
    )
    val token = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      tokenString
    )
    val tokenValidity = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      tokenValidityString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.getTokenInGroup(
        groupId,
        userId,
        key,
        token,
        tokenValidity,
      )
    }
  }

  public fun getTokenInAllGroups(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    userIdentifierString: String,
    keyString: String,
    tokenString: String,
    tokenValidityString: String,
  ) {
    val userIdentifier = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      userIdentifierString
    )
    val key = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      keyString
    )
    val token = fullLanguageInteropJson.decodeFromString(
      String.serializer().nullable,
      tokenString
    )
    val tokenValidity = fullLanguageInteropJson.decodeFromString(
      Long.serializer().nullable,
      tokenValidityString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(TokenWithGroup.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.getTokenInAllGroups(
        userIdentifier,
        key,
        token,
        tokenValidity,
      )
    }
  }

  public fun filterUsersInGroupBy(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    groupIdString: String,
    filterString: String,
  ) {
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseFilterOptions.serializer(User.serializer()),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.filterUsersInGroupBy(
        groupId,
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        User.serializer()
      ))
    }
  }

  public fun matchUsersInGroupBy(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    groupIdString: String,
    filterString: String,
  ) {
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseFilterOptions.serializer(User.serializer()),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.matchUsersInGroupBy(
        groupId,
        filter,
      )
    }
  }

  public fun filterUsersInGroupBySorted(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    groupIdString: String,
    filterString: String,
  ) {
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseSortableFilterOptions.serializer(User.serializer()),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult =
          NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.filterUsersInGroupBySorted(
        groupId,
        filter,
      )
      NativeReferences.create(PaginatedListIteratorWithSerializer(
        richResult,
        User.serializer()
      ))
    }
  }

  public fun matchUsersInGroupBySorted(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    groupIdString: String,
    filterString: String,
  ) {
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    val filter = fullLanguageInteropJson.decodeFromString(
      BaseSortableFilterOptions.serializer(User.serializer()),
      filterString
    )
    ApiScope.execute(
      dartResultCallback,
      ListSerializer(String.serializer())) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.matchUsersInGroupBySorted(
        groupId,
        filter,
      )
    }
  }

  public fun enable2faForUserWithGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    userIdString: String,
    groupIdString: String,
    requestString: String,
  ) {
    val userId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      userIdString
    )
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    val request = fullLanguageInteropJson.decodeFromString(
      Enable2faRequest.serializer(),
      requestString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.enable2faForUser(
        userId,
        groupId,
        request,
      )
    }
  }

  public fun enable2faForUser(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    userIdString: String,
    requestString: String,
  ) {
    val userId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      userIdString
    )
    val request = fullLanguageInteropJson.decodeFromString(
      Enable2faRequest.serializer(),
      requestString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.enable2faForUser(
        userId,
        request,
      )
    }
  }

  public fun disable2faForUserWithGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    userIdString: String,
    groupIdString: String,
  ) {
    val userId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      userIdString
    )
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.disable2faForUser(
        userId,
        groupId,
      )
    }
  }

  public fun disable2faForUser(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    userIdString: String,
  ) {
    val userId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      userIdString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.disable2faForUser(
        userId,
      )
    }
  }

  public fun createAdminUser(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    userString: String,
  ) {
    val user = fullLanguageInteropJson.decodeFromString(
      User.serializer(),
      userString
    )
    ApiScope.execute(
      dartResultCallback,
      User.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.createAdminUser(
        user,
      )
    }
  }

  public fun createAdminUserInGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    groupIdString: String,
    userString: String,
  ) {
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    val user = fullLanguageInteropJson.decodeFromString(
      User.serializer(),
      userString
    )
    ApiScope.execute(
      dartResultCallback,
      User.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.createAdminUserInGroup(
        groupId,
        user,
      )
    }
  }

  public fun deleteUserById(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    entityIdString: String,
    revString: String,
  ) {
    val entityId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      entityIdString
    )
    val rev = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      revString
    )
    ApiScope.execute(
      dartResultCallback,
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.deleteUserById(
        entityId,
        rev,
      )
    }
  }

  public fun deleteUserInGroupById(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    groupIdString: String,
    entityIdString: String,
    revString: String,
  ) {
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    val entityId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      entityIdString
    )
    val rev = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      revString
    )
    ApiScope.execute(
      dartResultCallback,
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.deleteUserInGroupById(
        groupId,
        entityId,
        rev,
      )
    }
  }

  public fun purgeUserById(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    idString: String,
    revString: String,
  ) {
    val id = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      idString
    )
    val rev = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      revString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.purgeUserById(
        id,
        rev,
      )
    }
  }

  public fun undeleteUserById(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    idString: String,
    revString: String,
  ) {
    val id = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      idString
    )
    val rev = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      revString
    )
    ApiScope.execute(
      dartResultCallback,
      User.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.undeleteUserById(
        id,
        rev,
      )
    }
  }

  public fun deleteUser(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    userString: String,
  ) {
    val user = fullLanguageInteropJson.decodeFromString(
      User.serializer(),
      userString
    )
    ApiScope.execute(
      dartResultCallback,
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.deleteUser(
        user,
      )
    }
  }

  public fun deleteUserInGroup(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    groupIdString: String,
    userString: String,
  ) {
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    val user = fullLanguageInteropJson.decodeFromString(
      User.serializer(),
      userString
    )
    ApiScope.execute(
      dartResultCallback,
      DocIdentifier.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.deleteUserInGroup(
        groupId,
        user,
      )
    }
  }

  public fun purgeUser(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    userString: String,
  ) {
    val user = fullLanguageInteropJson.decodeFromString(
      User.serializer(),
      userString
    )
    ApiScope.execute(
      dartResultCallback,
      Unit.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.purgeUser(
        user,
      )
    }
  }

  public fun undeleteUser(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    userString: String,
  ) {
    val user = fullLanguageInteropJson.decodeFromString(
      User.serializer(),
      userString
    )
    ApiScope.execute(
      dartResultCallback,
      User.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.undeleteUser(
        user,
      )
    }
  }

  public fun setUserInheritsPermissions(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    userIdString: String,
    groupIdString: String,
    valueString: String,
  ) {
    val userId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      userIdString
    )
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    val value = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      valueString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.setUserInheritsPermissions(
        userId,
        groupId,
        value,
      )
    }
  }

  public fun setLoginIdentifiers(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    userIdString: String,
    groupIdString: String,
    identifierString: String,
    replaceExistingString: String,
  ) {
    val userId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      userIdString
    )
    val groupId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      groupIdString
    )
    val identifier = fullLanguageInteropJson.decodeFromString(
      LoginIdentifier.serializer(),
      identifierString
    )
    val replaceExisting = fullLanguageInteropJson.decodeFromString(
      Boolean.serializer(),
      replaceExistingString
    )
    ApiScope.execute(
      dartResultCallback,
      Boolean.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.setLoginIdentifiers(
        userId,
        groupId,
        identifier,
        replaceExisting,
      )
    }
  }

  public fun setExternalJwtAuthByIdentifiersForCurrentUser(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    externalJwtConfigIdString: String,
    externalAuthenticationTokenString: String,
  ) {
    val externalJwtConfigId = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      externalJwtConfigIdString
    )
    val externalAuthenticationToken = fullLanguageInteropJson.decodeFromString(
      String.serializer(),
      externalAuthenticationTokenString
    )
    ApiScope.execute(
      dartResultCallback,
      Boolean.serializer()) {
      NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.setExternalJwtAuthByIdentifiersForCurrentUser(
        externalJwtConfigId,
        externalAuthenticationToken,
      )
    }
  }

  public fun subscribeToEvents(
    dartResultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
    sdkId: String,
    eventsString: String,
    filterString: String,
    subscriptionConfigString: String,
  ) {
    val events = fullLanguageInteropJson.decodeFromString(
      SetSerializer(SubscriptionEventType.serializer()),
      eventsString
    )
    val filter = fullLanguageInteropJson.decodeFromString(
      FilterOptions.serializer(User.serializer()),
      filterString
    )
    val subscriptionConfig = fullLanguageInteropJson.decodeFromString(
      EntitySubscriptionConfiguration.serializer().nullable,
      subscriptionConfigString
    )
    ApiScope.execute(
      dartResultCallback,
      String.serializer()) {
      val richResult = NativeReferences.get<CardinalNonCryptoApis>(sdkId).user.subscribeToEvents(
        events,
        filter,
        subscriptionConfig,
      )
      NativeReferences.create(EntitySubscriptionWithSerializer(
        richResult,
        User.serializer()
      ))
    }
  }
}
