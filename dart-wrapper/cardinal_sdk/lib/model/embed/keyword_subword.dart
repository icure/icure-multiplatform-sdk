// auto-generated file
import 'package:cardinal_sdk/model/embed/keyword_subword.dart';


class KeywordSubword {
	String? value;
	List<KeywordSubword>? subWords;
	KeywordSubword({
			this.value,
			this.subWords
		});

	factory KeywordSubword.fromJSON(Map<String, dynamic> data) {
		return KeywordSubword(
			value: data["value"],
			subWords: data["subWords"]?.map((x0) => KeywordSubword.fromJSON(x0) )
		);
	}

	static Map<String, dynamic> encode(KeywordSubword value) {
		Map<String, dynamic> entityAsMap = {
			"value" : value.value,
			"subWords" : value.subWords?.map((x0) => KeywordSubword.encode(x0))
		};
		return entityAsMap;
	}
}