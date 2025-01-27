// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/sdk/key_pair_update_notification.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'package:cardinal_sdk/crypto/entities/cardinal_keys.dart';
import 'package:cardinal_sdk/model/data_owner_type.dart';


class CardinalMaintenanceTaskPlatformApi {
	MethodChannel _methodChannel;
	CardinalMaintenanceTaskPlatformApi(this._methodChannel);

	Future<void> applyKeyPairUpdate(String sdkId, KeyPairUpdateNotification updateRequest) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CardinalMaintenanceTaskApi.applyKeyPairUpdate',
			{
				"sdkId": sdkId,
				"updateRequest": jsonEncode(KeyPairUpdateNotification.encode(updateRequest)),
			}
		).catchError(convertPlatformException);
	}

	Future<void> createKeyPairUpdateNotificationsToAllDelegationCounterparts(String sdkId, CardinalRsaPublicKey key, Set<DataOwnerType>? requestToOwnerTypes) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CardinalMaintenanceTaskApi.createKeyPairUpdateNotificationsToAllDelegationCounterparts',
			{
				"sdkId": sdkId,
				"key": jsonEncode(key.spkiHex),
				"requestToOwnerTypes": jsonEncode(requestToOwnerTypes?.map((x0) => DataOwnerType.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
	}

	Future<void> createKeyPairUpdateNotificationTo(String sdkId, String dataOwnerId, CardinalRsaPublicKey key) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CardinalMaintenanceTaskApi.createKeyPairUpdateNotificationTo',
			{
				"sdkId": sdkId,
				"dataOwnerId": jsonEncode(dataOwnerId),
				"key": jsonEncode(key.spkiHex),
			}
		).catchError(convertPlatformException);
	}
}