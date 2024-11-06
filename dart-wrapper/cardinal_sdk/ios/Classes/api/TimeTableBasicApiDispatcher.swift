// auto-generated file
import CardinalDartSdkSupportLib

class TimeTableBasicApiDispatcher {

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
    case "matchTimeTablesBy": matchTimeTablesBy(parameters: parameters, resultCallback: resultCallback)
    case "matchTimeTablesBySorted": matchTimeTablesBySorted(parameters: parameters, resultCallback: resultCallback)
    case "filterTimeTablesBy": filterTimeTablesBy(parameters: parameters, resultCallback: resultCallback)
    case "filterTimeTablesBySorted": filterTimeTablesBySorted(parameters: parameters, resultCallback: resultCallback)
    case "deleteTimeTableById": deleteTimeTableById(parameters: parameters, resultCallback: resultCallback)
    case "deleteTimeTablesByIds": deleteTimeTablesByIds(parameters: parameters, resultCallback: resultCallback)
    case "purgeTimeTableById": purgeTimeTableById(parameters: parameters, resultCallback: resultCallback)
    case "deleteTimeTable": deleteTimeTable(parameters: parameters, resultCallback: resultCallback)
    case "deleteTimeTables": deleteTimeTables(parameters: parameters, resultCallback: resultCallback)
    case "purgeTimeTable": purgeTimeTable(parameters: parameters, resultCallback: resultCallback)
    case "undeleteTimeTable": undeleteTimeTable(parameters: parameters, resultCallback: resultCallback)
    case "modifyTimeTable": modifyTimeTable(parameters: parameters, resultCallback: resultCallback)
    case "undeleteTimeTableById": undeleteTimeTableById(parameters: parameters, resultCallback: resultCallback)
    case "getTimeTable": getTimeTable(parameters: parameters, resultCallback: resultCallback)
    case "getTimeTables": getTimeTables(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func matchTimeTablesBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableBasicApi.shared.matchTimeTablesBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchTimeTablesBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableBasicApi.shared.matchTimeTablesBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterTimeTablesBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableBasicApi.shared.filterTimeTablesBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterTimeTablesBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableBasicApi.shared.filterTimeTablesBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func deleteTimeTableById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableBasicApi.shared.deleteTimeTableById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteTimeTablesByIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableBasicApi.shared.deleteTimeTablesByIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func purgeTimeTableById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableBasicApi.shared.purgeTimeTableById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteTimeTable(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableBasicApi.shared.deleteTimeTable(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	timeTableString: parameters["timeTable"]!
    )
  }

  private static func deleteTimeTables(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableBasicApi.shared.deleteTimeTables(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	timeTablesString: parameters["timeTables"]!
    )
  }

  private static func purgeTimeTable(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableBasicApi.shared.purgeTimeTable(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	timeTableString: parameters["timeTable"]!
    )
  }

  private static func undeleteTimeTable(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableBasicApi.shared.undeleteTimeTable(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	timeTableString: parameters["timeTable"]!
    )
  }

  private static func modifyTimeTable(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableBasicApi.shared.modifyTimeTable(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func undeleteTimeTableById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableBasicApi.shared.undeleteTimeTableById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func getTimeTable(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableBasicApi.shared.getTimeTable(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func getTimeTables(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableBasicApi.shared.getTimeTables(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	timeTableIdsString: parameters["timeTableIds"]!
    )
  }

}
