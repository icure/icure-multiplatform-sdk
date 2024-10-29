import Flutter
import CardinalDartSdkSupportLib

class InitializersPlugin {
    public static func handle(_ call: FlutterMethodCall, result: @escaping FlutterResult) {
        let args = call.arguments as! [String: String]
        let methodName = call.method
        
        let completed = InitializersPlugin.dispatch(methodName: methodName, parameters: args) { success, errorCode, errorMessage in
            if (errorCode != nil){
                result(FlutterError(code: errorCode!, message: errorMessage, details: nil))
            }
            else {
                result(success)
            }
        }
        
        if !completed {
            result(FlutterMethodNotImplemented)
        }
    }
    
    private static func dispatch(
        methodName: String,
        parameters: [String : String],
        resultCallback: @escaping (
          String?,
          String?,
          String?
        ) -> Void
    ) -> Bool {
        switch methodName {
        case "initialize": initialize(parameters: parameters, resultCallback: resultCallback)
        case "initializeWithAuthProcess": initializeWithAuthProcess(parameters: parameters, resultCallback: resultCallback)
        case "completeAuthentication": completeAuthentication(parameters: parameters, resultCallback: resultCallback)
        default: return false
        }
        return true
    }
    
    private static func initialize(
        parameters: [String : String],
        resultCallback: @escaping (
          String?,
          String?,
          String?
        ) -> Void
    ) -> Void {
        Initializers.shared.initializeSdk(
            dartResultCallback: resultCallback,
            applicationIdString: parameters["applicationId"]!,
            baseUrlString: parameters["baseUrl"]!,
            authenticationMethodString: parameters["authenticationMethod"]!,
            storageFacade: StorageHelper.shared.getStorage(options: parameters["storageOptions"]!),
            optionsString: parameters["options"]!
        )
    }
    
    private static func initializeWithAuthProcess(
        parameters: [String : String],
        resultCallback: @escaping (
          String?,
          String?,
          String?
        ) -> Void
    ) -> Void {
        Initializers.shared.initializeWithAuthProcess(
            dartResultCallback: resultCallback,
            applicationIdString: parameters["applicationId"]!,
            baseUrlString: parameters["baseUrl"]!,
            messageGatewayUrlString: parameters["messageGatewayUrl"]!,
            externalServicesSpecIdString: parameters["externalServicesSpecId"]!,
            processIdString: parameters["processId"]!,
            userTelecomTypeString: parameters["userTelecomType"]!,
            userTelecomString: parameters["userTelecom"]!,
            captchaOptionsString: parameters["captchaOptions"]!,
            baseStorage: StorageHelper.shared.getStorage(options: parameters["storageOptions"]!),
            authenticationProcessTemplateParametersString: parameters["authenticationProcessTemplateParameters"]!,
            optionsString: parameters["options"]!
        )
    }
    
    private static func completeAuthentication(
        parameters: [String : String],
        resultCallback: @escaping (
          String?,
          String?,
          String?
        ) -> Void
    ) -> Void {
        Initializers.shared.completeAuthentication(
            dartResultCallback: resultCallback,
            authenticationStepId: parameters["authenticationStepId"]!,
            validationCodeString: parameters["validationCode"]!
        )
    }
}
