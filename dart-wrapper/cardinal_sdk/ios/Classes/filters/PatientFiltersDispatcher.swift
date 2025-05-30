// auto-generated file
import CardinalDartSdkSupportLib

class PatientFiltersDispatcher {

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
    case "allPatientsForDataOwner": allPatientsForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "allPatientsForDataOwnerInGroup": allPatientsForDataOwnerInGroup(parameters: parameters, resultCallback: resultCallback)
    case "allPatientsForSelf": allPatientsForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byIds": byIds(parameters: parameters, resultCallback: resultCallback)
    case "byIdentifiersForDataOwner": byIdentifiersForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byIdentifiersForDataOwnerInGroup": byIdentifiersForDataOwnerInGroup(parameters: parameters, resultCallback: resultCallback)
    case "bySsinsForDataOwner": bySsinsForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "bySsinsForDataOwnerInGroup": bySsinsForDataOwnerInGroup(parameters: parameters, resultCallback: resultCallback)
    case "byDateOfBirthBetweenForDataOwner": byDateOfBirthBetweenForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byDateOfBirthBetweenForDataOwnerInGroup": byDateOfBirthBetweenForDataOwnerInGroup(parameters: parameters, resultCallback: resultCallback)
    case "byFuzzyNameForDataOwner": byFuzzyNameForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byFuzzyNameForDataOwnerInGroup": byFuzzyNameForDataOwnerInGroup(parameters: parameters, resultCallback: resultCallback)
    case "byGenderEducationProfessionForDataOwner": byGenderEducationProfessionForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byGenderEducationProfessionForDataOwnerInGroup": byGenderEducationProfessionForDataOwnerInGroup(parameters: parameters, resultCallback: resultCallback)
    case "byActiveForDataOwner": byActiveForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byActiveForDataOwnerInGroup": byActiveForDataOwnerInGroup(parameters: parameters, resultCallback: resultCallback)
    case "byTelecomForDataOwner": byTelecomForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byTelecomForDataOwnerInGroup": byTelecomForDataOwnerInGroup(parameters: parameters, resultCallback: resultCallback)
    case "byAddressPostalCodeHouseNumberForDataOwner": byAddressPostalCodeHouseNumberForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byAddressPostalCodeHouseNumberForDataOwnerInGroup": byAddressPostalCodeHouseNumberForDataOwnerInGroup(parameters: parameters, resultCallback: resultCallback)
    case "byAddressForDataOwner": byAddressForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byAddressForDataOwnerInGroup": byAddressForDataOwnerInGroup(parameters: parameters, resultCallback: resultCallback)
    case "byExternalIdForDataOwner": byExternalIdForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byExternalIdForDataOwnerInGroup": byExternalIdForDataOwnerInGroup(parameters: parameters, resultCallback: resultCallback)
    case "byIdentifiersForSelf": byIdentifiersForSelf(parameters: parameters, resultCallback: resultCallback)
    case "bySsinsForSelf": bySsinsForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byDateOfBirthBetweenForSelf": byDateOfBirthBetweenForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byNameForSelf": byNameForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byGenderEducationProfessionForSelf": byGenderEducationProfessionForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byActiveForSelf": byActiveForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byTelecomForSelf": byTelecomForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byAddressPostalCodeHouseNumberForSelf": byAddressPostalCodeHouseNumberForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byAddressForSelf": byAddressForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byExternalIdForSelf": byExternalIdForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byTagForSelf": byTagForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byTagForDataOwner": byTagForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byTagForDataOwnerInGroup": byTagForDataOwnerInGroup(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func allPatientsForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientFilters.shared.allPatientsForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!
    )
  }

  private static func allPatientsForDataOwnerInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientFilters.shared.allPatientsForDataOwnerInGroup(
    	dartResultCallback: resultCallback,
    	dataOwnerString: parameters["dataOwner"]!
    )
  }

  private static func allPatientsForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientFilters.shared.allPatientsForSelf(
    	dartResultCallback: resultCallback
    )
  }

  private static func byIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientFilters.shared.byIds(
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
    PatientFilters.shared.byIdentifiersForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	identifiersString: parameters["identifiers"]!
    )
  }

  private static func byIdentifiersForDataOwnerInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientFilters.shared.byIdentifiersForDataOwnerInGroup(
    	dartResultCallback: resultCallback,
    	dataOwnerString: parameters["dataOwner"]!,
    	identifiersString: parameters["identifiers"]!
    )
  }

  private static func bySsinsForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientFilters.shared.bySsinsForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	ssinsString: parameters["ssins"]!
    )
  }

  private static func bySsinsForDataOwnerInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientFilters.shared.bySsinsForDataOwnerInGroup(
    	dartResultCallback: resultCallback,
    	dataOwnerString: parameters["dataOwner"]!,
    	ssinsString: parameters["ssins"]!
    )
  }

  private static func byDateOfBirthBetweenForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientFilters.shared.byDateOfBirthBetweenForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	fromDateString: parameters["fromDate"]!,
    	toDateString: parameters["toDate"]!
    )
  }

  private static func byDateOfBirthBetweenForDataOwnerInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientFilters.shared.byDateOfBirthBetweenForDataOwnerInGroup(
    	dartResultCallback: resultCallback,
    	dataOwnerString: parameters["dataOwner"]!,
    	fromDateString: parameters["fromDate"]!,
    	toDateString: parameters["toDate"]!
    )
  }

  private static func byFuzzyNameForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientFilters.shared.byFuzzyNameForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	searchStringString: parameters["searchString"]!
    )
  }

  private static func byFuzzyNameForDataOwnerInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientFilters.shared.byFuzzyNameForDataOwnerInGroup(
    	dartResultCallback: resultCallback,
    	dataOwnerString: parameters["dataOwner"]!,
    	searchStringString: parameters["searchString"]!
    )
  }

  private static func byGenderEducationProfessionForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientFilters.shared.byGenderEducationProfessionForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	genderString: parameters["gender"]!,
    	educationString: parameters["education"]!,
    	professionString: parameters["profession"]!
    )
  }

  private static func byGenderEducationProfessionForDataOwnerInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientFilters.shared.byGenderEducationProfessionForDataOwnerInGroup(
    	dartResultCallback: resultCallback,
    	dataOwnerString: parameters["dataOwner"]!,
    	genderString: parameters["gender"]!,
    	educationString: parameters["education"]!,
    	professionString: parameters["profession"]!
    )
  }

  private static func byActiveForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientFilters.shared.byActiveForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	activeString: parameters["active"]!
    )
  }

  private static func byActiveForDataOwnerInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientFilters.shared.byActiveForDataOwnerInGroup(
    	dartResultCallback: resultCallback,
    	dataOwnerString: parameters["dataOwner"]!,
    	activeString: parameters["active"]!
    )
  }

  private static func byTelecomForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientFilters.shared.byTelecomForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	searchStringString: parameters["searchString"]!
    )
  }

  private static func byTelecomForDataOwnerInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientFilters.shared.byTelecomForDataOwnerInGroup(
    	dartResultCallback: resultCallback,
    	dataOwnerString: parameters["dataOwner"]!,
    	searchStringString: parameters["searchString"]!
    )
  }

  private static func byAddressPostalCodeHouseNumberForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientFilters.shared.byAddressPostalCodeHouseNumberForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	searchStringString: parameters["searchString"]!,
    	postalCodeString: parameters["postalCode"]!,
    	houseNumberString: parameters["houseNumber"]!
    )
  }

  private static func byAddressPostalCodeHouseNumberForDataOwnerInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientFilters.shared.byAddressPostalCodeHouseNumberForDataOwnerInGroup(
    	dartResultCallback: resultCallback,
    	dataOwnerString: parameters["dataOwner"]!,
    	searchStringString: parameters["searchString"]!,
    	postalCodeString: parameters["postalCode"]!,
    	houseNumberString: parameters["houseNumber"]!
    )
  }

  private static func byAddressForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientFilters.shared.byAddressForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	searchStringString: parameters["searchString"]!
    )
  }

  private static func byAddressForDataOwnerInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientFilters.shared.byAddressForDataOwnerInGroup(
    	dartResultCallback: resultCallback,
    	dataOwnerString: parameters["dataOwner"]!,
    	searchStringString: parameters["searchString"]!
    )
  }

  private static func byExternalIdForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientFilters.shared.byExternalIdForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	externalIdPrefixString: parameters["externalIdPrefix"]!
    )
  }

  private static func byExternalIdForDataOwnerInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientFilters.shared.byExternalIdForDataOwnerInGroup(
    	dartResultCallback: resultCallback,
    	dataOwnerString: parameters["dataOwner"]!,
    	externalIdPrefixString: parameters["externalIdPrefix"]!
    )
  }

  private static func byIdentifiersForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientFilters.shared.byIdentifiersForSelf(
    	dartResultCallback: resultCallback,
    	identifiersString: parameters["identifiers"]!
    )
  }

  private static func bySsinsForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientFilters.shared.bySsinsForSelf(
    	dartResultCallback: resultCallback,
    	ssinsString: parameters["ssins"]!
    )
  }

  private static func byDateOfBirthBetweenForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientFilters.shared.byDateOfBirthBetweenForSelf(
    	dartResultCallback: resultCallback,
    	fromDateString: parameters["fromDate"]!,
    	toDateString: parameters["toDate"]!
    )
  }

  private static func byNameForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientFilters.shared.byNameForSelf(
    	dartResultCallback: resultCallback,
    	searchStringString: parameters["searchString"]!
    )
  }

  private static func byGenderEducationProfessionForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientFilters.shared.byGenderEducationProfessionForSelf(
    	dartResultCallback: resultCallback,
    	genderString: parameters["gender"]!,
    	educationString: parameters["education"]!,
    	professionString: parameters["profession"]!
    )
  }

  private static func byActiveForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientFilters.shared.byActiveForSelf(
    	dartResultCallback: resultCallback,
    	activeString: parameters["active"]!
    )
  }

  private static func byTelecomForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientFilters.shared.byTelecomForSelf(
    	dartResultCallback: resultCallback,
    	searchStringString: parameters["searchString"]!
    )
  }

  private static func byAddressPostalCodeHouseNumberForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientFilters.shared.byAddressPostalCodeHouseNumberForSelf(
    	dartResultCallback: resultCallback,
    	searchStringString: parameters["searchString"]!,
    	postalCodeString: parameters["postalCode"]!,
    	houseNumberString: parameters["houseNumber"]!
    )
  }

  private static func byAddressForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientFilters.shared.byAddressForSelf(
    	dartResultCallback: resultCallback,
    	searchStringString: parameters["searchString"]!
    )
  }

  private static func byExternalIdForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientFilters.shared.byExternalIdForSelf(
    	dartResultCallback: resultCallback,
    	externalIdPrefixString: parameters["externalIdPrefix"]!
    )
  }

  private static func byTagForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientFilters.shared.byTagForSelf(
    	dartResultCallback: resultCallback,
    	tagTypeString: parameters["tagType"]!,
    	tagCodeString: parameters["tagCode"]!
    )
  }

  private static func byTagForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientFilters.shared.byTagForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	tagTypeString: parameters["tagType"]!,
    	tagCodeString: parameters["tagCode"]!
    )
  }

  private static func byTagForDataOwnerInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientFilters.shared.byTagForDataOwnerInGroup(
    	dartResultCallback: resultCallback,
    	dataOwnerString: parameters["dataOwner"]!,
    	tagTypeString: parameters["tagType"]!,
    	tagCodeString: parameters["tagCode"]!
    )
  }

}
