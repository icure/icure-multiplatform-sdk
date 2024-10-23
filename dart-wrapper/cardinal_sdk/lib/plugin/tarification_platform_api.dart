// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/tarification.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/paginated_list.dart';


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
				"tarificationIds": jsonEncode(tarificationIds.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getTarifications");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => Tarification.fromJSON(x1) );
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

	Future<PaginatedList<Tarification>> findTarificationsByLabel(String sdkId, String? region, String? types, String? language, String? label, String? startKey, String? startDocumentId, int? limit) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TarificationApi.findTarificationsByLabel',
			{
				"sdkId": sdkId,
				"region": jsonEncode(region),
				"types": jsonEncode(types),
				"language": jsonEncode(language),
				"label": jsonEncode(label),
				"startKey": jsonEncode(startKey),
				"startDocumentId": jsonEncode(startDocumentId),
				"limit": jsonEncode(limit),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method findTarificationsByLabel");
		final parsedResJson = jsonDecode(res);
		return PaginatedList.fromJSON(parsedResJson);
	}

	Future<PaginatedList<Tarification>> findTarificationsBy(String sdkId, String? region, String? type, String? tarification, String? version, String? startDocumentId, String? startKey, int? limit) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TarificationApi.findTarificationsBy',
			{
				"sdkId": sdkId,
				"region": jsonEncode(region),
				"type": jsonEncode(type),
				"tarification": jsonEncode(tarification),
				"version": jsonEncode(version),
				"startDocumentId": jsonEncode(startDocumentId),
				"startKey": jsonEncode(startKey),
				"limit": jsonEncode(limit),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method findTarificationsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedList.fromJSON(parsedResJson);
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