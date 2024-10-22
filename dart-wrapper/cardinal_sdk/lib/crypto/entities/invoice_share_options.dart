// This file is auto-generated
import 'package:cardinal_sdk/model/requests/requested_permission.dart';
import 'package:cardinal_sdk/crypto/entities/share_metadata_behaviour.dart';
import 'package:cardinal_sdk/crypto/entities/secret_id_share_options.dart';


class InvoiceShareOptions {
	RequestedPermission requestedPermissions = RequestedPermission.maxWrite;
	ShareMetadataBehaviour shareEncryptionKey = ShareMetadataBehaviour.ifAvailable;
	ShareMetadataBehaviour sharePatientId = ShareMetadataBehaviour.ifAvailable;
	SecretIdShareOptions shareSecretIds = SecretIdShareOptionsAllAvailable(false);
	InvoiceShareOptions({
			RequestedPermission? requestedPermissions,
			ShareMetadataBehaviour? shareEncryptionKey,
			ShareMetadataBehaviour? sharePatientId,
			SecretIdShareOptions? shareSecretIds
		}) : requestedPermissions = requestedPermissions ?? RequestedPermission.maxWrite,
		shareEncryptionKey = shareEncryptionKey ?? ShareMetadataBehaviour.ifAvailable,
		sharePatientId = sharePatientId ?? ShareMetadataBehaviour.ifAvailable,
		shareSecretIds = shareSecretIds ?? SecretIdShareOptionsAllAvailable(false);

	factory InvoiceShareOptions.fromJSON(Map<String, dynamic> data) {
		return InvoiceShareOptions(
			requestedPermissions: RequestedPermission.fromJSON(data["requestedPermissions"]),
			shareEncryptionKey: ShareMetadataBehaviour.fromJSON(data["shareEncryptionKey"]),
			sharePatientId: ShareMetadataBehaviour.fromJSON(data["sharePatientId"]),
			shareSecretIds: SecretIdShareOptions.fromJSON(data["shareSecretIds"])
		);
	}

	static Map<String, dynamic> encode(InvoiceShareOptions value) {
		Map<String, dynamic> entityAsMap = {
			"requestedPermissions" : RequestedPermission.encode(value.requestedPermissions),
			"shareEncryptionKey" : ShareMetadataBehaviour.encode(value.shareEncryptionKey),
			"sharePatientId" : ShareMetadataBehaviour.encode(value.sharePatientId),
			"shareSecretIds" : SecretIdShareOptions.encode(value.shareSecretIds)
		};
		return entityAsMap;
	}
}