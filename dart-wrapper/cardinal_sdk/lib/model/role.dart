// auto-generated file
import 'package:cardinal_sdk/model/base/stored_document.dart';


class Role implements StoredDocument {
	@override String id;
	@override String? rev = null;
	@override int? deletionDate = null;
	String? name = null;
	Set<String> permissions = {};
	Role(
		this.id,
		{
			String? rev,
			int? deletionDate,
			String? name,
			Set<String>? permissions
		}) : rev = rev ?? null,
		deletionDate = deletionDate ?? null,
		name = name ?? null,
		permissions = permissions ?? {};

	static Map<String, dynamic> encode(Role value) {
		Map<String, dynamic> entityAsMap = {
			"id" : value.id,
			"rev" : value.rev,
			"deletionDate" : value.deletionDate,
			"name" : value.name,
			"permissions" : value.permissions.map((x0) => x0).toList()
		};
		return entityAsMap;
	}

	static Role fromJSON(Map<String, dynamic> data) {
		return Role(
			(data["id"] as String),
			rev: (data["rev"] as String?),
			deletionDate: (data["deletionDate"] as int?),
			name: (data["name"] as String?),
			permissions: (data["permissions"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
		);
	}
}