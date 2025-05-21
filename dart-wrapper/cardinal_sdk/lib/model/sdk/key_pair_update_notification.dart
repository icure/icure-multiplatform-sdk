// auto-generated file
import 'package:cardinal_sdk/crypto/entities/cardinal_keys.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "key_pair_update_notification.freezed.dart";


@freezed
abstract class KeyPairUpdateNotification with _$KeyPairUpdateNotification {
	const factory KeyPairUpdateNotification({
		required CardinalRsaPublicKey newPublicKey,
		required String concernedDataOwnerId,
	}) = _KeyPairUpdateNotification;


	static Map<String, dynamic> encode(KeyPairUpdateNotification value) {
		Map<String, dynamic> entityAsMap = {
			"newPublicKey" : value.newPublicKey.spkiHex,
			"concernedDataOwnerId" : value.concernedDataOwnerId
		};
		return entityAsMap;
	}

	static KeyPairUpdateNotification fromJSON(Map<String, dynamic> data) {
		return KeyPairUpdateNotification(
			newPublicKey: CardinalRsaPublicKey.fromSpkiHex(data["newPublicKey"]),
			concernedDataOwnerId: (data["concernedDataOwnerId"] as String)
		);
	}
}