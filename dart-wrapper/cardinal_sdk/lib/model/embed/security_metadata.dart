// auto-generated file
import 'package:cardinal_sdk/model/specializations/secure_delegation_key_string.dart';
import 'package:cardinal_sdk/model/embed/secure_delegation.dart';
import 'package:cardinal_sdk/model/specializations/sha256hex_string.dart';


class SecurityMetadata {
	Map<SecureDelegationKeyString, SecureDelegation> secureDelegations;
	Map<Sha256HexString, Sha256HexString> keysEquivalences = {};
	SecurityMetadata(
		this.secureDelegations,
		{
			Map<Sha256HexString, Sha256HexString>? keysEquivalences
		}) : keysEquivalences = keysEquivalences ?? {};

	factory SecurityMetadata.fromJSON(Map<String, dynamic> data) {
		return SecurityMetadata(
			data["secureDelegations"].map((k0, v0) => MapEntry(k0, SecureDelegation.fromJSON(v0))),
			keysEquivalences: data["keysEquivalences"].map((k0, v0) => MapEntry(k0, v0)),
		);
	}

	static Map<String, dynamic> encode(SecurityMetadata value) {
		Map<String, dynamic> entityAsMap = {
			"secureDelegations" : value.secureDelegations.map((k0, v0) => MapEntry(k0, SecureDelegation.encode(v0))),
			"keysEquivalences" : value.keysEquivalences.map((k0, v0) => MapEntry(k0, v0))
		};
		return entityAsMap;
	}
}