// This file is auto-generated
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

	SecureDelegation({
		required this.permissions,
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

	static Map<String, dynamic> encode(SecureDelegation value) {
		Map<String, dynamic> entityAsMap = {
			"delegator" : value.delegator,
			"delegate" : value.delegate,
			"secretIds" : value.secretIds.map((x0) => x0),
			"encryptionKeys" : value.encryptionKeys.map((x0) => x0),
			"owningEntityIds" : value.owningEntityIds.map((x0) => x0),
			"parentDelegations" : value.parentDelegations.map((x0) => x0),
			"exchangeDataId" : value.exchangeDataId,
			"permissions" : AccessLevel.encode(value.permissions)
		};
		return entityAsMap;
	}
}