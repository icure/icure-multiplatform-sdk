// auto-generated file
import 'package:cardinal_sdk/model/embed/secure_delegation.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
import 'package:cardinal_sdk/model/specializations/secure_delegation_key_string.dart';
part "security_metadata.freezed.dart";


@freezed
abstract class SecurityMetadata with _$SecurityMetadata {
	const factory SecurityMetadata({
		required Map<SecureDelegationKeyString, SecureDelegation> secureDelegations,
	}) = _SecurityMetadata;


	static Map<String, dynamic> encode(SecurityMetadata value) {
		Map<String, dynamic> entityAsMap = {
			"secureDelegations" : value.secureDelegations.map((k0, v0) => MapEntry(k0, SecureDelegation.encode(v0)))
		};
		return entityAsMap;
	}

	static SecurityMetadata fromJSON(Map<String, dynamic> data) {
		return SecurityMetadata(
			secureDelegations: (data["secureDelegations"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as SecureDelegationKeyString), SecureDelegation.fromJSON(v0)))
		);
	}
}