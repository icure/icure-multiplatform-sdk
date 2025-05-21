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
import 'package:freezed_annotation/freezed_annotation.dart';
part "service.freezed.dart";


sealed class Service implements Encryptable, ICureDocument<String> {
	@override abstract final String id;
	abstract final String? transactionId;
	abstract final List<Identifier> identifier;
	abstract final String? contactId;
	abstract final Set<String>? subContactIds;
	abstract final Set<String>? plansOfActionIds;
	abstract final Set<String>? healthElementsIds;
	abstract final Set<String>? formIds;
	abstract final Set<String>? secretForeignKeys;
	abstract final Map<String, Set<Delegation>> cryptedForeignKeys;
	abstract final Map<String, Set<Delegation>> delegations;
	abstract final Map<String, Set<Delegation>> encryptionKeys;
	abstract final String? label;
	abstract final int? index;
	Map<String, Content> get content;
	abstract final String? encryptedContent;
	abstract final Map<String, String> textIndexes;
	abstract final int? valueDate;
	abstract final int? openingDate;
	abstract final int? closingDate;
	abstract final String? formId;
	@override abstract final int? created;
	@override abstract final int? modified;
	@override abstract final int? endOfLife;
	@override abstract final String? author;
	@override abstract final String? responsible;
	@override abstract final String? medicalLocationId;
	abstract final String? comment;
	@actualInt32 abstract final int? status;
	abstract final Set<String> invoicingCodes;
	abstract final List<Annotation> notes;
	abstract final Map<LinkQualification, Map<String, String>> qualifiedLinks;
	@override abstract final Set<CodeStub> codes;
	@override abstract final Set<CodeStub> tags;
	@override abstract final Base64String? encryptedSelf;
	abstract final SecurityMetadata? securityMetadata;

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

@freezed
abstract class DecryptedService with _$DecryptedService implements Service {
	const factory DecryptedService({
		required String id,
		@Default(null) String? transactionId,
		@Default([]) List<Identifier> identifier,
		@Default(null) String? contactId,
		@Default(null) Set<String>? subContactIds,
		@Default(null) Set<String>? plansOfActionIds,
		@Default(null) Set<String>? healthElementsIds,
		@Default(null) Set<String>? formIds,
		@Default({}) Set<String>? secretForeignKeys,
		@Default({}) Map<String, Set<Delegation>> cryptedForeignKeys,
		@Default({}) Map<String, Set<Delegation>> delegations,
		@Default({}) Map<String, Set<Delegation>> encryptionKeys,
		@Default(null) String? label,
		@Default(null) int? index,
		@Default({}) Map<String, DecryptedContent> content,
		@Default(null) String? encryptedContent,
		@Default({}) Map<String, String> textIndexes,
		@Default(null) int? valueDate,
		@Default(null) int? openingDate,
		@Default(null) int? closingDate,
		@Default(null) String? formId,
		@Default(null) int? created,
		@Default(null) int? modified,
		@Default(null) int? endOfLife,
		@Default(null) String? author,
		@Default(null) String? responsible,
		@Default(null) String? medicalLocationId,
		@Default(null) String? comment,
		@Default(null) int? status,
		@Default({}) Set<String> invoicingCodes,
		@Default([]) List<Annotation> notes,
		@Default({}) Map<LinkQualification, Map<String, String>> qualifiedLinks,
		@Default({}) Set<CodeStub> codes,
		@Default({}) Set<CodeStub> tags,
		@Default(null) Base64String? encryptedSelf,
		@Default(null) SecurityMetadata? securityMetadata,
	}) = _DecryptedService;


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

	static DecryptedService fromJSON(Map<String, dynamic> data) {
		return DecryptedService(
			id: (data["id"] as String),
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
}

@freezed
abstract class EncryptedService with _$EncryptedService implements Service {
	const factory EncryptedService({
		required String id,
		@Default(null) String? transactionId,
		@Default([]) List<Identifier> identifier,
		@Default(null) String? contactId,
		@Default(null) Set<String>? subContactIds,
		@Default(null) Set<String>? plansOfActionIds,
		@Default(null) Set<String>? healthElementsIds,
		@Default(null) Set<String>? formIds,
		@Default({}) Set<String>? secretForeignKeys,
		@Default({}) Map<String, Set<Delegation>> cryptedForeignKeys,
		@Default({}) Map<String, Set<Delegation>> delegations,
		@Default({}) Map<String, Set<Delegation>> encryptionKeys,
		@Default(null) String? label,
		@Default(null) int? index,
		@Default({}) Map<String, EncryptedContent> content,
		@Default(null) String? encryptedContent,
		@Default({}) Map<String, String> textIndexes,
		@Default(null) int? valueDate,
		@Default(null) int? openingDate,
		@Default(null) int? closingDate,
		@Default(null) String? formId,
		@Default(null) int? created,
		@Default(null) int? modified,
		@Default(null) int? endOfLife,
		@Default(null) String? author,
		@Default(null) String? responsible,
		@Default(null) String? medicalLocationId,
		@Default(null) String? comment,
		@Default(null) int? status,
		@Default({}) Set<String> invoicingCodes,
		@Default([]) List<Annotation> notes,
		@Default({}) Map<LinkQualification, Map<String, String>> qualifiedLinks,
		@Default({}) Set<CodeStub> codes,
		@Default({}) Set<CodeStub> tags,
		@Default(null) Base64String? encryptedSelf,
		@Default(null) SecurityMetadata? securityMetadata,
	}) = _EncryptedService;


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

	static EncryptedService fromJSON(Map<String, dynamic> data) {
		return EncryptedService(
			id: (data["id"] as String),
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
}