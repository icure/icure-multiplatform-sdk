// auto-generated file
import CardinalDartSdkSupportLib

class RoleApiDispatcher {

  static func dispatch(
    methodName: String,
    parameters: [String : String],
    resultCallback: @escaping (
      String?,
      String?,
      String?
    ) -> Void
  ) -> Bool {
    switch methodName {
    case "getAllRoles": getAllRoles(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func getAllRoles(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    RoleApi.shared.getAllRoles(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!
    )
  }

}
