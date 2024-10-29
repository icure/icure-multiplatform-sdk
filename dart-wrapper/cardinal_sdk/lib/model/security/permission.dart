// auto-generated file
import 'package:cardinal_sdk/model/security/permission_item.dart';


class Permission {
	Set<PermissionItem> grants = {};
	Set<PermissionItem> revokes = {};
	Permission({
			Set<PermissionItem>? grants,
			Set<PermissionItem>? revokes
		}) : grants = grants ?? {},
		revokes = revokes ?? {};

	factory Permission.fromJSON(Map<String, dynamic> data) {
		return Permission(
			grants: (data["grants"] as List<dynamic>).map((x0) => PermissionItem.fromJSON(x0) ).toSet(),
			revokes: (data["revokes"] as List<dynamic>).map((x0) => PermissionItem.fromJSON(x0) ).toSet()
		);
	}

	static Map<String, dynamic> encode(Permission value) {
		Map<String, dynamic> entityAsMap = {
			"grants" : value.grants.map((x0) => PermissionItem.encode(x0)).toList(),
			"revokes" : value.revokes.map((x0) => PermissionItem.encode(x0)).toList()
		};
		return entityAsMap;
	}
}