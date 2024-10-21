// This file is auto-generated
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/base/identifier.dart';
import 'package:cardinal_sdk/model/embed/address.dart';
import 'package:cardinal_sdk/model/embed/sub_contact.dart';
import 'package:cardinal_sdk/model/embed/service.dart';
import 'package:cardinal_sdk/model/base/participant_type.dart';
import 'package:cardinal_sdk/model/embed/delegation.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/security_metadata.dart';
import 'package:cardinal_sdk/model/embed/annotation.dart';
import 'package:cardinal_sdk/model/contact.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/icure_document.dart';
import 'package:cardinal_sdk/model/base/has_encryption_metadata.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';


sealed class Contact implements StoredDocument, ICureDocument<String>, HasEncryptionMetadata, Encryptable {
	@override abstract String id;
	@override abstract String? rev;
	@override abstract int? created;
	@override abstract int? modified;
	@override abstract String? author;
	@override abstract String? responsible;
	@override abstract String? medicalLocationId;
	@override abstract Set<CodeStub> tags;
	@override abstract Set<CodeStub> codes;
	abstract List<Identifier> identifier;
	@override abstract int? endOfLife;
	@override abstract int? deletionDate;
	abstract String? groupId;
	abstract int? openingDate;
	abstract int? closingDate;
	abstract String? descr;
	abstract String? location;
	abstract String? externalId;
	abstract CodeStub? encounterType;
	Address? get encounterLocation;
	Set<SubContact> get subContacts;
	Set<Service> get services;
	abstract Map<ParticipantType, String> participants;
	abstract String? healthcarePartyId;
	abstract String? modifiedContactId;
	@override abstract Set<String> secretForeignKeys;
	@override abstract Map<String, Set<Delegation>> cryptedForeignKeys;
	@override abstract Map<String, Set<Delegation>> delegations;
	@override abstract Map<String, Set<Delegation>> encryptionKeys;
	@override abstract Base64String? encryptedSelf;
	@override abstract SecurityMetadata? securityMetadata;
	abstract List<Annotation> notes;


	static Map<String, dynamic> encode(Contact value) {
		switch (value) {
			case DecryptedContact entity:
				Map<String, dynamic> entityJson = DecryptedContact.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DecryptedContact";
				return entityJson;
			case EncryptedContact entity:
				Map<String, dynamic> entityJson = EncryptedContact.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.EncryptedContact";
				return entityJson;
		}
	}
}

class DecryptedContact implements Contact {
	@override  String id;
	@override  String? rev;
	@override  int? created;
	@override  int? modified;
	@override  String? author;
	@override  String? responsible;
	@override  String? medicalLocationId;
	@override  Set<CodeStub> tags = {};
	@override  Set<CodeStub> codes = {};
	@override  List<Identifier> identifier = [];
	@override  int? endOfLife;
	@override  int? deletionDate;
	@override  String? groupId;
	@override  int? openingDate;
	@override  int? closingDate;
	@override  String? descr;
	@override  String? location;
	@override  String? externalId;
	@override  CodeStub? encounterType;
	@override  DecryptedAddress? encounterLocation;
	@override  Set<DecryptedSubContact> subContacts = {};
	@override  Set<DecryptedService> services = {};
	@override  Map<ParticipantType, String> participants = {};
	@override  String? healthcarePartyId;
	@override  String? modifiedContactId;
	@override  Set<String> secretForeignKeys = {};
	@override  Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override  Map<String, Set<Delegation>> delegations = {};
	@override  Map<String, Set<Delegation>> encryptionKeys = {};
	@override  Base64String? encryptedSelf;
	@override  SecurityMetadata? securityMetadata;
	@override  List<Annotation> notes = [];

	DecryptedContact({
		required this.id,
		this.rev,
		this.created,
		this.modified,
		this.author,
		this.responsible,
		this.medicalLocationId,
		this.endOfLife,
		this.deletionDate,
		this.groupId,
		this.openingDate,
		this.closingDate,
		this.descr,
		this.location,
		this.externalId,
		this.encounterType,
		this.encounterLocation,
		this.healthcarePartyId,
		this.modifiedContactId,
		this.encryptedSelf,
		this.securityMetadata,
		Set<CodeStub>? tags,
		Set<CodeStub>? codes,
		List<Identifier>? identifier,
		Set<DecryptedSubContact>? subContacts,
		Set<DecryptedService>? services,
		Map<ParticipantType, String>? participants,
		Set<String>? secretForeignKeys,
		Map<String, Set<Delegation>>? cryptedForeignKeys,
		Map<String, Set<Delegation>>? delegations,
		Map<String, Set<Delegation>>? encryptionKeys,
		List<Annotation>? notes
	}) : tags = tags ?? {},
		codes = codes ?? {},
		identifier = identifier ?? [],
		subContacts = subContacts ?? {},
		services = services ?? {},
		participants = participants ?? {},
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {},
		notes = notes ?? [];

	static Map<String, dynamic> encode(DecryptedContact value) {
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
			"identifier" : value.identifier.map((x0) => Identifier.encode(x0)),
			"endOfLife" : value.endOfLife,
			"deletionDate" : value.deletionDate,
			"groupId" : value.groupId,
			"openingDate" : value.openingDate,
			"closingDate" : value.closingDate,
			"descr" : value.descr,
			"location" : value.location,
			"externalId" : value.externalId,
			"encounterType" : value.encounterType == null ? null : CodeStub.encode(value.encounterType!),
			"encounterLocation" : value.encounterLocation == null ? null : DecryptedAddress.encode(value.encounterLocation!),
			"subContacts" : value.subContacts.map((x0) => DecryptedSubContact.encode(x0)),
			"services" : value.services.map((x0) => DecryptedService.encode(x0)),
			"participants" : value.participants.map((k0, v0) => MapEntry(ParticipantType.encode(k0), v0)),
			"healthcarePartyId" : value.healthcarePartyId,
			"modifiedContactId" : value.modifiedContactId,
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!),
			"notes" : value.notes.map((x0) => Annotation.encode(x0))
		};
		return entityAsMap;
	}
}

class EncryptedContact implements Contact {
	@override  String id;
	@override  String? rev;
	@override  int? created;
	@override  int? modified;
	@override  String? author;
	@override  String? responsible;
	@override  String? medicalLocationId;
	@override  Set<CodeStub> tags = {};
	@override  Set<CodeStub> codes = {};
	@override  List<Identifier> identifier = [];
	@override  int? endOfLife;
	@override  int? deletionDate;
	@override  String? groupId;
	@override  int? openingDate;
	@override  int? closingDate;
	@override  String? descr;
	@override  String? location;
	@override  String? externalId;
	@override  CodeStub? encounterType;
	@override  EncryptedAddress? encounterLocation;
	@override  Set<EncryptedSubContact> subContacts = {};
	@override  Set<EncryptedService> services = {};
	@override  Map<ParticipantType, String> participants = {};
	@override  String? healthcarePartyId;
	@override  String? modifiedContactId;
	@override  Set<String> secretForeignKeys = {};
	@override  Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override  Map<String, Set<Delegation>> delegations = {};
	@override  Map<String, Set<Delegation>> encryptionKeys = {};
	@override  Base64String? encryptedSelf;
	@override  SecurityMetadata? securityMetadata;
	@override  List<Annotation> notes = [];

	EncryptedContact({
		required this.id,
		this.rev,
		this.created,
		this.modified,
		this.author,
		this.responsible,
		this.medicalLocationId,
		this.endOfLife,
		this.deletionDate,
		this.groupId,
		this.openingDate,
		this.closingDate,
		this.descr,
		this.location,
		this.externalId,
		this.encounterType,
		this.encounterLocation,
		this.healthcarePartyId,
		this.modifiedContactId,
		this.encryptedSelf,
		this.securityMetadata,
		Set<CodeStub>? tags,
		Set<CodeStub>? codes,
		List<Identifier>? identifier,
		Set<EncryptedSubContact>? subContacts,
		Set<EncryptedService>? services,
		Map<ParticipantType, String>? participants,
		Set<String>? secretForeignKeys,
		Map<String, Set<Delegation>>? cryptedForeignKeys,
		Map<String, Set<Delegation>>? delegations,
		Map<String, Set<Delegation>>? encryptionKeys,
		List<Annotation>? notes
	}) : tags = tags ?? {},
		codes = codes ?? {},
		identifier = identifier ?? [],
		subContacts = subContacts ?? {},
		services = services ?? {},
		participants = participants ?? {},
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {},
		notes = notes ?? [];

	static Map<String, dynamic> encode(EncryptedContact value) {
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
			"identifier" : value.identifier.map((x0) => Identifier.encode(x0)),
			"endOfLife" : value.endOfLife,
			"deletionDate" : value.deletionDate,
			"groupId" : value.groupId,
			"openingDate" : value.openingDate,
			"closingDate" : value.closingDate,
			"descr" : value.descr,
			"location" : value.location,
			"externalId" : value.externalId,
			"encounterType" : value.encounterType == null ? null : CodeStub.encode(value.encounterType!),
			"encounterLocation" : value.encounterLocation == null ? null : EncryptedAddress.encode(value.encounterLocation!),
			"subContacts" : value.subContacts.map((x0) => EncryptedSubContact.encode(x0)),
			"services" : value.services.map((x0) => EncryptedService.encode(x0)),
			"participants" : value.participants.map((k0, v0) => MapEntry(ParticipantType.encode(k0), v0)),
			"healthcarePartyId" : value.healthcarePartyId,
			"modifiedContactId" : value.modifiedContactId,
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!),
			"notes" : value.notes.map((x0) => Annotation.encode(x0))
		};
		return entityAsMap;
	}
}