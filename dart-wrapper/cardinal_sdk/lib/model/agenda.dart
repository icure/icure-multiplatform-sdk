// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/embed/right.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/icure_document.dart';


class Agenda implements StoredDocument, ICureDocument<String> {
	@override String id;
	@override String? rev = null;
	@override int? created = null;
	@override int? modified = null;
	@override String? author = null;
	@override String? responsible = null;
	@override String? medicalLocationId = null;
	@override Set<CodeStub> tags = {};
	@override Set<CodeStub> codes = {};
	@override int? endOfLife = null;
	@override int? deletionDate = null;
	String? name = null;
	String? userId = null;
	List<Right> rights = [];
	Agenda(
		this.id,
		{
			String? rev,
			int? created,
			int? modified,
			String? author,
			String? responsible,
			String? medicalLocationId,
			Set<CodeStub>? tags,
			Set<CodeStub>? codes,
			int? endOfLife,
			int? deletionDate,
			String? name,
			String? userId,
			List<Right>? rights
		}) : rev = rev ?? null,
		created = created ?? null,
		modified = modified ?? null,
		author = author ?? null,
		responsible = responsible ?? null,
		medicalLocationId = medicalLocationId ?? null,
		tags = tags ?? {},
		codes = codes ?? {},
		endOfLife = endOfLife ?? null,
		deletionDate = deletionDate ?? null,
		name = name ?? null,
		userId = userId ?? null,
		rights = rights ?? [];

	static Map<String, dynamic> encode(Agenda value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"created" : value.created,
			"modified" : value.modified,
			"author" : value.author,
			"responsible" : value.responsible,
			"medicalLocationId" : value.medicalLocationId,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)).toList(),
			"endOfLife" : value.endOfLife,
			"deletionDate" : value.deletionDate,
			"name" : value.name,
			"userId" : value.userId,
			"rights" : value.rights.map((x0) => Right.encode(x0)).toList()
		};
		return entityAsMap;
	}

	static Agenda fromJSON(Map<String, dynamic> data) {
		return Agenda(
			(data["id"] as String),
			rev: (data["rev"] as String?),
			created: (data["created"] as int?),
			modified: (data["modified"] as int?),
			author: (data["author"] as String?),
			responsible: (data["responsible"] as String?),
			medicalLocationId: (data["medicalLocationId"] as String?),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			endOfLife: (data["endOfLife"] as int?),
			deletionDate: (data["deletionDate"] as int?),
			name: (data["name"] as String?),
			userId: (data["userId"] as String?),
			rights: (data["rights"] as List<dynamic>).map((x0) => Right.fromJSON(x0) ).toList(),
		);
	}
}