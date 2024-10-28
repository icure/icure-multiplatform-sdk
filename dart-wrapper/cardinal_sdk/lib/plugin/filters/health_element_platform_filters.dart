// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/health_element.dart';
import 'package:cardinal_sdk/model/base/identifier.dart';
import 'package:cardinal_sdk/model/patient.dart';


class HealthElementPlatformFilters {
	MethodChannel _methodChannel;
	HealthElementPlatformFilters(this._methodChannel);

	Future<BaseFilterOptions<HealthElement>> allHealthElementsForDataOwner(String dataOwnerId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementFilters.allHealthElementsForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method allHealthElementsForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<FilterOptions<HealthElement>> allHealthElementsForSelf() async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementFilters.allHealthElementsForSelf',
			{
			}
		);
		if (res == null) throw AssertionError("received null result from platform method allHealthElementsForSelf");
		final parsedResJson = jsonDecode(res);
		return FilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<HealthElement>> byIdentifiersForDataOwner(String dataOwnerId, List<Identifier> identifiers) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementFilters.byIdentifiersForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"identifiers": jsonEncode(identifiers.map((x0) => Identifier.encode(x0)).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byIdentifiersForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<HealthElement>> byIdentifiersForSelf(List<Identifier> identifiers) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementFilters.byIdentifiersForSelf',
			{
				"identifiers": jsonEncode(identifiers.map((x0) => Identifier.encode(x0)).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byIdentifiersForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<HealthElement>> byCodeForDataOwner(String dataOwnerId, String codeType, { String? codeCode }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementFilters.byCodeForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"codeType": jsonEncode(codeType),
				"codeCode": jsonEncode(codeCode),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byCodeForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<HealthElement>> byCodeForSelf(String codeType, { String? codeCode }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementFilters.byCodeForSelf',
			{
				"codeType": jsonEncode(codeType),
				"codeCode": jsonEncode(codeCode),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byCodeForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<HealthElement>> byTagForDataOwner(String dataOwnerId, String tagType, { String? tagCode }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementFilters.byTagForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"tagType": jsonEncode(tagType),
				"tagCode": jsonEncode(tagCode),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byTagForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<HealthElement>> byTagForSelf(String tagType, { String? tagCode }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementFilters.byTagForSelf',
			{
				"tagType": jsonEncode(tagType),
				"tagCode": jsonEncode(tagCode),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byTagForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<HealthElement>> byPatientsForDataOwner(String dataOwnerId, List<Patient> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementFilters.byPatientsForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"patients": jsonEncode(patients.map((x0) => Patient.encode(x0)).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byPatientsForDataOwner");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<HealthElement>> byPatientsForSelf(List<Patient> patients) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementFilters.byPatientsForSelf',
			{
				"patients": jsonEncode(patients.map((x0) => Patient.encode(x0)).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byPatientsForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<HealthElement>> byPatientsSecretIdsForDataOwner(String dataOwnerId, List<String> secretIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementFilters.byPatientsSecretIdsForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"secretIds": jsonEncode(secretIds.map((x0) => x0).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byPatientsSecretIdsForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<HealthElement>> byPatientsSecretIdsForSelf(List<String> secretIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementFilters.byPatientsSecretIdsForSelf',
			{
				"secretIds": jsonEncode(secretIds.map((x0) => x0).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byPatientsSecretIdsForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<HealthElement>> byIds(List<String> ids) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementFilters.byIds',
			{
				"ids": jsonEncode(ids.map((x0) => x0).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byIds");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<HealthElement>> byPatientsOpeningDateForDataOwner(String dataOwnerId, List<Patient> patients, { int? from, int? to, bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementFilters.byPatientsOpeningDateForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"patients": jsonEncode(patients.map((x0) => Patient.encode(x0)).toList()),
				"from": jsonEncode(from),
				"to": jsonEncode(to),
				"descending": jsonEncode(descending),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byPatientsOpeningDateForDataOwner");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<HealthElement>> byPatientsOpeningDateForSelf(List<Patient> patients, { int? from, int? to, bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementFilters.byPatientsOpeningDateForSelf',
			{
				"patients": jsonEncode(patients.map((x0) => Patient.encode(x0)).toList()),
				"from": jsonEncode(from),
				"to": jsonEncode(to),
				"descending": jsonEncode(descending),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byPatientsOpeningDateForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<HealthElement>> byPatientSecretIdsOpeningDateForDataOwner(String dataOwnerId, List<String> secretIds, { int? from, int? to, bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementFilters.byPatientSecretIdsOpeningDateForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"secretIds": jsonEncode(secretIds.map((x0) => x0).toList()),
				"from": jsonEncode(from),
				"to": jsonEncode(to),
				"descending": jsonEncode(descending),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byPatientSecretIdsOpeningDateForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<HealthElement>> byPatientSecretIdsOpeningDateForSelf(List<String> secretIds, { int? from, int? to, bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementFilters.byPatientSecretIdsOpeningDateForSelf',
			{
				"secretIds": jsonEncode(secretIds.map((x0) => x0).toList()),
				"from": jsonEncode(from),
				"to": jsonEncode(to),
				"descending": jsonEncode(descending),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byPatientSecretIdsOpeningDateForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<HealthElement>> byStatusForDataOwner(String dataOwnerId, int status) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementFilters.byStatusForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"status": jsonEncode(status),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byStatusForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<FilterOptions<HealthElement>> byStatusForSelf(int status) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementFilters.byStatusForSelf',
			{
				"status": jsonEncode(status),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byStatusForSelf");
		final parsedResJson = jsonDecode(res);
		return FilterOptions.fromJSON(parsedResJson);
	}
}