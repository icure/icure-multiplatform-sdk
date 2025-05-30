// auto-generated file
import CardinalDartSdkSupportLib

class AgendaApiDispatcher {

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
    case "createAgenda": createAgenda(parameters: parameters, resultCallback: resultCallback)
    case "deleteAgendaById": deleteAgendaById(parameters: parameters, resultCallback: resultCallback)
    case "deleteAgendasByIds": deleteAgendasByIds(parameters: parameters, resultCallback: resultCallback)
    case "purgeAgendaById": purgeAgendaById(parameters: parameters, resultCallback: resultCallback)
    case "undeleteAgendaById": undeleteAgendaById(parameters: parameters, resultCallback: resultCallback)
    case "deleteAgenda": deleteAgenda(parameters: parameters, resultCallback: resultCallback)
    case "deleteAgendas": deleteAgendas(parameters: parameters, resultCallback: resultCallback)
    case "purgeAgenda": purgeAgenda(parameters: parameters, resultCallback: resultCallback)
    case "undeleteAgenda": undeleteAgenda(parameters: parameters, resultCallback: resultCallback)
    case "getAgenda": getAgenda(parameters: parameters, resultCallback: resultCallback)
    case "getAgendas": getAgendas(parameters: parameters, resultCallback: resultCallback)
    case "modifyAgenda": modifyAgenda(parameters: parameters, resultCallback: resultCallback)
    case "matchAgendasBy": matchAgendasBy(parameters: parameters, resultCallback: resultCallback)
    case "matchAgendasBySorted": matchAgendasBySorted(parameters: parameters, resultCallback: resultCallback)
    case "filterAgendasBy": filterAgendasBy(parameters: parameters, resultCallback: resultCallback)
    case "filterAgendasBySorted": filterAgendasBySorted(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.getAgenda": inGroup_getAgenda(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.getAgendas": inGroup_getAgendas(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.createAgenda": inGroup_createAgenda(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.modifyAgenda": inGroup_modifyAgenda(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.deleteAgendas": inGroup_deleteAgendas(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.deleteAgenda": inGroup_deleteAgenda(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.deleteAgendasByIds": inGroup_deleteAgendasByIds(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.deleteAgendaById": inGroup_deleteAgendaById(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.matchAgendasBy": inGroup_matchAgendasBy(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.matchAgendasBySorted": inGroup_matchAgendasBySorted(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.filterAgendasBy": inGroup_filterAgendasBy(parameters: parameters, resultCallback: resultCallback)
    case "inGroup.filterAgendasBySorted": inGroup_filterAgendasBySorted(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func createAgenda(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaApi.shared.createAgenda(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	agendaDtoString: parameters["agendaDto"]!
    )
  }

  private static func deleteAgendaById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaApi.shared.deleteAgendaById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteAgendasByIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaApi.shared.deleteAgendasByIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func purgeAgendaById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaApi.shared.purgeAgendaById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func undeleteAgendaById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaApi.shared.undeleteAgendaById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	idString: parameters["id"]!,
    	revString: parameters["rev"]!
    )
  }

  private static func deleteAgenda(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaApi.shared.deleteAgenda(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	agendaString: parameters["agenda"]!
    )
  }

  private static func deleteAgendas(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaApi.shared.deleteAgendas(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	agendasString: parameters["agendas"]!
    )
  }

  private static func purgeAgenda(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaApi.shared.purgeAgenda(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	agendaString: parameters["agenda"]!
    )
  }

  private static func undeleteAgenda(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaApi.shared.undeleteAgenda(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	agendaString: parameters["agenda"]!
    )
  }

  private static func getAgenda(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaApi.shared.getAgenda(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	agendaIdString: parameters["agendaId"]!
    )
  }

  private static func getAgendas(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaApi.shared.getAgendas(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	agendaIdsString: parameters["agendaIds"]!
    )
  }

  private static func modifyAgenda(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaApi.shared.modifyAgenda(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	agendaDtoString: parameters["agendaDto"]!
    )
  }

  private static func matchAgendasBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaApi.shared.matchAgendasBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func matchAgendasBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaApi.shared.matchAgendasBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterAgendasBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaApi.shared.filterAgendasBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func filterAgendasBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaApi.shared.filterAgendasBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func inGroup_getAgenda(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaApi.inGroup.shared.getAgenda(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func inGroup_getAgendas(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaApi.inGroup.shared.getAgendas(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func inGroup_createAgenda(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaApi.inGroup.shared.createAgenda(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func inGroup_modifyAgenda(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaApi.inGroup.shared.modifyAgenda(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityString: parameters["entity"]!
    )
  }

  private static func inGroup_deleteAgendas(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaApi.inGroup.shared.deleteAgendas(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	agendasString: parameters["agendas"]!
    )
  }

  private static func inGroup_deleteAgenda(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaApi.inGroup.shared.deleteAgenda(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	agendaString: parameters["agenda"]!
    )
  }

  private static func inGroup_deleteAgendasByIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaApi.inGroup.shared.deleteAgendasByIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdsString: parameters["entityIds"]!
    )
  }

  private static func inGroup_deleteAgendaById(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaApi.inGroup.shared.deleteAgendaById(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityIdString: parameters["entityId"]!
    )
  }

  private static func inGroup_matchAgendasBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaApi.inGroup.shared.matchAgendasBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func inGroup_matchAgendasBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaApi.inGroup.shared.matchAgendasBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func inGroup_filterAgendasBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaApi.inGroup.shared.filterAgendasBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	filterString: parameters["filter"]!
    )
  }

  private static func inGroup_filterAgendasBySorted(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    AgendaApi.inGroup.shared.filterAgendasBySorted(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	groupIdString: parameters["groupId"]!,
    	filterString: parameters["filter"]!
    )
  }

}
