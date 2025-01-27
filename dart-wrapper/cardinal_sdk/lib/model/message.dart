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
	@override String? fromAddress = null;
	@override String? fromHealthcarePartyId = null;
	@override String? formId = null;
	int? _status = null;
	@ActualInt32() @override int? get status => _status;
	@ActualInt32() @override set status(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('status value cannot exceed 2147483647');
		}
		_status = value;
	}
	@override String? recipientsType = null;
	@override Set<String> recipients = {};
	@override Set<String> toAddresses = {};
	@override int? received = null;
	@override int? sent = null;
	@override Map<String, String> metas = {};
	@override Map<String, MessageReadStatus> readStatus = {};
	@override List<MessageAttachment> messageAttachments = [];
	@override String? transportGuid = null;
	@override String? remark = null;
	@override String? conversationGuid = null;
	@override String? subject = null;
	@override Set<String> invoiceIds = {};
	@override String? parentId = null;
	@override String? externalRef = null;
	@override Set<String> unassignedResults = {};
	@override Map<String, String> assignedResults = {};
	@override Map<String, String> senderReferences = {};
	@override Set<String> secretForeignKeys = {};
	@override Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override Map<String, Set<Delegation>> delegations = {};
	@override Map<String, Set<Delegation>> encryptionKeys = {};
	@override Base64String? encryptedSelf = null;
	@override SecurityMetadata? securityMetadata = null;
	DecryptedMessage(
		this.id,
		{
			int? status,
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
			String? fromAddress,
			String? fromHealthcarePartyId,
			String? formId,
			String? recipientsType,
			Set<String>? recipients,
			Set<String>? toAddresses,
			int? received,
			int? sent,
			Map<String, String>? metas,
			Map<String, MessageReadStatus>? readStatus,
			List<MessageAttachment>? messageAttachments,
			String? transportGuid,
			String? remark,
			String? conversationGuid,
			String? subject,
			Set<String>? invoiceIds,
			String? parentId,
			String? externalRef,
			Set<String>? unassignedResults,
			Map<String, String>? assignedResults,
			Map<String, String>? senderReferences,
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
		fromAddress = fromAddress ?? null,
		fromHealthcarePartyId = fromHealthcarePartyId ?? null,
		formId = formId ?? null,
		recipientsType = recipientsType ?? null,
		recipients = recipients ?? {},
		toAddresses = toAddresses ?? {},
		received = received ?? null,
		sent = sent ?? null,
		metas = metas ?? {},
		readStatus = readStatus ?? {},
		messageAttachments = messageAttachments ?? [],
		transportGuid = transportGuid ?? null,
		remark = remark ?? null,
		conversationGuid = conversationGuid ?? null,
		subject = subject ?? null,
		invoiceIds = invoiceIds ?? {},
		parentId = parentId ?? null,
		externalRef = externalRef ?? null,
		unassignedResults = unassignedResults ?? {},
		assignedResults = assignedResults ?? {},
		senderReferences = senderReferences ?? {},
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {},
		encryptedSelf = encryptedSelf ?? null,
		securityMetadata = securityMetadata ?? null,
		_status = status ?? null;

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
			(data["id"] as String),
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

class EncryptedMessage implements Message {
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
	@override String? fromAddress = null;
	@override String? fromHealthcarePartyId = null;
	@override String? formId = null;
	int? _status = null;
	@ActualInt32() @override int? get status => _status;
	@ActualInt32() @override set status(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('status value cannot exceed 2147483647');
		}
		_status = value;
	}
	@override String? recipientsType = null;
	@override Set<String> recipients = {};
	@override Set<String> toAddresses = {};
	@override int? received = null;
	@override int? sent = null;
	@override Map<String, String> metas = {};
	@override Map<String, MessageReadStatus> readStatus = {};
	@override List<MessageAttachment> messageAttachments = [];
	@override String? transportGuid = null;
	@override String? remark = null;
	@override String? conversationGuid = null;
	@override String? subject = null;
	@override Set<String> invoiceIds = {};
	@override String? parentId = null;
	@override String? externalRef = null;
	@override Set<String> unassignedResults = {};
	@override Map<String, String> assignedResults = {};
	@override Map<String, String> senderReferences = {};
	@override Set<String> secretForeignKeys = {};
	@override Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override Map<String, Set<Delegation>> delegations = {};
	@override Map<String, Set<Delegation>> encryptionKeys = {};
	@override Base64String? encryptedSelf = null;
	@override SecurityMetadata? securityMetadata = null;
	EncryptedMessage(
		this.id,
		{
			int? status,
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
			String? fromAddress,
			String? fromHealthcarePartyId,
			String? formId,
			String? recipientsType,
			Set<String>? recipients,
			Set<String>? toAddresses,
			int? received,
			int? sent,
			Map<String, String>? metas,
			Map<String, MessageReadStatus>? readStatus,
			List<MessageAttachment>? messageAttachments,
			String? transportGuid,
			String? remark,
			String? conversationGuid,
			String? subject,
			Set<String>? invoiceIds,
			String? parentId,
			String? externalRef,
			Set<String>? unassignedResults,
			Map<String, String>? assignedResults,
			Map<String, String>? senderReferences,
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
		fromAddress = fromAddress ?? null,
		fromHealthcarePartyId = fromHealthcarePartyId ?? null,
		formId = formId ?? null,
		recipientsType = recipientsType ?? null,
		recipients = recipients ?? {},
		toAddresses = toAddresses ?? {},
		received = received ?? null,
		sent = sent ?? null,
		metas = metas ?? {},
		readStatus = readStatus ?? {},
		messageAttachments = messageAttachments ?? [],
		transportGuid = transportGuid ?? null,
		remark = remark ?? null,
		conversationGuid = conversationGuid ?? null,
		subject = subject ?? null,
		invoiceIds = invoiceIds ?? {},
		parentId = parentId ?? null,
		externalRef = externalRef ?? null,
		unassignedResults = unassignedResults ?? {},
		assignedResults = assignedResults ?? {},
		senderReferences = senderReferences ?? {},
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {},
		encryptedSelf = encryptedSelf ?? null,
		securityMetadata = securityMetadata ?? null,
		_status = status ?? null;

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
			(data["id"] as String),
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