// auto-generated file
import CardinalDartSdkSupportLib

class FormBasicApiDispatcher {

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
    case "matchFormsBy": matchFormsBy(parameters: parameters, resultCallback: resultCallback)
    case "matchFormsBySorted": matchFormsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "filterFormsBy": filterFormsBy(parameters: parameters, resultCallback: resultCallback)
    case "filterFormsBySorted": filterFormsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "deleteFormById": deleteFormById(parameters: parameters, resultCallback: resultCallback)
    case "deleteFormsByIds": deleteFormsByIds(parameters: parameters, resultCallback: resultCallback)
    case "purgeFormById": purgeFormById(parameters: parameters, resultCallback: resultCallback)
    case "deleteForm": deleteForm(parameters: parameters, resultCallback: resultCallback)
    case "deleteForms": deleteForms(parameters: parameters, resultCallback: resultCallback)
    case "purgeForm": purgeForm(parameters: parameters, resultCallback: resultCallback)
    case "getFormTemplate": getFormTemplate(parameters: parameters, resultCallback: resultCallback)
    case "createFormTemplate": createFormTemplate(parameters: parameters, resultCallback: resultCallback)
    case "deleteFormTemplate": deleteFormTemplate(parameters: parameters, resultCallback: resultCallback)
    case "updateFormTemplate": updateFormTemplate(parameters: parameters, resultCallback: resultCallback)
    case "setTemplateAttachment": setTemplateAttachment(parameters: parameters, resultCallback: resultCallback)
    case "modifyForm": modifyForm(parameters: parameters, resultCallback: resultCallback)
    case "undeleteFormById": undeleteFormById(parameters: parameters, resultCallback: resultCallback)
    case "undeleteForm": undeleteForm(parameters: parameters, resultCallback: resultCallback)
    case "modifyForms": modifyForms(parameters: parameters, resultCallback: resultCallback)
    case "getForm": getForm(parameters: parameters, resultCallback: resultCallback)
    case "getForms": getForms(parameters: parameters, resultCallback: resultCallback)
    case "getLatestFormByLogicalUuid": getLatestFormByLogicalUuid(parameters: parameters, resultCallback: resultCallback)
    case "getLatestFormByUniqueId": getLatestFormByUniqueId(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func matchFormsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    FormBasicApi.shared.matchFormsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchFormsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    FormBasicApi.shared.matchFormsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterFormsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    FormBasicApi.shared.filterFormsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterFormsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    FormBasicApi.shared.filterFormsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func deleteFormById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    FormBasicApi.shared.deleteFormById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteFormsByIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    FormBasicApi.shared.deleteFormsByIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func purgeFormById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    FormBasicApi.shared.purgeFormById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteForm(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    FormBasicApi.shared.deleteForm(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	formString: parameters["form"]!
    )
  }

  private static func deleteForms(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    FormBasicApi.shared.deleteForms(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	formsString: parameters["forms"]!
    )
  }

  private static func purgeForm(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    FormBasicApi.shared.purgeForm(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	formString: parameters["form"]!
    )
  }

  private static func getFormTemplate(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    FormBasicApi.shared.getFormTemplate(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	formTemplateIdString: parameters["formTemplateId"]!,
    	rawString: parameters["raw"]!
    )
  }

  private static func createFormTemplate(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    FormBasicApi.shared.createFormTemplate(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	formTemplateString: parameters["formTemplate"]!
    )
  }

  private static func deleteFormTemplate(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    FormBasicApi.shared.deleteFormTemplate(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	formTemplateIdString: parameters["formTemplateId"]!
    )
  }

  private static func updateFormTemplate(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    FormBasicApi.shared.updateFormTemplate(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	formTemplateString: parameters["formTemplate"]!
    )
  }

  private static func setTemplateAttachment(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    FormBasicApi.shared.setTemplateAttachment(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	formTemplateIdString: parameters["formTemplateId"]!,
    	payloadString: parameters["payload"]!
    )
  }

  private static func modifyForm(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    FormBasicApi.shared.modifyForm(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func undeleteFormById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    FormBasicApi.shared.undeleteFormById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func undeleteForm(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    FormBasicApi.shared.undeleteForm(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	formString: parameters["form"]!
    )
  }

  private static func modifyForms(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    FormBasicApi.shared.modifyForms(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entitiesString: parameters["entities"]!
    )
  }

  private static func getForm(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    FormBasicApi.shared.getForm(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func getForms(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    FormBasicApi.shared.getForms(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func getLatestFormByLogicalUuid(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    FormBasicApi.shared.getLatestFormByLogicalUuid(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	logicalUuidString: parameters["logicalUuid"]!
    )
  }

  private static func getLatestFormByUniqueId(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    FormBasicApi.shared.getLatestFormByUniqueId(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	uniqueIdString: parameters["uniqueId"]!
    )
  }

}
