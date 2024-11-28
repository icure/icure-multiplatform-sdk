// auto-generated file
import CardinalDartSdkSupportLib

class FormFiltersDispatcher {

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
    case "byParentIdForDataOwner": byParentIdForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byParentIdForSelf": byParentIdForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byPatientsOpeningDateForDataOwner": byPatientsOpeningDateForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byPatientsOpeningDateForSelf": byPatientsOpeningDateForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byPatientSecretIdsOpeningDateForDataOwner": byPatientSecretIdsOpeningDateForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byPatientSecretIdsOpeningDateForSelf": byPatientSecretIdsOpeningDateForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byLogicalUuid": byLogicalUuid(parameters: parameters, resultCallback: resultCallback)
    case "byUniqueId": byUniqueId(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func byParentIdForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormFilters.shared.byParentIdForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	parentIdString: parameters["parentId"]!
    )
  }

  private static func byParentIdForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormFilters.shared.byParentIdForSelf(
    	dartResultCallback: resultCallback,
    	parentIdString: parameters["parentId"]!
    )
  }

  private static func byPatientsOpeningDateForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormFilters.shared.byPatientsOpeningDateForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	patientsString: parameters["patients"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!,
    	descendingString: parameters["descending"]!
    )
  }

  private static func byPatientsOpeningDateForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormFilters.shared.byPatientsOpeningDateForSelf(
    	dartResultCallback: resultCallback,
    	patientsString: parameters["patients"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!,
    	descendingString: parameters["descending"]!
    )
  }

  private static func byPatientSecretIdsOpeningDateForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormFilters.shared.byPatientSecretIdsOpeningDateForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	secretIdsString: parameters["secretIds"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!,
    	descendingString: parameters["descending"]!
    )
  }

  private static func byPatientSecretIdsOpeningDateForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormFilters.shared.byPatientSecretIdsOpeningDateForSelf(
    	dartResultCallback: resultCallback,
    	secretIdsString: parameters["secretIds"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!,
    	descendingString: parameters["descending"]!
    )
  }

  private static func byLogicalUuid(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormFilters.shared.byLogicalUuid(
    	dartResultCallback: resultCallback,
    	logicalUuidString: parameters["logicalUuid"]!,
    	descendingString: parameters["descending"]!
    )
  }

  private static func byUniqueId(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    FormFilters.shared.byUniqueId(
    	dartResultCallback: resultCallback,
    	uniqueIdString: parameters["uniqueId"]!,
    	descendingString: parameters["descending"]!
    )
  }

}
