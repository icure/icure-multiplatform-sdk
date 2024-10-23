// auto-generated file
import 'package:cardinal_sdk/model/base/identifier.dart';
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'dart:typed_data';
import 'package:cardinal_sdk/model/property_stub.dart';
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/model/specializations/spki_hex_string.dart';
import 'package:cardinal_sdk/model/specializations/aes_exchange_key_encryption_keypair_identifier.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/icure_document.dart';
import 'package:cardinal_sdk/model/base/named.dart';
import 'package:cardinal_sdk/model/base/crypto_actor.dart';
import 'package:cardinal_sdk/model/base/data_owner.dart';


class Device implements StoredDocument, ICureDocument<String>, Named, CryptoActor, DataOwner {
	@override String id;
	@override String? rev;
	@override int? deletionDate;
	List<Identifier> identifiers = [];
	@override int? created;
	@override int? modified;
	@override String? author;
	@override String? responsible;
	@override Set<CodeStub> tags = {};
	@override Set<CodeStub> codes = {};
	@override int? endOfLife;
	@override String? medicalLocationId;
	String? externalId;
	@override String? name;
	String? type;
	String? brand;
	String? model;
	String? serialNumber;
	String? parentId;
	Uint8List? picture;
	@override Set<DecryptedPropertyStub> properties = {};
	@override Map<String, List<HexString>> hcPartyKeys = {};
	@override Map<SpkiHexString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>> aesExchangeKeys = {};
	@override Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>> transferKeys = {};
	@override Map<String, HexString> privateKeyShamirPartitions = {};
	@override SpkiHexString? publicKey;
	@override Set<SpkiHexString> publicKeysForOaepWithSha256 = {};
	Device(
		this.id,
		{
			this.rev,
			this.deletionDate,
			this.created,
			this.modified,
			this.author,
			this.responsible,
			this.endOfLife,
			this.medicalLocationId,
			this.externalId,
			this.name,
			this.type,
			this.brand,
			this.model,
			this.serialNumber,
			this.parentId,
			this.picture,
			this.publicKey,
			List<Identifier>? identifiers,
			Set<CodeStub>? tags,
			Set<CodeStub>? codes,
			Set<DecryptedPropertyStub>? properties,
			Map<String, List<HexString>>? hcPartyKeys,
			Map<SpkiHexString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>? aesExchangeKeys,
			Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>? transferKeys,
			Map<String, HexString>? privateKeyShamirPartitions,
			Set<SpkiHexString>? publicKeysForOaepWithSha256
		}) : identifiers = identifiers ?? [],
		tags = tags ?? {},
		codes = codes ?? {},
		properties = properties ?? {},
		hcPartyKeys = hcPartyKeys ?? {},
		aesExchangeKeys = aesExchangeKeys ?? {},
		transferKeys = transferKeys ?? {},
		privateKeyShamirPartitions = privateKeyShamirPartitions ?? {},
		publicKeysForOaepWithSha256 = publicKeysForOaepWithSha256 ?? {};

	factory Device.fromJSON(Map<String, dynamic> data) {
		return Device(
			data["id"],
			rev: data["rev"],
			deletionDate: data["deletionDate"],
			identifiers: data["identifiers"].map((x0) => Identifier.fromJSON(x0) ),
			created: data["created"],
			modified: data["modified"],
			author: data["author"],
			responsible: data["responsible"],
			tags: data["tags"].map((x0) => CodeStub.fromJSON(x0) ),
			codes: data["codes"].map((x0) => CodeStub.fromJSON(x0) ),
			endOfLife: data["endOfLife"],
			medicalLocationId: data["medicalLocationId"],
			externalId: data["externalId"],
			name: data["name"],
			type: data["type"],
			brand: data["brand"],
			model: data["model"],
			serialNumber: data["serialNumber"],
			parentId: data["parentId"],
			picture: data["picture"] == null ? null : base64Decode(data["picture"] as String),
			properties: data["properties"].map((x0) => DecryptedPropertyStub.fromJSON(x0) ),
			hcPartyKeys: data["hcPartyKeys"].map((k0, v0) => MapEntry(k0, v0.map((x1) => x1 ))),
			aesExchangeKeys: data["aesExchangeKeys"].map((k0, v0) => MapEntry(k0, v0.map((k1, v1) => MapEntry(k1, v1.map((k2, v2) => MapEntry(k2, v2)))))),
			transferKeys: data["transferKeys"].map((k0, v0) => MapEntry(k0, v0.map((k1, v1) => MapEntry(k1, v1)))),
			privateKeyShamirPartitions: data["privateKeyShamirPartitions"].map((k0, v0) => MapEntry(k0, v0)),
			publicKey: data["publicKey"],
			publicKeysForOaepWithSha256: data["publicKeysForOaepWithSha256"].map((x0) => x0 ),
		);
	}

	static Map<String, dynamic> encode(Device value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"deletionDate" : value.deletionDate,
			"identifiers" : value.identifiers.map((x0) => Identifier.encode(x0)),
			"created" : value.created,
			"modified" : value.modified,
			"author" : value.author,
			"responsible" : value.responsible,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)),
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