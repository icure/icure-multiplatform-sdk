// auto-generated file
import CardinalDartSdkSupportLib

class ContactFiltersDispatcher {

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
    case "allContactsForDataOwner": allContactsForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "allContactsForSelf": allContactsForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byFormIdsForDataOwner": byFormIdsForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byFormIdsForSelf": byFormIdsForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byPatientsOpeningDateForDataOwner": byPatientsOpeningDateForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byPatientsOpeningDateForSelf": byPatientsOpeningDateForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byPatientSecretIdsOpeningDateForDataOwner": byPatientSecretIdsOpeningDateForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byPatientSecretIdsOpeningDateForSelf": byPatientSecretIdsOpeningDateForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byExternalId": byExternalId(parameters: parameters, resultCallback: resultCallback)
    case "byIdentifiersForSelf": byIdentifiersForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byIdentifiersForDataOwner": byIdentifiersForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byCodeAndOpeningDateForDataOwner": byCodeAndOpeningDateForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byCodeAndOpeningDateForSelf": byCodeAndOpeningDateForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byTagAndOpeningDateForDataOwner": byTagAndOpeningDateForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byOpeningDateForDataOwner": byOpeningDateForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byOpeningDateForSelf": byOpeningDateForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byServiceTagForSelf": byServiceTagForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byServiceTagForDataOwner": byServiceTagForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byServiceCodeForSelf": byServiceCodeForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byServiceCodeForDataOwner": byServiceCodeForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byTagAndOpeningDateForSelf": byTagAndOpeningDateForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byPatientsForDataOwner": byPatientsForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byPatientsForSelf": byPatientsForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byPatientsSecretIdsForDataOwner": byPatientsSecretIdsForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byPatientsSecretIdsForSelf": byPatientsSecretIdsForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byServiceIds": byServiceIds(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func allContactsForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactFilters.shared.allContactsForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!
    )
  }

  private static func allContactsForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactFilters.shared.allContactsForSelf(
    	dartResultCallback: resultCallback
    )
  }

  private static func byFormIdsForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactFilters.shared.byFormIdsForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	formIdsString: parameters["formIds"]!
    )
  }

  private static func byFormIdsForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactFilters.shared.byFormIdsForSelf(
    	dartResultCallback: resultCallback,
    	formIdsString: parameters["formIds"]!
    )
  }

  private static func byPatientsOpeningDateForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactFilters.shared.byPatientsOpeningDateForDataOwner(
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
    ContactFilters.shared.byPatientsOpeningDateForSelf(
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
    ContactFilters.shared.byPatientSecretIdsOpeningDateForDataOwner(
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
    ContactFilters.shared.byPatientSecretIdsOpeningDateForSelf(
    	dartResultCallback: resultCallback,
    	secretIdsString: parameters["secretIds"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!,
    	descendingString: parameters["descending"]!
    )
  }

  private static func byExternalId(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactFilters.shared.byExternalId(
    	dartResultCallback: resultCallback,
    	externalIdString: parameters["externalId"]!
    )
  }

  private static func byIdentifiersForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactFilters.shared.byIdentifiersForSelf(
    	dartResultCallback: resultCallback,
    	identifiersString: parameters["identifiers"]!
    )
  }

  private static func byIdentifiersForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactFilters.shared.byIdentifiersForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	identifiersString: parameters["identifiers"]!
    )
  }

  private static func byCodeAndOpeningDateForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactFilters.shared.byCodeAndOpeningDateForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	codeTypeString: parameters["codeType"]!,
    	codeCodeString: parameters["codeCode"]!,
    	startOfContactOpeningDateString: parameters["startOfContactOpeningDate"]!,
    	endOfContactOpeningDateString: parameters["endOfContactOpeningDate"]!
    )
  }

  private static func byCodeAndOpeningDateForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactFilters.shared.byCodeAndOpeningDateForSelf(
    	dartResultCallback: resultCallback,
    	codeTypeString: parameters["codeType"]!,
    	codeCodeString: parameters["codeCode"]!,
    	startOfContactOpeningDateString: parameters["startOfContactOpeningDate"]!,
    	endOfContactOpeningDateString: parameters["endOfContactOpeningDate"]!
    )
  }

  private static func byTagAndOpeningDateForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactFilters.shared.byTagAndOpeningDateForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	tagTypeString: parameters["tagType"]!,
    	tagCodeString: parameters["tagCode"]!,
    	startOfContactOpeningDateString: parameters["startOfContactOpeningDate"]!,
    	endOfContactOpeningDateString: parameters["endOfContactOpeningDate"]!
    )
  }

  private static func byOpeningDateForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactFilters.shared.byOpeningDateForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	startDateString: parameters["startDate"]!,
    	endDateString: parameters["endDate"]!,
    	descendingString: parameters["descending"]!
    )
  }

  private static func byOpeningDateForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactFilters.shared.byOpeningDateForSelf(
    	dartResultCallback: resultCallback,
    	startDateString: parameters["startDate"]!,
    	endDateString: parameters["endDate"]!,
    	descendingString: parameters["descending"]!
    )
  }

  private static func byServiceTagForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactFilters.shared.byServiceTagForSelf(
    	dartResultCallback: resultCallback,
    	tagTypeString: parameters["tagType"]!,
    	tagCodeString: parameters["tagCode"]!
    )
  }

  private static func byServiceTagForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactFilters.shared.byServiceTagForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	tagTypeString: parameters["tagType"]!,
    	tagCodeString: parameters["tagCode"]!
    )
  }

  private static func byServiceCodeForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactFilters.shared.byServiceCodeForSelf(
    	dartResultCallback: resultCallback,
    	codeTypeString: parameters["codeType"]!,
    	codeCodeString: parameters["codeCode"]!
    )
  }

  private static func byServiceCodeForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactFilters.shared.byServiceCodeForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	codeTypeString: parameters["codeType"]!,
    	codeCodeString: parameters["codeCode"]!
    )
  }

  private static func byTagAndOpeningDateForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactFilters.shared.byTagAndOpeningDateForSelf(
    	dartResultCallback: resultCallback,
    	tagTypeString: parameters["tagType"]!,
    	tagCodeString: parameters["tagCode"]!,
    	startOfContactOpeningDateString: parameters["startOfContactOpeningDate"]!,
    	endOfContactOpeningDateString: parameters["endOfContactOpeningDate"]!
    )
  }

  private static func byPatientsForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactFilters.shared.byPatientsForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func byPatientsForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactFilters.shared.byPatientsForSelf(
    	dartResultCallback: resultCallback,
    	patientsString: parameters["patients"]!
    )
  }

  private static func byPatientsSecretIdsForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactFilters.shared.byPatientsSecretIdsForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	secretIdsString: parameters["secretIds"]!
    )
  }

  private static func byPatientsSecretIdsForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactFilters.shared.byPatientsSecretIdsForSelf(
    	dartResultCallback: resultCallback,
    	secretIdsString: parameters["secretIds"]!
    )
  }

  private static func byServiceIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactFilters.shared.byServiceIds(
    	dartResultCallback: resultCallback,
    	serviceIdsString: parameters["serviceIds"]!
    )
  }

}
