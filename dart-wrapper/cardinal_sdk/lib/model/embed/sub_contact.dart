// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/annotations/actual_int32.dart';
import 'package:cardinal_sdk/model/embed/service_link.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/sub_contact.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';
import 'package:cardinal_sdk/model/base/icure_document.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "sub_contact.freezed.dart";


sealed class SubContact implements Encryptable, ICureDocument<String?> {
	@override abstract final String? id;
	@override abstract final int? created;
	@override abstract final int? modified;
	@override abstract final String? author;
	@override abstract final String? responsible;
	@override abstract final String? medicalLocationId;
	@override abstract final Set<CodeStub> tags;
	@override abstract final Set<CodeStub> codes;
	@override abstract final int? endOfLife;
	abstract final String? descr;
	abstract final String? protocol;
	@actualInt32 abstract final int? status;
	abstract final String? formId;
	abstract final String? planOfActionId;
	abstract final String? healthElementId;
	abstract final String? classificationId;
	abstract final List<ServiceLink> services;
	@override abstract final Base64String? encryptedSelf;

	static Map<String, dynamic> encode(SubContact value) {
		switch (value) {
			case EncryptedSubContact entity:
				Map<String, dynamic> entityJson = EncryptedSubContact.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.EncryptedSubContact";
				return entityJson;
			case DecryptedSubContact entity:
				Map<String, dynamic> entityJson = DecryptedSubContact.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.DecryptedSubContact";
				return entityJson;
		}
	}

	static SubContact fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.embed.EncryptedSubContact":
				return EncryptedSubContact.fromJSON(data);
			case "com.icure.cardinal.sdk.model.embed.DecryptedSubContact":
				return DecryptedSubContact.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

@freezed
abstract class EncryptedSubContact with _$EncryptedSubContact implements SubContact {
	const factory EncryptedSubContact({
		@Default(null) String? id,
		@Default(null) int? created,
		@Default(null) int? modified,
		@Default(null) String? author,
		@Default(null) String? responsible,
		@Default(null) String? medicalLocationId,
		@Default({}) Set<CodeStub> tags,
		@Default({}) Set<CodeStub> codes,
		@Default(null) int? endOfLife,
		@Default(null) String? descr,
		@Default(null) String? protocol,
		@Default(null) int? status,
		@Default(null) String? formId,
		@Default(null) String? planOfActionId,
		@Default(null) String? healthElementId,
		@Default(null) String? classificationId,
		@Default([]) List<ServiceLink> services,
		@Default(null) Base64String? encryptedSelf,
	}) = _EncryptedSubContact;


	static Map<String, dynamic> encode(EncryptedSubContact value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"created" : value.created,
			"modified" : value.modified,
			"author" : value.author,
			"responsible" : value.responsible,
			"medicalLocationId" : value.medicalLocationId,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)).toList(),
			"endOfLife" : value.endOfLife,
			"descr" : value.descr,
			"protocol" : value.protocol,
			"status" : value.status,
			"formId" : value.formId,
			"planOfActionId" : value.planOfActionId,
			"healthElementId" : value.healthElementId,
			"classificationId" : value.classificationId,
			"services" : value.services.map((x0) => ServiceLink.encode(x0)).toList(),
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}

	static EncryptedSubContact fromJSON(Map<String, dynamic> data) {
		return EncryptedSubContact(
			status: (data["status"] as int?),
			id: (data["id"] as String?),
			created: (data["created"] as int?),
			modified: (data["modified"] as int?),
			author: (data["author"] as String?),
			responsible: (data["responsible"] as String?),
			medicalLocationId: (data["medicalLocationId"] as String?),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			endOfLife: (data["endOfLife"] as int?),
			descr: (data["descr"] as String?),
			protocol: (data["protocol"] as String?),
			formId: (data["formId"] as String?),
			planOfActionId: (data["planOfActionId"] as String?),
			healthElementId: (data["healthElementId"] as String?),
			classificationId: (data["classificationId"] as String?),
			services: (data["services"] as List<dynamic>).map((x0) => ServiceLink.fromJSON(x0) ).toList(),
			encryptedSelf: (data["encryptedSelf"] as Base64String?)
		);
	}
}

@freezed
abstract class DecryptedSubContact with _$DecryptedSubContact implements SubContact {
	const factory DecryptedSubContact({
		@Default(null) String? id,
		@Default(null) int? created,
		@Default(null) int? modified,
		@Default(null) String? author,
		@Default(null) String? responsible,
		@Default(null) String? medicalLocationId,
		@Default({}) Set<CodeStub> tags,
		@Default({}) Set<CodeStub> codes,
		@Default(null) int? endOfLife,
		@Default(null) String? descr,
		@Default(null) String? protocol,
		@Default(null) int? status,
		@Default(null) String? formId,
		@Default(null) String? planOfActionId,
		@Default(null) String? healthElementId,
		@Default(null) String? classificationId,
		@Default([]) List<ServiceLink> services,
		@Default(null) Base64String? encryptedSelf,
	}) = _DecryptedSubContact;


	static Map<String, dynamic> encode(DecryptedSubContact value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"created" : value.created,
			"modified" : value.modified,
			"author" : value.author,
			"responsible" : value.responsible,
			"medicalLocationId" : value.medicalLocationId,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)).toList(),
			"endOfLife" : value.endOfLife,
			"descr" : value.descr,
			"protocol" : value.protocol,
			"status" : value.status,
			"formId" : value.formId,
			"planOfActionId" : value.planOfActionId,
			"healthElementId" : value.healthElementId,
			"classificationId" : value.classificationId,
			"services" : value.services.map((x0) => ServiceLink.encode(x0)).toList(),
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}

	static DecryptedSubContact fromJSON(Map<String, dynamic> data) {
		return DecryptedSubContact(
			status: (data["status"] as int?),
			id: (data["id"] as String?),
			created: (data["created"] as int?),
			modified: (data["modified"] as int?),
			author: (data["author"] as String?),
			responsible: (data["responsible"] as String?),
			medicalLocationId: (data["medicalLocationId"] as String?),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			endOfLife: (data["endOfLife"] as int?),
			descr: (data["descr"] as String?),
			protocol: (data["protocol"] as String?),
			formId: (data["formId"] as String?),
			planOfActionId: (data["planOfActionId"] as String?),
			healthElementId: (data["healthElementId"] as String?),
			classificationId: (data["classificationId"] as String?),
			services: (data["services"] as List<dynamic>).map((x0) => ServiceLink.fromJSON(x0) ).toList(),
			encryptedSelf: (data["encryptedSelf"] as Base64String?)
		);
	}
}