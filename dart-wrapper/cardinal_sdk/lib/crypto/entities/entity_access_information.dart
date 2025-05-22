// auto-generated file
import 'package:cardinal_sdk/model/entity_reference_in_group.dart';
import 'package:cardinal_sdk/model/embed/access_level.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "entity_access_information.freezed.dart";


@freezed
abstract class EntityAccessInformation with _$EntityAccessInformation {
	const factory EntityAccessInformation({
		required Map<EntityReferenceInGroup, AccessLevel> permissionsByDataOwnerId,
		required bool hasUnknownAnonymousDataOwners,
	}) = _EntityAccessInformation;


	static Map<String, dynamic> encode(EntityAccessInformation value) {
		Map<String, dynamic> entityAsMap = {
			"permissionsByDataOwnerId" : value.permissionsByDataOwnerId.entries.map((x0) => {
				"k": EntityReferenceInGroup.encode(x0.key),
				"v": AccessLevel.encode(x0.value),
			}).toList(),
			"hasUnknownAnonymousDataOwners" : value.hasUnknownAnonymousDataOwners
		};
		return entityAsMap;
	}

	static EntityAccessInformation fromJSON(Map<String, dynamic> data) {
		return EntityAccessInformation(
			permissionsByDataOwnerId: { for (var x0 in (data["permissionsByDataOwnerId"] as List<dynamic>).map((z0) => z0 as Map<String, dynamic>)) EntityReferenceInGroup.fromJSON(x0["k"]) : AccessLevel.fromJSON(x0["v"]) },
			hasUnknownAnonymousDataOwners: (data["hasUnknownAnonymousDataOwners"] as bool)
		);
	}
}