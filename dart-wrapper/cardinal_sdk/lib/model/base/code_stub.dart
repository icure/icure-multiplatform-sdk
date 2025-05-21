// auto-generated file
import 'package:cardinal_sdk/model/base/code_identification.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "code_stub.freezed.dart";


@freezed
abstract class CodeStub with _$CodeStub implements CodeIdentification<String?> {
	const factory CodeStub({
		@Default(null) String? id,
		@Default(null) String? context,
		@Default(null) String? type,
		@Default(null) String? code,
		@Default(null) String? version,
		@Default(null) String? contextLabel,
		@Default(null) Map<String, String>? label,
	}) = _CodeStub;


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

	static CodeStub fromJSON(Map<String, dynamic> data) {
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
}