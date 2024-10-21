// This file is auto-generated


class View {
	String map;
	String? reduce;

	View({
		required this.map,
		this.reduce
	});

	static Map<String, dynamic> encode(View value) {
		Map<String, dynamic> entityAsMap = {
			"map" : value.map,
			"reduce" : value.reduce
		};
		return entityAsMap;
	}
}