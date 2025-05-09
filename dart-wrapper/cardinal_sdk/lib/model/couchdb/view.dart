// auto-generated file


class View {
	String map;
	String? reduce = null;
	View(
		this.map,
		{
			String? reduce
		}) : reduce = reduce ?? null;

	static Map<String, dynamic> encode(View value) {
		Map<String, dynamic> entityAsMap = {
			"map" : value.map,
			"reduce" : value.reduce
		};
		return entityAsMap;
	}

	static View fromJSON(Map<String, dynamic> data) {
		return View(
			(data["map"] as String),
			reduce: (data["reduce"] as String?),
		);
	}
}