// auto-generated file
import 'package:cardinal_sdk/model/base/identifier.dart';
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/property_stub.dart';
import 'package:cardinal_sdk/crypto/entities/cardinal_keys.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/icure_document.dart';
import 'package:cardinal_sdk/model/base/named.dart';
import 'package:cardinal_sdk/model/base/crypto_actor.dart';
import 'package:cardinal_sdk/model/base/data_owner.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
import 'dart:typed_data';
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/model/specializations/aes_exchange_key_entry_key_string.dart';
import 'package:cardinal_sdk/model/specializations/aes_exchange_key_encryption_keypair_identifier.dart';
part "device.freezed.dart";


@freezed
abstract class Device with _$Device implements StoredDocument, ICureDocument<String>, Named, CryptoActor, DataOwner {
	const factory Device({
		required String id,
		@Default(null) String? rev,
		@Default(null) int? deletionDate,
		@Default([]) List<Identifier> identifiers,
		@Default(null) int? created,
		@Default(null) int? modified,
		@Default(null) String? author,
		@Default(null) String? responsible,
		@Default({}) Set<CodeStub> tags,
		@Default({}) Set<CodeStub> codes,
		@Default(null) int? endOfLife,
		@Default(null) String? medicalLocationId,
		@Default(null) String? externalId,
		@Default(null) String? name,
		@Default(null) String? type,
		@Default(null) String? brand,
		@Default(null) String? model,
		@Default(null) String? serialNumber,
		@Default(null) String? parentId,
		@Default(null) Uint8List? picture,
		@Default({}) Set<DecryptedPropertyStub> properties,
		@Default({}) Map<String, List<HexString>> hcPartyKeys,
		@Default({}) Map<AesExchangeKeyEntryKeyString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>> aesExchangeKeys,
		@Default({}) Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>> transferKeys,
		@Default({}) Map<String, HexString> privateKeyShamirPartitions,
		@Default(null) CardinalRsaPublicKey? publicKey,
		@Default({}) Set<CardinalRsaPublicKey> publicKeysForOaepWithSha256,
		@Default(null) Set<DecryptedPropertyStub>? cryptoActorProperties,
	}) = _Device;


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
			"aesExchangeKeys" : value.aesExchangeKeys.map((k0, v0) => MapEntry(k0, v0.map((k1, v1) => MapEntry(k1, v1.map((k2, v2) => MapEntry(k2, v2)))))),
			"transferKeys" : value.transferKeys.map((k0, v0) => MapEntry(k0, v0.map((k1, v1) => MapEntry(k1, v1)))),
			"privateKeyShamirPartitions" : value.privateKeyShamirPartitions.map((k0, v0) => MapEntry(k0, v0)),
			"publicKey" : value.publicKey?.spkiHex,
			"publicKeysForOaepWithSha256" : value.publicKeysForOaepWithSha256.map((x0) => x0.spkiHex).toList(),
			"cryptoActorProperties" : value.cryptoActorProperties?.map((x0) => DecryptedPropertyStub.encode(x0)).toList()
		};
		return entityAsMap;
	}

	static Device fromJSON(Map<String, dynamic> data) {
		return Device(
			id: (data["id"] as String),
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
			aesExchangeKeys: (data["aesExchangeKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as AesExchangeKeyEntryKeyString), (v0 as Map<String, dynamic>).map((k1, v1) => MapEntry((k1 as String), (v1 as Map<String, dynamic>).map((k2, v2) => MapEntry((k2 as AesExchangeKeyEncryptionKeypairIdentifier), (v2 as HexString))))))),
			transferKeys: (data["transferKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as AesExchangeKeyEncryptionKeypairIdentifier), (v0 as Map<String, dynamic>).map((k1, v1) => MapEntry((k1 as AesExchangeKeyEncryptionKeypairIdentifier), (v1 as HexString))))),
			privateKeyShamirPartitions: (data["privateKeyShamirPartitions"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as HexString))),
			publicKey: data["publicKey"] != null ? CardinalRsaPublicKey.fromSpkiHex(data["publicKey"]!) : null,
			publicKeysForOaepWithSha256: (data["publicKeysForOaepWithSha256"] as List<dynamic>).map((x0) => CardinalRsaPublicKey.fromSpkiHex(x0) ).toSet(),
			cryptoActorProperties: (data["cryptoActorProperties"] as List<dynamic>?)?.map((x0) => DecryptedPropertyStub.fromJSON(x0) ).toSet(),
		);
	}
}