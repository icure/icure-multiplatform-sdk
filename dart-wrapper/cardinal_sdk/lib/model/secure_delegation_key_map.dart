// This file is auto-generated
import 'package:cardinal_sdk/model/embed/delegation.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/security_metadata.dart';
import 'package:cardinal_sdk/model/secure_delegation_key_map.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/has_encryption_metadata.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';


sealed class SecureDelegationKeyMap implements StoredDocument, HasEncryptionMetadata, Encryptable {
	@override abstract String id;
	@override abstract String? rev;
	abstract String delegationKey;
	abstract String? delegator;
	abstract String? delegate;
	@override abstract Set<String> secretForeignKeys;
	@override abstract Map<String, Set<Delegation>> cryptedForeignKeys;
	@override abstract Map<String, Set<Delegation>> delegations;
	@override abstract Map<String, Set<Delegation>> encryptionKeys;
	@override abstract Base64String? encryptedSelf;
	@override abstract SecurityMetadata? securityMetadata;
	@override abstract int? deletionDate;


	static Map<String, dynamic> encode(SecureDelegationKeyMap value) {
		switch (value) {
			case EncryptedSecureDelegationKeyMap entity:
				Map<String, dynamic> entityJson = EncryptedSecureDelegationKeyMap.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.EncryptedSecureDelegationKeyMap";
				return entityJson;
			case DecryptedSecureDelegationKeyMap entity:
				Map<String, dynamic> entityJson = DecryptedSecureDelegationKeyMap.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DecryptedSecureDelegationKeyMap";
				return entityJson;
		}
	}
}

class EncryptedSecureDelegationKeyMap implements SecureDelegationKeyMap {
	@override  String id;
	@override  String? rev;
	@override  String delegationKey;
	@override  String? delegator;
	@override  String? delegate;
	@override  Set<String> secretForeignKeys = {};
	@override  Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override  Map<String, Set<Delegation>> delegations = {};
	@override  Map<String, Set<Delegation>> encryptionKeys = {};
	@override  Base64String? encryptedSelf;
	@override  SecurityMetadata? securityMetadata;
	@override  int? deletionDate;

	EncryptedSecureDelegationKeyMap({
		required this.id,
		required this.delegationKey,
		this.rev,
		this.delegator,
		this.delegate,
		this.encryptedSelf,
		this.securityMetadata,
		this.deletionDate,
		Set<String>? secretForeignKeys,
		Map<String, Set<Delegation>>? cryptedForeignKeys,
		Map<String, Set<Delegation>>? delegations,
		Map<String, Set<Delegation>>? encryptionKeys
	}) : secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {};

	static Map<String, dynamic> encode(EncryptedSecureDelegationKeyMap value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"delegationKey" : value.delegationKey,
			"delegator" : value.delegator,
			"delegate" : value.delegate,
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!),
			"deletionDate" : value.deletionDate
		};
		return entityAsMap;
	}
}

class DecryptedSecureDelegationKeyMap implements SecureDelegationKeyMap {
	@override  String id;
	@override  String? rev;
	@override  String delegationKey;
	@override  String? delegator;
	@override  String? delegate;
	@override  Set<String> secretForeignKeys = {};
	@override  Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override  Map<String, Set<Delegation>> delegations = {};
	@override  Map<String, Set<Delegation>> encryptionKeys = {};
	@override  Base64String? encryptedSelf;
	@override  SecurityMetadata? securityMetadata;
	@override  int? deletionDate;

	DecryptedSecureDelegationKeyMap({
		required this.id,
		required this.delegationKey,
		this.rev,
		this.delegator,
		this.delegate,
		this.encryptedSelf,
		this.securityMetadata,
		this.deletionDate,
		Set<String>? secretForeignKeys,
		Map<String, Set<Delegation>>? cryptedForeignKeys,
		Map<String, Set<Delegation>>? delegations,
		Map<String, Set<Delegation>>? encryptionKeys
	}) : secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {};

	static Map<String, dynamic> encode(DecryptedSecureDelegationKeyMap value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"delegationKey" : value.delegationKey,
			"delegator" : value.delegator,
			"delegate" : value.delegate,
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!),
			"deletionDate" : value.deletionDate
		};
		return entityAsMap;
	}
}