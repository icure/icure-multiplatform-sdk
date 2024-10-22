// This file is auto-generated


class TimeSeries {
	List<String> fields = [];
	List<List<double>> samples = [];
	List<double> min = [];
	List<double> max = [];
	List<double> mean = [];
	List<double> median = [];
	List<double> variance = [];
	TimeSeries({
			List<String>? fields,
			List<List<double>>? samples,
			List<double>? min,
			List<double>? max,
			List<double>? mean,
			List<double>? median,
			List<double>? variance
		}) : fields = fields ?? [],
		samples = samples ?? [],
		min = min ?? [],
		max = max ?? [],
		mean = mean ?? [],
		median = median ?? [],
		variance = variance ?? [];

	factory TimeSeries.fromJSON(Map<String, dynamic> data) {
		return TimeSeries(
			fields: data["fields"].map((x0) => x0 ),
			samples: data["samples"].map((x0) => x0.map((x1) => x1 ) ),
			min: data["min"].map((x0) => x0 ),
			max: data["max"].map((x0) => x0 ),
			mean: data["mean"].map((x0) => x0 ),
			median: data["median"].map((x0) => x0 ),
			variance: data["variance"].map((x0) => x0 )
		);
	}

	static Map<String, dynamic> encode(TimeSeries value) {
		Map<String, dynamic> entityAsMap = {
			"fields" : value.fields.map((x0) => x0),
			"samples" : value.samples.map((x0) => x0.map((x1) => x1)),
			"min" : value.min.map((x0) => x0),
			"max" : value.max.map((x0) => x0),
			"mean" : value.mean.map((x0) => x0),
			"median" : value.median.map((x0) => x0),
			"variance" : value.variance.map((x0) => x0)
		};
		return entityAsMap;
	}
}