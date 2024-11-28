// auto-generated file
import CardinalDartSdkSupportLib

class MessageBasicApiDispatcher {

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
    case "matchMessagesBy": matchMessagesBy(parameters: parameters, resultCallback: resultCallback)
    case "matchMessagesBySorted": matchMessagesBySorted(parameters: parameters, resultCallback: resultCallback)
    case "filterMessagesBy": filterMessagesBy(parameters: parameters, resultCallback: resultCallback)
    case "filterMessagesBySorted": filterMessagesBySorted(parameters: parameters, resultCallback: resultCallback)
    case "deleteMessageById": deleteMessageById(parameters: parameters, resultCallback: resultCallback)
    case "deleteMessagesByIds": deleteMessagesByIds(parameters: parameters, resultCallback: resultCallback)
    case "purgeMessageById": purgeMessageById(parameters: parameters, resultCallback: resultCallback)
    case "deleteMessage": deleteMessage(parameters: parameters, resultCallback: resultCallback)
    case "deleteMessages": deleteMessages(parameters: parameters, resultCallback: resultCallback)
    case "purgeMessage": purgeMessage(parameters: parameters, resultCallback: resultCallback)
    case "undeleteMessage": undeleteMessage(parameters: parameters, resultCallback: resultCallback)
    case "modifyMessage": modifyMessage(parameters: parameters, resultCallback: resultCallback)
    case "undeleteMessageById": undeleteMessageById(parameters: parameters, resultCallback: resultCallback)
    case "getMessage": getMessage(parameters: parameters, resultCallback: resultCallback)
    case "getMessages": getMessages(parameters: parameters, resultCallback: resultCallback)
    case "setMessagesReadStatus": setMessagesReadStatus(parameters: parameters, resultCallback: resultCallback)
    case "subscribeToEvents": subscribeToEvents(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func matchMessagesBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageBasicApi.shared.matchMessagesBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchMessagesBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageBasicApi.shared.matchMessagesBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterMessagesBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageBasicApi.shared.filterMessagesBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterMessagesBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageBasicApi.shared.filterMessagesBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func deleteMessageById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageBasicApi.shared.deleteMessageById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteMessagesByIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageBasicApi.shared.deleteMessagesByIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func purgeMessageById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageBasicApi.shared.purgeMessageById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteMessage(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageBasicApi.shared.deleteMessage(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	messageString: parameters["message"]!
    )
  }

  private static func deleteMessages(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageBasicApi.shared.deleteMessages(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	messagesString: parameters["messages"]!
    )
  }

  private static func purgeMessage(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageBasicApi.shared.purgeMessage(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	messageString: parameters["message"]!
    )
  }

  private static func undeleteMessage(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageBasicApi.shared.undeleteMessage(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	messageString: parameters["message"]!
    )
  }

  private static func modifyMessage(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageBasicApi.shared.modifyMessage(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func undeleteMessageById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageBasicApi.shared.undeleteMessageById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func getMessage(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageBasicApi.shared.getMessage(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func getMessages(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageBasicApi.shared.getMessages(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func setMessagesReadStatus(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageBasicApi.shared.setMessagesReadStatus(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!,
    	timeString: parameters["time"]!,
    	readStatusString: parameters["readStatus"]!,
    	userIdString: parameters["userId"]!
    )
  }

  private static func subscribeToEvents(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MessageBasicApi.shared.subscribeToEvents(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	eventsString: parameters["events"]!,
    	filterString: parameters["filter"]!,
    	subscriptionConfigString: parameters["subscriptionConfig"]!
    )
  }

}
