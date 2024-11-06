// auto-generated file


class IdWithRev {
	String id;
	String? rev = null;
	IdWithRev(
		this.id,
		{
			String? rev
		}) : rev = rev ?? null;

	factory IdWithRev.fromJSON(Map<String, dynamic> data) {
		return IdWithRev(
			(data["id"] as String),
			rev: (data["rev"] as String?),
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