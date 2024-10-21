// This file is auto-generated
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
	@ActualInt32("This property cannot contain a value exceeding 2147483647") abstract int status;
	abstract Set<String> documentIds;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") abstract int? numberOfCares;
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
}

class EncryptedPlanOfAction implements PlanOfAction {
	@override  String id;
	@override  int? created;
	@override  int? modified;
	@override  String? author;
	@override  String? responsible;
	@override  String? medicalLocationId;
	@override  Set<CodeStub> tags = {};
	@override  Set<CodeStub> codes = {};
	@override  int? endOfLife;
	@override  String? prescriberId;
	@override  int? valueDate;
	@override  int? openingDate;
	@override  int? closingDate;
	@override  int? deadlineDate;
	@override  String? name;
	@override  String? descr;
	@override  String? note;
	@override  String? idOpeningContact;
	@override  String? idClosingContact;
	int _status = 0;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int get status => _status;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set status(int value) {
		if (value > 2147483647) {
			throw ArgumentError('status value cannot exceed 2147483647');
		}
		_status = value;
	}
	@override  Set<String> documentIds = {};
	int? _numberOfCares;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get numberOfCares => _numberOfCares;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set numberOfCares(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('numberOfCares value cannot exceed 2147483647');
		}
		_numberOfCares = value;
	}
	@override  List<EncryptedCareTeamMembership?> careTeamMemberships = [];
	@override  bool relevant = true;
	@override  Base64String? encryptedSelf;

	EncryptedPlanOfAction({
		required this.id,
		int? status,
		int? numberOfCares,
		this.created,
		this.modified,
		this.author,
		this.responsible,
		this.medicalLocationId,
		this.endOfLife,
		this.prescriberId,
		this.valueDate,
		this.openingDate,
		this.closingDate,
		this.deadlineDate,
		this.name,
		this.descr,
		this.note,
		this.idOpeningContact,
		this.idClosingContact,
		this.encryptedSelf,
		Set<CodeStub>? tags,
		Set<CodeStub>? codes,
		Set<String>? documentIds,
		List<EncryptedCareTeamMembership?>? careTeamMemberships,
		bool? relevant
	}) : tags = tags ?? {},
		codes = codes ?? {},
		documentIds = documentIds ?? {},
		careTeamMemberships = careTeamMemberships ?? [],
		relevant = relevant ?? true,
		_status = status ?? 0,
		_numberOfCares = numberOfCares;

	static Map<String, dynamic> encode(EncryptedPlanOfAction value) {
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
			"documentIds" : value.documentIds.map((x0) => x0),
			"numberOfCares" : value.numberOfCares,
			"careTeamMemberships" : value.careTeamMemberships.map((x0) => x0 == null ? null : EncryptedCareTeamMembership.encode(x0!)),
			"relevant" : value.relevant,
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}
}

class DecryptedPlanOfAction implements PlanOfAction {
	@override  String id;
	@override  int? created;
	@override  int? modified;
	@override  String? author;
	@override  String? responsible;
	@override  String? medicalLocationId;
	@override  Set<CodeStub> tags = {};
	@override  Set<CodeStub> codes = {};
	@override  int? endOfLife;
	@override  String? prescriberId;
	@override  int? valueDate;
	@override  int? openingDate;
	@override  int? closingDate;
	@override  int? deadlineDate;
	@override  String? name;
	@override  String? descr;
	@override  String? note;
	@override  String? idOpeningContact;
	@override  String? idClosingContact;
	int _status = 0;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int get status => _status;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set status(int value) {
		if (value > 2147483647) {
			throw ArgumentError('status value cannot exceed 2147483647');
		}
		_status = value;
	}
	@override  Set<String> documentIds = {};
	int? _numberOfCares;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override int? get numberOfCares => _numberOfCares;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") @override set numberOfCares(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('numberOfCares value cannot exceed 2147483647');
		}
		_numberOfCares = value;
	}
	@override  List<DecryptedCareTeamMembership?> careTeamMemberships = [];
	@override  bool relevant = true;
	@override  Base64String? encryptedSelf;

	DecryptedPlanOfAction({
		required this.id,
		int? status,
		int? numberOfCares,
		this.created,
		this.modified,
		this.author,
		this.responsible,
		this.medicalLocationId,
		this.endOfLife,
		this.prescriberId,
		this.valueDate,
		this.openingDate,
		this.closingDate,
		this.deadlineDate,
		this.name,
		this.descr,
		this.note,
		this.idOpeningContact,
		this.idClosingContact,
		this.encryptedSelf,
		Set<CodeStub>? tags,
		Set<CodeStub>? codes,
		Set<String>? documentIds,
		List<DecryptedCareTeamMembership?>? careTeamMemberships,
		bool? relevant
	}) : tags = tags ?? {},
		codes = codes ?? {},
		documentIds = documentIds ?? {},
		careTeamMemberships = careTeamMemberships ?? [],
		relevant = relevant ?? true,
		_status = status ?? 0,
		_numberOfCares = numberOfCares;

	static Map<String, dynamic> encode(DecryptedPlanOfAction value) {
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
			"documentIds" : value.documentIds.map((x0) => x0),
			"numberOfCares" : value.numberOfCares,
			"careTeamMemberships" : value.careTeamMemberships.map((x0) => x0 == null ? null : DecryptedCareTeamMembership.encode(x0!)),
			"relevant" : value.relevant,
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}
}