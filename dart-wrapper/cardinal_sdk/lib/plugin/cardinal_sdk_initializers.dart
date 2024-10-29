import 'package:cardinal_sdk/auth/authentication_method.dart';
import 'package:cardinal_sdk/auth/authentication_process_telecom_type.dart';
import 'package:cardinal_sdk/auth/authentication_process_template_parameters.dart';
import 'package:cardinal_sdk/auth/captcha_options.dart';
import 'package:cardinal_sdk/cardinal_sdk.dart';
import 'package:cardinal_sdk/options/sdk_options.dart';
import 'package:cardinal_sdk/options/storage_options.dart';

abstract class CardinalSdkInitializersPlugin {
  Future<CardinalSdk> initialize(AuthenticationMethod authenticationMethod);
  Future<CardinalSdk> initializeWithProcess(
      String? applicationId,
      String baseUrl,
      String messageGatewayUrl,
      String externalServicesSpecId,
      String processId,
      AuthenticationProcessTelecomType userTelecomType,
      String userTelecom,
      CaptchaOptions captcha,
      StorageOptions storageOptions,
      {
        AuthenticationProcessTemplateParameters authenticationProcessTemplateParameters = const AuthenticationProcessTemplateParameters(),
        SdkOptions options = const SdkOptions()
      }
  );
}
