import 'package:cardinal_sdk/model/user_group.dart';

typedef GroupSelector = Future<String> Function(List<UserGroup>);

abstract interface class CommonSdkOptions {
  /**
   * Configure which fields of entities should be encrypted
   */
  EncryptedFieldsConfiguration get encryptedFields;

  /**
   * If true (default) the password of the user will be salted together with the application id before sending it to
   * the iCure backend for login or when changing the user password.
   * This is done in addition to the server-side salting of the password before storing them.
   *
   * By enabling this option iCure never gets access to the plain text password of users.
   * Note that changing this value in a second moment requires also modifying the password of the user on the iCure
   * databases to reflect the change.
   */
  bool get saltPasswordWithApplicationId;

  /**
   * An instance of iCure SDK is initialized for working as a specific user in a single group.
   * However, the user credentials may match multiple users in different groups (but at most one per group).
   * If that is the case, this function will be used to pick the actual user for which the sdk will be initialized.
   *
   * This is mandatory in multi-group applications, where a single user could exist in multiple groups.
   * If this parameter is null and the user credentials match multiple users the api initialisation will fail.
   * In single-group applications this parameter won't be used, so it can be left as null.
   */
  GroupSelector? get groupSelector;
}

class SdkOptions implements CommonSdkOptions {
  @override final EncryptedFieldsConfiguration encryptedFields;
  @override final bool saltPasswordWithApplicationId;
  @override final GroupSelector? groupSelector;
  /**
   * Has only effect when logging in as an hcp user.
   *
   * If true the api will be initialized in a hierarchical mode, where each data owner is considered to have access
   * to all data of his parents (requires corresponding permission on the server side).
   * In this case the sdk will also expect to have access to at least a key for each parent data owner of the current
   * user.
   *
   * If false the api will ignore the data owner hierarchies.
   * Each data owner is considered to have access only to data shared explicitly with him, and has access only to his
   * own keys.
   */
  final bool useHierarchicalDataOwners;
  /**
   * If true (default) the sdk will automatically create the transfer keys for the current user if a new keypair is
   * created.
   */
  final bool createTransferKeys;

  SdkOptions({
    EncryptedFieldsConfiguration? encryptedFields,
    this.saltPasswordWithApplicationId = true,
    this.groupSelector,
    this.useHierarchicalDataOwners = true,
    this.createTransferKeys = true
  }) : this.encryptedFields = encryptedFields ?? EncryptedFieldsConfiguration();
}

class BasicSdkOptions implements CommonSdkOptions {
  @override final EncryptedFieldsConfiguration encryptedFields;
  @override final bool saltPasswordWithApplicationId;
  @override final GroupSelector? groupSelector;

  BasicSdkOptions({
    EncryptedFieldsConfiguration? encryptedFields,
    this.saltPasswordWithApplicationId = true,
    this.groupSelector
  }) : this.encryptedFields = encryptedFields ?? EncryptedFieldsConfiguration();
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

  EncryptedFieldsConfiguration({
    Set<String> accessLog = const {"detail", "objectId"},
    Set<String> calendarItem = const {"descr", "notes[].markdown"},
    Set<String> contact = const  {"descr", "notes[].markdown"},
    Set<String> service = const {"notes[].markdown"},
    Set<String> healthElement = const {"descr", "note", "notes[].markdown"},
    Set<String> maintenanceTask = const {"properties"},
    Set<String> patient = const {"note", "notes[].markdown"},
    Set<String> message = const {"subject"},
    Set<String> topic = const {"description", "linkedServices", "linkedHealthElements"},
    Set<String> document = const {},
    Set<String> form = const {},
    Set<String> receipt = const {},
    Set<String> classification = const {},
    Set<String> timeTable = const {},
    Set<String> invoice = const {}
  }) : this.accessLog = accessLog,
    this.calendarItem = calendarItem,
    this.contact = contact,
    this.service = service,
    this.healthElement = healthElement,
    this.maintenanceTask = maintenanceTask,
    this.patient = patient,
    this.message = message,
    this.topic = topic,
    this.document = document,
    this.form = form,
    this.receipt = receipt,
    this.classification = classification,
    this.timeTable = timeTable,
    this.invoice = invoice;
}