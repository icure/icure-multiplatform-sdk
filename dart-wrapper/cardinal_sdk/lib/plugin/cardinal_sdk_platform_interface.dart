import 'package:cardinal_sdk/plugin/api/cardinal_sdk_method_channel_apis.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_pagination.dart';
import 'package:cardinal_sdk/plugin/api/cardinal_sdk_platform_apis_plugin.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_initializers.dart';
import 'package:plugin_platform_interface/plugin_platform_interface.dart';

class CardinalSdkPlatformInterface extends PlatformInterface {
  CardinalSdkPlatformInterface() : super(token: _token);

  static final Object _token = Object();

  static CardinalSdkPlatformInterface _instance = CardinalSdkMethodChannelInterface();

  static CardinalSdkPlatformInterface get instance => _instance;

  static set instance(CardinalSdkPlatformInterface instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }

  CardinalSdkPlatformApisPlugin get apis => throw UnimplementedError();
  CardinalSdkPlatformPaginationPlugin get pagination => throw UnimplementedError();
  CardinalSdkInitializersPlugin get initializers => throw UnimplementedError();
}

class CardinalSdkMethodChannelInterface extends CardinalSdkPlatformInterface {
  final _apis = CardinalSdkMethodChannelApis();
  final _pagination = CardinalSdkMethodChannelPagination();
  final _initializers = CardinalSdkMethodChannelInitializers();

  @override
  CardinalSdkPlatformApisPlugin get apis => _apis;

  @override
  CardinalSdkPlatformPaginationPlugin get pagination => _pagination;

  @override
  CardinalSdkInitializersPlugin get initializers => _initializers;
}