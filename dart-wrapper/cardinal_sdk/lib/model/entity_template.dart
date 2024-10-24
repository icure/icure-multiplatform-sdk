// auto-generated file
import 'package:cardinal_sdk/model/base/stored_document.dart';


class EntityTemplate implements StoredDocument {
	@override String id;
	@override String? rev;
	@override int? deletionDate;
	String? userId;
	String? descr;
	Set<String>? keywords;
	String? entityType;
	String? subType;
	bool? defaultTemplate;
	List<Map<String, dynamic>> entity = [];
	EntityTemplate(
		this.id,
		{
			this.rev,
			this.deletionDate,
			this.userId,
			this.descr,
			this.keywords,
			this.entityType,
			this.subType,
			this.defaultTemplate,
			List<Map<String, dynamic>>? entity
		}) : entity = entity ?? [];

	factory EntityTemplate.fromJSON(Map<String, dynamic> data) {
		return EntityTemplate(
			data["id"],
			rev: data["rev"],
			deletionDate: data["deletionDate"],
			userId: data["userId"],
			descr: data["descr"],
			keywords: data["keywords"]?.map((x0) => x0 ).toList(),
			entityType: data["entityType"],
			subType: data["subType"],
			defaultTemplate: data["defaultTemplate"],
			entity: data["entity"].map((x0) => x0 ).toList(),
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