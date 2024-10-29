// auto-generated file
import 'package:cardinal_sdk/model/embed/access_level.dart';


class EntityAccessInformation {
	Map<String, AccessLevel> permissionsByDataOwnerId;
	bool hasUnknownAnonymousDataOwners;
	EntityAccessInformation(
		this.permissionsByDataOwnerId,
		this.hasUnknownAnonymousDataOwners
		);

	factory EntityAccessInformation.fromJSON(Map<String, dynamic> data) {
		return EntityAccessInformation(
			(data["permissionsByDataOwnerId"] as Map<String, dynamic>).map((k0, v0) => MapEntry((k0 as String), AccessLevel.fromJSON(v0))),
			(data["hasUnknownAnonymousDataOwners"] as bool)
		);
	}

	static Map<String, dynamic> encode(EntityAccessInformation value) {
		Map<String, dynamic> entityAsMap = {
			"permissionsByDataOwnerId" : value.permissionsByDataOwnerId.map((k0, v0) => MapEntry(k0, AccessLevel.encode(v0))),
			"hasUnknownAnonymousDataOwners" : value.hasUnknownAnonymousDataOwners
		};
		return entityAsMap;
	}
}