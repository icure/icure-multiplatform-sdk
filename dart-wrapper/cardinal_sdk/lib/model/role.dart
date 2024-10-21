// This file is auto-generated
import 'package:cardinal_sdk/model/base/stored_document.dart';


class Role implements StoredDocument {
	@override  String id;
	@override  String? rev;
	@override  int? deletionDate;
	String? name;
	Set<String> permissions = {};

	Role({
		required this.id,
		this.rev,
		this.deletionDate,
		this.name,
		Set<String>? permissions
	}) : permissions = permissions ?? {};

	static Map<String, dynamic> encode(Role value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"deletionDate" : value.deletionDate,
			"name" : value.name,
			"permissions" : value.permissions.map((x0) => x0)
		};
		return entityAsMap;
	}
}