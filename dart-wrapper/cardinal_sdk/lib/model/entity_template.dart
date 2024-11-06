// auto-generated file
import 'package:cardinal_sdk/model/base/stored_document.dart';


class EntityTemplate implements StoredDocument {
	@override String id;
	@override String? rev = null;
	@override int? deletionDate = null;
	String? userId = null;
	String? descr = null;
	Set<String>? keywords = null;
	String? entityType = null;
	String? subType = null;
	bool? defaultTemplate = null;
	List<Map<String, dynamic>> entity = [];
	EntityTemplate(
		this.id,
		{
			String? rev,
			int? deletionDate,
			String? userId,
			String? descr,
			Set<String>? keywords,
			String? entityType,
			String? subType,
			bool? defaultTemplate,
			List<Map<String, dynamic>>? entity
		}) : rev = rev ?? null,
		deletionDate = deletionDate ?? null,
		userId = userId ?? null,
		descr = descr ?? null,
		keywords = keywords ?? null,
		entityType = entityType ?? null,
		subType = subType ?? null,
		defaultTemplate = defaultTemplate ?? null,
		entity = entity ?? [];

	factory EntityTemplate.fromJSON(Map<String, dynamic> data) {
		return EntityTemplate(
			(data["id"] as String),
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
}