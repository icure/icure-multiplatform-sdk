import 'package:cardinal_sdk/cardinal_sdk.dart';
import 'package:cardinal_sdk/plugin/api/cardinal_sdk_method_channel_apis.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_crypto.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_pagination.dart';
import 'package:cardinal_sdk/plugin/api/cardinal_sdk_platform_apis_plugin.dart';
import 'package:cardinal_sdk/plugin/filters/cardinal_sdk_platform_filters_plugin.dart';
import 'package:cardinal_sdk/plugin/filters/cardinal_sdk_method_channel_filters.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_initializers.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_subscription.dart';
import 'package:plugin_platform_interface/plugin_platform_interface.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_utils.dart';
import 'package:cardinal_sdk/plugin/dart_method_channel_callbacks.dart';


class CardinalSdkPlatformInterface extends PlatformInterface {
  CardinalSdkPlatformInterface() : super(token: _token);

  static final Object _token = Object();

  static CardinalSdkPlatformInterface _instance = CardinalSdkMethodChannelInterface();

  static CardinalSdkPlatformInterface get instance => _instance;

  static set instance(CardinalSdkPlatformInterface instance) {
    PlatformInterface.verify(instance, _token);
    _instance = instance;
  }

  CardinalSdkPlatformApisPlugin get apis => throw UnimplementedError();
  CardinalSdkPlatformPaginationPlugin get pagination => throw UnimplementedError();
  CardinalSdkInitializersPlugin get initializers => throw UnimplementedError();
  CardinalSdkPlatformSubscriptionPlugin get subscription => throw UnimplementedError();
  CardinalSdkPlatformFiltersPlugin get filters => throw UnimplementedError();
  CardinalSdkPlatformUtilsPlugin get utils => throw UnimplementedError();
  CardinalSdkPlatformCryptoPlugin get crypto => throw UnimplementedError();
}

class CardinalSdkMethodChannelInterface extends CardinalSdkPlatformInterface {
  final _apis = CardinalSdkMethodChannelApis();
  final _pagination = CardinalSdkMethodChannelPagination();
  final _initializers = CardinalSdkMethodChannelInitializers();
  final _subscription = CardinalSdkMethodChannelSubscription();
  final _filters = CardinalSdkMethodChannelFilters();
  final _utils = CardinalSdkMethodChannelUtils();
  final _crypto = CardinalSdkMethodChannelCrypto();

  CardinalSdkMethodChannelInterface() {
    DartMethodChannelCallbacks.register();
  }

  @override
  CardinalSdkPlatformApisPlugin get apis => _apis;

  @override
  CardinalSdkPlatformPaginationPlugin get pagination => _pagination;

  @override
  CardinalSdkInitializersPlugin get initializers => _initializers;

  @override
  CardinalSdkPlatformSubscriptionPlugin get subscription => _subscription;

  @override
  CardinalSdkPlatformFiltersPlugin get filters => _filters;

  @override
  CardinalSdkPlatformUtilsPlugin get utils => _utils;

  @override
  CardinalSdkPlatformCryptoPlugin get crypto => _crypto;
}