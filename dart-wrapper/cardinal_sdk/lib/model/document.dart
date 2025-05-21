// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/embed/document_location.dart';
import 'package:cardinal_sdk/model/embed/document_type.dart';
import 'package:cardinal_sdk/model/embed/document_status.dart';
import 'package:cardinal_sdk/model/embed/data_attachment.dart';
import 'package:cardinal_sdk/model/embed/deleted_attachment.dart';
import 'dart:typed_data';
import 'package:cardinal_sdk/model/embed/delegation.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/security_metadata.dart';
import 'package:cardinal_sdk/model/document.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/icure_document.dart';
import 'package:cardinal_sdk/model/base/has_encryption_metadata.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';
import 'dart:convert';
import 'package:freezed_annotation/freezed_annotation.dart';
part "document.freezed.dart";


sealed class Document implements StoredDocument, ICureDocument<String>, HasEncryptionMetadata, Encryptable {
	@override abstract final String id;
	@override abstract final String? rev;
	@override abstract final int? created;
	@override abstract final int? modified;
	@override abstract final String? author;
	@override abstract final String? responsible;
	@override abstract final String? medicalLocationId;
	@override abstract final Set<CodeStub> tags;
	@override abstract final Set<CodeStub> codes;
	@override abstract final int? endOfLife;
	@override abstract final int? deletionDate;
	abstract final DocumentLocation? documentLocation;
	abstract final DocumentType? documentType;
	abstract final DocumentStatus? documentStatus;
	abstract final String? externalUri;
	abstract final String? name;
	abstract final String? version;
	abstract final String? storedICureDocumentId;
	abstract final String? externalUuid;
	abstract final int? size;
	abstract final String? hash;
	abstract final String? openingContactId;
	abstract final String? attachmentId;
	abstract final String? objectStoreReference;
	abstract final String? mainUti;
	abstract final Set<String> otherUtis;
	abstract final Map<String, DataAttachment> secondaryAttachments;
	abstract final List<DeletedAttachment> deletedAttachments;
	abstract final Uint8List? encryptedAttachment;
	abstract final Uint8List? decryptedAttachment;
	@override abstract final Set<String> secretForeignKeys;
	@override abstract final Map<String, Set<Delegation>> cryptedForeignKeys;
	@override abstract final Map<String, Set<Delegation>> delegations;
	@override abstract final Map<String, Set<Delegation>> encryptionKeys;
	@override abstract final Base64String? encryptedSelf;
	@override abstract final SecurityMetadata? securityMetadata;

	static Map<String, dynamic> encode(Document value) {
		switch (value) {
			case EncryptedDocument entity:
				Map<String, dynamic> entityJson = EncryptedDocument.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.EncryptedDocument";
				return entityJson;
			case DecryptedDocument entity:
				Map<String, dynamic> entityJson = DecryptedDocument.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DecryptedDocument";
				return entityJson;
		}
	}

	static Document fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.EncryptedDocument":
				return EncryptedDocument.fromJSON(data);
			case "com.icure.cardinal.sdk.model.DecryptedDocument":
				return DecryptedDocument.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

@freezed
abstract class EncryptedDocument with _$EncryptedDocument implements Document {
	const factory EncryptedDocument({
		required String id,
		@Default(null) String? rev,
		@Default(null) int? created,
		@Default(null) int? modified,
		@Default(null) String? author,
		@Default(null) String? responsible,
		@Default(null) String? medicalLocationId,
		@Default({}) Set<CodeStub> tags,
		@Default({}) Set<CodeStub> codes,
		@Default(null) int? endOfLife,
		@Default(null) int? deletionDate,
		@Default(null) DocumentLocation? documentLocation,
		@Default(null) DocumentType? documentType,
		@Default(null) DocumentStatus? documentStatus,
		@Default(null) String? externalUri,
		@Default(null) String? name,
		@Default(null) String? version,
		@Default(null) String? storedICureDocumentId,
		@Default(null) String? externalUuid,
		@Default(null) int? size,
		@Default(null) String? hash,
		@Default(null) String? openingContactId,
		@Default(null) String? attachmentId,
		@Default(null) String? objectStoreReference,
		@Default(null) String? mainUti,
		@Default({}) Set<String> otherUtis,
		@Default({}) Map<String, DataAttachment> secondaryAttachments,
		@Default([]) List<DeletedAttachment> deletedAttachments,
		@Default(null) Uint8List? encryptedAttachment,
		@Default(null) Uint8List? decryptedAttachment,
		@Default({}) Set<String> secretForeignKeys,
		@Default({}) Map<String, Set<Delegation>> cryptedForeignKeys,
		@Default({}) Map<String, Set<Delegation>> delegations,
		@Default({}) Map<String, Set<Delegation>> encryptionKeys,
		@Default(null) Base64String? encryptedSelf,
		@Default(null) SecurityMetadata? securityMetadata,
	}) = _EncryptedDocument;


	static Map<String, dynamic> encode(EncryptedDocument value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"created" : value.created,
			"modified" : value.modified,
			"author" : value.author,
			"responsible" : value.responsible,
			"medicalLocationId" : value.medicalLocationId,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)).toList(),
			"endOfLife" : value.endOfLife,
			"deletionDate" : value.deletionDate,
			"documentLocation" : value.documentLocation == null ? null : DocumentLocation.encode(value.documentLocation!),
			"documentType" : value.documentType == null ? null : DocumentType.encode(value.documentType!),
			"documentStatus" : value.documentStatus == null ? null : DocumentStatus.encode(value.documentStatus!),
			"externalUri" : value.externalUri,
			"name" : value.name,
			"version" : value.version,
			"storedICureDocumentId" : value.storedICureDocumentId,
			"externalUuid" : value.externalUuid,
			"size" : value.size,
			"hash" : value.hash,
			"openingContactId" : value.openingContactId,
			"attachmentId" : value.attachmentId,
			"objectStoreReference" : value.objectStoreReference,
			"mainUti" : value.mainUti,
			"otherUtis" : value.otherUtis.map((x0) => x0).toList(),
			"secondaryAttachments" : value.secondaryAttachments.map((k0, v0) => MapEntry(k0, DataAttachment.encode(v0))),
			"deletedAttachments" : value.deletedAttachments.map((x0) => DeletedAttachment.encode(x0)).toList(),
			"encryptedAttachment" : value.encryptedAttachment == null ? null : base64Encode(value.encryptedAttachment as List<int>),
			"decryptedAttachment" : value.decryptedAttachment == null ? null : base64Encode(value.decryptedAttachment as List<int>),
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0).toList(),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!)
		};
		return entityAsMap;
	}

	static EncryptedDocument fromJSON(Map<String, dynamic> data) {
		return EncryptedDocument(
			id: (data["id"] as String),
			rev: (data["rev"] as String?),
			created: (data["created"] as int?),
			modified: (data["modified"] as int?),
			author: (data["author"] as String?),
			responsible: (data["responsible"] as String?),
			medicalLocationId: (data["medicalLocationId"] as String?),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			endOfLife: (data["endOfLife"] as int?),
			deletionDate: (data["deletionDate"] as int?),
			documentLocation: data["documentLocation"] == null ? null : DocumentLocation.fromJSON(data["documentLocation"]),
			documentType: data["documentType"] == null ? null : DocumentType.fromJSON(data["documentType"]),
			documentStatus: data["documentStatus"] == null ? null : DocumentStatus.fromJSON(data["documentStatus"]),
			externalUri: (data["externalUri"] as String?),
			name: (data["name"] as String?),
			version: (data["version"] as String?),
			storedICureDocumentId: (data["storedICureDocumentId"] as String?),
			externalUuid: (data["externalUuid"] as String?),
			size: (data["size"] as int?),
			hash: (data["hash"] as String?),
			openingContactId: (data["openingContactId"] as String?),
			attachmentId: (data["attachmentId"] as String?),
			objectStoreReference: (data["objectStoreReference"] as String?),
			mainUti: (data["mainUti"] as String?),
			otherUtis: (data["otherUtis"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			secondaryAttachments: (data["secondaryAttachments"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), DataAttachment.fromJSON(v0))),
			deletedAttachments: (data["deletedAttachments"] as List<dynamic>).map((x0) => DeletedAttachment.fromJSON(x0) ).toList(),
			encryptedAttachment: data["encryptedAttachment"] == null ? null : base64Decode(data["encryptedAttachment"] as String),
			decryptedAttachment: data["decryptedAttachment"] == null ? null : base64Decode(data["decryptedAttachment"] as String),
			secretForeignKeys: (data["secretForeignKeys"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			cryptedForeignKeys: (data["cryptedForeignKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			delegations: (data["delegations"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptionKeys: (data["encryptionKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
		);
	}
}

@freezed
abstract class DecryptedDocument with _$DecryptedDocument implements Document {
	const factory DecryptedDocument({
		required String id,
		@Default(null) String? rev,
		@Default(null) int? created,
		@Default(null) int? modified,
		@Default(null) String? author,
		@Default(null) String? responsible,
		@Default(null) String? medicalLocationId,
		@Default({}) Set<CodeStub> tags,
		@Default({}) Set<CodeStub> codes,
		@Default(null) int? endOfLife,
		@Default(null) int? deletionDate,
		@Default(null) DocumentLocation? documentLocation,
		@Default(null) DocumentType? documentType,
		@Default(null) DocumentStatus? documentStatus,
		@Default(null) String? externalUri,
		@Default(null) String? name,
		@Default(null) String? version,
		@Default(null) String? storedICureDocumentId,
		@Default(null) String? externalUuid,
		@Default(null) int? size,
		@Default(null) String? hash,
		@Default(null) String? openingContactId,
		@Default(null) String? attachmentId,
		@Default(null) String? objectStoreReference,
		@Default(null) String? mainUti,
		@Default({}) Set<String> otherUtis,
		@Default({}) Map<String, DataAttachment> secondaryAttachments,
		@Default([]) List<DeletedAttachment> deletedAttachments,
		@Default(null) Uint8List? encryptedAttachment,
		@Default(null) Uint8List? decryptedAttachment,
		@Default({}) Set<String> secretForeignKeys,
		@Default({}) Map<String, Set<Delegation>> cryptedForeignKeys,
		@Default({}) Map<String, Set<Delegation>> delegations,
		@Default({}) Map<String, Set<Delegation>> encryptionKeys,
		@Default(null) Base64String? encryptedSelf,
		@Default(null) SecurityMetadata? securityMetadata,
	}) = _DecryptedDocument;


	static Map<String, dynamic> encode(DecryptedDocument value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"created" : value.created,
			"modified" : value.modified,
			"author" : value.author,
			"responsible" : value.responsible,
			"medicalLocationId" : value.medicalLocationId,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)).toList(),
			"endOfLife" : value.endOfLife,
			"deletionDate" : value.deletionDate,
			"documentLocation" : value.documentLocation == null ? null : DocumentLocation.encode(value.documentLocation!),
			"documentType" : value.documentType == null ? null : DocumentType.encode(value.documentType!),
			"documentStatus" : value.documentStatus == null ? null : DocumentStatus.encode(value.documentStatus!),
			"externalUri" : value.externalUri,
			"name" : value.name,
			"version" : value.version,
			"storedICureDocumentId" : value.storedICureDocumentId,
			"externalUuid" : value.externalUuid,
			"size" : value.size,
			"hash" : value.hash,
			"openingContactId" : value.openingContactId,
			"attachmentId" : value.attachmentId,
			"objectStoreReference" : value.objectStoreReference,
			"mainUti" : value.mainUti,
			"otherUtis" : value.otherUtis.map((x0) => x0).toList(),
			"secondaryAttachments" : value.secondaryAttachments.map((k0, v0) => MapEntry(k0, DataAttachment.encode(v0))),
			"deletedAttachments" : value.deletedAttachments.map((x0) => DeletedAttachment.encode(x0)).toList(),
			"encryptedAttachment" : value.encryptedAttachment == null ? null : base64Encode(value.encryptedAttachment as List<int>),
			"decryptedAttachment" : value.decryptedAttachment == null ? null : base64Encode(value.decryptedAttachment as List<int>),
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0).toList(),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!)
		};
		return entityAsMap;
	}

	static DecryptedDocument fromJSON(Map<String, dynamic> data) {
		return DecryptedDocument(
			id: (data["id"] as String),
			rev: (data["rev"] as String?),
			created: (data["created"] as int?),
			modified: (data["modified"] as int?),
			author: (data["author"] as String?),
			responsible: (data["responsible"] as String?),
			medicalLocationId: (data["medicalLocationId"] as String?),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			endOfLife: (data["endOfLife"] as int?),
			deletionDate: (data["deletionDate"] as int?),
			documentLocation: data["documentLocation"] == null ? null : DocumentLocation.fromJSON(data["documentLocation"]),
			documentType: data["documentType"] == null ? null : DocumentType.fromJSON(data["documentType"]),
			documentStatus: data["documentStatus"] == null ? null : DocumentStatus.fromJSON(data["documentStatus"]),
			externalUri: (data["externalUri"] as String?),
			name: (data["name"] as String?),
			version: (data["version"] as String?),
			storedICureDocumentId: (data["storedICureDocumentId"] as String?),
			externalUuid: (data["externalUuid"] as String?),
			size: (data["size"] as int?),
			hash: (data["hash"] as String?),
			openingContactId: (data["openingContactId"] as String?),
			attachmentId: (data["attachmentId"] as String?),
			objectStoreReference: (data["objectStoreReference"] as String?),
			mainUti: (data["mainUti"] as String?),
			otherUtis: (data["otherUtis"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			secondaryAttachments: (data["secondaryAttachments"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), DataAttachment.fromJSON(v0))),
			deletedAttachments: (data["deletedAttachments"] as List<dynamic>).map((x0) => DeletedAttachment.fromJSON(x0) ).toList(),
			encryptedAttachment: data["encryptedAttachment"] == null ? null : base64Decode(data["encryptedAttachment"] as String),
			decryptedAttachment: data["decryptedAttachment"] == null ? null : base64Decode(data["decryptedAttachment"] as String),
			secretForeignKeys: (data["secretForeignKeys"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			cryptedForeignKeys: (data["cryptedForeignKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			delegations: (data["delegations"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptionKeys: (data["encryptionKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
		);
	}
}