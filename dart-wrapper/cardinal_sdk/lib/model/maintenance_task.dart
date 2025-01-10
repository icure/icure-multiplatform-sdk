// auto-generated file
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

	static MaintenanceTask fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.DecryptedMaintenanceTask":
				return DecryptedMaintenanceTask.fromJSON(data);
			case "com.icure.cardinal.sdk.model.EncryptedMaintenanceTask":
				return EncryptedMaintenanceTask.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

class DecryptedMaintenanceTask implements MaintenanceTask {
	@override String id;
	@override String? rev = null;
	@override List<Identifier> identifier = [];
	@override int? created = null;
	@override int? modified = null;
	@override String? author = null;
	@override String? responsible = null;
	@override String? medicalLocationId = null;
	@override Set<CodeStub> tags = {};
	@override Set<CodeStub> codes = {};
	@override int? endOfLife = null;
	@override int? deletionDate = null;
	@override String? taskType = null;
	@override Set<DecryptedPropertyStub> properties = {};
	@override TaskStatus status = TaskStatus.pending;
	@override Set<String> secretForeignKeys = {};
	@override Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override Map<String, Set<Delegation>> delegations = {};
	@override Map<String, Set<Delegation>> encryptionKeys = {};
	@override Base64String? encryptedSelf = null;
	@override SecurityMetadata? securityMetadata = null;
	DecryptedMaintenanceTask(
		this.id,
		{
			String? rev,
			List<Identifier>? identifier,
			int? created,
			int? modified,
			String? author,
			String? responsible,
			String? medicalLocationId,
			Set<CodeStub>? tags,
			Set<CodeStub>? codes,
			int? endOfLife,
			int? deletionDate,
			String? taskType,
			Set<DecryptedPropertyStub>? properties,
			TaskStatus? status,
			Set<String>? secretForeignKeys,
			Map<String, Set<Delegation>>? cryptedForeignKeys,
			Map<String, Set<Delegation>>? delegations,
			Map<String, Set<Delegation>>? encryptionKeys,
			Base64String? encryptedSelf,
			SecurityMetadata? securityMetadata
		}) : rev = rev ?? null,
		identifier = identifier ?? [],
		created = created ?? null,
		modified = modified ?? null,
		author = author ?? null,
		responsible = responsible ?? null,
		medicalLocationId = medicalLocationId ?? null,
		tags = tags ?? {},
		codes = codes ?? {},
		endOfLife = endOfLife ?? null,
		deletionDate = deletionDate ?? null,
		taskType = taskType ?? null,
		properties = properties ?? {},
		status = status ?? TaskStatus.pending,
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {},
		encryptedSelf = encryptedSelf ?? null,
		securityMetadata = securityMetadata ?? null;

	static Map<String, dynamic> encode(DecryptedMaintenanceTask value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"identifier" : value.identifier.map((x0) => Identifier.encode(x0)).toList(),
			"created" : value.created,
			"modified" : value.modified,
			"author" : value.author,
			"responsible" : value.responsible,
			"medicalLocationId" : value.medicalLocationId,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)).toList(),
			"endOfLife" : value.endOfLife,
			"deletionDate" : value.deletionDate,
			"taskType" : value.taskType,
			"properties" : value.properties.map((x0) => DecryptedPropertyStub.encode(x0)).toList(),
			"status" : TaskStatus.encode(value.status),
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0).toList(),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!)
		};
		return entityAsMap;
	}

	static DecryptedMaintenanceTask fromJSON(Map<String, dynamic> data) {
		return DecryptedMaintenanceTask(
			(data["id"] as String),
			rev: (data["rev"] as String?),
			identifier: (data["identifier"] as List<dynamic>).map((x0) => Identifier.fromJSON(x0) ).toList(),
			created: (data["created"] as int?),
			modified: (data["modified"] as int?),
			author: (data["author"] as String?),
			responsible: (data["responsible"] as String?),
			medicalLocationId: (data["medicalLocationId"] as String?),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			endOfLife: (data["endOfLife"] as int?),
			deletionDate: (data["deletionDate"] as int?),
			taskType: (data["taskType"] as String?),
			properties: (data["properties"] as List<dynamic>).map((x0) => DecryptedPropertyStub.fromJSON(x0) ).toSet(),
			status: TaskStatus.fromJSON(data["status"]),
			secretForeignKeys: (data["secretForeignKeys"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			cryptedForeignKeys: (data["cryptedForeignKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			delegations: (data["delegations"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptionKeys: (data["encryptionKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
		);
	}
}

class EncryptedMaintenanceTask implements MaintenanceTask {
	@override String id;
	@override String? rev = null;
	@override List<Identifier> identifier = [];
	@override int? created = null;
	@override int? modified = null;
	@override String? author = null;
	@override String? responsible = null;
	@override String? medicalLocationId = null;
	@override Set<CodeStub> tags = {};
	@override Set<CodeStub> codes = {};
	@override int? endOfLife = null;
	@override int? deletionDate = null;
	@override String? taskType = null;
	@override Set<EncryptedPropertyStub> properties = {};
	@override TaskStatus status = TaskStatus.pending;
	@override Set<String> secretForeignKeys = {};
	@override Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override Map<String, Set<Delegation>> delegations = {};
	@override Map<String, Set<Delegation>> encryptionKeys = {};
	@override Base64String? encryptedSelf = null;
	@override SecurityMetadata? securityMetadata = null;
	EncryptedMaintenanceTask(
		this.id,
		{
			String? rev,
			List<Identifier>? identifier,
			int? created,
			int? modified,
			String? author,
			String? responsible,
			String? medicalLocationId,
			Set<CodeStub>? tags,
			Set<CodeStub>? codes,
			int? endOfLife,
			int? deletionDate,
			String? taskType,
			Set<EncryptedPropertyStub>? properties,
			TaskStatus? status,
			Set<String>? secretForeignKeys,
			Map<String, Set<Delegation>>? cryptedForeignKeys,
			Map<String, Set<Delegation>>? delegations,
			Map<String, Set<Delegation>>? encryptionKeys,
			Base64String? encryptedSelf,
			SecurityMetadata? securityMetadata
		}) : rev = rev ?? null,
		identifier = identifier ?? [],
		created = created ?? null,
		modified = modified ?? null,
		author = author ?? null,
		responsible = responsible ?? null,
		medicalLocationId = medicalLocationId ?? null,
		tags = tags ?? {},
		codes = codes ?? {},
		endOfLife = endOfLife ?? null,
		deletionDate = deletionDate ?? null,
		taskType = taskType ?? null,
		properties = properties ?? {},
		status = status ?? TaskStatus.pending,
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {},
		encryptedSelf = encryptedSelf ?? null,
		securityMetadata = securityMetadata ?? null;

	static Map<String, dynamic> encode(EncryptedMaintenanceTask value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"identifier" : value.identifier.map((x0) => Identifier.encode(x0)).toList(),
			"created" : value.created,
			"modified" : value.modified,
			"author" : value.author,
			"responsible" : value.responsible,
			"medicalLocationId" : value.medicalLocationId,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)).toList(),
			"endOfLife" : value.endOfLife,
			"deletionDate" : value.deletionDate,
			"taskType" : value.taskType,
			"properties" : value.properties.map((x0) => EncryptedPropertyStub.encode(x0)).toList(),
			"status" : TaskStatus.encode(value.status),
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0).toList(),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!)
		};
		return entityAsMap;
	}

	static EncryptedMaintenanceTask fromJSON(Map<String, dynamic> data) {
		return EncryptedMaintenanceTask(
			(data["id"] as String),
			rev: (data["rev"] as String?),
			identifier: (data["identifier"] as List<dynamic>).map((x0) => Identifier.fromJSON(x0) ).toList(),
			created: (data["created"] as int?),
			modified: (data["modified"] as int?),
			author: (data["author"] as String?),
			responsible: (data["responsible"] as String?),
			medicalLocationId: (data["medicalLocationId"] as String?),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			endOfLife: (data["endOfLife"] as int?),
			deletionDate: (data["deletionDate"] as int?),
			taskType: (data["taskType"] as String?),
			properties: (data["properties"] as List<dynamic>).map((x0) => EncryptedPropertyStub.fromJSON(x0) ).toSet(),
			status: TaskStatus.fromJSON(data["status"]),
			secretForeignKeys: (data["secretForeignKeys"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			cryptedForeignKeys: (data["cryptedForeignKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			delegations: (data["delegations"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptionKeys: (data["encryptionKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
		);
	}
}