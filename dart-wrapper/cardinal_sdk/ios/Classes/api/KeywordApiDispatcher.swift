// auto-generated file
import CardinalDartSdkSupportLib

class KeywordApiDispatcher {

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
    case "getKeyword": getKeyword(parameters: parameters, resultCallback: resultCallback)
    case "createKeyword": createKeyword(parameters: parameters, resultCallback: resultCallback)
    case "modifyKeyword": modifyKeyword(parameters: parameters, resultCallback: resultCallback)
    case "getKeywordsByUser": getKeywordsByUser(parameters: parameters, resultCallback: resultCallback)
    case "deleteKeywords": deleteKeywords(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func getKeyword(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    KeywordApi.shared.getKeyword(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	keywordIdString: parameters["keywordId"]!
    )
  }

  private static func createKeyword(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    KeywordApi.shared.createKeyword(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	keywordString: parameters["keyword"]!
    )
  }

  private static func modifyKeyword(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    KeywordApi.shared.modifyKeyword(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	keywordString: parameters["keyword"]!
    )
  }

  private static func getKeywordsByUser(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    KeywordApi.shared.getKeywordsByUser(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userIdString: parameters["userId"]!
    )
  }

  private static func deleteKeywords(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    KeywordApi.shared.deleteKeywords(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	keywordIdsString: parameters["keywordIds"]!
    )
  }

}
