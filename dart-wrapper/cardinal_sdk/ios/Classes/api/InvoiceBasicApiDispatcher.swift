// auto-generated file
import CardinalDartSdkSupportLib

class InvoiceBasicApiDispatcher {

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
    case "deleteInvoice": deleteInvoice(parameters: parameters, resultCallback: resultCallback)
    case "findInvoicesDelegationsStubsByHcPartyPatientForeignKeys": findInvoicesDelegationsStubsByHcPartyPatientForeignKeys(parameters: parameters, resultCallback: resultCallback)
    case "getTarificationsCodesOccurrences": getTarificationsCodesOccurrences(parameters: parameters, resultCallback: resultCallback)
    case "modifyInvoice": modifyInvoice(parameters: parameters, resultCallback: resultCallback)
    case "modifyInvoices": modifyInvoices(parameters: parameters, resultCallback: resultCallback)
    case "getInvoice": getInvoice(parameters: parameters, resultCallback: resultCallback)
    case "getInvoices": getInvoices(parameters: parameters, resultCallback: resultCallback)
    case "findInvoicesByHcPartyPatientForeignKeys": findInvoicesByHcPartyPatientForeignKeys(parameters: parameters, resultCallback: resultCallback)
    case "reassignInvoice": reassignInvoice(parameters: parameters, resultCallback: resultCallback)
    case "mergeTo": mergeTo(parameters: parameters, resultCallback: resultCallback)
    case "validate": validate(parameters: parameters, resultCallback: resultCallback)
    case "appendCodes": appendCodes(parameters: parameters, resultCallback: resultCallback)
    case "removeCodes": removeCodes(parameters: parameters, resultCallback: resultCallback)
    case "listInvoicesByHCPartyAndPatientForeignKeys": listInvoicesByHCPartyAndPatientForeignKeys(parameters: parameters, resultCallback: resultCallback)
    case "listInvoicesByHcPartyAndGroupId": listInvoicesByHcPartyAndGroupId(parameters: parameters, resultCallback: resultCallback)
    case "listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate": listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(parameters: parameters, resultCallback: resultCallback)
    case "listInvoicesByContactIds": listInvoicesByContactIds(parameters: parameters, resultCallback: resultCallback)
    case "listInvoicesByRecipientsIds": listInvoicesByRecipientsIds(parameters: parameters, resultCallback: resultCallback)
    case "listToInsurances": listToInsurances(parameters: parameters, resultCallback: resultCallback)
    case "listToInsurancesUnsent": listToInsurancesUnsent(parameters: parameters, resultCallback: resultCallback)
    case "listToPatients": listToPatients(parameters: parameters, resultCallback: resultCallback)
    case "listToPatientsUnsent": listToPatientsUnsent(parameters: parameters, resultCallback: resultCallback)
    case "listInvoicesByIds": listInvoicesByIds(parameters: parameters, resultCallback: resultCallback)
    case "listInvoicesByHcpartySendingModeStatusDate": listInvoicesByHcpartySendingModeStatusDate(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func deleteInvoice(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceBasicApi.shared.deleteInvoice(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func findInvoicesDelegationsStubsByHcPartyPatientForeignKeys(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceBasicApi.shared.findInvoicesDelegationsStubsByHcPartyPatientForeignKeys(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	hcPartyIdString: parameters["hcPartyId"]!,
    	secretPatientKeysString: parameters["secretPatientKeys"]!
    )
  }

  private static func getTarificationsCodesOccurrences(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceBasicApi.shared.getTarificationsCodesOccurrences(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	minOccurrenceString: parameters["minOccurrence"]!
    )
  }

  private static func modifyInvoice(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceBasicApi.shared.modifyInvoice(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func modifyInvoices(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceBasicApi.shared.modifyInvoices(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entitiesString: parameters["entities"]!
    )
  }

  private static func getInvoice(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceBasicApi.shared.getInvoice(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func getInvoices(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceBasicApi.shared.getInvoices(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func findInvoicesByHcPartyPatientForeignKeys(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceBasicApi.shared.findInvoicesByHcPartyPatientForeignKeys(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	hcPartyIdString: parameters["hcPartyId"]!,
    	secretPatientKeysString: parameters["secretPatientKeys"]!
    )
  }

  private static func reassignInvoice(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceBasicApi.shared.reassignInvoice(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	invoiceString: parameters["invoice"]!
    )
  }

  private static func mergeTo(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceBasicApi.shared.mergeTo(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	invoiceIdString: parameters["invoiceId"]!,
    	idsString: parameters["ids"]!
    )
  }

  private static func validate(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceBasicApi.shared.validate(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	invoiceIdString: parameters["invoiceId"]!,
    	schemeString: parameters["scheme"]!,
    	forcedValueString: parameters["forcedValue"]!
    )
  }

  private static func appendCodes(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceBasicApi.shared.appendCodes(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userIdString: parameters["userId"]!,
    	typeString: parameters["type"]!,
    	sentMediumTypeString: parameters["sentMediumType"]!,
    	secretFKeysString: parameters["secretFKeys"]!,
    	insuranceIdString: parameters["insuranceId"]!,
    	invoiceIdString: parameters["invoiceId"]!,
    	gracePeriodString: parameters["gracePeriod"]!,
    	invoicingCodesString: parameters["invoicingCodes"]!
    )
  }

  private static func removeCodes(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceBasicApi.shared.removeCodes(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userIdString: parameters["userId"]!,
    	serviceIdString: parameters["serviceId"]!,
    	secretFKeysString: parameters["secretFKeys"]!,
    	tarificationIdsString: parameters["tarificationIds"]!
    )
  }

  private static func listInvoicesByHCPartyAndPatientForeignKeys(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceBasicApi.shared.listInvoicesByHCPartyAndPatientForeignKeys(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	hcPartyIdString: parameters["hcPartyId"]!,
    	secretPatientKeysString: parameters["secretPatientKeys"]!
    )
  }

  private static func listInvoicesByHcPartyAndGroupId(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceBasicApi.shared.listInvoicesByHcPartyAndGroupId(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	hcPartyIdString: parameters["hcPartyId"]!,
    	groupIdString: parameters["groupId"]!
    )
  }

  private static func listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceBasicApi.shared.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	hcPartyIdString: parameters["hcPartyId"]!,
    	sentMediumTypeString: parameters["sentMediumType"]!,
    	invoiceTypeString: parameters["invoiceType"]!,
    	sentString: parameters["sent"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!
    )
  }

  private static func listInvoicesByContactIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceBasicApi.shared.listInvoicesByContactIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	contactIdsString: parameters["contactIds"]!
    )
  }

  private static func listInvoicesByRecipientsIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceBasicApi.shared.listInvoicesByRecipientsIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	recipientsIdsString: parameters["recipientsIds"]!
    )
  }

  private static func listToInsurances(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceBasicApi.shared.listToInsurances(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userIdsString: parameters["userIds"]!
    )
  }

  private static func listToInsurancesUnsent(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceBasicApi.shared.listToInsurancesUnsent(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userIdsString: parameters["userIds"]!
    )
  }

  private static func listToPatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceBasicApi.shared.listToPatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	hcPartyIdString: parameters["hcPartyId"]!
    )
  }

  private static func listToPatientsUnsent(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceBasicApi.shared.listToPatientsUnsent(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	hcPartyIdString: parameters["hcPartyId"]!
    )
  }

  private static func listInvoicesByIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceBasicApi.shared.listInvoicesByIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idsString: parameters["ids"]!
    )
  }

  private static func listInvoicesByHcpartySendingModeStatusDate(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    InvoiceBasicApi.shared.listInvoicesByHcpartySendingModeStatusDate(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	hcPartyIdString: parameters["hcPartyId"]!,
    	sendingModeString: parameters["sendingMode"]!,
    	statusString: parameters["status"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!
    )
  }

}
