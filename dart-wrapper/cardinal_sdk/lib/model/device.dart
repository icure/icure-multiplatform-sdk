// auto-generated file
import 'package:cardinal_sdk/model/base/identifier.dart';
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'dart:typed_data';
import 'package:cardinal_sdk/model/property_stub.dart';
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/crypto/entities/cardinal_keys.dart';
import 'package:cardinal_sdk/model/specializations/aes_exchange_key_encryption_keypair_identifier.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/icure_document.dart';
import 'package:cardinal_sdk/model/base/named.dart';
import 'package:cardinal_sdk/model/base/crypto_actor.dart';
import 'package:cardinal_sdk/model/base/data_owner.dart';


class Device implements StoredDocument, ICureDocument<String>, Named, CryptoActor, DataOwner {
	@override String id;
	@override String? rev = null;
	@override int? deletionDate = null;
	List<Identifier> identifiers = [];
	@override int? created = null;
	@override int? modified = null;
	@override String? author = null;
	@override String? responsible = null;
	@override Set<CodeStub> tags = {};
	@override Set<CodeStub> codes = {};
	@override int? endOfLife = null;
	@override String? medicalLocationId = null;
	String? externalId = null;
	@override String? name = null;
	String? type = null;
	String? brand = null;
	String? model = null;
	String? serialNumber = null;
	String? parentId = null;
	Uint8List? picture = null;
	@override Set<DecryptedPropertyStub> properties = {};
	@override Map<String, List<HexString>> hcPartyKeys = {};
	@override Map<CardinalRsaPublicKey, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>> aesExchangeKeys = {};
	@override Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>> transferKeys = {};
	@override Map<String, HexString> privateKeyShamirPartitions = {};
	@override CardinalRsaPublicKey? publicKey = null;
	@override Set<CardinalRsaPublicKey> publicKeysForOaepWithSha256 = {};
	Device(
		this.id,
		{
			String? rev,
			int? deletionDate,
			List<Identifier>? identifiers,
			int? created,
			int? modified,
			String? author,
			String? responsible,
			Set<CodeStub>? tags,
			Set<CodeStub>? codes,
			int? endOfLife,
			String? medicalLocationId,
			String? externalId,
			String? name,
			String? type,
			String? brand,
			String? model,
			String? serialNumber,
			String? parentId,
			Uint8List? picture,
			Set<DecryptedPropertyStub>? properties,
			Map<String, List<HexString>>? hcPartyKeys,
			Map<CardinalRsaPublicKey, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>? aesExchangeKeys,
			Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>? transferKeys,
			Map<String, HexString>? privateKeyShamirPartitions,
			CardinalRsaPublicKey? publicKey,
			Set<CardinalRsaPublicKey>? publicKeysForOaepWithSha256
		}) : rev = rev ?? null,
		deletionDate = deletionDate ?? null,
		identifiers = identifiers ?? [],
		created = created ?? null,
		modified = modified ?? null,
		author = author ?? null,
		responsible = responsible ?? null,
		tags = tags ?? {},
		codes = codes ?? {},
		endOfLife = endOfLife ?? null,
		medicalLocationId = medicalLocationId ?? null,
		externalId = externalId ?? null,
		name = name ?? null,
		type = type ?? null,
		brand = brand ?? null,
		model = model ?? null,
		serialNumber = serialNumber ?? null,
		parentId = parentId ?? null,
		picture = picture ?? null,
		properties = properties ?? {},
		hcPartyKeys = hcPartyKeys ?? {},
		aesExchangeKeys = aesExchangeKeys ?? {},
		transferKeys = transferKeys ?? {},
		privateKeyShamirPartitions = privateKeyShamirPartitions ?? {},
		publicKey = publicKey ?? null,
		publicKeysForOaepWithSha256 = publicKeysForOaepWithSha256 ?? {};

	static Map<String, dynamic> encode(Device value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"deletionDate" : value.deletionDate,
			"identifiers" : value.identifiers.map((x0) => Identifier.encode(x0)).toList(),
			"created" : value.created,
			"modified" : value.modified,
			"author" : value.author,
			"responsible" : value.responsible,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)).toList(),
			"endOfLife" : value.endOfLife,
			"medicalLocationId" : value.medicalLocationId,
			"externalId" : value.externalId,
			"name" : value.name,
			"type" : value.type,
			"brand" : value.brand,
			"model" : value.model,
			"serialNumber" : value.serialNumber,
			"parentId" : value.parentId,
			"picture" : value.picture == null ? null : base64Encode(value.picture as List<int>),
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

	static Device fromJSON(Map<String, dynamic> data) {
		return Device(
			(data["id"] as String),
			rev: (data["rev"] as String?),
			deletionDate: (data["deletionDate"] as int?),
			identifiers: (data["identifiers"] as List<dynamic>).map((x0) => Identifier.fromJSON(x0) ).toList(),
			created: (data["created"] as int?),
			modified: (data["modified"] as int?),
			author: (data["author"] as String?),
			responsible: (data["responsible"] as String?),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			endOfLife: (data["endOfLife"] as int?),
			medicalLocationId: (data["medicalLocationId"] as String?),
			externalId: (data["externalId"] as String?),
			name: (data["name"] as String?),
			type: (data["type"] as String?),
			brand: (data["brand"] as String?),
			model: (data["model"] as String?),
			serialNumber: (data["serialNumber"] as String?),
			parentId: (data["parentId"] as String?),
			picture: data["picture"] == null ? null : base64Decode(data["picture"] as String),
			properties: (data["properties"] as List<dynamic>).map((x0) => DecryptedPropertyStub.fromJSON(x0) ).toSet(),
			hcPartyKeys: (data["hcPartyKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => (x1 as HexString) ).toList())),
			aesExchangeKeys: (data["aesExchangeKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry(CardinalRsaPublicKey.fromHex(k0), (v0 as Map<String, dynamic>).map((k1, v1) => MapEntry((k1 as String), (v1 as Map<String, dynamic>).map((k2, v2) => MapEntry((k2 as AesExchangeKeyEncryptionKeypairIdentifier), (v2 as HexString))))))),
			transferKeys: (data["transferKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as AesExchangeKeyEncryptionKeypairIdentifier), (v0 as Map<String, dynamic>).map((k1, v1) => MapEntry((k1 as AesExchangeKeyEncryptionKeypairIdentifier), (v1 as HexString))))),
			privateKeyShamirPartitions: (data["privateKeyShamirPartitions"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as HexString))),
			publicKey: data["publicKey"] != null ? CardinalRsaPublicKey.fromHex(data["publicKey"]!) : null,
			publicKeysForOaepWithSha256: (data["publicKeysForOaepWithSha256"] as List<dynamic>).map((x0) => CardinalRsaPublicKey.fromHex(x0) ).toSet(),
		);
	}
}