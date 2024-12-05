// auto-generated file


class GroupDeletionReport {
	String type;
	String id;
	String server;
	GroupDeletionReport(
		this.type,
		this.id,
		this.server
		);

	static Map<String, dynamic> encode(GroupDeletionReport value) {
		Map<String, dynamic> entityAsMap = {
			"type" : value.type,
			"id" : value.id,
			"server" : value.server
		};
		return entityAsMap;
	}

	static GroupDeletionReport fromJSON(Map<String, dynamic> data) {
		return GroupDeletionReport(
			(data["type"] as String),
			(data["id"] as String),
			(data["server"] as String)
		);
	}
}