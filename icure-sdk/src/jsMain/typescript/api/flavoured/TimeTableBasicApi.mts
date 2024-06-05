// auto-generated file
import {EncryptedTimeTable} from '../../model/TimeTable.mjs';
import {DocIdentifier} from '../../model/couchdb/DocIdentifier.mjs';


export interface TimeTableBasicApi {

	deleteTimeTable(entityId: string): Promise<DocIdentifier>;

	deleteTimeTables(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	modifyTimeTable(entity: EncryptedTimeTable): Promise<EncryptedTimeTable>;

	getTimeTable(entityId: string): Promise<EncryptedTimeTable>;

	getTimeTablesByPeriodAndAgendaId(startDate: number, endDate: number,
			agendaId: string): Promise<Array<EncryptedTimeTable>>;

	getTimeTablesByAgendaId(agendaId: string): Promise<Array<EncryptedTimeTable>>;

}
