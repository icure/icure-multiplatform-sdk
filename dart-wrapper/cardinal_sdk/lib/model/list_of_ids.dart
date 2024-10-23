// auto-generated file


class ListOfIds {
	List<String> ids = [];
	ListOfIds({
			List<String>? ids}) : ids = ids ?? [];

	factory ListOfIds.fromJSON(Map<String, dynamic> data) {
		return ListOfIds(
			ids: data["ids"].map((x0) => x0 )
		);
	}

	static Map<String, dynamic> encode(ListOfIds value) {
		Map<String, dynamic> entityAsMap = {
			"ids" : value.ids.map((x0) => x0)
		};
		return entityAsMap;
	}
}