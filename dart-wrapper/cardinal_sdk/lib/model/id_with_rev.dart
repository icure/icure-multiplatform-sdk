// auto-generated file


class IdWithRev {
	String id;
	String? rev;
	IdWithRev(
		this.id,
		{
			this.rev
		});

	factory IdWithRev.fromJSON(Map<String, dynamic> data) {
		return IdWithRev(
			data["id"],
			rev: data["rev"],
		);
	}

	static Map<String, dynamic> encode(IdWithRev value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev
		};
		return entityAsMap;
	}
}