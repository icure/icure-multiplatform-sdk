// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/embed/delegation.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/security_metadata.dart';
import 'package:cardinal_sdk/model/access_log.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/icure_document.dart';
import 'package:cardinal_sdk/model/base/has_encryption_metadata.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';


sealed class AccessLog implements StoredDocument, ICureDocument<String>, HasEncryptionMetadata, Encryptable {
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
	abstract String? objectId;
	abstract String? accessType;
	abstract String? user;
	abstract String? detail;
	abstract DateTime? date;
	abstract String? patientId;
	@override abstract Set<String> secretForeignKeys;
	@override abstract Map<String, Set<Delegation>> cryptedForeignKeys;
	@override abstract Map<String, Set<Delegation>> delegations;
	@override abstract Map<String, Set<Delegation>> encryptionKeys;
	@override abstract Base64String? encryptedSelf;
	@override abstract SecurityMetadata? securityMetadata;

	static Map<String, dynamic> encode(AccessLog value) {
		switch (value) {
			case DecryptedAccessLog entity:
				Map<String, dynamic> entityJson = DecryptedAccessLog.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DecryptedAccessLog";
				return entityJson;
			case EncryptedAccessLog entity:
				Map<String, dynamic> entityJson = EncryptedAccessLog.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.EncryptedAccessLog";
				return entityJson;
		}
	}

	static AccessLog fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.DecryptedAccessLog":
				return DecryptedAccessLog.fromJSON(data);
			case "com.icure.cardinal.sdk.model.EncryptedAccessLog":
				return EncryptedAccessLog.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

class DecryptedAccessLog implements AccessLog {
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
	@override String? objectId;
	@override String? accessType;
	@override String? user;
	@override String? detail;
	@override DateTime? date;
	@override String? patientId;
	@override Set<String> secretForeignKeys = {};
	@override Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override Map<String, Set<Delegation>> delegations = {};
	@override Map<String, Set<Delegation>> encryptionKeys = {};
	@override Base64String? encryptedSelf;
	@override SecurityMetadata? securityMetadata;
	DecryptedAccessLog(
		this.id,
		{
			this.rev,
			this.created,
			this.modified,
			this.author,
			this.responsible,
			this.medicalLocationId,
			this.endOfLife,
			this.deletionDate,
			this.objectId,
			this.accessType,
			this.user,
			this.detail,
			this.date,
			this.patientId,
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
		encryptionKeys = encryptionKeys ?? {};

	factory DecryptedAccessLog.fromJSON(Map<String, dynamic> data) {
		return DecryptedAccessLog(
			data["id"],
			rev: data["rev"],
			created: data["created"],
			modified: data["modified"],
			author: data["author"],
			responsible: data["responsible"],
			medicalLocationId: data["medicalLocationId"],
			tags: data["tags"].map((x0) => CodeStub.fromJSON(x0) ).toList(),
			codes: data["codes"].map((x0) => CodeStub.fromJSON(x0) ).toList(),
			endOfLife: data["endOfLife"],
			deletionDate: data["deletionDate"],
			objectId: data["objectId"],
			accessType: data["accessType"],
			user: data["user"],
			detail: data["detail"],
			date: data["date"] == null ? null : DateTime.parse(data["date"] as String),
			patientId: data["patientId"],
			secretForeignKeys: data["secretForeignKeys"].map((x0) => x0 ).toList(),
			cryptedForeignKeys: data["cryptedForeignKeys"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ).toList())),
			delegations: data["delegations"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ).toList())),
			encryptionKeys: data["encryptionKeys"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ).toList())),
			encryptedSelf: data["encryptedSelf"],
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
		);
	}

	static Map<String, dynamic> encode(DecryptedAccessLog value) {
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
			"objectId" : value.objectId,
			"accessType" : value.accessType,
			"user" : value.user,
			"detail" : value.detail,
			"date" : value.date?.toIso8601String(),
			"patientId" : value.patientId,
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0).toList(),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!)
		};
		return entityAsMap;
	}
}

class EncryptedAccessLog implements AccessLog {
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
	@override String? objectId;
	@override String? accessType;
	@override String? user;
	@override String? detail;
	@override DateTime? date;
	@override String? patientId;
	@override Set<String> secretForeignKeys = {};
	@override Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override Map<String, Set<Delegation>> delegations = {};
	@override Map<String, Set<Delegation>> encryptionKeys = {};
	@override Base64String? encryptedSelf;
	@override SecurityMetadata? securityMetadata;
	EncryptedAccessLog(
		this.id,
		{
			this.rev,
			this.created,
			this.modified,
			this.author,
			this.responsible,
			this.medicalLocationId,
			this.endOfLife,
			this.deletionDate,
			this.objectId,
			this.accessType,
			this.user,
			this.detail,
			this.date,
			this.patientId,
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
		encryptionKeys = encryptionKeys ?? {};

	factory EncryptedAccessLog.fromJSON(Map<String, dynamic> data) {
		return EncryptedAccessLog(
			data["id"],
			rev: data["rev"],
			created: data["created"],
			modified: data["modified"],
			author: data["author"],
			responsible: data["responsible"],
			medicalLocationId: data["medicalLocationId"],
			tags: data["tags"].map((x0) => CodeStub.fromJSON(x0) ).toList(),
			codes: data["codes"].map((x0) => CodeStub.fromJSON(x0) ).toList(),
			endOfLife: data["endOfLife"],
			deletionDate: data["deletionDate"],
			objectId: data["objectId"],
			accessType: data["accessType"],
			user: data["user"],
			detail: data["detail"],
			date: data["date"] == null ? null : DateTime.parse(data["date"] as String),
			patientId: data["patientId"],
			secretForeignKeys: data["secretForeignKeys"].map((x0) => x0 ).toList(),
			cryptedForeignKeys: data["cryptedForeignKeys"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ).toList())),
			delegations: data["delegations"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ).toList())),
			encryptionKeys: data["encryptionKeys"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ).toList())),
			encryptedSelf: data["encryptedSelf"],
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
		);
	}

	static Map<String, dynamic> encode(EncryptedAccessLog value) {
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
			"objectId" : value.objectId,
			"accessType" : value.accessType,
			"user" : value.user,
			"detail" : value.detail,
			"date" : value.date?.toIso8601String(),
			"patientId" : value.patientId,
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0).toList(),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!)
		};
		return entityAsMap;
	}
}