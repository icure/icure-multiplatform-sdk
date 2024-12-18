import Flutter
import CardinalDartSdkSupportLib

class CryptoPlugin {

	public static func handle(_ call: FlutterMethodCall, result: @escaping FlutterResult) {
		let args = call.arguments as! [String: String]
		let methodName = call.method

		let completed = SubscriptionPlugin.dispatch(methodName: methodName, parameters: args) { success, errorCode, errorMessage, errorDetails in
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
			case "KeyPairRecoverer.waitForRecoveryKey": close(parameters: parameters, resultCallback: resultCallback)
			case "KeyPairRecoverer.recoverWithRecoveryKey": getCloseReason(parameters: parameters, resultCallback: resultCallback)
			default: return false
		}
		return true
	}

	private static func waitForRecoveryKey(
		parameters: [String : String],
		resultCallback: @escaping (
			String?,
			String?,
			String?,
			String?
		) -> Void
	) {
		KeyPairRecoverer.shared.waitForRecoveryKey(
			dartResultCallback: resultCallback,
            cancellationToken: Int64(parameters["cancellationToken"]!)!,
            referenceId: parameters["referenceId"]!,
            recoveryKeyString: parameters["recoveryKey"]!,
            autoDeleteString: parameters["autoDelete"]!,
            waitSecondsString: parameters["waitSeconds"]!
		)
	}

	private static func recoverWithRecoveryKey(
		parameters: [String : String],
		resultCallback: @escaping (
			String?,
			String?,
			String?,
			String?
		) -> Void
	) {
        KeyPairRecoverer.shared.recoverWithRecoveryKey(
			dartResultCallback: resultCallback,
            referenceId: parameters["referenceId"]!,
            recoveryKeyString: parameters["recoveryKey"]!,
            autoDeleteString: parameters["autoDelete"]!
		)
	}
}
