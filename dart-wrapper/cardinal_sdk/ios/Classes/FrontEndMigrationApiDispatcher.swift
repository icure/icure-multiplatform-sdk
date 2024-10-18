// auto-generated file
import CardinalDartSdkSupportLib

class FrontEndMigrationApiDispatcher {

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
    case "getFrontEndMigration": getFrontEndMigration(parameters: parameters, resultCallback: resultCallback)
    case "createFrontEndMigration": createFrontEndMigration(parameters: parameters, resultCallback: resultCallback)
    case "getFrontEndMigrations": getFrontEndMigrations(parameters: parameters, resultCallback: resultCallback)
    case "deleteFrontEndMigration": deleteFrontEndMigration(parameters: parameters, resultCallback: resultCallback)
    case "getFrontEndMigrationByName": getFrontEndMigrationByName(parameters: parameters, resultCallback: resultCallback)
    case "modifyFrontEndMigration": modifyFrontEndMigration(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func getFrontEndMigration(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    FrontEndMigrationApi.shared.getFrontEndMigration(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	frontEndMigrationIdString: parameters["frontEndMigrationId"]!
    )
  }

  private static func createFrontEndMigration(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    FrontEndMigrationApi.shared.createFrontEndMigration(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	frontEndMigrationString: parameters["frontEndMigration"]!
    )
  }

  private static func getFrontEndMigrations(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    FrontEndMigrationApi.shared.getFrontEndMigrations(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!
    )
  }

  private static func deleteFrontEndMigration(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    FrontEndMigrationApi.shared.deleteFrontEndMigration(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	frontEndMigrationIdString: parameters["frontEndMigrationId"]!
    )
  }

  private static func getFrontEndMigrationByName(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    FrontEndMigrationApi.shared.getFrontEndMigrationByName(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	frontEndMigrationNameString: parameters["frontEndMigrationName"]!
    )
  }

  private static func modifyFrontEndMigration(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?
  ) -> Void) {
    FrontEndMigrationApi.shared.modifyFrontEndMigration(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	frontEndMigrationString: parameters["frontEndMigration"]!
    )
  }

}
