// This file is auto-generated


class IndexingInfo {
	Map<String, int>? statuses;

	IndexingInfo({
		this.statuses
	});

	static Map<String, dynamic> encode(IndexingInfo value) {
		Map<String, dynamic> entityAsMap = {
			"statuses" : value.statuses?.map((k0, v0) => MapEntry(k0, v0))
		};
		return entityAsMap;
	}
}