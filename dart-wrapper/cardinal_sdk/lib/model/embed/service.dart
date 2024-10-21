// This file is auto-generated
import 'package:cardinal_sdk/model/base/identifier.dart';
import 'package:cardinal_sdk/model/embed/delegation.dart';
import 'package:cardinal_sdk/model/embed/content.dart';
import 'package:cardinal_sdk/annotations/actual_int32.dart';
import 'package:cardinal_sdk/model/embed/annotation.dart';
import 'package:cardinal_sdk/model/base/link_qualification.dart';
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/security_metadata.dart';
import 'package:cardinal_sdk/model/embed/service.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';
import 'package:cardinal_sdk/model/base/icure_document.dart';


sealed class Service implements Encryptable, ICureDocument<String> {
	@override abstract String id;
	abstract String? transactionId;
	abstract List<Identifier> identifier;
	abstract String? contactId;
	abstract Set<String>? subContactIds;
	abstract Set<String>? plansOfActionIds;
	abstract Set<String>? healthElementsIds;
	abstract Set<String>? formIds;
	abstract Set<String>? secretForeignKeys;
	abstract Map<String, Set<Delegation>> cryptedForeignKeys;
	abstract Map<String, Set<Delegation>> delegations;
	abstract Map<String, Set<Delegation>> encryptionKeys;
	abstract String? label;
	abstract int? index;
	Map<String, Content> get content;
	abstract String? encryptedContent;
	abstract Map<String, String> textIndexes;
	abstract int? valueDate;
	abstract int? openingDate;
	abstract int? closingDate;
	abstract String? formId;
	@override abstract int? created;
	@override abstract int? modified;
	@override abstract int? endOfLife;
	@override abstract String? author;
	@override abstract String? responsible;
	@override abstract String? medicalLocationId;
	abstract String? comment;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") abstract int? status;
	abstract Set<String> invoicingCodes;
	abstract List<Annotation> notes;
	abstract Map<LinkQualification, Map<String, String>> qualifiedLinks;
	@override abstract Set<CodeStub> codes;
	@override abstract Set<CodeStub> tags;
	@override abstract Base64String? encryptedSelf;
	abstract SecurityMetadata? securityMetadata;


	static Map<String, dynamic> encode(Service value) {
		switch (value) {
			case DecryptedService entity:
				Map<String, dynamic> entityJson = DecryptedService.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.DecryptedService";
				return entityJson;
			case EncryptedService entity:
				Map<String, dynamic> entityJson = EncryptedService.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.EncryptedService";
				return entityJson;
		}
	}
}

class DecryptedService implements Service {
	@override  String id;
	@override  String? transactionId;
	@override  List<Identifier> identifier = [];
	@override  String? contactId;
	@override  Set<String>? subContactIds;
	@override  Set<String>? plansOfActionIds;
	@override  Set<String>? healthElementsIds;
	@override  Set<String>? formIds;
	@override  Set<String>? secretForeignKeys = {};
	@override  Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override  Map<String, Set<Delegation>> delegations = {};
	@override  Map<String, Set<Delegation>> encryptionKeys = {};
	@override  String? label;
	@override  int? index;
	@override  Map<String, DecryptedContent> content = {};
	@override  String? encryptedContent;
	@override  Map<String, String> textIndexes = {};
	@override  int? valueDate;
	@override  int? openingDate;
	@override  int? closingDate;
	@override  String? formId;
	@override  int? created;
	@override  int? modified;
	@override  int? endOfLife;
	@override  String? author;
	@override  String? responsible;
	@override  String? medicalLocationId;
	@override  String? comment;
	int? _status;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get status => _status;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set status(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('status value cannot exceed 2147483647');
		}
		_status = value;
	}
	@override  Set<String> invoicingCodes = {};
	@override  List<Annotation> notes = [];
	@override  Map<LinkQualification, Map<String, String>> qualifiedLinks = {};
	@override  Set<CodeStub> codes = {};
	@override  Set<CodeStub> tags = {};
	@override  Base64String? encryptedSelf;
	@override  SecurityMetadata? securityMetadata;

	DecryptedService({
		required this.id,
		int? status,
		this.transactionId,
		this.contactId,
		this.subContactIds,
		this.plansOfActionIds,
		this.healthElementsIds,
		this.formIds,
		this.label,
		this.index,
		this.encryptedContent,
		this.valueDate,
		this.openingDate,
		this.closingDate,
		this.formId,
		this.created,
		this.modified,
		this.endOfLife,
		this.author,
		this.responsible,
		this.medicalLocationId,
		this.comment,
		this.encryptedSelf,
		this.securityMetadata,
		List<Identifier>? identifier,
		Set<String>? secretForeignKeys,
		Map<String, Set<Delegation>>? cryptedForeignKeys,
		Map<String, Set<Delegation>>? delegations,
		Map<String, Set<Delegation>>? encryptionKeys,
		Map<String, DecryptedContent>? content,
		Map<String, String>? textIndexes,
		Set<String>? invoicingCodes,
		List<Annotation>? notes,
		Map<LinkQualification, Map<String, String>>? qualifiedLinks,
		Set<CodeStub>? codes,
		Set<CodeStub>? tags
	}) : identifier = identifier ?? [],
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {},
		content = content ?? {},
		textIndexes = textIndexes ?? {},
		invoicingCodes = invoicingCodes ?? {},
		notes = notes ?? [],
		qualifiedLinks = qualifiedLinks ?? {},
		codes = codes ?? {},
		tags = tags ?? {},
		_status = status;

	static Map<String, dynamic> encode(DecryptedService value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"transactionId" : value.transactionId,
			"identifier" : value.identifier.map((x0) => Identifier.encode(x0)),
			"contactId" : value.contactId,
			"subContactIds" : value.subContactIds?.map((x0) => x0),
			"plansOfActionIds" : value.plansOfActionIds?.map((x0) => x0),
			"healthElementsIds" : value.healthElementsIds?.map((x0) => x0),
			"formIds" : value.formIds?.map((x0) => x0),
			"secretForeignKeys" : value.secretForeignKeys?.map((x0) => x0),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"label" : value.label,
			"index" : value.index,
			"content" : value.content.map((k0, v0) => MapEntry(k0, DecryptedContent.encode(v0))),
			"encryptedContent" : value.encryptedContent,
			"textIndexes" : value.textIndexes.map((k0, v0) => MapEntry(k0, v0)),
			"valueDate" : value.valueDate,
			"openingDate" : value.openingDate,
			"closingDate" : value.closingDate,
			"formId" : value.formId,
			"created" : value.created,
			"modified" : value.modified,
			"endOfLife" : value.endOfLife,
			"author" : value.author,
			"responsible" : value.responsible,
			"medicalLocationId" : value.medicalLocationId,
			"comment" : value.comment,
			"status" : value.status,
			"invoicingCodes" : value.invoicingCodes.map((x0) => x0),
			"notes" : value.notes.map((x0) => Annotation.encode(x0)),
			"qualifiedLinks" : value.qualifiedLinks.map((k0, v0) => MapEntry(LinkQualification.encode(k0), v0.map((k1, v1) => MapEntry(k1, v1)))),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)),
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!)
		};
		return entityAsMap;
	}
}

class EncryptedService implements Service {
	@override  String id;
	@override  String? transactionId;
	@override  List<Identifier> identifier = [];
	@override  String? contactId;
	@override  Set<String>? subContactIds;
	@override  Set<String>? plansOfActionIds;
	@override  Set<String>? healthElementsIds;
	@override  Set<String>? formIds;
	@override  Set<String>? secretForeignKeys = {};
	@override  Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override  Map<String, Set<Delegation>> delegations = {};
	@override  Map<String, Set<Delegation>> encryptionKeys = {};
	@override  String? label;
	@override  int? index;
	@override  Map<String, EncryptedContent> content = {};
	@override  String? encryptedContent;
	@override  Map<String, String> textIndexes = {};
	@override  int? valueDate;
	@override  int? openingDate;
	@override  int? closingDate;
	@override  String? formId;
	@override  int? created;
	@override  int? modified;
	@override  int? endOfLife;
	@override  String? author;
	@override  String? responsible;
	@override  String? medicalLocationId;
	@override  String? comment;
	int? _status;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get status => _status;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set status(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('status value cannot exceed 2147483647');
		}
		_status = value;
	}
	@override  Set<String> invoicingCodes = {};
	@override  List<Annotation> notes = [];
	@override  Map<LinkQualification, Map<String, String>> qualifiedLinks = {};
	@override  Set<CodeStub> codes = {};
	@override  Set<CodeStub> tags = {};
	@override  Base64String? encryptedSelf;
	@override  SecurityMetadata? securityMetadata;

	EncryptedService({
		required this.id,
		int? status,
		this.transactionId,
		this.contactId,
		this.subContactIds,
		this.plansOfActionIds,
		this.healthElementsIds,
		this.formIds,
		this.label,
		this.index,
		this.encryptedContent,
		this.valueDate,
		this.openingDate,
		this.closingDate,
		this.formId,
		this.created,
		this.modified,
		this.endOfLife,
		this.author,
		this.responsible,
		this.medicalLocationId,
		this.comment,
		this.encryptedSelf,
		this.securityMetadata,
		List<Identifier>? identifier,
		Set<String>? secretForeignKeys,
		Map<String, Set<Delegation>>? cryptedForeignKeys,
		Map<String, Set<Delegation>>? delegations,
		Map<String, Set<Delegation>>? encryptionKeys,
		Map<String, EncryptedContent>? content,
		Map<String, String>? textIndexes,
		Set<String>? invoicingCodes,
		List<Annotation>? notes,
		Map<LinkQualification, Map<String, String>>? qualifiedLinks,
		Set<CodeStub>? codes,
		Set<CodeStub>? tags
	}) : identifier = identifier ?? [],
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {},
		content = content ?? {},
		textIndexes = textIndexes ?? {},
		invoicingCodes = invoicingCodes ?? {},
		notes = notes ?? [],
		qualifiedLinks = qualifiedLinks ?? {},
		codes = codes ?? {},
		tags = tags ?? {},
		_status = status;

	static Map<String, dynamic> encode(EncryptedService value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"transactionId" : value.transactionId,
			"identifier" : value.identifier.map((x0) => Identifier.encode(x0)),
			"contactId" : value.contactId,
			"subContactIds" : value.subContactIds?.map((x0) => x0),
			"plansOfActionIds" : value.plansOfActionIds?.map((x0) => x0),
			"healthElementsIds" : value.healthElementsIds?.map((x0) => x0),
			"formIds" : value.formIds?.map((x0) => x0),
			"secretForeignKeys" : value.secretForeignKeys?.map((x0) => x0),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)))),
			"label" : value.label,
			"index" : value.index,
			"content" : value.content.map((k0, v0) => MapEntry(k0, EncryptedContent.encode(v0))),
			"encryptedContent" : value.encryptedContent,
			"textIndexes" : value.textIndexes.map((k0, v0) => MapEntry(k0, v0)),
			"valueDate" : value.valueDate,
			"openingDate" : value.openingDate,
			"closingDate" : value.closingDate,
			"formId" : value.formId,
			"created" : value.created,
			"modified" : value.modified,
			"endOfLife" : value.endOfLife,
			"author" : value.author,
			"responsible" : value.responsible,
			"medicalLocationId" : value.medicalLocationId,
			"comment" : value.comment,
			"status" : value.status,
			"invoicingCodes" : value.invoicingCodes.map((x0) => x0),
			"notes" : value.notes.map((x0) => Annotation.encode(x0)),
			"qualifiedLinks" : value.qualifiedLinks.map((k0, v0) => MapEntry(LinkQualification.encode(k0), v0.map((k1, v1) => MapEntry(k1, v1)))),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)),
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!)
		};
		return entityAsMap;
	}
}