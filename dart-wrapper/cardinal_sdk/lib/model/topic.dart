// This file is auto-generated
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
}

class DecryptedTopic implements Topic {
	@override  String id;
	@override  String? rev;
	@override  int? created;
	@override  int? modified;
	@override  String? healthElementId;
	@override  String? contactId;
	@override  String? description;
	@override  Set<CodeStub> codes = {};
	@override  Set<CodeStub> tags = {};
	@override  String? author;
	@override  String? responsible;
	@override  String? medicalLocationId;
	@override  int? endOfLife;
	@override  int? deletionDate;
	@override  Map<String, TopicRole> activeParticipants = {};
	@override  SecurityMetadata? securityMetadata;
	@override  Set<String> secretForeignKeys = {};
	@override  Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override  Map<String, Set<Delegation>> delegations = {};
	@override  Map<String, Set<Delegation>> encryptionKeys = {};
	@override  Base64String? encryptedSelf;
	@override  Set<String> linkedHealthElements = {};
	@override  Set<String> linkedServices = {};

	DecryptedTopic({
		required this.id,
		this.rev,
		this.created,
		this.modified,
		this.healthElementId,
		this.contactId,
		this.description,
		this.author,
		this.responsible,
		this.medicalLocationId,
		this.endOfLife,
		this.deletionDate,
		this.securityMetadata,
		this.encryptedSelf,
		Set<CodeStub>? codes,
		Set<CodeStub>? tags,
		Map<String, TopicRole>? activeParticipants,
		Set<String>? secretForeignKeys,
		Map<String, Set<Delegation>>? cryptedForeignKeys,
		Map<String, Set<Delegation>>? delegations,
		Map<String, Set<Delegation>>? encryptionKeys,
		Set<String>? linkedHealthElements,
		Set<String>? linkedServices
	}) : codes = codes ?? {},
		tags = tags ?? {},
		activeParticipants = activeParticipants ?? {},
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {},
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
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)),
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)),
			"author" : value.author,
			"responsible" : value.responsible,
			"medicalLocationId" : value.medicalLocationId,
			"endOfLife" : value.endOfLife,
			"deletionDate" : value.deletionDate,
			"activeParticipants" : value.activeParticipants.map((k0, v0) => MapEntry(k0, TopicRole.encode(v0))),
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!),
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"encryptedSelf" : value.encryptedSelf,
			"linkedHealthElements" : value.linkedHealthElements.map((x0) => x0),
			"linkedServices" : value.linkedServices.map((x0) => x0)
		};
		return entityAsMap;
	}
}

class EncryptedTopic implements Topic {
	@override  String id;
	@override  String? rev;
	@override  int? created;
	@override  int? modified;
	@override  String? healthElementId;
	@override  String? contactId;
	@override  String? description;
	@override  Set<CodeStub> codes = {};
	@override  Set<CodeStub> tags = {};
	@override  String? author;
	@override  String? responsible;
	@override  String? medicalLocationId;
	@override  int? endOfLife;
	@override  int? deletionDate;
	@override  Map<String, TopicRole> activeParticipants = {};
	@override  SecurityMetadata? securityMetadata;
	@override  Set<String> secretForeignKeys = {};
	@override  Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override  Map<String, Set<Delegation>> delegations = {};
	@override  Map<String, Set<Delegation>> encryptionKeys = {};
	@override  Base64String? encryptedSelf;
	@override  Set<String> linkedHealthElements = {};
	@override  Set<String> linkedServices = {};

	EncryptedTopic({
		required this.id,
		this.rev,
		this.created,
		this.modified,
		this.healthElementId,
		this.contactId,
		this.description,
		this.author,
		this.responsible,
		this.medicalLocationId,
		this.endOfLife,
		this.deletionDate,
		this.securityMetadata,
		this.encryptedSelf,
		Set<CodeStub>? codes,
		Set<CodeStub>? tags,
		Map<String, TopicRole>? activeParticipants,
		Set<String>? secretForeignKeys,
		Map<String, Set<Delegation>>? cryptedForeignKeys,
		Map<String, Set<Delegation>>? delegations,
		Map<String, Set<Delegation>>? encryptionKeys,
		Set<String>? linkedHealthElements,
		Set<String>? linkedServices
	}) : codes = codes ?? {},
		tags = tags ?? {},
		activeParticipants = activeParticipants ?? {},
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {},
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
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)),
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)),
			"author" : value.author,
			"responsible" : value.responsible,
			"medicalLocationId" : value.medicalLocationId,
			"endOfLife" : value.endOfLife,
			"deletionDate" : value.deletionDate,
			"activeParticipants" : value.activeParticipants.map((k0, v0) => MapEntry(k0, TopicRole.encode(v0))),
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!),
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"encryptedSelf" : value.encryptedSelf,
			"linkedHealthElements" : value.linkedHealthElements.map((x0) => x0),
			"linkedServices" : value.linkedServices.map((x0) => x0)
		};
		return entityAsMap;
	}
}