// This file is auto-generated
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
			data["id"],
			rev: data["rev"],
			deletionDate: data["deletionDate"],
			docId: data["docId"],
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