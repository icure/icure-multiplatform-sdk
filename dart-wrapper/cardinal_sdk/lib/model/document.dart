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


sealed class Document implements StoredDocument, ICureDocument<String>, HasEncryptionMetadata, Encryptable {
	@override abstract String id;
	@override abstract String? rev;
	@override abstract int? created;
	@override abstract int? modified;
	@override abstract String? author;
	@override abstract String? responsible;
	@override abstract String? medicalLocationId;
	@override abstract Set<CodeStub> tags;
	@override abstract Set<CodeStub> codes;
	@override abstract int? endOfLife;
	@override abstract int? deletionDate;
	abstract DocumentLocation? documentLocation;
	abstract DocumentType? documentType;
	abstract DocumentStatus? documentStatus;
	abstract String? externalUri;
	abstract String? name;
	abstract String? version;
	abstract String? storedICureDocumentId;
	abstract String? externalUuid;
	abstract int? size;
	abstract String? hash;
	abstract String? openingContactId;
	abstract String? attachmentId;
	abstract String? objectStoreReference;
	abstract String? mainUti;
	abstract Set<String> otherUtis;
	abstract Map<String, DataAttachment> secondaryAttachments;
	abstract List<DeletedAttachment> deletedAttachments;
	abstract Uint8List? encryptedAttachment;
	abstract Uint8List? decryptedAttachment;
	@override abstract Set<String> secretForeignKeys;
	@override abstract Map<String, Set<Delegation>> cryptedForeignKeys;
	@override abstract Map<String, Set<Delegation>> delegations;
	@override abstract Map<String, Set<Delegation>> encryptionKeys;
	@override abstract Base64String? encryptedSelf;
	@override abstract SecurityMetadata? securityMetadata;

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

class EncryptedDocument implements Document {
	@override String id;
	@override String? rev;
	@override int? created;
	@override int? modified;
	@override String? author;
	@override String? responsible;
	@override String? medicalLocationId;
	@override Set<CodeStub> tags = {};
	@override Set<CodeStub> codes = {};
	@override int? endOfLife;
	@override int? deletionDate;
	@override DocumentLocation? documentLocation;
	@override DocumentType? documentType;
	@override DocumentStatus? documentStatus;
	@override String? externalUri;
	@override String? name;
	@override String? version;
	@override String? storedICureDocumentId;
	@override String? externalUuid;
	@override int? size;
	@override String? hash;
	@override String? openingContactId;
	@override String? attachmentId;
	@override String? objectStoreReference;
	@override String? mainUti;
	@override Set<String> otherUtis = {};
	@override Map<String, DataAttachment> secondaryAttachments = {};
	@override List<DeletedAttachment> deletedAttachments = [];
	@override Uint8List? encryptedAttachment;
	@override Uint8List? decryptedAttachment;
	@override Set<String> secretForeignKeys = {};
	@override Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override Map<String, Set<Delegation>> delegations = {};
	@override Map<String, Set<Delegation>> encryptionKeys = {};
	@override Base64String? encryptedSelf;
	@override SecurityMetadata? securityMetadata;
	EncryptedDocument(
		this.id,
		{
			this.rev,
			this.created,
			this.modified,
			this.author,
			this.responsible,
			this.medicalLocationId,
			this.endOfLife,
			this.deletionDate,
			this.documentLocation,
			this.documentType,
			this.documentStatus,
			this.externalUri,
			this.name,
			this.version,
			this.storedICureDocumentId,
			this.externalUuid,
			this.size,
			this.hash,
			this.openingContactId,
			this.attachmentId,
			this.objectStoreReference,
			this.mainUti,
			this.encryptedAttachment,
			this.decryptedAttachment,
			this.encryptedSelf,
			this.securityMetadata,
			Set<CodeStub>? tags,
			Set<CodeStub>? codes,
			Set<String>? otherUtis,
			Map<String, DataAttachment>? secondaryAttachments,
			List<DeletedAttachment>? deletedAttachments,
			Set<String>? secretForeignKeys,
			Map<String, Set<Delegation>>? cryptedForeignKeys,
			Map<String, Set<Delegation>>? delegations,
			Map<String, Set<Delegation>>? encryptionKeys
		}) : tags = tags ?? {},
		codes = codes ?? {},
		otherUtis = otherUtis ?? {},
		secondaryAttachments = secondaryAttachments ?? {},
		deletedAttachments = deletedAttachments ?? [],
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {};

	factory EncryptedDocument.fromJSON(Map<String, dynamic> data) {
		return EncryptedDocument(
			data["id"],
			rev: data["rev"],
			created: data["created"],
			modified: data["modified"],
			author: data["author"],
			responsible: data["responsible"],
			medicalLocationId: data["medicalLocationId"],
			tags: data["tags"].map((x0) => CodeStub.fromJSON(x0) ).toList(),
			codes: data["codes"].map((x0) => CodeStub.fromJSON(x0) ).toList(),
			endOfLife: data["endOfLife"],
			deletionDate: data["deletionDate"],
			documentLocation: data["documentLocation"] == null ? null : DocumentLocation.fromJSON(data["documentLocation"]),
			documentType: data["documentType"] == null ? null : DocumentType.fromJSON(data["documentType"]),
			documentStatus: data["documentStatus"] == null ? null : DocumentStatus.fromJSON(data["documentStatus"]),
			externalUri: data["externalUri"],
			name: data["name"],
			version: data["version"],
			storedICureDocumentId: data["storedICureDocumentId"],
			externalUuid: data["externalUuid"],
			size: data["size"],
			hash: data["hash"],
			openingContactId: data["openingContactId"],
			attachmentId: data["attachmentId"],
			objectStoreReference: data["objectStoreReference"],
			mainUti: data["mainUti"],
			otherUtis: data["otherUtis"].map((x0) => x0 ).toList(),
			secondaryAttachments: data["secondaryAttachments"].map((k0, v0) => MapEntry(k0, DataAttachment.fromJSON(v0))),
			deletedAttachments: data["deletedAttachments"].map((x0) => DeletedAttachment.fromJSON(x0) ).toList(),
			encryptedAttachment: data["encryptedAttachment"] == null ? null : base64Decode(data["encryptedAttachment"] as String),
			decryptedAttachment: data["decryptedAttachment"] == null ? null : base64Decode(data["decryptedAttachment"] as String),
			secretForeignKeys: data["secretForeignKeys"].map((x0) => x0 ).toList(),
			cryptedForeignKeys: data["cryptedForeignKeys"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ).toList())),
			delegations: data["delegations"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ).toList())),
			encryptionKeys: data["encryptionKeys"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ).toList())),
			encryptedSelf: data["encryptedSelf"],
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
		);
	}

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
}

class DecryptedDocument implements Document {
	@override String id;
	@override String? rev;
	@override int? created;
	@override int? modified;
	@override String? author;
	@override String? responsible;
	@override String? medicalLocationId;
	@override Set<CodeStub> tags = {};
	@override Set<CodeStub> codes = {};
	@override int? endOfLife;
	@override int? deletionDate;
	@override DocumentLocation? documentLocation;
	@override DocumentType? documentType;
	@override DocumentStatus? documentStatus;
	@override String? externalUri;
	@override String? name;
	@override String? version;
	@override String? storedICureDocumentId;
	@override String? externalUuid;
	@override int? size;
	@override String? hash;
	@override String? openingContactId;
	@override String? attachmentId;
	@override String? objectStoreReference;
	@override String? mainUti;
	@override Set<String> otherUtis = {};
	@override Map<String, DataAttachment> secondaryAttachments = {};
	@override List<DeletedAttachment> deletedAttachments = [];
	@override Uint8List? encryptedAttachment;
	@override Uint8List? decryptedAttachment;
	@override Set<String> secretForeignKeys = {};
	@override Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override Map<String, Set<Delegation>> delegations = {};
	@override Map<String, Set<Delegation>> encryptionKeys = {};
	@override Base64String? encryptedSelf;
	@override SecurityMetadata? securityMetadata;
	DecryptedDocument(
		this.id,
		{
			this.rev,
			this.created,
			this.modified,
			this.author,
			this.responsible,
			this.medicalLocationId,
			this.endOfLife,
			this.deletionDate,
			this.documentLocation,
			this.documentType,
			this.documentStatus,
			this.externalUri,
			this.name,
			this.version,
			this.storedICureDocumentId,
			this.externalUuid,
			this.size,
			this.hash,
			this.openingContactId,
			this.attachmentId,
			this.objectStoreReference,
			this.mainUti,
			this.encryptedAttachment,
			this.decryptedAttachment,
			this.encryptedSelf,
			this.securityMetadata,
			Set<CodeStub>? tags,
			Set<CodeStub>? codes,
			Set<String>? otherUtis,
			Map<String, DataAttachment>? secondaryAttachments,
			List<DeletedAttachment>? deletedAttachments,
			Set<String>? secretForeignKeys,
			Map<String, Set<Delegation>>? cryptedForeignKeys,
			Map<String, Set<Delegation>>? delegations,
			Map<String, Set<Delegation>>? encryptionKeys
		}) : tags = tags ?? {},
		codes = codes ?? {},
		otherUtis = otherUtis ?? {},
		secondaryAttachments = secondaryAttachments ?? {},
		deletedAttachments = deletedAttachments ?? [],
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {};

	factory DecryptedDocument.fromJSON(Map<String, dynamic> data) {
		return DecryptedDocument(
			data["id"],
			rev: data["rev"],
			created: data["created"],
			modified: data["modified"],
			author: data["author"],
			responsible: data["responsible"],
			medicalLocationId: data["medicalLocationId"],
			tags: data["tags"].map((x0) => CodeStub.fromJSON(x0) ).toList(),
			codes: data["codes"].map((x0) => CodeStub.fromJSON(x0) ).toList(),
			endOfLife: data["endOfLife"],
			deletionDate: data["deletionDate"],
			documentLocation: data["documentLocation"] == null ? null : DocumentLocation.fromJSON(data["documentLocation"]),
			documentType: data["documentType"] == null ? null : DocumentType.fromJSON(data["documentType"]),
			documentStatus: data["documentStatus"] == null ? null : DocumentStatus.fromJSON(data["documentStatus"]),
			externalUri: data["externalUri"],
			name: data["name"],
			version: data["version"],
			storedICureDocumentId: data["storedICureDocumentId"],
			externalUuid: data["externalUuid"],
			size: data["size"],
			hash: data["hash"],
			openingContactId: data["openingContactId"],
			attachmentId: data["attachmentId"],
			objectStoreReference: data["objectStoreReference"],
			mainUti: data["mainUti"],
			otherUtis: data["otherUtis"].map((x0) => x0 ).toList(),
			secondaryAttachments: data["secondaryAttachments"].map((k0, v0) => MapEntry(k0, DataAttachment.fromJSON(v0))),
			deletedAttachments: data["deletedAttachments"].map((x0) => DeletedAttachment.fromJSON(x0) ).toList(),
			encryptedAttachment: data["encryptedAttachment"] == null ? null : base64Decode(data["encryptedAttachment"] as String),
			decryptedAttachment: data["decryptedAttachment"] == null ? null : base64Decode(data["decryptedAttachment"] as String),
			secretForeignKeys: data["secretForeignKeys"].map((x0) => x0 ).toList(),
			cryptedForeignKeys: data["cryptedForeignKeys"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ).toList())),
			delegations: data["delegations"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ).toList())),
			encryptionKeys: data["encryptionKeys"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ).toList())),
			encryptedSelf: data["encryptedSelf"],
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
		);
	}

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
}