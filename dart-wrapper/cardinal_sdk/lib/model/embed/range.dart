// This file is auto-generated


class Range {
	double? low;
	double? high;
	Range({
			this.low,
			this.high
		});

	factory Range.fromJSON(Map<String, dynamic> data) {
		return Range(
			low: data["low"],
			high: data["high"]
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