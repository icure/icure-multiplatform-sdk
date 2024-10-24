// auto-generated file


class DataAttachment {
	String? couchDbAttachmentId;
	String? objectStoreAttachmentId;
	List<String> utis = [];
	DataAttachment({
			this.couchDbAttachmentId,
			this.objectStoreAttachmentId,
			List<String>? utis
		}) : utis = utis ?? [];

	factory DataAttachment.fromJSON(Map<String, dynamic> data) {
		return DataAttachment(
			couchDbAttachmentId: (data["couchDbAttachmentId"] as String?),
			objectStoreAttachmentId: (data["objectStoreAttachmentId"] as String?),
			utis: (data["utis"] as List<dynamic>).map((x0) => (x0 as String) ).toList()
		);
	}

	static Map<String, dynamic> encode(DataAttachment value) {
		Map<String, dynamic> entityAsMap = {
			"couchDbAttachmentId" : value.couchDbAttachmentId,
			"objectStoreAttachmentId" : value.objectStoreAttachmentId,
			"utis" : value.utis.map((x0) => x0).toList()
		};
		return entityAsMap;
	}
}