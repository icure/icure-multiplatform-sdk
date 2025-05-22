// auto-generated file
import 'package:cardinal_sdk/model/requests/requested_permission.dart';
import 'package:cardinal_sdk/crypto/entities/share_metadata_behaviour.dart';
import 'package:cardinal_sdk/crypto/entities/secret_id_share_options.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "patient_share_options.freezed.dart";


@freezed
abstract class PatientShareOptions with _$PatientShareOptions {
	const factory PatientShareOptions({
		@Default(RequestedPermission.maxWrite) RequestedPermission requestedPermissions,
		@Default(ShareMetadataBehaviour.ifAvailable) ShareMetadataBehaviour shareEncryptionKey,
		@Default(SecretIdShareOptionsAllAvailable()) SecretIdShareOptions shareSecretIds,
	}) = _PatientShareOptions;


	static Map<String, dynamic> encode(PatientShareOptions value) {
		Map<String, dynamic> entityAsMap = {
			"requestedPermissions" : RequestedPermission.encode(value.requestedPermissions),
			"shareEncryptionKey" : ShareMetadataBehaviour.encode(value.shareEncryptionKey),
			"shareSecretIds" : SecretIdShareOptions.encode(value.shareSecretIds)
		};
		return entityAsMap;
	}

	static PatientShareOptions fromJSON(Map<String, dynamic> data) {
		return PatientShareOptions(
			requestedPermissions: RequestedPermission.fromJSON(data["requestedPermissions"]),
			shareEncryptionKey: ShareMetadataBehaviour.fromJSON(data["shareEncryptionKey"]),
			shareSecretIds: SecretIdShareOptions.fromJSON(data["shareSecretIds"])
		);
	}
}