// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/annotations/actual_int32.dart';
import 'package:cardinal_sdk/model/embed/care_team_membership.dart';
import 'package:cardinal_sdk/model/specializations/base64string.dart';
import 'package:cardinal_sdk/model/embed/plan_of_action.dart';
import 'package:cardinal_sdk/model/embed/encryptable.dart';
import 'package:cardinal_sdk/model/base/icure_document.dart';
import 'package:cardinal_sdk/model/base/named.dart';


sealed class PlanOfAction implements Encryptable, ICureDocument<String>, Named {
	@override abstract String id;
	@override abstract int? created;
	@override abstract int? modified;
	@override abstract String? author;
	@override abstract String? responsible;
	@override abstract String? medicalLocationId;
	@override abstract Set<CodeStub> tags;
	@override abstract Set<CodeStub> codes;
	@override abstract int? endOfLife;
	abstract String? prescriberId;
	abstract int? valueDate;
	abstract int? openingDate;
	abstract int? closingDate;
	abstract int? deadlineDate;
	@override abstract String? name;
	abstract String? descr;
	abstract String? note;
	abstract String? idOpeningContact;
	abstract String? idClosingContact;
	@ActualInt32() abstract int status;
	abstract Set<String> documentIds;
	@ActualInt32() abstract int? numberOfCares;
	List<CareTeamMembership?> get careTeamMemberships;
	abstract bool relevant;
	@override abstract Base64String? encryptedSelf;

	static Map<String, dynamic> encode(PlanOfAction value) {
		switch (value) {
			case EncryptedPlanOfAction entity:
				Map<String, dynamic> entityJson = EncryptedPlanOfAction.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.EncryptedPlanOfAction";
				return entityJson;
			case DecryptedPlanOfAction entity:
				Map<String, dynamic> entityJson = DecryptedPlanOfAction.encode(entity);
				entityJson["kotlinType"] = "com.icure.cardinal.sdk.model.embed.DecryptedPlanOfAction";
				return entityJson;
		}
	}

	static PlanOfAction fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "com.icure.cardinal.sdk.model.embed.EncryptedPlanOfAction":
				return EncryptedPlanOfAction.fromJSON(data);
			case "com.icure.cardinal.sdk.model.embed.DecryptedPlanOfAction":
				return DecryptedPlanOfAction.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}

class EncryptedPlanOfAction implements PlanOfAction {
	@override String id;
	@override int? created = null;
	@override int? modified = null;
	@override String? author = null;
	@override String? responsible = null;
	@override String? medicalLocationId = null;
	@override Set<CodeStub> tags = {};
	@override Set<CodeStub> codes = {};
	@override int? endOfLife = null;
	@override String? prescriberId = null;
	@override int? valueDate = null;
	@override int? openingDate = null;
	@override int? closingDate = null;
	@override int? deadlineDate = null;
	@override String? name = null;
	@override String? descr = null;
	@override String? note = null;
	@override String? idOpeningContact = null;
	@override String? idClosingContact = null;
	int _status = 0;
	@ActualInt32() @override int get status => _status;
	@ActualInt32() @override set status(int value) {
		if (value > 2147483647) {
			throw ArgumentError('status value cannot exceed 2147483647');
		}
		_status = value;
	}
	@override Set<String> documentIds = {};
	int? _numberOfCares = null;
	@ActualInt32() @override int? get numberOfCares => _numberOfCares;
	@ActualInt32() @override set numberOfCares(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('numberOfCares value cannot exceed 2147483647');
		}
		_numberOfCares = value;
	}
	@override List<EncryptedCareTeamMembership?> careTeamMemberships = [];
	@override bool relevant = true;
	@override Base64String? encryptedSelf = null;
	EncryptedPlanOfAction(
		this.id,
		{
			int? status,
			int? numberOfCares,
			int? created,
			int? modified,
			String? author,
			String? responsible,
			String? medicalLocationId,
			Set<CodeStub>? tags,
			Set<CodeStub>? codes,
			int? endOfLife,
			String? prescriberId,
			int? valueDate,
			int? openingDate,
			int? closingDate,
			int? deadlineDate,
			String? name,
			String? descr,
			String? note,
			String? idOpeningContact,
			String? idClosingContact,
			Set<String>? documentIds,
			List<EncryptedCareTeamMembership?>? careTeamMemberships,
			bool? relevant,
			Base64String? encryptedSelf
		}) : created = created ?? null,
		modified = modified ?? null,
		author = author ?? null,
		responsible = responsible ?? null,
		medicalLocationId = medicalLocationId ?? null,
		tags = tags ?? {},
		codes = codes ?? {},
		endOfLife = endOfLife ?? null,
		prescriberId = prescriberId ?? null,
		valueDate = valueDate ?? null,
		openingDate = openingDate ?? null,
		closingDate = closingDate ?? null,
		deadlineDate = deadlineDate ?? null,
		name = name ?? null,
		descr = descr ?? null,
		note = note ?? null,
		idOpeningContact = idOpeningContact ?? null,
		idClosingContact = idClosingContact ?? null,
		documentIds = documentIds ?? {},
		careTeamMemberships = careTeamMemberships ?? [],
		relevant = relevant ?? true,
		encryptedSelf = encryptedSelf ?? null,
		_status = status ?? 0,
		_numberOfCares = numberOfCares ?? null;

	factory EncryptedPlanOfAction.fromJSON(Map<String, dynamic> data) {
		return EncryptedPlanOfAction(
			(data["id"] as String),
			status: (data["status"] as int),
			numberOfCares: (data["numberOfCares"] as int?),
			created: (data["created"] as int?),
			modified: (data["modified"] as int?),
			author: (data["author"] as String?),
			responsible: (data["responsible"] as String?),
			medicalLocationId: (data["medicalLocationId"] as String?),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			endOfLife: (data["endOfLife"] as int?),
			prescriberId: (data["prescriberId"] as String?),
			valueDate: (data["valueDate"] as int?),
			openingDate: (data["openingDate"] as int?),
			closingDate: (data["closingDate"] as int?),
			deadlineDate: (data["deadlineDate"] as int?),
			name: (data["name"] as String?),
			descr: (data["descr"] as String?),
			note: (data["note"] as String?),
			idOpeningContact: (data["idOpeningContact"] as String?),
			idClosingContact: (data["idClosingContact"] as String?),
			documentIds: (data["documentIds"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			careTeamMemberships: (data["careTeamMemberships"] as List<dynamic>).map((x0) => x0 == null ? null : EncryptedCareTeamMembership.fromJSON(x0) ).toList(),
			relevant: (data["relevant"] as bool),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
		);
	}

	static Map<String, dynamic> encode(EncryptedPlanOfAction value) {
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
			"prescriberId" : value.prescriberId,
			"valueDate" : value.valueDate,
			"openingDate" : value.openingDate,
			"closingDate" : value.closingDate,
			"deadlineDate" : value.deadlineDate,
			"name" : value.name,
			"descr" : value.descr,
			"note" : value.note,
			"idOpeningContact" : value.idOpeningContact,
			"idClosingContact" : value.idClosingContact,
			"status" : value.status,
			"documentIds" : value.documentIds.map((x0) => x0).toList(),
			"numberOfCares" : value.numberOfCares,
			"careTeamMemberships" : value.careTeamMemberships.map((x0) => x0 == null ? null : EncryptedCareTeamMembership.encode(x0!)).toList(),
			"relevant" : value.relevant,
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}
}

class DecryptedPlanOfAction implements PlanOfAction {
	@override String id;
	@override int? created = null;
	@override int? modified = null;
	@override String? author = null;
	@override String? responsible = null;
	@override String? medicalLocationId = null;
	@override Set<CodeStub> tags = {};
	@override Set<CodeStub> codes = {};
	@override int? endOfLife = null;
	@override String? prescriberId = null;
	@override int? valueDate = null;
	@override int? openingDate = null;
	@override int? closingDate = null;
	@override int? deadlineDate = null;
	@override String? name = null;
	@override String? descr = null;
	@override String? note = null;
	@override String? idOpeningContact = null;
	@override String? idClosingContact = null;
	int _status = 0;
	@ActualInt32() @override int get status => _status;
	@ActualInt32() @override set status(int value) {
		if (value > 2147483647) {
			throw ArgumentError('status value cannot exceed 2147483647');
		}
		_status = value;
	}
	@override Set<String> documentIds = {};
	int? _numberOfCares = null;
	@ActualInt32() @override int? get numberOfCares => _numberOfCares;
	@ActualInt32() @override set numberOfCares(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('numberOfCares value cannot exceed 2147483647');
		}
		_numberOfCares = value;
	}
	@override List<DecryptedCareTeamMembership?> careTeamMemberships = [];
	@override bool relevant = true;
	@override Base64String? encryptedSelf = null;
	DecryptedPlanOfAction(
		this.id,
		{
			int? status,
			int? numberOfCares,
			int? created,
			int? modified,
			String? author,
			String? responsible,
			String? medicalLocationId,
			Set<CodeStub>? tags,
			Set<CodeStub>? codes,
			int? endOfLife,
			String? prescriberId,
			int? valueDate,
			int? openingDate,
			int? closingDate,
			int? deadlineDate,
			String? name,
			String? descr,
			String? note,
			String? idOpeningContact,
			String? idClosingContact,
			Set<String>? documentIds,
			List<DecryptedCareTeamMembership?>? careTeamMemberships,
			bool? relevant,
			Base64String? encryptedSelf
		}) : created = created ?? null,
		modified = modified ?? null,
		author = author ?? null,
		responsible = responsible ?? null,
		medicalLocationId = medicalLocationId ?? null,
		tags = tags ?? {},
		codes = codes ?? {},
		endOfLife = endOfLife ?? null,
		prescriberId = prescriberId ?? null,
		valueDate = valueDate ?? null,
		openingDate = openingDate ?? null,
		closingDate = closingDate ?? null,
		deadlineDate = deadlineDate ?? null,
		name = name ?? null,
		descr = descr ?? null,
		note = note ?? null,
		idOpeningContact = idOpeningContact ?? null,
		idClosingContact = idClosingContact ?? null,
		documentIds = documentIds ?? {},
		careTeamMemberships = careTeamMemberships ?? [],
		relevant = relevant ?? true,
		encryptedSelf = encryptedSelf ?? null,
		_status = status ?? 0,
		_numberOfCares = numberOfCares ?? null;

	factory DecryptedPlanOfAction.fromJSON(Map<String, dynamic> data) {
		return DecryptedPlanOfAction(
			(data["id"] as String),
			status: (data["status"] as int),
			numberOfCares: (data["numberOfCares"] as int?),
			created: (data["created"] as int?),
			modified: (data["modified"] as int?),
			author: (data["author"] as String?),
			responsible: (data["responsible"] as String?),
			medicalLocationId: (data["medicalLocationId"] as String?),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			endOfLife: (data["endOfLife"] as int?),
			prescriberId: (data["prescriberId"] as String?),
			valueDate: (data["valueDate"] as int?),
			openingDate: (data["openingDate"] as int?),
			closingDate: (data["closingDate"] as int?),
			deadlineDate: (data["deadlineDate"] as int?),
			name: (data["name"] as String?),
			descr: (data["descr"] as String?),
			note: (data["note"] as String?),
			idOpeningContact: (data["idOpeningContact"] as String?),
			idClosingContact: (data["idClosingContact"] as String?),
			documentIds: (data["documentIds"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			careTeamMemberships: (data["careTeamMemberships"] as List<dynamic>).map((x0) => x0 == null ? null : DecryptedCareTeamMembership.fromJSON(x0) ).toList(),
			relevant: (data["relevant"] as bool),
			encryptedSelf: (data["encryptedSelf"] as Base64String?),
		);
	}

	static Map<String, dynamic> encode(DecryptedPlanOfAction value) {
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
			"prescriberId" : value.prescriberId,
			"valueDate" : value.valueDate,
			"openingDate" : value.openingDate,
			"closingDate" : value.closingDate,
			"deadlineDate" : value.deadlineDate,
			"name" : value.name,
			"descr" : value.descr,
			"note" : value.note,
			"idOpeningContact" : value.idOpeningContact,
			"idClosingContact" : value.idClosingContact,
			"status" : value.status,
			"documentIds" : value.documentIds.map((x0) => x0).toList(),
			"numberOfCares" : value.numberOfCares,
			"careTeamMemberships" : value.careTeamMemberships.map((x0) => x0 == null ? null : DecryptedCareTeamMembership.encode(x0!)).toList(),
			"relevant" : value.relevant,
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}
}