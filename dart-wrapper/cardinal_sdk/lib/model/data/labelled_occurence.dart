// auto-generated file


class LabelledOccurence {
	String label;
	int occurence;
	LabelledOccurence(
		this.label,
		this.occurence
		);

	factory LabelledOccurence.fromJSON(Map<String, dynamic> data) {
		return LabelledOccurence(
			(data["label"] as String),
			(data["occurence"] as int)
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