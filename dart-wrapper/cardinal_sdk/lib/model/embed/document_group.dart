// auto-generated file


class DocumentGroup {
	String? guid;
	String? name;
	DocumentGroup({
			this.guid,
			this.name
		});

	factory DocumentGroup.fromJSON(Map<String, dynamic> data) {
		return DocumentGroup(
			guid: data["guid"],
			name: data["name"]
		);
	}

	static Map<String, dynamic> encode(DocumentGroup value) {
		Map<String, dynamic> entityAsMap = {
			"guid" : value.guid,
			"name" : value.name
		};
		return entityAsMap;
	}
}