// auto-generated file
import 'package:cardinal_sdk/model/requests/requested_permission.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
part "delegate_share_options.freezed.dart";


@freezed
abstract class DelegateShareOptions with _$DelegateShareOptions {
	const factory DelegateShareOptions({
		required Set<String> shareSecretIds,
		required Set<HexString> shareEncryptionKeys,
		required Set<String> shareOwningEntityIds,
		required RequestedPermission requestedPermissions,
	}) = _DelegateShareOptions;


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
			shareSecretIds: (data["shareSecretIds"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			shareEncryptionKeys: (data["shareEncryptionKeys"] as List<dynamic>).map((x0) => (x0 as HexString) ).toSet(),
			shareOwningEntityIds: (data["shareOwningEntityIds"] as List<dynamic>).map((x0) => (x0 as String) ).toSet(),
			requestedPermissions: RequestedPermission.fromJSON(data["requestedPermissions"])
		);
	}
}