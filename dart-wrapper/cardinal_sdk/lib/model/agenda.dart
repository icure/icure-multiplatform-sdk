// This file is auto-generated
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/embed/right.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/icure_document.dart';


class Agenda implements StoredDocument, ICureDocument<String> {
	@override String id;
	@override String? rev;
	@override int? created;
	@override int? modified;
	@override String? author;
	@override String? responsible;
	@override String? medicalLocationId;
	@override Set<CodeStub> tags = {};
	@override Set<CodeStub> codes = {};
	@override int? endOfLife;
	@override int? deletionDate;
	String? name;
	String? userId;
	List<Right> rights = [];
	Agenda(
		this.id,
		{
			this.rev,
			this.created,
			this.modified,
			this.author,
			this.responsible,
			this.medicalLocationId,
			this.endOfLife,
			this.deletionDate,
			this.name,
			this.userId,
			Set<CodeStub>? tags,
			Set<CodeStub>? codes,
			List<Right>? rights
		}) : tags = tags ?? {},
		codes = codes ?? {},
		rights = rights ?? [];

	factory Agenda.fromJSON(Map<String, dynamic> data) {
		return Agenda(
			data["id"],
			rev: data["rev"],
			created: data["created"],
			modified: data["modified"],
			author: data["author"],
			responsible: data["responsible"],
			medicalLocationId: data["medicalLocationId"],
			tags: data["tags"].map((x0) => CodeStub.fromJSON(x0) ),
			codes: data["codes"].map((x0) => CodeStub.fromJSON(x0) ),
			endOfLife: data["endOfLife"],
			deletionDate: data["deletionDate"],
			name: data["name"],
			userId: data["userId"],
			rights: data["rights"].map((x0) => Right.fromJSON(x0) ),
		);
	}

	static Map<String, dynamic> encode(Agenda value) {
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
			"name" : value.name,
			"userId" : value.userId,
			"rights" : value.rights.map((x0) => Right.encode(x0))
		};
		return entityAsMap;
	}
}