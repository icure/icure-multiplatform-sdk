import Flutter
import CardinalDartSdkSupportLib

class PaginatedListIteratorPlugin {

    public static func handle(_ call: FlutterMethodCall, result: @escaping FlutterResult) {
        let args = call.arguments as! [String: String]
        let methodName = call.method

        let completed = PaginatedListIteratorPlugin.dispatch(methodName: methodName, parameters: args) { success, errorCode, errorMessage in
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
		case "hasNext": hasNext(parameters: parameters, resultCallback: resultCallback)
		case "next": next(parameters: parameters, resultCallback: resultCallback)
    	default: return false
    }
    return true
  }

	private static func hasNext(
		parameters: [String : String],
		resultCallback: @escaping (String?,String?, String?) -> Void
	) {
		PaginatedListIterator.shared.hasNext(
			dartResultCallback: resultCallback,
			paginatedListIteratorId: parameters["paginatedListIteratorId"]!,
		)
	}

	private static func next(
		parameters: [String : String],
		resultCallback: @escaping (String?,String?, String?) -> Void
	) {
		PaginatedListIterator.shared.next(
			dartResultCallback: resultCallback,
			paginatedListIteratorId: parameters["paginatedListIteratorId"]!,
			limit: parameters["limit"]!
		)
	}

}