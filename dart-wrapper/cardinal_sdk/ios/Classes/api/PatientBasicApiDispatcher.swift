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
    case "createPatient": createPatient(parameters: parameters, resultCallback: resultCallback)
    case "createPatientsMinimal": createPatientsMinimal(parameters: parameters, resultCallback: resultCallback)
    case "createPatients": createPatients(parameters: parameters, resultCallback: resultCallback)
    case "undeletePatient": undeletePatient(parameters: parameters, resultCallback: resultCallback)
    case "modifyPatient": modifyPatient(parameters: parameters, resultCallback: resultCallback)
    case "undeletePatientById": undeletePatientById(parameters: parameters, resultCallback: resultCallback)
    case "undeletePatients": undeletePatients(parameters: parameters, resultCallback: resultCallback)
    case "getPatient": getPatient(parameters: parameters, resultCallback: resultCallback)
    case "getPatientResolvingMerges": getPatientResolvingMerges(parameters: parameters, resultCallback: resultCallback)
    case "getPatients": getPatients(parameters: parameters, resultCallback: resultCallback)
    case "modifyPatientsMinimal": modifyPatientsMinimal(parameters: parameters, resultCallback: resultCallback)
    case "modifyPatients": modifyPatients(parameters: parameters, resultCallback: resultCallback)
    case "mergePatients": mergePatients(parameters: parameters, resultCallback: resultCallback)
    case "subscribeToEvents": subscribeToEvents(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.matchPatientsBy": inGroup_matchPatientsBy(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.matchPatientsBySorted": inGroup_matchPatientsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.filterPatientsBy": inGroup_filterPatientsBy(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.filterPatientsBySorted": inGroup_filterPatientsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.getDataOwnersWithAccessTo": inGroup_getDataOwnersWithAccessTo(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.createPatient": inGroup_createPatient(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.createPatientsMinimal": inGroup_createPatientsMinimal(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.createPatients": inGroup_createPatients(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.getPatient": inGroup_getPatient(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.getPatientResolvingMerges": inGroup_getPatientResolvingMerges(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.getPatients": inGroup_getPatients(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.modifyPatientsMinimal": inGroup_modifyPatientsMinimal(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.modifyPatients": inGroup_modifyPatients(parameters: parameters, resultCallback: resultCallback)
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

  private static func createPatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientBasicApi.shared.createPatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func createPatientsMinimal(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientBasicApi.shared.createPatientsMinimal(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func createPatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientBasicApi.shared.createPatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientsString: parameters["patients"]!
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

  private static func modifyPatientsMinimal(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientBasicApi.shared.modifyPatientsMinimal(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientsString: parameters["patients"]!
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
    	patientsString: parameters["patients"]!
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

  private static func inGroup_matchPatientsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientBasicApi.inGroup.shared.matchPatientsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func inGroup_matchPatientsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientBasicApi.inGroup.shared.matchPatientsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func inGroup_filterPatientsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientBasicApi.inGroup.shared.filterPatientsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func inGroup_filterPatientsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientBasicApi.inGroup.shared.filterPatientsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func inGroup_getDataOwnersWithAccessTo(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientBasicApi.inGroup.shared.getDataOwnersWithAccessTo(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func inGroup_createPatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientBasicApi.inGroup.shared.createPatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func inGroup_createPatientsMinimal(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientBasicApi.inGroup.shared.createPatientsMinimal(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func inGroup_createPatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientBasicApi.inGroup.shared.createPatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func inGroup_getPatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientBasicApi.inGroup.shared.getPatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func inGroup_getPatientResolvingMerges(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientBasicApi.inGroup.shared.getPatientResolvingMerges(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	patientIdString: parameters["patientId"]!,
    	maxMergeDepthString: parameters["maxMergeDepth"]!
    )
  }

  private static func inGroup_getPatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientBasicApi.inGroup.shared.getPatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	patientIdsString: parameters["patientIds"]!
    )
  }

  private static func inGroup_modifyPatientsMinimal(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientBasicApi.inGroup.shared.modifyPatientsMinimal(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientsString: parameters["patients"]!
    )
  }

  private static func inGroup_modifyPatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientBasicApi.inGroup.shared.modifyPatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientsString: parameters["patients"]!
    )
  }

}
