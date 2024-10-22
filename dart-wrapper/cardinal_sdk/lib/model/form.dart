// This file is auto-generated
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
	@ActualInt32("This property cannot contain a value exceeding 2147483647") abstract int? version;
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
	@override String? rev;
	@override int? created;
	@override int? modified;
	@override String? author;
	@override String? responsible;
	@override String? medicalLocationId;
	@override Set<CodeStub> tags = {};
	@override Set<CodeStub> codes = {};
	@override int? endOfLife;
	@override int? deletionDate;
	@override int? openingDate;
	@override String? status;
	int? _version;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get version => _version;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set version(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('version value cannot exceed 2147483647');
		}
		_version = value;
	}
	@override String? logicalUuid;
	@override String? descr;
	@override String? uniqueId;
	@override String? formTemplateId;
	@override String? contactId;
	@override String? healthElementId;
	@override String? planOfActionId;
	@override String? parent;
	@override Set<String> secretForeignKeys = {};
	@override Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override Map<String, Set<Delegation>> delegations = {};
	@override Map<String, Set<Delegation>> encryptionKeys = {};
	@override Base64String? encryptedSelf;
	@override SecurityMetadata? securityMetadata;
	EncryptedForm(
		this.id,
		{
			int? version,
			this.rev,
			this.created,
			this.modified,
			this.author,
			this.responsible,
			this.medicalLocationId,
			this.endOfLife,
			this.deletionDate,
			this.openingDate,
			this.status,
			this.logicalUuid,
			this.descr,
			this.uniqueId,
			this.formTemplateId,
			this.contactId,
			this.healthElementId,
			this.planOfActionId,
			this.parent,
			this.encryptedSelf,
			this.securityMetadata,
			Set<CodeStub>? tags,
			Set<CodeStub>? codes,
			Set<String>? secretForeignKeys,
			Map<String, Set<Delegation>>? cryptedForeignKeys,
			Map<String, Set<Delegation>>? delegations,
			Map<String, Set<Delegation>>? encryptionKeys
		}) : tags = tags ?? {},
		codes = codes ?? {},
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {},
		_version = version;

	factory EncryptedForm.fromJSON(Map<String, dynamic> data) {
		return EncryptedForm(
			data["id"],
			version: data["version"],
			rev: data["rev"],
			created: data["created"],
			modified: data["modified"],
			author: data["author"],
			responsible: data["responsible"],
			medicalLocationId: data["medicalLocationId"],
			tags: data["tags"].map((x0) => CodeStub.fromJSON(x0) ),
			codes: data["codes"].map((x0) => CodeStub.fromJSON(x0) ),
			endOfLife: data["endOfLife"],
			deletionDate: data["deletionDate"],
			openingDate: data["openingDate"],
			status: data["status"],
			logicalUuid: data["logicalUuid"],
			descr: data["descr"],
			uniqueId: data["uniqueId"],
			formTemplateId: data["formTemplateId"],
			contactId: data["contactId"],
			healthElementId: data["healthElementId"],
			planOfActionId: data["planOfActionId"],
			parent: data["parent"],
			secretForeignKeys: data["secretForeignKeys"].map((x0) => x0 ),
			cryptedForeignKeys: data["cryptedForeignKeys"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ))),
			delegations: data["delegations"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ))),
			encryptionKeys: data["encryptionKeys"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ))),
			encryptedSelf: data["encryptedSelf"],
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
		);
	}

	static Map<String, dynamic> encode(EncryptedForm value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"created" : value.created,
			"modified" : value.modified,
			"author" : value.author,
			"responsible" : value.responsible,
			"medicalLocationId" : value.medicalLocationId,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)),
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

class DecryptedForm implements Form {
	@override String id;
	@override String? rev;
	@override int? created;
	@override int? modified;
	@override String? author;
	@override String? responsible;
	@override String? medicalLocationId;
	@override Set<CodeStub> tags = {};
	@override Set<CodeStub> codes = {};
	@override int? endOfLife;
	@override int? deletionDate;
	@override int? openingDate;
	@override String? status;
	int? _version;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get version => _version;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set version(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('version value cannot exceed 2147483647');
		}
		_version = value;
	}
	@override String? logicalUuid;
	@override String? descr;
	@override String? uniqueId;
	@override String? formTemplateId;
	@override String? contactId;
	@override String? healthElementId;
	@override String? planOfActionId;
	@override String? parent;
	@override Set<String> secretForeignKeys = {};
	@override Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override Map<String, Set<Delegation>> delegations = {};
	@override Map<String, Set<Delegation>> encryptionKeys = {};
	@override Base64String? encryptedSelf;
	@override SecurityMetadata? securityMetadata;
	DecryptedForm(
		this.id,
		{
			int? version,
			this.rev,
			this.created,
			this.modified,
			this.author,
			this.responsible,
			this.medicalLocationId,
			this.endOfLife,
			this.deletionDate,
			this.openingDate,
			this.status,
			this.logicalUuid,
			this.descr,
			this.uniqueId,
			this.formTemplateId,
			this.contactId,
			this.healthElementId,
			this.planOfActionId,
			this.parent,
			this.encryptedSelf,
			this.securityMetadata,
			Set<CodeStub>? tags,
			Set<CodeStub>? codes,
			Set<String>? secretForeignKeys,
			Map<String, Set<Delegation>>? cryptedForeignKeys,
			Map<String, Set<Delegation>>? delegations,
			Map<String, Set<Delegation>>? encryptionKeys
		}) : tags = tags ?? {},
		codes = codes ?? {},
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {},
		_version = version;

	factory DecryptedForm.fromJSON(Map<String, dynamic> data) {
		return DecryptedForm(
			data["id"],
			version: data["version"],
			rev: data["rev"],
			created: data["created"],
			modified: data["modified"],
			author: data["author"],
			responsible: data["responsible"],
			medicalLocationId: data["medicalLocationId"],
			tags: data["tags"].map((x0) => CodeStub.fromJSON(x0) ),
			codes: data["codes"].map((x0) => CodeStub.fromJSON(x0) ),
			endOfLife: data["endOfLife"],
			deletionDate: data["deletionDate"],
			openingDate: data["openingDate"],
			status: data["status"],
			logicalUuid: data["logicalUuid"],
			descr: data["descr"],
			uniqueId: data["uniqueId"],
			formTemplateId: data["formTemplateId"],
			contactId: data["contactId"],
			healthElementId: data["healthElementId"],
			planOfActionId: data["planOfActionId"],
			parent: data["parent"],
			secretForeignKeys: data["secretForeignKeys"].map((x0) => x0 ),
			cryptedForeignKeys: data["cryptedForeignKeys"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ))),
			delegations: data["delegations"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ))),
			encryptionKeys: data["encryptionKeys"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ))),
			encryptedSelf: data["encryptedSelf"],
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
		);
	}

	static Map<String, dynamic> encode(DecryptedForm value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"created" : value.created,
			"modified" : value.modified,
			"author" : value.author,
			"responsible" : value.responsible,
			"medicalLocationId" : value.medicalLocationId,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)),
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