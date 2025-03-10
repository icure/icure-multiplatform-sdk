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


sealed class Topic implements StoredDocument, ICureDocument<String>, HasEncryptionMetadata, Encryptable {
	@override abstract String id;
	@override abstract String? rev;
	@override abstract int? created;
	@override abstract int? modified;
	abstract String? healthElementId;
	abstract String? contactId;
	abstract String? description;
	@override abstract Set<CodeStub> codes;
	@override abstract Set<CodeStub> tags;
	@override abstract String? author;
	@override abstract String? responsible;
	@override abstract String? medicalLocationId;
	@override abstract int? endOfLife;
	@override abstract int? deletionDate;
	abstract Map<String, TopicRole> activeParticipants;
	@override abstract SecurityMetadata? securityMetadata;
	@override abstract Set<String> secretForeignKeys;
	@override abstract Map<String, Set<Delegation>> cryptedForeignKeys;
	@override abstract Map<String, Set<Delegation>> delegations;
	@override abstract Map<String, Set<Delegation>> encryptionKeys;
	@override abstract Base64String? encryptedSelf;
	abstract Set<String> linkedHealthElements;
	abstract Set<String> linkedServices;

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

class DecryptedTopic implements Topic {
	@override String id;
	@override String? rev = null;
	@override int? created = null;
	@override int? modified = null;
	@override String? healthElementId = null;
	@override String? contactId = null;
	@override String? description = null;
	@override Set<CodeStub> codes = {};
	@override Set<CodeStub> tags = {};
	@override String? author = null;
	@override String? responsible = null;
	@override String? medicalLocationId = null;
	@override int? endOfLife = null;
	@override int? deletionDate = null;
	@override Map<String, TopicRole> activeParticipants = {};
	@override SecurityMetadata? securityMetadata = null;
	@override Set<String> secretForeignKeys = {};
	@override Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override Map<String, Set<Delegation>> delegations = {};
	@override Map<String, Set<Delegation>> encryptionKeys = {};
	@override Base64String? encryptedSelf = null;
	@override Set<String> linkedHealthElements = {};
	@override Set<String> linkedServices = {};
	DecryptedTopic(
		this.id,
		{
			String? rev,
			int? created,
			int? modified,
			String? healthElementId,
			String? contactId,
			String? description,
			Set<CodeStub>? codes,
			Set<CodeStub>? tags,
			String? author,
			String? responsible,
			String? medicalLocationId,
			int? endOfLife,
			int? deletionDate,
			Map<String, TopicRole>? activeParticipants,
			SecurityMetadata? securityMetadata,
			Set<String>? secretForeignKeys,
			Map<String, Set<Delegation>>? cryptedForeignKeys,
			Map<String, Set<Delegation>>? delegations,
			Map<String, Set<Delegation>>? encryptionKeys,
			Base64String? encryptedSelf,
			Set<String>? linkedHealthElements,
			Set<String>? linkedServices
		}) : rev = rev ?? null,
		created = created ?? null,
		modified = modified ?? null,
		healthElementId = healthElementId ?? null,
		contactId = contactId ?? null,
		description = description ?? null,
		codes = codes ?? {},
		tags = tags ?? {},
		author = author ?? null,
		responsible = responsible ?? null,
		medicalLocationId = medicalLocationId ?? null,
		endOfLife = endOfLife ?? null,
		deletionDate = deletionDate ?? null,
		activeParticipants = activeParticipants ?? {},
		securityMetadata = securityMetadata ?? null,
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {},
		encryptedSelf = encryptedSelf ?? null,
		linkedHealthElements = linkedHealthElements ?? {},
		linkedServices = linkedServices ?? {};

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
			(data["id"] as String),
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

class EncryptedTopic implements Topic {
	@override String id;
	@override String? rev = null;
	@override int? created = null;
	@override int? modified = null;
	@override String? healthElementId = null;
	@override String? contactId = null;
	@override String? description = null;
	@override Set<CodeStub> codes = {};
	@override Set<CodeStub> tags = {};
	@override String? author = null;
	@override String? responsible = null;
	@override String? medicalLocationId = null;
	@override int? endOfLife = null;
	@override int? deletionDate = null;
	@override Map<String, TopicRole> activeParticipants = {};
	@override SecurityMetadata? securityMetadata = null;
	@override Set<String> secretForeignKeys = {};
	@override Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override Map<String, Set<Delegation>> delegations = {};
	@override Map<String, Set<Delegation>> encryptionKeys = {};
	@override Base64String? encryptedSelf = null;
	@override Set<String> linkedHealthElements = {};
	@override Set<String> linkedServices = {};
	EncryptedTopic(
		this.id,
		{
			String? rev,
			int? created,
			int? modified,
			String? healthElementId,
			String? contactId,
			String? description,
			Set<CodeStub>? codes,
			Set<CodeStub>? tags,
			String? author,
			String? responsible,
			String? medicalLocationId,
			int? endOfLife,
			int? deletionDate,
			Map<String, TopicRole>? activeParticipants,
			SecurityMetadata? securityMetadata,
			Set<String>? secretForeignKeys,
			Map<String, Set<Delegation>>? cryptedForeignKeys,
			Map<String, Set<Delegation>>? delegations,
			Map<String, Set<Delegation>>? encryptionKeys,
			Base64String? encryptedSelf,
			Set<String>? linkedHealthElements,
			Set<String>? linkedServices
		}) : rev = rev ?? null,
		created = created ?? null,
		modified = modified ?? null,
		healthElementId = healthElementId ?? null,
		contactId = contactId ?? null,
		description = description ?? null,
		codes = codes ?? {},
		tags = tags ?? {},
		author = author ?? null,
		responsible = responsible ?? null,
		medicalLocationId = medicalLocationId ?? null,
		endOfLife = endOfLife ?? null,
		deletionDate = deletionDate ?? null,
		activeParticipants = activeParticipants ?? {},
		securityMetadata = securityMetadata ?? null,
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {},
		encryptedSelf = encryptedSelf ?? null,
		linkedHealthElements = linkedHealthElements ?? {},
		linkedServices = linkedServices ?? {};

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
			(data["id"] as String),
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