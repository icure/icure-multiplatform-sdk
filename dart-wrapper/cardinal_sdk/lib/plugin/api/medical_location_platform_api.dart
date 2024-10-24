// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/medical_location.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/list_of_ids.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';


class MedicalLocationPlatformApi {
	MethodChannel _methodChannel;
	MedicalLocationPlatformApi(this._methodChannel);

	Future<MedicalLocation> createMedicalLocation(String sdkId, MedicalLocation medicalLocationDto) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MedicalLocationApi.createMedicalLocation',
			{
				"sdkId": sdkId,
				"medicalLocationDto": jsonEncode(MedicalLocation.encode(medicalLocationDto)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method createMedicalLocation");
		final parsedResJson = jsonDecode(res);
		return MedicalLocation.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteMedicalLocations(String sdkId, ListOfIds locationIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MedicalLocationApi.deleteMedicalLocations',
			{
				"sdkId": sdkId,
				"locationIds": jsonEncode(ListOfIds.encode(locationIds)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteMedicalLocations");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => DocIdentifier.fromJSON(x1) );
	}

	Future<MedicalLocation> getMedicalLocation(String sdkId, String locationId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MedicalLocationApi.getMedicalLocation',
			{
				"sdkId": sdkId,
				"locationId": jsonEncode(locationId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getMedicalLocation");
		final parsedResJson = jsonDecode(res);
		return MedicalLocation.fromJSON(parsedResJson);
	}

	Future<MedicalLocation> modifyMedicalLocation(String sdkId, MedicalLocation medicalLocationDto) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MedicalLocationApi.modifyMedicalLocation',
			{
				"sdkId": sdkId,
				"medicalLocationDto": jsonEncode(MedicalLocation.encode(medicalLocationDto)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyMedicalLocation");
		final parsedResJson = jsonDecode(res);
		return MedicalLocation.fromJSON(parsedResJson);
	}

	Future<List<MedicalLocation>> getMedicalLocations(String sdkId, List<String> medicalLocationIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MedicalLocationApi.getMedicalLocations',
			{
				"sdkId": sdkId,
				"medicalLocationIds": jsonEncode(medicalLocationIds.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getMedicalLocations");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => MedicalLocation.fromJSON(x1) );
	}

	Future<List<String>> matchMedicalLocationsBy(String sdkId, BaseFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MedicalLocationApi.matchMedicalLocationsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchMedicalLocationsBy");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => x1 );
	}

	Future<List<String>> matchMedicalLocationsBySorted(String sdkId, BaseSortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MedicalLocationApi.matchMedicalLocationsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseSortableFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchMedicalLocationsBySorted");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => x1 );
	}

	Future<PaginatedListIterator<MedicalLocation>> filterMedicalLocationsBy(String sdkId, BaseFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MedicalLocationApi.filterMedicalLocationsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterMedicalLocationsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => MedicalLocation.fromJSON(x0));
	}

	Future<PaginatedListIterator<MedicalLocation>> filterMedicalLocationsBySorted(String sdkId, BaseSortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MedicalLocationApi.filterMedicalLocationsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseSortableFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterMedicalLocationsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => MedicalLocation.fromJSON(x0));
	}
}