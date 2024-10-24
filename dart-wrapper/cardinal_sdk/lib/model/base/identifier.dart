// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';


class Identifier {
	String? id;
	String? assigner;
	String? start;
	String? end;
	String? system;
	CodeStub? type;
	String? use;
	String? value;
	Identifier({
			this.id,
			this.assigner,
			this.start,
			this.end,
			this.system,
			this.type,
			this.use,
			this.value
		});

	factory Identifier.fromJSON(Map<String, dynamic> data) {
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
}