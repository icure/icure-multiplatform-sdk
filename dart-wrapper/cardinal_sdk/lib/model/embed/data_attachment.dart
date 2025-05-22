// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "data_attachment.freezed.dart";


@freezed
abstract class DataAttachment with _$DataAttachment {
	const factory DataAttachment({
		@Default(null) String? couchDbAttachmentId,
		@Default(null) String? objectStoreAttachmentId,
		@Default([]) List<String> utis,
	}) = _DataAttachment;


	static Map<String, dynamic> encode(DataAttachment value) {
		Map<String, dynamic> entityAsMap = {
			"couchDbAttachmentId" : value.couchDbAttachmentId,
			"objectStoreAttachmentId" : value.objectStoreAttachmentId,
			"utis" : value.utis.map((x0) => x0).toList()
		};
		return entityAsMap;
	}

	static DataAttachment fromJSON(Map<String, dynamic> data) {
		return DataAttachment(
			couchDbAttachmentId: (data["couchDbAttachmentId"] as String?),
			objectStoreAttachmentId: (data["objectStoreAttachmentId"] as String?),
			utis: (data["utis"] as List<dynamic>).map((x0) => (x0 as String) ).toList()
		);
	}
}