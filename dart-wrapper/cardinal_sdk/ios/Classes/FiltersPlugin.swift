import Flutter
import CardinalDartSdkSupportLib

class FiltersPlugin {
	public static func handle(_ call: FlutterMethodCall, result: @escaping FlutterResult) {
		let  args = call.arguments as! [String: String]
		let apiName = String(call.method.split(separator: ".").first!)
		let methodName = call.method.split(separator: ".").dropFirst().joined(separator: ".")
		
		let completed = dispatchFilters(apiName: apiName, methodName: methodName, parameters: args) { success, errorCode, errorMessage, errorDetails in
			if (errorCode != nil){
				result(FlutterError(code: errorCode!, message: errorMessage, details: errorDetails))
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
