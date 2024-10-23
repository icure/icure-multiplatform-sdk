// auto-generated file


class IndexingInfo {
	Map<String, int>? statuses;
	IndexingInfo({
			this.statuses});

	factory IndexingInfo.fromJSON(Map<String, dynamic> data) {
		return IndexingInfo(
			statuses: data["statuses"]?.map((k0, v0) => MapEntry(k0, v0))
		);
	}

	static Map<String, dynamic> encode(IndexingInfo value) {
		Map<String, dynamic> entityAsMap = {
			"statuses" : value.statuses?.map((k0, v0) => MapEntry(k0, v0))
		};
		return entityAsMap;
	}
}