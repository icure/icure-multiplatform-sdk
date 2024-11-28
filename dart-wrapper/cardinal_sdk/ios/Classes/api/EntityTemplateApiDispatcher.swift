// auto-generated file
import CardinalDartSdkSupportLib

class EntityTemplateApiDispatcher {

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
    case "getEntityTemplate": getEntityTemplate(parameters: parameters, resultCallback: resultCallback)
    case "createEntityTemplate": createEntityTemplate(parameters: parameters, resultCallback: resultCallback)
    case "modifyEntityTemplate": modifyEntityTemplate(parameters: parameters, resultCallback: resultCallback)
    case "listEntityTemplatesBy": listEntityTemplatesBy(parameters: parameters, resultCallback: resultCallback)
    case "listAllEntityTemplatesBy": listAllEntityTemplatesBy(parameters: parameters, resultCallback: resultCallback)
    case "listEntityTemplatesByKeyword": listEntityTemplatesByKeyword(parameters: parameters, resultCallback: resultCallback)
    case "findAllEntityTemplatesByKeyword": findAllEntityTemplatesByKeyword(parameters: parameters, resultCallback: resultCallback)
    case "getEntityTemplates": getEntityTemplates(parameters: parameters, resultCallback: resultCallback)
    case "modifyEntityTemplates": modifyEntityTemplates(parameters: parameters, resultCallback: resultCallback)
    case "createEntityTemplates": createEntityTemplates(parameters: parameters, resultCallback: resultCallback)
    case "deleteEntityTemplates": deleteEntityTemplates(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func getEntityTemplate(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    EntityTemplateApi.shared.getEntityTemplate(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentTemplateIdString: parameters["documentTemplateId"]!
    )
  }

  private static func createEntityTemplate(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    EntityTemplateApi.shared.createEntityTemplate(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	applicationSettingsString: parameters["applicationSettings"]!
    )
  }

  private static func modifyEntityTemplate(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    EntityTemplateApi.shared.modifyEntityTemplate(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	documentTemplateString: parameters["documentTemplate"]!
    )
  }

  private static func listEntityTemplatesBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    EntityTemplateApi.shared.listEntityTemplatesBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userIdString: parameters["userId"]!,
    	typeString: parameters["type"]!,
    	searchStringString: parameters["searchString"]!,
    	includeEntitiesString: parameters["includeEntities"]!
    )
  }

  private static func listAllEntityTemplatesBy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    EntityTemplateApi.shared.listAllEntityTemplatesBy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	typeString: parameters["type"]!,
    	searchStringString: parameters["searchString"]!,
    	includeEntitiesString: parameters["includeEntities"]!
    )
  }

  private static func listEntityTemplatesByKeyword(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    EntityTemplateApi.shared.listEntityTemplatesByKeyword(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	userIdString: parameters["userId"]!,
    	typeString: parameters["type"]!,
    	keywordString: parameters["keyword"]!,
    	includeEntitiesString: parameters["includeEntities"]!
    )
  }

  private static func findAllEntityTemplatesByKeyword(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    EntityTemplateApi.shared.findAllEntityTemplatesByKeyword(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	typeString: parameters["type"]!,
    	keywordString: parameters["keyword"]!,
    	includeEntitiesString: parameters["includeEntities"]!
    )
  }

  private static func getEntityTemplates(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    EntityTemplateApi.shared.getEntityTemplates(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityTemplateIdsString: parameters["entityTemplateIds"]!
    )
  }

  private static func modifyEntityTemplates(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    EntityTemplateApi.shared.modifyEntityTemplates(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityTemplatesString: parameters["entityTemplates"]!
    )
  }

  private static func createEntityTemplates(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    EntityTemplateApi.shared.createEntityTemplates(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityTemplatesString: parameters["entityTemplates"]!
    )
  }

  private static func deleteEntityTemplates(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    EntityTemplateApi.shared.deleteEntityTemplates(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityTemplateIdsString: parameters["entityTemplateIds"]!
    )
  }

}
