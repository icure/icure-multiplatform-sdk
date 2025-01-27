// auto-generated file
import CardinalDartSdkSupportLib

class PatientBasicApiDispatcher {

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
    case "matchPatientsBy": matchPatientsBy(parameters: parameters, resultCallback: resultCallback)
    case "matchPatientsBySorted": matchPatientsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "filterPatientsBy": filterPatientsBy(parameters: parameters, resultCallback: resultCallback)
    case "filterPatientsBySorted": filterPatientsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "deletePatientById": deletePatientById(parameters: parameters, resultCallback: resultCallback)
    case "deletePatientsByIds": deletePatientsByIds(parameters: parameters, resultCallback: resultCallback)
    case "purgePatientById": purgePatientById(parameters: parameters, resultCallback: resultCallback)
    case "deletePatient": deletePatient(parameters: parameters, resultCallback: resultCallback)
    case "deletePatients": deletePatients(parameters: parameters, resultCallback: resultCallback)
    case "purgePatient": purgePatient(parameters: parameters, resultCallback: resultCallback)
    case "getDataOwnersWithAccessTo": getDataOwnersWithAccessTo(parameters: parameters, resultCallback: resultCallback)
    case "undeletePatient": undeletePatient(parameters: parameters, resultCallback: resultCallback)
    case "modifyPatient": modifyPatient(parameters: parameters, resultCallback: resultCallback)
    case "undeletePatientById": undeletePatientById(parameters: parameters, resultCallback: resultCallback)
    case "undeletePatients": undeletePatients(parameters: parameters, resultCallback: resultCallback)
    case "getPatient": getPatient(parameters: parameters, resultCallback: resultCallback)
    case "getPatientResolvingMerges": getPatientResolvingMerges(parameters: parameters, resultCallback: resultCallback)
    case "getPatients": getPatients(parameters: parameters, resultCallback: resultCallback)
    case "modifyPatients": modifyPatients(parameters: parameters, resultCallback: resultCallback)
    case "mergePatients": mergePatients(parameters: parameters, resultCallback: resultCallback)
    case "subscribeToEvents": subscribeToEvents(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func matchPatientsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientBasicApi.shared.matchPatientsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchPatientsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientBasicApi.shared.matchPatientsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterPatientsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientBasicApi.shared.filterPatientsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterPatientsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientBasicApi.shared.filterPatientsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func deletePatientById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientBasicApi.shared.deletePatientById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deletePatientsByIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientBasicApi.shared.deletePatientsByIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func purgePatientById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientBasicApi.shared.purgePatientById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deletePatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientBasicApi.shared.deletePatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func deletePatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientBasicApi.shared.deletePatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func purgePatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientBasicApi.shared.purgePatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func getDataOwnersWithAccessTo(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientBasicApi.shared.getDataOwnersWithAccessTo(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func undeletePatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientBasicApi.shared.undeletePatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func modifyPatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientBasicApi.shared.modifyPatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func undeletePatientById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientBasicApi.shared.undeletePatientById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func undeletePatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientBasicApi.shared.undeletePatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idsString: parameters["ids"]!
    )
  }

  private static func getPatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientBasicApi.shared.getPatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func getPatientResolvingMerges(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientBasicApi.shared.getPatientResolvingMerges(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientIdString: parameters["patientId"]!,
    	maxMergeDepthString: parameters["maxMergeDepth"]!
    )
  }

  private static func getPatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientBasicApi.shared.getPatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientIdsString: parameters["patientIds"]!
    )
  }

  private static func modifyPatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientBasicApi.shared.modifyPatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientDtosString: parameters["patientDtos"]!
    )
  }

  private static func mergePatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientBasicApi.shared.mergePatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	fromString: parameters["from"]!,
    	mergedIntoString: parameters["mergedInto"]!
    )
  }

  private static func subscribeToEvents(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientBasicApi.shared.subscribeToEvents(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	eventsString: parameters["events"]!,
    	filterString: parameters["filter"]!,
    	subscriptionConfigString: parameters["subscriptionConfig"]!
    )
  }

}
