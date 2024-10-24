// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/tarification.dart';
import 'dart:convert';


class TarificationPlatformApi {
	MethodChannel _methodChannel;
	TarificationPlatformApi(this._methodChannel);

	Future<Tarification> getTarification(String sdkId, String tarificationId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TarificationApi.getTarification',
			{
				"sdkId": sdkId,
				"tarificationId": jsonEncode(tarificationId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getTarification");
		final parsedResJson = jsonDecode(res);
		return Tarification.fromJSON(parsedResJson);
	}

	Future<Tarification> createTarification(String sdkId, Tarification tarification) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TarificationApi.createTarification',
			{
				"sdkId": sdkId,
				"tarification": jsonEncode(Tarification.encode(tarification)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method createTarification");
		final parsedResJson = jsonDecode(res);
		return Tarification.fromJSON(parsedResJson);
	}

	Future<List<Tarification>> getTarifications(String sdkId, List<String> tarificationIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TarificationApi.getTarifications',
			{
				"sdkId": sdkId,
				"tarificationIds": jsonEncode(tarificationIds.map((x0) => x0).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getTarifications");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => Tarification.fromJSON(x1) ).toList();
	}

	Future<Tarification> modifyTarification(String sdkId, Tarification tarification) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TarificationApi.modifyTarification',
			{
				"sdkId": sdkId,
				"tarification": jsonEncode(Tarification.encode(tarification)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyTarification");
		final parsedResJson = jsonDecode(res);
		return Tarification.fromJSON(parsedResJson);
	}

	Future<Tarification> getTarificationWithParts(String sdkId, String type, String tarification, String version) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TarificationApi.getTarificationWithParts',
			{
				"sdkId": sdkId,
				"type": jsonEncode(type),
				"tarification": jsonEncode(tarification),
				"version": jsonEncode(version),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getTarificationWithParts");
		final parsedResJson = jsonDecode(res);
		return Tarification.fromJSON(parsedResJson);
	}
}