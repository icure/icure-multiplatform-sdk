// auto-generated file
import 'package:cardinal_sdk/model/security/permission_type.dart';
import 'package:cardinal_sdk/model/filter/predicate/predicate.dart';
import 'package:cardinal_sdk/model/security/always_permission_item.dart';


abstract interface class PermissionItem {
	abstract PermissionType type;
	Predicate get predicate;

	static Map<String, dynamic> encode(PermissionItem value) {
		switch (value) {
			case AlwaysPermissionItem entity:
				Map<String, dynamic> entityJson = AlwaysPermissionItem.encode(entity);
				entityJson["kotlinType"] = "AlwaysPermissionItemDto";
				return entityJson;
			default:
				throw ArgumentError('Invalid subclass $value');
		}
	}

	static PermissionItem fromJSON(Map<String, dynamic> data) {
		if (data["kotlinType"] == null) {
			throw ArgumentError('Missing discriminator: kotlinType');
		}
		String discriminator = data["kotlinType"];
		switch (discriminator) {
			case "AlwaysPermissionItemDto":
				return AlwaysPermissionItem.fromJSON(data);
			default:
				throw ArgumentError('Invalid subclass $discriminator');
		}
	}
}