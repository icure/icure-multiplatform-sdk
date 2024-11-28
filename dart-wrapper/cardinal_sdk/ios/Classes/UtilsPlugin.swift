import Flutter
import CardinalDartSdkSupportLib

class UtilsPlugin {

	public static func handle(_ call: FlutterMethodCall, result: @escaping FlutterResult) {
		let args = call.arguments as! [String: String]
		let methodName = call.method

		let completed = UtilsPlugin.dispatch(methodName: methodName, parameters: args) { success, errorCode, errorMessage in
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
			case "releasePlatformResource": releasePlatformResource(parameters: parameters, resultCallback: resultCallback)
			case "cancelJob": cancelJob(parameters: parameters, resultCallback: resultCallback)
			default: return false
		}
		return true
	}

	private static func releasePlatformResource(
		parameters: [String : String],
		resultCallback: @escaping (String?,String?, String?) -> Void
	) {
		ResourceUtils.shared.releasePlatformResource(
			dartResultCallback: resultCallback,
			resourceId: parameters["resourceId"]!
		)
	}
	
	private static func cancelJob(
		parameters: [String : String],
		resultCallback: @escaping (String?,String?, String?) -> Void
	) {
		ApiScope.shared.cancel(
			dartResultCallback: resultCallback,
			cancellationToken: Int64(parameters["cancellationToken"]!),
		)
	}
}
