// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "time_series.freezed.dart";


@freezed
abstract class TimeSeries with _$TimeSeries {
	const factory TimeSeries({
		@Default([]) List<String> fields,
		@Default([]) List<List<double>> samples,
		@Default([]) List<double> min,
		@Default([]) List<double> max,
		@Default([]) List<double> mean,
		@Default([]) List<double> median,
		@Default([]) List<double> variance,
	}) = _TimeSeries;


	static Map<String, dynamic> encode(TimeSeries value) {
		Map<String, dynamic> entityAsMap = {
			"fields" : value.fields.map((x0) => x0).toList(),
			"samples" : value.samples.map((x0) => x0.map((x1) => x1).toList()).toList(),
			"min" : value.min.map((x0) => x0).toList(),
			"max" : value.max.map((x0) => x0).toList(),
			"mean" : value.mean.map((x0) => x0).toList(),
			"median" : value.median.map((x0) => x0).toList(),
			"variance" : value.variance.map((x0) => x0).toList()
		};
		return entityAsMap;
	}

	static TimeSeries fromJSON(Map<String, dynamic> data) {
		return TimeSeries(
			fields: (data["fields"] as List<dynamic>).map((x0) => (x0 as String) ).toList(),
			samples: (data["samples"] as List<dynamic>).map((x0) => (x0 as List<dynamic>).map((x1) => (x1 as num).toDouble() ).toList() ).toList(),
			min: (data["min"] as List<dynamic>).map((x0) => (x0 as num).toDouble() ).toList(),
			max: (data["max"] as List<dynamic>).map((x0) => (x0 as num).toDouble() ).toList(),
			mean: (data["mean"] as List<dynamic>).map((x0) => (x0 as num).toDouble() ).toList(),
			median: (data["median"] as List<dynamic>).map((x0) => (x0 as num).toDouble() ).toList(),
			variance: (data["variance"] as List<dynamic>).map((x0) => (x0 as num).toDouble() ).toList()
		);
	}
}