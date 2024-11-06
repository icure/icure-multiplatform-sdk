// auto-generated file
import CardinalDartSdkSupportLib

class MedicalLocationApiDispatcher {

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
    case "createMedicalLocation": createMedicalLocation(parameters: parameters, resultCallback: resultCallback)
    case "deleteMedicalLocations": deleteMedicalLocations(parameters: parameters, resultCallback: resultCallback)
    case "getMedicalLocation": getMedicalLocation(parameters: parameters, resultCallback: resultCallback)
    case "modifyMedicalLocation": modifyMedicalLocation(parameters: parameters, resultCallback: resultCallback)
    case "getMedicalLocations": getMedicalLocations(parameters: parameters, resultCallback: resultCallback)
    case "matchMedicalLocationsBy": matchMedicalLocationsBy(parameters: parameters, resultCallback: resultCallback)
    case "matchMedicalLocationsBySorted": matchMedicalLocationsBySorted(parameters: parameters, resultCallback: resultCallback)
    case "filterMedicalLocationsBy": filterMedicalLocationsBy(parameters: parameters, resultCallback: resultCallback)
    case "filterMedicalLocationsBySorted": filterMedicalLocationsBySorted(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func createMedicalLocation(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    MedicalLocationApi.shared.createMedicalLocation(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	medicalLocationDtoString: parameters["medicalLocationDto"]!
    )
  }

  private static func deleteMedicalLocations(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    MedicalLocationApi.shared.deleteMedicalLocations(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	locationIdsString: parameters["locationIds"]!
    )
  }

  private static func getMedicalLocation(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    MedicalLocationApi.shared.getMedicalLocation(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	locationIdString: parameters["locationId"]!
    )
  }

  private static func modifyMedicalLocation(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    MedicalLocationApi.shared.modifyMedicalLocation(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	medicalLocationDtoString: parameters["medicalLocationDto"]!
    )
  }

  private static func getMedicalLocations(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    MedicalLocationApi.shared.getMedicalLocations(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	medicalLocationIdsString: parameters["medicalLocationIds"]!
    )
  }

  private static func matchMedicalLocationsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    MedicalLocationApi.shared.matchMedicalLocationsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchMedicalLocationsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    MedicalLocationApi.shared.matchMedicalLocationsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterMedicalLocationsBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    MedicalLocationApi.shared.filterMedicalLocationsBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterMedicalLocationsBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    MedicalLocationApi.shared.filterMedicalLocationsBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

}
