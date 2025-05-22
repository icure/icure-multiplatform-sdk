// auto-generated file
import 'package:freezed_annotation/freezed_annotation.dart';
part "entity_reference_in_group.freezed.dart";


@freezed
abstract class EntityReferenceInGroup with _$EntityReferenceInGroup {
	const factory EntityReferenceInGroup({
		required String entityId,
		@Default(null) String? groupId,
	}) = _EntityReferenceInGroup;


	static Map<String, dynamic> encode(EntityReferenceInGroup value) {
		Map<String, dynamic> entityAsMap = {
			"entityId" : value.entityId,
			"groupId" : value.groupId
		};
		return entityAsMap;
	}

	static EntityReferenceInGroup fromJSON(Map<String, dynamic> data) {
		return EntityReferenceInGroup(
			entityId: (data["entityId"] as String),
			groupId: (data["groupId"] as String?),
		);
	}
}