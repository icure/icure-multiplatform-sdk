// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {IdWithMandatoryRev} from '../model/IdWithMandatoryRev.mjs';
import {TimeTable} from '../model/TimeTable.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';


export interface TimeTableApi {

	deleteTimeTableUnsafe(entityId: string): Promise<DocIdentifier>;

	deleteTimeTablesUnsafe(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	deleteTimeTableById(entityId: string, rev: string): Promise<DocIdentifier>;

	deleteTimeTablesByIds(entityIds: Array<IdWithMandatoryRev>): Promise<Array<DocIdentifier>>;

	purgeTimeTableById(id: string, rev: string): Promise<void>;

	deleteTimeTable(timeTable: TimeTable): Promise<DocIdentifier>;

	deleteTimeTables(timeTables: Array<TimeTable>): Promise<Array<DocIdentifier>>;

	purgeTimeTable(timeTable: TimeTable): Promise<void>;

	undeleteTimeTable(timeTable: TimeTable): Promise<TimeTable>;

	modifyTimeTable(entity: TimeTable): Promise<TimeTable>;

	undeleteTimeTableById(id: string, rev: string): Promise<TimeTable>;

	getTimeTable(entityId: string): Promise<TimeTable>;

	getTimeTables(timeTableIds: Array<string>): Promise<Array<TimeTable>>;

	getTimeTablesByPeriodAndAgendaId(startDate: number, endDate: number,
			agendaId: string): Promise<Array<TimeTable>>;

	getTimeTablesByAgendaId(agendaId: string): Promise<Array<TimeTable>>;

	filterTimeTablesBy(filter: BaseFilterOptions<TimeTable>): Promise<PaginatedListIterator<TimeTable>>;

	filterTimeTablesBySorted(filter: BaseSortableFilterOptions<TimeTable>): Promise<PaginatedListIterator<TimeTable>>;

	createTimeTable(entity: TimeTable): Promise<TimeTable>;

	matchTimeTablesBy(filter: BaseFilterOptions<TimeTable>): Promise<Array<string>>;

	matchTimeTablesBySorted(filter: BaseSortableFilterOptions<TimeTable>): Promise<Array<string>>;

}
