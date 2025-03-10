// auto-generated file


class DocumentGroup {
	String? guid = null;
	String? name = null;
	DocumentGroup({
			String? guid,
			String? name
		}) : guid = guid ?? null,
		name = name ?? null;

	static Map<String, dynamic> encode(DocumentGroup value) {
		Map<String, dynamic> entityAsMap = {
			"guid" : value.guid,
			"name" : value.name
		};
		return entityAsMap;
	}

	static DocumentGroup fromJSON(Map<String, dynamic> data) {
		return DocumentGroup(
			guid: (data["guid"] as String?),
			name: (data["name"] as String?)
		);
	}
}