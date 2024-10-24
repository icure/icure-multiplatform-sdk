// auto-generated file
import CardinalDartSdkSupportLib

class MaintenanceTaskBasicApiDispatcher {

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
    case "matchMaintenanceTasksBy": matchMaintenanceTasksBy(parameters: parameters, resultCallback: resultCallback)
    case "matchMaintenanceTasksBySorted": matchMaintenanceTasksBySorted(parameters: parameters, resultCallback: resultCallback)
    case "filterMaintenanceTasksBy": filterMaintenanceTasksBy(parameters: parameters, resultCallback: resultCallback)
    case "filterMaintenanceTasksBySorted": filterMaintenanceTasksBySorted(parameters: parameters, resultCallback: resultCallback)
    case "deleteMaintenanceTaskById": deleteMaintenanceTaskById(parameters: parameters, resultCallback: resultCallback)
    case "deleteMaintenanceTasksByIds": deleteMaintenanceTasksByIds(parameters: parameters, resultCallback: resultCallback)
    case "purgeMaintenanceTaskById": purgeMaintenanceTaskById(parameters: parameters, resultCallback: resultCallback)
    case "deleteMaintenanceTask": deleteMaintenanceTask(parameters: parameters, resultCallback: resultCallback)
    case "deleteMaintenanceTasks": deleteMaintenanceTasks(parameters: parameters, resultCallback: resultCallback)
    case "purgeMaintenanceTask": purgeMaintenanceTask(parameters: parameters, resultCallback: resultCallback)
    case "undeleteMaintenanceTask": undeleteMaintenanceTask(parameters: parameters, resultCallback: resultCallback)
    case "undeleteMaintenanceTaskById": undeleteMaintenanceTaskById(parameters: parameters, resultCallback: resultCallback)
    case "modifyMaintenanceTask": modifyMaintenanceTask(parameters: parameters, resultCallback: resultCallback)
    case "getMaintenanceTask": getMaintenanceTask(parameters: parameters, resultCallback: resultCallback)
    case "getMaintenanceTasks": getMaintenanceTasks(parameters: parameters, resultCallback: resultCallback)
    case "subscribeToEvents": subscribeToEvents(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func matchMaintenanceTasksBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskBasicApi.shared.matchMaintenanceTasksBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchMaintenanceTasksBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskBasicApi.shared.matchMaintenanceTasksBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterMaintenanceTasksBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskBasicApi.shared.filterMaintenanceTasksBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterMaintenanceTasksBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskBasicApi.shared.filterMaintenanceTasksBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func deleteMaintenanceTaskById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskBasicApi.shared.deleteMaintenanceTaskById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteMaintenanceTasksByIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskBasicApi.shared.deleteMaintenanceTasksByIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func purgeMaintenanceTaskById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskBasicApi.shared.purgeMaintenanceTaskById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteMaintenanceTask(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskBasicApi.shared.deleteMaintenanceTask(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	maintenanceTaskString: parameters["maintenanceTask"]!
    )
  }

  private static func deleteMaintenanceTasks(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskBasicApi.shared.deleteMaintenanceTasks(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	maintenanceTasksString: parameters["maintenanceTasks"]!
    )
  }

  private static func purgeMaintenanceTask(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskBasicApi.shared.purgeMaintenanceTask(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	maintenanceTaskString: parameters["maintenanceTask"]!
    )
  }

  private static func undeleteMaintenanceTask(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskBasicApi.shared.undeleteMaintenanceTask(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	maintenanceTaskString: parameters["maintenanceTask"]!
    )
  }

  private static func undeleteMaintenanceTaskById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskBasicApi.shared.undeleteMaintenanceTaskById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func modifyMaintenanceTask(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskBasicApi.shared.modifyMaintenanceTask(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func getMaintenanceTask(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskBasicApi.shared.getMaintenanceTask(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func getMaintenanceTasks(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskBasicApi.shared.getMaintenanceTasks(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func subscribeToEvents(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    MaintenanceTaskBasicApi.shared.subscribeToEvents(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	eventsString: parameters["events"]!,
    	filterString: parameters["filter"]!,
    	subscriptionConfigString: parameters["subscriptionConfig"]!
    )
  }

}
