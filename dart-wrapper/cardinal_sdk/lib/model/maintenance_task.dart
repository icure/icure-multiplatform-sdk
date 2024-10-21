// This file is auto-generated
import 'package:cardinal_sdk/model/base/identifier.dart';
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/property_stub.dart';
import 'package:cardinal_sdk/model/embed/task_status.dart';
import 'package:cardinal_sdk/model/embed/delegation.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/security_metadata.dart';
import 'package:cardinal_sdk/model/maintenance_task.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/icure_document.dart';
import 'package:cardinal_sdk/model/base/has_encryption_metadata.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';


sealed class MaintenanceTask implements StoredDocument, ICureDocument<String>, HasEncryptionMetadata, Encryptable {
	@override abstract String id;
	@override abstract String? rev;
	abstract List<Identifier> identifier;
	@override abstract int? created;
	@override abstract int? modified;
	@override abstract String? author;
	@override abstract String? responsible;
	@override abstract String? medicalLocationId;
	@override abstract Set<CodeStub> tags;
	@override abstract Set<CodeStub> codes;
	@override abstract int? endOfLife;
	@override abstract int? deletionDate;
	abstract String? taskType;
	Set<PropertyStub> get properties;
	abstract TaskStatus status;
	@override abstract Set<String> secretForeignKeys;
	@override abstract Map<String, Set<Delegation>> cryptedForeignKeys;
	@override abstract Map<String, Set<Delegation>> delegations;
	@override abstract Map<String, Set<Delegation>> encryptionKeys;
	@override abstract Base64String? encryptedSelf;
	@override abstract SecurityMetadata? securityMetadata;


	static Map<String, dynamic> encode(MaintenanceTask value) {
		switch (value) {
			case DecryptedMaintenanceTask entity:
				Map<String, dynamic> entityJson = DecryptedMaintenanceTask.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DecryptedMaintenanceTask";
				return entityJson;
			case EncryptedMaintenanceTask entity:
				Map<String, dynamic> entityJson = EncryptedMaintenanceTask.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.EncryptedMaintenanceTask";
				return entityJson;
		}
	}
}

class DecryptedMaintenanceTask implements MaintenanceTask {
	@override  String id;
	@override  String? rev;
	@override  List<Identifier> identifier = [];
	@override  int? created;
	@override  int? modified;
	@override  String? author;
	@override  String? responsible;
	@override  String? medicalLocationId;
	@override  Set<CodeStub> tags = {};
	@override  Set<CodeStub> codes = {};
	@override  int? endOfLife;
	@override  int? deletionDate;
	@override  String? taskType;
	@override  Set<DecryptedPropertyStub> properties = {};
	@override  TaskStatus status = TaskStatus.pending;
	@override  Set<String> secretForeignKeys = {};
	@override  Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override  Map<String, Set<Delegation>> delegations = {};
	@override  Map<String, Set<Delegation>> encryptionKeys = {};
	@override  Base64String? encryptedSelf;
	@override  SecurityMetadata? securityMetadata;

	DecryptedMaintenanceTask({
		required this.id,
		this.rev,
		this.created,
		this.modified,
		this.author,
		this.responsible,
		this.medicalLocationId,
		this.endOfLife,
		this.deletionDate,
		this.taskType,
		this.encryptedSelf,
		this.securityMetadata,
		List<Identifier>? identifier,
		Set<CodeStub>? tags,
		Set<CodeStub>? codes,
		Set<DecryptedPropertyStub>? properties,
		TaskStatus? status,
		Set<String>? secretForeignKeys,
		Map<String, Set<Delegation>>? cryptedForeignKeys,
		Map<String, Set<Delegation>>? delegations,
		Map<String, Set<Delegation>>? encryptionKeys
	}) : identifier = identifier ?? [],
		tags = tags ?? {},
		codes = codes ?? {},
		properties = properties ?? {},
		status = status ?? TaskStatus.pending,
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {};

	static Map<String, dynamic> encode(DecryptedMaintenanceTask value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"identifier" : value.identifier.map((x0) => Identifier.encode(x0)),
			"created" : value.created,
			"modified" : value.modified,
			"author" : value.author,
			"responsible" : value.responsible,
			"medicalLocationId" : value.medicalLocationId,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)),
			"endOfLife" : value.endOfLife,
			"deletionDate" : value.deletionDate,
			"taskType" : value.taskType,
			"properties" : value.properties.map((x0) => DecryptedPropertyStub.encode(x0)),
			"status" : TaskStatus.encode(value.status),
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!)
		};
		return entityAsMap;
	}
}

class EncryptedMaintenanceTask implements MaintenanceTask {
	@override  String id;
	@override  String? rev;
	@override  List<Identifier> identifier = [];
	@override  int? created;
	@override  int? modified;
	@override  String? author;
	@override  String? responsible;
	@override  String? medicalLocationId;
	@override  Set<CodeStub> tags = {};
	@override  Set<CodeStub> codes = {};
	@override  int? endOfLife;
	@override  int? deletionDate;
	@override  String? taskType;
	@override  Set<EncryptedPropertyStub> properties = {};
	@override  TaskStatus status = TaskStatus.pending;
	@override  Set<String> secretForeignKeys = {};
	@override  Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override  Map<String, Set<Delegation>> delegations = {};
	@override  Map<String, Set<Delegation>> encryptionKeys = {};
	@override  Base64String? encryptedSelf;
	@override  SecurityMetadata? securityMetadata;

	EncryptedMaintenanceTask({
		required this.id,
		this.rev,
		this.created,
		this.modified,
		this.author,
		this.responsible,
		this.medicalLocationId,
		this.endOfLife,
		this.deletionDate,
		this.taskType,
		this.encryptedSelf,
		this.securityMetadata,
		List<Identifier>? identifier,
		Set<CodeStub>? tags,
		Set<CodeStub>? codes,
		Set<EncryptedPropertyStub>? properties,
		TaskStatus? status,
		Set<String>? secretForeignKeys,
		Map<String, Set<Delegation>>? cryptedForeignKeys,
		Map<String, Set<Delegation>>? delegations,
		Map<String, Set<Delegation>>? encryptionKeys
	}) : identifier = identifier ?? [],
		tags = tags ?? {},
		codes = codes ?? {},
		properties = properties ?? {},
		status = status ?? TaskStatus.pending,
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {};

	static Map<String, dynamic> encode(EncryptedMaintenanceTask value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"identifier" : value.identifier.map((x0) => Identifier.encode(x0)),
			"created" : value.created,
			"modified" : value.modified,
			"author" : value.author,
			"responsible" : value.responsible,
			"medicalLocationId" : value.medicalLocationId,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)),
			"endOfLife" : value.endOfLife,
			"deletionDate" : value.deletionDate,
			"taskType" : value.taskType,
			"properties" : value.properties.map((x0) => EncryptedPropertyStub.encode(x0)),
			"status" : TaskStatus.encode(value.status),
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!)
		};
		return entityAsMap;
	}
}