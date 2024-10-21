// This file is auto-generated
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
import 'package:cardinal_sdk/model/specializations/spki_hex_string.dart';
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
	@override  String id;
	@override  String? rev;
	int? created;
	int? modified;
	@override  int? deletionDate;
	List<Identifier> identifier = [];
	@override  Set<CodeStub> tags = {};
	@override  Set<CodeStub> codes = {};
	@override  String? name;
	@override  String? lastName;
	@override  String? firstName;
	@override  List<PersonName> names = [];
	@override  Gender? gender;
	@override  String? civility;
	@override  String? companyName;
	String? speciality;
	String? bankAccount;
	String? bic;
	String? proxyBankAccount;
	String? proxyBic;
	String? invoiceHeader;
	String? cbe;
	String? ehp;
	String? userId;
	String? parentId;
	int? _convention;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") int? get convention => _convention;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") set convention(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('convention value cannot exceed 2147483647');
		}
		_convention = value;
	}
	String? nihii;
	String? nihiiSpecCode;
	String? ssin;
	@override  List<DecryptedAddress> addresses = [];
	@override  List<String> languages = [];
	Uint8List? picture;
	Set<HealthcarePartyStatus> statuses = {};
	List<HealthcarePartyHistoryStatus> statusHistory = [];
	Set<CodeStub> specialityCodes = {};
	Map<TelecomType, String> sendFormats = {};
	String? notes;
	List<DecryptedFinancialInstitutionInformation> financialInstitutionInformation = [];
	Map<String, String>? descr = {};
	String? billingType;
	String? type;
	String? contactPerson;
	String? contactPersonHcpId;
	String? supervisorId;
	List<DecryptedFlatRateTarification> flatRateTarifications = [];
	Map<String, String> importedData = {};
	@Deprecated('Use properties instead')  Map<String, String> options = {};
	@override  Set<DecryptedPropertyStub> properties = {};
	@override  Map<String, List<HexString>> hcPartyKeys = {};
	@override  Map<SpkiHexString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>> aesExchangeKeys = {};
	@override  Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>> transferKeys = {};
	@override  Map<String, HexString> privateKeyShamirPartitions = {};
	@override  SpkiHexString? publicKey;
	@override  Set<SpkiHexString> publicKeysForOaepWithSha256 = {};

	HealthcareParty({
		required this.id,
		int? convention,
		this.rev,
		this.created,
		this.modified,
		this.deletionDate,
		this.name,
		this.lastName,
		this.firstName,
		this.gender,
		this.civility,
		this.companyName,
		this.speciality,
		this.bankAccount,
		this.bic,
		this.proxyBankAccount,
		this.proxyBic,
		this.invoiceHeader,
		this.cbe,
		this.ehp,
		this.userId,
		this.parentId,
		this.nihii,
		this.nihiiSpecCode,
		this.ssin,
		this.picture,
		this.notes,
		this.billingType,
		this.type,
		this.contactPerson,
		this.contactPersonHcpId,
		this.supervisorId,
		this.publicKey,
		List<Identifier>? identifier,
		Set<CodeStub>? tags,
		Set<CodeStub>? codes,
		List<PersonName>? names,
		List<DecryptedAddress>? addresses,
		List<String>? languages,
		Set<HealthcarePartyStatus>? statuses,
		List<HealthcarePartyHistoryStatus>? statusHistory,
		Set<CodeStub>? specialityCodes,
		Map<TelecomType, String>? sendFormats,
		List<DecryptedFinancialInstitutionInformation>? financialInstitutionInformation,
		Map<String, String>? descr,
		List<DecryptedFlatRateTarification>? flatRateTarifications,
		Map<String, String>? importedData,
		Map<String, String>? options,
		Set<DecryptedPropertyStub>? properties,
		Map<String, List<HexString>>? hcPartyKeys,
		Map<SpkiHexString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>? aesExchangeKeys,
		Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>? transferKeys,
		Map<String, HexString>? privateKeyShamirPartitions,
		Set<SpkiHexString>? publicKeysForOaepWithSha256
	}) : identifier = identifier ?? [],
		tags = tags ?? {},
		codes = codes ?? {},
		names = names ?? [],
		addresses = addresses ?? [],
		languages = languages ?? [],
		statuses = statuses ?? {},
		statusHistory = statusHistory ?? [],
		specialityCodes = specialityCodes ?? {},
		sendFormats = sendFormats ?? {},
		financialInstitutionInformation = financialInstitutionInformation ?? [],
		descr = descr ?? {},
		flatRateTarifications = flatRateTarifications ?? [],
		importedData = importedData ?? {},
		options = options ?? {},
		properties = properties ?? {},
		hcPartyKeys = hcPartyKeys ?? {},
		aesExchangeKeys = aesExchangeKeys ?? {},
		transferKeys = transferKeys ?? {},
		privateKeyShamirPartitions = privateKeyShamirPartitions ?? {},
		publicKeysForOaepWithSha256 = publicKeysForOaepWithSha256 ?? {},
		_convention = convention;

	static Map<String, dynamic> encode(HealthcareParty value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"created" : value.created,
			"modified" : value.modified,
			"deletionDate" : value.deletionDate,
			"identifier" : value.identifier.map((x0) => Identifier.encode(x0)),
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)),
			"name" : value.name,
			"lastName" : value.lastName,
			"firstName" : value.firstName,
			"names" : value.names.map((x0) => PersonName.encode(x0)),
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
			"addresses" : value.addresses.map((x0) => DecryptedAddress.encode(x0)),
			"languages" : value.languages.map((x0) => x0),
			"picture" : value.picture == null ? null : base64Encode(value.picture as List<int>),
			"statuses" : value.statuses.map((x0) => HealthcarePartyStatus.encode(x0)),
			"statusHistory" : value.statusHistory.map((x0) => HealthcarePartyHistoryStatus.encode(x0)),
			"specialityCodes" : value.specialityCodes.map((x0) => CodeStub.encode(x0)),
			"sendFormats" : value.sendFormats.map((k0, v0) => MapEntry(TelecomType.encode(k0), v0)),
			"notes" : value.notes,
			"financialInstitutionInformation" : value.financialInstitutionInformation.map((x0) => DecryptedFinancialInstitutionInformation.encode(x0)),
			"descr" : value.descr?.map((k0, v0) => MapEntry(k0, v0)),
			"billingType" : value.billingType,
			"type" : value.type,
			"contactPerson" : value.contactPerson,
			"contactPersonHcpId" : value.contactPersonHcpId,
			"supervisorId" : value.supervisorId,
			"flatRateTarifications" : value.flatRateTarifications.map((x0) => DecryptedFlatRateTarification.encode(x0)),
			"importedData" : value.importedData.map((k0, v0) => MapEntry(k0, v0)),
			"options" : value.options.map((k0, v0) => MapEntry(k0, v0)),
			"properties" : value.properties.map((x0) => DecryptedPropertyStub.encode(x0)),
			"hcPartyKeys" : value.hcPartyKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => x1))),
			"aesExchangeKeys" : value.aesExchangeKeys.map((k0, v0) => MapEntry(k0, v0.map((k1, v1) => MapEntry(k1, v1.map((k2, v2) => MapEntry(k2, v2)))))),
			"transferKeys" : value.transferKeys.map((k0, v0) => MapEntry(k0, v0.map((k1, v1) => MapEntry(k1, v1)))),
			"privateKeyShamirPartitions" : value.privateKeyShamirPartitions.map((k0, v0) => MapEntry(k0, v0)),
			"publicKey" : value.publicKey,
			"publicKeysForOaepWithSha256" : value.publicKeysForOaepWithSha256.map((x0) => x0)
		};
		return entityAsMap;
	}
}