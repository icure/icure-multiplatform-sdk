// auto-generated file


class Range {
	double? low;
	double? high;
	Range({
			this.low,
			this.high
		});

	factory Range.fromJSON(Map<String, dynamic> data) {
		return Range(
			low: (data["low"] as num?)?.toDouble(),
			high: (data["high"] as num?)?.toDouble()
		);
	}

	static Map<String, dynamic> encode(Range value) {
		Map<String, dynamic> entityAsMap = {
			"low" : value.low,
			"high" : value.high
		};
		return entityAsMap;
	}
}