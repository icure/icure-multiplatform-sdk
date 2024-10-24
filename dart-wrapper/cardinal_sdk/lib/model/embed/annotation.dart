// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/base/identifiable.dart';


class Annotation implements Identifiable<String> {
	@override String id;
	String? author;
	int? created;
	int? modified;
	String? text;
	Map<String, String> markdown = {};
	String? location;
	bool? confidential;
	Set<CodeStub> tags = {};
	String? encryptedSelf;
	Annotation(
		this.id,
		{
			this.author,
			this.created,
			this.modified,
			this.text,
			this.location,
			this.confidential,
			this.encryptedSelf,
			Map<String, String>? markdown,
			Set<CodeStub>? tags
		}) : markdown = markdown ?? {},
		tags = tags ?? {};

	factory Annotation.fromJSON(Map<String, dynamic> data) {
		return Annotation(
			(data["id"] as String),
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
}