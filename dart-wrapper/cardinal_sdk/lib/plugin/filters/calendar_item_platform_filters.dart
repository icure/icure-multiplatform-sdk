// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'package:cardinal_sdk/model/calendar_item.dart';


class CalendarItemPlatformFilters {
	MethodChannel _methodChannel;
	CalendarItemPlatformFilters(this._methodChannel);

	Future<SortableFilterOptions<CalendarItem>> byPatientsStartTimeForDataOwner(String dataOwnerId, List<Patient> patients, { int? from, int? to, bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemFilters.byPatientsStartTimeForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"patients": jsonEncode(patients.map((x0) => Patient.encode(x0)).toList()),
				"from": jsonEncode(from),
				"to": jsonEncode(to),
				"descending": jsonEncode(descending),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byPatientsStartTimeForDataOwner");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<CalendarItem>> byPatientsStartTimeForSelf(List<Patient> patients, { int? from, int? to, bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemFilters.byPatientsStartTimeForSelf',
			{
				"patients": jsonEncode(patients.map((x0) => Patient.encode(x0)).toList()),
				"from": jsonEncode(from),
				"to": jsonEncode(to),
				"descending": jsonEncode(descending),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byPatientsStartTimeForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<CalendarItem>> byPatientSecretIdsStartTimeForDataOwner(String dataOwnerId, List<String> secretIds, { int? from, int? to, bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemFilters.byPatientSecretIdsStartTimeForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"secretIds": jsonEncode(secretIds.map((x0) => x0).toList()),
				"from": jsonEncode(from),
				"to": jsonEncode(to),
				"descending": jsonEncode(descending),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byPatientSecretIdsStartTimeForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<SortableFilterOptions<CalendarItem>> byPatientSecretIdsStartTimeForSelf(List<String> secretIds, { int? from, int? to, bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemFilters.byPatientSecretIdsStartTimeForSelf',
			{
				"secretIds": jsonEncode(secretIds.map((x0) => x0).toList()),
				"from": jsonEncode(from),
				"to": jsonEncode(to),
				"descending": jsonEncode(descending),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byPatientSecretIdsStartTimeForSelf");
		final parsedResJson = jsonDecode(res);
		return SortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<CalendarItem>> byPeriodAndAgenda(String agendaId, int from, int to, { bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemFilters.byPeriodAndAgenda',
			{
				"agendaId": jsonEncode(agendaId),
				"from": jsonEncode(from),
				"to": jsonEncode(to),
				"descending": jsonEncode(descending),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byPeriodAndAgenda");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseFilterOptions<CalendarItem>> byPeriodForDataOwner(String dataOwnerId, int from, int to) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemFilters.byPeriodForDataOwner',
			{
				"dataOwnerId": jsonEncode(dataOwnerId),
				"from": jsonEncode(from),
				"to": jsonEncode(to),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byPeriodForDataOwner");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<FilterOptions<CalendarItem>> byPeriodForSelf(int from, int to) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemFilters.byPeriodForSelf',
			{
				"from": jsonEncode(from),
				"to": jsonEncode(to),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byPeriodForSelf");
		final parsedResJson = jsonDecode(res);
		return FilterOptions.fromJSON(parsedResJson);
	}

	Future<FilterOptions<CalendarItem>> byRecurrenceId(String recurrenceId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemFilters.byRecurrenceId',
			{
				"recurrenceId": jsonEncode(recurrenceId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byRecurrenceId");
		final parsedResJson = jsonDecode(res);
		return FilterOptions.fromJSON(parsedResJson);
	}
}