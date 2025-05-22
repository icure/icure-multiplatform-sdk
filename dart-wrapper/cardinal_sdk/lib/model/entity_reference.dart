// auto-generated file
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "entity_reference.freezed.dart";


@freezed
abstract class EntityReference with _$EntityReference implements StoredDocument {
	const factory EntityReference({
		required String id,
		@Default(null) String? rev,
		@Default(null) int? deletionDate,
		@Default(null) String? docId,
	}) = _EntityReference;


	static Map<String, dynamic> encode(EntityReference value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"deletionDate" : value.deletionDate,
			"docId" : value.docId
		};
		return entityAsMap;
	}

	static EntityReference fromJSON(Map<String, dynamic> data) {
		return EntityReference(
			id: (data["id"] as String),
			rev: (data["rev"] as String?),
			deletionDate: (data["deletionDate"] as int?),
			docId: (data["docId"] as String?),
		);
	}
}