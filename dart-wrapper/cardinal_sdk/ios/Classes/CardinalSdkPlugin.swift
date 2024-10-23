import Flutter
import UIKit
import CardinalDartSdkSupportLib

public class CardinalSdkPlugin: NSObject, FlutterPlugin {
  public static func register(with registrar: FlutterPluginRegistrar) {
      ApiScope.shared.setup()
      let channel = FlutterMethodChannel(name: "com.icure.cardinal.sdk/api", binaryMessenger: registrar.messenger())
      let instance = CardinalSdkPlugin()
      registrar.addMethodCallDelegate(instance, channel: channel)
  }
    
    public func detachFromEngine(for registrar: any FlutterPluginRegistrar) {
        ApiScope.shared.teardown()
    }

  public func handle(_ call: FlutterMethodCall, result: @escaping FlutterResult) {
      let  args = call.arguments as! [String: String]
      let apiName = String(call.method.split(separator: ".").first!)
      let methodName = call.method.split(separator: ".").dropFirst().joined(separator: ".")
      
      let completed = dispatchApi(apiName: apiName, methodName: methodName, parameters: args) { success, errorCode, errorMessage in
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
