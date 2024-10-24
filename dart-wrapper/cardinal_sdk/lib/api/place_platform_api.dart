// auto-generated file
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/place.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';


class PlacePlatformApi {
	String _sdkId;
	PlacePlatformApi(this._sdkId);

	Future<Place> getPlace(String placeId) async {
		return await CardinalSdkPlatformInterface.instance.apis.place.getPlace(
			_sdkId,
			placeId,
		);
	}

	Future<Place> createPlace(Place place) async {
		return await CardinalSdkPlatformInterface.instance.apis.place.createPlace(
			_sdkId,
			place,
		);
	}

	Future<Place> modifyPlace(Place place) async {
		return await CardinalSdkPlatformInterface.instance.apis.place.modifyPlace(
			_sdkId,
			place,
		);
	}

	Future<List<DocIdentifier>> deletePlaces(List<String> placeIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.place.deletePlaces(
			_sdkId,
			placeIds,
		);
	}
}