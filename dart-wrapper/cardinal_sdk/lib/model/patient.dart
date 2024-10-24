// auto-generated file
import 'package:cardinal_sdk/model/base/identifier.dart';
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/embed/person_name.dart';
import 'package:cardinal_sdk/model/embed/address.dart';
import 'package:cardinal_sdk/model/embed/gender.dart';
import 'package:cardinal_sdk/model/embed/deactivation_reason.dart';
import 'package:cardinal_sdk/annotations/actual_int32.dart';
import 'package:cardinal_sdk/model/embed/personal_status.dart';
import 'package:cardinal_sdk/model/embed/annotation.dart';
import 'dart:typed_data';
import 'package:cardinal_sdk/model/embed/insurability.dart';
import 'package:cardinal_sdk/model/embed/partnership.dart';
import 'package:cardinal_sdk/model/embed/patient_health_care_party.dart';
import 'package:cardinal_sdk/model/embed/financial_institution_information.dart';
import 'package:cardinal_sdk/model/embed/medical_house_contract.dart';
import 'package:cardinal_sdk/model/property_stub.dart';
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/model/specializations/spki_hex_string.dart';
import 'package:cardinal_sdk/model/specializations/aes_exchange_key_encryption_keypair_identifier.dart';
import 'package:cardinal_sdk/model/embed/delegation.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/security_metadata.dart';
import 'package:cardinal_sdk/model/embed/schooling_info.dart';
import 'package:cardinal_sdk/model/embed/employment_info.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/icure_document.dart';
import 'package:cardinal_sdk/model/base/person.dart';
import 'package:cardinal_sdk/model/base/has_encryption_metadata.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';
import 'package:cardinal_sdk/model/base/crypto_actor.dart';
import 'dart:convert';


sealed class Patient implements StoredDocument, ICureDocument<String>, Person, HasEncryptionMetadata, Encryptable, CryptoActor {
	@override abstract String id;
	abstract List<Identifier> identifier;
	@override abstract String? rev;
	@override abstract int? created;
	@override abstract int? modified;
	@override abstract String? author;
	@override abstract String? responsible;
	@override abstract Set<CodeStub> tags;
	@override abstract Set<CodeStub> codes;
	@override abstract int? endOfLife;
	@override abstract int? deletionDate;
	@override abstract String? firstName;
	@override abstract String? lastName;
	@override abstract List<PersonName> names;
	@override abstract String? companyName;
	@override abstract List<String> languages;
	@override List<Address> get addresses;
	@override abstract String? civility;
	@override abstract Gender? gender;
	abstract Gender? birthSex;
	abstract String? mergeToPatientId;
	abstract Set<String> mergedIds;
	abstract String? alias;
	abstract bool active;
	abstract DeactivationReason deactivationReason;
	@ActualInt32() abstract int? deactivationDate;
	abstract String? ssin;
	abstract String? maidenName;
	abstract String? spouseName;
	abstract String? partnerName;
	abstract PersonalStatus? personalStatus;
	@ActualInt32() abstract int? dateOfBirth;
	@ActualInt32() abstract int? dateOfDeath;
	abstract int? timestampOfLatestEidReading;
	abstract String? placeOfBirth;
	abstract String? placeOfDeath;
	abstract bool? deceased;
	abstract String? education;
	abstract String? profession;
	abstract List<Annotation> notes;
	abstract String? note;
	abstract String? administrativeNote;
	abstract String? nationality;
	abstract String? race;
	abstract String? ethnicity;
	abstract String? preferredUserId;
	abstract Uint8List? picture;
	abstract String? externalId;
	List<Insurability> get insurabilities;
	abstract List<Partnership> partnerships;
	List<PatientHealthCareParty> get patientHealthCareParties;
	List<FinancialInstitutionInformation> get financialInstitutionInformation;
	List<MedicalHouseContract> get medicalHouseContracts;
	abstract List<CodeStub> patientProfessions;
	abstract Map<String, List<String>> parameters;
	Set<PropertyStub> get properties;
	@override abstract Map<String, List<HexString>> hcPartyKeys;
	@override abstract Map<SpkiHexString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>> aesExchangeKeys;
	@override abstract Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>> transferKeys;
	@override abstract Map<String, HexString> privateKeyShamirPartitions;
	@override abstract SpkiHexString? publicKey;
	@override abstract Set<SpkiHexString> publicKeysForOaepWithSha256;
	@override abstract Set<String> secretForeignKeys;
	@override abstract Map<String, Set<Delegation>> cryptedForeignKeys;
	@override abstract Map<String, Set<Delegation>> delegations;
	@override abstract Map<String, Set<Delegation>> encryptionKeys;
	@override abstract Base64String? encryptedSelf;
	@override abstract SecurityMetadata? securityMetadata;
	@override abstract String? medicalLocationId;
	abstract Set<String> nonDuplicateIds;
	abstract Set<String> encryptedAdministrativesDocuments;
	abstract String? comment;
	abstract String? warning;
	abstract CodeStub? fatherBirthCountry;
	abstract CodeStub? birthCountry;
	abstract CodeStub? nativeCountry;
	abstract CodeStub? socialStatus;
	abstract CodeStub? mainSourceOfIncome;
	abstract List<SchoolingInfo> schoolingInfos;
	abstract List<EmploymentInfo> employementInfos;

	static Map<String, dynamic> encode(Patient value) {
		switch (value) {
			case EncryptedPatient entity:
				Map<String, dynamic> entityJson = EncryptedPatient.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.EncryptedPatient";
				return entityJson;
			case DecryptedPatient entity:
				Map<String, dynamic> entityJson = DecryptedPatient.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DecryptedPatient";
				return entityJson;
		}
	}

	static Patient fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.EncryptedPatient":
				return EncryptedPatient.fromJSON(data);
			case "com.icure.cardinal.sdk.model.DecryptedPatient":
				return DecryptedPatient.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

class EncryptedPatient implements Patient {
	@override String id;
	@override List<Identifier> identifier = [];
	@override String? rev;
	@override int? created;
	@override int? modified;
	@override String? author;
	@override String? responsible;
	@override Set<CodeStub> tags = {};
	@override Set<CodeStub> codes = {};
	@override int? endOfLife;
	@override int? deletionDate;
	@override String? firstName;
	@override String? lastName;
	@override List<PersonName> names = [];
	@override String? companyName;
	@override List<String> languages = [];
	@override List<EncryptedAddress> addresses = [];
	@override String? civility;
	@override Gender? gender = Gender.unknown;
	@override Gender? birthSex = Gender.unknown;
	@override String? mergeToPatientId;
	@override Set<String> mergedIds = {};
	@override String? alias;
	@override bool active = true;
	@override DeactivationReason deactivationReason = DeactivationReason.none;
	int? _deactivationDate;
	@ActualInt32() @override int? get deactivationDate => _deactivationDate;
	@ActualInt32() @override set deactivationDate(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('deactivationDate value cannot exceed 2147483647');
		}
		_deactivationDate = value;
	}
	@override String? ssin;
	@override String? maidenName;
	@override String? spouseName;
	@override String? partnerName;
	@override PersonalStatus? personalStatus = PersonalStatus.unknown;
	int? _dateOfBirth;
	@ActualInt32() @override int? get dateOfBirth => _dateOfBirth;
	@ActualInt32() @override set dateOfBirth(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('dateOfBirth value cannot exceed 2147483647');
		}
		_dateOfBirth = value;
	}
	int? _dateOfDeath;
	@ActualInt32() @override int? get dateOfDeath => _dateOfDeath;
	@ActualInt32() @override set dateOfDeath(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('dateOfDeath value cannot exceed 2147483647');
		}
		_dateOfDeath = value;
	}
	@override int? timestampOfLatestEidReading;
	@override String? placeOfBirth;
	@override String? placeOfDeath;
	@override bool? deceased;
	@override String? education;
	@override String? profession;
	@override List<Annotation> notes = [];
	@override String? note;
	@override String? administrativeNote;
	@override String? nationality;
	@override String? race;
	@override String? ethnicity;
	@override String? preferredUserId;
	@override Uint8List? picture;
	@override String? externalId;
	@override List<EncryptedInsurability> insurabilities = [];
	@override List<Partnership> partnerships = [];
	@override List<EncryptedPatientHealthCareParty> patientHealthCareParties = [];
	@override List<EncryptedFinancialInstitutionInformation> financialInstitutionInformation = [];
	@override List<EncryptedMedicalHouseContract> medicalHouseContracts = [];
	@override List<CodeStub> patientProfessions = [];
	@override Map<String, List<String>> parameters = {};
	@override Set<EncryptedPropertyStub> properties = {};
	@override Map<String, List<HexString>> hcPartyKeys = {};
	@override Map<SpkiHexString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>> aesExchangeKeys = {};
	@override Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>> transferKeys = {};
	@override Map<String, HexString> privateKeyShamirPartitions = {};
	@override SpkiHexString? publicKey;
	@override Set<SpkiHexString> publicKeysForOaepWithSha256 = {};
	@override Set<String> secretForeignKeys = {};
	@override Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override Map<String, Set<Delegation>> delegations = {};
	@override Map<String, Set<Delegation>> encryptionKeys = {};
	@override Base64String? encryptedSelf;
	@override SecurityMetadata? securityMetadata;
	@override String? medicalLocationId;
	@override Set<String> nonDuplicateIds = {};
	@override Set<String> encryptedAdministrativesDocuments = {};
	@override String? comment;
	@override String? warning;
	@override CodeStub? fatherBirthCountry;
	@override CodeStub? birthCountry;
	@override CodeStub? nativeCountry;
	@override CodeStub? socialStatus;
	@override CodeStub? mainSourceOfIncome;
	@override List<SchoolingInfo> schoolingInfos = [];
	@override List<EmploymentInfo> employementInfos = [];
	EncryptedPatient(
		this.id,
		{
			int? deactivationDate,
			int? dateOfBirth,
			int? dateOfDeath,
			this.rev,
			this.created,
			this.modified,
			this.author,
			this.responsible,
			this.endOfLife,
			this.deletionDate,
			this.firstName,
			this.lastName,
			this.companyName,
			this.civility,
			this.mergeToPatientId,
			this.alias,
			this.ssin,
			this.maidenName,
			this.spouseName,
			this.partnerName,
			this.timestampOfLatestEidReading,
			this.placeOfBirth,
			this.placeOfDeath,
			this.deceased,
			this.education,
			this.profession,
			this.note,
			this.administrativeNote,
			this.nationality,
			this.race,
			this.ethnicity,
			this.preferredUserId,
			this.picture,
			this.externalId,
			this.publicKey,
			this.encryptedSelf,
			this.securityMetadata,
			this.medicalLocationId,
			this.comment,
			this.warning,
			this.fatherBirthCountry,
			this.birthCountry,
			this.nativeCountry,
			this.socialStatus,
			this.mainSourceOfIncome,
			List<Identifier>? identifier,
			Set<CodeStub>? tags,
			Set<CodeStub>? codes,
			List<PersonName>? names,
			List<String>? languages,
			List<EncryptedAddress>? addresses,
			Gender? gender,
			Gender? birthSex,
			Set<String>? mergedIds,
			bool? active,
			DeactivationReason? deactivationReason,
			PersonalStatus? personalStatus,
			List<Annotation>? notes,
			List<EncryptedInsurability>? insurabilities,
			List<Partnership>? partnerships,
			List<EncryptedPatientHealthCareParty>? patientHealthCareParties,
			List<EncryptedFinancialInstitutionInformation>? financialInstitutionInformation,
			List<EncryptedMedicalHouseContract>? medicalHouseContracts,
			List<CodeStub>? patientProfessions,
			Map<String, List<String>>? parameters,
			Set<EncryptedPropertyStub>? properties,
			Map<String, List<HexString>>? hcPartyKeys,
			Map<SpkiHexString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>? aesExchangeKeys,
			Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>? transferKeys,
			Map<String, HexString>? privateKeyShamirPartitions,
			Set<SpkiHexString>? publicKeysForOaepWithSha256,
			Set<String>? secretForeignKeys,
			Map<String, Set<Delegation>>? cryptedForeignKeys,
			Map<String, Set<Delegation>>? delegations,
			Map<String, Set<Delegation>>? encryptionKeys,
			Set<String>? nonDuplicateIds,
			Set<String>? encryptedAdministrativesDocuments,
			List<SchoolingInfo>? schoolingInfos,
			List<EmploymentInfo>? employementInfos
		}) : identifier = identifier ?? [],
		tags = tags ?? {},
		codes = codes ?? {},
		names = names ?? [],
		languages = languages ?? [],
		addresses = addresses ?? [],
		gender = gender ?? Gender.unknown,
		birthSex = birthSex ?? Gender.unknown,
		mergedIds = mergedIds ?? {},
		active = active ?? true,
		deactivationReason = deactivationReason ?? DeactivationReason.none,
		personalStatus = personalStatus ?? PersonalStatus.unknown,
		notes = notes ?? [],
		insurabilities = insurabilities ?? [],
		partnerships = partnerships ?? [],
		patientHealthCareParties = patientHealthCareParties ?? [],
		financialInstitutionInformation = financialInstitutionInformation ?? [],
		medicalHouseContracts = medicalHouseContracts ?? [],
		patientProfessions = patientProfessions ?? [],
		parameters = parameters ?? {},
		properties = properties ?? {},
		hcPartyKeys = hcPartyKeys ?? {},
		aesExchangeKeys = aesExchangeKeys ?? {},
		transferKeys = transferKeys ?? {},
		privateKeyShamirPartitions = privateKeyShamirPartitions ?? {},
		publicKeysForOaepWithSha256 = publicKeysForOaepWithSha256 ?? {},
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {},
		nonDuplicateIds = nonDuplicateIds ?? {},
		encryptedAdministrativesDocuments = encryptedAdministrativesDocuments ?? {},
		schoolingInfos = schoolingInfos ?? [],
		employementInfos = employementInfos ?? [],
		_deactivationDate = deactivationDate,
		_dateOfBirth = dateOfBirth,
		_dateOfDeath = dateOfDeath;

	factory EncryptedPatient.fromJSON(Map<String, dynamic> data) {
		return EncryptedPatient(
			(data["id"] as String),
			deactivationDate: (data["deactivationDate"] as int?),
			dateOfBirth: (data["dateOfBirth"] as int?),
			dateOfDeath: (data["dateOfDeath"] as int?),
			identifier: (data["identifier"] as List<dynamic>).map((x0) => Identifier.fromJSON(x0) ).toList(),
			rev: (data["rev"] as String?),
			created: (data["created"] as int?),
			modified: (data["modified"] as int?),
			author: (data["author"] as String?),
			responsible: (data["responsible"] as String?),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			endOfLife: (data["endOfLife"] as int?),
			deletionDate: (data["deletionDate"] as int?),
			firstName: (data["firstName"] as String?),
			lastName: (data["lastName"] as String?),
			names: (data["names"] as List<dynamic>).map((x0) => PersonName.fromJSON(x0) ).toList(),
			companyName: (data["companyName"] as String?),
			languages: (data["languages"] as List<dynamic>).map((x0) => (x0 as String) ).toList(),
			addresses: (data["addresses"] as List<dynamic>).map((x0) => EncryptedAddress.fromJSON(x0) ).toList(),
			civility: (data["civility"] as String?),
			gender: data["gender"] == null ? null : Gender.fromJSON(data["gender"]),
			birthSex: data["birthSex"] == null ? null : Gender.fromJSON(data["birthSex"]),
			mergeToPatientId: (data["mergeToPatientId"] as String?),
			mergedIds: (data["mergedIds"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			alias: (data["alias"] as String?),
			active: (data["active"] as bool),
			deactivationReason: DeactivationReason.fromJSON(data["deactivationReason"]),
			ssin: (data["ssin"] as String?),
			maidenName: (data["maidenName"] as String?),
			spouseName: (data["spouseName"] as String?),
			partnerName: (data["partnerName"] as String?),
			personalStatus: data["personalStatus"] == null ? null : PersonalStatus.fromJSON(data["personalStatus"]),
			timestampOfLatestEidReading: (data["timestampOfLatestEidReading"] as int?),
			placeOfBirth: (data["placeOfBirth"] as String?),
			placeOfDeath: (data["placeOfDeath"] as String?),
			deceased: (data["deceased"] as bool?),
			education: (data["education"] as String?),
			profession: (data["profession"] as String?),
			notes: (data["notes"] as List<dynamic>).map((x0) => Annotation.fromJSON(x0) ).toList(),
			note: (data["note"] as String?),
			administrativeNote: (data["administrativeNote"] as String?),
			nationality: (data["nationality"] as String?),
			race: (data["race"] as String?),
			ethnicity: (data["ethnicity"] as String?),
			preferredUserId: (data["preferredUserId"] as String?),
			picture: data["picture"] == null ? null : base64Decode(data["picture"] as String),
			externalId: (data["externalId"] as String?),
			insurabilities: (data["insurabilities"] as List<dynamic>).map((x0) => EncryptedInsurability.fromJSON(x0) ).toList(),
			partnerships: (data["partnerships"] as List<dynamic>).map((x0) => Partnership.fromJSON(x0) ).toList(),
			patientHealthCareParties: (data["patientHealthCareParties"] as List<dynamic>).map((x0) => EncryptedPatientHealthCareParty.fromJSON(x0) ).toList(),
			financialInstitutionInformation: (data["financialInstitutionInformation"] as List<dynamic>).map((x0) => EncryptedFinancialInstitutionInformation.fromJSON(x0) ).toList(),
			medicalHouseContracts: (data["medicalHouseContracts"] as List<dynamic>).map((x0) => EncryptedMedicalHouseContract.fromJSON(x0) ).toList(),
			patientProfessions: (data["patientProfessions"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toList(),
			parameters: (data["parameters"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => (x1 as String) ).toList())),
			properties: (data["properties"] as List<dynamic>).map((x0) => EncryptedPropertyStub.fromJSON(x0) ).toSet(),
			hcPartyKeys: (data["hcPartyKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => (x1 as HexString) ).toList())),
			aesExchangeKeys: (data["aesExchangeKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as SpkiHexString), (v0 as Map<String, dynamic>).map((k1, v1) => MapEntry((k1 as String), (v1 as Map<String, dynamic>).map((k2, v2) => MapEntry((k2 as AesExchangeKeyEncryptionKeypairIdentifier), (v2 as HexString))))))),
			transferKeys: (data["transferKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as AesExchangeKeyEncryptionKeypairIdentifier), (v0 as Map<String, dynamic>).map((k1, v1) => MapEntry((k1 as AesExchangeKeyEncryptionKeypairIdentifier), (v1 as HexString))))),
			privateKeyShamirPartitions: (data["privateKeyShamirPartitions"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as HexString))),
			publicKey: (data["publicKey"] as SpkiHexString?),
			publicKeysForOaepWithSha256: (data["publicKeysForOaepWithSha256"] as List<dynamic>).map((x0) => (x0 as SpkiHexString) ).toSet(),
			secretForeignKeys: (data["secretForeignKeys"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			cryptedForeignKeys: (data["cryptedForeignKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			delegations: (data["delegations"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptionKeys: (data["encryptionKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
			medicalLocationId: (data["medicalLocationId"] as String?),
			nonDuplicateIds: (data["nonDuplicateIds"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			encryptedAdministrativesDocuments: (data["encryptedAdministrativesDocuments"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			comment: (data["comment"] as String?),
			warning: (data["warning"] as String?),
			fatherBirthCountry: data["fatherBirthCountry"] == null ? null : CodeStub.fromJSON(data["fatherBirthCountry"]),
			birthCountry: data["birthCountry"] == null ? null : CodeStub.fromJSON(data["birthCountry"]),
			nativeCountry: data["nativeCountry"] == null ? null : CodeStub.fromJSON(data["nativeCountry"]),
			socialStatus: data["socialStatus"] == null ? null : CodeStub.fromJSON(data["socialStatus"]),
			mainSourceOfIncome: data["mainSourceOfIncome"] == null ? null : CodeStub.fromJSON(data["mainSourceOfIncome"]),
			schoolingInfos: (data["schoolingInfos"] as List<dynamic>).map((x0) => SchoolingInfo.fromJSON(x0) ).toList(),
			employementInfos: (data["employementInfos"] as List<dynamic>).map((x0) => EmploymentInfo.fromJSON(x0) ).toList(),
		);
	}

	static Map<String, dynamic> encode(EncryptedPatient value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"identifier" : value.identifier.map((x0) => Identifier.encode(x0)).toList(),
			"rev" : value.rev,
			"created" : value.created,
			"modified" : value.modified,
			"author" : value.author,
			"responsible" : value.responsible,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)).toList(),
			"endOfLife" : value.endOfLife,
			"deletionDate" : value.deletionDate,
			"firstName" : value.firstName,
			"lastName" : value.lastName,
			"names" : value.names.map((x0) => PersonName.encode(x0)).toList(),
			"companyName" : value.companyName,
			"languages" : value.languages.map((x0) => x0).toList(),
			"addresses" : value.addresses.map((x0) => EncryptedAddress.encode(x0)).toList(),
			"civility" : value.civility,
			"gender" : value.gender == null ? null : Gender.encode(value.gender!),
			"birthSex" : value.birthSex == null ? null : Gender.encode(value.birthSex!),
			"mergeToPatientId" : value.mergeToPatientId,
			"mergedIds" : value.mergedIds.map((x0) => x0).toList(),
			"alias" : value.alias,
			"active" : value.active,
			"deactivationReason" : DeactivationReason.encode(value.deactivationReason),
			"deactivationDate" : value.deactivationDate,
			"ssin" : value.ssin,
			"maidenName" : value.maidenName,
			"spouseName" : value.spouseName,
			"partnerName" : value.partnerName,
			"personalStatus" : value.personalStatus == null ? null : PersonalStatus.encode(value.personalStatus!),
			"dateOfBirth" : value.dateOfBirth,
			"dateOfDeath" : value.dateOfDeath,
			"timestampOfLatestEidReading" : value.timestampOfLatestEidReading,
			"placeOfBirth" : value.placeOfBirth,
			"placeOfDeath" : value.placeOfDeath,
			"deceased" : value.deceased,
			"education" : value.education,
			"profession" : value.profession,
			"notes" : value.notes.map((x0) => Annotation.encode(x0)).toList(),
			"note" : value.note,
			"administrativeNote" : value.administrativeNote,
			"nationality" : value.nationality,
			"race" : value.race,
			"ethnicity" : value.ethnicity,
			"preferredUserId" : value.preferredUserId,
			"picture" : value.picture == null ? null : base64Encode(value.picture as List<int>),
			"externalId" : value.externalId,
			"insurabilities" : value.insurabilities.map((x0) => EncryptedInsurability.encode(x0)).toList(),
			"partnerships" : value.partnerships.map((x0) => Partnership.encode(x0)).toList(),
			"patientHealthCareParties" : value.patientHealthCareParties.map((x0) => EncryptedPatientHealthCareParty.encode(x0)).toList(),
			"financialInstitutionInformation" : value.financialInstitutionInformation.map((x0) => EncryptedFinancialInstitutionInformation.encode(x0)).toList(),
			"medicalHouseContracts" : value.medicalHouseContracts.map((x0) => EncryptedMedicalHouseContract.encode(x0)).toList(),
			"patientProfessions" : value.patientProfessions.map((x0) => CodeStub.encode(x0)).toList(),
			"parameters" : value.parameters.map((k0, v0) => MapEntry(k0, v0.map((x1) => x1).toList())),
			"properties" : value.properties.map((x0) => EncryptedPropertyStub.encode(x0)).toList(),
			"hcPartyKeys" : value.hcPartyKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => x1).toList())),
			"aesExchangeKeys" : value.aesExchangeKeys.map((k0, v0) => MapEntry(k0, v0.map((k1, v1) => MapEntry(k1, v1.map((k2, v2) => MapEntry(k2, v2)))))),
			"transferKeys" : value.transferKeys.map((k0, v0) => MapEntry(k0, v0.map((k1, v1) => MapEntry(k1, v1)))),
			"privateKeyShamirPartitions" : value.privateKeyShamirPartitions.map((k0, v0) => MapEntry(k0, v0)),
			"publicKey" : value.publicKey,
			"publicKeysForOaepWithSha256" : value.publicKeysForOaepWithSha256.map((x0) => x0).toList(),
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0).toList(),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!),
			"medicalLocationId" : value.medicalLocationId,
			"nonDuplicateIds" : value.nonDuplicateIds.map((x0) => x0).toList(),
			"encryptedAdministrativesDocuments" : value.encryptedAdministrativesDocuments.map((x0) => x0).toList(),
			"comment" : value.comment,
			"warning" : value.warning,
			"fatherBirthCountry" : value.fatherBirthCountry == null ? null : CodeStub.encode(value.fatherBirthCountry!),
			"birthCountry" : value.birthCountry == null ? null : CodeStub.encode(value.birthCountry!),
			"nativeCountry" : value.nativeCountry == null ? null : CodeStub.encode(value.nativeCountry!),
			"socialStatus" : value.socialStatus == null ? null : CodeStub.encode(value.socialStatus!),
			"mainSourceOfIncome" : value.mainSourceOfIncome == null ? null : CodeStub.encode(value.mainSourceOfIncome!),
			"schoolingInfos" : value.schoolingInfos.map((x0) => SchoolingInfo.encode(x0)).toList(),
			"employementInfos" : value.employementInfos.map((x0) => EmploymentInfo.encode(x0)).toList()
		};
		return entityAsMap;
	}
}

class DecryptedPatient implements Patient {
	@override String id;
	@override List<Identifier> identifier = [];
	@override String? rev;
	@override int? created;
	@override int? modified;
	@override String? author;
	@override String? responsible;
	@override Set<CodeStub> tags = {};
	@override Set<CodeStub> codes = {};
	@override int? endOfLife;
	@override int? deletionDate;
	@override String? firstName;
	@override String? lastName;
	@override List<PersonName> names = [];
	@override String? companyName;
	@override List<String> languages = [];
	@override List<DecryptedAddress> addresses = [];
	@override String? civility;
	@override Gender? gender = Gender.unknown;
	@override Gender? birthSex = Gender.unknown;
	@override String? mergeToPatientId;
	@override Set<String> mergedIds = {};
	@override String? alias;
	@override bool active = true;
	@override DeactivationReason deactivationReason = DeactivationReason.none;
	int? _deactivationDate;
	@ActualInt32() @override int? get deactivationDate => _deactivationDate;
	@ActualInt32() @override set deactivationDate(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('deactivationDate value cannot exceed 2147483647');
		}
		_deactivationDate = value;
	}
	@override String? ssin;
	@override String? maidenName;
	@override String? spouseName;
	@override String? partnerName;
	@override PersonalStatus? personalStatus = PersonalStatus.unknown;
	int? _dateOfBirth;
	@ActualInt32() @override int? get dateOfBirth => _dateOfBirth;
	@ActualInt32() @override set dateOfBirth(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('dateOfBirth value cannot exceed 2147483647');
		}
		_dateOfBirth = value;
	}
	int? _dateOfDeath;
	@ActualInt32() @override int? get dateOfDeath => _dateOfDeath;
	@ActualInt32() @override set dateOfDeath(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('dateOfDeath value cannot exceed 2147483647');
		}
		_dateOfDeath = value;
	}
	@override int? timestampOfLatestEidReading;
	@override String? placeOfBirth;
	@override String? placeOfDeath;
	@override bool? deceased;
	@override String? education;
	@override String? profession;
	@override List<Annotation> notes = [];
	@override String? note;
	@override String? administrativeNote;
	@override String? nationality;
	@override String? race;
	@override String? ethnicity;
	@override String? preferredUserId;
	@override Uint8List? picture;
	@override String? externalId;
	@override List<DecryptedInsurability> insurabilities = [];
	@override List<Partnership> partnerships = [];
	@override List<DecryptedPatientHealthCareParty> patientHealthCareParties = [];
	@override List<DecryptedFinancialInstitutionInformation> financialInstitutionInformation = [];
	@override List<DecryptedMedicalHouseContract> medicalHouseContracts = [];
	@override List<CodeStub> patientProfessions = [];
	@override Map<String, List<String>> parameters = {};
	@override Set<DecryptedPropertyStub> properties = {};
	@override Map<String, List<HexString>> hcPartyKeys = {};
	@override Map<SpkiHexString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>> aesExchangeKeys = {};
	@override Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>> transferKeys = {};
	@override Map<String, HexString> privateKeyShamirPartitions = {};
	@override SpkiHexString? publicKey;
	@override Set<SpkiHexString> publicKeysForOaepWithSha256 = {};
	@override Set<String> secretForeignKeys = {};
	@override Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override Map<String, Set<Delegation>> delegations = {};
	@override Map<String, Set<Delegation>> encryptionKeys = {};
	@override Base64String? encryptedSelf;
	@override SecurityMetadata? securityMetadata;
	@override String? medicalLocationId;
	@override Set<String> nonDuplicateIds = {};
	@override Set<String> encryptedAdministrativesDocuments = {};
	@override String? comment;
	@override String? warning;
	@override CodeStub? fatherBirthCountry;
	@override CodeStub? birthCountry;
	@override CodeStub? nativeCountry;
	@override CodeStub? socialStatus;
	@override CodeStub? mainSourceOfIncome;
	@override List<SchoolingInfo> schoolingInfos = [];
	@override List<EmploymentInfo> employementInfos = [];
	DecryptedPatient(
		this.id,
		{
			int? deactivationDate,
			int? dateOfBirth,
			int? dateOfDeath,
			this.rev,
			this.created,
			this.modified,
			this.author,
			this.responsible,
			this.endOfLife,
			this.deletionDate,
			this.firstName,
			this.lastName,
			this.companyName,
			this.civility,
			this.mergeToPatientId,
			this.alias,
			this.ssin,
			this.maidenName,
			this.spouseName,
			this.partnerName,
			this.timestampOfLatestEidReading,
			this.placeOfBirth,
			this.placeOfDeath,
			this.deceased,
			this.education,
			this.profession,
			this.note,
			this.administrativeNote,
			this.nationality,
			this.race,
			this.ethnicity,
			this.preferredUserId,
			this.picture,
			this.externalId,
			this.publicKey,
			this.encryptedSelf,
			this.securityMetadata,
			this.medicalLocationId,
			this.comment,
			this.warning,
			this.fatherBirthCountry,
			this.birthCountry,
			this.nativeCountry,
			this.socialStatus,
			this.mainSourceOfIncome,
			List<Identifier>? identifier,
			Set<CodeStub>? tags,
			Set<CodeStub>? codes,
			List<PersonName>? names,
			List<String>? languages,
			List<DecryptedAddress>? addresses,
			Gender? gender,
			Gender? birthSex,
			Set<String>? mergedIds,
			bool? active,
			DeactivationReason? deactivationReason,
			PersonalStatus? personalStatus,
			List<Annotation>? notes,
			List<DecryptedInsurability>? insurabilities,
			List<Partnership>? partnerships,
			List<DecryptedPatientHealthCareParty>? patientHealthCareParties,
			List<DecryptedFinancialInstitutionInformation>? financialInstitutionInformation,
			List<DecryptedMedicalHouseContract>? medicalHouseContracts,
			List<CodeStub>? patientProfessions,
			Map<String, List<String>>? parameters,
			Set<DecryptedPropertyStub>? properties,
			Map<String, List<HexString>>? hcPartyKeys,
			Map<SpkiHexString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>? aesExchangeKeys,
			Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>? transferKeys,
			Map<String, HexString>? privateKeyShamirPartitions,
			Set<SpkiHexString>? publicKeysForOaepWithSha256,
			Set<String>? secretForeignKeys,
			Map<String, Set<Delegation>>? cryptedForeignKeys,
			Map<String, Set<Delegation>>? delegations,
			Map<String, Set<Delegation>>? encryptionKeys,
			Set<String>? nonDuplicateIds,
			Set<String>? encryptedAdministrativesDocuments,
			List<SchoolingInfo>? schoolingInfos,
			List<EmploymentInfo>? employementInfos
		}) : identifier = identifier ?? [],
		tags = tags ?? {},
		codes = codes ?? {},
		names = names ?? [],
		languages = languages ?? [],
		addresses = addresses ?? [],
		gender = gender ?? Gender.unknown,
		birthSex = birthSex ?? Gender.unknown,
		mergedIds = mergedIds ?? {},
		active = active ?? true,
		deactivationReason = deactivationReason ?? DeactivationReason.none,
		personalStatus = personalStatus ?? PersonalStatus.unknown,
		notes = notes ?? [],
		insurabilities = insurabilities ?? [],
		partnerships = partnerships ?? [],
		patientHealthCareParties = patientHealthCareParties ?? [],
		financialInstitutionInformation = financialInstitutionInformation ?? [],
		medicalHouseContracts = medicalHouseContracts ?? [],
		patientProfessions = patientProfessions ?? [],
		parameters = parameters ?? {},
		properties = properties ?? {},
		hcPartyKeys = hcPartyKeys ?? {},
		aesExchangeKeys = aesExchangeKeys ?? {},
		transferKeys = transferKeys ?? {},
		privateKeyShamirPartitions = privateKeyShamirPartitions ?? {},
		publicKeysForOaepWithSha256 = publicKeysForOaepWithSha256 ?? {},
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {},
		nonDuplicateIds = nonDuplicateIds ?? {},
		encryptedAdministrativesDocuments = encryptedAdministrativesDocuments ?? {},
		schoolingInfos = schoolingInfos ?? [],
		employementInfos = employementInfos ?? [],
		_deactivationDate = deactivationDate,
		_dateOfBirth = dateOfBirth,
		_dateOfDeath = dateOfDeath;

	factory DecryptedPatient.fromJSON(Map<String, dynamic> data) {
		return DecryptedPatient(
			(data["id"] as String),
			deactivationDate: (data["deactivationDate"] as int?),
			dateOfBirth: (data["dateOfBirth"] as int?),
			dateOfDeath: (data["dateOfDeath"] as int?),
			identifier: (data["identifier"] as List<dynamic>).map((x0) => Identifier.fromJSON(x0) ).toList(),
			rev: (data["rev"] as String?),
			created: (data["created"] as int?),
			modified: (data["modified"] as int?),
			author: (data["author"] as String?),
			responsible: (data["responsible"] as String?),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			endOfLife: (data["endOfLife"] as int?),
			deletionDate: (data["deletionDate"] as int?),
			firstName: (data["firstName"] as String?),
			lastName: (data["lastName"] as String?),
			names: (data["names"] as List<dynamic>).map((x0) => PersonName.fromJSON(x0) ).toList(),
			companyName: (data["companyName"] as String?),
			languages: (data["languages"] as List<dynamic>).map((x0) => (x0 as String) ).toList(),
			addresses: (data["addresses"] as List<dynamic>).map((x0) => DecryptedAddress.fromJSON(x0) ).toList(),
			civility: (data["civility"] as String?),
			gender: data["gender"] == null ? null : Gender.fromJSON(data["gender"]),
			birthSex: data["birthSex"] == null ? null : Gender.fromJSON(data["birthSex"]),
			mergeToPatientId: (data["mergeToPatientId"] as String?),
			mergedIds: (data["mergedIds"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			alias: (data["alias"] as String?),
			active: (data["active"] as bool),
			deactivationReason: DeactivationReason.fromJSON(data["deactivationReason"]),
			ssin: (data["ssin"] as String?),
			maidenName: (data["maidenName"] as String?),
			spouseName: (data["spouseName"] as String?),
			partnerName: (data["partnerName"] as String?),
			personalStatus: data["personalStatus"] == null ? null : PersonalStatus.fromJSON(data["personalStatus"]),
			timestampOfLatestEidReading: (data["timestampOfLatestEidReading"] as int?),
			placeOfBirth: (data["placeOfBirth"] as String?),
			placeOfDeath: (data["placeOfDeath"] as String?),
			deceased: (data["deceased"] as bool?),
			education: (data["education"] as String?),
			profession: (data["profession"] as String?),
			notes: (data["notes"] as List<dynamic>).map((x0) => Annotation.fromJSON(x0) ).toList(),
			note: (data["note"] as String?),
			administrativeNote: (data["administrativeNote"] as String?),
			nationality: (data["nationality"] as String?),
			race: (data["race"] as String?),
			ethnicity: (data["ethnicity"] as String?),
			preferredUserId: (data["preferredUserId"] as String?),
			picture: data["picture"] == null ? null : base64Decode(data["picture"] as String),
			externalId: (data["externalId"] as String?),
			insurabilities: (data["insurabilities"] as List<dynamic>).map((x0) => DecryptedInsurability.fromJSON(x0) ).toList(),
			partnerships: (data["partnerships"] as List<dynamic>).map((x0) => Partnership.fromJSON(x0) ).toList(),
			patientHealthCareParties: (data["patientHealthCareParties"] as List<dynamic>).map((x0) => DecryptedPatientHealthCareParty.fromJSON(x0) ).toList(),
			financialInstitutionInformation: (data["financialInstitutionInformation"] as List<dynamic>).map((x0) => DecryptedFinancialInstitutionInformation.fromJSON(x0) ).toList(),
			medicalHouseContracts: (data["medicalHouseContracts"] as List<dynamic>).map((x0) => DecryptedMedicalHouseContract.fromJSON(x0) ).toList(),
			patientProfessions: (data["patientProfessions"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toList(),
			parameters: (data["parameters"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => (x1 as String) ).toList())),
			properties: (data["properties"] as List<dynamic>).map((x0) => DecryptedPropertyStub.fromJSON(x0) ).toSet(),
			hcPartyKeys: (data["hcPartyKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => (x1 as HexString) ).toList())),
			aesExchangeKeys: (data["aesExchangeKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as SpkiHexString), (v0 as Map<String, dynamic>).map((k1, v1) => MapEntry((k1 as String), (v1 as Map<String, dynamic>).map((k2, v2) => MapEntry((k2 as AesExchangeKeyEncryptionKeypairIdentifier), (v2 as HexString))))))),
			transferKeys: (data["transferKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as AesExchangeKeyEncryptionKeypairIdentifier), (v0 as Map<String, dynamic>).map((k1, v1) => MapEntry((k1 as AesExchangeKeyEncryptionKeypairIdentifier), (v1 as HexString))))),
			privateKeyShamirPartitions: (data["privateKeyShamirPartitions"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as HexString))),
			publicKey: (data["publicKey"] as SpkiHexString?),
			publicKeysForOaepWithSha256: (data["publicKeysForOaepWithSha256"] as List<dynamic>).map((x0) => (x0 as SpkiHexString) ).toSet(),
			secretForeignKeys: (data["secretForeignKeys"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			cryptedForeignKeys: (data["cryptedForeignKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			delegations: (data["delegations"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptionKeys: (data["encryptionKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
			medicalLocationId: (data["medicalLocationId"] as String?),
			nonDuplicateIds: (data["nonDuplicateIds"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			encryptedAdministrativesDocuments: (data["encryptedAdministrativesDocuments"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			comment: (data["comment"] as String?),
			warning: (data["warning"] as String?),
			fatherBirthCountry: data["fatherBirthCountry"] == null ? null : CodeStub.fromJSON(data["fatherBirthCountry"]),
			birthCountry: data["birthCountry"] == null ? null : CodeStub.fromJSON(data["birthCountry"]),
			nativeCountry: data["nativeCountry"] == null ? null : CodeStub.fromJSON(data["nativeCountry"]),
			socialStatus: data["socialStatus"] == null ? null : CodeStub.fromJSON(data["socialStatus"]),
			mainSourceOfIncome: data["mainSourceOfIncome"] == null ? null : CodeStub.fromJSON(data["mainSourceOfIncome"]),
			schoolingInfos: (data["schoolingInfos"] as List<dynamic>).map((x0) => SchoolingInfo.fromJSON(x0) ).toList(),
			employementInfos: (data["employementInfos"] as List<dynamic>).map((x0) => EmploymentInfo.fromJSON(x0) ).toList(),
		);
	}

	static Map<String, dynamic> encode(DecryptedPatient value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"identifier" : value.identifier.map((x0) => Identifier.encode(x0)).toList(),
			"rev" : value.rev,
			"created" : value.created,
			"modified" : value.modified,
			"author" : value.author,
			"responsible" : value.responsible,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)).toList(),
			"endOfLife" : value.endOfLife,
			"deletionDate" : value.deletionDate,
			"firstName" : value.firstName,
			"lastName" : value.lastName,
			"names" : value.names.map((x0) => PersonName.encode(x0)).toList(),
			"companyName" : value.companyName,
			"languages" : value.languages.map((x0) => x0).toList(),
			"addresses" : value.addresses.map((x0) => DecryptedAddress.encode(x0)).toList(),
			"civility" : value.civility,
			"gender" : value.gender == null ? null : Gender.encode(value.gender!),
			"birthSex" : value.birthSex == null ? null : Gender.encode(value.birthSex!),
			"mergeToPatientId" : value.mergeToPatientId,
			"mergedIds" : value.mergedIds.map((x0) => x0).toList(),
			"alias" : value.alias,
			"active" : value.active,
			"deactivationReason" : DeactivationReason.encode(value.deactivationReason),
			"deactivationDate" : value.deactivationDate,
			"ssin" : value.ssin,
			"maidenName" : value.maidenName,
			"spouseName" : value.spouseName,
			"partnerName" : value.partnerName,
			"personalStatus" : value.personalStatus == null ? null : PersonalStatus.encode(value.personalStatus!),
			"dateOfBirth" : value.dateOfBirth,
			"dateOfDeath" : value.dateOfDeath,
			"timestampOfLatestEidReading" : value.timestampOfLatestEidReading,
			"placeOfBirth" : value.placeOfBirth,
			"placeOfDeath" : value.placeOfDeath,
			"deceased" : value.deceased,
			"education" : value.education,
			"profession" : value.profession,
			"notes" : value.notes.map((x0) => Annotation.encode(x0)).toList(),
			"note" : value.note,
			"administrativeNote" : value.administrativeNote,
			"nationality" : value.nationality,
			"race" : value.race,
			"ethnicity" : value.ethnicity,
			"preferredUserId" : value.preferredUserId,
			"picture" : value.picture == null ? null : base64Encode(value.picture as List<int>),
			"externalId" : value.externalId,
			"insurabilities" : value.insurabilities.map((x0) => DecryptedInsurability.encode(x0)).toList(),
			"partnerships" : value.partnerships.map((x0) => Partnership.encode(x0)).toList(),
			"patientHealthCareParties" : value.patientHealthCareParties.map((x0) => DecryptedPatientHealthCareParty.encode(x0)).toList(),
			"financialInstitutionInformation" : value.financialInstitutionInformation.map((x0) => DecryptedFinancialInstitutionInformation.encode(x0)).toList(),
			"medicalHouseContracts" : value.medicalHouseContracts.map((x0) => DecryptedMedicalHouseContract.encode(x0)).toList(),
			"patientProfessions" : value.patientProfessions.map((x0) => CodeStub.encode(x0)).toList(),
			"parameters" : value.parameters.map((k0, v0) => MapEntry(k0, v0.map((x1) => x1).toList())),
			"properties" : value.properties.map((x0) => DecryptedPropertyStub.encode(x0)).toList(),
			"hcPartyKeys" : value.hcPartyKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => x1).toList())),
			"aesExchangeKeys" : value.aesExchangeKeys.map((k0, v0) => MapEntry(k0, v0.map((k1, v1) => MapEntry(k1, v1.map((k2, v2) => MapEntry(k2, v2)))))),
			"transferKeys" : value.transferKeys.map((k0, v0) => MapEntry(k0, v0.map((k1, v1) => MapEntry(k1, v1)))),
			"privateKeyShamirPartitions" : value.privateKeyShamirPartitions.map((k0, v0) => MapEntry(k0, v0)),
			"publicKey" : value.publicKey,
			"publicKeysForOaepWithSha256" : value.publicKeysForOaepWithSha256.map((x0) => x0).toList(),
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0).toList(),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!),
			"medicalLocationId" : value.medicalLocationId,
			"nonDuplicateIds" : value.nonDuplicateIds.map((x0) => x0).toList(),
			"encryptedAdministrativesDocuments" : value.encryptedAdministrativesDocuments.map((x0) => x0).toList(),
			"comment" : value.comment,
			"warning" : value.warning,
			"fatherBirthCountry" : value.fatherBirthCountry == null ? null : CodeStub.encode(value.fatherBirthCountry!),
			"birthCountry" : value.birthCountry == null ? null : CodeStub.encode(value.birthCountry!),
			"nativeCountry" : value.nativeCountry == null ? null : CodeStub.encode(value.nativeCountry!),
			"socialStatus" : value.socialStatus == null ? null : CodeStub.encode(value.socialStatus!),
			"mainSourceOfIncome" : value.mainSourceOfIncome == null ? null : CodeStub.encode(value.mainSourceOfIncome!),
			"schoolingInfos" : value.schoolingInfos.map((x0) => SchoolingInfo.encode(x0)).toList(),
			"employementInfos" : value.employementInfos.map((x0) => EmploymentInfo.encode(x0)).toList()
		};
		return entityAsMap;
	}
}