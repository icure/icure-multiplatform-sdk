// auto-generated file
import CardinalDartSdkSupportLib

class AgendaFiltersDispatcher {

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
    case "byUser": byUser(parameters: parameters, resultCallback: resultCallback)
    case "byUserInGroup": byUserInGroup(parameters: parameters, resultCallback: resultCallback)
    case "readableByUser": readableByUser(parameters: parameters, resultCallback: resultCallback)
    case "readableByUserInGroup": readableByUserInGroup(parameters: parameters, resultCallback: resultCallback)
    case "readableByUserRights": readableByUserRights(parameters: parameters, resultCallback: resultCallback)
    case "readableByUserRightsInGroup": readableByUserRightsInGroup(parameters: parameters, resultCallback: resultCallback)
    case "byStringProperty": byStringProperty(parameters: parameters, resultCallback: resultCallback)
    case "byBooleanProperty": byBooleanProperty(parameters: parameters, resultCallback: resultCallback)
    case "byLongProperty": byLongProperty(parameters: parameters, resultCallback: resultCallback)
    case "byDoubleProperty": byDoubleProperty(parameters: parameters, resultCallback: resultCallback)
    case "withProperty": withProperty(parameters: parameters, resultCallback: resultCallback)
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
    AgendaFilters.shared.all(
    	dartResultCallback: resultCallback
    )
  }

  private static func byUser(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaFilters.shared.byUser(
    	dartResultCallback: resultCallback,
    	userIdString: parameters["userId"]!
    )
  }

  private static func byUserInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaFilters.shared.byUserInGroup(
    	dartResultCallback: resultCallback,
    	userReferenceString: parameters["userReference"]!
    )
  }

  private static func readableByUser(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaFilters.shared.readableByUser(
    	dartResultCallback: resultCallback,
    	userIdString: parameters["userId"]!
    )
  }

  private static func readableByUserInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaFilters.shared.readableByUserInGroup(
    	dartResultCallback: resultCallback,
    	userReferenceString: parameters["userReference"]!
    )
  }

  private static func readableByUserRights(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaFilters.shared.readableByUserRights(
    	dartResultCallback: resultCallback,
    	userIdString: parameters["userId"]!
    )
  }

  private static func readableByUserRightsInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaFilters.shared.readableByUserRightsInGroup(
    	dartResultCallback: resultCallback,
    	userReferenceString: parameters["userReference"]!
    )
  }

  private static func byStringProperty(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaFilters.shared.byStringProperty(
    	dartResultCallback: resultCallback,
    	propertyIdString: parameters["propertyId"]!,
    	propertyValueString: parameters["propertyValue"]!
    )
  }

  private static func byBooleanProperty(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaFilters.shared.byBooleanProperty(
    	dartResultCallback: resultCallback,
    	propertyIdString: parameters["propertyId"]!,
    	propertyValueString: parameters["propertyValue"]!
    )
  }

  private static func byLongProperty(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaFilters.shared.byLongProperty(
    	dartResultCallback: resultCallback,
    	propertyIdString: parameters["propertyId"]!,
    	propertyValueString: parameters["propertyValue"]!
    )
  }

  private static func byDoubleProperty(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaFilters.shared.byDoubleProperty(
    	dartResultCallback: resultCallback,
    	propertyIdString: parameters["propertyId"]!,
    	propertyValueString: parameters["propertyValue"]!
    )
  }

  private static func withProperty(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaFilters.shared.withProperty(
    	dartResultCallback: resultCallback,
    	propertyIdString: parameters["propertyId"]!
    )
  }

}
