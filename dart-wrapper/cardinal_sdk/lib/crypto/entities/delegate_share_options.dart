// This file is auto-generated
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/model/requests/requested_permission.dart';


class DelegateShareOptions {
	Set<String> shareSecretIds;
	Set<HexString> shareEncryptionKeys;
	Set<String> shareOwningEntityIds;
	RequestedPermission requestedPermissions;

	DelegateShareOptions({
		required this.shareSecretIds,
		required this.shareEncryptionKeys,
		required this.shareOwningEntityIds,
		required this.requestedPermissions
	});

	static Map<String, dynamic> encode(DelegateShareOptions value) {
		Map<String, dynamic> entityAsMap = {
			"shareSecretIds" : value.shareSecretIds.map((x0) => x0),
			"shareEncryptionKeys" : value.shareEncryptionKeys.map((x0) => x0),
			"shareOwningEntityIds" : value.shareOwningEntityIds.map((x0) => x0),
			"requestedPermissions" : RequestedPermission.encode(value.requestedPermissions)
		};
		return entityAsMap;
	}
}