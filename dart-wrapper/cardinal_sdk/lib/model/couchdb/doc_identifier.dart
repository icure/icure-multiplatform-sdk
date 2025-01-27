// auto-generated file


class DocIdentifier {
	String? id = null;
	String? rev = null;
	DocIdentifier({
			String? id,
			String? rev
		}) : id = id ?? null,
		rev = rev ?? null;

	static Map<String, dynamic> encode(DocIdentifier value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev
		};
		return entityAsMap;
	}

	static DocIdentifier fromJSON(Map<String, dynamic> data) {
		return DocIdentifier(
			id: (data["id"] as String?),
			rev: (data["rev"] as String?)
		);
	}
}