// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/base/crypto_actor.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/specializations/keypair_fingerprint_v1string.dart';
import 'package:cardinal_sdk/crypto/entities/shamir_update_request.dart';
import 'package:cardinal_sdk/model/crypto_actor_stub_with_type.dart';


class ShamirKeysManagerPlatformApi {
	MethodChannel _methodChannel;
	ShamirKeysManagerPlatformApi(this._methodChannel);

	Future<Map<KeypairFingerprintV1String, Set<String>>> getExistingSplitsInfo(String sdkId, CryptoActor dataOwner) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ShamirKeysManagerApi.getExistingSplitsInfo',
			{
				"sdkId": sdkId,
				"dataOwner": jsonEncode(CryptoActor.encode(dataOwner)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getExistingSplitsInfo");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((k1, v1) => MapEntry(k1, v1.map((x2) => x2 )));
	}

	Future<CryptoActorStubWithType> updateSelfSplits(String sdkId, Map<KeypairFingerprintV1String, ShamirUpdateRequest> keySplitsToUpdate, Set<KeypairFingerprintV1String> keySplitsToDelete) async {
		final res = await _methodChannel.invokeMethod<String>(
			'ShamirKeysManagerApi.updateSelfSplits',
			{
				"sdkId": sdkId,
				"keySplitsToUpdate": jsonEncode(keySplitsToUpdate.map((k0, v0) => MapEntry(k0, ShamirUpdateRequest.encode(v0)))),
				"keySplitsToDelete": jsonEncode(keySplitsToDelete.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method updateSelfSplits");
		final parsedResJson = jsonDecode(res);
		return CryptoActorStubWithType.fromJSON(parsedResJson);
	}
}