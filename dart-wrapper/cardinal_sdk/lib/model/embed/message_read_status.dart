// auto-generated file


class MessageReadStatus {
	int? time;
	bool read = false;
	MessageReadStatus({
			this.time,
			bool? read
		}) : read = read ?? false;

	factory MessageReadStatus.fromJSON(Map<String, dynamic> data) {
		return MessageReadStatus(
			time: (data["time"] as int?),
			read: (data["read"] as bool)
		);
	}

	static Map<String, dynamic> encode(MessageReadStatus value) {
		Map<String, dynamic> entityAsMap = {
			"time" : value.time,
			"read" : value.read
		};
		return entityAsMap;
	}
}