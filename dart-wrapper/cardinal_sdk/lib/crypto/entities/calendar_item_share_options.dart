// auto-generated file
import 'package:cardinal_sdk/model/requests/requested_permission.dart';
import 'package:cardinal_sdk/crypto/entities/share_metadata_behaviour.dart';
import 'package:cardinal_sdk/crypto/entities/secret_id_share_options.dart';
import 'package:freezed_annotation/freezed_annotation.dart';
part "calendar_item_share_options.freezed.dart";


@freezed
abstract class CalendarItemShareOptions with _$CalendarItemShareOptions {
	const factory CalendarItemShareOptions({
		@Default(RequestedPermission.maxWrite) RequestedPermission requestedPermissions,
		@Default(ShareMetadataBehaviour.ifAvailable) ShareMetadataBehaviour shareEncryptionKey,
		@Default(ShareMetadataBehaviour.ifAvailable) ShareMetadataBehaviour sharePatientId,
		@Default(SecretIdShareOptionsAllAvailable()) SecretIdShareOptions shareSecretIds,
	}) = _CalendarItemShareOptions;


	static Map<String, dynamic> encode(CalendarItemShareOptions value) {
		Map<String, dynamic> entityAsMap = {
			"requestedPermissions" : RequestedPermission.encode(value.requestedPermissions),
			"shareEncryptionKey" : ShareMetadataBehaviour.encode(value.shareEncryptionKey),
			"sharePatientId" : ShareMetadataBehaviour.encode(value.sharePatientId),
			"shareSecretIds" : SecretIdShareOptions.encode(value.shareSecretIds)
		};
		return entityAsMap;
	}

	static CalendarItemShareOptions fromJSON(Map<String, dynamic> data) {
		return CalendarItemShareOptions(
			requestedPermissions: RequestedPermission.fromJSON(data["requestedPermissions"]),
			shareEncryptionKey: ShareMetadataBehaviour.fromJSON(data["shareEncryptionKey"]),
			sharePatientId: ShareMetadataBehaviour.fromJSON(data["sharePatientId"]),
			shareSecretIds: SecretIdShareOptions.fromJSON(data["shareSecretIds"])
		);
	}
}