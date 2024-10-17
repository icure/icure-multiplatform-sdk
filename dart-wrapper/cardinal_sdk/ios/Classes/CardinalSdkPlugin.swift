import Flutter
import UIKit
import Lib

public class CardinalSdkPlugin: NSObject, FlutterPlugin {
  public static func register(with registrar: FlutterPluginRegistrar) {
    ApiDemo.shared.setupScope()
    let channel = FlutterMethodChannel(name: "cardinal_sdk", binaryMessenger: registrar.messenger())
    let instance = CardinalSdkPlugin()
    registrar.addMethodCallDelegate(instance, channel: channel)
  }
    
    public func detachFromEngine(for registrar: any FlutterPluginRegistrar) {
        ApiDemo.shared.teardownScope()
    }

  public func handle(_ call: FlutterMethodCall, result: @escaping FlutterResult) {
    let  args = call.arguments as! [String: String]
    switch call.method {
    case "usePlatformMethod":
        ApiDemo.shared.useApi(data: args["data"]!, callbackResult: { res in
            result(res)
        })
    default:
      result(FlutterMethodNotImplemented)
    }
  }
}
