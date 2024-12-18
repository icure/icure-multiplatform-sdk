import 'dart:convert';

import 'package:cardinal_sdk/crypto/entities/cardinal_keys.dart';
import 'package:cardinal_sdk/crypto/entities/recovery_data_key.dart';
import 'package:cardinal_sdk/crypto/entities/recovery_result.dart';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'package:flutter/services.dart';

abstract class CardinalSdkPlatformCryptoPlugin {
	Future<RecoveryResult<Map<String, Map<CardinalRsaPublicKey, CardinalRsaPrivateKey>>>> recoverWithRecoveryKey(
		String referenceId,
		RecoveryDataKey recoveryKey,
		bool autoDelete
	);

	Future<RecoveryResult<Map<String, Map<CardinalRsaPublicKey, CardinalRsaPrivateKey>>>> waitForRecoveryKey(
		String referenceId,
		RecoveryDataKey recoveryKey,
		bool autoDelete,
		int waitSeconds,
		int cancellationToken
	);
}

class CardinalSdkMethodChannelCrypto extends CardinalSdkPlatformCryptoPlugin {
	final MethodChannel _methodChannel = const MethodChannel("com.icure.cardinal.sdk/crypto");

	@override
	Future<RecoveryResult<Map<String, Map<CardinalRsaPublicKey, CardinalRsaPrivateKey>>>> recoverWithRecoveryKey(
		String referenceId,
		RecoveryDataKey recoveryKey,
		bool autoDelete
	) async {
		final res = await _methodChannel.invokeMethod<String>(
				'KeyPairRecoverer.recoverWithRecoveryKey',
				{
					"referenceId": referenceId,
					"recoveryKey": jsonEncode(RecoveryDataKey.encode(recoveryKey)),
					"autoDelete": jsonEncode(autoDelete),
				}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method recoverKeyPairs");
		final parsedResJson = jsonDecode(res);
		return RecoveryResult.fromJSON(
			parsedResJson,
			(x1) {
				return (x1 as Map<String, dynamic>).map((k2, v2) => MapEntry(
					(k2 as String),
					(v2 as Map<String, dynamic>).map((k3, v3) => MapEntry(
						CardinalRsaPublicKey.fromSpkiHex(k3),
						CardinalRsaPrivateKey.fromPkcs8Base64(v3)
					))
				));
			},
		);
	}

	@override
	Future<RecoveryResult<Map<String, Map<CardinalRsaPublicKey, CardinalRsaPrivateKey>>>> waitForRecoveryKey(
		String referenceId,
		RecoveryDataKey recoveryKey,
		bool autoDelete,
		int waitSeconds,
		int cancellationToken
	) async {
		final res = await _methodChannel.invokeMethod<String>(
				'KeyPairRecoverer.waitForRecoveryKey',
				{
					"cancellationToken": cancellationToken.toString(),
					"referenceId": referenceId,
					"recoveryKey": jsonEncode(RecoveryDataKey.encode(recoveryKey)),
					"autoDelete": jsonEncode(autoDelete),
					"waitSeconds": jsonEncode(waitSeconds),
				}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method recoverKeyPairsWaitingForCreation");
		final parsedResJson = jsonDecode(res);
		return RecoveryResult.fromJSON(
			parsedResJson,
			(x1) {
				return (x1 as Map<String, dynamic>).map((k2, v2) => MapEntry(
					(k2 as String),
					(v2 as Map<String, dynamic>).map((k3, v3) => MapEntry(
						CardinalRsaPublicKey.fromSpkiHex(k3),
						CardinalRsaPrivateKey.fromPkcs8Base64(v3)
					))
				));
			},
		);
	}
}