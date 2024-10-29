import Flutter
import CardinalDartSdkSupportLib

class FiltersPlugin {
    public static func handle(_ call: FlutterMethodCall, result: @escaping FlutterResult) {
        let  args = call.arguments as! [String: String]
        let apiName = String(call.method.split(separator: ".").first!)
        let methodName = call.method.split(separator: ".").dropFirst().joined(separator: ".")
        
        let completed = dispatchFilters(apiName: apiName, methodName: methodName, parameters: args) { success, errorCode, errorMessage in
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
}
