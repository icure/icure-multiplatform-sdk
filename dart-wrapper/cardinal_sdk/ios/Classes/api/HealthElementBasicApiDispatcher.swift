// auto-generated file
import CardinalDartSdkSupportLib

class HealthElementBasicApiDispatcher {

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
    case "matchHealthElementsBy": matchHealthElementsBy(parameters: parameters, resultCallback: resultCallback)
    case "matchHealthElementsBySorted": matchHealthElementsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "filterHealthElementsBy": filterHealthElementsBy(parameters: parameters, resultCallback: resultCallback)
    case "filterHealthElementsBySorted": filterHealthElementsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "deleteHealthElementById": deleteHealthElementById(parameters: parameters, resultCallback: resultCallback)
    case "deleteHealthElementsByIds": deleteHealthElementsByIds(parameters: parameters, resultCallback: resultCallback)
    case "purgeHealthElementById": purgeHealthElementById(parameters: parameters, resultCallback: resultCallback)
    case "deleteHealthElement": deleteHealthElement(parameters: parameters, resultCallback: resultCallback)
    case "deleteHealthElements": deleteHealthElements(parameters: parameters, resultCallback: resultCallback)
    case "purgeHealthElement": purgeHealthElement(parameters: parameters, resultCallback: resultCallback)
    case "createHealthElement": createHealthElement(parameters: parameters, resultCallback: resultCallback)
    case "createHealthElements": createHealthElements(parameters: parameters, resultCallback: resultCallback)
    case "undeleteHealthElementById": undeleteHealthElementById(parameters: parameters, resultCallback: resultCallback)
    case "undeleteHealthElement": undeleteHealthElement(parameters: parameters, resultCallback: resultCallback)
    case "modifyHealthElement": modifyHealthElement(parameters: parameters, resultCallback: resultCallback)
    case "modifyHealthElements": modifyHealthElements(parameters: parameters, resultCallback: resultCallback)
    case "getHealthElement": getHealthElement(parameters: parameters, resultCallback: resultCallback)
    case "getHealthElements": getHealthElements(parameters: parameters, resultCallback: resultCallback)
    case "subscribeToEvents": subscribeToEvents(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.createHealthElement": inGroup_createHealthElement(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.modifyHealthElement": inGroup_modifyHealthElement(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.getHealthElement": inGroup_getHealthElement(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func matchHealthElementsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementBasicApi.shared.matchHealthElementsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchHealthElementsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementBasicApi.shared.matchHealthElementsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterHealthElementsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementBasicApi.shared.filterHealthElementsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterHealthElementsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementBasicApi.shared.filterHealthElementsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func deleteHealthElementById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementBasicApi.shared.deleteHealthElementById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteHealthElementsByIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementBasicApi.shared.deleteHealthElementsByIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func purgeHealthElementById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementBasicApi.shared.purgeHealthElementById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteHealthElement(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementBasicApi.shared.deleteHealthElement(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	healthElementString: parameters["healthElement"]!
    )
  }

  private static func deleteHealthElements(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementBasicApi.shared.deleteHealthElements(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	healthElementsString: parameters["healthElements"]!
    )
  }

  private static func purgeHealthElement(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementBasicApi.shared.purgeHealthElement(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	healthElementString: parameters["healthElement"]!
    )
  }

  private static func createHealthElement(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementBasicApi.shared.createHealthElement(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func createHealthElements(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementBasicApi.shared.createHealthElements(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entitiesString: parameters["entities"]!
    )
  }

  private static func undeleteHealthElementById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementBasicApi.shared.undeleteHealthElementById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func undeleteHealthElement(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementBasicApi.shared.undeleteHealthElement(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	healthElementString: parameters["healthElement"]!
    )
  }

  private static func modifyHealthElement(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementBasicApi.shared.modifyHealthElement(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func modifyHealthElements(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementBasicApi.shared.modifyHealthElements(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entitiesString: parameters["entities"]!
    )
  }

  private static func getHealthElement(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementBasicApi.shared.getHealthElement(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func getHealthElements(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementBasicApi.shared.getHealthElements(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func subscribeToEvents(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementBasicApi.shared.subscribeToEvents(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	eventsString: parameters["events"]!,
    	filterString: parameters["filter"]!,
    	subscriptionConfigString: parameters["subscriptionConfig"]!
    )
  }

  private static func inGroup_createHealthElement(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementBasicApi.inGroup.shared.createHealthElement(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func inGroup_modifyHealthElement(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementBasicApi.inGroup.shared.modifyHealthElement(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func inGroup_getHealthElement(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementBasicApi.inGroup.shared.getHealthElement(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

}
