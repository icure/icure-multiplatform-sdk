// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/access_log.dart';


class AccessLogPlatformFilters {
	MethodChannel _methodChannel;
	AccessLogPlatformFilters(this._methodChannel);

	Future<SortableFilterOptions<AccessLog>> byPatientsDateForDataOwner(String dataOwnerId, List<Patient> patients, DateTime? from, DateTime? to, { bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogFilters.byPatientsDateForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"patients": jsonEncode(patients.map((x0) => Patient.encode(x0)).toList()),
				"from": jsonEncode(from?.toIso8601String()),
				"to": jsonEncode(to?.toIso8601String()),
				"descending": jsonEncode(descending),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byPatientsDateForDataOwner");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<AccessLog>> byPatientsDateForSelf(List<Patient> patients, DateTime? from, DateTime? to, { bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogFilters.byPatientsDateForSelf',
			{
				"patients": jsonEncode(patients.map((x0) => Patient.encode(x0)).toList()),
				"from": jsonEncode(from?.toIso8601String()),
				"to": jsonEncode(to?.toIso8601String()),
				"descending": jsonEncode(descending),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byPatientsDateForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<AccessLog>> byPatientSecretIdsDateForDataOwner(String dataOwnerId, List<String> secretIds, DateTime? from, DateTime? to, { bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogFilters.byPatientSecretIdsDateForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"secretIds": jsonEncode(secretIds.map((x0) => x0).toList()),
				"from": jsonEncode(from?.toIso8601String()),
				"to": jsonEncode(to?.toIso8601String()),
				"descending": jsonEncode(descending),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byPatientSecretIdsDateForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<AccessLog>> byPatientSecretIdsDateForSelf(List<String> secretIds, DateTime? from, DateTime? to, { bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogFilters.byPatientSecretIdsDateForSelf',
			{
				"secretIds": jsonEncode(secretIds.map((x0) => x0).toList()),
				"from": jsonEncode(from?.toIso8601String()),
				"to": jsonEncode(to?.toIso8601String()),
				"descending": jsonEncode(descending),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byPatientSecretIdsDateForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<AccessLog>> byDate(DateTime? from, DateTime? to, { bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogFilters.byDate',
			{
				"from": jsonEncode(from?.toIso8601String()),
				"to": jsonEncode(to?.toIso8601String()),
				"descending": jsonEncode(descending),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byDate");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<AccessLog>> byUserTypeDate(String userId, String? accessType, DateTime? from, { bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'AccessLogFilters.byUserTypeDate',
			{
				"userId": jsonEncode(userId),
				"accessType": jsonEncode(accessType),
				"from": jsonEncode(from?.toIso8601String()),
				"descending": jsonEncode(descending),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method byUserTypeDate");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}
}