// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, FilterOptions, InternalCalendarItemFiltersObj, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {CalendarItem} from '../model/CalendarItem.mjs';
import {Patient} from '../model/Patient.mjs';


interface CalendarItemFiltersFactory {

	byPatientsStartTimeForDataOwner(dataOwnerId: string, patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<CalendarItem>;

	byPatientsStartTimeForSelf(patients: Array<Patient>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<CalendarItem>;

	byPatientSecretIdsStartTimeForDataOwner(dataOwnerId: string, secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<CalendarItem>;

	byPatientSecretIdsStartTimeForSelf(secretIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): SortableFilterOptions<CalendarItem>;

	byPeriodAndAgenda(agendaId: string, from: number, to: number,
			options?: { descending?: boolean }): BaseSortableFilterOptions<CalendarItem>;

	byPeriodForDataOwner(dataOwnerId: string, from: number,
			to: number): BaseFilterOptions<CalendarItem>;

	byPeriodForSelf(from: number, to: number): FilterOptions<CalendarItem>;

	byRecurrenceId(recurrenceId: string): FilterOptions<CalendarItem>;

}

export const CalendarItemFilters: CalendarItemFiltersFactory = {
			byPatientsStartTimeForDataOwner: (dataOwnerId, patients, options) => InternalCalendarItemFiltersObj.getInstance().byPatientsStartTimeForDataOwner(dataOwnerId, patients, options),
			byPatientsStartTimeForSelf: (patients, options) => InternalCalendarItemFiltersObj.getInstance().byPatientsStartTimeForSelf(patients, options),
			byPatientSecretIdsStartTimeForDataOwner: (dataOwnerId, secretIds, options) => InternalCalendarItemFiltersObj.getInstance().byPatientSecretIdsStartTimeForDataOwner(dataOwnerId, secretIds, options),
			byPatientSecretIdsStartTimeForSelf: (secretIds, options) => InternalCalendarItemFiltersObj.getInstance().byPatientSecretIdsStartTimeForSelf(secretIds, options),
			byPeriodAndAgenda: (agendaId, from, to, options) => InternalCalendarItemFiltersObj.getInstance().byPeriodAndAgenda(agendaId, from, to, options),
			byPeriodForDataOwner: (dataOwnerId, from, to) => InternalCalendarItemFiltersObj.getInstance().byPeriodForDataOwner(dataOwnerId, from, to),
			byPeriodForSelf: (from, to) => InternalCalendarItemFiltersObj.getInstance().byPeriodForSelf(from, to),
			byRecurrenceId: (recurrenceId) => InternalCalendarItemFiltersObj.getInstance().byRecurrenceId(recurrenceId)
		};
