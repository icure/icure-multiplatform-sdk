// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {IdWithMandatoryRev} from '../model/IdWithMandatoryRev.mjs';
import {EncryptedTimeTable, TimeTable} from '../model/TimeTable.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';


export interface TimeTableBasicApi {

	matchTimeTablesBy(filter: BaseFilterOptions<TimeTable>): Promise<Array<string>>;

	matchTimeTablesBySorted(filter: BaseSortableFilterOptions<TimeTable>): Promise<Array<string>>;

	filterTimeTablesBy(filter: BaseFilterOptions<TimeTable>): Promise<PaginatedListIterator<EncryptedTimeTable>>;

	filterTimeTablesBySorted(filter: BaseSortableFilterOptions<TimeTable>): Promise<PaginatedListIterator<EncryptedTimeTable>>;

	deleteTimeTableUnsafe(entityId: string): Promise<DocIdentifier>;

	deleteTimeTablesUnsafe(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	deleteTimeTableById(entityId: string, rev: string): Promise<DocIdentifier>;

	deleteTimeTablesByIds(entityIds: Array<IdWithMandatoryRev>): Promise<Array<DocIdentifier>>;

	purgeTimeTableById(id: string, rev: string): Promise<void>;

	deleteTimeTable(timeTable: TimeTable): Promise<DocIdentifier>;

	deleteTimeTables(timeTables: Array<TimeTable>): Promise<Array<DocIdentifier>>;

	purgeTimeTable(timeTable: TimeTable): Promise<void>;

	undeleteTimeTable(timeTable: TimeTable): Promise<TimeTable>;

	modifyTimeTable(entity: EncryptedTimeTable): Promise<EncryptedTimeTable>;

	undeleteTimeTableById(id: string, rev: string): Promise<EncryptedTimeTable>;

	getTimeTable(entityId: string): Promise<EncryptedTimeTable>;

	getTimeTables(timeTableIds: Array<string>): Promise<Array<EncryptedTimeTable>>;

	getTimeTablesByPeriodAndAgendaId(startDate: number, endDate: number,
			agendaId: string): Promise<Array<EncryptedTimeTable>>;

	getTimeTablesByAgendaId(agendaId: string): Promise<Array<EncryptedTimeTable>>;

}
