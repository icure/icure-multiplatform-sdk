// auto-generated file
import CardinalDartSdkSupportLib

class ServiceFiltersDispatcher {

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
    case "allServicesForDataOwner": allServicesForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "allServicesForSelf": allServicesForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byIdentifiersForDataOwner": byIdentifiersForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byCodeAndValueDateForDataOwner": byCodeAndValueDateForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byTagAndValueDateForDataOwner": byTagAndValueDateForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byPatientsForDataOwner": byPatientsForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byPatientsSecretIdsForDataOwner": byPatientsSecretIdsForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byHealthElementIdFromSubContactForDataOwner": byHealthElementIdFromSubContactForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byIdentifiersForSelf": byIdentifiersForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byCodeAndValueDateForSelf": byCodeAndValueDateForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byTagAndValueDateForSelf": byTagAndValueDateForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byPatientsForSelf": byPatientsForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byPatientsSecretIdsForSelf": byPatientsSecretIdsForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byHealthElementIdFromSubContactForSelf": byHealthElementIdFromSubContactForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byIds": byIds(parameters: parameters, resultCallback: resultCallback)
    case "byAssociationId": byAssociationId(parameters: parameters, resultCallback: resultCallback)
    case "byQualifiedLink": byQualifiedLink(parameters: parameters, resultCallback: resultCallback)
    case "byPatientsDateForDataOwner": byPatientsDateForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byPatientsDateForSelf": byPatientsDateForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byPatientSecretIdsDateForDataOwner": byPatientSecretIdsDateForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byPatientSecretIdsDateForSelf": byPatientSecretIdsDateForSelf(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func allServicesForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ServiceFilters.shared.allServicesForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!
    )
  }

  private static func allServicesForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ServiceFilters.shared.allServicesForSelf(
    	dartResultCallback: resultCallback
    )
  }

  private static func byIdentifiersForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ServiceFilters.shared.byIdentifiersForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	identifiersString: parameters["identifiers"]!
    )
  }

  private static func byCodeAndValueDateForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ServiceFilters.shared.byCodeAndValueDateForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	codeTypeString: parameters["codeType"]!,
    	codeCodeString: parameters["codeCode"]!,
    	startOfServiceValueDateString: parameters["startOfServiceValueDate"]!,
    	endOfServiceValueDateString: parameters["endOfServiceValueDate"]!
    )
  }

  private static func byTagAndValueDateForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ServiceFilters.shared.byTagAndValueDateForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	tagTypeString: parameters["tagType"]!,
    	tagCodeString: parameters["tagCode"]!,
    	startOfServiceValueDateString: parameters["startOfServiceValueDate"]!,
    	endOfServiceValueDateString: parameters["endOfServiceValueDate"]!
    )
  }

  private static func byPatientsForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ServiceFilters.shared.byPatientsForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func byPatientsSecretIdsForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ServiceFilters.shared.byPatientsSecretIdsForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	secretIdsString: parameters["secretIds"]!
    )
  }

  private static func byHealthElementIdFromSubContactForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ServiceFilters.shared.byHealthElementIdFromSubContactForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	healthElementIdsString: parameters["healthElementIds"]!
    )
  }

  private static func byIdentifiersForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ServiceFilters.shared.byIdentifiersForSelf(
    	dartResultCallback: resultCallback,
    	identifiersString: parameters["identifiers"]!
    )
  }

  private static func byCodeAndValueDateForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ServiceFilters.shared.byCodeAndValueDateForSelf(
    	dartResultCallback: resultCallback,
    	codeTypeString: parameters["codeType"]!,
    	codeCodeString: parameters["codeCode"]!,
    	startOfServiceValueDateString: parameters["startOfServiceValueDate"]!,
    	endOfServiceValueDateString: parameters["endOfServiceValueDate"]!
    )
  }

  private static func byTagAndValueDateForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ServiceFilters.shared.byTagAndValueDateForSelf(
    	dartResultCallback: resultCallback,
    	tagTypeString: parameters["tagType"]!,
    	tagCodeString: parameters["tagCode"]!,
    	startOfServiceValueDateString: parameters["startOfServiceValueDate"]!,
    	endOfServiceValueDateString: parameters["endOfServiceValueDate"]!
    )
  }

  private static func byPatientsForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ServiceFilters.shared.byPatientsForSelf(
    	dartResultCallback: resultCallback,
    	patientsString: parameters["patients"]!
    )
  }

  private static func byPatientsSecretIdsForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ServiceFilters.shared.byPatientsSecretIdsForSelf(
    	dartResultCallback: resultCallback,
    	secretIdsString: parameters["secretIds"]!
    )
  }

  private static func byHealthElementIdFromSubContactForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ServiceFilters.shared.byHealthElementIdFromSubContactForSelf(
    	dartResultCallback: resultCallback,
    	healthElementIdsString: parameters["healthElementIds"]!
    )
  }

  private static func byIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ServiceFilters.shared.byIds(
    	dartResultCallback: resultCallback,
    	idsString: parameters["ids"]!
    )
  }

  private static func byAssociationId(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ServiceFilters.shared.byAssociationId(
    	dartResultCallback: resultCallback,
    	associationIdString: parameters["associationId"]!
    )
  }

  private static func byQualifiedLink(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ServiceFilters.shared.byQualifiedLink(
    	dartResultCallback: resultCallback,
    	linkValuesString: parameters["linkValues"]!,
    	linkQualificationString: parameters["linkQualification"]!
    )
  }

  private static func byPatientsDateForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ServiceFilters.shared.byPatientsDateForDataOwner(
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
    String?,
    String?
  ) -> Void) {
    ServiceFilters.shared.byPatientsDateForSelf(
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
    String?,
    String?
  ) -> Void) {
    ServiceFilters.shared.byPatientSecretIdsDateForDataOwner(
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
    String?,
    String?
  ) -> Void) {
    ServiceFilters.shared.byPatientSecretIdsDateForSelf(
    	dartResultCallback: resultCallback,
    	secretIdsString: parameters["secretIds"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!,
    	descendingString: parameters["descending"]!
    )
  }

}
