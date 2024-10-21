// This file is auto-generated


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