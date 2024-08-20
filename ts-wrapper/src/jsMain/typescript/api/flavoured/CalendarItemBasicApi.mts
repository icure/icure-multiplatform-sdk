// auto-generated file
import {EncryptedCalendarItem} from '../../model/CalendarItem.mjs';
import {PaginatedList} from '../../model/PaginatedList.mjs';
import {DocIdentifier} from '../../model/couchdb/DocIdentifier.mjs';


export interface CalendarItemBasicApi {

	deleteCalendarItem(entityId: string): Promise<DocIdentifier>;

	deleteCalendarItems(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	modifyCalendarItem(entity: EncryptedCalendarItem): Promise<EncryptedCalendarItem>;

	getCalendarItem(entityId: string): Promise<EncryptedCalendarItem>;

	getCalendarItems(entityIds: Array<string>): Promise<Array<EncryptedCalendarItem>>;

	getCalendarItemsByPeriodAndHcPartyId(startDate: number, endDate: number,
			hcPartyId: string): Promise<Array<EncryptedCalendarItem>>;

	getCalendarsByPeriodAndAgendaId(startDate: number, endDate: number,
			agendaId: string): Promise<Array<EncryptedCalendarItem>>;

	findCalendarItemsByRecurrenceId(recurrenceId: string, startKey: string | undefined,
			startDocumentId: string | undefined,
			limit: number): Promise<PaginatedList<EncryptedCalendarItem>>;

}
