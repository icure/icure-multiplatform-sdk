// auto-generated file


class LetterValue {
	String? letter;
	String? index;
	double? coefficient;
	double? value;
	LetterValue({
			this.letter,
			this.index,
			this.coefficient,
			this.value
		});

	factory LetterValue.fromJSON(Map<String, dynamic> data) {
		return LetterValue(
			letter: (data["letter"] as String?),
			index: (data["index"] as String?),
			coefficient: (data["coefficient"] as num?)?.toDouble(),
			value: (data["value"] as num?)?.toDouble()
		);
	}

	static Map<String, dynamic> encode(LetterValue value) {
		Map<String, dynamic> entityAsMap = {
			"letter" : value.letter,
			"index" : value.index,
			"coefficient" : value.coefficient,
			"value" : value.value
		};
		return entityAsMap;
	}
}