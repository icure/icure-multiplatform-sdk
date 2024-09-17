// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {TimeTableShareOptions} from '../crypto/entities/TimeTableShareOptions.mjs';
import {TimeTable} from '../model/TimeTable.mjs';


export interface TimeTableFlavouredApi<E extends TimeTable> {

	shareWith(delegateId: string, timeTable: E,
			options?: { options?: TimeTableShareOptions | undefined }): Promise<E>;

	shareWithMany(timeTable: E, delegates: { [ key: string ]: TimeTableShareOptions }): Promise<E>;

	filterTimeTablesBy(filter: FilterOptions<TimeTable>): Promise<PaginatedListIterator<E>>;

	filterTimeTablesBySorted(filter: SortableFilterOptions<TimeTable>): Promise<PaginatedListIterator<E>>;

	modifyTimeTable(entity: E): Promise<E>;

	getTimeTable(entityId: string): Promise<E>;

	getTimeTables(timeTableIds: Array<string>): Promise<Array<E>>;

	getTimeTablesByPeriodAndAgendaId(startDate: number, endDate: number,
			agendaId: string): Promise<Array<E>>;

	getTimeTablesByAgendaId(agendaId: string): Promise<Array<E>>;

}
