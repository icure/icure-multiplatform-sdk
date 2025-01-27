// auto-generated file
import CardinalDartSdkSupportLib

class CardinalMaintenanceTaskApiDispatcher {

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
    case "applyKeyPairUpdate": applyKeyPairUpdate(parameters: parameters, resultCallback: resultCallback)
    case "createKeyPairUpdateNotificationsToAllDelegationCounterparts": createKeyPairUpdateNotificationsToAllDelegationCounterparts(parameters: parameters, resultCallback: resultCallback)
    case "createKeyPairUpdateNotificationTo": createKeyPairUpdateNotificationTo(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func applyKeyPairUpdate(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CardinalMaintenanceTaskApi.shared.applyKeyPairUpdate(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	updateRequestString: parameters["updateRequest"]!
    )
  }

  private static func createKeyPairUpdateNotificationsToAllDelegationCounterparts(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CardinalMaintenanceTaskApi.shared.createKeyPairUpdateNotificationsToAllDelegationCounterparts(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	keyString: parameters["key"]!,
    	requestToOwnerTypesString: parameters["requestToOwnerTypes"]!
    )
  }

  private static func createKeyPairUpdateNotificationTo(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CardinalMaintenanceTaskApi.shared.createKeyPairUpdateNotificationTo(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	keyString: parameters["key"]!
    )
  }

}
