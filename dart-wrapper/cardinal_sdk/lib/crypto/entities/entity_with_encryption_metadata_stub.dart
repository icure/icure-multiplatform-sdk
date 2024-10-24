// auto-generated file
import 'package:cardinal_sdk/model/embed/delegation.dart';
import 'package:cardinal_sdk/model/embed/security_metadata.dart';
import 'package:cardinal_sdk/model/base/has_encryption_metadata.dart';


class EntityWithEncryptionMetadataStub implements HasEncryptionMetadata {
	@override String id;
	@override String? rev;
	@override Set<String> secretForeignKeys;
	@override Map<String, Set<Delegation>> cryptedForeignKeys;
	@override Map<String, Set<Delegation>> delegations;
	@override Map<String, Set<Delegation>> encryptionKeys;
	@override SecurityMetadata? securityMetadata;
	EntityWithEncryptionMetadataStub(
		this.id,
		this.secretForeignKeys,
		this.cryptedForeignKeys,
		this.delegations,
		this.encryptionKeys,
		{
			this.rev,
			this.securityMetadata
		});

	factory EntityWithEncryptionMetadataStub.fromJSON(Map<String, dynamic> data) {
		return EntityWithEncryptionMetadataStub(
			data["id"],
			data["secretForeignKeys"].map((x0) => x0 ),
			data["cryptedForeignKeys"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ))),
			data["delegations"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ))),
			data["encryptionKeys"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ))),
			rev: data["rev"],
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
		);
	}

	static Map<String, dynamic> encode(EntityWithEncryptionMetadataStub value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!)
		};
		return entityAsMap;
	}
}