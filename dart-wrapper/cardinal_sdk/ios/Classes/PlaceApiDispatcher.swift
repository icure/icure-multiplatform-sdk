// auto-generated file
import CardinalDartSdkSupportLib

class PlaceApiDispatcher {

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
    case "getPlace": getPlace(parameters: parameters, resultCallback: resultCallback)
    case "createPlace": createPlace(parameters: parameters, resultCallback: resultCallback)
    case "modifyPlace": modifyPlace(parameters: parameters, resultCallback: resultCallback)
    case "deletePlaces": deletePlaces(parameters: parameters, resultCallback: resultCallback)
    case "getPlaces": getPlaces(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func getPlace(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    PlaceApi.shared.getPlace(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	placeIdString: parameters["placeId"]!
    )
  }

  private static func createPlace(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    PlaceApi.shared.createPlace(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	placeString: parameters["place"]!
    )
  }

  private static func modifyPlace(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    PlaceApi.shared.modifyPlace(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	placeString: parameters["place"]!
    )
  }

  private static func deletePlaces(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    PlaceApi.shared.deletePlaces(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	placeIdsString: parameters["placeIds"]!
    )
  }

  private static func getPlaces(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    PlaceApi.shared.getPlaces(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	startDocumentIdString: parameters["startDocumentId"]!,
    	limitString: parameters["limit"]!
    )
  }

}
