// auto-generated file


class IndexingInfo {
	Map<String, int>? statuses = null;
	IndexingInfo({
			Map<String, int>? statuses}) : statuses = statuses ?? null;

	factory IndexingInfo.fromJSON(Map<String, dynamic> data) {
		return IndexingInfo(
			statuses: (data["statuses"] as Map<String, dynamic>?)?.map((k0, v0) => MapEntry((k0 as String), (v0 as int)))
		);
	}

	static Map<String, dynamic> encode(IndexingInfo value) {
		Map<String, dynamic> entityAsMap = {
			"statuses" : value.statuses?.map((k0, v0) => MapEntry(k0, v0))
		};
		return entityAsMap;
	}
}