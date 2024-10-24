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
			delegator: data["delegator"],
			delegate: data["delegate"],
			secretIds: data["secretIds"].map((x0) => x0 ).toList(),
			encryptionKeys: data["encryptionKeys"].map((x0) => x0 ).toList(),
			owningEntityIds: data["owningEntityIds"].map((x0) => x0 ).toList(),
			parentDelegations: data["parentDelegations"].map((x0) => x0 ).toList(),
			exchangeDataId: data["exchangeDataId"],
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