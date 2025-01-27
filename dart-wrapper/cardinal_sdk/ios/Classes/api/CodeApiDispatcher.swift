// auto-generated file
import CardinalDartSdkSupportLib

class CodeApiDispatcher {

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
    case "listCodesByRegionTypeCodeVersion": listCodesByRegionTypeCodeVersion(parameters: parameters, resultCallback: resultCallback)
    case "listCodeTypesBy": listCodeTypesBy(parameters: parameters, resultCallback: resultCallback)
    case "listTagTypesBy": listTagTypesBy(parameters: parameters, resultCallback: resultCallback)
    case "createCode": createCode(parameters: parameters, resultCallback: resultCallback)
    case "createCodes": createCodes(parameters: parameters, resultCallback: resultCallback)
    case "createCodesInGroup": createCodesInGroup(parameters: parameters, resultCallback: resultCallback)
    case "isCodeValid": isCodeValid(parameters: parameters, resultCallback: resultCallback)
    case "getCodeByRegionLanguageTypeLabel": getCodeByRegionLanguageTypeLabel(parameters: parameters, resultCallback: resultCallback)
    case "getCodes": getCodes(parameters: parameters, resultCallback: resultCallback)
    case "getCodesInGroup": getCodesInGroup(parameters: parameters, resultCallback: resultCallback)
    case "getCode": getCode(parameters: parameters, resultCallback: resultCallback)
    case "getCodeWithParts": getCodeWithParts(parameters: parameters, resultCallback: resultCallback)
    case "modifyCode": modifyCode(parameters: parameters, resultCallback: resultCallback)
    case "modifyCodes": modifyCodes(parameters: parameters, resultCallback: resultCallback)
    case "modifyCodesInGroup": modifyCodesInGroup(parameters: parameters, resultCallback: resultCallback)
    case "filterCodesBy": filterCodesBy(parameters: parameters, resultCallback: resultCallback)
    case "filterCodesBySorted": filterCodesBySorted(parameters: parameters, resultCallback: resultCallback)
    case "matchCodesBy": matchCodesBy(parameters: parameters, resultCallback: resultCallback)
    case "matchCodesBySorted": matchCodesBySorted(parameters: parameters, resultCallback: resultCallback)
    case "importCodes": importCodes(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func listCodesByRegionTypeCodeVersion(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CodeApi.shared.listCodesByRegionTypeCodeVersion(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	regionString: parameters["region"]!,
    	typeString: parameters["type"]!,
    	codeString: parameters["code"]!,
    	versionString: parameters["version"]!
    )
  }

  private static func listCodeTypesBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CodeApi.shared.listCodeTypesBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	regionString: parameters["region"]!,
    	typeString: parameters["type"]!
    )
  }

  private static func listTagTypesBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CodeApi.shared.listTagTypesBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	regionString: parameters["region"]!,
    	typeString: parameters["type"]!
    )
  }

  private static func createCode(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CodeApi.shared.createCode(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	cString: parameters["c"]!
    )
  }

  private static func createCodes(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CodeApi.shared.createCodes(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	codeBatchString: parameters["codeBatch"]!
    )
  }

  private static func createCodesInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CodeApi.shared.createCodesInGroup(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	codeBatchString: parameters["codeBatch"]!
    )
  }

  private static func isCodeValid(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CodeApi.shared.isCodeValid(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	typeString: parameters["type"]!,
    	codeString: parameters["code"]!,
    	versionString: parameters["version"]!
    )
  }

  private static func getCodeByRegionLanguageTypeLabel(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CodeApi.shared.getCodeByRegionLanguageTypeLabel(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	regionString: parameters["region"]!,
    	labelString: parameters["label"]!,
    	typeString: parameters["type"]!,
    	languagesString: parameters["languages"]!
    )
  }

  private static func getCodes(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CodeApi.shared.getCodes(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	codeIdsString: parameters["codeIds"]!
    )
  }

  private static func getCodesInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CodeApi.shared.getCodesInGroup(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	codeIdsString: parameters["codeIds"]!
    )
  }

  private static func getCode(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CodeApi.shared.getCode(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	codeIdString: parameters["codeId"]!
    )
  }

  private static func getCodeWithParts(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CodeApi.shared.getCodeWithParts(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	typeString: parameters["type"]!,
    	codeString: parameters["code"]!,
    	versionString: parameters["version"]!
    )
  }

  private static func modifyCode(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CodeApi.shared.modifyCode(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	codeDtoString: parameters["codeDto"]!
    )
  }

  private static func modifyCodes(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CodeApi.shared.modifyCodes(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	codeBatchString: parameters["codeBatch"]!
    )
  }

  private static func modifyCodesInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CodeApi.shared.modifyCodesInGroup(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	codeBatchString: parameters["codeBatch"]!
    )
  }

  private static func filterCodesBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CodeApi.shared.filterCodesBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterCodesBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CodeApi.shared.filterCodesBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchCodesBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CodeApi.shared.matchCodesBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchCodesBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CodeApi.shared.matchCodesBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func importCodes(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CodeApi.shared.importCodes(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	codeTypeString: parameters["codeType"]!
    )
  }

}
