// auto-generated file
import 'package:cardinal_sdk/model/sdk/key_pair_update_notification.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/specializations/spki_hex_string.dart';
import 'package:cardinal_sdk/model/data_owner_type.dart';


class CardinalMaintenanceTaskPlatformApi {
	String _sdkId;
	CardinalMaintenanceTaskPlatformApi(this._sdkId);

	Future<void> applyKeyPairUpdate(KeyPairUpdateNotification updateRequest) async {
		return await CardinalSdkPlatformInterface.instance.cardinalMaintenanceTask.applyKeyPairUpdate(
			_sdkId,
			updateRequest,
		);
	}

	Future<void> createKeyPairUpdateNotificationsToAllDelegationCounterparts(SpkiHexString key, Set<DataOwnerType>? requestToOwnerTypes) async {
		return await CardinalSdkPlatformInterface.instance.cardinalMaintenanceTask.createKeyPairUpdateNotificationsToAllDelegationCounterparts(
			_sdkId,
			key,
			requestToOwnerTypes,
		);
	}

	Future<void> createKeyPairUpdateNotificationTo(String dataOwnerId, SpkiHexString key) async {
		return await CardinalSdkPlatformInterface.instance.cardinalMaintenanceTask.createKeyPairUpdateNotificationTo(
			_sdkId,
			dataOwnerId,
			key,
		);
	}
}