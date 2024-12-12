import Flutter
import CardinalDartSdkSupportLib

public class CardinalSdkPlugin: NSObject, FlutterPlugin {
	public static func register(with registrar: FlutterPluginRegistrar) {
		ApiScope.shared.setup()
		let apiChannel = FlutterMethodChannel(name: "com.icure.cardinal.sdk/api", binaryMessenger: registrar.messenger())
		let initializersChannel = FlutterMethodChannel(name: "com.icure.cardinal.sdk/initializers", binaryMessenger: registrar.messenger())
		let filtersChannel = FlutterMethodChannel(name: "com.icure.cardinal.sdk/filters", binaryMessenger: registrar.messenger())
		let paginationChannel = FlutterMethodChannel(name: "com.icure.cardinal.sdk/pagination", binaryMessenger: registrar.messenger())
		let subscriptionChannel = FlutterMethodChannel(name: "com.icure.cardinal.sdk/subscription", binaryMessenger: registrar.messenger())
		let utilsChannel = FlutterMethodChannel(name: "com.icure.cardinal.sdk/utils", binaryMessenger: registrar.messenger())
		apiChannel.setMethodCallHandler(ApisPlugin.handle)
		initializersChannel.setMethodCallHandler(InitializersPlugin.handle)
		paginationChannel.setMethodCallHandler(PaginatedListIteratorPlugin.handle)
		subscriptionChannel.setMethodCallHandler(SubscriptionPlugin.handle)
		utilsChannel.setMethodCallHandler(UtilsPlugin.handle)
		filtersChannel.setMethodCallHandler(FiltersPlugin.handle)
		registrar.addApplicationDelegate(CardinalSdkPlugin())
        let callbackChannel = FlutterMethodChannel(name: "com.icure.cardinal.sdk/dartCallbacks", binaryMessenger: registrar.messenger())
        DartCallbacksHandlerCompanion.shared.registerUsingMethodChannel { method, callbackId, args, resultCallback in
            let arguments: [String: String] = args != nil
              ? ["callbackId": callbackId, "params": args!]
              : ["callbackId": callbackId]
            callbackChannel.invokeMethod(method, arguments: arguments) { dartResult in
                if let stringResult = dartResult as? String {
                    resultCallback(stringResult, nil, nil, nil)
                } else if let dartError = dartResult as? FlutterError {
                    resultCallback(nil, dartError.code, dartError.message, dartError.details != nil ? String(describing: dartError.details!) : nil)
                } else {
                    resultCallback(nil, "UnexpectedDartResult", String(reflecting: dartResult), nil)
                }
            }
        }
	}
	public func detachFromEngine(for registrar: any FlutterPluginRegistrar) {
		ApiScope.shared.teardown()
        DartCallbacksHandlerCompanion.shared.unregister()
	}
}
