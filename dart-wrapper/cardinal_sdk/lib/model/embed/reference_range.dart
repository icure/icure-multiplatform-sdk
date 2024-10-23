// auto-generated file
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/embed/annotation.dart';
import 'package:cardinal_sdk/model/embed/range.dart';


class ReferenceRange {
	double? low;
	double? high;
	String? stringValue;
	List<CodeStub> tags = [];
	List<CodeStub> codes = [];
	List<Annotation> notes = [];
	Range? age;
	ReferenceRange({
			this.low,
			this.high,
			this.stringValue,
			this.age,
			List<CodeStub>? tags,
			List<CodeStub>? codes,
			List<Annotation>? notes
		}) : tags = tags ?? [],
		codes = codes ?? [],
		notes = notes ?? [];

	factory ReferenceRange.fromJSON(Map<String, dynamic> data) {
		return ReferenceRange(
			low: data["low"],
			high: data["high"],
			stringValue: data["stringValue"],
			tags: data["tags"].map((x0) => CodeStub.fromJSON(x0) ),
			codes: data["codes"].map((x0) => CodeStub.fromJSON(x0) ),
			notes: data["notes"].map((x0) => Annotation.fromJSON(x0) ),
			age: data["age"] == null ? null : Range.fromJSON(data["age"])
		);
	}

	static Map<String, dynamic> encode(ReferenceRange value) {
		Map<String, dynamic> entityAsMap = {
			"low" : value.low,
			"high" : value.high,
			"stringValue" : value.stringValue,
			"tags" : value.tags.map((x0) => CodeStub.encode(x0)),
			"codes" : value.codes.map((x0) => CodeStub.encode(x0)),
			"notes" : value.notes.map((x0) => Annotation.encode(x0)),
			"age" : value.age == null ? null : Range.encode(value.age!)
		};
		return entityAsMap;
	}
}