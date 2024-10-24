// auto-generated file


class View {
	String map;
	String? reduce;
	View(
		this.map,
		{
			this.reduce
		});

	factory View.fromJSON(Map<String, dynamic> data) {
		return View(
			(data["map"] as String),
			reduce: (data["reduce"] as String?),
		);
	}

	static Map<String, dynamic> encode(View value) {
		Map<String, dynamic> entityAsMap = {
			"map" : value.map,
			"reduce" : value.reduce
		};
		return entityAsMap;
	}
}