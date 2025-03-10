// auto-generated file
import CardinalDartSdkSupportLib

class TarificationApiDispatcher {

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
    case "getTarification": getTarification(parameters: parameters, resultCallback: resultCallback)
    case "createTarification": createTarification(parameters: parameters, resultCallback: resultCallback)
    case "getTarifications": getTarifications(parameters: parameters, resultCallback: resultCallback)
    case "modifyTarification": modifyTarification(parameters: parameters, resultCallback: resultCallback)
    case "getTarificationWithParts": getTarificationWithParts(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func getTarification(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TarificationApi.shared.getTarification(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	tarificationIdString: parameters["tarificationId"]!
    )
  }

  private static func createTarification(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TarificationApi.shared.createTarification(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	tarificationString: parameters["tarification"]!
    )
  }

  private static func getTarifications(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TarificationApi.shared.getTarifications(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	tarificationIdsString: parameters["tarificationIds"]!
    )
  }

  private static func modifyTarification(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TarificationApi.shared.modifyTarification(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	tarificationString: parameters["tarification"]!
    )
  }

  private static func getTarificationWithParts(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TarificationApi.shared.getTarificationWithParts(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	typeString: parameters["type"]!,
    	tarificationString: parameters["tarification"]!,
    	versionString: parameters["version"]!
    )
  }

}
