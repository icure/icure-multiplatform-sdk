// This file is auto-generated


class MessageReadStatus {
	int? time;
	bool read = false;

	MessageReadStatus({
		this.time,
		bool? read
	}) : read = read ?? false;

	static Map<String, dynamic> encode(MessageReadStatus value) {
		Map<String, dynamic> entityAsMap = {
			"time" : value.time,
			"read" : value.read
		};
		return entityAsMap;
	}
}