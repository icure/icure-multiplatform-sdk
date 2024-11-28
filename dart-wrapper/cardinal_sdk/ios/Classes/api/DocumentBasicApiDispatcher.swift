// auto-generated file
import CardinalDartSdkSupportLib

class DocumentBasicApiDispatcher {

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
    case "matchDocumentsBy": matchDocumentsBy(parameters: parameters, resultCallback: resultCallback)
    case "matchDocumentsBySorted": matchDocumentsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "filterDocumentsBy": filterDocumentsBy(parameters: parameters, resultCallback: resultCallback)
    case "filterDocumentsBySorted": filterDocumentsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "deleteDocumentById": deleteDocumentById(parameters: parameters, resultCallback: resultCallback)
    case "deleteDocumentsByIds": deleteDocumentsByIds(parameters: parameters, resultCallback: resultCallback)
    case "purgeDocumentById": purgeDocumentById(parameters: parameters, resultCallback: resultCallback)
    case "deleteDocument": deleteDocument(parameters: parameters, resultCallback: resultCallback)
    case "deleteDocuments": deleteDocuments(parameters: parameters, resultCallback: resultCallback)
    case "purgeDocument": purgeDocument(parameters: parameters, resultCallback: resultCallback)
    case "getRawMainAttachment": getRawMainAttachment(parameters: parameters, resultCallback: resultCallback)
    case "getRawSecondaryAttachment": getRawSecondaryAttachment(parameters: parameters, resultCallback: resultCallback)
    case "setRawMainAttachment": setRawMainAttachment(parameters: parameters, resultCallback: resultCallback)
    case "setRawSecondaryAttachment": setRawSecondaryAttachment(parameters: parameters, resultCallback: resultCallback)
    case "deleteMainAttachment": deleteMainAttachment(parameters: parameters, resultCallback: resultCallback)
    case "deleteSecondaryAttachment": deleteSecondaryAttachment(parameters: parameters, resultCallback: resultCallback)
    case "undeleteDocumentById": undeleteDocumentById(parameters: parameters, resultCallback: resultCallback)
    case "undeleteDocument": undeleteDocument(parameters: parameters, resultCallback: resultCallback)
    case "modifyDocument": modifyDocument(parameters: parameters, resultCallback: resultCallback)
    case "getDocument": getDocument(parameters: parameters, resultCallback: resultCallback)
    case "getDocuments": getDocuments(parameters: parameters, resultCallback: resultCallback)
    case "modifyDocuments": modifyDocuments(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func matchDocumentsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentBasicApi.shared.matchDocumentsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchDocumentsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentBasicApi.shared.matchDocumentsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterDocumentsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentBasicApi.shared.filterDocumentsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterDocumentsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentBasicApi.shared.filterDocumentsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func deleteDocumentById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentBasicApi.shared.deleteDocumentById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteDocumentsByIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentBasicApi.shared.deleteDocumentsByIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func purgeDocumentById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentBasicApi.shared.purgeDocumentById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteDocument(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentBasicApi.shared.deleteDocument(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentString: parameters["document"]!
    )
  }

  private static func deleteDocuments(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentBasicApi.shared.deleteDocuments(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentsString: parameters["documents"]!
    )
  }

  private static func purgeDocument(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentBasicApi.shared.purgeDocument(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentString: parameters["document"]!
    )
  }

  private static func getRawMainAttachment(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentBasicApi.shared.getRawMainAttachment(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentIdString: parameters["documentId"]!
    )
  }

  private static func getRawSecondaryAttachment(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentBasicApi.shared.getRawSecondaryAttachment(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentIdString: parameters["documentId"]!,
    	keyString: parameters["key"]!
    )
  }

  private static func setRawMainAttachment(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentBasicApi.shared.setRawMainAttachment(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentIdString: parameters["documentId"]!,
    	revString: parameters["rev"]!,
    	utisString: parameters["utis"]!,
    	attachmentString: parameters["attachment"]!,
    	encryptedString: parameters["encrypted"]!
    )
  }

  private static func setRawSecondaryAttachment(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentBasicApi.shared.setRawSecondaryAttachment(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentIdString: parameters["documentId"]!,
    	keyString: parameters["key"]!,
    	revString: parameters["rev"]!,
    	utisString: parameters["utis"]!,
    	attachmentString: parameters["attachment"]!,
    	encryptedString: parameters["encrypted"]!
    )
  }

  private static func deleteMainAttachment(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentBasicApi.shared.deleteMainAttachment(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteSecondaryAttachment(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentBasicApi.shared.deleteSecondaryAttachment(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentIdString: parameters["documentId"]!,
    	keyString: parameters["key"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func undeleteDocumentById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentBasicApi.shared.undeleteDocumentById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func undeleteDocument(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentBasicApi.shared.undeleteDocument(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentString: parameters["document"]!
    )
  }

  private static func modifyDocument(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentBasicApi.shared.modifyDocument(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func getDocument(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentBasicApi.shared.getDocument(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func getDocuments(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentBasicApi.shared.getDocuments(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func modifyDocuments(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DocumentBasicApi.shared.modifyDocuments(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entitiesString: parameters["entities"]!
    )
  }

}
