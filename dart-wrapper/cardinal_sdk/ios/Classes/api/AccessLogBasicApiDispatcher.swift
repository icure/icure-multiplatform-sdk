// auto-generated file
import CardinalDartSdkSupportLib

class AccessLogBasicApiDispatcher {

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
    case "matchAccessLogsBy": matchAccessLogsBy(parameters: parameters, resultCallback: resultCallback)
    case "matchAccessLogsBySorted": matchAccessLogsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "filterAccessLogsBy": filterAccessLogsBy(parameters: parameters, resultCallback: resultCallback)
    case "filterAccessLogsBySorted": filterAccessLogsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "deleteAccessLogById": deleteAccessLogById(parameters: parameters, resultCallback: resultCallback)
    case "deleteAccessLogsByIds": deleteAccessLogsByIds(parameters: parameters, resultCallback: resultCallback)
    case "purgeAccessLogById": purgeAccessLogById(parameters: parameters, resultCallback: resultCallback)
    case "deleteAccessLog": deleteAccessLog(parameters: parameters, resultCallback: resultCallback)
    case "deleteAccessLogs": deleteAccessLogs(parameters: parameters, resultCallback: resultCallback)
    case "purgeAccessLog": purgeAccessLog(parameters: parameters, resultCallback: resultCallback)
    case "createAccessLog": createAccessLog(parameters: parameters, resultCallback: resultCallback)
    case "undeleteAccessLogById": undeleteAccessLogById(parameters: parameters, resultCallback: resultCallback)
    case "undeleteAccessLog": undeleteAccessLog(parameters: parameters, resultCallback: resultCallback)
    case "modifyAccessLog": modifyAccessLog(parameters: parameters, resultCallback: resultCallback)
    case "getAccessLog": getAccessLog(parameters: parameters, resultCallback: resultCallback)
    case "getAccessLogs": getAccessLogs(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func matchAccessLogsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogBasicApi.shared.matchAccessLogsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchAccessLogsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogBasicApi.shared.matchAccessLogsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterAccessLogsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogBasicApi.shared.filterAccessLogsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterAccessLogsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogBasicApi.shared.filterAccessLogsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func deleteAccessLogById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogBasicApi.shared.deleteAccessLogById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteAccessLogsByIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogBasicApi.shared.deleteAccessLogsByIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func purgeAccessLogById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogBasicApi.shared.purgeAccessLogById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteAccessLog(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogBasicApi.shared.deleteAccessLog(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	accessLogString: parameters["accessLog"]!
    )
  }

  private static func deleteAccessLogs(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogBasicApi.shared.deleteAccessLogs(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	accessLogsString: parameters["accessLogs"]!
    )
  }

  private static func purgeAccessLog(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogBasicApi.shared.purgeAccessLog(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	accessLogString: parameters["accessLog"]!
    )
  }

  private static func createAccessLog(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogBasicApi.shared.createAccessLog(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func undeleteAccessLogById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogBasicApi.shared.undeleteAccessLogById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func undeleteAccessLog(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogBasicApi.shared.undeleteAccessLog(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	accessLogString: parameters["accessLog"]!
    )
  }

  private static func modifyAccessLog(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogBasicApi.shared.modifyAccessLog(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func getAccessLog(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogBasicApi.shared.getAccessLog(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func getAccessLogs(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogBasicApi.shared.getAccessLogs(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

}
