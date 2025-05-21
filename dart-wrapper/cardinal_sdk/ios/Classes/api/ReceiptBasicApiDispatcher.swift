// auto-generated file
import CardinalDartSdkSupportLib

class ReceiptBasicApiDispatcher {

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
    case "deleteReceipt": deleteReceipt(parameters: parameters, resultCallback: resultCallback)
    case "deleteReceipts": deleteReceipts(parameters: parameters, resultCallback: resultCallback)
    case "getRawReceiptAttachment": getRawReceiptAttachment(parameters: parameters, resultCallback: resultCallback)
    case "setRawReceiptAttachment": setRawReceiptAttachment(parameters: parameters, resultCallback: resultCallback)
    case "createReceipt": createReceipt(parameters: parameters, resultCallback: resultCallback)
    case "modifyReceipt": modifyReceipt(parameters: parameters, resultCallback: resultCallback)
    case "getReceipt": getReceipt(parameters: parameters, resultCallback: resultCallback)
    case "listByReference": listByReference(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func deleteReceipt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ReceiptBasicApi.shared.deleteReceipt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func deleteReceipts(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ReceiptBasicApi.shared.deleteReceipts(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func getRawReceiptAttachment(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ReceiptBasicApi.shared.getRawReceiptAttachment(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	receiptIdString: parameters["receiptId"]!,
    	attachmentIdString: parameters["attachmentId"]!
    )
  }

  private static func setRawReceiptAttachment(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ReceiptBasicApi.shared.setRawReceiptAttachment(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	receiptIdString: parameters["receiptId"]!,
    	revString: parameters["rev"]!,
    	blobTypeString: parameters["blobType"]!,
    	attachmentString: parameters["attachment"]!
    )
  }

  private static func createReceipt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ReceiptBasicApi.shared.createReceipt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func modifyReceipt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ReceiptBasicApi.shared.modifyReceipt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func getReceipt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ReceiptBasicApi.shared.getReceipt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func listByReference(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ReceiptBasicApi.shared.listByReference(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	referenceString: parameters["reference"]!
    )
  }

}
