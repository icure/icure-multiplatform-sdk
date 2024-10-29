import 'dart:convert';

import 'package:cardinal_sdk/api/access_log_api.dart';
import 'package:cardinal_sdk/api/agenda_api.dart';
import 'package:cardinal_sdk/api/application_settings_api.dart';
import 'package:cardinal_sdk/api/calendar_item_api.dart';
import 'package:cardinal_sdk/api/cardinal_maintenance_task_api.dart';
import 'package:cardinal_sdk/api/classification_api.dart';
import 'package:cardinal_sdk/api/code_api.dart';
import 'package:cardinal_sdk/api/contact_api.dart';
import 'package:cardinal_sdk/api/crypto_api.dart';
import 'package:cardinal_sdk/api/data_owner_api.dart';
import 'package:cardinal_sdk/api/device_api.dart';
import 'package:cardinal_sdk/api/document_api.dart';
import 'package:cardinal_sdk/api/document_template_api.dart';
import 'package:cardinal_sdk/api/entity_reference_api.dart';
import 'package:cardinal_sdk/api/entity_template_api.dart';
import 'package:cardinal_sdk/api/form_api.dart';
import 'package:cardinal_sdk/api/front_end_migration_api.dart';
import 'package:cardinal_sdk/api/group_api.dart';
import 'package:cardinal_sdk/api/health_element_api.dart';
import 'package:cardinal_sdk/api/healthcare_party_api.dart';
import 'package:cardinal_sdk/api/insurance_api.dart';
import 'package:cardinal_sdk/api/keyword_api.dart';
import 'package:cardinal_sdk/api/maintenance_task_api.dart';
import 'package:cardinal_sdk/api/medical_location_api.dart';
import 'package:cardinal_sdk/api/message_api.dart';
import 'package:cardinal_sdk/api/patient_api.dart';
import 'package:cardinal_sdk/api/permission_api.dart';
import 'package:cardinal_sdk/api/place_api.dart';
import 'package:cardinal_sdk/api/role_api.dart';
import 'package:cardinal_sdk/api/system_api.dart';
import 'package:cardinal_sdk/api/tarification_api.dart';
import 'package:cardinal_sdk/api/time_table_api.dart';
import 'package:cardinal_sdk/api/topic_api.dart';
import 'package:cardinal_sdk/api/user_api.dart';
import 'package:cardinal_sdk/auth/authentication_method.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_initializers.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:flutter/services.dart';
import 'auth/authentication_process_telecom_type.dart';
import 'auth/authentication_process_template_parameters.dart';
import 'auth/captcha_options.dart';
import 'options/sdk_options.dart';
import 'options/storage_options.dart';

class AuthenticationWithProcessStep {
  static final Finalizer<String> _finalizer = Finalizer((resourceId) =>
      CardinalSdkPlatformInterface.instance.utils.releasePlatformResource(resourceId)
  );

  final String _instanceId;
  AuthenticationWithProcessStep._(this._instanceId);

  factory AuthenticationWithProcessStep._factory(String instanceId) {
    final authStep = AuthenticationWithProcessStep._(instanceId);
    _finalizer.attach(authStep, instanceId, detach: authStep);
    return authStep;
  }

  Future<CardinalSdk> completeAuthentication(String validationCode) {
    return CardinalSdkPlatformInterface.instance.initializers.completeAuthentication(_instanceId, validationCode);
  }
}

class CardinalSdk {
  static final Finalizer<String> _finalizer = Finalizer((resourceId) =>
      CardinalSdkPlatformInterface.instance.utils.releasePlatformResource(resourceId)
  );

  final String _sdkId;
  final ApplicationSettingsApi applicationSettings;
  final CodeApi code;
  final DeviceApi device;
  final DocumentTemplateApi documentTemplate;
  final EntityReferenceApi entityReference;
  final EntityTemplateApi entityTemplate;
  final FrontEndMigrationApi frontEndMigration;
  final GroupApi group;
  final HealthcarePartyApi healthcareParty;
  final SystemApi system;
  final InsuranceApi insurance;
  final KeywordApi keyword;
  final PermissionApi permission;
  final PlaceApi place;
  final RoleApi role;
  final TarificationApi tarification;
  final UserApi user;
  final MedicalLocationApi medicalLocation;
  final AgendaApi agenda;
  final AccessLogApi accessLog;
  final CalendarItemApi calendarItem;
  final ClassificationApi classification;
  final ContactApi contact;
  final DocumentApi document;
  final FormApi form;
  final HealthElementApi healthElement;
  final MaintenanceTaskApi maintenanceTask;
  final MessageApi message;
  final PatientApi patient;
  final TimeTableApi timeTable;
  final TopicApi topic;
  final CryptoApi crypto;
  // final RecoveryApi recovery;
  final CardinalMaintenanceTaskApi cardinalMaintenanceTask;
  final DataOwnerApi dataOwner;

  CardinalSdk._(
    this._sdkId
  ) : applicationSettings = ApplicationSettingsApi(_sdkId),
    code = CodeApi(_sdkId),
    device = DeviceApi(_sdkId),
    documentTemplate = DocumentTemplateApi(_sdkId),
    entityReference = EntityReferenceApi(_sdkId),
    entityTemplate = EntityTemplateApi(_sdkId),
    frontEndMigration = FrontEndMigrationApi(_sdkId),
    group = GroupApi(_sdkId),
    healthcareParty = HealthcarePartyApi(_sdkId),
    system = SystemApi(_sdkId),
    insurance = InsuranceApi(_sdkId),
    keyword = KeywordApi(_sdkId),
    permission = PermissionApi(_sdkId),
    place = PlaceApi(_sdkId),
    role = RoleApi(_sdkId),
    tarification = TarificationApi(_sdkId),
    user = UserApi(_sdkId),
    medicalLocation = MedicalLocationApi(_sdkId),
    agenda = AgendaApi(_sdkId),
    accessLog = AccessLogApi(_sdkId),
    calendarItem = CalendarItemApi(_sdkId),
    classification = ClassificationApi(_sdkId),
    contact = ContactApi(_sdkId),
    document = DocumentApi(_sdkId),
    form = FormApi(_sdkId),
    healthElement = HealthElementApi(_sdkId),
    maintenanceTask = MaintenanceTaskApi(_sdkId),
    message = MessageApi(_sdkId),
    patient = PatientApi(_sdkId),
    timeTable = TimeTableApi(_sdkId),
    topic = TopicApi(_sdkId),
    crypto = CryptoApi(_sdkId),
    cardinalMaintenanceTask = CardinalMaintenanceTaskApi(_sdkId),
    dataOwner = DataOwnerApi(_sdkId);

  factory CardinalSdk._factory(String sdkId) {
    final sdk = CardinalSdk._(sdkId);
    _finalizer.attach(sdk, sdkId, detach: sdk);
    return sdk;
  }

  static Future<AuthenticationWithProcessStep> initializeWithProcess(
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
  ) {
    return CardinalSdkPlatformInterface.instance.initializers.initializeWithProcess(
        applicationId,
        baseUrl,
        messageGatewayUrl,
        externalServicesSpecId,
        processId,
        userTelecomType,
        userTelecom,
        captcha,
        storageOptions,
        authenticationProcessTemplateParameters,
        options
    );
  }

  static Future<CardinalSdk> initialize(
      String? applicationId,
      String baseUrl,
      AuthenticationMethod authenticationMethod,
      StorageOptions storageOptions,
      {SdkOptions options = const SdkOptions()}
  ) {
    return CardinalSdkPlatformInterface.instance.initializers.initialize(
        applicationId,
        baseUrl,
        authenticationMethod,
        storageOptions,
        options
    );
  }
}

class CardinalSdkMethodChannelInitializers extends CardinalSdkInitializersPlugin {
  static const MethodChannel _methodChannel = MethodChannel("com.icure.cardinal.sdk/initializers");



  @override
  Future<AuthenticationWithProcessStep> initializeWithProcess(
      String? applicationId,
      String baseUrl,
      String messageGatewayUrl,
      String externalServicesSpecId,
      String processId,
      AuthenticationProcessTelecomType userTelecomType,
      String userTelecom,
      CaptchaOptions captcha,
      StorageOptions storageOptions,
      AuthenticationProcessTemplateParameters authenticationProcessTemplateParameters,
      SdkOptions options
  ) async {
    final res = await _methodChannel.invokeMethod<String>(
        "initializeWithProcess",
        {
          "applicationId": jsonEncode(applicationId),
          "baseUrl": jsonEncode(baseUrl),
          "messageGatewayUrl": jsonEncode(messageGatewayUrl),
          "externalServicesSpecId": jsonEncode(externalServicesSpecId),
          "processId": jsonEncode(processId),
          "userTelecomType": jsonEncode(AuthenticationProcessTelecomType.encode(userTelecomType)),
          "userTelecom": jsonEncode(userTelecom),
          "captcha": jsonEncode(CaptchaOptions.encode(captcha)),
          "storageOptions": jsonEncode(StorageOptions.encode(storageOptions)),
          "authenticationProcessTemplateParameters": jsonEncode(AuthenticationProcessTemplateParameters.encode(authenticationProcessTemplateParameters)),
          "options": jsonEncode(SdkOptions.encode(options))
        }
    );
    if (res == null) throw AssertionError("received null result from platform method initializeWithProcess");
    final parsedResJson = jsonDecode(res);
    return AuthenticationWithProcessStep._factory(parsedResJson as String);
  }

  @override
  Future<CardinalSdk> completeAuthentication(String authenticationStepId, String validationCode) async {
    final res = await _methodChannel.invokeMethod<String>(
        "completeAuthentication",
        {
          "authenticationStepId": authenticationStepId,
          "validationCode": jsonEncode(validationCode)
        }
    );
    if (res == null) throw AssertionError("received null result from platform method completeAuthentication");
    final parsedResJson = jsonDecode(res);
    return CardinalSdk._factory(parsedResJson as String);
  }

  @override
  Future<CardinalSdk> initialize(
      String? applicationId,
      String baseUrl,
      AuthenticationMethod authenticationMethod,
      StorageOptions storageOptions,
      SdkOptions options
  ) async {
    final res = await _methodChannel.invokeMethod<String>(
        "initialize",
        {
          "applicationId": jsonEncode(applicationId),
          "baseUrl": jsonEncode(baseUrl),
          "authenticationMethod": jsonEncode(AuthenticationMethod.encode(authenticationMethod)),
          "storageOptions": jsonEncode(StorageOptions.encode(storageOptions)),
          "options": jsonEncode(SdkOptions.encode(options))
        }
    );
    if (res == null) throw AssertionError("received null result from platform method initialize");
    final parsedResJson = jsonDecode(res);
    return CardinalSdk._factory(parsedResJson as String);
  }
}