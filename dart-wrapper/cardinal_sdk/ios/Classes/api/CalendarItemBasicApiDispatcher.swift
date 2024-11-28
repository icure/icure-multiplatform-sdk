// auto-generated file
import CardinalDartSdkSupportLib

class CalendarItemBasicApiDispatcher {

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
    case "matchCalendarItemsBy": matchCalendarItemsBy(parameters: parameters, resultCallback: resultCallback)
    case "matchCalendarItemsBySorted": matchCalendarItemsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "filterCalendarItemsBy": filterCalendarItemsBy(parameters: parameters, resultCallback: resultCallback)
    case "filterCalendarItemsBySorted": filterCalendarItemsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "deleteCalendarItemById": deleteCalendarItemById(parameters: parameters, resultCallback: resultCallback)
    case "deleteCalendarItemsByIds": deleteCalendarItemsByIds(parameters: parameters, resultCallback: resultCallback)
    case "purgeCalendarItemById": purgeCalendarItemById(parameters: parameters, resultCallback: resultCallback)
    case "deleteCalendarItem": deleteCalendarItem(parameters: parameters, resultCallback: resultCallback)
    case "deleteCalendarItems": deleteCalendarItems(parameters: parameters, resultCallback: resultCallback)
    case "purgeCalendarItem": purgeCalendarItem(parameters: parameters, resultCallback: resultCallback)
    case "undeleteCalendarItemById": undeleteCalendarItemById(parameters: parameters, resultCallback: resultCallback)
    case "undeleteCalendarItem": undeleteCalendarItem(parameters: parameters, resultCallback: resultCallback)
    case "modifyCalendarItem": modifyCalendarItem(parameters: parameters, resultCallback: resultCallback)
    case "getCalendarItem": getCalendarItem(parameters: parameters, resultCallback: resultCallback)
    case "getCalendarItems": getCalendarItems(parameters: parameters, resultCallback: resultCallback)
    case "subscribeToEvents": subscribeToEvents(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func matchCalendarItemsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.shared.matchCalendarItemsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchCalendarItemsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.shared.matchCalendarItemsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterCalendarItemsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.shared.filterCalendarItemsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterCalendarItemsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.shared.filterCalendarItemsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func deleteCalendarItemById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.shared.deleteCalendarItemById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteCalendarItemsByIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.shared.deleteCalendarItemsByIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func purgeCalendarItemById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.shared.purgeCalendarItemById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteCalendarItem(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.shared.deleteCalendarItem(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	calendarItemString: parameters["calendarItem"]!
    )
  }

  private static func deleteCalendarItems(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.shared.deleteCalendarItems(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	calendarItemsString: parameters["calendarItems"]!
    )
  }

  private static func purgeCalendarItem(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.shared.purgeCalendarItem(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	calendarItemString: parameters["calendarItem"]!
    )
  }

  private static func undeleteCalendarItemById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.shared.undeleteCalendarItemById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func undeleteCalendarItem(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.shared.undeleteCalendarItem(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	calendarItemString: parameters["calendarItem"]!
    )
  }

  private static func modifyCalendarItem(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.shared.modifyCalendarItem(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func getCalendarItem(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.shared.getCalendarItem(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func getCalendarItems(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemBasicApi.shared.getCalendarItems(
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
    CalendarItemBasicApi.shared.subscribeToEvents(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	eventsString: parameters["events"]!,
    	filterString: parameters["filter"]!,
    	subscriptionConfigString: parameters["subscriptionConfig"]!
    )
  }

}
