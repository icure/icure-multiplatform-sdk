// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "range.freezed.dart";


@freezed
abstract class Range with _$Range {
	const factory Range({
		@Default(null) double? low,
		@Default(null) double? high,
	}) = _Range;


	static Map<String, dynamic> encode(Range value) {
		Map<String, dynamic> entityAsMap = {
			"low" : value.low,
			"high" : value.high
		};
		return entityAsMap;
	}

	static Range fromJSON(Map<String, dynamic> data) {
		return Range(
			low: (data["low"] as num?)?.toDouble(),
			high: (data["high"] as num?)?.toDouble()
		);
	}
}