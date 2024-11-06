// auto-generated file
import CardinalDartSdkSupportLib

class DocumentTemplateApiDispatcher {

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
    case "getDocumentTemplate": getDocumentTemplate(parameters: parameters, resultCallback: resultCallback)
    case "createDocumentTemplate": createDocumentTemplate(parameters: parameters, resultCallback: resultCallback)
    case "modifyDocumentTemplate": modifyDocumentTemplate(parameters: parameters, resultCallback: resultCallback)
    case "deleteDocumentTemplates": deleteDocumentTemplates(parameters: parameters, resultCallback: resultCallback)
    case "listDocumentTemplatesBySpeciality": listDocumentTemplatesBySpeciality(parameters: parameters, resultCallback: resultCallback)
    case "listDocumentTemplatesByDocumentType": listDocumentTemplatesByDocumentType(parameters: parameters, resultCallback: resultCallback)
    case "listDocumentTemplatesByDocumentTypeForCurrentUser": listDocumentTemplatesByDocumentTypeForCurrentUser(parameters: parameters, resultCallback: resultCallback)
    case "listDocumentTemplates": listDocumentTemplates(parameters: parameters, resultCallback: resultCallback)
    case "getDocumentTemplateAttachment": getDocumentTemplateAttachment(parameters: parameters, resultCallback: resultCallback)
    case "getAttachmentText": getAttachmentText(parameters: parameters, resultCallback: resultCallback)
    case "setDocumentTemplateAttachment": setDocumentTemplateAttachment(parameters: parameters, resultCallback: resultCallback)
    case "getAttachmentUrl": getAttachmentUrl(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func getDocumentTemplate(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentTemplateApi.shared.getDocumentTemplate(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentTemplateIdString: parameters["documentTemplateId"]!
    )
  }

  private static func createDocumentTemplate(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentTemplateApi.shared.createDocumentTemplate(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentTemplateString: parameters["documentTemplate"]!
    )
  }

  private static func modifyDocumentTemplate(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentTemplateApi.shared.modifyDocumentTemplate(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentTemplateString: parameters["documentTemplate"]!
    )
  }

  private static func deleteDocumentTemplates(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentTemplateApi.shared.deleteDocumentTemplates(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentTemplateIdsString: parameters["documentTemplateIds"]!
    )
  }

  private static func listDocumentTemplatesBySpeciality(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentTemplateApi.shared.listDocumentTemplatesBySpeciality(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	specialityCodeString: parameters["specialityCode"]!
    )
  }

  private static func listDocumentTemplatesByDocumentType(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentTemplateApi.shared.listDocumentTemplatesByDocumentType(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentTypeCodeString: parameters["documentTypeCode"]!
    )
  }

  private static func listDocumentTemplatesByDocumentTypeForCurrentUser(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentTemplateApi.shared.listDocumentTemplatesByDocumentTypeForCurrentUser(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentTypeCodeString: parameters["documentTypeCode"]!
    )
  }

  private static func listDocumentTemplates(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentTemplateApi.shared.listDocumentTemplates(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!
    )
  }

  private static func getDocumentTemplateAttachment(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentTemplateApi.shared.getDocumentTemplateAttachment(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentTemplateIdString: parameters["documentTemplateId"]!,
    	attachmentIdString: parameters["attachmentId"]!
    )
  }

  private static func getAttachmentText(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentTemplateApi.shared.getAttachmentText(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentTemplateIdString: parameters["documentTemplateId"]!,
    	attachmentIdString: parameters["attachmentId"]!
    )
  }

  private static func setDocumentTemplateAttachment(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentTemplateApi.shared.setDocumentTemplateAttachment(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentTemplateIdString: parameters["documentTemplateId"]!,
    	payloadString: parameters["payload"]!
    )
  }

  private static func getAttachmentUrl(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentTemplateApi.shared.getAttachmentUrl(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentIdString: parameters["documentId"]!,
    	attachmentIdString: parameters["attachmentId"]!
    )
  }

}
