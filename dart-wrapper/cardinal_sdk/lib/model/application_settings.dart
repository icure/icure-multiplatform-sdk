// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/icure_document.dart';


class ApplicationSettings implements StoredDocument, ICureDocument<String> {
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
	Map<String, String> settings = {};
	ApplicationSettings(
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
			Set<CodeStub>? tags,
			Set<CodeStub>? codes,
			Map<String, String>? settings
		}) : tags = tags ?? {},
		codes = codes ?? {},
		settings = settings ?? {};

	factory ApplicationSettings.fromJSON(Map<String, dynamic> data) {
		return ApplicationSettings(
			data["id"],
			rev: data["rev"],
			created: data["created"],
			modified: data["modified"],
			author: data["author"],
			responsible: data["responsible"],
			medicalLocationId: data["medicalLocationId"],
			tags: data["tags"].map((x0) => CodeStub.fromJSON(x0) ).toList(),
			codes: data["codes"].map((x0) => CodeStub.fromJSON(x0) ).toList(),
			endOfLife: data["endOfLife"],
			deletionDate: data["deletionDate"],
			settings: data["settings"].map((k0, v0) => MapEntry(k0, v0)),
		);
	}

	static Map<String, dynamic> encode(ApplicationSettings value) {
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
			"settings" : value.settings.map((k0, v0) => MapEntry(k0, v0))
		};
		return entityAsMap;
	}
}