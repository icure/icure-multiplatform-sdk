// auto-generated file
import 'package:cardinal_sdk/annotations/actual_int32.dart';
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/embed/reference_range.dart';


class Measure {
	double? value;
	double? ref;
	int? _severity;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") int? get severity => _severity;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") set severity(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('severity value cannot exceed 2147483647');
		}
		_severity = value;
	}
	String? severityCode;
	int? _evolution;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") int? get evolution => _evolution;
	@ActualInt32("This property cannot contain a value exceeding 2147483647") set evolution(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('evolution value cannot exceed 2147483647');
		}
		_evolution = value;
	}
	String? unit;
	Set<CodeStub>? unitCodes;
	String? comment;
	String? comparator;
	String? sign;
	List<ReferenceRange> referenceRanges = [];
	Measure({
			int? severity,
			int? evolution,
			this.value,
			this.ref,
			this.severityCode,
			this.unit,
			this.unitCodes,
			this.comment,
			this.comparator,
			this.sign,
			List<ReferenceRange>? referenceRanges
		}) : referenceRanges = referenceRanges ?? [],
		_severity = severity,
		_evolution = evolution;

	factory Measure.fromJSON(Map<String, dynamic> data) {
		return Measure(
			severity: data["severity"],
			evolution: data["evolution"],
			value: data["value"],
			ref: data["ref"],
			severityCode: data["severityCode"],
			unit: data["unit"],
			unitCodes: data["unitCodes"]?.map((x0) => CodeStub.fromJSON(x0) ),
			comment: data["comment"],
			comparator: data["comparator"],
			sign: data["sign"],
			referenceRanges: data["referenceRanges"].map((x0) => ReferenceRange.fromJSON(x0) )
		);
	}

	static Map<String, dynamic> encode(Measure value) {
		Map<String, dynamic> entityAsMap = {
			"value" : value.value,
			"ref" : value.ref,
			"severity" : value.severity,
			"severityCode" : value.severityCode,
			"evolution" : value.evolution,
			"unit" : value.unit,
			"unitCodes" : value.unitCodes?.map((x0) => CodeStub.encode(x0)),
			"comment" : value.comment,
			"comparator" : value.comparator,
			"sign" : value.sign,
			"referenceRanges" : value.referenceRanges.map((x0) => ReferenceRange.encode(x0))
		};
		return entityAsMap;
	}
}