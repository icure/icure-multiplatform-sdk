// auto-generated file
import 'package:cardinal_sdk/model/embed/keyword_subword.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "keyword_subword.freezed.dart";


@freezed
abstract class KeywordSubword with _$KeywordSubword {
	const factory KeywordSubword({
		@Default(null) String? value,
		@Default(null) List<KeywordSubword>? subWords,
	}) = _KeywordSubword;


	static Map<String, dynamic> encode(KeywordSubword value) {
		Map<String, dynamic> entityAsMap = {
			"value" : value.value,
			"subWords" : value.subWords?.map((x0) => KeywordSubword.encode(x0)).toList()
		};
		return entityAsMap;
	}

	static KeywordSubword fromJSON(Map<String, dynamic> data) {
		return KeywordSubword(
			value: (data["value"] as String?),
			subWords: (data["subWords"] as List<dynamic>?)?.map((x0) => KeywordSubword.fromJSON(x0) ).toList()
		);
	}
}