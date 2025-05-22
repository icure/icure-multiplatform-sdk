// auto-generated file
import CardinalDartSdkSupportLib

class AuthApiDispatcher {

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
    case "getBearerToken": getBearerToken(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func getBearerToken(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AuthApi.shared.getBearerToken(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!
    )
  }

}
