// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "letter_value.freezed.dart";


@freezed
abstract class LetterValue with _$LetterValue {
	const factory LetterValue({
		@Default(null) String? letter,
		@Default(null) String? index,
		@Default(null) double? coefficient,
		@Default(null) double? value,
	}) = _LetterValue;


	static Map<String, dynamic> encode(LetterValue value) {
		Map<String, dynamic> entityAsMap = {
			"letter" : value.letter,
			"index" : value.index,
			"coefficient" : value.coefficient,
			"value" : value.value
		};
		return entityAsMap;
	}

	static LetterValue fromJSON(Map<String, dynamic> data) {
		return LetterValue(
			letter: (data["letter"] as String?),
			index: (data["index"] as String?),
			coefficient: (data["coefficient"] as num?)?.toDouble(),
			value: (data["value"] as num?)?.toDouble()
		);
	}
}