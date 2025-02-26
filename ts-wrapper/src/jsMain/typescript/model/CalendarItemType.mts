// auto-generated file
import {randomUuid} from '../utils/Id.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';


export class CalendarItemType implements StoredDocument {

	id: string;

	rev: string | undefined = undefined;

	deletionDate: number | undefined = undefined;

	healthcarePartyId: string | undefined = undefined;

	agendaId: string | undefined = undefined;

	defaultCalendarItemType: boolean = false;

	name: string | undefined = undefined;

	color: string | undefined = undefined;

	duration: number = 0;

	externalRef: string | undefined = undefined;

	mikronoId: string | undefined = undefined;

	docIds: Array<string> = [];

	otherInfos: { [ key: string ]: string } = {};

	subjectByLanguage: { [ key: string ]: string } = {};

	constructor(partial: Partial<CalendarItemType>) {
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
		if ('agendaId' in partial) this.agendaId = partial.agendaId;
		if ('defaultCalendarItemType' in partial && partial.defaultCalendarItemType !== undefined) this.defaultCalendarItemType = partial.defaultCalendarItemType;
		if ('name' in partial) this.name = partial.name;
		if ('color' in partial) this.color = partial.color;
		if ('duration' in partial && partial.duration !== undefined) this.duration = partial.duration;
		if ('externalRef' in partial) this.externalRef = partial.externalRef;
		if ('mikronoId' in partial) this.mikronoId = partial.mikronoId;
		if ('docIds' in partial && partial.docIds !== undefined) this.docIds = partial.docIds;
		if ('otherInfos' in partial && partial.otherInfos !== undefined) this.otherInfos = partial.otherInfos;
		if ('subjectByLanguage' in partial && partial.subjectByLanguage !== undefined) this.subjectByLanguage = partial.subjectByLanguage;
	}

}
