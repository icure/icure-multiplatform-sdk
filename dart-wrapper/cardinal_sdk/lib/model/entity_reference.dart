// This file is auto-generated
import 'package:cardinal_sdk/model/base/stored_document.dart';


class EntityReference implements StoredDocument {
	@override  String id;
	@override  String? rev;
	@override  int? deletionDate;
	String? docId;

	EntityReference({
		required this.id,
		this.rev,
		this.deletionDate,
		this.docId
	});

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