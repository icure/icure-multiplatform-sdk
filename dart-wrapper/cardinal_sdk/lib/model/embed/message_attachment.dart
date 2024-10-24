// auto-generated file
import 'package:cardinal_sdk/model/embed/document_location.dart';


class MessageAttachment {
	DocumentLocation? type;
	List<String> ids = [];
	MessageAttachment({
			this.type,
			List<String>? ids
		}) : ids = ids ?? [];

	factory MessageAttachment.fromJSON(Map<String, dynamic> data) {
		return MessageAttachment(
			type: data["type"] == null ? null : DocumentLocation.fromJSON(data["type"]),
			ids: data["ids"].map((x0) => x0 ).toList()
		);
	}

	static Map<String, dynamic> encode(MessageAttachment value) {
		Map<String, dynamic> entityAsMap = {
			"type" : value.type == null ? null : DocumentLocation.encode(value.type!),
			"ids" : value.ids.map((x0) => x0).toList()
		};
		return entityAsMap;
	}
}