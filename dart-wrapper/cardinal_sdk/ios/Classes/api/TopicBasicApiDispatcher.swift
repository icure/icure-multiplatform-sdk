// auto-generated file
import CardinalDartSdkSupportLib

class TopicBasicApiDispatcher {

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
    case "matchTopicsBy": matchTopicsBy(parameters: parameters, resultCallback: resultCallback)
    case "matchTopicsBySorted": matchTopicsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "filterTopicsBy": filterTopicsBy(parameters: parameters, resultCallback: resultCallback)
    case "filterTopicsBySorted": filterTopicsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "deleteTopicById": deleteTopicById(parameters: parameters, resultCallback: resultCallback)
    case "deleteTopicsByIds": deleteTopicsByIds(parameters: parameters, resultCallback: resultCallback)
    case "purgeTopicById": purgeTopicById(parameters: parameters, resultCallback: resultCallback)
    case "deleteTopic": deleteTopic(parameters: parameters, resultCallback: resultCallback)
    case "deleteTopics": deleteTopics(parameters: parameters, resultCallback: resultCallback)
    case "purgeTopic": purgeTopic(parameters: parameters, resultCallback: resultCallback)
    case "undeleteTopic": undeleteTopic(parameters: parameters, resultCallback: resultCallback)
    case "modifyTopic": modifyTopic(parameters: parameters, resultCallback: resultCallback)
    case "undeleteTopicById": undeleteTopicById(parameters: parameters, resultCallback: resultCallback)
    case "getTopic": getTopic(parameters: parameters, resultCallback: resultCallback)
    case "getTopics": getTopics(parameters: parameters, resultCallback: resultCallback)
    case "addParticipant": addParticipant(parameters: parameters, resultCallback: resultCallback)
    case "removeParticipant": removeParticipant(parameters: parameters, resultCallback: resultCallback)
    case "subscribeToEvents": subscribeToEvents(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func matchTopicsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TopicBasicApi.shared.matchTopicsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchTopicsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TopicBasicApi.shared.matchTopicsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterTopicsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TopicBasicApi.shared.filterTopicsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterTopicsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TopicBasicApi.shared.filterTopicsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func deleteTopicById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TopicBasicApi.shared.deleteTopicById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteTopicsByIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TopicBasicApi.shared.deleteTopicsByIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func purgeTopicById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TopicBasicApi.shared.purgeTopicById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteTopic(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TopicBasicApi.shared.deleteTopic(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	topicString: parameters["topic"]!
    )
  }

  private static func deleteTopics(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TopicBasicApi.shared.deleteTopics(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	topicsString: parameters["topics"]!
    )
  }

  private static func purgeTopic(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TopicBasicApi.shared.purgeTopic(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	topicString: parameters["topic"]!
    )
  }

  private static func undeleteTopic(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TopicBasicApi.shared.undeleteTopic(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	topicString: parameters["topic"]!
    )
  }

  private static func modifyTopic(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TopicBasicApi.shared.modifyTopic(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func undeleteTopicById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TopicBasicApi.shared.undeleteTopicById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func getTopic(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TopicBasicApi.shared.getTopic(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func getTopics(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TopicBasicApi.shared.getTopics(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func addParticipant(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TopicBasicApi.shared.addParticipant(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	topicRoleString: parameters["topicRole"]!
    )
  }

  private static func removeParticipant(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TopicBasicApi.shared.removeParticipant(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!,
    	dataOwnerIdString: parameters["dataOwnerId"]!
    )
  }

  private static func subscribeToEvents(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TopicBasicApi.shared.subscribeToEvents(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	eventsString: parameters["events"]!,
    	filterString: parameters["filter"]!,
    	subscriptionConfigString: parameters["subscriptionConfig"]!
    )
  }

}
