// This file is auto-generated
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/model/specializations/spki_hex_string.dart';
import 'package:cardinal_sdk/model/specializations/aes_exchange_key_encryption_keypair_identifier.dart';
import 'package:cardinal_sdk/model/base/versionable.dart';
import 'package:cardinal_sdk/model/base/has_tags.dart';


abstract interface class CryptoActor implements Versionable<String>, HasTags {
	abstract Map<String, List<HexString>> hcPartyKeys;
	abstract Map<SpkiHexString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>> aesExchangeKeys;
	abstract Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>> transferKeys;
	abstract Map<String, HexString> privateKeyShamirPartitions;
	abstract SpkiHexString? publicKey;
	abstract Set<SpkiHexString> publicKeysForOaepWithSha256;

}