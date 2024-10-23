// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/place.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/paginated_list.dart';


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
		);
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
		);
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
		);
		if (res == null) throw AssertionError("received null result from platform method modifyPlace");
		final parsedResJson = jsonDecode(res);
		return Place.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deletePlaces(String sdkId, List<String> placeIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PlaceApi.deletePlaces',
			{
				"sdkId": sdkId,
				"placeIds": jsonEncode(placeIds.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deletePlaces");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => DocIdentifier.fromJSON(x1) );
	}

	Future<PaginatedList<Place>> getPlaces(String sdkId, String? startDocumentId, int? limit) async {
		final res = await _methodChannel.invokeMethod<String>(
			'PlaceApi.getPlaces',
			{
				"sdkId": sdkId,
				"startDocumentId": jsonEncode(startDocumentId),
				"limit": jsonEncode(limit),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getPlaces");
		final parsedResJson = jsonDecode(res);
		return PaginatedList.fromJSON(parsedResJson);
	}
}