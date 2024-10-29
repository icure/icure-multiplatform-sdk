// auto-generated file


class DeletedAttachment {
	String? couchDbAttachmentId = null;
	String? objectStoreAttachmentId = null;
	String? key = null;
	int? deletionTime = null;
	DeletedAttachment({
			String? couchDbAttachmentId,
			String? objectStoreAttachmentId,
			String? key,
			int? deletionTime
		}) : couchDbAttachmentId = couchDbAttachmentId ?? null,
		objectStoreAttachmentId = objectStoreAttachmentId ?? null,
		key = key ?? null,
		deletionTime = deletionTime ?? null;

	factory DeletedAttachment.fromJSON(Map<String, dynamic> data) {
		return DeletedAttachment(
			couchDbAttachmentId: (data["couchDbAttachmentId"] as String?),
			objectStoreAttachmentId: (data["objectStoreAttachmentId"] as String?),
			key: (data["key"] as String?),
			deletionTime: (data["deletionTime"] as int?)
		);
	}

	static Map<String, dynamic> encode(DeletedAttachment value) {
		Map<String, dynamic> entityAsMap = {
			"couchDbAttachmentId" : value.couchDbAttachmentId,
			"objectStoreAttachmentId" : value.objectStoreAttachmentId,
			"key" : value.key,
			"deletionTime" : value.deletionTime
		};
		return entityAsMap;
	}
}