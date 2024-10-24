// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/embed/keyword_subword.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/icure_document.dart';


class Keyword implements StoredDocument, ICureDocument<String> {
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
	String? value;
	Set<KeywordSubword> subWords = {};
	String? userId;
	Keyword(
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
			this.value,
			this.userId,
			Set<CodeStub>? tags,
			Set<CodeStub>? codes,
			Set<KeywordSubword>? subWords
		}) : tags = tags ?? {},
		codes = codes ?? {},
		subWords = subWords ?? {};

	factory Keyword.fromJSON(Map<String, dynamic> data) {
		return Keyword(
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
			value: (data["value"] as String?),
			subWords: (data["subWords"] as List<dynamic>).map((x0) => KeywordSubword.fromJSON(x0) ).toSet(),
			userId: (data["userId"] as String?),
		);
	}

	static Map<String, dynamic> encode(Keyword value) {
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
			"value" : value.value,
			"subWords" : value.subWords.map((x0) => KeywordSubword.encode(x0)).toList(),
			"userId" : value.userId
		};
		return entityAsMap;
	}
}