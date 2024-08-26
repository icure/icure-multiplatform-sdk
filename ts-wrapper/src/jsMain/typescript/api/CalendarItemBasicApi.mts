// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../icure-sdk-ts.mjs';
import {CalendarItem, EncryptedCalendarItem} from '../model/CalendarItem.mjs';
import {PaginatedList} from '../model/PaginatedList.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';


export interface CalendarItemBasicApi {

	matchCalendarItemsBy(filter: BaseFilterOptions<CalendarItem>): Promise<Array<string>>;

	matchCalendarItemsBySorted(filter: BaseSortableFilterOptions<CalendarItem>): Promise<Array<string>>;

	filterCalendarItemsBy(filter: BaseFilterOptions<CalendarItem>): Promise<PaginatedListIterator<EncryptedCalendarItem>>;

	filterCalendarItemsBySorted(filter: BaseSortableFilterOptions<CalendarItem>): Promise<PaginatedListIterator<EncryptedCalendarItem>>;

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
