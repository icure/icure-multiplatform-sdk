// auto-generated file
import 'package:cardinal_sdk/model/base/stored_document.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "entity_template.freezed.dart";


@freezed
abstract class EntityTemplate with _$EntityTemplate implements StoredDocument {
	const factory EntityTemplate({
		required String id,
		@Default(null) String? rev,
		@Default(null) int? deletionDate,
		@Default(null) String? userId,
		@Default(null) String? descr,
		@Default(null) Set<String>? keywords,
		@Default(null) String? entityType,
		@Default(null) String? subType,
		@Default(null) bool? defaultTemplate,
		@Default([]) List<Map<String, dynamic>> entity,
	}) = _EntityTemplate;


	static Map<String, dynamic> encode(EntityTemplate value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"deletionDate" : value.deletionDate,
			"userId" : value.userId,
			"descr" : value.descr,
			"keywords" : value.keywords?.map((x0) => x0).toList(),
			"entityType" : value.entityType,
			"subType" : value.subType,
			"defaultTemplate" : value.defaultTemplate,
			"entity" : value.entity.map((x0) => x0).toList()
		};
		return entityAsMap;
	}

	static EntityTemplate fromJSON(Map<String, dynamic> data) {
		return EntityTemplate(
			id: (data["id"] as String),
			rev: (data["rev"] as String?),
			deletionDate: (data["deletionDate"] as int?),
			userId: (data["userId"] as String?),
			descr: (data["descr"] as String?),
			keywords: (data["keywords"] as List<dynamic>?)?.map((x0) => (x0 as String) ).toSet(),
			entityType: (data["entityType"] as String?),
			subType: (data["subType"] as String?),
			defaultTemplate: (data["defaultTemplate"] as bool?),
			entity: (data["entity"] as List<dynamic>).map((x0) => (x0 as Map<String, dynamic>) ).toList(),
		);
	}
}