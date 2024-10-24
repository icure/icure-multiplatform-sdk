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


sealed class Message implements StoredDocument, ICureDocument<String>, HasEncryptionMetadata, Encryptable {
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
	abstract String? fromAddress;
	abstract String? fromHealthcarePartyId;
	abstract String? formId;
	@ActualInt32() abstract int? status;
	abstract String? recipientsType;
	abstract Set<String> recipients;
	abstract Set<String> toAddresses;
	abstract int? received;
	abstract int? sent;
	abstract Map<String, String> metas;
	abstract Map<String, MessageReadStatus> readStatus;
	abstract List<MessageAttachment> messageAttachments;
	abstract String? transportGuid;
	abstract String? remark;
	abstract String? conversationGuid;
	abstract String? subject;
	abstract Set<String> invoiceIds;
	abstract String? parentId;
	abstract String? externalRef;
	abstract Set<String> unassignedResults;
	abstract Map<String, String> assignedResults;
	abstract Map<String, String> senderReferences;
	@override abstract Set<String> secretForeignKeys;
	@override abstract Map<String, Set<Delegation>> cryptedForeignKeys;
	@override abstract Map<String, Set<Delegation>> delegations;
	@override abstract Map<String, Set<Delegation>> encryptionKeys;
	@override abstract Base64String? encryptedSelf;
	@override abstract SecurityMetadata? securityMetadata;

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

class DecryptedMessage implements Message {
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
	@override String? fromAddress;
	@override String? fromHealthcarePartyId;
	@override String? formId;
	int? _status;
	@ActualInt32() @override int? get status => _status;
	@ActualInt32() @override set status(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('status value cannot exceed 2147483647');
		}
		_status = value;
	}
	@override String? recipientsType;
	@override Set<String> recipients = {};
	@override Set<String> toAddresses = {};
	@override int? received;
	@override int? sent;
	@override Map<String, String> metas = {};
	@override Map<String, MessageReadStatus> readStatus = {};
	@override List<MessageAttachment> messageAttachments = [];
	@override String? transportGuid;
	@override String? remark;
	@override String? conversationGuid;
	@override String? subject;
	@override Set<String> invoiceIds = {};
	@override String? parentId;
	@override String? externalRef;
	@override Set<String> unassignedResults = {};
	@override Map<String, String> assignedResults = {};
	@override Map<String, String> senderReferences = {};
	@override Set<String> secretForeignKeys = {};
	@override Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override Map<String, Set<Delegation>> delegations = {};
	@override Map<String, Set<Delegation>> encryptionKeys = {};
	@override Base64String? encryptedSelf;
	@override SecurityMetadata? securityMetadata;
	DecryptedMessage(
		this.id,
		{
			int? status,
			this.rev,
			this.created,
			this.modified,
			this.author,
			this.responsible,
			this.medicalLocationId,
			this.endOfLife,
			this.deletionDate,
			this.fromAddress,
			this.fromHealthcarePartyId,
			this.formId,
			this.recipientsType,
			this.received,
			this.sent,
			this.transportGuid,
			this.remark,
			this.conversationGuid,
			this.subject,
			this.parentId,
			this.externalRef,
			this.encryptedSelf,
			this.securityMetadata,
			Set<CodeStub>? tags,
			Set<CodeStub>? codes,
			Set<String>? recipients,
			Set<String>? toAddresses,
			Map<String, String>? metas,
			Map<String, MessageReadStatus>? readStatus,
			List<MessageAttachment>? messageAttachments,
			Set<String>? invoiceIds,
			Set<String>? unassignedResults,
			Map<String, String>? assignedResults,
			Map<String, String>? senderReferences,
			Set<String>? secretForeignKeys,
			Map<String, Set<Delegation>>? cryptedForeignKeys,
			Map<String, Set<Delegation>>? delegations,
			Map<String, Set<Delegation>>? encryptionKeys
		}) : tags = tags ?? {},
		codes = codes ?? {},
		recipients = recipients ?? {},
		toAddresses = toAddresses ?? {},
		metas = metas ?? {},
		readStatus = readStatus ?? {},
		messageAttachments = messageAttachments ?? [],
		invoiceIds = invoiceIds ?? {},
		unassignedResults = unassignedResults ?? {},
		assignedResults = assignedResults ?? {},
		senderReferences = senderReferences ?? {},
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {},
		_status = status;

	factory DecryptedMessage.fromJSON(Map<String, dynamic> data) {
		return DecryptedMessage(
			data["id"],
			status: data["status"],
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
			fromAddress: data["fromAddress"],
			fromHealthcarePartyId: data["fromHealthcarePartyId"],
			formId: data["formId"],
			recipientsType: data["recipientsType"],
			recipients: data["recipients"].map((x0) => x0 ).toList(),
			toAddresses: data["toAddresses"].map((x0) => x0 ).toList(),
			received: data["received"],
			sent: data["sent"],
			metas: data["metas"].map((k0, v0) => MapEntry(k0, v0)),
			readStatus: data["readStatus"].map((k0, v0) => MapEntry(k0, MessageReadStatus.fromJSON(v0))),
			messageAttachments: data["messageAttachments"].map((x0) => MessageAttachment.fromJSON(x0) ).toList(),
			transportGuid: data["transportGuid"],
			remark: data["remark"],
			conversationGuid: data["conversationGuid"],
			subject: data["subject"],
			invoiceIds: data["invoiceIds"].map((x0) => x0 ).toList(),
			parentId: data["parentId"],
			externalRef: data["externalRef"],
			unassignedResults: data["unassignedResults"].map((x0) => x0 ).toList(),
			assignedResults: data["assignedResults"].map((k0, v0) => MapEntry(k0, v0)),
			senderReferences: data["senderReferences"].map((k0, v0) => MapEntry(k0, v0)),
			secretForeignKeys: data["secretForeignKeys"].map((x0) => x0 ).toList(),
			cryptedForeignKeys: data["cryptedForeignKeys"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ).toList())),
			delegations: data["delegations"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ).toList())),
			encryptionKeys: data["encryptionKeys"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ).toList())),
			encryptedSelf: data["encryptedSelf"],
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
		);
	}

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
}

class EncryptedMessage implements Message {
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
	@override String? fromAddress;
	@override String? fromHealthcarePartyId;
	@override String? formId;
	int? _status;
	@ActualInt32() @override int? get status => _status;
	@ActualInt32() @override set status(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('status value cannot exceed 2147483647');
		}
		_status = value;
	}
	@override String? recipientsType;
	@override Set<String> recipients = {};
	@override Set<String> toAddresses = {};
	@override int? received;
	@override int? sent;
	@override Map<String, String> metas = {};
	@override Map<String, MessageReadStatus> readStatus = {};
	@override List<MessageAttachment> messageAttachments = [];
	@override String? transportGuid;
	@override String? remark;
	@override String? conversationGuid;
	@override String? subject;
	@override Set<String> invoiceIds = {};
	@override String? parentId;
	@override String? externalRef;
	@override Set<String> unassignedResults = {};
	@override Map<String, String> assignedResults = {};
	@override Map<String, String> senderReferences = {};
	@override Set<String> secretForeignKeys = {};
	@override Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override Map<String, Set<Delegation>> delegations = {};
	@override Map<String, Set<Delegation>> encryptionKeys = {};
	@override Base64String? encryptedSelf;
	@override SecurityMetadata? securityMetadata;
	EncryptedMessage(
		this.id,
		{
			int? status,
			this.rev,
			this.created,
			this.modified,
			this.author,
			this.responsible,
			this.medicalLocationId,
			this.endOfLife,
			this.deletionDate,
			this.fromAddress,
			this.fromHealthcarePartyId,
			this.formId,
			this.recipientsType,
			this.received,
			this.sent,
			this.transportGuid,
			this.remark,
			this.conversationGuid,
			this.subject,
			this.parentId,
			this.externalRef,
			this.encryptedSelf,
			this.securityMetadata,
			Set<CodeStub>? tags,
			Set<CodeStub>? codes,
			Set<String>? recipients,
			Set<String>? toAddresses,
			Map<String, String>? metas,
			Map<String, MessageReadStatus>? readStatus,
			List<MessageAttachment>? messageAttachments,
			Set<String>? invoiceIds,
			Set<String>? unassignedResults,
			Map<String, String>? assignedResults,
			Map<String, String>? senderReferences,
			Set<String>? secretForeignKeys,
			Map<String, Set<Delegation>>? cryptedForeignKeys,
			Map<String, Set<Delegation>>? delegations,
			Map<String, Set<Delegation>>? encryptionKeys
		}) : tags = tags ?? {},
		codes = codes ?? {},
		recipients = recipients ?? {},
		toAddresses = toAddresses ?? {},
		metas = metas ?? {},
		readStatus = readStatus ?? {},
		messageAttachments = messageAttachments ?? [],
		invoiceIds = invoiceIds ?? {},
		unassignedResults = unassignedResults ?? {},
		assignedResults = assignedResults ?? {},
		senderReferences = senderReferences ?? {},
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {},
		_status = status;

	factory EncryptedMessage.fromJSON(Map<String, dynamic> data) {
		return EncryptedMessage(
			data["id"],
			status: data["status"],
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
			fromAddress: data["fromAddress"],
			fromHealthcarePartyId: data["fromHealthcarePartyId"],
			formId: data["formId"],
			recipientsType: data["recipientsType"],
			recipients: data["recipients"].map((x0) => x0 ).toList(),
			toAddresses: data["toAddresses"].map((x0) => x0 ).toList(),
			received: data["received"],
			sent: data["sent"],
			metas: data["metas"].map((k0, v0) => MapEntry(k0, v0)),
			readStatus: data["readStatus"].map((k0, v0) => MapEntry(k0, MessageReadStatus.fromJSON(v0))),
			messageAttachments: data["messageAttachments"].map((x0) => MessageAttachment.fromJSON(x0) ).toList(),
			transportGuid: data["transportGuid"],
			remark: data["remark"],
			conversationGuid: data["conversationGuid"],
			subject: data["subject"],
			invoiceIds: data["invoiceIds"].map((x0) => x0 ).toList(),
			parentId: data["parentId"],
			externalRef: data["externalRef"],
			unassignedResults: data["unassignedResults"].map((x0) => x0 ).toList(),
			assignedResults: data["assignedResults"].map((k0, v0) => MapEntry(k0, v0)),
			senderReferences: data["senderReferences"].map((k0, v0) => MapEntry(k0, v0)),
			secretForeignKeys: data["secretForeignKeys"].map((x0) => x0 ).toList(),
			cryptedForeignKeys: data["cryptedForeignKeys"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ).toList())),
			delegations: data["delegations"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ).toList())),
			encryptionKeys: data["encryptionKeys"].map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.fromJSON(x1) ).toList())),
			encryptedSelf: data["encryptedSelf"],
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
		);
	}

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
}