// auto-generated file
import CardinalDartSdkSupportLib

class MedicalLocationFiltersDispatcher {

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
    case "all": all(parameters: parameters, resultCallback: resultCallback)
    case "byPostCode": byPostCode(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func all(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MedicalLocationFilters.shared.all(
    	dartResultCallback: resultCallback
    )
  }

  private static func byPostCode(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    MedicalLocationFilters.shared.byPostCode(
    	dartResultCallback: resultCallback,
    	postCodeString: parameters["postCode"]!
    )
  }

}
