// This file is auto-generated
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
	@ActualInt32("This property cannot contain a value exceeding 2147483647") abstract int? status;
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
}

class DecryptedMessage implements Message {
	@override  String id;
	@override  String? rev;
	@override  int? created;
	@override  int? modified;
	@override  String? author;
	@override  String? responsible;
	@override  String? medicalLocationId;
	@override  Set<CodeStub> tags = {};
	@override  Set<CodeStub> codes = {};
	@override  int? endOfLife;
	@override  int? deletionDate;
	@override  String? fromAddress;
	@override  String? fromHealthcarePartyId;
	@override  String? formId;
	int? _status;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get status => _status;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set status(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('status value cannot exceed 2147483647');
		}
		_status = value;
	}
	@override  String? recipientsType;
	@override  Set<String> recipients = {};
	@override  Set<String> toAddresses = {};
	@override  int? received;
	@override  int? sent;
	@override  Map<String, String> metas = {};
	@override  Map<String, MessageReadStatus> readStatus = {};
	@override  List<MessageAttachment> messageAttachments = [];
	@override  String? transportGuid;
	@override  String? remark;
	@override  String? conversationGuid;
	@override  String? subject;
	@override  Set<String> invoiceIds = {};
	@override  String? parentId;
	@override  String? externalRef;
	@override  Set<String> unassignedResults = {};
	@override  Map<String, String> assignedResults = {};
	@override  Map<String, String> senderReferences = {};
	@override  Set<String> secretForeignKeys = {};
	@override  Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override  Map<String, Set<Delegation>> delegations = {};
	@override  Map<String, Set<Delegation>> encryptionKeys = {};
	@override  Base64String? encryptedSelf;
	@override  SecurityMetadata? securityMetadata;

	DecryptedMessage({
		required this.id,
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

	static Map<String, dynamic> encode(DecryptedMessage value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"created" : value.created,
			"modified" : value.modified,
			"author" : value.author,
			"responsible" : value.responsible,
			"medicalLocationId" : value.medicalLocationId,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)),
			"endOfLife" : value.endOfLife,
			"deletionDate" : value.deletionDate,
			"fromAddress" : value.fromAddress,
			"fromHealthcarePartyId" : value.fromHealthcarePartyId,
			"formId" : value.formId,
			"status" : value.status,
			"recipientsType" : value.recipientsType,
			"recipients" : value.recipients.map((x0) => x0),
			"toAddresses" : value.toAddresses.map((x0) => x0),
			"received" : value.received,
			"sent" : value.sent,
			"metas" : value.metas.map((k0, v0) => MapEntry(k0, v0)),
			"readStatus" : value.readStatus.map((k0, v0) => MapEntry(k0, MessageReadStatus.encode(v0))),
			"messageAttachments" : value.messageAttachments.map((x0) => MessageAttachment.encode(x0)),
			"transportGuid" : value.transportGuid,
			"remark" : value.remark,
			"conversationGuid" : value.conversationGuid,
			"subject" : value.subject,
			"invoiceIds" : value.invoiceIds.map((x0) => x0),
			"parentId" : value.parentId,
			"externalRef" : value.externalRef,
			"unassignedResults" : value.unassignedResults.map((x0) => x0),
			"assignedResults" : value.assignedResults.map((k0, v0) => MapEntry(k0, v0)),
			"senderReferences" : value.senderReferences.map((k0, v0) => MapEntry(k0, v0)),
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!)
		};
		return entityAsMap;
	}
}

class EncryptedMessage implements Message {
	@override  String id;
	@override  String? rev;
	@override  int? created;
	@override  int? modified;
	@override  String? author;
	@override  String? responsible;
	@override  String? medicalLocationId;
	@override  Set<CodeStub> tags = {};
	@override  Set<CodeStub> codes = {};
	@override  int? endOfLife;
	@override  int? deletionDate;
	@override  String? fromAddress;
	@override  String? fromHealthcarePartyId;
	@override  String? formId;
	int? _status;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get status => _status;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set status(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('status value cannot exceed 2147483647');
		}
		_status = value;
	}
	@override  String? recipientsType;
	@override  Set<String> recipients = {};
	@override  Set<String> toAddresses = {};
	@override  int? received;
	@override  int? sent;
	@override  Map<String, String> metas = {};
	@override  Map<String, MessageReadStatus> readStatus = {};
	@override  List<MessageAttachment> messageAttachments = [];
	@override  String? transportGuid;
	@override  String? remark;
	@override  String? conversationGuid;
	@override  String? subject;
	@override  Set<String> invoiceIds = {};
	@override  String? parentId;
	@override  String? externalRef;
	@override  Set<String> unassignedResults = {};
	@override  Map<String, String> assignedResults = {};
	@override  Map<String, String> senderReferences = {};
	@override  Set<String> secretForeignKeys = {};
	@override  Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override  Map<String, Set<Delegation>> delegations = {};
	@override  Map<String, Set<Delegation>> encryptionKeys = {};
	@override  Base64String? encryptedSelf;
	@override  SecurityMetadata? securityMetadata;

	EncryptedMessage({
		required this.id,
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

	static Map<String, dynamic> encode(EncryptedMessage value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"created" : value.created,
			"modified" : value.modified,
			"author" : value.author,
			"responsible" : value.responsible,
			"medicalLocationId" : value.medicalLocationId,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)),
			"endOfLife" : value.endOfLife,
			"deletionDate" : value.deletionDate,
			"fromAddress" : value.fromAddress,
			"fromHealthcarePartyId" : value.fromHealthcarePartyId,
			"formId" : value.formId,
			"status" : value.status,
			"recipientsType" : value.recipientsType,
			"recipients" : value.recipients.map((x0) => x0),
			"toAddresses" : value.toAddresses.map((x0) => x0),
			"received" : value.received,
			"sent" : value.sent,
			"metas" : value.metas.map((k0, v0) => MapEntry(k0, v0)),
			"readStatus" : value.readStatus.map((k0, v0) => MapEntry(k0, MessageReadStatus.encode(v0))),
			"messageAttachments" : value.messageAttachments.map((x0) => MessageAttachment.encode(x0)),
			"transportGuid" : value.transportGuid,
			"remark" : value.remark,
			"conversationGuid" : value.conversationGuid,
			"subject" : value.subject,
			"invoiceIds" : value.invoiceIds.map((x0) => x0),
			"parentId" : value.parentId,
			"externalRef" : value.externalRef,
			"unassignedResults" : value.unassignedResults.map((x0) => x0),
			"assignedResults" : value.assignedResults.map((k0, v0) => MapEntry(k0, v0)),
			"senderReferences" : value.senderReferences.map((k0, v0) => MapEntry(k0, v0)),
			"secretForeignKeys" : value.secretForeignKeys.map((x0) => x0),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!)
		};
		return entityAsMap;
	}
}