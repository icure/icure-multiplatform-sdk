// auto-generated file
import 'package:cardinal_sdk/model/requests/requested_permission.dart';
import 'package:cardinal_sdk/crypto/entities/share_metadata_behaviour.dart';
import 'package:cardinal_sdk/crypto/entities/secret_id_share_options.dart';


class ReceiptShareOptions {
	RequestedPermission requestedPermissions = RequestedPermission.maxWrite;
	ShareMetadataBehaviour shareEncryptionKey = ShareMetadataBehaviour.ifAvailable;
	SecretIdShareOptions shareSecretIds = SecretIdShareOptionsAllAvailable(false);
	ReceiptShareOptions({
			RequestedPermission? requestedPermissions,
			ShareMetadataBehaviour? shareEncryptionKey,
			SecretIdShareOptions? shareSecretIds
		}) : requestedPermissions = requestedPermissions ?? RequestedPermission.maxWrite,
		shareEncryptionKey = shareEncryptionKey ?? ShareMetadataBehaviour.ifAvailable,
		shareSecretIds = shareSecretIds ?? SecretIdShareOptionsAllAvailable(false);

	factory ReceiptShareOptions.fromJSON(Map<String, dynamic> data) {
		return ReceiptShareOptions(
			requestedPermissions: RequestedPermission.fromJSON(data["requestedPermissions"]),
			shareEncryptionKey: ShareMetadataBehaviour.fromJSON(data["shareEncryptionKey"]),
			shareSecretIds: SecretIdShareOptions.fromJSON(data["shareSecretIds"])
		);
	}

	static Map<String, dynamic> encode(ReceiptShareOptions value) {
		Map<String, dynamic> entityAsMap = {
			"requestedPermissions" : RequestedPermission.encode(value.requestedPermissions),
			"shareEncryptionKey" : ShareMetadataBehaviour.encode(value.shareEncryptionKey),
			"shareSecretIds" : SecretIdShareOptions.encode(value.shareSecretIds)
		};
		return entityAsMap;
	}
}