// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/annotations/actual_int32.dart';
import 'package:cardinal_sdk/model/embed/delegation.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/security_metadata.dart';
import 'package:cardinal_sdk/model/form.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/icure_document.dart';
import 'package:cardinal_sdk/model/base/has_encryption_metadata.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';


sealed class Form implements StoredDocument, ICureDocument<String>, HasEncryptionMetadata, Encryptable {
	@override abstract String id;
	@override abstract String? rev;
	@override abstract int? created;
	@override abstract int? modified;
	@override abstract String? author;
	@override abstract String? responsible;
	@override abstract String? medicalLocationId;
	@override abstract Set<CodeStub> tags;
	@override abstract Set<CodeStub> codes;
	@override abstract int? endOfLife;
	@override abstract int? deletionDate;
	abstract int? openingDate;
	abstract String? status;
	@ActualInt32() abstract int? version;
	abstract String? logicalUuid;
	abstract String? descr;
	abstract String? uniqueId;
	abstract String? formTemplateId;
	abstract String? contactId;
	abstract String? healthElementId;
	abstract String? planOfActionId;
	abstract String? parent;
	@override abstract Set<String> secretForeignKeys;
	@override abstract Map<String, Set<Delegation>> cryptedForeignKeys;
	@override abstract Map<String, Set<Delegation>> delegations;
	@override abstract Map<String, Set<Delegation>> encryptionKeys;
	@override abstract Base64String? encryptedSelf;
	@override abstract SecurityMetadata? securityMetadata;

	static Map<String, dynamic> encode(Form value) {
		switch (value) {
			case EncryptedForm entity:
				Map<String, dynamic> entityJson = EncryptedForm.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.EncryptedForm";
				return entityJson;
			case DecryptedForm entity:
				Map<String, dynamic> entityJson = DecryptedForm.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DecryptedForm";
				return entityJson;
		}
	}

	static Form fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.EncryptedForm":
				return EncryptedForm.fromJSON(data);
			case "com.icure.cardinal.sdk.model.DecryptedForm":
				return DecryptedForm.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

class EncryptedForm implements Form {
	@override String id;
	@override String? rev = null;
	@override int? created = null;
	@override int? modified = null;
	@override String? author = null;
	@override String? responsible = null;
	@override String? medicalLocationId = null;
	@override Set<CodeStub> tags = {};
	@override Set<CodeStub> codes = {};
	@override int? endOfLife = null;
	@override int? deletionDate = null;
	@override int? openingDate = null;
	@override String? status = null;
	int? _version = null;
	@ActualInt32() @override int? get version => _version;
	@ActualInt32() @override set version(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('version value cannot exceed 2147483647');
		}
		_version = value;
	}
	@override String? logicalUuid = null;
	@override String? descr = null;
	@override String? uniqueId = null;
	@override String? formTemplateId = null;
	@override String? contactId = null;
	@override String? healthElementId = null;
	@override String? planOfActionId = null;
	@override String? parent = null;
	@override Set<String> secretForeignKeys = {};
	@override Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override Map<String, Set<Delegation>> delegations = {};
	@override Map<String, Set<Delegation>> encryptionKeys = {};
	@override Base64String? encryptedSelf = null;
	@override SecurityMetadata? securityMetadata = null;
	EncryptedForm(
		this.id,
		{
			int? version,
			String? rev,
			int? created,
			int? modified,
			String? author,
			String? responsible,
			String? medicalLocationId,
			Set<CodeStub>? tags,
			Set<CodeStub>? codes,
			int? endOfLife,
			int? deletionDate,
			int? openingDate,
			String? status,
			String? logicalUuid,
			String? descr,
			String? uniqueId,
			String? formTemplateId,
			String? contactId,
			String? healthElementId,
			String? planOfActionId,
			String? parent,
			Set<String>? secretForeignKeys,
			Map<String, Set<Delegation>>? cryptedForeignKeys,
			Map<String, Set<Delegation>>? delegations,
			Map<String, Set<Delegation>>? encryptionKeys,
			Base64String? encryptedSelf,
			SecurityMetadata? securityMetadata
		}) : rev = rev ?? null,
		created = created ?? null,
		modified = modified ?? null,
		author = author ?? null,
		responsible = responsible ?? null,
		medicalLocationId = medicalLocationId ?? null,
		tags = tags ?? {},
		codes = codes ?? {},
		endOfLife = endOfLife ?? null,
		deletionDate = deletionDate ?? null,
		openingDate = openingDate ?? null,
		status = status ?? null,
		logicalUuid = logicalUuid ?? null,
		descr = descr ?? null,
		uniqueId = uniqueId ?? null,
		formTemplateId = formTemplateId ?? null,
		contactId = contactId ?? null,
		healthElementId = healthElementId ?? null,
		planOfActionId = planOfActionId ?? null,
		parent = parent ?? null,
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {},
		encryptedSelf = encryptedSelf ?? null,
		securityMetadata = securityMetadata ?? null,
		_version = version ?? null;

	static Map<String, dynamic> encode(EncryptedForm value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"created" : value.created,
			"modified" : value.modified,
			"author" : value.author,
			"responsible" : value.responsible,
			"medicalLocationId" : value.medicalLocationId,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)).toList(),
			"endOfLife" : value.endOfLife,
			"deletionDate" : value.deletionDate,
			"openingDate" : value.openingDate,
			"status" : value.status,
			"version" : value.version,
			"logicalUuid" : value.logicalUuid,
			"descr" : value.descr,
			"uniqueId" : value.uniqueId,
			"formTemplateId" : value.formTemplateId,
			"contactId" : value.contactId,
			"healthElementId" : value.healthElementId,
			"planOfActionId" : value.planOfActionId,
			"parent" : value.parent,
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0).toList(),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!)
		};
		return entityAsMap;
	}

	static EncryptedForm fromJSON(Map<String, dynamic> data) {
		return EncryptedForm(
			(data["id"] as String),
			version: (data["version"] as int?),
			rev: (data["rev"] as String?),
			created: (data["created"] as int?),
			modified: (data["modified"] as int?),
			author: (data["author"] as String?),
			responsible: (data["responsible"] as String?),
			medicalLocationId: (data["medicalLocationId"] as String?),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			endOfLife: (data["endOfLife"] as int?),
			deletionDate: (data["deletionDate"] as int?),
			openingDate: (data["openingDate"] as int?),
			status: (data["status"] as String?),
			logicalUuid: (data["logicalUuid"] as String?),
			descr: (data["descr"] as String?),
			uniqueId: (data["uniqueId"] as String?),
			formTemplateId: (data["formTemplateId"] as String?),
			contactId: (data["contactId"] as String?),
			healthElementId: (data["healthElementId"] as String?),
			planOfActionId: (data["planOfActionId"] as String?),
			parent: (data["parent"] as String?),
			secretForeignKeys: (data["secretForeignKeys"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			cryptedForeignKeys: (data["cryptedForeignKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			delegations: (data["delegations"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptionKeys: (data["encryptionKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
		);
	}
}

class DecryptedForm implements Form {
	@override String id;
	@override String? rev = null;
	@override int? created = null;
	@override int? modified = null;
	@override String? author = null;
	@override String? responsible = null;
	@override String? medicalLocationId = null;
	@override Set<CodeStub> tags = {};
	@override Set<CodeStub> codes = {};
	@override int? endOfLife = null;
	@override int? deletionDate = null;
	@override int? openingDate = null;
	@override String? status = null;
	int? _version = null;
	@ActualInt32() @override int? get version => _version;
	@ActualInt32() @override set version(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('version value cannot exceed 2147483647');
		}
		_version = value;
	}
	@override String? logicalUuid = null;
	@override String? descr = null;
	@override String? uniqueId = null;
	@override String? formTemplateId = null;
	@override String? contactId = null;
	@override String? healthElementId = null;
	@override String? planOfActionId = null;
	@override String? parent = null;
	@override Set<String> secretForeignKeys = {};
	@override Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override Map<String, Set<Delegation>> delegations = {};
	@override Map<String, Set<Delegation>> encryptionKeys = {};
	@override Base64String? encryptedSelf = null;
	@override SecurityMetadata? securityMetadata = null;
	DecryptedForm(
		this.id,
		{
			int? version,
			String? rev,
			int? created,
			int? modified,
			String? author,
			String? responsible,
			String? medicalLocationId,
			Set<CodeStub>? tags,
			Set<CodeStub>? codes,
			int? endOfLife,
			int? deletionDate,
			int? openingDate,
			String? status,
			String? logicalUuid,
			String? descr,
			String? uniqueId,
			String? formTemplateId,
			String? contactId,
			String? healthElementId,
			String? planOfActionId,
			String? parent,
			Set<String>? secretForeignKeys,
			Map<String, Set<Delegation>>? cryptedForeignKeys,
			Map<String, Set<Delegation>>? delegations,
			Map<String, Set<Delegation>>? encryptionKeys,
			Base64String? encryptedSelf,
			SecurityMetadata? securityMetadata
		}) : rev = rev ?? null,
		created = created ?? null,
		modified = modified ?? null,
		author = author ?? null,
		responsible = responsible ?? null,
		medicalLocationId = medicalLocationId ?? null,
		tags = tags ?? {},
		codes = codes ?? {},
		endOfLife = endOfLife ?? null,
		deletionDate = deletionDate ?? null,
		openingDate = openingDate ?? null,
		status = status ?? null,
		logicalUuid = logicalUuid ?? null,
		descr = descr ?? null,
		uniqueId = uniqueId ?? null,
		formTemplateId = formTemplateId ?? null,
		contactId = contactId ?? null,
		healthElementId = healthElementId ?? null,
		planOfActionId = planOfActionId ?? null,
		parent = parent ?? null,
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {},
		encryptedSelf = encryptedSelf ?? null,
		securityMetadata = securityMetadata ?? null,
		_version = version ?? null;

	static Map<String, dynamic> encode(DecryptedForm value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"created" : value.created,
			"modified" : value.modified,
			"author" : value.author,
			"responsible" : value.responsible,
			"medicalLocationId" : value.medicalLocationId,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)).toList(),
			"endOfLife" : value.endOfLife,
			"deletionDate" : value.deletionDate,
			"openingDate" : value.openingDate,
			"status" : value.status,
			"version" : value.version,
			"logicalUuid" : value.logicalUuid,
			"descr" : value.descr,
			"uniqueId" : value.uniqueId,
			"formTemplateId" : value.formTemplateId,
			"contactId" : value.contactId,
			"healthElementId" : value.healthElementId,
			"planOfActionId" : value.planOfActionId,
			"parent" : value.parent,
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0).toList(),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!)
		};
		return entityAsMap;
	}

	static DecryptedForm fromJSON(Map<String, dynamic> data) {
		return DecryptedForm(
			(data["id"] as String),
			version: (data["version"] as int?),
			rev: (data["rev"] as String?),
			created: (data["created"] as int?),
			modified: (data["modified"] as int?),
			author: (data["author"] as String?),
			responsible: (data["responsible"] as String?),
			medicalLocationId: (data["medicalLocationId"] as String?),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			endOfLife: (data["endOfLife"] as int?),
			deletionDate: (data["deletionDate"] as int?),
			openingDate: (data["openingDate"] as int?),
			status: (data["status"] as String?),
			logicalUuid: (data["logicalUuid"] as String?),
			descr: (data["descr"] as String?),
			uniqueId: (data["uniqueId"] as String?),
			formTemplateId: (data["formTemplateId"] as String?),
			contactId: (data["contactId"] as String?),
			healthElementId: (data["healthElementId"] as String?),
			planOfActionId: (data["planOfActionId"] as String?),
			parent: (data["parent"] as String?),
			secretForeignKeys: (data["secretForeignKeys"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			cryptedForeignKeys: (data["cryptedForeignKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			delegations: (data["delegations"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptionKeys: (data["encryptionKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
		);
	}
}