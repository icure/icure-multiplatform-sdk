// auto-generated file
import CardinalDartSdkSupportLib

class CalendarItemTypeApiDispatcher {

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
    case "createCalendarItemType": createCalendarItemType(parameters: parameters, resultCallback: resultCallback)
    case "deleteCalendarItemTypes": deleteCalendarItemTypes(parameters: parameters, resultCallback: resultCallback)
    case "getCalendarItemType": getCalendarItemType(parameters: parameters, resultCallback: resultCallback)
    case "modifyCalendarItemType": modifyCalendarItemType(parameters: parameters, resultCallback: resultCallback)
    case "listCalendarItemTypesByAgendaId": listCalendarItemTypesByAgendaId(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func createCalendarItemType(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemTypeApi.shared.createCalendarItemType(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	calendarItemTypeDtoString: parameters["calendarItemTypeDto"]!
    )
  }

  private static func deleteCalendarItemTypes(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemTypeApi.shared.deleteCalendarItemTypes(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	calendarItemTypeIdsString: parameters["calendarItemTypeIds"]!
    )
  }

  private static func getCalendarItemType(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemTypeApi.shared.getCalendarItemType(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	calendarItemTypeIdString: parameters["calendarItemTypeId"]!
    )
  }

  private static func modifyCalendarItemType(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemTypeApi.shared.modifyCalendarItemType(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	calendarItemTypeDtoString: parameters["calendarItemTypeDto"]!
    )
  }

  private static func listCalendarItemTypesByAgendaId(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemTypeApi.shared.listCalendarItemTypesByAgendaId(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	agendaIdString: parameters["agendaId"]!
    )
  }

}
