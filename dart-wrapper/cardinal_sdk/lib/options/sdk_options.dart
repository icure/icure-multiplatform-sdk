import 'package:cardinal_sdk/model/user_group.dart';

typedef GroupSelector = Future<String> Function(List<UserGroup>);

abstract interface class CommonSdkOptions {
  /// Configure which fields of entities should be encrypted
  EncryptedFieldsConfiguration get encryptedFields;

  /// If true (default) the password of the user will be salted together with the application id before sending it to
  /// the iCure backend for login or when changing the user password.
  /// This is done in addition to the server-side salting of the password before storing them.
  ///
  /// By enabling this option iCure never gets access to the plain text password of users.
  /// Note that changing this value in a second moment requires also modifying the password of the user on the iCure
  /// databases to reflect the change.
  bool get saltPasswordWithApplicationId;

  /// An instance of iCure SDK is initialized for working as a specific user in a single group.
  /// However, the user credentials may match multiple users in different groups (but at most one per group).
  /// If that is the case, this function will be used to pick the actual user for which the sdk will be initialized.
  ///
  /// This is mandatory in multi-group applications, where a single user could exist in multiple groups.
  /// If this parameter is null and the user credentials match multiple users the api initialisation will fail.
  /// In single-group applications this parameter won't be used, so it can be left as null.
  // GroupSelector? get groupSelector;
}

class SdkOptions implements CommonSdkOptions {
  @override final EncryptedFieldsConfiguration encryptedFields;
  @override final bool saltPasswordWithApplicationId;
  // @override final GroupSelector? groupSelector;
  /// Has only effect when logging in as an hcp user.
  ///
  /// If true the api will be initialized in a hierarchical mode, where each data owner is considered to have access
  /// to all data of his parents (requires corresponding permission on the server side).
  /// In this case the sdk will also expect to have access to at least a key for each parent data owner of the current
  /// user.
  ///
  /// If false the api will ignore the data owner hierarchies.
  /// Each data owner is considered to have access only to data shared explicitly with him, and has access only to his
  /// own keys.
  final bool useHierarchicalDataOwners;
  /// If true (default) the sdk will automatically create the transfer keys for the current user if a new keypair is
  /// created.
  final bool createTransferKeys;

  const SdkOptions({
    this.encryptedFields = const EncryptedFieldsConfiguration(),
    this.saltPasswordWithApplicationId = true,
    // this.groupSelector,
    this.useHierarchicalDataOwners = true,
    this.createTransferKeys = true
  });

  factory SdkOptions.fromJSON(Map<String, dynamic> data) {
    return SdkOptions(
        encryptedFields: EncryptedFieldsConfiguration.fromJSON(data["encryptedFields"]),
        saltPasswordWithApplicationId: data["saltPasswordWithApplicationId"] as bool,
        useHierarchicalDataOwners: data["useHierarchicalDataOwners"] as bool,
        createTransferKeys: data["createTransferKeys"] as bool
    );
  }

  static Map<String, dynamic> encode(SdkOptions value) {
    Map<String, dynamic> entityAsMap = {
      "encryptedFields": EncryptedFieldsConfiguration.encode(value.encryptedFields),
      "saltPasswordWithApplicationId": value.saltPasswordWithApplicationId,
      "useHierarchicalDataOwners": value.useHierarchicalDataOwners,
      "createTransferKeys": value.createTransferKeys
    };
    return entityAsMap;
  }
}

class BasicSdkOptions implements CommonSdkOptions {
  @override final EncryptedFieldsConfiguration encryptedFields;
  @override final bool saltPasswordWithApplicationId;
  // @override final GroupSelector? groupSelector;

  const BasicSdkOptions({
    this.encryptedFields = const EncryptedFieldsConfiguration(),
    this.saltPasswordWithApplicationId = true,
    // this.groupSelector
  });

  factory BasicSdkOptions.fromJSON(Map<String, dynamic> data) {
    return BasicSdkOptions(
        encryptedFields: EncryptedFieldsConfiguration.fromJSON(data["encryptedFields"]),
        saltPasswordWithApplicationId: data["saltPasswordWithApplicationId"] as bool
    );
  }

  static Map<String, dynamic> encode(BasicSdkOptions value) {
    Map<String, dynamic> entityAsMap = {
      "encryptedFields": EncryptedFieldsConfiguration.encode(value.encryptedFields),
      "saltPasswordWithApplicationId": value.saltPasswordWithApplicationId
    };
    return entityAsMap;
  }
}

class EncryptedFieldsConfiguration {
  final Set<String> accessLog;
  final Set<String> calendarItem;
  final Set<String> contact;
  final Set<String> service;
  final Set<String> healthElement;
  final Set<String> maintenanceTask;
  final Set<String> patient;
  final Set<String> message;
  final Set<String> topic;
  final Set<String> document;
  final Set<String> form;
  final Set<String> receipt;
  final Set<String> classification;
  final Set<String> timeTable;
  final Set<String> invoice;

  const EncryptedFieldsConfiguration({
    this.accessLog = const {"detail", "objectId"},
    this.calendarItem = const {"descr", "notes[].markdown"},
    this.contact = const  {"descr", "notes[].markdown"},
    this.service = const {"notes[].markdown"},
    this.healthElement = const {"descr", "note", "notes[].markdown"},
    this.maintenanceTask = const {"properties"},
    this.patient = const {"note", "notes[].markdown"},
    this.message = const {"subject"},
    this.topic = const {"description", "linkedServices", "linkedHealthElements"},
    this.document = const {},
    this.form = const {},
    this.receipt = const {},
    this.classification = const {},
    this.timeTable = const {},
    this.invoice = const {}
  });

  factory EncryptedFieldsConfiguration.fromJSON(Map<String, dynamic> data) {
    return EncryptedFieldsConfiguration(
        accessLog: (data["accessLog"] as List<dynamic>).map((x) => x as String).toSet(),
        calendarItem: (data["calendarItem"] as List<dynamic>).map((x) => x as String).toSet(),
        contact: (data["contact"] as List<dynamic>).map((x) => x as String).toSet(),
        service: (data["service"] as List<dynamic>).map((x) => x as String).toSet(),
        healthElement: (data["healthElement"] as List<dynamic>).map((x) => x as String).toSet(),
        maintenanceTask: (data["maintenanceTask"] as List<dynamic>).map((x) => x as String).toSet(),
        patient: (data["patient"] as List<dynamic>).map((x) => x as String).toSet(),
        message: (data["message"] as List<dynamic>).map((x) => x as String).toSet(),
        topic: (data["topic"] as List<dynamic>).map((x) => x as String).toSet(),
        document: (data["document"] as List<dynamic>).map((x) => x as String).toSet(),
        form: (data["form"] as List<dynamic>).map((x) => x as String).toSet(),
        receipt: (data["receipt"] as List<dynamic>).map((x) => x as String).toSet(),
        classification: (data["classification"] as List<dynamic>).map((x) => x as String).toSet(),
        timeTable: (data["timeTable"] as List<dynamic>).map((x) => x as String).toSet(),
        invoice: (data["invoice"] as List<dynamic>).map((x) => x as String).toSet(),
    );
  }

  static Map<String, dynamic> encode(EncryptedFieldsConfiguration value) {
    Map<String, dynamic> entityAsMap = {
      "accessLog": value.accessLog.toList(),
      "calendarItem": value.calendarItem.toList(),
      "contact": value.contact.toList(),
      "service": value.service.toList(),
      "healthElement": value.healthElement.toList(),
      "maintenanceTask": value.maintenanceTask.toList(),
      "patient": value.patient.toList(),
      "message": value.message.toList(),
      "topic": value.topic.toList(),
      "document": value.document.toList(),
      "form": value.form.toList(),
      "receipt": value.receipt.toList(),
      "classification": value.classification.toList(),
      "timeTable": value.timeTable.toList(),
      "invoice": value.invoice.toList()
    };
    return entityAsMap;
  }
}