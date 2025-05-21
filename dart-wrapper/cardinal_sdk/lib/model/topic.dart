// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/topic_role.dart';
import 'package:cardinal_sdk/model/embed/security_metadata.dart';
import 'package:cardinal_sdk/model/embed/delegation.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/topic.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/icure_document.dart';
import 'package:cardinal_sdk/model/base/has_encryption_metadata.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "topic.freezed.dart";


sealed class Topic implements StoredDocument, ICureDocument<String>, HasEncryptionMetadata, Encryptable {
	@override abstract final String id;
	@override abstract final String? rev;
	@override abstract final int? created;
	@override abstract final int? modified;
	abstract final String? healthElementId;
	abstract final String? contactId;
	abstract final String? description;
	@override abstract final Set<CodeStub> codes;
	@override abstract final Set<CodeStub> tags;
	@override abstract final String? author;
	@override abstract final String? responsible;
	@override abstract final String? medicalLocationId;
	@override abstract final int? endOfLife;
	@override abstract final int? deletionDate;
	abstract final Map<String, TopicRole> activeParticipants;
	@override abstract final SecurityMetadata? securityMetadata;
	@override abstract final Set<String> secretForeignKeys;
	@override abstract final Map<String, Set<Delegation>> cryptedForeignKeys;
	@override abstract final Map<String, Set<Delegation>> delegations;
	@override abstract final Map<String, Set<Delegation>> encryptionKeys;
	@override abstract final Base64String? encryptedSelf;
	abstract final Set<String> linkedHealthElements;
	abstract final Set<String> linkedServices;

	static Map<String, dynamic> encode(Topic value) {
		switch (value) {
			case DecryptedTopic entity:
				Map<String, dynamic> entityJson = DecryptedTopic.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DecryptedTopic";
				return entityJson;
			case EncryptedTopic entity:
				Map<String, dynamic> entityJson = EncryptedTopic.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.EncryptedTopic";
				return entityJson;
		}
	}

	static Topic fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.DecryptedTopic":
				return DecryptedTopic.fromJSON(data);
			case "com.icure.cardinal.sdk.model.EncryptedTopic":
				return EncryptedTopic.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

@freezed
abstract class DecryptedTopic with _$DecryptedTopic implements Topic {
	const factory DecryptedTopic({
		required String id,
		@Default(null) String? rev,
		@Default(null) int? created,
		@Default(null) int? modified,
		@Default(null) String? healthElementId,
		@Default(null) String? contactId,
		@Default(null) String? description,
		@Default({}) Set<CodeStub> codes,
		@Default({}) Set<CodeStub> tags,
		@Default(null) String? author,
		@Default(null) String? responsible,
		@Default(null) String? medicalLocationId,
		@Default(null) int? endOfLife,
		@Default(null) int? deletionDate,
		@Default({}) Map<String, TopicRole> activeParticipants,
		@Default(null) SecurityMetadata? securityMetadata,
		@Default({}) Set<String> secretForeignKeys,
		@Default({}) Map<String, Set<Delegation>> cryptedForeignKeys,
		@Default({}) Map<String, Set<Delegation>> delegations,
		@Default({}) Map<String, Set<Delegation>> encryptionKeys,
		@Default(null) Base64String? encryptedSelf,
		@Default({}) Set<String> linkedHealthElements,
		@Default({}) Set<String> linkedServices,
	}) = _DecryptedTopic;


	static Map<String, dynamic> encode(DecryptedTopic value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"created" : value.created,
			"modified" : value.modified,
			"healthElementId" : value.healthElementId,
			"contactId" : value.contactId,
			"description" : value.description,
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)).toList(),
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"author" : value.author,
			"responsible" : value.responsible,
			"medicalLocationId" : value.medicalLocationId,
			"endOfLife" : value.endOfLife,
			"deletionDate" : value.deletionDate,
			"activeParticipants" : value.activeParticipants.map((k0, v0) => MapEntry(k0, TopicRole.encode(v0))),
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!),
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0).toList(),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptedSelf" : value.encryptedSelf,
			"linkedHealthElements" : value.linkedHealthElements.map((x0) => x0).toList(),
			"linkedServices" : value.linkedServices.map((x0) => x0).toList()
		};
		return entityAsMap;
	}

	static DecryptedTopic fromJSON(Map<String, dynamic> data) {
		return DecryptedTopic(
			id: (data["id"] as String),
			rev: (data["rev"] as String?),
			created: (data["created"] as int?),
			modified: (data["modified"] as int?),
			healthElementId: (data["healthElementId"] as String?),
			contactId: (data["contactId"] as String?),
			description: (data["description"] as String?),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			author: (data["author"] as String?),
			responsible: (data["responsible"] as String?),
			medicalLocationId: (data["medicalLocationId"] as String?),
			endOfLife: (data["endOfLife"] as int?),
			deletionDate: (data["deletionDate"] as int?),
			activeParticipants: (data["activeParticipants"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), TopicRole.fromJSON(v0))),
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
			secretForeignKeys: (data["secretForeignKeys"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			cryptedForeignKeys: (data["cryptedForeignKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			delegations: (data["delegations"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptionKeys: (data["encryptionKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
			linkedHealthElements: (data["linkedHealthElements"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			linkedServices: (data["linkedServices"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
		);
	}
}

@freezed
abstract class EncryptedTopic with _$EncryptedTopic implements Topic {
	const factory EncryptedTopic({
		required String id,
		@Default(null) String? rev,
		@Default(null) int? created,
		@Default(null) int? modified,
		@Default(null) String? healthElementId,
		@Default(null) String? contactId,
		@Default(null) String? description,
		@Default({}) Set<CodeStub> codes,
		@Default({}) Set<CodeStub> tags,
		@Default(null) String? author,
		@Default(null) String? responsible,
		@Default(null) String? medicalLocationId,
		@Default(null) int? endOfLife,
		@Default(null) int? deletionDate,
		@Default({}) Map<String, TopicRole> activeParticipants,
		@Default(null) SecurityMetadata? securityMetadata,
		@Default({}) Set<String> secretForeignKeys,
		@Default({}) Map<String, Set<Delegation>> cryptedForeignKeys,
		@Default({}) Map<String, Set<Delegation>> delegations,
		@Default({}) Map<String, Set<Delegation>> encryptionKeys,
		@Default(null) Base64String? encryptedSelf,
		@Default({}) Set<String> linkedHealthElements,
		@Default({}) Set<String> linkedServices,
	}) = _EncryptedTopic;


	static Map<String, dynamic> encode(EncryptedTopic value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"created" : value.created,
			"modified" : value.modified,
			"healthElementId" : value.healthElementId,
			"contactId" : value.contactId,
			"description" : value.description,
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)).toList(),
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"author" : value.author,
			"responsible" : value.responsible,
			"medicalLocationId" : value.medicalLocationId,
			"endOfLife" : value.endOfLife,
			"deletionDate" : value.deletionDate,
			"activeParticipants" : value.activeParticipants.map((k0, v0) => MapEntry(k0, TopicRole.encode(v0))),
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!),
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0).toList(),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptedSelf" : value.encryptedSelf,
			"linkedHealthElements" : value.linkedHealthElements.map((x0) => x0).toList(),
			"linkedServices" : value.linkedServices.map((x0) => x0).toList()
		};
		return entityAsMap;
	}

	static EncryptedTopic fromJSON(Map<String, dynamic> data) {
		return EncryptedTopic(
			id: (data["id"] as String),
			rev: (data["rev"] as String?),
			created: (data["created"] as int?),
			modified: (data["modified"] as int?),
			healthElementId: (data["healthElementId"] as String?),
			contactId: (data["contactId"] as String?),
			description: (data["description"] as String?),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			author: (data["author"] as String?),
			responsible: (data["responsible"] as String?),
			medicalLocationId: (data["medicalLocationId"] as String?),
			endOfLife: (data["endOfLife"] as int?),
			deletionDate: (data["deletionDate"] as int?),
			activeParticipants: (data["activeParticipants"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), TopicRole.fromJSON(v0))),
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
			secretForeignKeys: (data["secretForeignKeys"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			cryptedForeignKeys: (data["cryptedForeignKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			delegations: (data["delegations"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptionKeys: (data["encryptionKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
			linkedHealthElements: (data["linkedHealthElements"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			linkedServices: (data["linkedServices"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
		);
	}
}