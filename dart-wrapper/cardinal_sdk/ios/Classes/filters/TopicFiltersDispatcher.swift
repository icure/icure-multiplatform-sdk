// auto-generated file
import CardinalDartSdkSupportLib

class TopicFiltersDispatcher {

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
    case "allTopicsForDataOwner": allTopicsForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "allTopicsForSelf": allTopicsForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byParticipant": byParticipant(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func allTopicsForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicFilters.shared.allTopicsForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!
    )
  }

  private static func allTopicsForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicFilters.shared.allTopicsForSelf(
    	dartResultCallback: resultCallback
    )
  }

  private static func byParticipant(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    TopicFilters.shared.byParticipant(
    	dartResultCallback: resultCallback,
    	participantIdString: parameters["participantId"]!
    )
  }

}
