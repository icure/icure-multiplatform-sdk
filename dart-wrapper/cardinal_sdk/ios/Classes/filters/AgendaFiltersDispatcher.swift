// auto-generated file
import CardinalDartSdkSupportLib

class AgendaFiltersDispatcher {

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
    case "all": all(parameters: parameters, resultCallback: resultCallback)
    case "byUser": byUser(parameters: parameters, resultCallback: resultCallback)
    case "readableByUser": readableByUser(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func all(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaFilters.shared.all(
    	dartResultCallback: resultCallback
    )
  }

  private static func byUser(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaFilters.shared.byUser(
    	dartResultCallback: resultCallback,
    	userIdString: parameters["userId"]!
    )
  }

  private static func readableByUser(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaFilters.shared.readableByUser(
    	dartResultCallback: resultCallback,
    	userIdString: parameters["userId"]!
    )
  }

}
