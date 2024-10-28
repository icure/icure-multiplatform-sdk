// auto-generated file
import 'package:cardinal_sdk/model/base/code_identification.dart';


class CodeStub implements CodeIdentification<String?> {
	@override String? id = null;
	@override String? context = null;
	@override String? type = null;
	@override String? code = null;
	@override String? version = null;
	String? contextLabel = null;
	@override Map<String, String>? label = null;
	CodeStub({
			String? id,
			String? context,
			String? type,
			String? code,
			String? version,
			String? contextLabel,
			Map<String, String>? label
		}) : id = id ?? null,
		context = context ?? null,
		type = type ?? null,
		code = code ?? null,
		version = version ?? null,
		contextLabel = contextLabel ?? null,
		label = label ?? null;

	factory CodeStub.fromJSON(Map<String, dynamic> data) {
		return CodeStub(
			id: (data["id"] as String?),
			context: (data["context"] as String?),
			type: (data["type"] as String?),
			code: (data["code"] as String?),
			version: (data["version"] as String?),
			contextLabel: (data["contextLabel"] as String?),
			label: (data["label"] as Map<String, dynamic>?)?.map((k0, v0) => MapEntry((k0 as String), (v0 as String)))
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