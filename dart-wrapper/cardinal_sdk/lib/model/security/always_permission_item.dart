// auto-generated file
import 'package:cardinal_sdk/model/filter/predicate/always_predicate.dart';
import 'package:cardinal_sdk/model/security/permission_type.dart';
import 'package:cardinal_sdk/model/security/permission_item.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "always_permission_item.freezed.dart";


@freezed
abstract class AlwaysPermissionItem with _$AlwaysPermissionItem implements PermissionItem {

	@override AlwaysPredicate get predicate => AlwaysPredicate();
	const factory AlwaysPermissionItem({
		required PermissionType type,
	}) = _AlwaysPermissionItem;

	const AlwaysPermissionItem._();

	static Map<String, dynamic> encode(AlwaysPermissionItem value) {
		Map<String, dynamic> entityAsMap = {
			"type" : PermissionType.encode(value.type)
		};
		return entityAsMap;
	}

	static AlwaysPermissionItem fromJSON(Map<String, dynamic> data) {
		return AlwaysPermissionItem(
			type: PermissionType.fromJSON(data["type"])
		);
	}
}