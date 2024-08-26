// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, InternalTimeTableFiltersObj} from '../icure-sdk-ts.mjs';
import {TimeTable} from '../model/TimeTable.mjs';


interface TimeTableFiltersFactory {

	byAgendaId(agendaId: string): BaseFilterOptions<TimeTable>;

	byPeriodAndAgendaId(agendaId: string,
			options?: { from?: number | undefined, to?: number | undefined, descending?: boolean }): BaseSortableFilterOptions<TimeTable>;

}

export const TimeTableFilters: TimeTableFiltersFactory = {
			byAgendaId: (agendaId) => InternalTimeTableFiltersObj.getInstance().byAgendaId(agendaId),
			byPeriodAndAgendaId: (agendaId, options) => InternalTimeTableFiltersObj.getInstance().byPeriodAndAgendaId(agendaId, options)
		};
