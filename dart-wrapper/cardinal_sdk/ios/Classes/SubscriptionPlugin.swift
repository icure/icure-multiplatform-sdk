import Flutter
import CardinalDartSdkSupportLib

class SubscriptionPlugin {

    public static func handle(_ call: FlutterMethodCall, result: @escaping FlutterResult) {
        let args = call.arguments as! [String: String]
        let methodName = call.method

        let completed = SubscriptionPlugin.dispatch(methodName: methodName, parameters: args) { success, errorCode, errorMessage in
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
		case "close": close(parameters: parameters, resultCallback: resultCallback)
		case "getCloseReason": getCloseReason(parameters: parameters, resultCallback: resultCallback)
		case "getEvent": getEvent(parameters: parameters, resultCallback: resultCallback)
		case "waitForEvent": waitForEvent(parameters: parameters, resultCallback: resultCallback)
    	default: return false
    }
    return true
  }

	private static func close(
		parameters: [String : String],
		resultCallback: @escaping (String?,String?, String?) -> Void
	) {
		EntitySubscription.shared.close(
			dartResultCallback: resultCallback,
			subscriptionId: parameters["subscriptionId"]!
		)
	}

	private static func getCloseReason(
		parameters: [String : String],
		resultCallback: @escaping (String?,String?, String?) -> Void
	) {
		EntitySubscription.shared.getCloseReason(
			dartResultCallback: resultCallback,
			subscriptionId: parameters["subscriptionId"]!
		)
	}

	private static func getEvent(
		parameters: [String : String],
		resultCallback: @escaping (String?,String?, String?) -> Void
	) {
		EntitySubscription.shared.getEvent(
			dartResultCallback: resultCallback,
			subscriptionId: parameters["subscriptionId"]!
		)
	}

	private static func waitForEvent(
		parameters: [String : String],
		resultCallback: @escaping (String?,String?, String?) -> Void
	) {
		EntitySubscription.shared.waitForEvent(
			dartResultCallback: resultCallback,
			subscriptionId: parameters["subscriptionId"]!,
			timeoutString: parameters["timeout"]!
		)
	}
}
