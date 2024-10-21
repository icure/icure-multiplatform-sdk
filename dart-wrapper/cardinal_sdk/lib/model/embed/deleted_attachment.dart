// This file is auto-generated


class DeletedAttachment {
	String? couchDbAttachmentId;
	String? objectStoreAttachmentId;
	String? key;
	int? deletionTime;

	DeletedAttachment({
		this.couchDbAttachmentId,
		this.objectStoreAttachmentId,
		this.key,
		this.deletionTime
	});

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