// auto-generated file
import CardinalDartSdkSupportLib

class CodeFiltersDispatcher {

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
    case "all": all(parameters: parameters, resultCallback: resultCallback)
    case "byIds": byIds(parameters: parameters, resultCallback: resultCallback)
    case "byQualifiedLink": byQualifiedLink(parameters: parameters, resultCallback: resultCallback)
    case "byRegionTypeCodeVersion": byRegionTypeCodeVersion(parameters: parameters, resultCallback: resultCallback)
    case "byLanguageTypeLabelRegion": byLanguageTypeLabelRegion(parameters: parameters, resultCallback: resultCallback)
    case "byLanguageTypesLabelRegionVersion": byLanguageTypesLabelRegionVersion(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func all(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    CodeFilters.shared.all(
    	dartResultCallback: resultCallback
    )
  }

  private static func byIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    CodeFilters.shared.byIds(
    	dartResultCallback: resultCallback,
    	idsString: parameters["ids"]!
    )
  }

  private static func byQualifiedLink(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    CodeFilters.shared.byQualifiedLink(
    	dartResultCallback: resultCallback,
    	linkTypeString: parameters["linkType"]!,
    	linkedIdString: parameters["linkedId"]!
    )
  }

  private static func byRegionTypeCodeVersion(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    CodeFilters.shared.byRegionTypeCodeVersion(
    	dartResultCallback: resultCallback,
    	regionString: parameters["region"]!,
    	typeString: parameters["type"]!,
    	codeString: parameters["code"]!,
    	versionString: parameters["version"]!
    )
  }

  private static func byLanguageTypeLabelRegion(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    CodeFilters.shared.byLanguageTypeLabelRegion(
    	dartResultCallback: resultCallback,
    	languageString: parameters["language"]!,
    	typeString: parameters["type"]!,
    	labelString: parameters["label"]!,
    	regionString: parameters["region"]!
    )
  }

  private static func byLanguageTypesLabelRegionVersion(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    CodeFilters.shared.byLanguageTypesLabelRegionVersion(
    	dartResultCallback: resultCallback,
    	languageString: parameters["language"]!,
    	typesString: parameters["types"]!,
    	labelString: parameters["label"]!,
    	regionString: parameters["region"]!,
    	versionString: parameters["version"]!
    )
  }

}
