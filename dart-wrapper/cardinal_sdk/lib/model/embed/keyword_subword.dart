// auto-generated file
import 'package:cardinal_sdk/model/embed/keyword_subword.dart';


class KeywordSubword {
	String? value = null;
	List<KeywordSubword>? subWords = null;
	KeywordSubword({
			String? value,
			List<KeywordSubword>? subWords
		}) : value = value ?? null,
		subWords = subWords ?? null;

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