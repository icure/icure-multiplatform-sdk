// This file is auto-generated


class IdWithMandatoryRev {
	String id;
	String rev;

	IdWithMandatoryRev({
		required this.id,
		required this.rev
	});

	static Map<String, dynamic> encode(IdWithMandatoryRev value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev
		};
		return entityAsMap;
	}
}