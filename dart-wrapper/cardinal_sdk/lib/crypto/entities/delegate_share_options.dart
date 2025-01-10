// auto-generated file
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/model/requests/requested_permission.dart';


class DelegateShareOptions {
	Set<String> shareSecretIds;
	Set<HexString> shareEncryptionKeys;
	Set<String> shareOwningEntityIds;
	RequestedPermission requestedPermissions;
	DelegateShareOptions(
		this.shareSecretIds,
		this.shareEncryptionKeys,
		this.shareOwningEntityIds,
		this.requestedPermissions
		);

	static Map<String, dynamic> encode(DelegateShareOptions value) {
		Map<String, dynamic> entityAsMap = {
			"shareSecretIds" : value.shareSecretIds.map((x0) => x0).toList(),
			"shareEncryptionKeys" : value.shareEncryptionKeys.map((x0) => x0).toList(),
			"shareOwningEntityIds" : value.shareOwningEntityIds.map((x0) => x0).toList(),
			"requestedPermissions" : RequestedPermission.encode(value.requestedPermissions)
		};
		return entityAsMap;
	}

	static DelegateShareOptions fromJSON(Map<String, dynamic> data) {
		return DelegateShareOptions(
			(data["shareSecretIds"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			(data["shareEncryptionKeys"] as List<dynamic>).map((x0) => (x0 as HexString) ).toSet(),
			(data["shareOwningEntityIds"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			RequestedPermission.fromJSON(data["requestedPermissions"])
		);
	}
}