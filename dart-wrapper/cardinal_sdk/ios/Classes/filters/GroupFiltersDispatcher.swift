// auto-generated file
import CardinalDartSdkSupportLib

class GroupFiltersDispatcher {

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
    case "all": all(parameters: parameters, resultCallback: resultCallback)
    case "bySuperGroup": bySuperGroup(parameters: parameters, resultCallback: resultCallback)
    case "withContent": withContent(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func all(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    GroupFilters.shared.all(
    	dartResultCallback: resultCallback
    )
  }

  private static func bySuperGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    GroupFilters.shared.bySuperGroup(
    	dartResultCallback: resultCallback,
    	superGroupIdString: parameters["superGroupId"]!
    )
  }

  private static func withContent(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    GroupFilters.shared.withContent(
    	dartResultCallback: resultCallback,
    	superGroupIdString: parameters["superGroupId"]!,
    	searchStringString: parameters["searchString"]!
    )
  }

}
