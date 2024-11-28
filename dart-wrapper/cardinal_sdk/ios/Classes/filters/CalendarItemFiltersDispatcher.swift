// auto-generated file
import CardinalDartSdkSupportLib

class CalendarItemFiltersDispatcher {

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
    case "byPatientsStartTimeForDataOwner": byPatientsStartTimeForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byPatientsStartTimeForSelf": byPatientsStartTimeForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byPatientSecretIdsStartTimeForDataOwner": byPatientSecretIdsStartTimeForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byPatientSecretIdsStartTimeForSelf": byPatientSecretIdsStartTimeForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byPeriodAndAgenda": byPeriodAndAgenda(parameters: parameters, resultCallback: resultCallback)
    case "byPeriodForDataOwner": byPeriodForDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "byPeriodForSelf": byPeriodForSelf(parameters: parameters, resultCallback: resultCallback)
    case "byRecurrenceId": byRecurrenceId(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func byPatientsStartTimeForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemFilters.shared.byPatientsStartTimeForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	patientsString: parameters["patients"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!,
    	descendingString: parameters["descending"]!
    )
  }

  private static func byPatientsStartTimeForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemFilters.shared.byPatientsStartTimeForSelf(
    	dartResultCallback: resultCallback,
    	patientsString: parameters["patients"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!,
    	descendingString: parameters["descending"]!
    )
  }

  private static func byPatientSecretIdsStartTimeForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemFilters.shared.byPatientSecretIdsStartTimeForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	secretIdsString: parameters["secretIds"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!,
    	descendingString: parameters["descending"]!
    )
  }

  private static func byPatientSecretIdsStartTimeForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemFilters.shared.byPatientSecretIdsStartTimeForSelf(
    	dartResultCallback: resultCallback,
    	secretIdsString: parameters["secretIds"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!,
    	descendingString: parameters["descending"]!
    )
  }

  private static func byPeriodAndAgenda(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemFilters.shared.byPeriodAndAgenda(
    	dartResultCallback: resultCallback,
    	agendaIdString: parameters["agendaId"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!,
    	descendingString: parameters["descending"]!
    )
  }

  private static func byPeriodForDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemFilters.shared.byPeriodForDataOwner(
    	dartResultCallback: resultCallback,
    	dataOwnerIdString: parameters["dataOwnerId"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!
    )
  }

  private static func byPeriodForSelf(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemFilters.shared.byPeriodForSelf(
    	dartResultCallback: resultCallback,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!
    )
  }

  private static func byRecurrenceId(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    CalendarItemFilters.shared.byRecurrenceId(
    	dartResultCallback: resultCallback,
    	recurrenceIdString: parameters["recurrenceId"]!
    )
  }

}
