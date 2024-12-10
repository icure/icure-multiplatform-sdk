// auto-generated file
import 'package:cardinal_sdk/crypto/entities/cardinal_keys.dart';


class KeyPairUpdateNotification {
	CardinalRsaPublicKey newPublicKey;
	String concernedDataOwnerId;
	KeyPairUpdateNotification(
		this.newPublicKey,
		this.concernedDataOwnerId
		);

	static Map<String, dynamic> encode(KeyPairUpdateNotification value) {
		Map<String, dynamic> entityAsMap = {
			"newPublicKey" : value.newPublicKey.spkiHex,
			"concernedDataOwnerId" : value.concernedDataOwnerId
		};
		return entityAsMap;
	}

	static KeyPairUpdateNotification fromJSON(Map<String, dynamic> data) {
		return KeyPairUpdateNotification(
			CardinalRsaPublicKey.fromSpkiHex(data["newPublicKey"]),
			(data["concernedDataOwnerId"] as String)
		);
	}
}