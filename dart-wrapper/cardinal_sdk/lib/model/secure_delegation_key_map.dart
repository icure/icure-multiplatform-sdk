// auto-generated file
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

	static SecureDelegationKeyMap fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.EncryptedSecureDelegationKeyMap":
				return EncryptedSecureDelegationKeyMap.fromJSON(data);
			case "com.icure.cardinal.sdk.model.DecryptedSecureDelegationKeyMap":
				return DecryptedSecureDelegationKeyMap.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

class EncryptedSecureDelegationKeyMap implements SecureDelegationKeyMap {
	@override String id;
	@override String? rev = null;
	@override String delegationKey;
	@override String? delegator = null;
	@override String? delegate = null;
	@override Set<String> secretForeignKeys = {};
	@override Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override Map<String, Set<Delegation>> delegations = {};
	@override Map<String, Set<Delegation>> encryptionKeys = {};
	@override Base64String? encryptedSelf = null;
	@override SecurityMetadata? securityMetadata = null;
	@override int? deletionDate = null;
	EncryptedSecureDelegationKeyMap(
		this.id,
		this.delegationKey,
		{
			String? rev,
			String? delegator,
			String? delegate,
			Set<String>? secretForeignKeys,
			Map<String, Set<Delegation>>? cryptedForeignKeys,
			Map<String, Set<Delegation>>? delegations,
			Map<String, Set<Delegation>>? encryptionKeys,
			Base64String? encryptedSelf,
			SecurityMetadata? securityMetadata,
			int? deletionDate
		}) : rev = rev ?? null,
		delegator = delegator ?? null,
		delegate = delegate ?? null,
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {},
		encryptedSelf = encryptedSelf ?? null,
		securityMetadata = securityMetadata ?? null,
		deletionDate = deletionDate ?? null;

	factory EncryptedSecureDelegationKeyMap.fromJSON(Map<String, dynamic> data) {
		return EncryptedSecureDelegationKeyMap(
			(data["id"] as String),
			(data["delegationKey"] as String),
			rev: (data["rev"] as String?),
			delegator: (data["delegator"] as String?),
			delegate: (data["delegate"] as String?),
			secretForeignKeys: (data["secretForeignKeys"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			cryptedForeignKeys: (data["cryptedForeignKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			delegations: (data["delegations"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptionKeys: (data["encryptionKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
			deletionDate: (data["deletionDate"] as int?),
		);
	}

	static Map<String, dynamic> encode(EncryptedSecureDelegationKeyMap value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"delegationKey" : value.delegationKey,
			"delegator" : value.delegator,
			"delegate" : value.delegate,
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0).toList(),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!),
			"deletionDate" : value.deletionDate
		};
		return entityAsMap;
	}
}

class DecryptedSecureDelegationKeyMap implements SecureDelegationKeyMap {
	@override String id;
	@override String? rev = null;
	@override String delegationKey;
	@override String? delegator = null;
	@override String? delegate = null;
	@override Set<String> secretForeignKeys = {};
	@override Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override Map<String, Set<Delegation>> delegations = {};
	@override Map<String, Set<Delegation>> encryptionKeys = {};
	@override Base64String? encryptedSelf = null;
	@override SecurityMetadata? securityMetadata = null;
	@override int? deletionDate = null;
	DecryptedSecureDelegationKeyMap(
		this.id,
		this.delegationKey,
		{
			String? rev,
			String? delegator,
			String? delegate,
			Set<String>? secretForeignKeys,
			Map<String, Set<Delegation>>? cryptedForeignKeys,
			Map<String, Set<Delegation>>? delegations,
			Map<String, Set<Delegation>>? encryptionKeys,
			Base64String? encryptedSelf,
			SecurityMetadata? securityMetadata,
			int? deletionDate
		}) : rev = rev ?? null,
		delegator = delegator ?? null,
		delegate = delegate ?? null,
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {},
		encryptedSelf = encryptedSelf ?? null,
		securityMetadata = securityMetadata ?? null,
		deletionDate = deletionDate ?? null;

	factory DecryptedSecureDelegationKeyMap.fromJSON(Map<String, dynamic> data) {
		return DecryptedSecureDelegationKeyMap(
			(data["id"] as String),
			(data["delegationKey"] as String),
			rev: (data["rev"] as String?),
			delegator: (data["delegator"] as String?),
			delegate: (data["delegate"] as String?),
			secretForeignKeys: (data["secretForeignKeys"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			cryptedForeignKeys: (data["cryptedForeignKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			delegations: (data["delegations"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptionKeys: (data["encryptionKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
			deletionDate: (data["deletionDate"] as int?),
		);
	}

	static Map<String, dynamic> encode(DecryptedSecureDelegationKeyMap value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"delegationKey" : value.delegationKey,
			"delegator" : value.delegator,
			"delegate" : value.delegate,
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0).toList(),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!),
			"deletionDate" : value.deletionDate
		};
		return entityAsMap;
	}
}