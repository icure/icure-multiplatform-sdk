// auto-generated file
import CardinalDartSdkSupportLib

class TimeTableFiltersDispatcher {

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
    case "byAgendaId": byAgendaId(parameters: parameters, resultCallback: resultCallback)
    case "byPeriodAndAgendaId": byPeriodAndAgendaId(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func byAgendaId(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableFilters.shared.byAgendaId(
    	dartResultCallback: resultCallback,
    	agendaIdString: parameters["agendaId"]!
    )
  }

  private static func byPeriodAndAgendaId(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    TimeTableFilters.shared.byPeriodAndAgendaId(
    	dartResultCallback: resultCallback,
    	agendaIdString: parameters["agendaId"]!,
    	fromString: parameters["from"]!,
    	toString: parameters["to"]!,
    	descendingString: parameters["descending"]!
    )
  }

}
