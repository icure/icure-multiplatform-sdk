// auto-generated file
import CardinalDartSdkSupportLib

class HealthcarePartyFiltersDispatcher {

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
    case "byIdentifiers": byIdentifiers(parameters: parameters, resultCallback: resultCallback)
    case "byCode": byCode(parameters: parameters, resultCallback: resultCallback)
    case "byTag": byTag(parameters: parameters, resultCallback: resultCallback)
    case "byIds": byIds(parameters: parameters, resultCallback: resultCallback)
    case "byName": byName(parameters: parameters, resultCallback: resultCallback)
    case "byNationalIdentifier": byNationalIdentifier(parameters: parameters, resultCallback: resultCallback)
    case "byParentId": byParentId(parameters: parameters, resultCallback: resultCallback)
    case "byTypeSpecialtyPostCode": byTypeSpecialtyPostCode(parameters: parameters, resultCallback: resultCallback)
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
    HealthcarePartyFilters.shared.all(
    	dartResultCallback: resultCallback
    )
  }

  private static func byIdentifiers(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthcarePartyFilters.shared.byIdentifiers(
    	dartResultCallback: resultCallback,
    	identifiersString: parameters["identifiers"]!
    )
  }

  private static func byCode(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthcarePartyFilters.shared.byCode(
    	dartResultCallback: resultCallback,
    	codeTypeString: parameters["codeType"]!,
    	codeCodeString: parameters["codeCode"]!
    )
  }

  private static func byTag(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthcarePartyFilters.shared.byTag(
    	dartResultCallback: resultCallback,
    	tagTypeString: parameters["tagType"]!,
    	tagCodeString: parameters["tagCode"]!
    )
  }

  private static func byIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthcarePartyFilters.shared.byIds(
    	dartResultCallback: resultCallback,
    	idsString: parameters["ids"]!
    )
  }

  private static func byName(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthcarePartyFilters.shared.byName(
    	dartResultCallback: resultCallback,
    	searchStringString: parameters["searchString"]!,
    	descendingString: parameters["descending"]!
    )
  }

  private static func byNationalIdentifier(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthcarePartyFilters.shared.byNationalIdentifier(
    	dartResultCallback: resultCallback,
    	searchStringString: parameters["searchString"]!,
    	descendingString: parameters["descending"]!
    )
  }

  private static func byParentId(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthcarePartyFilters.shared.byParentId(
    	dartResultCallback: resultCallback,
    	parentIdString: parameters["parentId"]!
    )
  }

  private static func byTypeSpecialtyPostCode(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    HealthcarePartyFilters.shared.byTypeSpecialtyPostCode(
    	dartResultCallback: resultCallback,
    	specialtyString: parameters["specialty"]!,
    	specCodeString: parameters["specCode"]!,
    	startPostCodeString: parameters["startPostCode"]!,
    	endPostCodeString: parameters["endPostCode"]!
    )
  }

}
