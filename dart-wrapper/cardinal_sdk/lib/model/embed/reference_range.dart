// This file is auto-generated
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