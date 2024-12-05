// auto-generated file
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/crypto/cardinal_keys.dart';
import 'package:cardinal_sdk/model/specializations/aes_exchange_key_encryption_keypair_identifier.dart';
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/base/versionable.dart';
import 'package:cardinal_sdk/model/base/crypto_actor.dart';
import 'package:cardinal_sdk/model/base/has_tags.dart';


class CryptoActorStub implements Versionable<String>, CryptoActor, HasTags {
	@override String id;
	@override String rev;
	@override Map<String, List<HexString>> hcPartyKeys = {};
	@override Map<CardinalRsaPublicKey, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>> aesExchangeKeys = {};
	@override Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>> transferKeys = {};
	@override Map<String, HexString> privateKeyShamirPartitions = {};
	@override CardinalRsaPublicKey? publicKey = null;
	@override Set<CardinalRsaPublicKey> publicKeysForOaepWithSha256;
	@override Set<CodeStub> tags = {};
	CryptoActorStub(
		this.id,
		this.rev,
		this.publicKeysForOaepWithSha256,
		{
			Map<String, List<HexString>>? hcPartyKeys,
			Map<CardinalRsaPublicKey, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>? aesExchangeKeys,
			Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>? transferKeys,
			Map<String, HexString>? privateKeyShamirPartitions,
			CardinalRsaPublicKey? publicKey,
			Set<CodeStub>? tags
		}) : hcPartyKeys = hcPartyKeys ?? {},
		aesExchangeKeys = aesExchangeKeys ?? {},
		transferKeys = transferKeys ?? {},
		privateKeyShamirPartitions = privateKeyShamirPartitions ?? {},
		publicKey = publicKey ?? null,
		tags = tags ?? {};

	static Map<String, dynamic> encode(CryptoActorStub value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"hcPartyKeys" : value.hcPartyKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => x1).toList())),
			"aesExchangeKeys" : value.aesExchangeKeys.map((k0, v0) => MapEntry(k0.spkiHex, v0.map((k1, v1) => MapEntry(k1, v1.map((k2, v2) => MapEntry(k2, v2)))))),
			"transferKeys" : value.transferKeys.map((k0, v0) => MapEntry(k0, v0.map((k1, v1) => MapEntry(k1, v1)))),
			"privateKeyShamirPartitions" : value.privateKeyShamirPartitions.map((k0, v0) => MapEntry(k0, v0)),
			"publicKey" : value.publicKey?.spkiHex,
			"publicKeysForOaepWithSha256" : value.publicKeysForOaepWithSha256.map((x0) => x0.spkiHex).toList(),
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList()
		};
		return entityAsMap;
	}

	static CryptoActorStub fromJSON(Map<String, dynamic> data) {
		return CryptoActorStub(
			(data["id"] as String),
			(data["rev"] as String),
			(data["publicKeysForOaepWithSha256"] as List<dynamic>).map((x0) => CardinalRsaPublicKey.fromHex(x0) ).toSet(),
			hcPartyKeys: (data["hcPartyKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => (x1 as HexString) ).toList())),
			aesExchangeKeys: (data["aesExchangeKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry(CardinalRsaPublicKey.fromHex(k0), (v0 as Map<String, dynamic>).map((k1, v1) => MapEntry((k1 as String), (v1 as Map<String, dynamic>).map((k2, v2) => MapEntry((k2 as AesExchangeKeyEncryptionKeypairIdentifier), (v2 as HexString))))))),
			transferKeys: (data["transferKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as AesExchangeKeyEncryptionKeypairIdentifier), (v0 as Map<String, dynamic>).map((k1, v1) => MapEntry((k1 as AesExchangeKeyEncryptionKeypairIdentifier), (v1 as HexString))))),
			privateKeyShamirPartitions: (data["privateKeyShamirPartitions"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as HexString))),
			publicKey: data["publicKey"] != null ? CardinalRsaPublicKey.fromHex(data["publicKey"]!) : null,
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
		);
	}
}