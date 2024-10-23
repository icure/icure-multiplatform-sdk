// auto-generated file


class DocIdentifier {
	String? id;
	String? rev;
	DocIdentifier({
			this.id,
			this.rev
		});

	factory DocIdentifier.fromJSON(Map<String, dynamic> data) {
		return DocIdentifier(
			id: data["id"],
			rev: data["rev"]
		);
	}

	static Map<String, dynamic> encode(DocIdentifier value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev
		};
		return entityAsMap;
	}
}