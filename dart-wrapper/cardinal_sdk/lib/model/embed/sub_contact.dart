// This file is auto-generated
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
	@ActualInt32("This property cannot contain a value exceeding 2147483647") abstract int? status;
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
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get status => _status;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set status(int? value) {
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
			status: data["status"],
			id: data["id"],
			created: data["created"],
			modified: data["modified"],
			author: data["author"],
			responsible: data["responsible"],
			medicalLocationId: data["medicalLocationId"],
			tags: data["tags"].map((x0) => CodeStub.fromJSON(x0) ),
			codes: data["codes"].map((x0) => CodeStub.fromJSON(x0) ),
			endOfLife: data["endOfLife"],
			descr: data["descr"],
			protocol: data["protocol"],
			formId: data["formId"],
			planOfActionId: data["planOfActionId"],
			healthElementId: data["healthElementId"],
			classificationId: data["classificationId"],
			services: data["services"].map((x0) => ServiceLink.fromJSON(x0) ),
			encryptedSelf: data["encryptedSelf"]
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
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)),
			"endOfLife" : value.endOfLife,
			"descr" : value.descr,
			"protocol" : value.protocol,
			"status" : value.status,
			"formId" : value.formId,
			"planOfActionId" : value.planOfActionId,
			"healthElementId" : value.healthElementId,
			"classificationId" : value.classificationId,
			"services" : value.services.map((x0) => ServiceLink.encode(x0)),
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
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get status => _status;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set status(int? value) {
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
			status: data["status"],
			id: data["id"],
			created: data["created"],
			modified: data["modified"],
			author: data["author"],
			responsible: data["responsible"],
			medicalLocationId: data["medicalLocationId"],
			tags: data["tags"].map((x0) => CodeStub.fromJSON(x0) ),
			codes: data["codes"].map((x0) => CodeStub.fromJSON(x0) ),
			endOfLife: data["endOfLife"],
			descr: data["descr"],
			protocol: data["protocol"],
			formId: data["formId"],
			planOfActionId: data["planOfActionId"],
			healthElementId: data["healthElementId"],
			classificationId: data["classificationId"],
			services: data["services"].map((x0) => ServiceLink.fromJSON(x0) ),
			encryptedSelf: data["encryptedSelf"]
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
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)),
			"endOfLife" : value.endOfLife,
			"descr" : value.descr,
			"protocol" : value.protocol,
			"status" : value.status,
			"formId" : value.formId,
			"planOfActionId" : value.planOfActionId,
			"healthElementId" : value.healthElementId,
			"classificationId" : value.classificationId,
			"services" : value.services.map((x0) => ServiceLink.encode(x0)),
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}
}