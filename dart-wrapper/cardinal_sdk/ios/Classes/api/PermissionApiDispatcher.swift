// auto-generated file
import CardinalDartSdkSupportLib

class PermissionApiDispatcher {

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
    case "modifyUserPermissions": modifyUserPermissions(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func modifyUserPermissions(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PermissionApi.shared.modifyUserPermissions(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userIdString: parameters["userId"]!,
    	permissionsString: parameters["permissions"]!
    )
  }

}
