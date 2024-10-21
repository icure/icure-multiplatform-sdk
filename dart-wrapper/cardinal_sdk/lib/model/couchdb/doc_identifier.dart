// This file is auto-generated


class DocIdentifier {
	String? id;
	String? rev;

	DocIdentifier({
		this.id,
		this.rev
	});

	static Map<String, dynamic> encode(DocIdentifier value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev
		};
		return entityAsMap;
	}
}