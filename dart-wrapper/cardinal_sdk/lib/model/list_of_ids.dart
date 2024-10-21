// This file is auto-generated


class ListOfIds {
	List<String> ids = [];

	ListOfIds({
		List<String>? ids
	}) : ids = ids ?? [];

	static Map<String, dynamic> encode(ListOfIds value) {
		Map<String, dynamic> entityAsMap = {
			"ids" : value.ids.map((x0) => x0)
		};
		return entityAsMap;
	}
}