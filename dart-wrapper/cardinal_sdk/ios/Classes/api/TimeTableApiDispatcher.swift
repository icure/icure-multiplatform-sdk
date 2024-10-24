// auto-generated file
import CardinalDartSdkSupportLib

class TimeTableApiDispatcher {

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
    case "createTimeTable": createTimeTable(parameters: parameters, resultCallback: resultCallback)
    case "withEncryptionMetadata": withEncryptionMetadata(parameters: parameters, resultCallback: resultCallback)
    case "getEncryptionKeysOf": getEncryptionKeysOf(parameters: parameters, resultCallback: resultCallback)
    case "hasWriteAccess": hasWriteAccess(parameters: parameters, resultCallback: resultCallback)
    case "decryptPatientIdOf": decryptPatientIdOf(parameters: parameters, resultCallback: resultCallback)
    case "createDelegationDeAnonymizationMetadata": createDelegationDeAnonymizationMetadata(parameters: parameters, resultCallback: resultCallback)
    case "decrypt": decrypt(parameters: parameters, resultCallback: resultCallback)
    case "tryDecrypt": tryDecrypt(parameters: parameters, resultCallback: resultCallback)
    case "matchTimeTablesBy": matchTimeTablesBy(parameters: parameters, resultCallback: resultCallback)
    case "matchTimeTablesBySorted": matchTimeTablesBySorted(parameters: parameters, resultCallback: resultCallback)
    case "deleteTimeTableById": deleteTimeTableById(parameters: parameters, resultCallback: resultCallback)
    case "deleteTimeTablesByIds": deleteTimeTablesByIds(parameters: parameters, resultCallback: resultCallback)
    case "purgeTimeTableById": purgeTimeTableById(parameters: parameters, resultCallback: resultCallback)
    case "deleteTimeTable": deleteTimeTable(parameters: parameters, resultCallback: resultCallback)
    case "deleteTimeTables": deleteTimeTables(parameters: parameters, resultCallback: resultCallback)
    case "purgeTimeTable": purgeTimeTable(parameters: parameters, resultCallback: resultCallback)
    case "shareWith": shareWith(parameters: parameters, resultCallback: resultCallback)
    case "shareWithMany": shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "filterTimeTablesBy": filterTimeTablesBy(parameters: parameters, resultCallback: resultCallback)
    case "filterTimeTablesBySorted": filterTimeTablesBySorted(parameters: parameters, resultCallback: resultCallback)
    case "undeleteTimeTable": undeleteTimeTable(parameters: parameters, resultCallback: resultCallback)
    case "modifyTimeTable": modifyTimeTable(parameters: parameters, resultCallback: resultCallback)
    case "undeleteTimeTableById": undeleteTimeTableById(parameters: parameters, resultCallback: resultCallback)
    case "getTimeTable": getTimeTable(parameters: parameters, resultCallback: resultCallback)
    case "getTimeTables": getTimeTables(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.shareWith": encrypted_shareWith(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.shareWithMany": encrypted_shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.filterTimeTablesBy": encrypted_filterTimeTablesBy(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.filterTimeTablesBySorted": encrypted_filterTimeTablesBySorted(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.undeleteTimeTable": encrypted_undeleteTimeTable(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.modifyTimeTable": encrypted_modifyTimeTable(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.undeleteTimeTableById": encrypted_undeleteTimeTableById(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.getTimeTable": encrypted_getTimeTable(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.getTimeTables": encrypted_getTimeTables(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.shareWith": tryAndRecover_shareWith(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.shareWithMany": tryAndRecover_shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.filterTimeTablesBy": tryAndRecover_filterTimeTablesBy(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.filterTimeTablesBySorted": tryAndRecover_filterTimeTablesBySorted(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.undeleteTimeTable": tryAndRecover_undeleteTimeTable(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.modifyTimeTable": tryAndRecover_modifyTimeTable(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.undeleteTimeTableById": tryAndRecover_undeleteTimeTableById(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.getTimeTable": tryAndRecover_getTimeTable(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.getTimeTables": tryAndRecover_getTimeTables(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func createTimeTable(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.createTimeTable(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func withEncryptionMetadata(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.withEncryptionMetadata(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	baseString: parameters["base"]!,
    	patientString: parameters["patient"]!,
    	userString: parameters["user"]!,
    	delegatesString: parameters["delegates"]!,
    	secretIdString: parameters["secretId"]!
    )
  }

  private static func getEncryptionKeysOf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.getEncryptionKeysOf(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	timeTableString: parameters["timeTable"]!
    )
  }

  private static func hasWriteAccess(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.hasWriteAccess(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	timeTableString: parameters["timeTable"]!
    )
  }

  private static func decryptPatientIdOf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.decryptPatientIdOf(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	timeTableString: parameters["timeTable"]!
    )
  }

  private static func createDelegationDeAnonymizationMetadata(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.createDelegationDeAnonymizationMetadata(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func decrypt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.decrypt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	timeTableString: parameters["timeTable"]!
    )
  }

  private static func tryDecrypt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.tryDecrypt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	timeTableString: parameters["timeTable"]!
    )
  }

  private static func matchTimeTablesBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.matchTimeTablesBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchTimeTablesBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.matchTimeTablesBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func deleteTimeTableById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.deleteTimeTableById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteTimeTablesByIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.deleteTimeTablesByIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func purgeTimeTableById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.purgeTimeTableById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteTimeTable(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.deleteTimeTable(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	timeTableString: parameters["timeTable"]!
    )
  }

  private static func deleteTimeTables(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.deleteTimeTables(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	timeTablesString: parameters["timeTables"]!
    )
  }

  private static func purgeTimeTable(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.purgeTimeTable(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	timeTableString: parameters["timeTable"]!
    )
  }

  private static func shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	timeTableString: parameters["timeTable"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	timeTableString: parameters["timeTable"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func filterTimeTablesBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.filterTimeTablesBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterTimeTablesBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.filterTimeTablesBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func undeleteTimeTable(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.undeleteTimeTable(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	timeTableString: parameters["timeTable"]!
    )
  }

  private static func modifyTimeTable(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.modifyTimeTable(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func undeleteTimeTableById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.undeleteTimeTableById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func getTimeTable(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.getTimeTable(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func getTimeTables(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.shared.getTimeTables(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	timeTableIdsString: parameters["timeTableIds"]!
    )
  }

  private static func encrypted_shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.encrypted.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	timeTableString: parameters["timeTable"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func encrypted_shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.encrypted.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	timeTableString: parameters["timeTable"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func encrypted_filterTimeTablesBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.encrypted.shared.filterTimeTablesBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func encrypted_filterTimeTablesBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.encrypted.shared.filterTimeTablesBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func encrypted_undeleteTimeTable(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.encrypted.shared.undeleteTimeTable(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	timeTableString: parameters["timeTable"]!
    )
  }

  private static func encrypted_modifyTimeTable(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.encrypted.shared.modifyTimeTable(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func encrypted_undeleteTimeTableById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.encrypted.shared.undeleteTimeTableById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func encrypted_getTimeTable(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.encrypted.shared.getTimeTable(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func encrypted_getTimeTables(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.encrypted.shared.getTimeTables(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	timeTableIdsString: parameters["timeTableIds"]!
    )
  }

  private static func tryAndRecover_shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.tryAndRecover.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	timeTableString: parameters["timeTable"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func tryAndRecover_shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.tryAndRecover.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	timeTableString: parameters["timeTable"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func tryAndRecover_filterTimeTablesBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.tryAndRecover.shared.filterTimeTablesBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func tryAndRecover_filterTimeTablesBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.tryAndRecover.shared.filterTimeTablesBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func tryAndRecover_undeleteTimeTable(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.tryAndRecover.shared.undeleteTimeTable(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	timeTableString: parameters["timeTable"]!
    )
  }

  private static func tryAndRecover_modifyTimeTable(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.tryAndRecover.shared.modifyTimeTable(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func tryAndRecover_undeleteTimeTableById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.tryAndRecover.shared.undeleteTimeTableById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func tryAndRecover_getTimeTable(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.tryAndRecover.shared.getTimeTable(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func tryAndRecover_getTimeTables(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableApi.tryAndRecover.shared.getTimeTables(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	timeTableIdsString: parameters["timeTableIds"]!
    )
  }

}
