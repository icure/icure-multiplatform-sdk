// auto-generated file


class LetterValue {
	String? letter = null;
	String? index = null;
	double? coefficient = null;
	double? value = null;
	LetterValue({
			String? letter,
			String? index,
			double? coefficient,
			double? value
		}) : letter = letter ?? null,
		index = index ?? null,
		coefficient = coefficient ?? null,
		value = value ?? null;

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