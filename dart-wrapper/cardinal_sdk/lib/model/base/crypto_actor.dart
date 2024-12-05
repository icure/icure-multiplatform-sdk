// auto-generated file
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/crypto/cardinal_keys.dart';
import 'package:cardinal_sdk/model/specializations/aes_exchange_key_encryption_keypair_identifier.dart';
import 'package:cardinal_sdk/model/crypto_actor_stub.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/device.dart';
import 'package:cardinal_sdk/model/healthcare_party.dart';
import 'package:cardinal_sdk/model/base/versionable.dart';
import 'package:cardinal_sdk/model/base/has_tags.dart';


abstract interface class CryptoActor implements Versionable<String>, HasTags {
	abstract Map<String, List<HexString>> hcPartyKeys;
	abstract Map<CardinalRsaPublicKey, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>> aesExchangeKeys;
	abstract Map<AesExchangeKeyEncryptionKeypairIdentifier, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>> transferKeys;
	abstract Map<String, HexString> privateKeyShamirPartitions;
	abstract CardinalRsaPublicKey? publicKey;
	abstract Set<CardinalRsaPublicKey> publicKeysForOaepWithSha256;

	static Map<String, dynamic> encode(CryptoActor value) {
		switch (value) {
			case CryptoActorStub entity:
				Map<String, dynamic> entityJson = CryptoActorStub.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.CryptoActorStub";
				return entityJson;
			case EncryptedPatient entity:
				Map<String, dynamic> entityJson = EncryptedPatient.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.EncryptedPatient";
				return entityJson;
			case DecryptedPatient entity:
				Map<String, dynamic> entityJson = DecryptedPatient.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DecryptedPatient";
				return entityJson;
			case Device entity:
				Map<String, dynamic> entityJson = Device.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.Device";
				return entityJson;
			case HealthcareParty entity:
				Map<String, dynamic> entityJson = HealthcareParty.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.HealthcareParty";
				return entityJson;
			default:
				throw ArgumentError('Invalid subclass $value');
		}
	}

	static CryptoActor fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.CryptoActorStub":
				return CryptoActorStub.fromJSON(data);
			case "com.icure.cardinal.sdk.model.EncryptedPatient":
				return EncryptedPatient.fromJSON(data);
			case "com.icure.cardinal.sdk.model.DecryptedPatient":
				return DecryptedPatient.fromJSON(data);
			case "com.icure.cardinal.sdk.model.Device":
				return Device.fromJSON(data);
			case "com.icure.cardinal.sdk.model.HealthcareParty":
				return HealthcareParty.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}