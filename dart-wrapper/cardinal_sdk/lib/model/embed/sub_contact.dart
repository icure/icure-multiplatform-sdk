// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/annotations/actual_int32.dart';
import 'package:cardinal_sdk/model/embed/service_link.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/sub_contact.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';
import 'package:cardinal_sdk/model/base/icure_document.dart';


sealed class SubContact implements Encryptable, ICureDocument<String?> {
	@override abstract String? id;
	@override abstract int? created;
	@override abstract int? modified;
	@override abstract String? author;
	@override abstract String? responsible;
	@override abstract String? medicalLocationId;
	@override abstract Set<CodeStub> tags;
	@override abstract Set<CodeStub> codes;
	@override abstract int? endOfLife;
	abstract String? descr;
	abstract String? protocol;
	@ActualInt32() abstract int? status;
	abstract String? formId;
	abstract String? planOfActionId;
	abstract String? healthElementId;
	abstract String? classificationId;
	abstract List<ServiceLink> services;
	@override abstract Base64String? encryptedSelf;

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

class EncryptedSubContact implements SubContact {
	@override String? id;
	@override int? created;
	@override int? modified;
	@override String? author;
	@override String? responsible;
	@override String? medicalLocationId;
	@override Set<CodeStub> tags = {};
	@override Set<CodeStub> codes = {};
	@override int? endOfLife;
	@override String? descr;
	@override String? protocol;
	int? _status;
	@ActualInt32() @override int? get status => _status;
	@ActualInt32() @override set status(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('status value cannot exceed 2147483647');
		}
		_status = value;
	}
	@override String? formId;
	@override String? planOfActionId;
	@override String? healthElementId;
	@override String? classificationId;
	@override List<ServiceLink> services = [];
	@override Base64String? encryptedSelf;
	EncryptedSubContact({
			int? status,
			this.id,
			this.created,
			this.modified,
			this.author,
			this.responsible,
			this.medicalLocationId,
			this.endOfLife,
			this.descr,
			this.protocol,
			this.formId,
			this.planOfActionId,
			this.healthElementId,
			this.classificationId,
			this.encryptedSelf,
			Set<CodeStub>? tags,
			Set<CodeStub>? codes,
			List<ServiceLink>? services
		}) : tags = tags ?? {},
		codes = codes ?? {},
		services = services ?? [],
		_status = status;

	factory EncryptedSubContact.fromJSON(Map<String, dynamic> data) {
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
}

class DecryptedSubContact implements SubContact {
	@override String? id;
	@override int? created;
	@override int? modified;
	@override String? author;
	@override String? responsible;
	@override String? medicalLocationId;
	@override Set<CodeStub> tags = {};
	@override Set<CodeStub> codes = {};
	@override int? endOfLife;
	@override String? descr;
	@override String? protocol;
	int? _status;
	@ActualInt32() @override int? get status => _status;
	@ActualInt32() @override set status(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('status value cannot exceed 2147483647');
		}
		_status = value;
	}
	@override String? formId;
	@override String? planOfActionId;
	@override String? healthElementId;
	@override String? classificationId;
	@override List<ServiceLink> services = [];
	@override Base64String? encryptedSelf;
	DecryptedSubContact({
			int? status,
			this.id,
			this.created,
			this.modified,
			this.author,
			this.responsible,
			this.medicalLocationId,
			this.endOfLife,
			this.descr,
			this.protocol,
			this.formId,
			this.planOfActionId,
			this.healthElementId,
			this.classificationId,
			this.encryptedSelf,
			Set<CodeStub>? tags,
			Set<CodeStub>? codes,
			List<ServiceLink>? services
		}) : tags = tags ?? {},
		codes = codes ?? {},
		services = services ?? [],
		_status = status;

	factory DecryptedSubContact.fromJSON(Map<String, dynamic> data) {
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
}