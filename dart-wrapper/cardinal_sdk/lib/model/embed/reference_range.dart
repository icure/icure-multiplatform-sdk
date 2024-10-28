// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/embed/annotation.dart';
import 'package:cardinal_sdk/model/embed/range.dart';


class ReferenceRange {
	double? low = null;
	double? high = null;
	String? stringValue = null;
	List<CodeStub> tags = [];
	List<CodeStub> codes = [];
	List<Annotation> notes = [];
	Range? age = null;
	ReferenceRange({
			double? low,
			double? high,
			String? stringValue,
			List<CodeStub>? tags,
			List<CodeStub>? codes,
			List<Annotation>? notes,
			Range? age
		}) : low = low ?? null,
		high = high ?? null,
		stringValue = stringValue ?? null,
		tags = tags ?? [],
		codes = codes ?? [],
		notes = notes ?? [],
		age = age ?? null;

	factory ReferenceRange.fromJSON(Map<String, dynamic> data) {
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
}