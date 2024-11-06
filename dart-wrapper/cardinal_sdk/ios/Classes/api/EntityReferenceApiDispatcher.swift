// auto-generated file
import CardinalDartSdkSupportLib

class EntityReferenceApiDispatcher {

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
    case "getLatest": getLatest(parameters: parameters, resultCallback: resultCallback)
    case "createEntityReference": createEntityReference(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func getLatest(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    EntityReferenceApi.shared.getLatest(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	prefixString: parameters["prefix"]!
    )
  }

  private static func createEntityReference(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    EntityReferenceApi.shared.createEntityReference(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityReferenceString: parameters["entityReference"]!
    )
  }

}
