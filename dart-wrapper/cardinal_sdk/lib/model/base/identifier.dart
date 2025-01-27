// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';


class Identifier {
	String? id = null;
	String? assigner = null;
	String? start = null;
	String? end = null;
	String? system = null;
	CodeStub? type = null;
	String? use = null;
	String? value = null;
	Identifier({
			String? id,
			String? assigner,
			String? start,
			String? end,
			String? system,
			CodeStub? type,
			String? use,
			String? value
		}) : id = id ?? null,
		assigner = assigner ?? null,
		start = start ?? null,
		end = end ?? null,
		system = system ?? null,
		type = type ?? null,
		use = use ?? null,
		value = value ?? null;

	static Map<String, dynamic> encode(Identifier value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"assigner" : value.assigner,
			"start" : value.start,
			"end" : value.end,
			"system" : value.system,
			"type" : value.type == null ? null : CodeStub.encode(value.type!),
			"use" : value.use,
			"value" : value.value
		};
		return entityAsMap;
	}

	static Identifier fromJSON(Map<String, dynamic> data) {
		return Identifier(
			id: (data["id"] as String?),
			assigner: (data["assigner"] as String?),
			start: (data["start"] as String?),
			end: (data["end"] as String?),
			system: (data["system"] as String?),
			type: data["type"] == null ? null : CodeStub.fromJSON(data["type"]),
			use: (data["use"] as String?),
			value: (data["value"] as String?)
		);
	}
}