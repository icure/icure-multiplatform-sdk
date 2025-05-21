// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/embed/annotation.dart';
import 'package:cardinal_sdk/model/embed/range.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "reference_range.freezed.dart";


@freezed
abstract class ReferenceRange with _$ReferenceRange {
	const factory ReferenceRange({
		@Default(null) double? low,
		@Default(null) double? high,
		@Default(null) String? stringValue,
		@Default([]) List<CodeStub> tags,
		@Default([]) List<CodeStub> codes,
		@Default([]) List<Annotation> notes,
		@Default(null) Range? age,
	}) = _ReferenceRange;


	static Map<String, dynamic> encode(ReferenceRange value) {
		Map<String, dynamic> entityAsMap = {
			"low" : value.low,
			"high" : value.high,
			"stringValue" : value.stringValue,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)).toList(),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)).toList(),
			"notes" : value.notes.map((x0) => Annotation.encode(x0)).toList(),
			"age" : value.age == null ? null : Range.encode(value.age!)
		};
		return entityAsMap;
	}

	static ReferenceRange fromJSON(Map<String, dynamic> data) {
		return ReferenceRange(
			low: (data["low"] as num?)?.toDouble(),
			high: (data["high"] as num?)?.toDouble(),
			stringValue: (data["stringValue"] as String?),
			tags: (data["tags"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toList(),
			codes: (data["codes"] as List<dynamic>).map((x0) => CodeStub.fromJSON(x0) ).toList(),
			notes: (data["notes"] as List<dynamic>).map((x0) => Annotation.fromJSON(x0) ).toList(),
			age: data["age"] == null ? null : Range.fromJSON(data["age"])
		);
	}
}