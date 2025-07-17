// auto-generated file
import {randomUuid} from '../utils/Id.mjs';
import {CalendarItem as CalendarItem_} from './CalendarItem.mjs';
import {CodeStub} from './base/CodeStub.mjs';
import {HasEncryptionMetadata} from './base/HasEncryptionMetadata.mjs';
import {ICureDocument} from './base/ICureDocument.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {Address, DecryptedAddress, EncryptedAddress} from './embed/Address.mjs';
import {CalendarItemTag, DecryptedCalendarItemTag, EncryptedCalendarItemTag} from './embed/CalendarItemTag.mjs';
import {Delegation} from './embed/Delegation.mjs';
import {Encryptable} from './embed/Encryptable.mjs';
import {FlowItem} from './embed/FlowItem.mjs';
import {SecurityMetadata} from './embed/SecurityMetadata.mjs';
import {Base64String} from './specializations/Base64String.mjs';


export interface CalendarItem extends StoredDocument, ICureDocument<string>, HasEncryptionMetadata, Encryptable {

	title: string | undefined;

	calendarItemTypeId: string | undefined;

	masterCalendarItemId: string | undefined;

	patientId: string | undefined;

	important: boolean | undefined;

	homeVisit: boolean | undefined;

	phoneNumber: string | undefined;

	placeId: string | undefined;

	address: Address | undefined;

	addressText: string | undefined;

	startTime: number | undefined;

	endTime: number | undefined;

	confirmationTime: number | undefined;

	cancellationTimestamp: number | undefined;

	confirmationId: string | undefined;

	duration: number | undefined;

	allDay: boolean | undefined;

	details: string | undefined;

	wasMigrated: boolean | undefined;

	agendaId: string | undefined;

	resourceGroup: CodeStub | undefined;

	availabilitiesAssignmentStrategy: CalendarItem.AvailabilitiesAssignmentStrategy | undefined;

	hcpId: string | undefined;

	recurrenceId: string | undefined;

	meetingTags: Array<CalendarItemTag>;

	flowItem: FlowItem | undefined;

	readonly isEncrypted: boolean;

}

export class DecryptedCalendarItem {

	id: string;

	rev: string | undefined = undefined;

	created: number | undefined = undefined;

	modified: number | undefined = undefined;

	author: string | undefined = undefined;

	responsible: string | undefined = undefined;

	medicalLocationId: string | undefined = undefined;

	tags: Array<CodeStub> = [];

	codes: Array<CodeStub> = [];

	endOfLife: number | undefined = undefined;

	deletionDate: number | undefined = undefined;

	title: string | undefined = undefined;

	calendarItemTypeId: string | undefined = undefined;

	masterCalendarItemId: string | undefined = undefined;

	patientId: string | undefined = undefined;

	important: boolean | undefined = undefined;

	homeVisit: boolean | undefined = undefined;

	phoneNumber: string | undefined = undefined;

	placeId: string | undefined = undefined;

	address: DecryptedAddress | undefined = undefined;

	addressText: string | undefined = undefined;

	startTime: number | undefined = undefined;

	endTime: number | undefined = undefined;

	confirmationTime: number | undefined = undefined;

	cancellationTimestamp: number | undefined = undefined;

	confirmationId: string | undefined = undefined;

	duration: number | undefined = undefined;

	allDay: boolean | undefined = undefined;

	details: string | undefined = undefined;

	wasMigrated: boolean | undefined = undefined;

	agendaId: string | undefined = undefined;

	resourceGroup: CodeStub | undefined = undefined;

	availabilitiesAssignmentStrategy: CalendarItem_.AvailabilitiesAssignmentStrategy | undefined = undefined;

	hcpId: string | undefined = undefined;

	recurrenceId: string | undefined = undefined;

	meetingTags: Array<DecryptedCalendarItemTag> = [];

	flowItem: FlowItem | undefined = undefined;

	secretForeignKeys: Array<string> = [];

	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	delegations: { [ key: string ]: Array<Delegation> } = {};

	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	encryptedSelf: Base64String | undefined = undefined;

	securityMetadata: SecurityMetadata | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedCalendarItem>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('created' in partial) this.created = partial.created;
		if ('modified' in partial) this.modified = partial.modified;
		if ('author' in partial) this.author = partial.author;
		if ('responsible' in partial) this.responsible = partial.responsible;
		if ('medicalLocationId' in partial) this.medicalLocationId = partial.medicalLocationId;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('title' in partial) this.title = partial.title;
		if ('calendarItemTypeId' in partial) this.calendarItemTypeId = partial.calendarItemTypeId;
		if ('masterCalendarItemId' in partial) this.masterCalendarItemId = partial.masterCalendarItemId;
		if ('patientId' in partial) this.patientId = partial.patientId;
		if ('important' in partial) this.important = partial.important;
		if ('homeVisit' in partial) this.homeVisit = partial.homeVisit;
		if ('phoneNumber' in partial) this.phoneNumber = partial.phoneNumber;
		if ('placeId' in partial) this.placeId = partial.placeId;
		if ('address' in partial) this.address = partial.address;
		if ('addressText' in partial) this.addressText = partial.addressText;
		if ('startTime' in partial) this.startTime = partial.startTime;
		if ('endTime' in partial) this.endTime = partial.endTime;
		if ('confirmationTime' in partial) this.confirmationTime = partial.confirmationTime;
		if ('cancellationTimestamp' in partial) this.cancellationTimestamp = partial.cancellationTimestamp;
		if ('confirmationId' in partial) this.confirmationId = partial.confirmationId;
		if ('duration' in partial) this.duration = partial.duration;
		if ('allDay' in partial) this.allDay = partial.allDay;
		if ('details' in partial) this.details = partial.details;
		if ('wasMigrated' in partial) this.wasMigrated = partial.wasMigrated;
		if ('agendaId' in partial) this.agendaId = partial.agendaId;
		if ('resourceGroup' in partial) this.resourceGroup = partial.resourceGroup;
		if ('availabilitiesAssignmentStrategy' in partial) this.availabilitiesAssignmentStrategy = partial.availabilitiesAssignmentStrategy;
		if ('hcpId' in partial) this.hcpId = partial.hcpId;
		if ('recurrenceId' in partial) this.recurrenceId = partial.recurrenceId;
		if ('meetingTags' in partial && partial.meetingTags !== undefined) this.meetingTags = partial.meetingTags;
		if ('flowItem' in partial) this.flowItem = partial.flowItem;
		if ('secretForeignKeys' in partial && partial.secretForeignKeys !== undefined) this.secretForeignKeys = partial.secretForeignKeys;
		if ('cryptedForeignKeys' in partial && partial.cryptedForeignKeys !== undefined) this.cryptedForeignKeys = partial.cryptedForeignKeys;
		if ('delegations' in partial && partial.delegations !== undefined) this.delegations = partial.delegations;
		if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
		if ('securityMetadata' in partial) this.securityMetadata = partial.securityMetadata;
	}

}

export class EncryptedCalendarItem {

	id: string;

	rev: string | undefined = undefined;

	created: number | undefined = undefined;

	modified: number | undefined = undefined;

	author: string | undefined = undefined;

	responsible: string | undefined = undefined;

	medicalLocationId: string | undefined = undefined;

	tags: Array<CodeStub> = [];

	codes: Array<CodeStub> = [];

	endOfLife: number | undefined = undefined;

	deletionDate: number | undefined = undefined;

	title: string | undefined = undefined;

	calendarItemTypeId: string | undefined = undefined;

	masterCalendarItemId: string | undefined = undefined;

	patientId: string | undefined = undefined;

	important: boolean | undefined = undefined;

	homeVisit: boolean | undefined = undefined;

	phoneNumber: string | undefined = undefined;

	placeId: string | undefined = undefined;

	address: EncryptedAddress | undefined = undefined;

	addressText: string | undefined = undefined;

	startTime: number | undefined = undefined;

	endTime: number | undefined = undefined;

	confirmationTime: number | undefined = undefined;

	cancellationTimestamp: number | undefined = undefined;

	confirmationId: string | undefined = undefined;

	duration: number | undefined = undefined;

	allDay: boolean | undefined = undefined;

	details: string | undefined = undefined;

	wasMigrated: boolean | undefined = undefined;

	agendaId: string | undefined = undefined;

	resourceGroup: CodeStub | undefined = undefined;

	availabilitiesAssignmentStrategy: CalendarItem_.AvailabilitiesAssignmentStrategy | undefined = undefined;

	hcpId: string | undefined = undefined;

	recurrenceId: string | undefined = undefined;

	meetingTags: Array<EncryptedCalendarItemTag> = [];

	flowItem: FlowItem | undefined = undefined;

	secretForeignKeys: Array<string> = [];

	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	delegations: { [ key: string ]: Array<Delegation> } = {};

	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	encryptedSelf: Base64String | undefined = undefined;

	securityMetadata: SecurityMetadata | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedCalendarItem>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('created' in partial) this.created = partial.created;
		if ('modified' in partial) this.modified = partial.modified;
		if ('author' in partial) this.author = partial.author;
		if ('responsible' in partial) this.responsible = partial.responsible;
		if ('medicalLocationId' in partial) this.medicalLocationId = partial.medicalLocationId;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('title' in partial) this.title = partial.title;
		if ('calendarItemTypeId' in partial) this.calendarItemTypeId = partial.calendarItemTypeId;
		if ('masterCalendarItemId' in partial) this.masterCalendarItemId = partial.masterCalendarItemId;
		if ('patientId' in partial) this.patientId = partial.patientId;
		if ('important' in partial) this.important = partial.important;
		if ('homeVisit' in partial) this.homeVisit = partial.homeVisit;
		if ('phoneNumber' in partial) this.phoneNumber = partial.phoneNumber;
		if ('placeId' in partial) this.placeId = partial.placeId;
		if ('address' in partial) this.address = partial.address;
		if ('addressText' in partial) this.addressText = partial.addressText;
		if ('startTime' in partial) this.startTime = partial.startTime;
		if ('endTime' in partial) this.endTime = partial.endTime;
		if ('confirmationTime' in partial) this.confirmationTime = partial.confirmationTime;
		if ('cancellationTimestamp' in partial) this.cancellationTimestamp = partial.cancellationTimestamp;
		if ('confirmationId' in partial) this.confirmationId = partial.confirmationId;
		if ('duration' in partial) this.duration = partial.duration;
		if ('allDay' in partial) this.allDay = partial.allDay;
		if ('details' in partial) this.details = partial.details;
		if ('wasMigrated' in partial) this.wasMigrated = partial.wasMigrated;
		if ('agendaId' in partial) this.agendaId = partial.agendaId;
		if ('resourceGroup' in partial) this.resourceGroup = partial.resourceGroup;
		if ('availabilitiesAssignmentStrategy' in partial) this.availabilitiesAssignmentStrategy = partial.availabilitiesAssignmentStrategy;
		if ('hcpId' in partial) this.hcpId = partial.hcpId;
		if ('recurrenceId' in partial) this.recurrenceId = partial.recurrenceId;
		if ('meetingTags' in partial && partial.meetingTags !== undefined) this.meetingTags = partial.meetingTags;
		if ('flowItem' in partial) this.flowItem = partial.flowItem;
		if ('secretForeignKeys' in partial && partial.secretForeignKeys !== undefined) this.secretForeignKeys = partial.secretForeignKeys;
		if ('cryptedForeignKeys' in partial && partial.cryptedForeignKeys !== undefined) this.cryptedForeignKeys = partial.cryptedForeignKeys;
		if ('delegations' in partial && partial.delegations !== undefined) this.delegations = partial.delegations;
		if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
		if ('securityMetadata' in partial) this.securityMetadata = partial.securityMetadata;
	}

}

export namespace CalendarItem {

	export enum AvailabilitiesAssignmentStrategy {
		Strict = "Strict",
		Loose = "Loose"
	}

}
