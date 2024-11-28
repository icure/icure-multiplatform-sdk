// auto-generated file
import CardinalDartSdkSupportLib

class ContactBasicApiDispatcher {

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
    case "matchContactsBy": matchContactsBy(parameters: parameters, resultCallback: resultCallback)
    case "matchServicesBy": matchServicesBy(parameters: parameters, resultCallback: resultCallback)
    case "matchContactsBySorted": matchContactsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "matchServicesBySorted": matchServicesBySorted(parameters: parameters, resultCallback: resultCallback)
    case "filterContactsBy": filterContactsBy(parameters: parameters, resultCallback: resultCallback)
    case "filterServicesBy": filterServicesBy(parameters: parameters, resultCallback: resultCallback)
    case "filterContactsBySorted": filterContactsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "filterServicesBySorted": filterServicesBySorted(parameters: parameters, resultCallback: resultCallback)
    case "subscribeToServiceCreateOrUpdateEvents": subscribeToServiceCreateOrUpdateEvents(parameters: parameters, resultCallback: resultCallback)
    case "deleteContactById": deleteContactById(parameters: parameters, resultCallback: resultCallback)
    case "deleteContactsByIds": deleteContactsByIds(parameters: parameters, resultCallback: resultCallback)
    case "purgeContactById": purgeContactById(parameters: parameters, resultCallback: resultCallback)
    case "deleteContact": deleteContact(parameters: parameters, resultCallback: resultCallback)
    case "deleteContacts": deleteContacts(parameters: parameters, resultCallback: resultCallback)
    case "purgeContact": purgeContact(parameters: parameters, resultCallback: resultCallback)
    case "getServiceCodesOccurrences": getServiceCodesOccurrences(parameters: parameters, resultCallback: resultCallback)
    case "undeleteContactById": undeleteContactById(parameters: parameters, resultCallback: resultCallback)
    case "undeleteContact": undeleteContact(parameters: parameters, resultCallback: resultCallback)
    case "modifyContact": modifyContact(parameters: parameters, resultCallback: resultCallback)
    case "modifyContacts": modifyContacts(parameters: parameters, resultCallback: resultCallback)
    case "getContact": getContact(parameters: parameters, resultCallback: resultCallback)
    case "getContacts": getContacts(parameters: parameters, resultCallback: resultCallback)
    case "getService": getService(parameters: parameters, resultCallback: resultCallback)
    case "getServices": getServices(parameters: parameters, resultCallback: resultCallback)
    case "subscribeToEvents": subscribeToEvents(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func matchContactsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactBasicApi.shared.matchContactsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchServicesBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactBasicApi.shared.matchServicesBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchContactsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactBasicApi.shared.matchContactsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchServicesBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactBasicApi.shared.matchServicesBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterContactsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactBasicApi.shared.filterContactsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterServicesBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactBasicApi.shared.filterServicesBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterContactsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactBasicApi.shared.filterContactsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterServicesBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactBasicApi.shared.filterServicesBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func subscribeToServiceCreateOrUpdateEvents(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactBasicApi.shared.subscribeToServiceCreateOrUpdateEvents(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!,
    	subscriptionConfigString: parameters["subscriptionConfig"]!
    )
  }

  private static func deleteContactById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactBasicApi.shared.deleteContactById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteContactsByIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactBasicApi.shared.deleteContactsByIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func purgeContactById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactBasicApi.shared.purgeContactById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteContact(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactBasicApi.shared.deleteContact(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	contactString: parameters["contact"]!
    )
  }

  private static func deleteContacts(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactBasicApi.shared.deleteContacts(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	contactsString: parameters["contacts"]!
    )
  }

  private static func purgeContact(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactBasicApi.shared.purgeContact(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	contactString: parameters["contact"]!
    )
  }

  private static func getServiceCodesOccurrences(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactBasicApi.shared.getServiceCodesOccurrences(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	codeTypeString: parameters["codeType"]!,
    	minOccurrencesString: parameters["minOccurrences"]!
    )
  }

  private static func undeleteContactById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactBasicApi.shared.undeleteContactById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func undeleteContact(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactBasicApi.shared.undeleteContact(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	contactString: parameters["contact"]!
    )
  }

  private static func modifyContact(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactBasicApi.shared.modifyContact(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func modifyContacts(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactBasicApi.shared.modifyContacts(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entitiesString: parameters["entities"]!
    )
  }

  private static func getContact(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactBasicApi.shared.getContact(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func getContacts(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactBasicApi.shared.getContacts(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func getService(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactBasicApi.shared.getService(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	serviceIdString: parameters["serviceId"]!
    )
  }

  private static func getServices(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactBasicApi.shared.getServices(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func subscribeToEvents(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    ContactBasicApi.shared.subscribeToEvents(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	eventsString: parameters["events"]!,
    	filterString: parameters["filter"]!,
    	subscriptionConfigString: parameters["subscriptionConfig"]!
    )
  }

}
