// auto-generated file
import CardinalDartSdkSupportLib

class PatientApiDispatcher {

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
    case "getSecretIdsOf": getSecretIdsOf(parameters: parameters, resultCallback: resultCallback)
    case "getEncryptionKeysOf": getEncryptionKeysOf(parameters: parameters, resultCallback: resultCallback)
    case "createPatient": createPatient(parameters: parameters, resultCallback: resultCallback)
    case "withEncryptionMetadata": withEncryptionMetadata(parameters: parameters, resultCallback: resultCallback)
    case "hasWriteAccess": hasWriteAccess(parameters: parameters, resultCallback: resultCallback)
    case "createDelegationDeAnonymizationMetadata": createDelegationDeAnonymizationMetadata(parameters: parameters, resultCallback: resultCallback)
    case "decrypt": decrypt(parameters: parameters, resultCallback: resultCallback)
    case "tryDecrypt": tryDecrypt(parameters: parameters, resultCallback: resultCallback)
    case "createPatients": createPatients(parameters: parameters, resultCallback: resultCallback)
    case "shareAllDataOfPatient": shareAllDataOfPatient(parameters: parameters, resultCallback: resultCallback)
    case "getConfidentialSecretIdsOf": getConfidentialSecretIdsOf(parameters: parameters, resultCallback: resultCallback)
    case "forceInitializeExchangeDataToNewlyInvitedPatient": forceInitializeExchangeDataToNewlyInvitedPatient(parameters: parameters, resultCallback: resultCallback)
    case "matchPatientsBy": matchPatientsBy(parameters: parameters, resultCallback: resultCallback)
    case "matchPatientsBySorted": matchPatientsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "ensureEncryptionMetadataForSelfIsInitialized": ensureEncryptionMetadataForSelfIsInitialized(parameters: parameters, resultCallback: resultCallback)
    case "deletePatientById": deletePatientById(parameters: parameters, resultCallback: resultCallback)
    case "deletePatientsByIds": deletePatientsByIds(parameters: parameters, resultCallback: resultCallback)
    case "purgePatientById": purgePatientById(parameters: parameters, resultCallback: resultCallback)
    case "deletePatient": deletePatient(parameters: parameters, resultCallback: resultCallback)
    case "deletePatients": deletePatients(parameters: parameters, resultCallback: resultCallback)
    case "purgePatient": purgePatient(parameters: parameters, resultCallback: resultCallback)
    case "getDataOwnersWithAccessTo": getDataOwnersWithAccessTo(parameters: parameters, resultCallback: resultCallback)
    case "shareWith": shareWith(parameters: parameters, resultCallback: resultCallback)
    case "shareWithMany": shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "initializeConfidentialSecretId": initializeConfidentialSecretId(parameters: parameters, resultCallback: resultCallback)
    case "filterPatientsBy": filterPatientsBy(parameters: parameters, resultCallback: resultCallback)
    case "filterPatientsBySorted": filterPatientsBySorted(parameters: parameters, resultCallback: resultCallback)
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
    case "encrypted.shareWith": encrypted_shareWith(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.shareWithMany": encrypted_shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.initializeConfidentialSecretId": encrypted_initializeConfidentialSecretId(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.filterPatientsBy": encrypted_filterPatientsBy(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.filterPatientsBySorted": encrypted_filterPatientsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.undeletePatient": encrypted_undeletePatient(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.modifyPatient": encrypted_modifyPatient(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.undeletePatientById": encrypted_undeletePatientById(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.undeletePatients": encrypted_undeletePatients(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.getPatient": encrypted_getPatient(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.getPatientResolvingMerges": encrypted_getPatientResolvingMerges(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.getPatients": encrypted_getPatients(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.modifyPatients": encrypted_modifyPatients(parameters: parameters, resultCallback: resultCallback)
    case "encrypted.mergePatients": encrypted_mergePatients(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.shareWith": tryAndRecover_shareWith(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.shareWithMany": tryAndRecover_shareWithMany(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.initializeConfidentialSecretId": tryAndRecover_initializeConfidentialSecretId(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.filterPatientsBy": tryAndRecover_filterPatientsBy(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.filterPatientsBySorted": tryAndRecover_filterPatientsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.undeletePatient": tryAndRecover_undeletePatient(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.modifyPatient": tryAndRecover_modifyPatient(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.undeletePatientById": tryAndRecover_undeletePatientById(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.undeletePatients": tryAndRecover_undeletePatients(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.getPatient": tryAndRecover_getPatient(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.getPatientResolvingMerges": tryAndRecover_getPatientResolvingMerges(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.getPatients": tryAndRecover_getPatients(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.modifyPatients": tryAndRecover_modifyPatients(parameters: parameters, resultCallback: resultCallback)
    case "tryAndRecover.mergePatients": tryAndRecover_mergePatients(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func getSecretIdsOf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.getSecretIdsOf(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func getEncryptionKeysOf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.getEncryptionKeysOf(
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
    PatientApi.shared.createPatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func withEncryptionMetadata(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.withEncryptionMetadata(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	baseString: parameters["base"]!,
    	userString: parameters["user"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func hasWriteAccess(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.hasWriteAccess(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func createDelegationDeAnonymizationMetadata(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.createDelegationDeAnonymizationMetadata(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func decrypt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.decrypt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func tryDecrypt(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.tryDecrypt(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func createPatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.createPatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientDtosString: parameters["patientDtos"]!
    )
  }

  private static func shareAllDataOfPatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.shareAllDataOfPatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientIdString: parameters["patientId"]!,
    	delegatesWithShareTypeString: parameters["delegatesWithShareType"]!
    )
  }

  private static func getConfidentialSecretIdsOf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.getConfidentialSecretIdsOf(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func forceInitializeExchangeDataToNewlyInvitedPatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.forceInitializeExchangeDataToNewlyInvitedPatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientIdString: parameters["patientId"]!
    )
  }

  private static func matchPatientsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.matchPatientsBy(
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
    PatientApi.shared.matchPatientsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func ensureEncryptionMetadataForSelfIsInitialized(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.ensureEncryptionMetadataForSelfIsInitialized(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	sharingWithString: parameters["sharingWith"]!
    )
  }

  private static func deletePatientById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.deletePatientById(
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
    PatientApi.shared.deletePatientsByIds(
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
    PatientApi.shared.purgePatientById(
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
    PatientApi.shared.deletePatient(
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
    PatientApi.shared.deletePatients(
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
    PatientApi.shared.purgePatient(
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
    PatientApi.shared.getDataOwnersWithAccessTo(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	patientString: parameters["patient"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func initializeConfidentialSecretId(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.initializeConfidentialSecretId(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func filterPatientsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.filterPatientsBy(
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
    PatientApi.shared.filterPatientsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func undeletePatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.shared.undeletePatient(
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
    PatientApi.shared.modifyPatient(
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
    PatientApi.shared.undeletePatientById(
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
    PatientApi.shared.undeletePatients(
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
    PatientApi.shared.getPatient(
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
    PatientApi.shared.getPatientResolvingMerges(
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
    PatientApi.shared.getPatients(
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
    PatientApi.shared.modifyPatients(
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
    PatientApi.shared.mergePatients(
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
    PatientApi.shared.subscribeToEvents(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	eventsString: parameters["events"]!,
    	filterString: parameters["filter"]!,
    	subscriptionConfigString: parameters["subscriptionConfig"]!
    )
  }

  private static func encrypted_shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.encrypted.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	patientString: parameters["patient"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func encrypted_shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.encrypted.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func encrypted_initializeConfidentialSecretId(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.encrypted.shared.initializeConfidentialSecretId(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func encrypted_filterPatientsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.encrypted.shared.filterPatientsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func encrypted_filterPatientsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.encrypted.shared.filterPatientsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func encrypted_undeletePatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.encrypted.shared.undeletePatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func encrypted_modifyPatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.encrypted.shared.modifyPatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func encrypted_undeletePatientById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.encrypted.shared.undeletePatientById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func encrypted_undeletePatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.encrypted.shared.undeletePatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idsString: parameters["ids"]!
    )
  }

  private static func encrypted_getPatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.encrypted.shared.getPatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func encrypted_getPatientResolvingMerges(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.encrypted.shared.getPatientResolvingMerges(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientIdString: parameters["patientId"]!,
    	maxMergeDepthString: parameters["maxMergeDepth"]!
    )
  }

  private static func encrypted_getPatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.encrypted.shared.getPatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientIdsString: parameters["patientIds"]!
    )
  }

  private static func encrypted_modifyPatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.encrypted.shared.modifyPatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientDtosString: parameters["patientDtos"]!
    )
  }

  private static func encrypted_mergePatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.encrypted.shared.mergePatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	fromString: parameters["from"]!,
    	mergedIntoString: parameters["mergedInto"]!
    )
  }

  private static func tryAndRecover_shareWith(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.tryAndRecover.shared.shareWith(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	delegateIdString: parameters["delegateId"]!,
    	patientString: parameters["patient"]!,
    	optionsString: parameters["options"]!
    )
  }

  private static func tryAndRecover_shareWithMany(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.tryAndRecover.shared.shareWithMany(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!,
    	delegatesString: parameters["delegates"]!
    )
  }

  private static func tryAndRecover_initializeConfidentialSecretId(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.tryAndRecover.shared.initializeConfidentialSecretId(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func tryAndRecover_filterPatientsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.tryAndRecover.shared.filterPatientsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func tryAndRecover_filterPatientsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.tryAndRecover.shared.filterPatientsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func tryAndRecover_undeletePatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.tryAndRecover.shared.undeletePatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientString: parameters["patient"]!
    )
  }

  private static func tryAndRecover_modifyPatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.tryAndRecover.shared.modifyPatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func tryAndRecover_undeletePatientById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.tryAndRecover.shared.undeletePatientById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func tryAndRecover_undeletePatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.tryAndRecover.shared.undeletePatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idsString: parameters["ids"]!
    )
  }

  private static func tryAndRecover_getPatient(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.tryAndRecover.shared.getPatient(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func tryAndRecover_getPatientResolvingMerges(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.tryAndRecover.shared.getPatientResolvingMerges(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientIdString: parameters["patientId"]!,
    	maxMergeDepthString: parameters["maxMergeDepth"]!
    )
  }

  private static func tryAndRecover_getPatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.tryAndRecover.shared.getPatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientIdsString: parameters["patientIds"]!
    )
  }

  private static func tryAndRecover_modifyPatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.tryAndRecover.shared.modifyPatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	patientDtosString: parameters["patientDtos"]!
    )
  }

  private static func tryAndRecover_mergePatients(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    PatientApi.tryAndRecover.shared.mergePatients(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	fromString: parameters["from"]!,
    	mergedIntoString: parameters["mergedInto"]!
    )
  }

}
