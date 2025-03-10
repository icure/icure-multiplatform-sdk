// auto-generated file


class IdWithMandatoryRev {
	String id;
	String rev;
	IdWithMandatoryRev(
		this.id,
		this.rev
		);

	static Map<String, dynamic> encode(IdWithMandatoryRev value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev
		};
		return entityAsMap;
	}

	static IdWithMandatoryRev fromJSON(Map<String, dynamic> data) {
		return IdWithMandatoryRev(
			(data["id"] as String),
			(data["rev"] as String)
		);
	}
}