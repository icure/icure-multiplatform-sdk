// auto-generated file
import 'package:cardinal_sdk/model/base/identifier.dart';
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/embed/person_name.dart';
import 'package:cardinal_sdk/model/embed/gender.dart';
import 'package:cardinal_sdk/annotations/actual_int32.dart';
import 'package:cardinal_sdk/model/embed/address.dart';
import 'dart:typed_data';
import 'package:cardinal_sdk/model/embed/healthcare_party_status.dart';
import 'package:cardinal_sdk/model/embed/healthcare_party_history_status.dart';
import 'package:cardinal_sdk/model/embed/telecom_type.dart';
import 'package:cardinal_sdk/model/embed/financial_institution_information.dart';
import 'package:cardinal_sdk/model/embed/flat_rate_tarification.dart';
import 'package:cardinal_sdk/model/property_stub.dart';
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/crypto/entities/cardinal_keys.dart';
import 'package:cardinal_sdk/model/specializations/aes_exchange_key_encryption_keypair_identifier.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/named.dart';
import 'package:cardinal_sdk/model/base/person.dart';
import 'package:cardinal_sdk/model/base/crypto_actor.dart';
import 'package:cardinal_sdk/model/base/data_owner.dart';
import 'package:cardinal_sdk/model/base/has_codes.dart';
import 'package:cardinal_sdk/model/base/has_tags.dart';


class HealthcareParty implements StoredDocument, Named, Person, CryptoActor, DataOwner, HasCodes, HasTags {
	@override String id;
	@override String? rev = null;
	int? created = null;
	int? modified = null;
	@override int? deletionDate = null;
	List<Identifier> identifier = [];
	@override Set<CodeStub> tags = {};
	@override Set<CodeStub> codes = {};
	@override String? name = null;
	@override String? lastName = null;
	@override String? firstName = null;
	@override List<PersonName> names = [];
	@override Gender? gender = null;
	@override String? civility = null;
	@override String? companyName = null;
	String? speciality = null;
	String? bankAccount = null;
	String? bic = null;
	String? proxyBankAccount = null;
	String? proxyBic = null;
	String? invoiceHeader = null;
	String? cbe = null;
	String? ehp = null;
	String? userId = null;
	String? parentId = null;
	int? _convention = null;
	@ActualInt32() int? get convention => _convention;
	@ActualInt32() set convention(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('convention value cannot exceed 2147483647');
		}
		_convention = value;
	}
	String? nihii = null;
	String? nihiiSpecCode = null;
	String? ssin = null;
	@override List<DecryptedAddress> addresses = [];
	@override List<String> languages = [];
	Uint8List? picture = null;
	Set<HealthcarePartyStatus> statuses = {};
	List<HealthcarePartyHistoryStatus> statusHistory = [];
	Set<CodeStub> specialityCodes = {};
	Map<TelecomType, String> sendFormats = {};
	String? notes = null;
	List<DecryptedFinancialInstitutionInformation> financialInstitutionInformation = [];
	Map<String, String>? descr = {};
	String? billingType = null;
	String? type = null;
	String? contactPerson = null;
	String? contactPersonHcpId = null;
	String? supervisorId = null;
	List<DecryptedFlatRateTarification> flatRateTarifications = [];
	Map<String, String> importedData = {};
	@Deprecated('Use properties instead') Map<String, String> options = {};
	@override Set<DecryptedPropertyStub> properties = {};
	@override Map<String, List<HexString>> hcPartyKeys = {};
	@override Map<CardinalRsaPublicKey, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>> aesExchangeKeys = {};
	@override Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>> transferKeys = {};
	@override Map<String, HexString> privateKeyShamirPartitions = {};
	@override CardinalRsaPublicKey? publicKey = null;
	@override Set<CardinalRsaPublicKey> publicKeysForOaepWithSha256 = {};
	HealthcareParty(
		this.id,
		{
			int? convention,
			String? rev,
			int? created,
			int? modified,
			int? deletionDate,
			List<Identifier>? identifier,
			Set<CodeStub>? tags,
			Set<CodeStub>? codes,
			String? name,
			String? lastName,
			String? firstName,
			List<PersonName>? names,
			Gender? gender,
			String? civility,
			String? companyName,
			String? speciality,
			String? bankAccount,
			String? bic,
			String? proxyBankAccount,
			String? proxyBic,
			String? invoiceHeader,
			String? cbe,
			String? ehp,
			String? userId,
			String? parentId,
			String? nihii,
			String? nihiiSpecCode,
			String? ssin,
			List<DecryptedAddress>? addresses,
			List<String>? languages,
			Uint8List? picture,
			Set<HealthcarePartyStatus>? statuses,
			List<HealthcarePartyHistoryStatus>? statusHistory,
			Set<CodeStub>? specialityCodes,
			Map<TelecomType, String>? sendFormats,
			String? notes,
			List<DecryptedFinancialInstitutionInformation>? financialInstitutionInformation,
			Map<String, String>? descr,
			String? billingType,
			String? type,
			String? contactPerson,
			String? contactPersonHcpId,
			String? supervisorId,
			List<DecryptedFlatRateTarification>? flatRateTarifications,
			Map<String, String>? importedData,
			Map<String, String>? options,
			Set<DecryptedPropertyStub>? properties,
			Map<String, List<HexString>>? hcPartyKeys,
			Map<CardinalRsaPublicKey, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>? aesExchangeKeys,
			Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>? transferKeys,
			Map<String, HexString>? privateKeyShamirPartitions,
			CardinalRsaPublicKey? publicKey,
			Set<CardinalRsaPublicKey>? publicKeysForOaepWithSha256
		}) : rev = rev ?? null,
		created = created ?? null,
		modified = modified ?? null,
		deletionDate = deletionDate ?? null,
		identifier = identifier ?? [],
		tags = tags ?? {},
		codes = codes ?? {},
		name = name ?? null,
		lastName = lastName ?? null,
		firstName = firstName ?? null,
		names = names ?? [],
		gender = gender ?? null,
		civility = civility ?? null,
		companyName = companyName ?? null,
		speciality = speciality ?? null,
		bankAccount = bankAccount ?? null,
		bic = bic ?? null,
		proxyBankAccount = proxyBankAccount ?? null,
		proxyBic = proxyBic ?? null,
		invoiceHeader = invoiceHeader ?? null,
		cbe = cbe ?? null,
		ehp = ehp ?? null,
		userId = userId ?? null,
		parentId = parentId ?? null,
		nihii = nihii ?? null,
		nihiiSpecCode = nihiiSpecCode ?? null,
		ssin = ssin ?? null,
		addresses = addresses ?? [],
		languages = languages ?? [],
		picture = picture ?? null,
		statuses = statuses ?? {},
		statusHistory = statusHistory ?? [],
		specialityCodes = specialityCodes ?? {},
		sendFormats = sendFormats ?? {},
		notes = notes ?? null,
		financialInstitutionInformation = financialInstitutionInformation ?? [],
		descr = descr ?? {},
		billingType = billingType ?? null,
		type = type ?? null,
		contactPerson = contactPerson ?? null,
		contactPersonHcpId = contactPersonHcpId ?? null,
		supervisorId = supervisorId ?? null,
		flatRateTarifications = flatRateTarifications ?? [],
		importedData = importedData ?? {},
		options = options ?? {},
		properties = properties ?? {},
		hcPartyKeys = hcPartyKeys ?? {},
		aesExchangeKeys = aesExchangeKeys ?? {},
		transferKeys = transferKeys ?? {},
		privateKeyShamirPartitions = privateKeyShamirPartitions ?? {},
		publicKey = publicKey ?? null,
		publicKeysForOaepWithSha256 = publicKeysForOaepWithSha256 ?? {},
		_convention = convention ?? null;

	static Map<String, dynamic> encode(HealthcareParty value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"created" : value.created,
			"modified" : value.modified,
			"deletionDate" : value.deletionDate,
			"identifier" : value.identifier.map((x0) => Identifier.encode(x0)).toList(),
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)).toList(),
			"name" : value.name,
			"lastName" : value.lastName,
			"firstName" : value.firstName,
			"names" : value.names.map((x0) => PersonName.encode(x0)).toList(),
			"gender" : value.gender == null ? null : Gender.encode(value.gender!),
			"civility" : value.civility,
			"companyName" : value.companyName,
			"speciality" : value.speciality,
			"bankAccount" : value.bankAccount,
			"bic" : value.bic,
			"proxyBankAccount" : value.proxyBankAccount,
			"proxyBic" : value.proxyBic,
			"invoiceHeader" : value.invoiceHeader,
			"cbe" : value.cbe,
			"ehp" : value.ehp,
			"userId" : value.userId,
			"parentId" : value.parentId,
			"convention" : value.convention,
			"nihii" : value.nihii,
			"nihiiSpecCode" : value.nihiiSpecCode,
			"ssin" : value.ssin,
			"addresses" : value.addresses.map((x0) => DecryptedAddress.encode(x0)).toList(),
			"languages" : value.languages.map((x0) => x0).toList(),
			"picture" : value.picture == null ? null : base64Encode(value.picture as List<int>),
			"statuses" : value.statuses.map((x0) => HealthcarePartyStatus.encode(x0)).toList(),
			"statusHistory" : value.statusHistory.map((x0) => HealthcarePartyHistoryStatus.encode(x0)).toList(),
			"specialityCodes" : value.specialityCodes.map((x0) => CodeStub.encode(x0)).toList(),
			"sendFormats" : value.sendFormats.map((k0, v0) => MapEntry(TelecomType.encode(k0), v0)),
			"notes" : value.notes,
			"financialInstitutionInformation" : value.financialInstitutionInformation.map((x0) => DecryptedFinancialInstitutionInformation.encode(x0)).toList(),
			"descr" : value.descr?.map((k0, v0) => MapEntry(k0, v0)),
			"billingType" : value.billingType,
			"type" : value.type,
			"contactPerson" : value.contactPerson,
			"contactPersonHcpId" : value.contactPersonHcpId,
			"supervisorId" : value.supervisorId,
			"flatRateTarifications" : value.flatRateTarifications.map((x0) => DecryptedFlatRateTarification.encode(x0)).toList(),
			"importedData" : value.importedData.map((k0, v0) => MapEntry(k0, v0)),
			"options" : value.options.map((k0, v0) => MapEntry(k0, v0)),
			"properties" : value.properties.map((x0) => DecryptedPropertyStub.encode(x0)).toList(),
			"hcPartyKeys" : value.hcPartyKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => x1).toList())),
			"aesExchangeKeys" : value.aesExchangeKeys.map((k0, v0) => MapEntry(k0.spkiHex, v0.map((k1, v1) => MapEntry(k1, v1.map((k2, v2) => MapEntry(k2, v2)))))),
			"transferKeys" : value.transferKeys.map((k0, v0) => MapEntry(k0, v0.map((k1, v1) => MapEntry(k1, v1)))),
			"privateKeyShamirPartitions" : value.privateKeyShamirPartitions.map((k0, v0) => MapEntry(k0, v0)),
			"publicKey" : value.publicKey?.spkiHex,
			"publicKeysForOaepWithSha256" : value.publicKeysForOaepWithSha256.map((x0) => x0.spkiHex).toList()
		};
		return entityAsMap;
	}

	static HealthcareParty fromJSON(Map<String, dynamic> data) {
		return HealthcareParty(
			(data["id"] as String),
			convention: (data["convention"] as int?),
			rev: (data["rev"] as String?),
			created: (data["created"] as int?),
			modified: (data["modified"] as int?),
			deletionDate: (data["deletionDate"] as int?),
			identifier: (data["identifier"] as List<dynamic>).map((x0) => Identifier.fromJSON(x0) ).toList(),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			name: (data["name"] as String?),
			lastName: (data["lastName"] as String?),
			firstName: (data["firstName"] as String?),
			names: (data["names"] as List<dynamic>).map((x0) => PersonName.fromJSON(x0) ).toList(),
			gender: data["gender"] == null ? null : Gender.fromJSON(data["gender"]),
			civility: (data["civility"] as String?),
			companyName: (data["companyName"] as String?),
			speciality: (data["speciality"] as String?),
			bankAccount: (data["bankAccount"] as String?),
			bic: (data["bic"] as String?),
			proxyBankAccount: (data["proxyBankAccount"] as String?),
			proxyBic: (data["proxyBic"] as String?),
			invoiceHeader: (data["invoiceHeader"] as String?),
			cbe: (data["cbe"] as String?),
			ehp: (data["ehp"] as String?),
			userId: (data["userId"] as String?),
			parentId: (data["parentId"] as String?),
			nihii: (data["nihii"] as String?),
			nihiiSpecCode: (data["nihiiSpecCode"] as String?),
			ssin: (data["ssin"] as String?),
			addresses: (data["addresses"] as List<dynamic>).map((x0) => DecryptedAddress.fromJSON(x0) ).toList(),
			languages: (data["languages"] as List<dynamic>).map((x0) => (x0 as String) ).toList(),
			picture: data["picture"] == null ? null : base64Decode(data["picture"] as String),
			statuses: (data["statuses"] as List<dynamic>).map((x0) => HealthcarePartyStatus.fromJSON(x0) ).toSet(),
			statusHistory: (data["statusHistory"] as List<dynamic>).map((x0) => HealthcarePartyHistoryStatus.fromJSON(x0) ).toList(),
			specialityCodes: (data["specialityCodes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			sendFormats: (data["sendFormats"] as Map<String, dynamic>).map((k0, v0) => MapEntry(TelecomType.fromJSON(k0), (v0 as String))),
			notes: (data["notes"] as String?),
			financialInstitutionInformation: (data["financialInstitutionInformation"] as List<dynamic>).map((x0) => DecryptedFinancialInstitutionInformation.fromJSON(x0) ).toList(),
			descr: (data["descr"] as Map<String, dynamic>?)?.map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			billingType: (data["billingType"] as String?),
			type: (data["type"] as String?),
			contactPerson: (data["contactPerson"] as String?),
			contactPersonHcpId: (data["contactPersonHcpId"] as String?),
			supervisorId: (data["supervisorId"] as String?),
			flatRateTarifications: (data["flatRateTarifications"] as List<dynamic>).map((x0) => DecryptedFlatRateTarification.fromJSON(x0) ).toList(),
			importedData: (data["importedData"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			options: (data["options"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			properties: (data["properties"] as List<dynamic>).map((x0) => DecryptedPropertyStub.fromJSON(x0) ).toSet(),
			hcPartyKeys: (data["hcPartyKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => (x1 as HexString) ).toList())),
			aesExchangeKeys: (data["aesExchangeKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry(CardinalRsaPublicKey.fromSpkiHex(k0), (v0 as Map<String, dynamic>).map((k1, v1) => MapEntry((k1 as String), (v1 as Map<String, dynamic>).map((k2, v2) => MapEntry((k2 as AesExchangeKeyEncryptionKeypairIdentifier), (v2 as HexString))))))),
			transferKeys: (data["transferKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as AesExchangeKeyEncryptionKeypairIdentifier), (v0 as Map<String, dynamic>).map((k1, v1) => MapEntry((k1 as AesExchangeKeyEncryptionKeypairIdentifier), (v1 as HexString))))),
			privateKeyShamirPartitions: (data["privateKeyShamirPartitions"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as HexString))),
			publicKey: data["publicKey"] != null ? CardinalRsaPublicKey.fromSpkiHex(data["publicKey"]!) : null,
			publicKeysForOaepWithSha256: (data["publicKeysForOaepWithSha256"] as List<dynamic>).map((x0) => CardinalRsaPublicKey.fromSpkiHex(x0) ).toSet(),
		);
	}
}