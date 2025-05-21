// auto-generated file
import CardinalDartSdkSupportLib

class DataOwnerApiDispatcher {

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
    case "getCurrentDataOwner": getCurrentDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "getCurrentDataOwnerStub": getCurrentDataOwnerStub(parameters: parameters, resultCallback: resultCallback)
    case "getCurrentDataOwnerId": getCurrentDataOwnerId(parameters: parameters, resultCallback: resultCallback)
    case "getCurrentDataOwnerReference": getCurrentDataOwnerReference(parameters: parameters, resultCallback: resultCallback)
    case "getCurrentDataOwnerHierarchyIds": getCurrentDataOwnerHierarchyIds(parameters: parameters, resultCallback: resultCallback)
    case "getCurrentDataOwnerHierarchyIdsReference": getCurrentDataOwnerHierarchyIdsReference(parameters: parameters, resultCallback: resultCallback)
    case "getDataOwner": getDataOwner(parameters: parameters, resultCallback: resultCallback)
    case "getCryptoActorStub": getCryptoActorStub(parameters: parameters, resultCallback: resultCallback)
    case "getCryptoActorStubInGroup": getCryptoActorStubInGroup(parameters: parameters, resultCallback: resultCallback)
    case "getCurrentDataOwnerHierarchyIdsFrom": getCurrentDataOwnerHierarchyIdsFrom(parameters: parameters, resultCallback: resultCallback)
    case "getCurrentDataOwnerHierarchy": getCurrentDataOwnerHierarchy(parameters: parameters, resultCallback: resultCallback)
    case "modifyDataOwnerStub": modifyDataOwnerStub(parameters: parameters, resultCallback: resultCallback)
    case "getCurrentDataOwnerType": getCurrentDataOwnerType(parameters: parameters, resultCallback: resultCallback)
    case "clearCurrentDataOwnerIdsCache": clearCurrentDataOwnerIdsCache(parameters: parameters, resultCallback: resultCallback)
    default: return false
    }
    return true
  }

  private static func getCurrentDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DataOwnerApi.shared.getCurrentDataOwner(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!
    )
  }

  private static func getCurrentDataOwnerStub(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DataOwnerApi.shared.getCurrentDataOwnerStub(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!
    )
  }

  private static func getCurrentDataOwnerId(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DataOwnerApi.shared.getCurrentDataOwnerId(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!
    )
  }

  private static func getCurrentDataOwnerReference(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DataOwnerApi.shared.getCurrentDataOwnerReference(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!
    )
  }

  private static func getCurrentDataOwnerHierarchyIds(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DataOwnerApi.shared.getCurrentDataOwnerHierarchyIds(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!
    )
  }

  private static func getCurrentDataOwnerHierarchyIdsReference(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DataOwnerApi.shared.getCurrentDataOwnerHierarchyIdsReference(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!
    )
  }

  private static func getDataOwner(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DataOwnerApi.shared.getDataOwner(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	ownerIdString: parameters["ownerId"]!
    )
  }

  private static func getCryptoActorStub(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DataOwnerApi.shared.getCryptoActorStub(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	ownerIdString: parameters["ownerId"]!
    )
  }

  private static func getCryptoActorStubInGroup(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DataOwnerApi.shared.getCryptoActorStubInGroup(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	entityReferenceInGroupString: parameters["entityReferenceInGroup"]!
    )
  }

  private static func getCurrentDataOwnerHierarchyIdsFrom(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DataOwnerApi.shared.getCurrentDataOwnerHierarchyIdsFrom(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	parentIdString: parameters["parentId"]!
    )
  }

  private static func getCurrentDataOwnerHierarchy(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DataOwnerApi.shared.getCurrentDataOwnerHierarchy(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!
    )
  }

  private static func modifyDataOwnerStub(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DataOwnerApi.shared.modifyDataOwnerStub(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!,
    	cryptoActorStubWithTypeDtoString: parameters["cryptoActorStubWithTypeDto"]!
    )
  }

  private static func getCurrentDataOwnerType(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DataOwnerApi.shared.getCurrentDataOwnerType(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!
    )
  }

  private static func clearCurrentDataOwnerIdsCache(parameters: [String : String], resultCallback: @escaping (
    String?,
    String?,
    String?,
    String?
  ) -> Void) {
    DataOwnerApi.shared.clearCurrentDataOwnerIdsCache(
    	dartResultCallback: resultCallback,
    	sdkId: parameters["sdkId"]!
    )
  }

}
