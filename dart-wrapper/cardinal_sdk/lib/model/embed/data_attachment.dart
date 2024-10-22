// This file is auto-generated


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
			couchDbAttachmentId: data["couchDbAttachmentId"],
			objectStoreAttachmentId: data["objectStoreAttachmentId"],
			utis: data["utis"].map((x0) => x0 )
		);
	}

	static Map<String, dynamic> encode(DataAttachment value) {
		Map<String, dynamic> entityAsMap = {
			"couchDbAttachmentId" : value.couchDbAttachmentId,
			"objectStoreAttachmentId" : value.objectStoreAttachmentId,
			"utis" : value.utis.map((x0) => x0)
		};
		return entityAsMap;
	}
}