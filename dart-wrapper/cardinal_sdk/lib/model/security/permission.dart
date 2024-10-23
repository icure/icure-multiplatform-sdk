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
			grants: data["grants"].map((x0) => PermissionItem.fromJSON(x0) ),
			revokes: data["revokes"].map((x0) => PermissionItem.fromJSON(x0) )
		);
	}

	static Map<String, dynamic> encode(Permission value) {
		Map<String, dynamic> entityAsMap = {
			"grants" : value.grants.map((x0) => PermissionItem.encode(x0)),
			"revokes" : value.revokes.map((x0) => PermissionItem.encode(x0))
		};
		return entityAsMap;
	}
}