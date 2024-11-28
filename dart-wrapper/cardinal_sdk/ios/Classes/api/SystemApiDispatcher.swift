// auto-generated file
import CardinalDartSdkSupportLib

class SystemApiDispatcher {

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
    case "getVersion": getVersion(parameters: parameters, resultCallback: resultCallback)
    case "isReady": isReady(parameters: parameters, resultCallback: resultCallback)
    case "getProcessInfo": getProcessInfo(parameters: parameters, resultCallback: resultCallback)
    case "getIndexingInfo": getIndexingInfo(parameters: parameters, resultCallback: resultCallback)
    case "getReplicationInfo": getReplicationInfo(parameters: parameters, resultCallback: resultCallback)
    case "updateDesignDoc": updateDesignDoc(parameters: parameters, resultCallback: resultCallback)
    case "resolvePatientsConflicts": resolvePatientsConflicts(parameters: parameters, resultCallback: resultCallback)
    case "resolveContactsConflicts": resolveContactsConflicts(parameters: parameters, resultCallback: resultCallback)
    case "resolveFormsConflicts": resolveFormsConflicts(parameters: parameters, resultCallback: resultCallback)
    case "resolveHealthElementsConflicts": resolveHealthElementsConflicts(parameters: parameters, resultCallback: resultCallback)
    case "resolveInvoicesConflicts": resolveInvoicesConflicts(parameters: parameters, resultCallback: resultCallback)
    case "resolveMessagesConflicts": resolveMessagesConflicts(parameters: parameters, resultCallback: resultCallback)
    case "resolveDocumentsConflicts": resolveDocumentsConflicts(parameters: parameters, resultCallback: resultCallback)
    case "getIndexingInfoByGroup": getIndexingInfoByGroup(parameters: parameters, resultCallback: resultCallback)
    case "getReplicatorInfo": getReplicatorInfo(parameters: parameters, resultCallback: resultCallback)
    case "evictAllFromMap": evictAllFromMap(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func getVersion(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    SystemApi.shared.getVersion(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!
    )
  }

  private static func isReady(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    SystemApi.shared.isReady(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!
    )
  }

  private static func getProcessInfo(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    SystemApi.shared.getProcessInfo(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!
    )
  }

  private static func getIndexingInfo(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    SystemApi.shared.getIndexingInfo(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!
    )
  }

  private static func getReplicationInfo(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    SystemApi.shared.getReplicationInfo(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!
    )
  }

  private static func updateDesignDoc(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    SystemApi.shared.updateDesignDoc(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityNameString: parameters["entityName"]!,
    	warmupString: parameters["warmup"]!
    )
  }

  private static func resolvePatientsConflicts(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    SystemApi.shared.resolvePatientsConflicts(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	limitString: parameters["limit"]!
    )
  }

  private static func resolveContactsConflicts(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    SystemApi.shared.resolveContactsConflicts(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	limitString: parameters["limit"]!
    )
  }

  private static func resolveFormsConflicts(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    SystemApi.shared.resolveFormsConflicts(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	limitString: parameters["limit"]!
    )
  }

  private static func resolveHealthElementsConflicts(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    SystemApi.shared.resolveHealthElementsConflicts(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	limitString: parameters["limit"]!
    )
  }

  private static func resolveInvoicesConflicts(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    SystemApi.shared.resolveInvoicesConflicts(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	limitString: parameters["limit"]!
    )
  }

  private static func resolveMessagesConflicts(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    SystemApi.shared.resolveMessagesConflicts(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	limitString: parameters["limit"]!
    )
  }

  private static func resolveDocumentsConflicts(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    SystemApi.shared.resolveDocumentsConflicts(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idsString: parameters["ids"]!,
    	limitString: parameters["limit"]!
    )
  }

  private static func getIndexingInfoByGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    SystemApi.shared.getIndexingInfoByGroup(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!
    )
  }

  private static func getReplicatorInfo(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    SystemApi.shared.getReplicatorInfo(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!
    )
  }

  private static func evictAllFromMap(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    SystemApi.shared.evictAllFromMap(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	mapNameString: parameters["mapName"]!
    )
  }

}
