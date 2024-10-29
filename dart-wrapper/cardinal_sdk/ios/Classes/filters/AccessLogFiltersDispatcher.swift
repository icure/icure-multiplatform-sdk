// auto-generated file
import CardinalDartSdkSupportLib

class AccessLogFiltersDispatcher {

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
    case "byPatientsDateForDataOwner": byPatientsDateForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byPatientsDateForSelf": byPatientsDateForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byPatientSecretIdsDateForDataOwner": byPatientSecretIdsDateForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byPatientSecretIdsDateForSelf": byPatientSecretIdsDateForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byDate": byDate(parameters: parameters, resultCallback: resultCallback)
    case "byUserTypeDate": byUserTypeDate(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func byPatientsDateForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogFilters.shared.byPatientsDateForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	patientsString: parameters["patients"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!,
    	descendingString: parameters["descending"]!
    )
  }

  private static func byPatientsDateForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogFilters.shared.byPatientsDateForSelf(
    	dartResultCallback: resultCallback,
    	patientsString: parameters["patients"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!,
    	descendingString: parameters["descending"]!
    )
  }

  private static func byPatientSecretIdsDateForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogFilters.shared.byPatientSecretIdsDateForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	secretIdsString: parameters["secretIds"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!,
    	descendingString: parameters["descending"]!
    )
  }

  private static func byPatientSecretIdsDateForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogFilters.shared.byPatientSecretIdsDateForSelf(
    	dartResultCallback: resultCallback,
    	secretIdsString: parameters["secretIds"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!,
    	descendingString: parameters["descending"]!
    )
  }

  private static func byDate(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogFilters.shared.byDate(
    	dartResultCallback: resultCallback,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!,
    	descendingString: parameters["descending"]!
    )
  }

  private static func byUserTypeDate(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    AccessLogFilters.shared.byUserTypeDate(
    	dartResultCallback: resultCallback,
    	userIdString: parameters["userId"]!,
    	accessTypeString: parameters["accessType"]!,
    	fromString: parameters["from"]!,
    	descendingString: parameters["descending"]!
    )
  }

}
