// auto-generated file
import 'package:cardinal_sdk/model/base/stored_document.dart';


class EntityReference implements StoredDocument {
	@override String id;
	@override String? rev;
	@override int? deletionDate;
	String? docId;
	EntityReference(
		this.id,
		{
			this.rev,
			this.deletionDate,
			this.docId
		});

	factory EntityReference.fromJSON(Map<String, dynamic> data) {
		return EntityReference(
			(data["id"] as String),
			rev: (data["rev"] as String?),
			deletionDate: (data["deletionDate"] as int?),
			docId: (data["docId"] as String?),
		);
	}

	static Map<String, dynamic> encode(EntityReference value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"deletionDate" : value.deletionDate,
			"docId" : value.docId
		};
		return entityAsMap;
	}
}