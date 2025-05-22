// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/embed/keyword_subword.dart';
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:cardinal_sdk/model/base/icure_document.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "keyword.freezed.dart";


@freezed
abstract class Keyword with _$Keyword implements StoredDocument, ICureDocument<String> {
	const factory Keyword({
		required String id,
		@Default(null) String? rev,
		@Default(null) int? created,
		@Default(null) int? modified,
		@Default(null) String? author,
		@Default(null) String? responsible,
		@Default(null) String? medicalLocationId,
		@Default({}) Set<CodeStub> tags,
		@Default({}) Set<CodeStub> codes,
		@Default(null) int? endOfLife,
		@Default(null) int? deletionDate,
		@Default(null) String? value,
		@Default({}) Set<KeywordSubword> subWords,
		@Default(null) String? userId,
	}) = _Keyword;


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

	static Keyword fromJSON(Map<String, dynamic> data) {
		return Keyword(
			id: (data["id"] as String),
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
}