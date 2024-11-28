// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/place.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';


class PlacePlatformApi {
	MethodChannel _methodChannel;
	PlacePlatformApi(this._methodChannel);

	Future<Place> getPlace(String sdkId, String placeId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PlaceApi.getPlace',
			{
				"sdkId": sdkId,
				"placeId": jsonEncode(placeId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getPlace");
		final parsedResJson = jsonDecode(res);
		return Place.fromJSON(parsedResJson);
	}

	Future<Place> createPlace(String sdkId, Place place) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PlaceApi.createPlace',
			{
				"sdkId": sdkId,
				"place": jsonEncode(Place.encode(place)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createPlace");
		final parsedResJson = jsonDecode(res);
		return Place.fromJSON(parsedResJson);
	}

	Future<Place> modifyPlace(String sdkId, Place place) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PlaceApi.modifyPlace',
			{
				"sdkId": sdkId,
				"place": jsonEncode(Place.encode(place)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyPlace");
		final parsedResJson = jsonDecode(res);
		return Place.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deletePlaces(String sdkId, List<String> placeIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PlaceApi.deletePlaces',
			{
				"sdkId": sdkId,
				"placeIds": jsonEncode(placeIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deletePlaces");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}
}