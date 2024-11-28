// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'package:cardinal_sdk/model/form.dart';
import 'package:cardinal_sdk/model/patient.dart';


class FormPlatformFilters {
	MethodChannel _methodChannel;
	FormPlatformFilters(this._methodChannel);

	Future<BaseFilterOptions<Form>> byParentIdForDataOwner(String dataOwnerId, String parentId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormFilters.byParentIdForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"parentId": jsonEncode(parentId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byParentIdForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<FilterOptions<Form>> byParentIdForSelf(String parentId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormFilters.byParentIdForSelf',
			{
				"parentId": jsonEncode(parentId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byParentIdForSelf");
		final parsedResJson = jsonDecode(res);
		return FilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Form>> byPatientsOpeningDateForDataOwner(String dataOwnerId, List<Patient> patients, { int? from, int? to, bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormFilters.byPatientsOpeningDateForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"patients": jsonEncode(patients.map((x0) => Patient.encode(x0)).toList()),
				"from": jsonEncode(from),
				"to": jsonEncode(to),
				"descending": jsonEncode(descending),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byPatientsOpeningDateForDataOwner");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Form>> byPatientsOpeningDateForSelf(List<Patient> patients, { int? from, int? to, bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormFilters.byPatientsOpeningDateForSelf',
			{
				"patients": jsonEncode(patients.map((x0) => Patient.encode(x0)).toList()),
				"from": jsonEncode(from),
				"to": jsonEncode(to),
				"descending": jsonEncode(descending),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byPatientsOpeningDateForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<Form>> byPatientSecretIdsOpeningDateForDataOwner(String dataOwnerId, List<String> secretIds, { int? from, int? to, bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormFilters.byPatientSecretIdsOpeningDateForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"secretIds": jsonEncode(secretIds.map((x0) => x0).toList()),
				"from": jsonEncode(from),
				"to": jsonEncode(to),
				"descending": jsonEncode(descending),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byPatientSecretIdsOpeningDateForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<Form>> byPatientSecretIdsOpeningDateForSelf(List<String> secretIds, { int? from, int? to, bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormFilters.byPatientSecretIdsOpeningDateForSelf',
			{
				"secretIds": jsonEncode(secretIds.map((x0) => x0).toList()),
				"from": jsonEncode(from),
				"to": jsonEncode(to),
				"descending": jsonEncode(descending),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byPatientSecretIdsOpeningDateForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<Form>> byLogicalUuid(String logicalUuid, { bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormFilters.byLogicalUuid',
			{
				"logicalUuid": jsonEncode(logicalUuid),
				"descending": jsonEncode(descending),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byLogicalUuid");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<Form>> byUniqueId(String uniqueId, { bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'FormFilters.byUniqueId',
			{
				"uniqueId": jsonEncode(uniqueId),
				"descending": jsonEncode(descending),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byUniqueId");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}
}