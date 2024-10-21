// This file is auto-generated


class GroupDeletionReport {
	String type;
	String id;
	String server;

	GroupDeletionReport({
		required this.type,
		required this.id,
		required this.server
	});

	static Map<String, dynamic> encode(GroupDeletionReport value) {
		Map<String, dynamic> entityAsMap = {
			"type" : value.type,
			"id" : value.id,
			"server" : value.server
		};
		return entityAsMap;
	}
}