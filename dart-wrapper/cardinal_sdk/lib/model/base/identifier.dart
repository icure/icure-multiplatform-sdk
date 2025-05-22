// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "identifier.freezed.dart";


@freezed
abstract class Identifier with _$Identifier {
	const factory Identifier({
		@Default(null) String? id,
		@Default(null) String? assigner,
		@Default(null) String? start,
		@Default(null) String? end,
		@Default(null) String? system,
		@Default(null) CodeStub? type,
		@Default(null) String? use,
		@Default(null) String? value,
	}) = _Identifier;


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