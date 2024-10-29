// auto-generated file
import CardinalDartSdkSupportLib

class HealthElementFiltersDispatcher {

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
    case "allHealthElementsForDataOwner": allHealthElementsForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "allHealthElementsForSelf": allHealthElementsForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byIdentifiersForDataOwner": byIdentifiersForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byIdentifiersForSelf": byIdentifiersForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byCodeForDataOwner": byCodeForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byCodeForSelf": byCodeForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byTagForDataOwner": byTagForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byTagForSelf": byTagForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byPatientsForDataOwner": byPatientsForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byPatientsForSelf": byPatientsForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byPatientsSecretIdsForDataOwner": byPatientsSecretIdsForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byPatientsSecretIdsForSelf": byPatientsSecretIdsForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byIds": byIds(parameters: parameters, resultCallback: resultCallback)
    case "byPatientsOpeningDateForDataOwner": byPatientsOpeningDateForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byPatientsOpeningDateForSelf": byPatientsOpeningDateForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byPatientSecretIdsOpeningDateForDataOwner": byPatientSecretIdsOpeningDateForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byPatientSecretIdsOpeningDateForSelf": byPatientSecretIdsOpeningDateForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byStatusForDataOwner": byStatusForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byStatusForSelf": byStatusForSelf(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func allHealthElementsForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementFilters.shared.allHealthElementsForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!
    )
  }

  private static func allHealthElementsForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementFilters.shared.allHealthElementsForSelf(
    	dartResultCallback: resultCallback
    )
  }

  private static func byIdentifiersForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementFilters.shared.byIdentifiersForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	identifiersString: parameters["identifiers"]!
    )
  }

  private static func byIdentifiersForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementFilters.shared.byIdentifiersForSelf(
    	dartResultCallback: resultCallback,
    	identifiersString: parameters["identifiers"]!
    )
  }

  private static func byCodeForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementFilters.shared.byCodeForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	codeTypeString: parameters["codeType"]!,
    	codeCodeString: parameters["codeCode"]!
    )
  }

  private static func byCodeForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementFilters.shared.byCodeForSelf(
    	dartResultCallback: resultCallback,
    	codeTypeString: parameters["codeType"]!,
    	codeCodeString: parameters["codeCode"]!
    )
  }

  private static func byTagForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementFilters.shared.byTagForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	tagTypeString: parameters["tagType"]!,
    	tagCodeString: parameters["tagCode"]!
    )
  }

  private static func byTagForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementFilters.shared.byTagForSelf(
    	dartResultCallback: resultCallback,
    	tagTypeString: parameters["tagType"]!,
    	tagCodeString: parameters["tagCode"]!
    )
  }

  private static func byPatientsForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementFilters.shared.byPatientsForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func byPatientsForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementFilters.shared.byPatientsForSelf(
    	dartResultCallback: resultCallback,
    	patientsString: parameters["patients"]!
    )
  }

  private static func byPatientsSecretIdsForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementFilters.shared.byPatientsSecretIdsForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	secretIdsString: parameters["secretIds"]!
    )
  }

  private static func byPatientsSecretIdsForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementFilters.shared.byPatientsSecretIdsForSelf(
    	dartResultCallback: resultCallback,
    	secretIdsString: parameters["secretIds"]!
    )
  }

  private static func byIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementFilters.shared.byIds(
    	dartResultCallback: resultCallback,
    	idsString: parameters["ids"]!
    )
  }

  private static func byPatientsOpeningDateForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementFilters.shared.byPatientsOpeningDateForDataOwner(
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
    String?
  ) -> Void) {
    HealthElementFilters.shared.byPatientsOpeningDateForSelf(
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
    String?
  ) -> Void) {
    HealthElementFilters.shared.byPatientSecretIdsOpeningDateForDataOwner(
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
    String?
  ) -> Void) {
    HealthElementFilters.shared.byPatientSecretIdsOpeningDateForSelf(
    	dartResultCallback: resultCallback,
    	secretIdsString: parameters["secretIds"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!,
    	descendingString: parameters["descending"]!
    )
  }

  private static func byStatusForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementFilters.shared.byStatusForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	statusString: parameters["status"]!
    )
  }

  private static func byStatusForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    HealthElementFilters.shared.byStatusForSelf(
    	dartResultCallback: resultCallback,
    	statusString: parameters["status"]!
    )
  }

}
