// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'package:cardinal_sdk/model/time_table.dart';


class TimeTablePlatformFilters {
	MethodChannel _methodChannel;
	TimeTablePlatformFilters(this._methodChannel);

	Future<BaseFilterOptions<TimeTable>> byAgendaId(String agendaId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableFilters.byAgendaId',
			{
				"agendaId": jsonEncode(agendaId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byAgendaId");
		final parsedResJson = jsonDecode(res);
		return BaseFilterOptions.fromJSON(parsedResJson);
	}

	Future<BaseSortableFilterOptions<TimeTable>> byPeriodAndAgendaId(String agendaId, { int? from, int? to, bool descending = false }) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TimeTableFilters.byPeriodAndAgendaId',
			{
				"agendaId": jsonEncode(agendaId),
				"from": jsonEncode(from),
				"to": jsonEncode(to),
				"descending": jsonEncode(descending),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method byPeriodAndAgendaId");
		final parsedResJson = jsonDecode(res);
		return BaseSortableFilterOptions.fromJSON(parsedResJson);
	}
}