// auto-generated file
import 'package:cardinal_sdk/model/embed/document_location.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "message_attachment.freezed.dart";


@freezed
abstract class MessageAttachment with _$MessageAttachment {
	const factory MessageAttachment({
		@Default(null) DocumentLocation? type,
		@Default([]) List<String> ids,
	}) = _MessageAttachment;


	static Map<String, dynamic> encode(MessageAttachment value) {
		Map<String, dynamic> entityAsMap = {
			"type" : value.type == null ? null : DocumentLocation.encode(value.type!),
			"ids" : value.ids.map((x0) => x0).toList()
		};
		return entityAsMap;
	}

	static MessageAttachment fromJSON(Map<String, dynamic> data) {
		return MessageAttachment(
			type: data["type"] == null ? null : DocumentLocation.fromJSON(data["type"]),
			ids: (data["ids"] as List<dynamic>).map((x0) => (x0 as String) ).toList()
		);
	}
}