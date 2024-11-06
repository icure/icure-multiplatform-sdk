// auto-generated file
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
	@ActualInt32() abstract int? status;
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

	static Service fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.embed.DecryptedService":
				return DecryptedService.fromJSON(data);
			case "com.icure.cardinal.sdk.model.embed.EncryptedService":
				return EncryptedService.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

class DecryptedService implements Service {
	@override String id;
	@override String? transactionId = null;
	@override List<Identifier> identifier = [];
	@override String? contactId = null;
	@override Set<String>? subContactIds = null;
	@override Set<String>? plansOfActionIds = null;
	@override Set<String>? healthElementsIds = null;
	@override Set<String>? formIds = null;
	@override Set<String>? secretForeignKeys = {};
	@override Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override Map<String, Set<Delegation>> delegations = {};
	@override Map<String, Set<Delegation>> encryptionKeys = {};
	@override String? label = null;
	@override int? index = null;
	@override Map<String, DecryptedContent> content = {};
	@override String? encryptedContent = null;
	@override Map<String, String> textIndexes = {};
	@override int? valueDate = null;
	@override int? openingDate = null;
	@override int? closingDate = null;
	@override String? formId = null;
	@override int? created = null;
	@override int? modified = null;
	@override int? endOfLife = null;
	@override String? author = null;
	@override String? responsible = null;
	@override String? medicalLocationId = null;
	@override String? comment = null;
	int? _status = null;
	@ActualInt32() @override int? get status => _status;
	@ActualInt32() @override set status(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('status value cannot exceed 2147483647');
		}
		_status = value;
	}
	@override Set<String> invoicingCodes = {};
	@override List<Annotation> notes = [];
	@override Map<LinkQualification, Map<String, String>> qualifiedLinks = {};
	@override Set<CodeStub> codes = {};
	@override Set<CodeStub> tags = {};
	@override Base64String? encryptedSelf = null;
	@override SecurityMetadata? securityMetadata = null;
	DecryptedService(
		this.id,
		{
			int? status,
			String? transactionId,
			List<Identifier>? identifier,
			String? contactId,
			Set<String>? subContactIds,
			Set<String>? plansOfActionIds,
			Set<String>? healthElementsIds,
			Set<String>? formIds,
			Set<String>? secretForeignKeys,
			Map<String, Set<Delegation>>? cryptedForeignKeys,
			Map<String, Set<Delegation>>? delegations,
			Map<String, Set<Delegation>>? encryptionKeys,
			String? label,
			int? index,
			Map<String, DecryptedContent>? content,
			String? encryptedContent,
			Map<String, String>? textIndexes,
			int? valueDate,
			int? openingDate,
			int? closingDate,
			String? formId,
			int? created,
			int? modified,
			int? endOfLife,
			String? author,
			String? responsible,
			String? medicalLocationId,
			String? comment,
			Set<String>? invoicingCodes,
			List<Annotation>? notes,
			Map<LinkQualification, Map<String, String>>? qualifiedLinks,
			Set<CodeStub>? codes,
			Set<CodeStub>? tags,
			Base64String? encryptedSelf,
			SecurityMetadata? securityMetadata
		}) : transactionId = transactionId ?? null,
		identifier = identifier ?? [],
		contactId = contactId ?? null,
		subContactIds = subContactIds ?? null,
		plansOfActionIds = plansOfActionIds ?? null,
		healthElementsIds = healthElementsIds ?? null,
		formIds = formIds ?? null,
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {},
		label = label ?? null,
		index = index ?? null,
		content = content ?? {},
		encryptedContent = encryptedContent ?? null,
		textIndexes = textIndexes ?? {},
		valueDate = valueDate ?? null,
		openingDate = openingDate ?? null,
		closingDate = closingDate ?? null,
		formId = formId ?? null,
		created = created ?? null,
		modified = modified ?? null,
		endOfLife = endOfLife ?? null,
		author = author ?? null,
		responsible = responsible ?? null,
		medicalLocationId = medicalLocationId ?? null,
		comment = comment ?? null,
		invoicingCodes = invoicingCodes ?? {},
		notes = notes ?? [],
		qualifiedLinks = qualifiedLinks ?? {},
		codes = codes ?? {},
		tags = tags ?? {},
		encryptedSelf = encryptedSelf ?? null,
		securityMetadata = securityMetadata ?? null,
		_status = status ?? null;

	factory DecryptedService.fromJSON(Map<String, dynamic> data) {
		return DecryptedService(
			(data["id"] as String),
			status: (data["status"] as int?),
			transactionId: (data["transactionId"] as String?),
			identifier: (data["identifier"] as List<dynamic>).map((x0) => Identifier.fromJSON(x0) ).toList(),
			contactId: (data["contactId"] as String?),
			subContactIds: (data["subContactIds"] as List<dynamic>?)?.map((x0) => (x0 as String) ).toSet(),
			plansOfActionIds: (data["plansOfActionIds"] as List<dynamic>?)?.map((x0) => (x0 as String) ).toSet(),
			healthElementsIds: (data["healthElementsIds"] as List<dynamic>?)?.map((x0) => (x0 as String) ).toSet(),
			formIds: (data["formIds"] as List<dynamic>?)?.map((x0) => (x0 as String) ).toSet(),
			secretForeignKeys: (data["secretForeignKeys"] as List<dynamic>?)?.map((x0) => (x0 as String) ).toSet(),
			cryptedForeignKeys: (data["cryptedForeignKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			delegations: (data["delegations"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptionKeys: (data["encryptionKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			label: (data["label"] as String?),
			index: (data["index"] as int?),
			content: (data["content"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), DecryptedContent.fromJSON(v0))),
			encryptedContent: (data["encryptedContent"] as String?),
			textIndexes: (data["textIndexes"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			valueDate: (data["valueDate"] as int?),
			openingDate: (data["openingDate"] as int?),
			closingDate: (data["closingDate"] as int?),
			formId: (data["formId"] as String?),
			created: (data["created"] as int?),
			modified: (data["modified"] as int?),
			endOfLife: (data["endOfLife"] as int?),
			author: (data["author"] as String?),
			responsible: (data["responsible"] as String?),
			medicalLocationId: (data["medicalLocationId"] as String?),
			comment: (data["comment"] as String?),
			invoicingCodes: (data["invoicingCodes"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			notes: (data["notes"] as List<dynamic>).map((x0) => Annotation.fromJSON(x0) ).toList(),
			qualifiedLinks: (data["qualifiedLinks"] as Map<String, dynamic>).map((k0, v0) => MapEntry(LinkQualification.fromJSON(k0), (v0 as Map<String, dynamic>).map((k1, v1) => MapEntry((k1 as String), (v1 as String))))),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
		);
	}

	static Map<String, dynamic> encode(DecryptedService value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"transactionId" : value.transactionId,
			"identifier" : value.identifier.map((x0) => Identifier.encode(x0)).toList(),
			"contactId" : value.contactId,
			"subContactIds" : value.subContactIds?.map((x0) => x0).toList(),
			"plansOfActionIds" : value.plansOfActionIds?.map((x0) => x0).toList(),
			"healthElementsIds" : value.healthElementsIds?.map((x0) => x0).toList(),
			"formIds" : value.formIds?.map((x0) => x0).toList(),
			"secretForeignKeys" : value.secretForeignKeys?.map((x0) => x0).toList(),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
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
			"invoicingCodes" : value.invoicingCodes.map((x0) => x0).toList(),
			"notes" : value.notes.map((x0) => Annotation.encode(x0)).toList(),
			"qualifiedLinks" : value.qualifiedLinks.map((k0, v0) => MapEntry(LinkQualification.encode(k0), v0.map((k1, v1) => MapEntry(k1, v1)))),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)).toList(),
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!)
		};
		return entityAsMap;
	}
}

class EncryptedService implements Service {
	@override String id;
	@override String? transactionId = null;
	@override List<Identifier> identifier = [];
	@override String? contactId = null;
	@override Set<String>? subContactIds = null;
	@override Set<String>? plansOfActionIds = null;
	@override Set<String>? healthElementsIds = null;
	@override Set<String>? formIds = null;
	@override Set<String>? secretForeignKeys = {};
	@override Map<String, Set<Delegation>> cryptedForeignKeys = {};
	@override Map<String, Set<Delegation>> delegations = {};
	@override Map<String, Set<Delegation>> encryptionKeys = {};
	@override String? label = null;
	@override int? index = null;
	@override Map<String, EncryptedContent> content = {};
	@override String? encryptedContent = null;
	@override Map<String, String> textIndexes = {};
	@override int? valueDate = null;
	@override int? openingDate = null;
	@override int? closingDate = null;
	@override String? formId = null;
	@override int? created = null;
	@override int? modified = null;
	@override int? endOfLife = null;
	@override String? author = null;
	@override String? responsible = null;
	@override String? medicalLocationId = null;
	@override String? comment = null;
	int? _status = null;
	@ActualInt32() @override int? get status => _status;
	@ActualInt32() @override set status(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('status value cannot exceed 2147483647');
		}
		_status = value;
	}
	@override Set<String> invoicingCodes = {};
	@override List<Annotation> notes = [];
	@override Map<LinkQualification, Map<String, String>> qualifiedLinks = {};
	@override Set<CodeStub> codes = {};
	@override Set<CodeStub> tags = {};
	@override Base64String? encryptedSelf = null;
	@override SecurityMetadata? securityMetadata = null;
	EncryptedService(
		this.id,
		{
			int? status,
			String? transactionId,
			List<Identifier>? identifier,
			String? contactId,
			Set<String>? subContactIds,
			Set<String>? plansOfActionIds,
			Set<String>? healthElementsIds,
			Set<String>? formIds,
			Set<String>? secretForeignKeys,
			Map<String, Set<Delegation>>? cryptedForeignKeys,
			Map<String, Set<Delegation>>? delegations,
			Map<String, Set<Delegation>>? encryptionKeys,
			String? label,
			int? index,
			Map<String, EncryptedContent>? content,
			String? encryptedContent,
			Map<String, String>? textIndexes,
			int? valueDate,
			int? openingDate,
			int? closingDate,
			String? formId,
			int? created,
			int? modified,
			int? endOfLife,
			String? author,
			String? responsible,
			String? medicalLocationId,
			String? comment,
			Set<String>? invoicingCodes,
			List<Annotation>? notes,
			Map<LinkQualification, Map<String, String>>? qualifiedLinks,
			Set<CodeStub>? codes,
			Set<CodeStub>? tags,
			Base64String? encryptedSelf,
			SecurityMetadata? securityMetadata
		}) : transactionId = transactionId ?? null,
		identifier = identifier ?? [],
		contactId = contactId ?? null,
		subContactIds = subContactIds ?? null,
		plansOfActionIds = plansOfActionIds ?? null,
		healthElementsIds = healthElementsIds ?? null,
		formIds = formIds ?? null,
		secretForeignKeys = secretForeignKeys ?? {},
		cryptedForeignKeys = cryptedForeignKeys ?? {},
		delegations = delegations ?? {},
		encryptionKeys = encryptionKeys ?? {},
		label = label ?? null,
		index = index ?? null,
		content = content ?? {},
		encryptedContent = encryptedContent ?? null,
		textIndexes = textIndexes ?? {},
		valueDate = valueDate ?? null,
		openingDate = openingDate ?? null,
		closingDate = closingDate ?? null,
		formId = formId ?? null,
		created = created ?? null,
		modified = modified ?? null,
		endOfLife = endOfLife ?? null,
		author = author ?? null,
		responsible = responsible ?? null,
		medicalLocationId = medicalLocationId ?? null,
		comment = comment ?? null,
		invoicingCodes = invoicingCodes ?? {},
		notes = notes ?? [],
		qualifiedLinks = qualifiedLinks ?? {},
		codes = codes ?? {},
		tags = tags ?? {},
		encryptedSelf = encryptedSelf ?? null,
		securityMetadata = securityMetadata ?? null,
		_status = status ?? null;

	factory EncryptedService.fromJSON(Map<String, dynamic> data) {
		return EncryptedService(
			(data["id"] as String),
			status: (data["status"] as int?),
			transactionId: (data["transactionId"] as String?),
			identifier: (data["identifier"] as List<dynamic>).map((x0) => Identifier.fromJSON(x0) ).toList(),
			contactId: (data["contactId"] as String?),
			subContactIds: (data["subContactIds"] as List<dynamic>?)?.map((x0) => (x0 as String) ).toSet(),
			plansOfActionIds: (data["plansOfActionIds"] as List<dynamic>?)?.map((x0) => (x0 as String) ).toSet(),
			healthElementsIds: (data["healthElementsIds"] as List<dynamic>?)?.map((x0) => (x0 as String) ).toSet(),
			formIds: (data["formIds"] as List<dynamic>?)?.map((x0) => (x0 as String) ).toSet(),
			secretForeignKeys: (data["secretForeignKeys"] as List<dynamic>?)?.map((x0) => (x0 as String) ).toSet(),
			cryptedForeignKeys: (data["cryptedForeignKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			delegations: (data["delegations"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			encryptionKeys: (data["encryptionKeys"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as List<dynamic>).map((x1) => Delegation.fromJSON(x1) ).toSet())),
			label: (data["label"] as String?),
			index: (data["index"] as int?),
			content: (data["content"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), EncryptedContent.fromJSON(v0))),
			encryptedContent: (data["encryptedContent"] as String?),
			textIndexes: (data["textIndexes"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			valueDate: (data["valueDate"] as int?),
			openingDate: (data["openingDate"] as int?),
			closingDate: (data["closingDate"] as int?),
			formId: (data["formId"] as String?),
			created: (data["created"] as int?),
			modified: (data["modified"] as int?),
			endOfLife: (data["endOfLife"] as int?),
			author: (data["author"] as String?),
			responsible: (data["responsible"] as String?),
			medicalLocationId: (data["medicalLocationId"] as String?),
			comment: (data["comment"] as String?),
			invoicingCodes: (data["invoicingCodes"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			notes: (data["notes"] as List<dynamic>).map((x0) => Annotation.fromJSON(x0) ).toList(),
			qualifiedLinks: (data["qualifiedLinks"] as Map<String, dynamic>).map((k0, v0) => MapEntry(LinkQualification.fromJSON(k0), (v0 as Map<String, dynamic>).map((k1, v1) => MapEntry((k1 as String), (v1 as String))))),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
			securityMetadata: data["securityMetadata"] == null ? null : SecurityMetadata.fromJSON(data["securityMetadata"]),
		);
	}

	static Map<String, dynamic> encode(EncryptedService value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"transactionId" : value.transactionId,
			"identifier" : value.identifier.map((x0) => Identifier.encode(x0)).toList(),
			"contactId" : value.contactId,
			"subContactIds" : value.subContactIds?.map((x0) => x0).toList(),
			"plansOfActionIds" : value.plansOfActionIds?.map((x0) => x0).toList(),
			"healthElementsIds" : value.healthElementsIds?.map((x0) => x0).toList(),
			"formIds" : value.formIds?.map((x0) => x0).toList(),
			"secretForeignKeys" : value.secretForeignKeys?.map((x0) => x0).toList(),
			"cryptedForeignKeys" : value.cryptedForeignKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"delegations" : value.delegations.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
			"encryptionKeys" : value.encryptionKeys.map((k0, v0) => MapEntry(k0, v0.map((x1) => Delegation.encode(x1)).toList())),
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
			"invoicingCodes" : value.invoicingCodes.map((x0) => x0).toList(),
			"notes" : value.notes.map((x0) => Annotation.encode(x0)).toList(),
			"qualifiedLinks" : value.qualifiedLinks.map((k0, v0) => MapEntry(LinkQualification.encode(k0), v0.map((k1, v1) => MapEntry(k1, v1)))),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)).toList(),
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"encryptedSelf" : value.encryptedSelf,
			"securityMetadata" : value.securityMetadata == null ? null : SecurityMetadata.encode(value.securityMetadata!)
		};
		return entityAsMap;
	}
}