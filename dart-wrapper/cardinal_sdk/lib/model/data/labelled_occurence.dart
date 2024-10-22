// This file is auto-generated


class LabelledOccurence {
	String label;
	int occurence;
	LabelledOccurence(
		this.label,
		this.occurence
		);

	factory LabelledOccurence.fromJSON(Map<String, dynamic> data) {
		return LabelledOccurence(
			data["label"],
			data["occurence"]
		);
	}

	static Map<String, dynamic> encode(LabelledOccurence value) {
		Map<String, dynamic> entityAsMap = {
			"label" : value.label,
			"occurence" : value.occurence
		};
		return entityAsMap;
	}
}