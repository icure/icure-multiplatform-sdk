// auto-generated file
import 'package:cardinal_sdk/model/specializations/spki_hex_string.dart';


class KeyPairUpdateNotification {
	SpkiHexString newPublicKey;
	String concernedDataOwnerId;
	KeyPairUpdateNotification(
		this.newPublicKey,
		this.concernedDataOwnerId
		);

	factory KeyPairUpdateNotification.fromJSON(Map<String, dynamic> data) {
		return KeyPairUpdateNotification(
			data["newPublicKey"],
			data["concernedDataOwnerId"]
		);
	}

	static Map<String, dynamic> encode(KeyPairUpdateNotification value) {
		Map<String, dynamic> entityAsMap = {
			"newPublicKey" : value.newPublicKey,
			"concernedDataOwnerId" : value.concernedDataOwnerId
		};
		return entityAsMap;
	}
}