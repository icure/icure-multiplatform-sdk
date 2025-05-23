// auto-generated file
import CardinalDartSdkSupportLib

class TimeTableApiDispatcher {

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
    case "filterTimeTablesBy": filterTimeTablesBy(parameters: parameters, resultCallback: resultCallback)
    case "filterTimeTablesBySorted": filterTimeTablesBySorted(parameters: parameters, resultCallback: resultCallback)
    case "createTimeTable": createTimeTable(parameters: parameters, resultCallback: resultCallback)
    case "matchTimeTablesBy": matchTimeTablesBy(parameters: parameters, resultCallback: resultCallback)
    case "matchTimeTablesBySorted": matchTimeTablesBySorted(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func deleteTimeTableById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.deleteTimeTableById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteTimeTablesByIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.deleteTimeTablesByIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func purgeTimeTableById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.purgeTimeTableById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteTimeTable(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.deleteTimeTable(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	timeTableString: parameters["timeTable"]!
    )
  }

  private static func deleteTimeTables(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.deleteTimeTables(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	timeTablesString: parameters["timeTables"]!
    )
  }

  private static func purgeTimeTable(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.purgeTimeTable(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	timeTableString: parameters["timeTable"]!
    )
  }

  private static func undeleteTimeTable(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.undeleteTimeTable(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	timeTableString: parameters["timeTable"]!
    )
  }

  private static func modifyTimeTable(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.modifyTimeTable(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func undeleteTimeTableById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.undeleteTimeTableById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func getTimeTable(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.getTimeTable(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func getTimeTables(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.getTimeTables(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	timeTableIdsString: parameters["timeTableIds"]!
    )
  }

  private static func filterTimeTablesBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.filterTimeTablesBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterTimeTablesBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.filterTimeTablesBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func createTimeTable(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.createTimeTable(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func matchTimeTablesBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.matchTimeTablesBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchTimeTablesBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.matchTimeTablesBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

}
