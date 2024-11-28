// auto-generated file
import CardinalDartSdkSupportLib

class CryptoApiDispatcher {

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
    case "forceReload": forceReload(parameters: parameters, resultCallback: resultCallback)
    case "currentDataOwnerKeys": currentDataOwnerKeys(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func forceReload(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CryptoApi.shared.forceReload(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!
    )
  }

  private static func currentDataOwnerKeys(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CryptoApi.shared.currentDataOwnerKeys(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterTrustedKeysString: parameters["filterTrustedKeys"]!
    )
  }

}
