// auto-generated file
import CardinalDartSdkSupportLib

class DocumentFiltersDispatcher {

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
    case "byPatientsCreatedForDataOwner": byPatientsCreatedForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byPatientsCreatedForSelf": byPatientsCreatedForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byPatientSecretIdsCreatedForDataOwner": byPatientSecretIdsCreatedForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byPatientSecretIdsCreatedForSelf": byPatientSecretIdsCreatedForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byPatientsAndTypeForDataOwner": byPatientsAndTypeForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byPatientsAndTypeForSelf": byPatientsAndTypeForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byPatientSecretIdsAndTypeForDataOwner": byPatientSecretIdsAndTypeForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byPatientSecretIdsAndTypeForSelf": byPatientSecretIdsAndTypeForSelf(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func byPatientsCreatedForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentFilters.shared.byPatientsCreatedForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	patientsString: parameters["patients"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!,
    	descendingString: parameters["descending"]!
    )
  }

  private static func byPatientsCreatedForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentFilters.shared.byPatientsCreatedForSelf(
    	dartResultCallback: resultCallback,
    	patientsString: parameters["patients"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!,
    	descendingString: parameters["descending"]!
    )
  }

  private static func byPatientSecretIdsCreatedForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentFilters.shared.byPatientSecretIdsCreatedForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	secretIdsString: parameters["secretIds"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!,
    	descendingString: parameters["descending"]!
    )
  }

  private static func byPatientSecretIdsCreatedForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentFilters.shared.byPatientSecretIdsCreatedForSelf(
    	dartResultCallback: resultCallback,
    	secretIdsString: parameters["secretIds"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!,
    	descendingString: parameters["descending"]!
    )
  }

  private static func byPatientsAndTypeForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentFilters.shared.byPatientsAndTypeForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	documentTypeString: parameters["documentType"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func byPatientsAndTypeForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentFilters.shared.byPatientsAndTypeForSelf(
    	dartResultCallback: resultCallback,
    	documentTypeString: parameters["documentType"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func byPatientSecretIdsAndTypeForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentFilters.shared.byPatientSecretIdsAndTypeForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	documentTypeString: parameters["documentType"]!,
    	secretIdsString: parameters["secretIds"]!
    )
  }

  private static func byPatientSecretIdsAndTypeForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentFilters.shared.byPatientSecretIdsAndTypeForSelf(
    	dartResultCallback: resultCallback,
    	documentTypeString: parameters["documentType"]!,
    	secretIdsString: parameters["secretIds"]!
    )
  }

}
