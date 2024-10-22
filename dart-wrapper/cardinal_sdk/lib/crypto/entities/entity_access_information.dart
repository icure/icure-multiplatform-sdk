// This file is auto-generated
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
			data["permissionsByDataOwnerId"].map((k0, v0) => MapEntry(k0, AccessLevel.fromJSON(v0))),
			data["hasUnknownAnonymousDataOwners"]
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