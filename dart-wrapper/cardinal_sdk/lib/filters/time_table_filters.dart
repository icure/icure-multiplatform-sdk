// auto-generated file
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/time_table.dart';


abstract class TimeTableFilters {
	TimeTableFilters();

	static Future<BaseFilterOptions<TimeTable>> byAgendaId(String agendaId) async {
		return CardinalSdkPlatformInterface.instance.filters.timeTable.byAgendaId(
			agendaId,
		);
	}

	static Future<BaseSortableFilterOptions<TimeTable>> byPeriodAndAgendaId(String agendaId, { int? from, int? to, bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.timeTable.byPeriodAndAgendaId(
			agendaId,
			from: from,
			to: to,
			descending: descending,
		);
	}
}