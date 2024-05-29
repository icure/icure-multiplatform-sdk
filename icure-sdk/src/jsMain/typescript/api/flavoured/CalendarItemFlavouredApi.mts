// auto-generated file
import {CalendarItemShareOptions} from '../../crypto/entities/CalendarItemShareOptions.mjs';
import {ShareMetadataBehaviour} from '../../crypto/entities/ShareMetadataBehaviour.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {PaginatedListIterator} from '../../icure-sdk.mjs';
import {CalendarItem} from '../../model/CalendarItem.mjs';
import {PaginatedList} from '../../model/PaginatedList.mjs';
import {Patient} from '../../model/Patient.mjs';
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';


export interface CalendarItemFlavouredApi<E extends CalendarItem> {

	shareWith(
			delegateId: string,
			calendarItem: E,
			shareEncryptionKeys: ShareMetadataBehaviour,
			shareOwningEntityIds: ShareMetadataBehaviour,
			requestedPermission: RequestedPermission
	): Promise<SimpleShareResult<E>>;

	tryShareWithMany(calendarItem: E,
			delegates: { [ key: string ]: CalendarItemShareOptions }): Promise<SimpleShareResult<E>>;

	shareWithMany(calendarItem: E,
			delegates: { [ key: string ]: CalendarItemShareOptions }): Promise<E>;

	findCalendarItemsByHcPartyPatient(
			hcPartyId: string,
			patient: Patient,
			startDate: number | undefined,
			endDate: number | undefined,
			descending: boolean | undefined
	): Promise<PaginatedListIterator<E>>;

	linkToPatient(calendarItem: CalendarItem, patient: Patient,
			shareLinkWithDelegates: Array<string>): Promise<E>;

	modifyCalendarItem(entity: E): Promise<E>;

	getCalendarItem(entityId: string): Promise<E>;

	getCalendarItems(entityIds: Array<string>): Promise<Array<E>>;

	getCalendarItemsByPeriodAndHcPartyId(startDate: number, endDate: number,
			hcPartyId: string): Promise<Array<E>>;

	getCalendarsByPeriodAndAgendaId(startDate: number, endDate: number,
			agendaId: string): Promise<Array<E>>;

	getCalendarItemsWithIds(entityIds: Array<string>): Promise<Array<E>>;

	findCalendarItemsByRecurrenceId(recurrenceId: string, startKey: string | undefined,
			startDocumentId: string | undefined, limit: number): Promise<PaginatedList<E>>;

}
