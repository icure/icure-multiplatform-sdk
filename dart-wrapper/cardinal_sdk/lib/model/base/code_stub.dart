// auto-generated file
import 'package:cardinal_sdk/model/base/code_identification.dart';


class CodeStub implements CodeIdentification<String?> {
	@override String? id;
	@override String? context;
	@override String? type;
	@override String? code;
	@override String? version;
	String? contextLabel;
	@override Map<String, String>? label;
	CodeStub({
			this.id,
			this.context,
			this.type,
			this.code,
			this.version,
			this.contextLabel,
			this.label
		});

	factory CodeStub.fromJSON(Map<String, dynamic> data) {
		return CodeStub(
			id: data["id"],
			context: data["context"],
			type: data["type"],
			code: data["code"],
			version: data["version"],
			contextLabel: data["contextLabel"],
			label: data["label"]?.map((k0, v0) => MapEntry(k0, v0))
		);
	}

	static Map<String, dynamic> encode(CodeStub value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"context" : value.context,
			"type" : value.type,
			"code" : value.code,
			"version" : value.version,
			"contextLabel" : value.contextLabel,
			"label" : value.label?.map((k0, v0) => MapEntry(k0, v0))
		};
		return entityAsMap;
	}
}