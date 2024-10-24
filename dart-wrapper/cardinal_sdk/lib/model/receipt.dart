// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/embed/receipt_blob_type.dart';
import 'package:cardinal_sdk/model/embed/delegation.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/security_metadata.dart';
import 'package:cardinal_sdk/model/receipt.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/icure_document.dart';
import 'package:cardinal_sdk/model/base/has_encryption_metadata.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';


sealed class Receipt implements StoredDocument, ICureDocument<String>, HasEncryptionMetadata, Encryptable {
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
	abstract Map<ReceiptBlobType, String> attachmentIds;
	abstract List<String> references;
	abstract String? documentId;
	abstract String? category;
	abstract String? subCategory;
	@override abstract Set<String> secretForeignKeys;
	@override abstract Map<String, Set<Delegation>> cryptedForeignKeys;
	@override abstract Map<String, Set<Delegation>> delegations;
	@override abstract Map<String, Set<Delegation>> encryptionKeys;
	@override abstract Base64String? encryptedSelf;
	@override abstract SecurityMetadata? securityMetadata;

	static Map<String, dynamic> encode(Receipt value) {
		switch (value) {
			case DecryptedReceipt entity:
				Map<String, dynamic> entityJson = DecryptedReceipt.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DecryptedReceipt";
				return entityJson;
			case EncryptedReceipt entity:
				Map<String, dynamic> entityJson = EncryptedReceipt.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.EncryptedReceipt";
				return entityJson;
		}
	}

	static Receipt fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.DecryptedReceipt":
				return DecryptedReceipt.fromJSON(data);
			case "com.icure.cardinal.sdk.model.EncryptedReceipt":
				return EncryptedReceipt.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

class DecryptedReceipt implements Receipt {
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
	@override Map<ReceiptBlobType, String> attachmentIds = {};
	@override List<String> references = [];
	@override String? documentId;
	@override String? category;
	@override String? subCategory;
	@override Set<String> secretForeignKeys = {};
	@override Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override Map<String, Set<Delegation>> delegations = {};
	@override Map<String, Set<Delegation>> encryptionKeys = {};
	@override Base64String? encryptedSelf;
	@override SecurityMetadata? securityMetadata;
	DecryptedReceipt(
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
			this.documentId,
			this.category,
			this.subCategory,
			this.encryptedSelf,
			this.securityMetadata,
			Set<CodeStub>? tags,
			Set<CodeStub>? codes,
			Map<ReceiptBlobType, String>? attachmentIds,
			List<String>? references,
			Set<String>? secretForeignKeys,
			Map<String, Set<Delegation>>? cryptedForeignKeys,
			Map<String, Set<Delegation>>? delegations,
			Map<String, Set<Delegation>>? encryptionKeys
		}) : tags = tags ?? {},
		codes = codes ?? {},
		attachmentIds = attachmentIds ?? {},
		references = references ?? [],
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {};

	factory DecryptedReceipt.fromJSON(Map<String, dynamic> data) {
		return DecryptedReceipt(
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
			attachmentIds: data["attachmentIds"].map((k0, v0) => MapEntry(ReceiptBlobType.fromJSON(k0), v0)),
			references: data["references"].map((x0) => x0 ).toList(),
			documentId: data["documentId"],
			category: data["category"],
			subCategory: data["subCategory"],
			secretForeignKeys: data["secretForeignKeys"].map((x0) => x0 ).toList(),
			cryptedForeignKeys: data["cryptedForeignKeys"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ).toList())),
			delegations: data["delegations"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ).toList())),
			encryptionKeys: data["encryptionKeys"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ).toList())),
			encryptedSelf: data["encryptedSelf"],
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
		);
	}

	static Map<String, dynamic> encode(DecryptedReceipt value) {
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
			"attachmentIds" : value.attachmentIds.map((k0, v0) => MapEntry(ReceiptBlobType.encode(k0), v0)),
			"references" : value.references.map((x0) => x0).toList(),
			"documentId" : value.documentId,
			"category" : value.category,
			"subCategory" : value.subCategory,
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

class EncryptedReceipt implements Receipt {
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
	@override Map<ReceiptBlobType, String> attachmentIds = {};
	@override List<String> references = [];
	@override String? documentId;
	@override String? category;
	@override String? subCategory;
	@override Set<String> secretForeignKeys = {};
	@override Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override Map<String, Set<Delegation>> delegations = {};
	@override Map<String, Set<Delegation>> encryptionKeys = {};
	@override Base64String? encryptedSelf;
	@override SecurityMetadata? securityMetadata;
	EncryptedReceipt(
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
			this.documentId,
			this.category,
			this.subCategory,
			this.encryptedSelf,
			this.securityMetadata,
			Set<CodeStub>? tags,
			Set<CodeStub>? codes,
			Map<ReceiptBlobType, String>? attachmentIds,
			List<String>? references,
			Set<String>? secretForeignKeys,
			Map<String, Set<Delegation>>? cryptedForeignKeys,
			Map<String, Set<Delegation>>? delegations,
			Map<String, Set<Delegation>>? encryptionKeys
		}) : tags = tags ?? {},
		codes = codes ?? {},
		attachmentIds = attachmentIds ?? {},
		references = references ?? [],
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {};

	factory EncryptedReceipt.fromJSON(Map<String, dynamic> data) {
		return EncryptedReceipt(
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
			attachmentIds: data["attachmentIds"].map((k0, v0) => MapEntry(ReceiptBlobType.fromJSON(k0), v0)),
			references: data["references"].map((x0) => x0 ).toList(),
			documentId: data["documentId"],
			category: data["category"],
			subCategory: data["subCategory"],
			secretForeignKeys: data["secretForeignKeys"].map((x0) => x0 ).toList(),
			cryptedForeignKeys: data["cryptedForeignKeys"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ).toList())),
			delegations: data["delegations"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ).toList())),
			encryptionKeys: data["encryptionKeys"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ).toList())),
			encryptedSelf: data["encryptedSelf"],
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
		);
	}

	static Map<String, dynamic> encode(EncryptedReceipt value) {
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
			"attachmentIds" : value.attachmentIds.map((k0, v0) => MapEntry(ReceiptBlobType.encode(k0), v0)),
			"references" : value.references.map((x0) => x0).toList(),
			"documentId" : value.documentId,
			"category" : value.category,
			"subCategory" : value.subCategory,
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