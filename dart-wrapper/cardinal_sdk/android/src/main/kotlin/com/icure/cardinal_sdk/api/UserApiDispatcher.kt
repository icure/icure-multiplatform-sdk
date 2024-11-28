// auto-generated file
package com.icure.cardinal_sdk.api

import com.icure.cardinal.sdk.dart.api.UserApi
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.Map

public object UserApiDispatcher {
  public fun dispatch(
    methodName: String,
    parameters: Map<String, String>,
    resultCallback: (
      String?,
      String?,
      String?,
      String?,
    ) -> Unit,
  ): Boolean = when(methodName) {
    "getCurrentUser" -> getCurrentUser(parameters, resultCallback)
    "createUser" -> createUser(parameters, resultCallback)
    "getUser" -> getUser(parameters, resultCallback)
    "getUsers" -> getUsers(parameters, resultCallback)
    "getUserByEmail" -> getUserByEmail(parameters, resultCallback)
    "getUserByPhoneNumber" -> getUserByPhoneNumber(parameters, resultCallback)
    "findByHcpartyId" -> findByHcpartyId(parameters, resultCallback)
    "findByPatientId" -> findByPatientId(parameters, resultCallback)
    "modifyUser" -> modifyUser(parameters, resultCallback)
    "assignHealthcareParty" -> assignHealthcareParty(parameters, resultCallback)
    "modifyProperties" -> modifyProperties(parameters, resultCallback)
    "getToken" -> getToken(parameters, resultCallback)
    "filterUsersBy" -> filterUsersBy(parameters, resultCallback)
    "matchUsersBy" -> matchUsersBy(parameters, resultCallback)
    "filterUsersBySorted" -> filterUsersBySorted(parameters, resultCallback)
    "matchUsersBySorted" -> matchUsersBySorted(parameters, resultCallback)
    "getMatchingUsers" -> getMatchingUsers(parameters, resultCallback)
    "getUsersInGroup" -> getUsersInGroup(parameters, resultCallback)
    "createUserInGroup" -> createUserInGroup(parameters, resultCallback)
    "modifyUserInGroup" -> modifyUserInGroup(parameters, resultCallback)
    "setUserRoles" -> setUserRoles(parameters, resultCallback)
    "setUserRolesInGroup" -> setUserRolesInGroup(parameters, resultCallback)
    "resetUserRoles" -> resetUserRoles(parameters, resultCallback)
    "resetUserRolesInGroup" -> resetUserRolesInGroup(parameters, resultCallback)
    "getTokenInGroup" -> getTokenInGroup(parameters, resultCallback)
    "getTokenInAllGroups" -> getTokenInAllGroups(parameters, resultCallback)
    "filterUsersInGroupBy" -> filterUsersInGroupBy(parameters, resultCallback)
    "matchUsersInGroupBy" -> matchUsersInGroupBy(parameters, resultCallback)
    "filterUsersInGroupBySorted" -> filterUsersInGroupBySorted(parameters, resultCallback)
    "matchUsersInGroupBySorted" -> matchUsersInGroupBySorted(parameters, resultCallback)
    "enable2faForUserWithGroup" -> enable2faForUserWithGroup(parameters, resultCallback)
    "enable2faForUser" -> enable2faForUser(parameters, resultCallback)
    "disable2faForUserWithGroup" -> disable2faForUserWithGroup(parameters, resultCallback)
    "disable2faForUser" -> disable2faForUser(parameters, resultCallback)
    "createAdminUser" -> createAdminUser(parameters, resultCallback)
    "createAdminUserInGroup" -> createAdminUserInGroup(parameters, resultCallback)
    "deleteUserById" -> deleteUserById(parameters, resultCallback)
    "deleteUserInGroupById" -> deleteUserInGroupById(parameters, resultCallback)
    "purgeUserById" -> purgeUserById(parameters, resultCallback)
    "undeleteUserById" -> undeleteUserById(parameters, resultCallback)
    "deleteUser" -> deleteUser(parameters, resultCallback)
    "deleteUserInGroup" -> deleteUserInGroup(parameters, resultCallback)
    "purgeUser" -> purgeUser(parameters, resultCallback)
    "undeleteUser" -> undeleteUser(parameters, resultCallback)
    "subscribeToEvents" -> subscribeToEvents(parameters, resultCallback)
    else -> null
  }?.let { true } ?: false

  private fun getCurrentUser(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.getCurrentUser(
      resultCallback,
      parameters.getValue("sdkId"),
    )
  }

  private fun createUser(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.createUser(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("user"),
    )
  }

  private fun getUser(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.getUser(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("userId"),
    )
  }

  private fun getUsers(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.getUsers(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("userIds"),
    )
  }

  private fun getUserByEmail(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.getUserByEmail(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("email"),
    )
  }

  private fun getUserByPhoneNumber(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.getUserByPhoneNumber(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("phoneNumber"),
    )
  }

  private fun findByHcpartyId(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.findByHcpartyId(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
    )
  }

  private fun findByPatientId(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.findByPatientId(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
    )
  }

  private fun modifyUser(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.modifyUser(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("user"),
    )
  }

  private fun assignHealthcareParty(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.assignHealthcareParty(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("healthcarePartyId"),
    )
  }

  private fun modifyProperties(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.modifyProperties(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("userId"),
      parameters.getValue("properties"),
    )
  }

  private fun getToken(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.getToken(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("userId"),
      parameters.getValue("key"),
      parameters.getValue("tokenValidity"),
      parameters.getValue("token"),
    )
  }

  private fun filterUsersBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.filterUsersBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchUsersBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.matchUsersBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterUsersBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.filterUsersBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchUsersBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.matchUsersBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("filter"),
    )
  }

  private fun getMatchingUsers(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.getMatchingUsers(
      resultCallback,
      parameters.getValue("sdkId"),
    )
  }

  private fun getUsersInGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.getUsersInGroup(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("userIds"),
    )
  }

  private fun createUserInGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.createUserInGroup(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("user"),
    )
  }

  private fun modifyUserInGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.modifyUserInGroup(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("user"),
    )
  }

  private fun setUserRoles(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.setUserRoles(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("userId"),
      parameters.getValue("rolesId"),
    )
  }

  private fun setUserRolesInGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.setUserRolesInGroup(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("userId"),
      parameters.getValue("groupId"),
      parameters.getValue("rolesId"),
    )
  }

  private fun resetUserRoles(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.resetUserRoles(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("userId"),
    )
  }

  private fun resetUserRolesInGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.resetUserRolesInGroup(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("userId"),
      parameters.getValue("groupId"),
    )
  }

  private fun getTokenInGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.getTokenInGroup(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("userId"),
      parameters.getValue("key"),
      parameters.getValue("token"),
      parameters.getValue("tokenValidity"),
    )
  }

  private fun getTokenInAllGroups(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.getTokenInAllGroups(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("userIdentifier"),
      parameters.getValue("key"),
      parameters.getValue("token"),
      parameters.getValue("tokenValidity"),
    )
  }

  private fun filterUsersInGroupBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.filterUsersInGroupBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchUsersInGroupBy(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.matchUsersInGroupBy(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("filter"),
    )
  }

  private fun filterUsersInGroupBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.filterUsersInGroupBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("filter"),
    )
  }

  private fun matchUsersInGroupBySorted(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.matchUsersInGroupBySorted(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("filter"),
    )
  }

  private fun enable2faForUserWithGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.enable2faForUserWithGroup(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("userId"),
      parameters.getValue("groupId"),
      parameters.getValue("request"),
    )
  }

  private fun enable2faForUser(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.enable2faForUser(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("userId"),
      parameters.getValue("request"),
    )
  }

  private fun disable2faForUserWithGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.disable2faForUserWithGroup(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("userId"),
      parameters.getValue("groupId"),
    )
  }

  private fun disable2faForUser(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.disable2faForUser(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("userId"),
    )
  }

  private fun createAdminUser(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.createAdminUser(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("user"),
    )
  }

  private fun createAdminUserInGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.createAdminUserInGroup(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("user"),
    )
  }

  private fun deleteUserById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.deleteUserById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("entityId"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteUserInGroupById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.deleteUserInGroupById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("entityId"),
      parameters.getValue("rev"),
    )
  }

  private fun purgeUserById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.purgeUserById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun undeleteUserById(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.undeleteUserById(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("id"),
      parameters.getValue("rev"),
    )
  }

  private fun deleteUser(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.deleteUser(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("user"),
    )
  }

  private fun deleteUserInGroup(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.deleteUserInGroup(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("groupId"),
      parameters.getValue("user"),
    )
  }

  private fun purgeUser(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.purgeUser(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("user"),
    )
  }

  private fun undeleteUser(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.undeleteUser(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("user"),
    )
  }

  private fun subscribeToEvents(parameters: Map<String, String>, resultCallback: (
    String?,
    String?,
    String?,
    String?,
  ) -> Unit) {
    UserApi.subscribeToEvents(
      resultCallback,
      parameters.getValue("sdkId"),
      parameters.getValue("events"),
      parameters.getValue("filter"),
      parameters.getValue("subscriptionConfig"),
    )
  }
}
