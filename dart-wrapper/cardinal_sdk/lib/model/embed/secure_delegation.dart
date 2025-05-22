// auto-generated file
import 'package:cardinal_sdk/model/embed/access_level.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/specializations/secure_delegation_key_string.dart';
part "secure_delegation.freezed.dart";


@freezed
abstract class SecureDelegation with _$SecureDelegation {
	const factory SecureDelegation({
		@Default(null) String? delegator,
		@Default(null) String? delegate,
		@Default({}) Set<Base64String> secretIds,
		@Default({}) Set<Base64String> encryptionKeys,
		@Default({}) Set<Base64String> owningEntityIds,
		@Default({}) Set<SecureDelegationKeyString> parentDelegations,
		@Default(null) String? exchangeDataId,
		required AccessLevel permissions,
	}) = _SecureDelegation;


	static Map<String, dynamic> encode(SecureDelegation value) {
		Map<String, dynamic> entityAsMap = {
			"delegator" : value.delegator,
			"delegate" : value.delegate,
			"secretIds" : value.secretIds.map((x0) => x0).toList(),
			"encryptionKeys" : value.encryptionKeys.map((x0) => x0).toList(),
			"owningEntityIds" : value.owningEntityIds.map((x0) => x0).toList(),
			"parentDelegations" : value.parentDelegations.map((x0) => x0).toList(),
			"exchangeDataId" : value.exchangeDataId,
			"permissions" : AccessLevel.encode(value.permissions)
		};
		return entityAsMap;
	}

	static SecureDelegation fromJSON(Map<String, dynamic> data) {
		return SecureDelegation(
			permissions: AccessLevel.fromJSON(data["permissions"]),
			delegator: (data["delegator"] as String?),
			delegate: (data["delegate"] as String?),
			secretIds: (data["secretIds"] as List<dynamic>).map((x0) => (x0 as Base64String) ).toSet(),
			encryptionKeys: (data["encryptionKeys"] as List<dynamic>).map((x0) => (x0 as Base64String) ).toSet(),
			owningEntityIds: (data["owningEntityIds"] as List<dynamic>).map((x0) => (x0 as Base64String) ).toSet(),
			parentDelegations: (data["parentDelegations"] as List<dynamic>).map((x0) => (x0 as SecureDelegationKeyString) ).toSet(),
			exchangeDataId: (data["exchangeDataId"] as String?),
		);
	}
}