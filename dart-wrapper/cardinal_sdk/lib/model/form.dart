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
import 'package:freezed_annotation/freezed_annotation.dart';
part "form.freezed.dart";


sealed class Form implements StoredDocument, ICureDocument<String>, HasEncryptionMetadata, Encryptable {
	@override abstract final String id;
	@override abstract final String? rev;
	@override abstract final int? created;
	@override abstract final int? modified;
	@override abstract final String? author;
	@override abstract final String? responsible;
	@override abstract final String? medicalLocationId;
	@override abstract final Set<CodeStub> tags;
	@override abstract final Set<CodeStub> codes;
	@override abstract final int? endOfLife;
	@override abstract final int? deletionDate;
	abstract final int? openingDate;
	abstract final String? status;
	@actualInt32 abstract final int? version;
	abstract final String? logicalUuid;
	abstract final String? descr;
	abstract final String? uniqueId;
	abstract final String? formTemplateId;
	abstract final String? contactId;
	abstract final String? healthElementId;
	abstract final String? planOfActionId;
	abstract final String? parent;
	abstract final String? anchorId;
	@override abstract final Set<String> secretForeignKeys;
	@override abstract final Map<String, Set<Delegation>> cryptedForeignKeys;
	@override abstract final Map<String, Set<Delegation>> delegations;
	@override abstract final Map<String, Set<Delegation>> encryptionKeys;
	@override abstract final Base64String? encryptedSelf;
	@override abstract final SecurityMetadata? securityMetadata;

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

@freezed
abstract class EncryptedForm with _$EncryptedForm implements Form {
	const factory EncryptedForm({
		required String id,
		@Default(null) String? rev,
		@Default(null) int? created,
		@Default(null) int? modified,
		@Default(null) String? author,
		@Default(null) String? responsible,
		@Default(null) String? medicalLocationId,
		@Default({}) Set<CodeStub> tags,
		@Default({}) Set<CodeStub> codes,
		@Default(null) int? endOfLife,
		@Default(null) int? deletionDate,
		@Default(null) int? openingDate,
		@Default(null) String? status,
		@Default(null) int? version,
		@Default(null) String? logicalUuid,
		@Default(null) String? descr,
		@Default(null) String? uniqueId,
		@Default(null) String? formTemplateId,
		@Default(null) String? contactId,
		@Default(null) String? healthElementId,
		@Default(null) String? planOfActionId,
		@Default(null) String? parent,
		@Default(null) String? anchorId,
		@Default({}) Set<String> secretForeignKeys,
		@Default({}) Map<String, Set<Delegation>> cryptedForeignKeys,
		@Default({}) Map<String, Set<Delegation>> delegations,
		@Default({}) Map<String, Set<Delegation>> encryptionKeys,
		@Default(null) Base64String? encryptedSelf,
		@Default(null) SecurityMetadata? securityMetadata,
	}) = _EncryptedForm;


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
			"anchorId" : value.anchorId,
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
			id: (data["id"] as String),
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
			anchorId: (data["anchorId"] as String?),
			secretForeignKeys: (data["secretForeignKeys"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			cryptedForeignKeys: (data["cryptedForeignKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			delegations: (data["delegations"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptionKeys: (data["encryptionKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
		);
	}
}

@freezed
abstract class DecryptedForm with _$DecryptedForm implements Form {
	const factory DecryptedForm({
		required String id,
		@Default(null) String? rev,
		@Default(null) int? created,
		@Default(null) int? modified,
		@Default(null) String? author,
		@Default(null) String? responsible,
		@Default(null) String? medicalLocationId,
		@Default({}) Set<CodeStub> tags,
		@Default({}) Set<CodeStub> codes,
		@Default(null) int? endOfLife,
		@Default(null) int? deletionDate,
		@Default(null) int? openingDate,
		@Default(null) String? status,
		@Default(null) int? version,
		@Default(null) String? logicalUuid,
		@Default(null) String? descr,
		@Default(null) String? uniqueId,
		@Default(null) String? formTemplateId,
		@Default(null) String? contactId,
		@Default(null) String? healthElementId,
		@Default(null) String? planOfActionId,
		@Default(null) String? parent,
		@Default(null) String? anchorId,
		@Default({}) Set<String> secretForeignKeys,
		@Default({}) Map<String, Set<Delegation>> cryptedForeignKeys,
		@Default({}) Map<String, Set<Delegation>> delegations,
		@Default({}) Map<String, Set<Delegation>> encryptionKeys,
		@Default(null) Base64String? encryptedSelf,
		@Default(null) SecurityMetadata? securityMetadata,
	}) = _DecryptedForm;


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
			"anchorId" : value.anchorId,
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
			id: (data["id"] as String),
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
			anchorId: (data["anchorId"] as String?),
			secretForeignKeys: (data["secretForeignKeys"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			cryptedForeignKeys: (data["cryptedForeignKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			delegations: (data["delegations"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptionKeys: (data["encryptionKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
		);
	}
}