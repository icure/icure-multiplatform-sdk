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
    }
        
    public func detachFromEngine(for registrar: any FlutterPluginRegistrar) {
        ApiScope.shared.teardown()
    }
}
