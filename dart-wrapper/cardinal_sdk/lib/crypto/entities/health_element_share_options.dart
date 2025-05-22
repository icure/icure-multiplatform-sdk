// auto-generated file
import 'package:cardinal_sdk/model/requests/requested_permission.dart';
import 'package:cardinal_sdk/crypto/entities/share_metadata_behaviour.dart';
import 'package:cardinal_sdk/crypto/entities/secret_id_share_options.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "health_element_share_options.freezed.dart";


@freezed
abstract class HealthElementShareOptions with _$HealthElementShareOptions {
	const factory HealthElementShareOptions({
		@Default(RequestedPermission.maxWrite) RequestedPermission requestedPermissions,
		@Default(ShareMetadataBehaviour.ifAvailable) ShareMetadataBehaviour shareEncryptionKey,
		@Default(ShareMetadataBehaviour.ifAvailable) ShareMetadataBehaviour sharePatientId,
		@Default(SecretIdShareOptionsAllAvailable()) SecretIdShareOptions shareSecretIds,
	}) = _HealthElementShareOptions;


	static Map<String, dynamic> encode(HealthElementShareOptions value) {
		Map<String, dynamic> entityAsMap = {
			"requestedPermissions" : RequestedPermission.encode(value.requestedPermissions),
			"shareEncryptionKey" : ShareMetadataBehaviour.encode(value.shareEncryptionKey),
			"sharePatientId" : ShareMetadataBehaviour.encode(value.sharePatientId),
			"shareSecretIds" : SecretIdShareOptions.encode(value.shareSecretIds)
		};
		return entityAsMap;
	}

	static HealthElementShareOptions fromJSON(Map<String, dynamic> data) {
		return HealthElementShareOptions(
			requestedPermissions: RequestedPermission.fromJSON(data["requestedPermissions"]),
			shareEncryptionKey: ShareMetadataBehaviour.fromJSON(data["shareEncryptionKey"]),
			sharePatientId: ShareMetadataBehaviour.fromJSON(data["sharePatientId"]),
			shareSecretIds: SecretIdShareOptions.fromJSON(data["shareSecretIds"])
		);
	}
}