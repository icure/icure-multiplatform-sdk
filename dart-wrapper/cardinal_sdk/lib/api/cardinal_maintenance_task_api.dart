// auto-generated file
import 'package:cardinal_sdk/cardinal_sdk.dart';
import 'package:cardinal_sdk/model/sdk/key_pair_update_notification.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/crypto/entities/cardinal_keys.dart';
import 'package:cardinal_sdk/model/data_owner_type.dart';


class CardinalMaintenanceTaskApi {
	final String _sdkId;
	final CardinalSdk _dartSdk;
	CardinalMaintenanceTaskApi(
		this._sdkId,
		this._dartSdk
		);

	Future<void> applyKeyPairUpdate(KeyPairUpdateNotification updateRequest) async {
		return await CardinalSdkPlatformInterface.instance.apis.cardinalMaintenanceTask.applyKeyPairUpdate(
			_sdkId,
			updateRequest,
		);
	}

	Future<void> createKeyPairUpdateNotificationsToAllDelegationCounterparts(CardinalRsaPublicKey key, { Set<DataOwnerType>? requestToOwnerTypes }) async {
		return await CardinalSdkPlatformInterface.instance.apis.cardinalMaintenanceTask.createKeyPairUpdateNotificationsToAllDelegationCounterparts(
			_sdkId,
			key,
			requestToOwnerTypes,
		);
	}

	Future<void> createKeyPairUpdateNotificationTo(String dataOwnerId, CardinalRsaPublicKey key) async {
		return await CardinalSdkPlatformInterface.instance.apis.cardinalMaintenanceTask.createKeyPairUpdateNotificationTo(
			_sdkId,
			dataOwnerId,
			key,
		);
	}
}