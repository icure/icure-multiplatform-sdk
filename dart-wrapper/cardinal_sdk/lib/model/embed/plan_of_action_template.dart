// This file is auto-generated
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/annotations/actual_int32.dart';
import 'package:cardinal_sdk/model/embed/form_skeleton.dart';
import 'package:cardinal_sdk/model/base/icure_document.dart';
import 'package:cardinal_sdk/model/base/named.dart';


class PlanOfActionTemplate implements ICureDocument<String>, Named {
	@override  String id;
	@override  int? created;
	@override  int? modified;
	@override  String? author;
	@override  String? responsible;
	@override  String? medicalLocationId;
	@override  Set<CodeStub> tags = {};
	@override  Set<CodeStub> codes = {};
	@override  int? endOfLife;
	@override  String? name;
	String? descr;
	String? note;
	bool relevant = true;
	int _status = 0;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") int get status => _status;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") set status(int value) {
		if (value > 2147483647) {
			throw ArgumentError('status value cannot exceed 2147483647');
		}
		_status = value;
	}
	List<FormSkeleton> forms = [];

	PlanOfActionTemplate({
		required this.id,
		int? status,
		this.created,
		this.modified,
		this.author,
		this.responsible,
		this.medicalLocationId,
		this.endOfLife,
		this.name,
		this.descr,
		this.note,
		Set<CodeStub>? tags,
		Set<CodeStub>? codes,
		bool? relevant,
		List<FormSkeleton>? forms
	}) : tags = tags ?? {},
		codes = codes ?? {},
		relevant = relevant ?? true,
		forms = forms ?? [],
		_status = status ?? 0;

	static Map<String, dynamic> encode(PlanOfActionTemplate value) {
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
			"name" : value.name,
			"descr" : value.descr,
			"note" : value.note,
			"relevant" : value.relevant,
			"status" : value.status,
			"forms" : value.forms.map((x0) => FormSkeleton.encode(x0))
		};
		return entityAsMap;
	}
}