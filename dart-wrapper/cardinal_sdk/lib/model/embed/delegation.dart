// auto-generated file
import 'package:cardinal_sdk/model/specializations/hex_string.dart';


class Delegation {
	String? owner = null;
	String? delegatedTo = null;
	HexString? key = null;
	List<String> tags = [];
	Delegation({
			String? owner,
			String? delegatedTo,
			HexString? key,
			List<String>? tags
		}) : owner = owner ?? null,
		delegatedTo = delegatedTo ?? null,
		key = key ?? null,
		tags = tags ?? [];

	static Map<String, dynamic> encode(Delegation value) {
		Map<String, dynamic> entityAsMap = {
			"owner" : value.owner,
			"delegatedTo" : value.delegatedTo,
			"key" : value.key,
			"tags" : value.tags.map((x0) => x0).toList()
		};
		return entityAsMap;
	}

	static Delegation fromJSON(Map<String, dynamic> data) {
		return Delegation(
			owner: (data["owner"] as String?),
			delegatedTo: (data["delegatedTo"] as String?),
			key: (data["key"] as HexString?),
			tags: (data["tags"] as List<dynamic>).map((x0) => (x0 as String) ).toList()
		);
	}
}