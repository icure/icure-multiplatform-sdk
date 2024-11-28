// auto-generated file
import CardinalDartSdkSupportLib

class MaintenanceTaskFiltersDispatcher {

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
    case "byIds": byIds(parameters: parameters, resultCallback: resultCallback)
    case "byIdentifiersForDataOwner": byIdentifiersForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byIdentifiersForSelf": byIdentifiersForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byTypeForDataOwner": byTypeForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byTypeForSelf": byTypeForSelf(parameters: parameters, resultCallback: resultCallback)
    case "afterDateForDataOwner": afterDateForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "afterDateForSelf": afterDateForSelf(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func byIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskFilters.shared.byIds(
    	dartResultCallback: resultCallback,
    	idsString: parameters["ids"]!
    )
  }

  private static func byIdentifiersForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskFilters.shared.byIdentifiersForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	identifiersString: parameters["identifiers"]!
    )
  }

  private static func byIdentifiersForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskFilters.shared.byIdentifiersForSelf(
    	dartResultCallback: resultCallback,
    	identifiersString: parameters["identifiers"]!
    )
  }

  private static func byTypeForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskFilters.shared.byTypeForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	typeString: parameters["type"]!
    )
  }

  private static func byTypeForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskFilters.shared.byTypeForSelf(
    	dartResultCallback: resultCallback,
    	typeString: parameters["type"]!
    )
  }

  private static func afterDateForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskFilters.shared.afterDateForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	dateString: parameters["date"]!
    )
  }

  private static func afterDateForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskFilters.shared.afterDateForSelf(
    	dartResultCallback: resultCallback,
    	dateString: parameters["date"]!
    )
  }

}
