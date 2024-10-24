// auto-generated file
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/specializations/secure_delegation_key_string.dart';
import 'package:cardinal_sdk/model/embed/access_level.dart';


class SecureDelegation {
	String? delegator;
	String? delegate;
	Set<Base64String> secretIds = {};
	Set<Base64String> encryptionKeys = {};
	Set<Base64String> owningEntityIds = {};
	Set<SecureDelegationKeyString> parentDelegations = {};
	String? exchangeDataId;
	AccessLevel permissions;
	SecureDelegation(
		this.permissions,
		{
			this.delegator,
			this.delegate,
			this.exchangeDataId,
			Set<Base64String>? secretIds,
			Set<Base64String>? encryptionKeys,
			Set<Base64String>? owningEntityIds,
			Set<SecureDelegationKeyString>? parentDelegations
		}) : secretIds = secretIds ?? {},
		encryptionKeys = encryptionKeys ?? {},
		owningEntityIds = owningEntityIds ?? {},
		parentDelegations = parentDelegations ?? {};

	factory SecureDelegation.fromJSON(Map<String, dynamic> data) {
		return SecureDelegation(
			AccessLevel.fromJSON(data["permissions"]),
			delegator: (data["delegator"] as String?),
			delegate: (data["delegate"] as String?),
			secretIds: (data["secretIds"] as List<dynamic>).map((x0) => (x0 as Base64String) ).toSet(),
			encryptionKeys: (data["encryptionKeys"] as List<dynamic>).map((x0) => (x0 as Base64String) ).toSet(),
			owningEntityIds: (data["owningEntityIds"] as List<dynamic>).map((x0) => (x0 as Base64String) ).toSet(),
			parentDelegations: (data["parentDelegations"] as List<dynamic>).map((x0) => (x0 as SecureDelegationKeyString) ).toSet(),
			exchangeDataId: (data["exchangeDataId"] as String?),
		);
	}

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
}