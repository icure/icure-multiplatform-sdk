// auto-generated file
import {CalendarItemType} from '../model/CalendarItemType.mjs';
import {ListOfIds} from '../model/ListOfIds.mjs';
import {PaginatedList} from '../model/PaginatedList.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';


export interface CalendarItemTypeApi {

	getCalendarItemTypes(startDocumentId: string | undefined,
			limit: number | undefined): Promise<PaginatedList<CalendarItemType>>;

	getCalendarItemTypesIncludingDeleted(startKey: string | undefined,
			startDocumentId: string | undefined,
			limit: number | undefined): Promise<PaginatedList<CalendarItemType>>;

	createCalendarItemType(calendarItemTypeDto: CalendarItemType): Promise<CalendarItemType>;

	deleteCalendarItemTypes(calendarItemTypeIds: ListOfIds): Promise<Array<DocIdentifier>>;

	getCalendarItemType(calendarItemTypeId: string): Promise<CalendarItemType | undefined>;

	modifyCalendarItemType(calendarItemTypeDto: CalendarItemType): Promise<CalendarItemType>;

	listCalendarItemTypesByAgendaId(agendaId: string): Promise<Array<CalendarItemType>>;

}
