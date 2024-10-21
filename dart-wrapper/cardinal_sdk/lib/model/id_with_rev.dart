// This file is auto-generated


class IdWithRev {
	String id;
	String? rev;

	IdWithRev({
		required this.id,
		this.rev
	});

	static Map<String, dynamic> encode(IdWithRev value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev
		};
		return entityAsMap;
	}
}