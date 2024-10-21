// This file is auto-generated
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/icure_document.dart';


class ClassificationTemplate implements StoredDocument, ICureDocument<String> {
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
	String? parentId;
	String label;

	ClassificationTemplate({
		required this.id,
		required this.label,
		this.rev,
		this.created,
		this.modified,
		this.author,
		this.responsible,
		this.medicalLocationId,
		this.endOfLife,
		this.deletionDate,
		this.parentId,
		Set<CodeStub>? tags,
		Set<CodeStub>? codes
	}) : tags = tags ?? {},
		codes = codes ?? {};

	static Map<String, dynamic> encode(ClassificationTemplate value) {
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
			"parentId" : value.parentId,
			"label" : value.label
		};
		return entityAsMap;
	}
}