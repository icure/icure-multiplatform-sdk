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
        case "initialize": Initializers.shared.initializeSdk(
            dartResultCallback: resultCallback,
            username: parameters["username"]!,
            longToken: parameters["longToken"]!
        )
        default: return false
        }
        return true
    }
}
