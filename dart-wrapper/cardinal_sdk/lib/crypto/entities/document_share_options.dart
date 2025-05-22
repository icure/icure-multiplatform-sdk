// auto-generated file
import 'package:cardinal_sdk/model/requests/requested_permission.dart';
import 'package:cardinal_sdk/crypto/entities/share_metadata_behaviour.dart';
import 'package:cardinal_sdk/crypto/entities/secret_id_share_options.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "document_share_options.freezed.dart";


@freezed
abstract class DocumentShareOptions with _$DocumentShareOptions {
	const factory DocumentShareOptions({
		@Default(RequestedPermission.maxWrite) RequestedPermission requestedPermissions,
		@Default(ShareMetadataBehaviour.ifAvailable) ShareMetadataBehaviour shareEncryptionKey,
		@Default(ShareMetadataBehaviour.ifAvailable) ShareMetadataBehaviour shareMessageId,
		@Default(SecretIdShareOptionsAllAvailable()) SecretIdShareOptions shareSecretIds,
	}) = _DocumentShareOptions;


	static Map<String, dynamic> encode(DocumentShareOptions value) {
		Map<String, dynamic> entityAsMap = {
			"requestedPermissions" : RequestedPermission.encode(value.requestedPermissions),
			"shareEncryptionKey" : ShareMetadataBehaviour.encode(value.shareEncryptionKey),
			"shareMessageId" : ShareMetadataBehaviour.encode(value.shareMessageId),
			"shareSecretIds" : SecretIdShareOptions.encode(value.shareSecretIds)
		};
		return entityAsMap;
	}

	static DocumentShareOptions fromJSON(Map<String, dynamic> data) {
		return DocumentShareOptions(
			requestedPermissions: RequestedPermission.fromJSON(data["requestedPermissions"]),
			shareEncryptionKey: ShareMetadataBehaviour.fromJSON(data["shareEncryptionKey"]),
			shareMessageId: ShareMetadataBehaviour.fromJSON(data["shareMessageId"]),
			shareSecretIds: SecretIdShareOptions.fromJSON(data["shareSecretIds"])
		);
	}
}