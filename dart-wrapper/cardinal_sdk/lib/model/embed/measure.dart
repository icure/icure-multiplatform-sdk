// auto-generated file
import 'package:cardinal_sdk/annotations/actual_int32.dart';
import 'package:cardinal_sdk/model/base/code_stub.dart';
import 'package:cardinal_sdk/model/embed/reference_range.dart';


class Measure {
	double? value = null;
	double? ref = null;
	int? _severity = null;
	@ActualInt32() int? get severity => _severity;
	@ActualInt32() set severity(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('severity value cannot exceed 2147483647');
		}
		_severity = value;
	}
	String? severityCode = null;
	int? _evolution = null;
	@ActualInt32() int? get evolution => _evolution;
	@ActualInt32() set evolution(int? value) {
		if (value != null && value > 2147483647) {
			throw ArgumentError('evolution value cannot exceed 2147483647');
		}
		_evolution = value;
	}
	String? unit = null;
	Set<CodeStub>? unitCodes = null;
	String? comment = null;
	String? comparator = null;
	String? sign = null;
	List<ReferenceRange> referenceRanges = [];
	Measure({
			int? severity,
			int? evolution,
			double? value,
			double? ref,
			String? severityCode,
			String? unit,
			Set<CodeStub>? unitCodes,
			String? comment,
			String? comparator,
			String? sign,
			List<ReferenceRange>? referenceRanges
		}) : value = value ?? null,
		ref = ref ?? null,
		severityCode = severityCode ?? null,
		unit = unit ?? null,
		unitCodes = unitCodes ?? null,
		comment = comment ?? null,
		comparator = comparator ?? null,
		sign = sign ?? null,
		referenceRanges = referenceRanges ?? [],
		_severity = severity ?? null,
		_evolution = evolution ?? null;

	static Map<String, dynamic> encode(Measure value) {
		Map<String, dynamic> entityAsMap = {
			"value" : value.value,
			"ref" : value.ref,
			"severity" : value.severity,
			"severityCode" : value.severityCode,
			"evolution" : value.evolution,
			"unit" : value.unit,
			"unitCodes" : value.unitCodes?.map((x0) => CodeStub.encode(x0)).toList(),
			"comment" : value.comment,
			"comparator" : value.comparator,
			"sign" : value.sign,
			"referenceRanges" : value.referenceRanges.map((x0) => ReferenceRange.encode(x0)).toList()
		};
		return entityAsMap;
	}

	static Measure fromJSON(Map<String, dynamic> data) {
		return Measure(
			severity: (data["severity"] as int?),
			evolution: (data["evolution"] as int?),
			value: (data["value"] as num?)?.toDouble(),
			ref: (data["ref"] as num?)?.toDouble(),
			severityCode: (data["severityCode"] as String?),
			unit: (data["unit"] as String?),
			unitCodes: (data["unitCodes"] as List<dynamic>?)?.map((x0) => CodeStub.fromJSON(x0) ).toSet(),
			comment: (data["comment"] as String?),
			comparator: (data["comparator"] as String?),
			sign: (data["sign"] as String?),
			referenceRanges: (data["referenceRanges"] as List<dynamic>).map((x0) => ReferenceRange.fromJSON(x0) ).toList()
		);
	}
}