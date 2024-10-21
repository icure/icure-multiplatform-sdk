// This file is auto-generated
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/model/specializations/spki_hex_string.dart';
import 'package:cardinal_sdk/model/specializations/aes_exchange_key_encryption_keypair_identifier.dart';
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/base/versionable.dart';
import 'package:cardinal_sdk/model/base/crypto_actor.dart';
import 'package:cardinal_sdk/model/base/has_tags.dart';


class CryptoActorStub implements Versionable<String>, CryptoActor, HasTags {
	@override  String id;
	@override  String rev;
	@override  Map<String, List<HexString>> hcPartyKeys = {};
	@override  Map<SpkiHexString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>> aesExchangeKeys = {};
	@override  Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>> transferKeys = {};
	@override  Map<String, HexString> privateKeyShamirPartitions = {};
	@override  SpkiHexString? publicKey;
	@override  Set<SpkiHexString> publicKeysForOaepWithSha256;
	@override  Set<CodeStub> tags = {};

	CryptoActorStub({
		required this.id,
		required this.rev,
		required this.publicKeysForOaepWithSha256,
		this.publicKey,
		Map<String, List<HexString>>? hcPartyKeys,
		Map<SpkiHexString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>? aesExchangeKeys,
		Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>? transferKeys,
		Map<String, HexString>? privateKeyShamirPartitions,
		Set<CodeStub>? tags
	}) : hcPartyKeys = hcPartyKeys ?? {},
		aesExchangeKeys = aesExchangeKeys ?? {},
		transferKeys = transferKeys ?? {},
		privateKeyShamirPartitions = privateKeyShamirPartitions ?? {},
		tags = tags ?? {};

	static Map<String, dynamic> encode(CryptoActorStub value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"hcPartyKeys" : value.hcPartyKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => x1))),
			"aesExchangeKeys" : value.aesExchangeKeys.map((k0, v0) => MapEntry(k0, v0.map((k1, v1) => MapEntry(k1, v1.map((k2, v2) => MapEntry(k2, v2)))))),
			"transferKeys" : value.transferKeys.map((k0, v0) => MapEntry(k0, v0.map((k1, v1) => MapEntry(k1, v1)))),
			"privateKeyShamirPartitions" : value.privateKeyShamirPartitions.map((k0, v0) => MapEntry(k0, v0)),
			"publicKey" : value.publicKey,
			"publicKeysForOaepWithSha256" : value.publicKeysForOaepWithSha256.map((x0) => x0),
			"tags" : value.tags.map((x0) => CodeStub.encode(x0))
		};
		return entityAsMap;
	}
}