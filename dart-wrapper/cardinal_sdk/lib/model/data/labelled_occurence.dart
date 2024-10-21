// This file is auto-generated


class LabelledOccurence {
	String label;
	int occurence;

	LabelledOccurence({
		required this.label,
		required this.occurence
	});

	static Map<String, dynamic> encode(LabelledOccurence value) {
		Map<String, dynamic> entityAsMap = {
			"label" : value.label,
			"occurence" : value.occurence
		};
		return entityAsMap;
	}
}