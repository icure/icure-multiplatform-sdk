// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/plugin/api/keyword_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/device_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/access_log_basic_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/place_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/medical_location_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/time_table_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/document_basic_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/patient_basic_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/time_table_basic_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/classification_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/calendar_item_basic_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/maintenance_task_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/form_basic_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/recovery_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/patient_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/maintenance_task_basic_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/tarification_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/contact_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/receipt_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/healthcare_party_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/access_log_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/permission_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/code_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/front_end_migration_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/topic_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/document_template_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/health_element_basic_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/system_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/contact_basic_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/calendar_item_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/application_settings_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/crypto_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/receipt_basic_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/entity_reference_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/classification_basic_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/shamir_keys_manager_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/document_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/entity_template_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/data_owner_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/user_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/role_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/message_basic_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/form_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/cardinal_maintenance_task_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/invoice_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/message_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/health_element_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/invoice_basic_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/topic_basic_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/insurance_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/agenda_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/group_platform_api.dart';
import 'package:cardinal_sdk/plugin/api/cardinal_sdk_platform_apis_plugin.dart';


class CardinalSdkMethodChannelApis extends CardinalSdkPlatformApisPlugin {
	static const MethodChannel _methodChannel = const MethodChannel("com.icure.cardinal.sdk/api");
	KeywordPlatformApi _keyword = KeywordPlatformApi(_methodChannel);
	@override KeywordPlatformApi get keyword => _keyword;
	DevicePlatformApi _device = DevicePlatformApi(_methodChannel);
	@override DevicePlatformApi get device => _device;
	AccessLogBasicPlatformApi _accessLogBasic = AccessLogBasicPlatformApi(_methodChannel);
	@override AccessLogBasicPlatformApi get accessLogBasic => _accessLogBasic;
	PlacePlatformApi _place = PlacePlatformApi(_methodChannel);
	@override PlacePlatformApi get place => _place;
	MedicalLocationPlatformApi _medicalLocation = MedicalLocationPlatformApi(_methodChannel);
	@override MedicalLocationPlatformApi get medicalLocation => _medicalLocation;
	TimeTablePlatformApi _timeTable = TimeTablePlatformApi(_methodChannel);
	@override TimeTablePlatformApi get timeTable => _timeTable;
	DocumentBasicPlatformApi _documentBasic = DocumentBasicPlatformApi(_methodChannel);
	@override DocumentBasicPlatformApi get documentBasic => _documentBasic;
	PatientBasicPlatformApi _patientBasic = PatientBasicPlatformApi(_methodChannel);
	@override PatientBasicPlatformApi get patientBasic => _patientBasic;
	TimeTableBasicPlatformApi _timeTableBasic = TimeTableBasicPlatformApi(_methodChannel);
	@override TimeTableBasicPlatformApi get timeTableBasic => _timeTableBasic;
	ClassificationPlatformApi _classification = ClassificationPlatformApi(_methodChannel);
	@override ClassificationPlatformApi get classification => _classification;
	CalendarItemBasicPlatformApi _calendarItemBasic = CalendarItemBasicPlatformApi(_methodChannel);
	@override CalendarItemBasicPlatformApi get calendarItemBasic => _calendarItemBasic;
	MaintenanceTaskPlatformApi _maintenanceTask = MaintenanceTaskPlatformApi(_methodChannel);
	@override MaintenanceTaskPlatformApi get maintenanceTask => _maintenanceTask;
	FormBasicPlatformApi _formBasic = FormBasicPlatformApi(_methodChannel);
	@override FormBasicPlatformApi get formBasic => _formBasic;
	RecoveryPlatformApi _recovery = RecoveryPlatformApi(_methodChannel);
	@override RecoveryPlatformApi get recovery => _recovery;
	PatientPlatformApi _patient = PatientPlatformApi(_methodChannel);
	@override PatientPlatformApi get patient => _patient;
	MaintenanceTaskBasicPlatformApi _maintenanceTaskBasic = MaintenanceTaskBasicPlatformApi(_methodChannel);
	@override MaintenanceTaskBasicPlatformApi get maintenanceTaskBasic => _maintenanceTaskBasic;
	TarificationPlatformApi _tarification = TarificationPlatformApi(_methodChannel);
	@override TarificationPlatformApi get tarification => _tarification;
	ContactPlatformApi _contact = ContactPlatformApi(_methodChannel);
	@override ContactPlatformApi get contact => _contact;
	ReceiptPlatformApi _receipt = ReceiptPlatformApi(_methodChannel);
	@override ReceiptPlatformApi get receipt => _receipt;
	HealthcarePartyPlatformApi _healthcareParty = HealthcarePartyPlatformApi(_methodChannel);
	@override HealthcarePartyPlatformApi get healthcareParty => _healthcareParty;
	AccessLogPlatformApi _accessLog = AccessLogPlatformApi(_methodChannel);
	@override AccessLogPlatformApi get accessLog => _accessLog;
	PermissionPlatformApi _permission = PermissionPlatformApi(_methodChannel);
	@override PermissionPlatformApi get permission => _permission;
	CodePlatformApi _code = CodePlatformApi(_methodChannel);
	@override CodePlatformApi get code => _code;
	FrontEndMigrationPlatformApi _frontEndMigration = FrontEndMigrationPlatformApi(_methodChannel);
	@override FrontEndMigrationPlatformApi get frontEndMigration => _frontEndMigration;
	TopicPlatformApi _topic = TopicPlatformApi(_methodChannel);
	@override TopicPlatformApi get topic => _topic;
	DocumentTemplatePlatformApi _documentTemplate = DocumentTemplatePlatformApi(_methodChannel);
	@override DocumentTemplatePlatformApi get documentTemplate => _documentTemplate;
	HealthElementBasicPlatformApi _healthElementBasic = HealthElementBasicPlatformApi(_methodChannel);
	@override HealthElementBasicPlatformApi get healthElementBasic => _healthElementBasic;
	SystemPlatformApi _system = SystemPlatformApi(_methodChannel);
	@override SystemPlatformApi get system => _system;
	ContactBasicPlatformApi _contactBasic = ContactBasicPlatformApi(_methodChannel);
	@override ContactBasicPlatformApi get contactBasic => _contactBasic;
	CalendarItemPlatformApi _calendarItem = CalendarItemPlatformApi(_methodChannel);
	@override CalendarItemPlatformApi get calendarItem => _calendarItem;
	ApplicationSettingsPlatformApi _applicationSettings = ApplicationSettingsPlatformApi(_methodChannel);
	@override ApplicationSettingsPlatformApi get applicationSettings => _applicationSettings;
	CryptoPlatformApi _crypto = CryptoPlatformApi(_methodChannel);
	@override CryptoPlatformApi get crypto => _crypto;
	ReceiptBasicPlatformApi _receiptBasic = ReceiptBasicPlatformApi(_methodChannel);
	@override ReceiptBasicPlatformApi get receiptBasic => _receiptBasic;
	EntityReferencePlatformApi _entityReference = EntityReferencePlatformApi(_methodChannel);
	@override EntityReferencePlatformApi get entityReference => _entityReference;
	ClassificationBasicPlatformApi _classificationBasic = ClassificationBasicPlatformApi(_methodChannel);
	@override ClassificationBasicPlatformApi get classificationBasic => _classificationBasic;
	ShamirKeysManagerPlatformApi _shamirKeysManager = ShamirKeysManagerPlatformApi(_methodChannel);
	@override ShamirKeysManagerPlatformApi get shamirKeysManager => _shamirKeysManager;
	DocumentPlatformApi _document = DocumentPlatformApi(_methodChannel);
	@override DocumentPlatformApi get document => _document;
	EntityTemplatePlatformApi _entityTemplate = EntityTemplatePlatformApi(_methodChannel);
	@override EntityTemplatePlatformApi get entityTemplate => _entityTemplate;
	DataOwnerPlatformApi _dataOwner = DataOwnerPlatformApi(_methodChannel);
	@override DataOwnerPlatformApi get dataOwner => _dataOwner;
	UserPlatformApi _user = UserPlatformApi(_methodChannel);
	@override UserPlatformApi get user => _user;
	RolePlatformApi _role = RolePlatformApi(_methodChannel);
	@override RolePlatformApi get role => _role;
	MessageBasicPlatformApi _messageBasic = MessageBasicPlatformApi(_methodChannel);
	@override MessageBasicPlatformApi get messageBasic => _messageBasic;
	FormPlatformApi _form = FormPlatformApi(_methodChannel);
	@override FormPlatformApi get form => _form;
	CardinalMaintenanceTaskPlatformApi _cardinalMaintenanceTask = CardinalMaintenanceTaskPlatformApi(_methodChannel);
	@override CardinalMaintenanceTaskPlatformApi get cardinalMaintenanceTask => _cardinalMaintenanceTask;
	InvoicePlatformApi _invoice = InvoicePlatformApi(_methodChannel);
	@override InvoicePlatformApi get invoice => _invoice;
	MessagePlatformApi _message = MessagePlatformApi(_methodChannel);
	@override MessagePlatformApi get message => _message;
	HealthElementPlatformApi _healthElement = HealthElementPlatformApi(_methodChannel);
	@override HealthElementPlatformApi get healthElement => _healthElement;
	InvoiceBasicPlatformApi _invoiceBasic = InvoiceBasicPlatformApi(_methodChannel);
	@override InvoiceBasicPlatformApi get invoiceBasic => _invoiceBasic;
	TopicBasicPlatformApi _topicBasic = TopicBasicPlatformApi(_methodChannel);
	@override TopicBasicPlatformApi get topicBasic => _topicBasic;
	InsurancePlatformApi _insurance = InsurancePlatformApi(_methodChannel);
	@override InsurancePlatformApi get insurance => _insurance;
	AgendaPlatformApi _agenda = AgendaPlatformApi(_methodChannel);
	@override AgendaPlatformApi get agenda => _agenda;
	GroupPlatformApi _group = GroupPlatformApi(_methodChannel);
	@override GroupPlatformApi get group => _group;
}