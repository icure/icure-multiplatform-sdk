// auto-generated file
import 'package:cardinal_sdk/model/base/stored_document.dart';


class EntityReference implements StoredDocument {
	@override String id;
	@override String? rev = null;
	@override int? deletionDate = null;
	String? docId = null;
	EntityReference(
		this.id,
		{
			String? rev,
			int? deletionDate,
			String? docId
		}) : rev = rev ?? null,
		deletionDate = deletionDate ?? null,
		docId = docId ?? null;

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
			(data["id"] as String),
			rev: (data["rev"] as String?),
			deletionDate: (data["deletionDate"] as int?),
			docId: (data["docId"] as String?),
		);
	}
}