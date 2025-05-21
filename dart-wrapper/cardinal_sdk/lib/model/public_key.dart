// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "public_key.freezed.dart";


@freezed
abstract class PublicKey with _$PublicKey {
	const factory PublicKey({
		@Default(null) String? hcPartyId,
		@Default(null) String? hexString,
	}) = _PublicKey;


	static Map<String, dynamic> encode(PublicKey value) {
		Map<String, dynamic> entityAsMap = {
			"hcPartyId" : value.hcPartyId,
			"hexString" : value.hexString
		};
		return entityAsMap;
	}

	static PublicKey fromJSON(Map<String, dynamic> data) {
		return PublicKey(
			hcPartyId: (data["hcPartyId"] as String?),
			hexString: (data["hexString"] as String?)
		);
	}
}