// auto-generated file
import 'package:cardinal_sdk/model/security/permission_item.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "permission.freezed.dart";


@freezed
abstract class Permission with _$Permission {
	const factory Permission({
		@Default({}) Set<PermissionItem> grants,
		@Default({}) Set<PermissionItem> revokes,
	}) = _Permission;


	static Map<String, dynamic> encode(Permission value) {
		Map<String, dynamic> entityAsMap = {
			"grants" : value.grants.map((x0) => PermissionItem.encode(x0)).toList(),
			"revokes" : value.revokes.map((x0) => PermissionItem.encode(x0)).toList()
		};
		return entityAsMap;
	}

	static Permission fromJSON(Map<String, dynamic> data) {
		return Permission(
			grants: (data["grants"] as List<dynamic>).map((x0) => PermissionItem.fromJSON(x0) ).toSet(),
			revokes: (data["revokes"] as List<dynamic>).map((x0) => PermissionItem.fromJSON(x0) ).toSet()
		);
	}
}