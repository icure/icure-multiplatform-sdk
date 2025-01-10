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
	@override String? rev = null;
	@override int? created = null;
	@override int? modified = null;
	@override String? author = null;
	@override String? responsible = null;
	@override String? medicalLocationId = null;
	@override Set<CodeStub> tags = {};
	@override Set<CodeStub> codes = {};
	@override int? endOfLife = null;
	@override int? deletionDate = null;
	@override DocumentLocation? documentLocation = null;
	@override DocumentType? documentType = null;
	@override DocumentStatus? documentStatus = null;
	@override String? externalUri = null;
	@override String? name = null;
	@override String? version = null;
	@override String? storedICureDocumentId = null;
	@override String? externalUuid = null;
	@override int? size = null;
	@override String? hash = null;
	@override String? openingContactId = null;
	@override String? attachmentId = null;
	@override String? objectStoreReference = null;
	@override String? mainUti = null;
	@override Set<String> otherUtis = {};
	@override Map<String, DataAttachment> secondaryAttachments = {};
	@override List<DeletedAttachment> deletedAttachments = [];
	@override Uint8List? encryptedAttachment = null;
	@override Uint8List? decryptedAttachment = null;
	@override Set<String> secretForeignKeys = {};
	@override Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override Map<String, Set<Delegation>> delegations = {};
	@override Map<String, Set<Delegation>> encryptionKeys = {};
	@override Base64String? encryptedSelf = null;
	@override SecurityMetadata? securityMetadata = null;
	EncryptedDocument(
		this.id,
		{
			String? rev,
			int? created,
			int? modified,
			String? author,
			String? responsible,
			String? medicalLocationId,
			Set<CodeStub>? tags,
			Set<CodeStub>? codes,
			int? endOfLife,
			int? deletionDate,
			DocumentLocation? documentLocation,
			DocumentType? documentType,
			DocumentStatus? documentStatus,
			String? externalUri,
			String? name,
			String? version,
			String? storedICureDocumentId,
			String? externalUuid,
			int? size,
			String? hash,
			String? openingContactId,
			String? attachmentId,
			String? objectStoreReference,
			String? mainUti,
			Set<String>? otherUtis,
			Map<String, DataAttachment>? secondaryAttachments,
			List<DeletedAttachment>? deletedAttachments,
			Uint8List? encryptedAttachment,
			Uint8List? decryptedAttachment,
			Set<String>? secretForeignKeys,
			Map<String, Set<Delegation>>? cryptedForeignKeys,
			Map<String, Set<Delegation>>? delegations,
			Map<String, Set<Delegation>>? encryptionKeys,
			Base64String? encryptedSelf,
			SecurityMetadata? securityMetadata
		}) : rev = rev ?? null,
		created = created ?? null,
		modified = modified ?? null,
		author = author ?? null,
		responsible = responsible ?? null,
		medicalLocationId = medicalLocationId ?? null,
		tags = tags ?? {},
		codes = codes ?? {},
		endOfLife = endOfLife ?? null,
		deletionDate = deletionDate ?? null,
		documentLocation = documentLocation ?? null,
		documentType = documentType ?? null,
		documentStatus = documentStatus ?? null,
		externalUri = externalUri ?? null,
		name = name ?? null,
		version = version ?? null,
		storedICureDocumentId = storedICureDocumentId ?? null,
		externalUuid = externalUuid ?? null,
		size = size ?? null,
		hash = hash ?? null,
		openingContactId = openingContactId ?? null,
		attachmentId = attachmentId ?? null,
		objectStoreReference = objectStoreReference ?? null,
		mainUti = mainUti ?? null,
		otherUtis = otherUtis ?? {},
		secondaryAttachments = secondaryAttachments ?? {},
		deletedAttachments = deletedAttachments ?? [],
		encryptedAttachment = encryptedAttachment ?? null,
		decryptedAttachment = decryptedAttachment ?? null,
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {},
		encryptedSelf = encryptedSelf ?? null,
		securityMetadata = securityMetadata ?? null;

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
			(data["id"] as String),
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

class DecryptedDocument implements Document {
	@override String id;
	@override String? rev = null;
	@override int? created = null;
	@override int? modified = null;
	@override String? author = null;
	@override String? responsible = null;
	@override String? medicalLocationId = null;
	@override Set<CodeStub> tags = {};
	@override Set<CodeStub> codes = {};
	@override int? endOfLife = null;
	@override int? deletionDate = null;
	@override DocumentLocation? documentLocation = null;
	@override DocumentType? documentType = null;
	@override DocumentStatus? documentStatus = null;
	@override String? externalUri = null;
	@override String? name = null;
	@override String? version = null;
	@override String? storedICureDocumentId = null;
	@override String? externalUuid = null;
	@override int? size = null;
	@override String? hash = null;
	@override String? openingContactId = null;
	@override String? attachmentId = null;
	@override String? objectStoreReference = null;
	@override String? mainUti = null;
	@override Set<String> otherUtis = {};
	@override Map<String, DataAttachment> secondaryAttachments = {};
	@override List<DeletedAttachment> deletedAttachments = [];
	@override Uint8List? encryptedAttachment = null;
	@override Uint8List? decryptedAttachment = null;
	@override Set<String> secretForeignKeys = {};
	@override Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override Map<String, Set<Delegation>> delegations = {};
	@override Map<String, Set<Delegation>> encryptionKeys = {};
	@override Base64String? encryptedSelf = null;
	@override SecurityMetadata? securityMetadata = null;
	DecryptedDocument(
		this.id,
		{
			String? rev,
			int? created,
			int? modified,
			String? author,
			String? responsible,
			String? medicalLocationId,
			Set<CodeStub>? tags,
			Set<CodeStub>? codes,
			int? endOfLife,
			int? deletionDate,
			DocumentLocation? documentLocation,
			DocumentType? documentType,
			DocumentStatus? documentStatus,
			String? externalUri,
			String? name,
			String? version,
			String? storedICureDocumentId,
			String? externalUuid,
			int? size,
			String? hash,
			String? openingContactId,
			String? attachmentId,
			String? objectStoreReference,
			String? mainUti,
			Set<String>? otherUtis,
			Map<String, DataAttachment>? secondaryAttachments,
			List<DeletedAttachment>? deletedAttachments,
			Uint8List? encryptedAttachment,
			Uint8List? decryptedAttachment,
			Set<String>? secretForeignKeys,
			Map<String, Set<Delegation>>? cryptedForeignKeys,
			Map<String, Set<Delegation>>? delegations,
			Map<String, Set<Delegation>>? encryptionKeys,
			Base64String? encryptedSelf,
			SecurityMetadata? securityMetadata
		}) : rev = rev ?? null,
		created = created ?? null,
		modified = modified ?? null,
		author = author ?? null,
		responsible = responsible ?? null,
		medicalLocationId = medicalLocationId ?? null,
		tags = tags ?? {},
		codes = codes ?? {},
		endOfLife = endOfLife ?? null,
		deletionDate = deletionDate ?? null,
		documentLocation = documentLocation ?? null,
		documentType = documentType ?? null,
		documentStatus = documentStatus ?? null,
		externalUri = externalUri ?? null,
		name = name ?? null,
		version = version ?? null,
		storedICureDocumentId = storedICureDocumentId ?? null,
		externalUuid = externalUuid ?? null,
		size = size ?? null,
		hash = hash ?? null,
		openingContactId = openingContactId ?? null,
		attachmentId = attachmentId ?? null,
		objectStoreReference = objectStoreReference ?? null,
		mainUti = mainUti ?? null,
		otherUtis = otherUtis ?? {},
		secondaryAttachments = secondaryAttachments ?? {},
		deletedAttachments = deletedAttachments ?? [],
		encryptedAttachment = encryptedAttachment ?? null,
		decryptedAttachment = decryptedAttachment ?? null,
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {},
		encryptedSelf = encryptedSelf ?? null,
		securityMetadata = securityMetadata ?? null;

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
			(data["id"] as String),
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