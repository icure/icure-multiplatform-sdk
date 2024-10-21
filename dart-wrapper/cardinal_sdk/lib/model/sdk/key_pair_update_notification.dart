// This file is auto-generated
import 'package:cardinal_sdk/model/specializations/spki_hex_string.dart';


class KeyPairUpdateNotification {
	SpkiHexString newPublicKey;
	String concernedDataOwnerId;

	KeyPairUpdateNotification({
		required this.newPublicKey,
		required this.concernedDataOwnerId
	});

	static Map<String, dynamic> encode(KeyPairUpdateNotification value) {
		Map<String, dynamic> entityAsMap = {
			"newPublicKey" : value.newPublicKey,
			"concernedDataOwnerId" : value.concernedDataOwnerId
		};
		return entityAsMap;
	}
}