// auto-generated file
import CardinalDartSdkSupportLib

class UserFiltersDispatcher {

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
    case "all": all(parameters: parameters, resultCallback: resultCallback)
    case "byIds": byIds(parameters: parameters, resultCallback: resultCallback)
    case "byPatientId": byPatientId(parameters: parameters, resultCallback: resultCallback)
    case "byHealthcarePartyId": byHealthcarePartyId(parameters: parameters, resultCallback: resultCallback)
    case "byNameEmailOrPhone": byNameEmailOrPhone(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func all(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    UserFilters.shared.all(
    	dartResultCallback: resultCallback
    )
  }

  private static func byIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    UserFilters.shared.byIds(
    	dartResultCallback: resultCallback,
    	idsString: parameters["ids"]!
    )
  }

  private static func byPatientId(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    UserFilters.shared.byPatientId(
    	dartResultCallback: resultCallback,
    	patientIdString: parameters["patientId"]!
    )
  }

  private static func byHealthcarePartyId(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    UserFilters.shared.byHealthcarePartyId(
    	dartResultCallback: resultCallback,
    	healthcarePartyIdString: parameters["healthcarePartyId"]!
    )
  }

  private static func byNameEmailOrPhone(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    UserFilters.shared.byNameEmailOrPhone(
    	dartResultCallback: resultCallback,
    	searchStringString: parameters["searchString"]!
    )
  }

}
