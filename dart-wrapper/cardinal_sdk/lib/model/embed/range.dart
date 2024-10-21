// This file is auto-generated


class Range {
	double? low;
	double? high;

	Range({
		this.low,
		this.high
	});

	static Map<String, dynamic> encode(Range value) {
		Map<String, dynamic> entityAsMap = {
			"low" : value.low,
			"high" : value.high
		};
		return entityAsMap;
	}
}