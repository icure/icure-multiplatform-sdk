// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "deleted_attachment.freezed.dart";


@freezed
abstract class DeletedAttachment with _$DeletedAttachment {
	const factory DeletedAttachment({
		@Default(null) String? couchDbAttachmentId,
		@Default(null) String? objectStoreAttachmentId,
		@Default(null) String? key,
		@Default(null) int? deletionTime,
	}) = _DeletedAttachment;


	static Map<String, dynamic> encode(DeletedAttachment value) {
		Map<String, dynamic> entityAsMap = {
			"couchDbAttachmentId" : value.couchDbAttachmentId,
			"objectStoreAttachmentId" : value.objectStoreAttachmentId,
			"key" : value.key,
			"deletionTime" : value.deletionTime
		};
		return entityAsMap;
	}

	static DeletedAttachment fromJSON(Map<String, dynamic> data) {
		return DeletedAttachment(
			couchDbAttachmentId: (data["couchDbAttachmentId"] as String?),
			objectStoreAttachmentId: (data["objectStoreAttachmentId"] as String?),
			key: (data["key"] as String?),
			deletionTime: (data["deletionTime"] as int?)
		);
	}
}