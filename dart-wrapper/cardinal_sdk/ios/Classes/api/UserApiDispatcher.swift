// auto-generated file
import CardinalDartSdkSupportLib

class UserApiDispatcher {

  static func dispatch(
    methodName: String,
    parameters: [String : String],
    resultCallback: @escaping (
      String?,
      String?,
      String?,
      String?
    ) -> Void
  ) -> Bool {
    switch methodName {
    case "getCurrentUser": getCurrentUser(parameters: parameters, resultCallback: resultCallback)
    case "createUser": createUser(parameters: parameters, resultCallback: resultCallback)
    case "getUser": getUser(parameters: parameters, resultCallback: resultCallback)
    case "getUsers": getUsers(parameters: parameters, resultCallback: resultCallback)
    case "getUserByEmail": getUserByEmail(parameters: parameters, resultCallback: resultCallback)
    case "getUserByPhoneNumber": getUserByPhoneNumber(parameters: parameters, resultCallback: resultCallback)
    case "findByHcpartyId": findByHcpartyId(parameters: parameters, resultCallback: resultCallback)
    case "findByPatientId": findByPatientId(parameters: parameters, resultCallback: resultCallback)
    case "modifyUser": modifyUser(parameters: parameters, resultCallback: resultCallback)
    case "assignHealthcareParty": assignHealthcareParty(parameters: parameters, resultCallback: resultCallback)
    case "modifyProperties": modifyProperties(parameters: parameters, resultCallback: resultCallback)
    case "getToken": getToken(parameters: parameters, resultCallback: resultCallback)
    case "filterUsersBy": filterUsersBy(parameters: parameters, resultCallback: resultCallback)
    case "matchUsersBy": matchUsersBy(parameters: parameters, resultCallback: resultCallback)
    case "filterUsersBySorted": filterUsersBySorted(parameters: parameters, resultCallback: resultCallback)
    case "matchUsersBySorted": matchUsersBySorted(parameters: parameters, resultCallback: resultCallback)
    case "getMatchingUsers": getMatchingUsers(parameters: parameters, resultCallback: resultCallback)
    case "getUsersInGroup": getUsersInGroup(parameters: parameters, resultCallback: resultCallback)
    case "createUserInGroup": createUserInGroup(parameters: parameters, resultCallback: resultCallback)
    case "modifyUserInGroup": modifyUserInGroup(parameters: parameters, resultCallback: resultCallback)
    case "setUserRoles": setUserRoles(parameters: parameters, resultCallback: resultCallback)
    case "setUserRolesInGroup": setUserRolesInGroup(parameters: parameters, resultCallback: resultCallback)
    case "resetUserRoles": resetUserRoles(parameters: parameters, resultCallback: resultCallback)
    case "resetUserRolesInGroup": resetUserRolesInGroup(parameters: parameters, resultCallback: resultCallback)
    case "getTokenInGroup": getTokenInGroup(parameters: parameters, resultCallback: resultCallback)
    case "getTokenInAllGroups": getTokenInAllGroups(parameters: parameters, resultCallback: resultCallback)
    case "filterUsersInGroupBy": filterUsersInGroupBy(parameters: parameters, resultCallback: resultCallback)
    case "matchUsersInGroupBy": matchUsersInGroupBy(parameters: parameters, resultCallback: resultCallback)
    case "filterUsersInGroupBySorted": filterUsersInGroupBySorted(parameters: parameters, resultCallback: resultCallback)
    case "matchUsersInGroupBySorted": matchUsersInGroupBySorted(parameters: parameters, resultCallback: resultCallback)
    case "enable2faForUserWithGroup": enable2faForUserWithGroup(parameters: parameters, resultCallback: resultCallback)
    case "enable2faForUser": enable2faForUser(parameters: parameters, resultCallback: resultCallback)
    case "disable2faForUserWithGroup": disable2faForUserWithGroup(parameters: parameters, resultCallback: resultCallback)
    case "disable2faForUser": disable2faForUser(parameters: parameters, resultCallback: resultCallback)
    case "createAdminUser": createAdminUser(parameters: parameters, resultCallback: resultCallback)
    case "createAdminUserInGroup": createAdminUserInGroup(parameters: parameters, resultCallback: resultCallback)
    case "deleteUserById": deleteUserById(parameters: parameters, resultCallback: resultCallback)
    case "deleteUserInGroupById": deleteUserInGroupById(parameters: parameters, resultCallback: resultCallback)
    case "purgeUserById": purgeUserById(parameters: parameters, resultCallback: resultCallback)
    case "undeleteUserById": undeleteUserById(parameters: parameters, resultCallback: resultCallback)
    case "deleteUser": deleteUser(parameters: parameters, resultCallback: resultCallback)
    case "deleteUserInGroup": deleteUserInGroup(parameters: parameters, resultCallback: resultCallback)
    case "purgeUser": purgeUser(parameters: parameters, resultCallback: resultCallback)
    case "undeleteUser": undeleteUser(parameters: parameters, resultCallback: resultCallback)
    case "subscribeToEvents": subscribeToEvents(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func getCurrentUser(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.getCurrentUser(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!
    )
  }

  private static func createUser(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.createUser(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userString: parameters["user"]!
    )
  }

  private static func getUser(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.getUser(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userIdString: parameters["userId"]!
    )
  }

  private static func getUsers(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.getUsers(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userIdsString: parameters["userIds"]!
    )
  }

  private static func getUserByEmail(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.getUserByEmail(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	emailString: parameters["email"]!
    )
  }

  private static func getUserByPhoneNumber(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.getUserByPhoneNumber(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	phoneNumberString: parameters["phoneNumber"]!
    )
  }

  private static func findByHcpartyId(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.findByHcpartyId(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!
    )
  }

  private static func findByPatientId(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.findByPatientId(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!
    )
  }

  private static func modifyUser(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.modifyUser(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userString: parameters["user"]!
    )
  }

  private static func assignHealthcareParty(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.assignHealthcareParty(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	healthcarePartyIdString: parameters["healthcarePartyId"]!
    )
  }

  private static func modifyProperties(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.modifyProperties(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userIdString: parameters["userId"]!,
    	propertiesString: parameters["properties"]!
    )
  }

  private static func getToken(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.getToken(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userIdString: parameters["userId"]!,
    	keyString: parameters["key"]!,
    	tokenValidityString: parameters["tokenValidity"]!,
    	tokenString: parameters["token"]!
    )
  }

  private static func filterUsersBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.filterUsersBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchUsersBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.matchUsersBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterUsersBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.filterUsersBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchUsersBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.matchUsersBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func getMatchingUsers(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.getMatchingUsers(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!
    )
  }

  private static func getUsersInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.getUsersInGroup(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	userIdsString: parameters["userIds"]!
    )
  }

  private static func createUserInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.createUserInGroup(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	userString: parameters["user"]!
    )
  }

  private static func modifyUserInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.modifyUserInGroup(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	userString: parameters["user"]!
    )
  }

  private static func setUserRoles(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.setUserRoles(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userIdString: parameters["userId"]!,
    	rolesIdString: parameters["rolesId"]!
    )
  }

  private static func setUserRolesInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.setUserRolesInGroup(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userIdString: parameters["userId"]!,
    	groupIdString: parameters["groupId"]!,
    	rolesIdString: parameters["rolesId"]!
    )
  }

  private static func resetUserRoles(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.resetUserRoles(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userIdString: parameters["userId"]!
    )
  }

  private static func resetUserRolesInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.resetUserRolesInGroup(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userIdString: parameters["userId"]!,
    	groupIdString: parameters["groupId"]!
    )
  }

  private static func getTokenInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.getTokenInGroup(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	userIdString: parameters["userId"]!,
    	keyString: parameters["key"]!,
    	tokenString: parameters["token"]!,
    	tokenValidityString: parameters["tokenValidity"]!
    )
  }

  private static func getTokenInAllGroups(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.getTokenInAllGroups(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userIdentifierString: parameters["userIdentifier"]!,
    	keyString: parameters["key"]!,
    	tokenString: parameters["token"]!,
    	tokenValidityString: parameters["tokenValidity"]!
    )
  }

  private static func filterUsersInGroupBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.filterUsersInGroupBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchUsersInGroupBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.matchUsersInGroupBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterUsersInGroupBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.filterUsersInGroupBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchUsersInGroupBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.matchUsersInGroupBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func enable2faForUserWithGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.enable2faForUserWithGroup(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userIdString: parameters["userId"]!,
    	groupIdString: parameters["groupId"]!,
    	requestString: parameters["request"]!
    )
  }

  private static func enable2faForUser(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.enable2faForUser(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userIdString: parameters["userId"]!,
    	requestString: parameters["request"]!
    )
  }

  private static func disable2faForUserWithGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.disable2faForUserWithGroup(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userIdString: parameters["userId"]!,
    	groupIdString: parameters["groupId"]!
    )
  }

  private static func disable2faForUser(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.disable2faForUser(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userIdString: parameters["userId"]!
    )
  }

  private static func createAdminUser(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.createAdminUser(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userString: parameters["user"]!
    )
  }

  private static func createAdminUserInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.createAdminUserInGroup(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	userString: parameters["user"]!
    )
  }

  private static func deleteUserById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.deleteUserById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteUserInGroupById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.deleteUserInGroupById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	entityIdString: parameters["entityId"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func purgeUserById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.purgeUserById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func undeleteUserById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.undeleteUserById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteUser(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.deleteUser(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userString: parameters["user"]!
    )
  }

  private static func deleteUserInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.deleteUserInGroup(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	userString: parameters["user"]!
    )
  }

  private static func purgeUser(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.purgeUser(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userString: parameters["user"]!
    )
  }

  private static func undeleteUser(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.undeleteUser(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userString: parameters["user"]!
    )
  }

  private static func subscribeToEvents(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    UserApi.shared.subscribeToEvents(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	eventsString: parameters["events"]!,
    	filterString: parameters["filter"]!,
    	subscriptionConfigString: parameters["subscriptionConfig"]!
    )
  }

}
