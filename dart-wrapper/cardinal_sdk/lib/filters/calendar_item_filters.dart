import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/calendar_item.dart';


abstract class CalendarItemFilters {
	CalendarItemFilters();

	static Future<SortableFilterOptions<CalendarItem>> byPatientsStartTimeForDataOwner(String dataOwnerId, List<Patient> patients, int? from, int? to, { bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.calendarItem.byPatientsStartTimeForDataOwner(
			dataOwnerId,
			patients,
			from,
			to,
			descending: descending,
		);
	}

	static Future<SortableFilterOptions<CalendarItem>> byPatientsStartTimeForSelf(List<Patient> patients, int? from, int? to, { bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.calendarItem.byPatientsStartTimeForSelf(
			patients,
			from,
			to,
			descending: descending,
		);
	}

	static Future<BaseSortableFilterOptions<CalendarItem>> byPatientSecretIdsStartTimeForDataOwner(String dataOwnerId, List<String> secretIds, int? from, int? to, { bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.calendarItem.byPatientSecretIdsStartTimeForDataOwner(
			dataOwnerId,
			secretIds,
			from,
			to,
			descending: descending,
		);
	}

	static Future<SortableFilterOptions<CalendarItem>> byPatientSecretIdsStartTimeForSelf(List<String> secretIds, int? from, int? to, { bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.calendarItem.byPatientSecretIdsStartTimeForSelf(
			secretIds,
			from,
			to,
			descending: descending,
		);
	}

	static Future<BaseSortableFilterOptions<CalendarItem>> byPeriodAndAgenda(String agendaId, int from, int to, { bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.calendarItem.byPeriodAndAgenda(
			agendaId,
			from,
			to,
			descending: descending,
		);
	}

	static Future<BaseFilterOptions<CalendarItem>> byPeriodForDataOwner(String dataOwnerId, int from, int to) async {
		return CardinalSdkPlatformInterface.instance.filters.calendarItem.byPeriodForDataOwner(
			dataOwnerId,
			from,
			to,
		);
	}

	static Future<FilterOptions<CalendarItem>> byPeriodForSelf(int from, int to) async {
		return CardinalSdkPlatformInterface.instance.filters.calendarItem.byPeriodForSelf(
			from,
			to,
		);
	}

	static Future<FilterOptions<CalendarItem>> byRecurrenceId(String recurrenceId) async {
		return CardinalSdkPlatformInterface.instance.filters.calendarItem.byRecurrenceId(
			recurrenceId,
		);
	}
}