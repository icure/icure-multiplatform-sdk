import Flutter
import CardinalDartSdkSupportLib

public class CardinalSdkPlugin: NSObject, FlutterPlugin {
    public static func register(with registrar: FlutterPluginRegistrar) {
        ApiScope.shared.setup()
        let apiChannel = FlutterMethodChannel(name: "com.icure.cardinal.sdk/api", binaryMessenger: registrar.messenger())
        let initializersChannel = FlutterMethodChannel(name: "com.icure.cardinal.sdk/initializers", binaryMessenger: registrar.messenger())
        apiChannel.setMethodCallHandler(ApisPlugin.handle)
        initializersChannel.setMethodCallHandler(InitializersPlugin.handle)
        registrar.addApplicationDelegate(CardinalSdkPlugin())
    }
        
    public func detachFromEngine(for registrar: any FlutterPluginRegistrar) {
        ApiScope.shared.teardown()
    }
}
