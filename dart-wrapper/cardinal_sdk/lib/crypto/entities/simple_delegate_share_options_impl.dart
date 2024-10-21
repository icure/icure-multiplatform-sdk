// This file is auto-generated
import 'package:cardinal_sdk/crypto/entities/secret_id_share_options.dart';
import 'package:cardinal_sdk/crypto/entities/share_metadata_behaviour.dart';
import 'package:cardinal_sdk/model/requests/requested_permission.dart';


class SimpleDelegateShareOptionsImpl {
	SecretIdShareOptions shareSecretIds;
	ShareMetadataBehaviour shareEncryptionKey;
	ShareMetadataBehaviour shareOwningEntityIds;
	RequestedPermission requestedPermissions;

	SimpleDelegateShareOptionsImpl({
		required this.shareSecretIds,
		required this.shareEncryptionKey,
		required this.shareOwningEntityIds,
		required this.requestedPermissions
	});

	static Map<String, dynamic> encode(SimpleDelegateShareOptionsImpl value) {
		Map<String, dynamic> entityAsMap = {
			"shareSecretIds" : SecretIdShareOptions.encode(value.shareSecretIds),
			"shareEncryptionKey" : ShareMetadataBehaviour.encode(value.shareEncryptionKey),
			"shareOwningEntityIds" : ShareMetadataBehaviour.encode(value.shareOwningEntityIds),
			"requestedPermissions" : RequestedPermission.encode(value.requestedPermissions)
		};
		return entityAsMap;
	}
}