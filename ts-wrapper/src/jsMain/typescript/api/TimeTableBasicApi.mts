// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../icure-sdk-ts.mjs';
import {EncryptedTimeTable, TimeTable} from '../model/TimeTable.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';


export interface TimeTableBasicApi {

	matchTimeTablesBy(filter: BaseFilterOptions<TimeTable>): Promise<Array<string>>;

	matchTimeTablesBySorted(filter: BaseSortableFilterOptions<TimeTable>): Promise<Array<string>>;

	filterTimeTablesBy(filter: BaseFilterOptions<TimeTable>): Promise<PaginatedListIterator<EncryptedTimeTable>>;

	filterTimeTablesBySorted(filter: BaseSortableFilterOptions<TimeTable>): Promise<PaginatedListIterator<EncryptedTimeTable>>;

	deleteTimeTable(entityId: string): Promise<DocIdentifier>;

	deleteTimeTables(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	modifyTimeTable(entity: EncryptedTimeTable): Promise<EncryptedTimeTable>;

	getTimeTable(entityId: string): Promise<EncryptedTimeTable>;

	getTimeTables(timeTableIds: Array<string>): Promise<Array<EncryptedTimeTable>>;

	getTimeTablesByPeriodAndAgendaId(startDate: number, endDate: number,
			agendaId: string): Promise<Array<EncryptedTimeTable>>;

	getTimeTablesByAgendaId(agendaId: string): Promise<Array<EncryptedTimeTable>>;

}
