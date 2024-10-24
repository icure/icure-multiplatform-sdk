// auto-generated file
import 'package:cardinal_sdk/model/specializations/hex_string.dart';


class Delegation {
	String? owner;
	String? delegatedTo;
	HexString? key;
	List<String> tags = [];
	Delegation({
			this.owner,
			this.delegatedTo,
			this.key,
			List<String>? tags
		}) : tags = tags ?? [];

	factory Delegation.fromJSON(Map<String, dynamic> data) {
		return Delegation(
			owner: (data["owner"] as String?),
			delegatedTo: (data["delegatedTo"] as String?),
			key: (data["key"] as HexString?),
			tags: (data["tags"] as List<dynamic>).map((x0) => (x0 as String) ).toList()
		);
	}

	static Map<String, dynamic> encode(Delegation value) {
		Map<String, dynamic> entityAsMap = {
			"owner" : value.owner,
			"delegatedTo" : value.delegatedTo,
			"key" : value.key,
			"tags" : value.tags.map((x0) => x0).toList()
		};
		return entityAsMap;
	}
}