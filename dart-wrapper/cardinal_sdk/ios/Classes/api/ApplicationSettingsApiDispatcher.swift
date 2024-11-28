// auto-generated file
import CardinalDartSdkSupportLib

class ApplicationSettingsApiDispatcher {

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
    case "getApplicationSettings": getApplicationSettings(parameters: parameters, resultCallback: resultCallback)
    case "createApplicationSettings": createApplicationSettings(parameters: parameters, resultCallback: resultCallback)
    case "updateApplicationSettings": updateApplicationSettings(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func getApplicationSettings(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ApplicationSettingsApi.shared.getApplicationSettings(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!
    )
  }

  private static func createApplicationSettings(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ApplicationSettingsApi.shared.createApplicationSettings(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	applicationSettingsString: parameters["applicationSettings"]!
    )
  }

  private static func updateApplicationSettings(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ApplicationSettingsApi.shared.updateApplicationSettings(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	applicationSettingsString: parameters["applicationSettings"]!
    )
  }

}
