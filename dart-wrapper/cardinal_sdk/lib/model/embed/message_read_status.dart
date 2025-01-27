// auto-generated file


class MessageReadStatus {
	int? time = null;
	bool read = false;
	MessageReadStatus({
			int? time,
			bool? read
		}) : time = time ?? null,
		read = read ?? false;

	static Map<String, dynamic> encode(MessageReadStatus value) {
		Map<String, dynamic> entityAsMap = {
			"time" : value.time,
			"read" : value.read
		};
		return entityAsMap;
	}

	static MessageReadStatus fromJSON(Map<String, dynamic> data) {
		return MessageReadStatus(
			time: (data["time"] as int?),
			read: (data["read"] as bool)
		);
	}
}