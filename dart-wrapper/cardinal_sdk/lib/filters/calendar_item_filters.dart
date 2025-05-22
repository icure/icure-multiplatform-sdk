// auto-generated file
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/calendar_item.dart';
import 'package:cardinal_sdk/model/entity_reference_in_group.dart';
import 'package:cardinal_sdk/model/group_scoped.dart';


abstract class CalendarItemFilters {
	CalendarItemFilters();

	static Future<SortableFilterOptions<CalendarItem>> byPatientsStartTimeForDataOwner(String dataOwnerId, List<Patient> patients, { int? from, int? to, bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.calendarItem.byPatientsStartTimeForDataOwner(
			dataOwnerId,
			patients,
			from: from,
			to: to,
			descending: descending,
		);
	}

	static Future<SortableFilterOptions<CalendarItem>> byPatientsStartTimeForDataOwnerInGroup(EntityReferenceInGroup dataOwner, List<GroupScoped<Patient>> patients, { int? from, int? to, bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.calendarItem.byPatientsStartTimeForDataOwnerInGroup(
			dataOwner,
			patients,
			from: from,
			to: to,
			descending: descending,
		);
	}

	static Future<SortableFilterOptions<CalendarItem>> byPatientsStartTimeForSelf(List<Patient> patients, { int? from, int? to, bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.calendarItem.byPatientsStartTimeForSelf(
			patients,
			from: from,
			to: to,
			descending: descending,
		);
	}

	static Future<BaseSortableFilterOptions<CalendarItem>> byPatientSecretIdsStartTimeForDataOwner(String dataOwnerId, List<String> secretIds, { int? from, int? to, bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.calendarItem.byPatientSecretIdsStartTimeForDataOwner(
			dataOwnerId,
			secretIds,
			from: from,
			to: to,
			descending: descending,
		);
	}

	static Future<BaseSortableFilterOptions<CalendarItem>> byPatientSecretIdsStartTimeForDataOwnerInGroup(EntityReferenceInGroup dataOwner, List<String> secretIds, { int? from, int? to, bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.calendarItem.byPatientSecretIdsStartTimeForDataOwnerInGroup(
			dataOwner,
			secretIds,
			from: from,
			to: to,
			descending: descending,
		);
	}

	static Future<SortableFilterOptions<CalendarItem>> byPatientSecretIdsStartTimeForSelf(List<String> secretIds, { int? from, int? to, bool descending = false }) async {
		return CardinalSdkPlatformInterface.instance.filters.calendarItem.byPatientSecretIdsStartTimeForSelf(
			secretIds,
			from: from,
			to: to,
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

	static Future<BaseFilterOptions<CalendarItem>> byPeriodForDataOwnerInGroup(EntityReferenceInGroup dataOwner, int from, int to) async {
		return CardinalSdkPlatformInterface.instance.filters.calendarItem.byPeriodForDataOwnerInGroup(
			dataOwner,
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

	static Future<BaseFilterOptions<CalendarItem>> lifecycleBetweenForDataOwner(String dataOwnerId, int? startTimestamp, int? endTimestamp, bool descending) async {
		return CardinalSdkPlatformInterface.instance.filters.calendarItem.lifecycleBetweenForDataOwner(
			dataOwnerId,
			startTimestamp,
			endTimestamp,
			descending,
		);
	}

	static Future<BaseFilterOptions<CalendarItem>> lifecycleBetweenForDataOwnerInGroup(EntityReferenceInGroup dataOwner, int? startTimestamp, int? endTimestamp, bool descending) async {
		return CardinalSdkPlatformInterface.instance.filters.calendarItem.lifecycleBetweenForDataOwnerInGroup(
			dataOwner,
			startTimestamp,
			endTimestamp,
			descending,
		);
	}

	static Future<FilterOptions<CalendarItem>> lifecycleBetweenForSelf(int? startTimestamp, int? endTimestamp, bool descending) async {
		return CardinalSdkPlatformInterface.instance.filters.calendarItem.lifecycleBetweenForSelf(
			startTimestamp,
			endTimestamp,
			descending,
		);
	}
}