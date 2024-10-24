// auto-generated file
import CardinalDartSdkSupportLib

class ClassificationBasicApiDispatcher {

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
    case "matchClassificationsBy": matchClassificationsBy(parameters: parameters, resultCallback: resultCallback)
    case "matchClassificationsBySorted": matchClassificationsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "filterClassificationsBy": filterClassificationsBy(parameters: parameters, resultCallback: resultCallback)
    case "filterClassificationsBySorted": filterClassificationsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "deleteClassification": deleteClassification(parameters: parameters, resultCallback: resultCallback)
    case "deleteClassifications": deleteClassifications(parameters: parameters, resultCallback: resultCallback)
    case "modifyClassification": modifyClassification(parameters: parameters, resultCallback: resultCallback)
    case "getClassification": getClassification(parameters: parameters, resultCallback: resultCallback)
    case "getClassifications": getClassifications(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func matchClassificationsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationBasicApi.shared.matchClassificationsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchClassificationsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationBasicApi.shared.matchClassificationsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterClassificationsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationBasicApi.shared.filterClassificationsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterClassificationsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationBasicApi.shared.filterClassificationsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func deleteClassification(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationBasicApi.shared.deleteClassification(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func deleteClassifications(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationBasicApi.shared.deleteClassifications(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func modifyClassification(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationBasicApi.shared.modifyClassification(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func getClassification(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationBasicApi.shared.getClassification(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func getClassifications(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    ClassificationBasicApi.shared.getClassifications(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

}
