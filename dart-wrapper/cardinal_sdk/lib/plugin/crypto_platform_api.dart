// auto-generated file
import 'package:flutter/services.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/specializations/keypair_fingerprint_v1string.dart';
import 'dart:typed_data';


class CryptoPlatformApi {
	MethodChannel _methodChannel;
	CryptoPlatformApi(this._methodChannel);

	Future<void> forceReload(String sdkId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CryptoApi.forceReload',
			{
				"sdkId": sdkId,
			}
		);
	}

	Future<Map<String, Map<KeypairFingerprintV1String, Uint8List>>> currentDataOwnerKeys(String sdkId, bool filterTrustedKeys) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CryptoApi.currentDataOwnerKeys',
			{
				"sdkId": sdkId,
				"filterTrustedKeys": jsonEncode(filterTrustedKeys),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method currentDataOwnerKeys");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((k1, v1) => MapEntry(k1, v1.map((k2, v2) => MapEntry(k2, base64Decode(v2 as String)))));
	}
}