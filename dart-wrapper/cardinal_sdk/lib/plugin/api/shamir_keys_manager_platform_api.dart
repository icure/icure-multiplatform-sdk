// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/base/crypto_actor.dart';
import 'package:cardinal_sdk/crypto/cardinal_keys.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'package:cardinal_sdk/crypto/entities/shamir_update_request.dart';
import 'package:cardinal_sdk/model/crypto_actor_stub_with_type.dart';


class ShamirKeysManagerPlatformApi {
	MethodChannel _methodChannel;
	ShamirKeysManagerPlatformApi(this._methodChannel);

	Future<Map<CardinalRsaPublicKeyFingerprint, Set<String>>> getExistingSplitsInfo(String sdkId, CryptoActor dataOwner) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ShamirKeysManagerApi.getExistingSplitsInfo',
			{
				"sdkId": sdkId,
				"dataOwner": jsonEncode(CryptoActor.encode(dataOwner)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getExistingSplitsInfo");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as Map<String, dynamic>).map((k1, v1) => MapEntry(CardinalRsaPublicKeyFingerprint(k1), (v1 as List<dynamic>).map((x2) => (x2 as String) ).toSet()));
	}

	Future<CryptoActorStubWithType> updateSelfSplits(String sdkId, Map<CardinalRsaPublicKeyFingerprint, ShamirUpdateRequest> keySplitsToUpdate, Set<CardinalRsaPublicKeyFingerprint> keySplitsToDelete) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ShamirKeysManagerApi.updateSelfSplits',
			{
				"sdkId": sdkId,
				"keySplitsToUpdate": jsonEncode(keySplitsToUpdate.map((k0, v0) => MapEntry(k0.toString(), ShamirUpdateRequest.encode(v0)))),
				"keySplitsToDelete": jsonEncode(keySplitsToDelete.map((x0) => x0.toString()).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method updateSelfSplits");
		final parsedResJson = jsonDecode(res);
		return CryptoActorStubWithType.fromJSON(parsedResJson);
	}
}