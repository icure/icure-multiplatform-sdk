// auto-generated file
import 'package:cardinal_sdk/model/embed/delegation.dart';
import 'package:cardinal_sdk/model/embed/security_metadata.dart';
import 'package:cardinal_sdk/model/base/has_encryption_metadata.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "entity_with_encryption_metadata_stub.freezed.dart";


@freezed
abstract class EntityWithEncryptionMetadataStub with _$EntityWithEncryptionMetadataStub implements HasEncryptionMetadata {
	const factory EntityWithEncryptionMetadataStub({
		required String id,
		required String? rev,
		required Set<String> secretForeignKeys,
		required Map<String, Set<Delegation>> cryptedForeignKeys,
		required Map<String, Set<Delegation>> delegations,
		required Map<String, Set<Delegation>> encryptionKeys,
		required SecurityMetadata? securityMetadata,
	}) = _EntityWithEncryptionMetadataStub;


	static Map<String, dynamic> encode(EntityWithEncryptionMetadataStub value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0).toList(),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!)
		};
		return entityAsMap;
	}

	static EntityWithEncryptionMetadataStub fromJSON(Map<String, dynamic> data) {
		return EntityWithEncryptionMetadataStub(
			id: (data["id"] as String),
			secretForeignKeys: (data["secretForeignKeys"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			cryptedForeignKeys: (data["cryptedForeignKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			delegations: (data["delegations"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptionKeys: (data["encryptionKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			rev: (data["rev"] as String?),
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
		);
	}
}