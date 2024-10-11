// auto-generated file
import {BaseFilterOptions, InternalAgendaFiltersObj} from '../cardinal-sdk-ts.mjs';
import {Agenda} from '../model/Agenda.mjs';


interface AgendaFiltersFactory {

	all(): BaseFilterOptions<Agenda>;

	byUser(userId: string): BaseFilterOptions<Agenda>;

	readableByUser(userId: string): BaseFilterOptions<Agenda>;

}

export const AgendaFilters: AgendaFiltersFactory = {
			all: () => InternalAgendaFiltersObj.getInstance().all(),
			byUser: (userId) => InternalAgendaFiltersObj.getInstance().byUser(userId),
			readableByUser: (userId) => InternalAgendaFiltersObj.getInstance().readableByUser(userId)
		};
