// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/annotations/actual_int32.dart';
import 'package:cardinal_sdk/model/embed/message_read_status.dart';
import 'package:cardinal_sdk/model/embed/message_attachment.dart';
import 'package:cardinal_sdk/model/embed/delegation.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/security_metadata.dart';
import 'package:cardinal_sdk/model/message.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/icure_document.dart';
import 'package:cardinal_sdk/model/base/has_encryption_metadata.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "message.freezed.dart";


sealed class Message implements StoredDocument, ICureDocument<String>, HasEncryptionMetadata, Encryptable {
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
	abstract final String? fromAddress;
	abstract final String? fromHealthcarePartyId;
	abstract final String? formId;
	@actualInt32 abstract final int? status;
	abstract final String? recipientsType;
	abstract final Set<String> recipients;
	abstract final Set<String> toAddresses;
	abstract final int? received;
	abstract final int? sent;
	abstract final Map<String, String> metas;
	abstract final Map<String, MessageReadStatus> readStatus;
	abstract final List<MessageAttachment> messageAttachments;
	abstract final String? transportGuid;
	abstract final String? remark;
	abstract final String? conversationGuid;
	abstract final String? subject;
	abstract final Set<String> invoiceIds;
	abstract final String? parentId;
	abstract final String? externalRef;
	abstract final Set<String> unassignedResults;
	abstract final Map<String, String> assignedResults;
	abstract final Map<String, String> senderReferences;
	@override abstract final Set<String> secretForeignKeys;
	@override abstract final Map<String, Set<Delegation>> cryptedForeignKeys;
	@override abstract final Map<String, Set<Delegation>> delegations;
	@override abstract final Map<String, Set<Delegation>> encryptionKeys;
	@override abstract final Base64String? encryptedSelf;
	@override abstract final SecurityMetadata? securityMetadata;

	static Map<String, dynamic> encode(Message value) {
		switch (value) {
			case DecryptedMessage entity:
				Map<String, dynamic> entityJson = DecryptedMessage.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.DecryptedMessage";
				return entityJson;
			case EncryptedMessage entity:
				Map<String, dynamic> entityJson = EncryptedMessage.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.EncryptedMessage";
				return entityJson;
		}
	}

	static Message fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.DecryptedMessage":
				return DecryptedMessage.fromJSON(data);
			case "com.icure.cardinal.sdk.model.EncryptedMessage":
				return EncryptedMessage.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

@freezed
abstract class DecryptedMessage with _$DecryptedMessage implements Message {
	const factory DecryptedMessage({
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
		@Default(null) String? fromAddress,
		@Default(null) String? fromHealthcarePartyId,
		@Default(null) String? formId,
		@Default(null) int? status,
		@Default(null) String? recipientsType,
		@Default({}) Set<String> recipients,
		@Default({}) Set<String> toAddresses,
		@Default(null) int? received,
		@Default(null) int? sent,
		@Default({}) Map<String, String> metas,
		@Default({}) Map<String, MessageReadStatus> readStatus,
		@Default([]) List<MessageAttachment> messageAttachments,
		@Default(null) String? transportGuid,
		@Default(null) String? remark,
		@Default(null) String? conversationGuid,
		@Default(null) String? subject,
		@Default({}) Set<String> invoiceIds,
		@Default(null) String? parentId,
		@Default(null) String? externalRef,
		@Default({}) Set<String> unassignedResults,
		@Default({}) Map<String, String> assignedResults,
		@Default({}) Map<String, String> senderReferences,
		@Default({}) Set<String> secretForeignKeys,
		@Default({}) Map<String, Set<Delegation>> cryptedForeignKeys,
		@Default({}) Map<String, Set<Delegation>> delegations,
		@Default({}) Map<String, Set<Delegation>> encryptionKeys,
		@Default(null) Base64String? encryptedSelf,
		@Default(null) SecurityMetadata? securityMetadata,
	}) = _DecryptedMessage;


	static Map<String, dynamic> encode(DecryptedMessage value) {
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
			"fromAddress" : value.fromAddress,
			"fromHealthcarePartyId" : value.fromHealthcarePartyId,
			"formId" : value.formId,
			"status" : value.status,
			"recipientsType" : value.recipientsType,
			"recipients" : value.recipients.map((x0) => x0).toList(),
			"toAddresses" : value.toAddresses.map((x0) => x0).toList(),
			"received" : value.received,
			"sent" : value.sent,
			"metas" : value.metas.map((k0, v0) => MapEntry(k0, v0)),
			"readStatus" : value.readStatus.map((k0, v0) => MapEntry(k0, MessageReadStatus.encode(v0))),
			"messageAttachments" : value.messageAttachments.map((x0) => MessageAttachment.encode(x0)).toList(),
			"transportGuid" : value.transportGuid,
			"remark" : value.remark,
			"conversationGuid" : value.conversationGuid,
			"subject" : value.subject,
			"invoiceIds" : value.invoiceIds.map((x0) => x0).toList(),
			"parentId" : value.parentId,
			"externalRef" : value.externalRef,
			"unassignedResults" : value.unassignedResults.map((x0) => x0).toList(),
			"assignedResults" : value.assignedResults.map((k0, v0) => MapEntry(k0, v0)),
			"senderReferences" : value.senderReferences.map((k0, v0) => MapEntry(k0, v0)),
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0).toList(),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!)
		};
		return entityAsMap;
	}

	static DecryptedMessage fromJSON(Map<String, dynamic> data) {
		return DecryptedMessage(
			id: (data["id"] as String),
			status: (data["status"] as int?),
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
			fromAddress: (data["fromAddress"] as String?),
			fromHealthcarePartyId: (data["fromHealthcarePartyId"] as String?),
			formId: (data["formId"] as String?),
			recipientsType: (data["recipientsType"] as String?),
			recipients: (data["recipients"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			toAddresses: (data["toAddresses"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			received: (data["received"] as int?),
			sent: (data["sent"] as int?),
			metas: (data["metas"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			readStatus: (data["readStatus"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), MessageReadStatus.fromJSON(v0))),
			messageAttachments: (data["messageAttachments"] as List<dynamic>).map((x0) => MessageAttachment.fromJSON(x0) ).toList(),
			transportGuid: (data["transportGuid"] as String?),
			remark: (data["remark"] as String?),
			conversationGuid: (data["conversationGuid"] as String?),
			subject: (data["subject"] as String?),
			invoiceIds: (data["invoiceIds"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			parentId: (data["parentId"] as String?),
			externalRef: (data["externalRef"] as String?),
			unassignedResults: (data["unassignedResults"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			assignedResults: (data["assignedResults"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			senderReferences: (data["senderReferences"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
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
abstract class EncryptedMessage with _$EncryptedMessage implements Message {
	const factory EncryptedMessage({
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
		@Default(null) String? fromAddress,
		@Default(null) String? fromHealthcarePartyId,
		@Default(null) String? formId,
		@Default(null) int? status,
		@Default(null) String? recipientsType,
		@Default({}) Set<String> recipients,
		@Default({}) Set<String> toAddresses,
		@Default(null) int? received,
		@Default(null) int? sent,
		@Default({}) Map<String, String> metas,
		@Default({}) Map<String, MessageReadStatus> readStatus,
		@Default([]) List<MessageAttachment> messageAttachments,
		@Default(null) String? transportGuid,
		@Default(null) String? remark,
		@Default(null) String? conversationGuid,
		@Default(null) String? subject,
		@Default({}) Set<String> invoiceIds,
		@Default(null) String? parentId,
		@Default(null) String? externalRef,
		@Default({}) Set<String> unassignedResults,
		@Default({}) Map<String, String> assignedResults,
		@Default({}) Map<String, String> senderReferences,
		@Default({}) Set<String> secretForeignKeys,
		@Default({}) Map<String, Set<Delegation>> cryptedForeignKeys,
		@Default({}) Map<String, Set<Delegation>> delegations,
		@Default({}) Map<String, Set<Delegation>> encryptionKeys,
		@Default(null) Base64String? encryptedSelf,
		@Default(null) SecurityMetadata? securityMetadata,
	}) = _EncryptedMessage;


	static Map<String, dynamic> encode(EncryptedMessage value) {
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
			"fromAddress" : value.fromAddress,
			"fromHealthcarePartyId" : value.fromHealthcarePartyId,
			"formId" : value.formId,
			"status" : value.status,
			"recipientsType" : value.recipientsType,
			"recipients" : value.recipients.map((x0) => x0).toList(),
			"toAddresses" : value.toAddresses.map((x0) => x0).toList(),
			"received" : value.received,
			"sent" : value.sent,
			"metas" : value.metas.map((k0, v0) => MapEntry(k0, v0)),
			"readStatus" : value.readStatus.map((k0, v0) => MapEntry(k0, MessageReadStatus.encode(v0))),
			"messageAttachments" : value.messageAttachments.map((x0) => MessageAttachment.encode(x0)).toList(),
			"transportGuid" : value.transportGuid,
			"remark" : value.remark,
			"conversationGuid" : value.conversationGuid,
			"subject" : value.subject,
			"invoiceIds" : value.invoiceIds.map((x0) => x0).toList(),
			"parentId" : value.parentId,
			"externalRef" : value.externalRef,
			"unassignedResults" : value.unassignedResults.map((x0) => x0).toList(),
			"assignedResults" : value.assignedResults.map((k0, v0) => MapEntry(k0, v0)),
			"senderReferences" : value.senderReferences.map((k0, v0) => MapEntry(k0, v0)),
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0).toList(),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!)
		};
		return entityAsMap;
	}

	static EncryptedMessage fromJSON(Map<String, dynamic> data) {
		return EncryptedMessage(
			id: (data["id"] as String),
			status: (data["status"] as int?),
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
			fromAddress: (data["fromAddress"] as String?),
			fromHealthcarePartyId: (data["fromHealthcarePartyId"] as String?),
			formId: (data["formId"] as String?),
			recipientsType: (data["recipientsType"] as String?),
			recipients: (data["recipients"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			toAddresses: (data["toAddresses"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			received: (data["received"] as int?),
			sent: (data["sent"] as int?),
			metas: (data["metas"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			readStatus: (data["readStatus"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), MessageReadStatus.fromJSON(v0))),
			messageAttachments: (data["messageAttachments"] as List<dynamic>).map((x0) => MessageAttachment.fromJSON(x0) ).toList(),
			transportGuid: (data["transportGuid"] as String?),
			remark: (data["remark"] as String?),
			conversationGuid: (data["conversationGuid"] as String?),
			subject: (data["subject"] as String?),
			invoiceIds: (data["invoiceIds"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			parentId: (data["parentId"] as String?),
			externalRef: (data["externalRef"] as String?),
			unassignedResults: (data["unassignedResults"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			assignedResults: (data["assignedResults"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			senderReferences: (data["senderReferences"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			secretForeignKeys: (data["secretForeignKeys"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			cryptedForeignKeys: (data["cryptedForeignKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			delegations: (data["delegations"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptionKeys: (data["encryptionKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
		);
	}
}