// auto-generated file
import CardinalDartSdkSupportLib

class DeviceApiDispatcher {

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
    case "getDevice": getDevice(parameters: parameters, resultCallback: resultCallback)
    case "getDevices": getDevices(parameters: parameters, resultCallback: resultCallback)
    case "createDevice": createDevice(parameters: parameters, resultCallback: resultCallback)
    case "modifyDevice": modifyDevice(parameters: parameters, resultCallback: resultCallback)
    case "createDevices": createDevices(parameters: parameters, resultCallback: resultCallback)
    case "modifyDevices": modifyDevices(parameters: parameters, resultCallback: resultCallback)
    case "filterDevicesBy": filterDevicesBy(parameters: parameters, resultCallback: resultCallback)
    case "filterDevicesBySorted": filterDevicesBySorted(parameters: parameters, resultCallback: resultCallback)
    case "matchDevicesBy": matchDevicesBy(parameters: parameters, resultCallback: resultCallback)
    case "matchDevicesBySorted": matchDevicesBySorted(parameters: parameters, resultCallback: resultCallback)
    case "deleteDeviceById": deleteDeviceById(parameters: parameters, resultCallback: resultCallback)
    case "deleteDevicesByIds": deleteDevicesByIds(parameters: parameters, resultCallback: resultCallback)
    case "purgeDeviceById": purgeDeviceById(parameters: parameters, resultCallback: resultCallback)
    case "undeleteDeviceById": undeleteDeviceById(parameters: parameters, resultCallback: resultCallback)
    case "deleteDevice": deleteDevice(parameters: parameters, resultCallback: resultCallback)
    case "deleteDevices": deleteDevices(parameters: parameters, resultCallback: resultCallback)
    case "purgeDevice": purgeDevice(parameters: parameters, resultCallback: resultCallback)
    case "undeleteDevice": undeleteDevice(parameters: parameters, resultCallback: resultCallback)
    case "getDevicesInGroup": getDevicesInGroup(parameters: parameters, resultCallback: resultCallback)
    case "modifyDeviceInGroup": modifyDeviceInGroup(parameters: parameters, resultCallback: resultCallback)
    case "createDeviceInGroup": createDeviceInGroup(parameters: parameters, resultCallback: resultCallback)
    case "deleteDevicesInGroup": deleteDevicesInGroup(parameters: parameters, resultCallback: resultCallback)
    case "subscribeToEvents": subscribeToEvents(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func getDevice(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DeviceApi.shared.getDevice(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	deviceIdString: parameters["deviceId"]!
    )
  }

  private static func getDevices(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DeviceApi.shared.getDevices(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	deviceIdsString: parameters["deviceIds"]!
    )
  }

  private static func createDevice(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DeviceApi.shared.createDevice(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	pString: parameters["p"]!
    )
  }

  private static func modifyDevice(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DeviceApi.shared.modifyDevice(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	deviceString: parameters["device"]!
    )
  }

  private static func createDevices(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DeviceApi.shared.createDevices(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	devicesString: parameters["devices"]!
    )
  }

  private static func modifyDevices(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DeviceApi.shared.modifyDevices(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	devicesString: parameters["devices"]!
    )
  }

  private static func filterDevicesBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DeviceApi.shared.filterDevicesBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterDevicesBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DeviceApi.shared.filterDevicesBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchDevicesBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DeviceApi.shared.matchDevicesBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchDevicesBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DeviceApi.shared.matchDevicesBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func deleteDeviceById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DeviceApi.shared.deleteDeviceById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteDevicesByIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DeviceApi.shared.deleteDevicesByIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func purgeDeviceById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DeviceApi.shared.purgeDeviceById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func undeleteDeviceById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DeviceApi.shared.undeleteDeviceById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteDevice(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DeviceApi.shared.deleteDevice(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	deviceString: parameters["device"]!
    )
  }

  private static func deleteDevices(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DeviceApi.shared.deleteDevices(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	devicesString: parameters["devices"]!
    )
  }

  private static func purgeDevice(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DeviceApi.shared.purgeDevice(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	deviceString: parameters["device"]!
    )
  }

  private static func undeleteDevice(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DeviceApi.shared.undeleteDevice(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	deviceString: parameters["device"]!
    )
  }

  private static func getDevicesInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DeviceApi.shared.getDevicesInGroup(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	deviceIdsString: parameters["deviceIds"]!
    )
  }

  private static func modifyDeviceInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DeviceApi.shared.modifyDeviceInGroup(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	deviceString: parameters["device"]!
    )
  }

  private static func createDeviceInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DeviceApi.shared.createDeviceInGroup(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	deviceString: parameters["device"]!
    )
  }

  private static func deleteDevicesInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DeviceApi.shared.deleteDevicesInGroup(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	deviceIdsString: parameters["deviceIds"]!
    )
  }

  private static func subscribeToEvents(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DeviceApi.shared.subscribeToEvents(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	eventsString: parameters["events"]!,
    	filterString: parameters["filter"]!,
    	subscriptionConfigString: parameters["subscriptionConfig"]!
    )
  }

}
