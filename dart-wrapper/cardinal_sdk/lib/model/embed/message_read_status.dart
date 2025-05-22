// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "message_read_status.freezed.dart";


@freezed
abstract class MessageReadStatus with _$MessageReadStatus {
	const factory MessageReadStatus({
		@Default(null) int? time,
		@Default(false) bool read,
	}) = _MessageReadStatus;


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