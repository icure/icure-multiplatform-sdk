// auto-generated file
import {CalendarItemShareOptions} from '../../crypto/entities/CalendarItemShareOptions.mjs';
import {SecretIdOption} from '../../crypto/entities/SecretIdOption.mjs';
import {ShareMetadataBehaviour} from '../../crypto/entities/ShareMetadataBehaviour.mjs';
import {SimpleShareResult} from '../../crypto/entities/SimpleShareResult.mjs';
import {PaginatedListIterator} from '../../icure-sdk.mjs';
import {CalendarItem, DecryptedCalendarItem, EncryptedCalendarItem} from '../../model/CalendarItem.mjs';
import {PaginatedList} from '../../model/PaginatedList.mjs';
import {Patient} from '../../model/Patient.mjs';
import {User} from '../../model/User.mjs';
import {DocIdentifier} from '../../model/couchdb/DocIdentifier.mjs';
import {AccessLevel} from '../../model/embed/AccessLevel.mjs';
import {RequestedPermission} from '../../model/requests/RequestedPermission.mjs';
import {HexString} from '../../model/specializations/HexString.mjs';
import {CalendarItemFlavouredApi} from './CalendarItemFlavouredApi.mjs';


export interface CalendarItemApi {

	encrypted: CalendarItemFlavouredApi<EncryptedCalendarItem>;

	tryAndRecover: CalendarItemFlavouredApi<CalendarItem>;

	createCalendarItem(entity: DecryptedCalendarItem): Promise<DecryptedCalendarItem>;

	withEncryptionMetadata(base: DecryptedCalendarItem | undefined, patient: Patient,
			options?: { base?: DecryptedCalendarItem | undefined, patient?: Patient, user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdOption }): Promise<DecryptedCalendarItem>;

	getEncryptionKeysOf(calendarItem: CalendarItem): Promise<Array<HexString>>;

	hasWriteAccess(calendarItem: CalendarItem): Promise<boolean>;

	decryptPatientIdOf(calendarItem: CalendarItem): Promise<Array<string>>;

	createDelegationDeAnonymizationMetadata(entity: CalendarItem,
			delegates: Array<string>): Promise<void>;

	deleteCalendarItem(entityId: string): Promise<DocIdentifier>;

	deleteCalendarItems(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	shareWith(delegateId: string, calendarItem: DecryptedCalendarItem,
			options?: { delegateId?: string, calendarItem?: DecryptedCalendarItem, shareEncryptionKeys?: ShareMetadataBehaviour, shareOwningEntityIds?: ShareMetadataBehaviour, requestedPermission?: RequestedPermission }): Promise<SimpleShareResult<DecryptedCalendarItem>>;

	tryShareWithMany(calendarItem: DecryptedCalendarItem,
			delegates: { [ key: string ]: CalendarItemShareOptions }): Promise<SimpleShareResult<DecryptedCalendarItem>>;

	shareWithMany(calendarItem: DecryptedCalendarItem,
			delegates: { [ key: string ]: CalendarItemShareOptions }): Promise<DecryptedCalendarItem>;

	findCalendarItemsByHcPartyPatient(hcPartyId: string, patient: Patient,
			options?: { hcPartyId?: string, patient?: Patient, startDate?: number | undefined, endDate?: number | undefined, descending?: boolean | undefined }): Promise<PaginatedListIterator<DecryptedCalendarItem>>;

	linkToPatient(calendarItem: CalendarItem, patient: Patient,
			shareLinkWithDelegates: Array<string>): Promise<DecryptedCalendarItem>;

	modifyCalendarItem(entity: DecryptedCalendarItem): Promise<DecryptedCalendarItem>;

	getCalendarItem(entityId: string): Promise<DecryptedCalendarItem>;

	getCalendarItems(entityIds: Array<string>): Promise<Array<DecryptedCalendarItem>>;

	getCalendarItemsByPeriodAndHcPartyId(startDate: number, endDate: number,
			hcPartyId: string): Promise<Array<DecryptedCalendarItem>>;

	getCalendarsByPeriodAndAgendaId(startDate: number, endDate: number,
			agendaId: string): Promise<Array<DecryptedCalendarItem>>;

	getCalendarItemsWithIds(entityIds: Array<string>): Promise<Array<DecryptedCalendarItem>>;

	findCalendarItemsByRecurrenceId(recurrenceId: string, startKey: string | undefined,
			startDocumentId: string | undefined,
			limit: number): Promise<PaginatedList<DecryptedCalendarItem>>;

}
