// auto-generated file
import 'package:cardinal_sdk/model/embed/delegation.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/security_metadata.dart';
import 'package:cardinal_sdk/model/secure_delegation_key_map.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/has_encryption_metadata.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "secure_delegation_key_map.freezed.dart";


sealed class SecureDelegationKeyMap implements StoredDocument, HasEncryptionMetadata, Encryptable {
	@override abstract final String id;
	@override abstract final String? rev;
	abstract final String delegationKey;
	abstract final String? delegator;
	abstract final String? delegate;
	@override abstract final Set<String> secretForeignKeys;
	@override abstract final Map<String, Set<Delegation>> cryptedForeignKeys;
	@override abstract final Map<String, Set<Delegation>> delegations;
	@override abstract final Map<String, Set<Delegation>> encryptionKeys;
	@override abstract final Base64String? encryptedSelf;
	@override abstract final SecurityMetadata? securityMetadata;
	@override abstract final int? deletionDate;

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

@freezed
abstract class EncryptedSecureDelegationKeyMap with _$EncryptedSecureDelegationKeyMap implements SecureDelegationKeyMap {
	const factory EncryptedSecureDelegationKeyMap({
		required String id,
		@Default(null) String? rev,
		required String delegationKey,
		@Default(null) String? delegator,
		@Default(null) String? delegate,
		@Default({}) Set<String> secretForeignKeys,
		@Default({}) Map<String, Set<Delegation>> cryptedForeignKeys,
		@Default({}) Map<String, Set<Delegation>> delegations,
		@Default({}) Map<String, Set<Delegation>> encryptionKeys,
		@Default(null) Base64String? encryptedSelf,
		@Default(null) SecurityMetadata? securityMetadata,
		@Default(null) int? deletionDate,
	}) = _EncryptedSecureDelegationKeyMap;


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

	static EncryptedSecureDelegationKeyMap fromJSON(Map<String, dynamic> data) {
		return EncryptedSecureDelegationKeyMap(
			id: (data["id"] as String),
			delegationKey: (data["delegationKey"] as String),
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
}

@freezed
abstract class DecryptedSecureDelegationKeyMap with _$DecryptedSecureDelegationKeyMap implements SecureDelegationKeyMap {
	const factory DecryptedSecureDelegationKeyMap({
		required String id,
		@Default(null) String? rev,
		required String delegationKey,
		@Default(null) String? delegator,
		@Default(null) String? delegate,
		@Default({}) Set<String> secretForeignKeys,
		@Default({}) Map<String, Set<Delegation>> cryptedForeignKeys,
		@Default({}) Map<String, Set<Delegation>> delegations,
		@Default({}) Map<String, Set<Delegation>> encryptionKeys,
		@Default(null) Base64String? encryptedSelf,
		@Default(null) SecurityMetadata? securityMetadata,
		@Default(null) int? deletionDate,
	}) = _DecryptedSecureDelegationKeyMap;


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

	static DecryptedSecureDelegationKeyMap fromJSON(Map<String, dynamic> data) {
		return DecryptedSecureDelegationKeyMap(
			id: (data["id"] as String),
			delegationKey: (data["delegationKey"] as String),
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
}