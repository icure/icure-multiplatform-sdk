// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/base/identifiable.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "annotation.freezed.dart";


@freezed
abstract class Annotation with _$Annotation implements Identifiable<String> {
	const factory Annotation({
		required String id,
		@Default(null) String? author,
		@Default(null) int? created,
		@Default(null) int? modified,
		@Default(null) String? text,
		@Default({}) Map<String, String> markdown,
		@Default(null) String? location,
		@Default(null) bool? confidential,
		@Default({}) Set<CodeStub> tags,
		@Default(null) String? encryptedSelf,
	}) = _Annotation;


	static Map<String, dynamic> encode(Annotation value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"author" : value.author,
			"created" : value.created,
			"modified" : value.modified,
			"text" : value.text,
			"markdown" : value.markdown.map((k0, v0) => MapEntry(k0, v0)),
			"location" : value.location,
			"confidential" : value.confidential,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}

	static Annotation fromJSON(Map<String, dynamic> data) {
		return Annotation(
			id: (data["id"] as String),
			author: (data["author"] as String?),
			created: (data["created"] as int?),
			modified: (data["modified"] as int?),
			text: (data["text"] as String?),
			markdown: (data["markdown"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), (v0 as String))),
			location: (data["location"] as String?),
			confidential: (data["confidential"] as bool?),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			encryptedSelf: (data["encryptedSelf"] as String?),
		);
	}
}