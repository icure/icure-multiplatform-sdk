// auto-generated file
import CardinalDartSdkSupportLib

class ShamirKeysManagerApiDispatcher {

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
    case "getExistingSplitsInfo": getExistingSplitsInfo(parameters: parameters, resultCallback: resultCallback)
    case "updateSelfSplits": updateSelfSplits(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func getExistingSplitsInfo(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ShamirKeysManagerApi.shared.getExistingSplitsInfo(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	dataOwnerString: parameters["dataOwner"]!
    )
  }

  private static func updateSelfSplits(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ShamirKeysManagerApi.shared.updateSelfSplits(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	keySplitsToUpdateString: parameters["keySplitsToUpdate"]!,
    	keySplitsToDeleteString: parameters["keySplitsToDelete"]!
    )
  }

}
