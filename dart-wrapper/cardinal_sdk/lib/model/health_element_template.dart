// This file is auto-generated
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/annotations/actual_int32.dart';
import 'package:cardinal_sdk/model/embed/plan_of_action_template.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/icure_document.dart';


class HealthElementTemplate implements StoredDocument, ICureDocument<String> {
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
	String? descr;
	String? note;
	int _status = 0;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") int get status => _status;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") set status(int value) {
		if (value > 2147483647) {
			throw ArgumentError('status value cannot exceed 2147483647');
		}
		_status = value;
	}
	bool relevant = true;
	List<PlanOfActionTemplate> plansOfAction = [];

	HealthElementTemplate({
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
		this.descr,
		this.note,
		Set<CodeStub>? tags,
		Set<CodeStub>? codes,
		bool? relevant,
		List<PlanOfActionTemplate>? plansOfAction
	}) : tags = tags ?? {},
		codes = codes ?? {},
		relevant = relevant ?? true,
		plansOfAction = plansOfAction ?? [],
		_status = status ?? 0;

	static Map<String, dynamic> encode(HealthElementTemplate value) {
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
			"descr" : value.descr,
			"note" : value.note,
			"status" : value.status,
			"relevant" : value.relevant,
			"plansOfAction" : value.plansOfAction.map((x0) => PlanOfActionTemplate.encode(x0))
		};
		return entityAsMap;
	}
}