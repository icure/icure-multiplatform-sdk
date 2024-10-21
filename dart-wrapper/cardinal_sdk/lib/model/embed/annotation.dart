// This file is auto-generated
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/base/identifiable.dart';


class Annotation implements Identifiable<String> {
	@override  String id;
	String? author;
	int? created;
	int? modified;
	String? text;
	Map<String, String> markdown = {};
	String? location;
	bool? confidential;
	Set<CodeStub> tags = {};
	String? encryptedSelf;

	Annotation({
		required this.id,
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
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)),
			"encryptedSelf" : value.encryptedSelf
		};
		return entityAsMap;
	}
}