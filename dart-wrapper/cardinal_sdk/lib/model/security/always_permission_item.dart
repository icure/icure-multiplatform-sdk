// This file is auto-generated
import 'package:cardinal_sdk/model/security/permission_type.dart';
import 'package:cardinal_sdk/model/filter/predicate/always_predicate.dart';
import 'package:cardinal_sdk/model/security/permission_item.dart';


class AlwaysPermissionItem implements PermissionItem {
	@override  PermissionType type;
	@override  AlwaysPredicate predicate;

	AlwaysPermissionItem({
		required this.type
	}) : predicate = AlwaysPredicate();

	static Map<String, dynamic> encode(AlwaysPermissionItem value) {
		Map<String, dynamic> entityAsMap = {
			"type" : PermissionType.encode(value.type)
		};
		return entityAsMap;
	}
}