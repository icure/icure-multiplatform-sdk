// auto-generated file


class DataAttachment {
	String? couchDbAttachmentId = null;
	String? objectStoreAttachmentId = null;
	List<String> utis = [];
	DataAttachment({
			String? couchDbAttachmentId,
			String? objectStoreAttachmentId,
			List<String>? utis
		}) : couchDbAttachmentId = couchDbAttachmentId ?? null,
		objectStoreAttachmentId = objectStoreAttachmentId ?? null,
		utis = utis ?? [];

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