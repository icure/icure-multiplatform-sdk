// auto-generated file
import {randomUuid} from '../../utils/Id.mjs';
import {CodeStub} from '../base/CodeStub.mjs';
import {ICureDocument} from '../base/ICureDocument.mjs';
import {Named} from '../base/Named.mjs';
import {Base64String} from '../specializations/Base64String.mjs';
import {CareTeamMembership, DecryptedCareTeamMembership, EncryptedCareTeamMembership} from './CareTeamMembership.mjs';
import {Encryptable} from './Encryptable.mjs';


export interface PlanOfAction extends Encryptable, ICureDocument<string>, Named {

	prescriberId: string | undefined;

	valueDate: number | undefined;

	openingDate: number | undefined;

	closingDate: number | undefined;

	deadlineDate: number | undefined;

	descr: string | undefined;

	note: string | undefined;

	idOpeningContact: string | undefined;

	idClosingContact: string | undefined;

	status: number;

	documentIds: Array<string>;

	numberOfCares: number | undefined;

	careTeamMemberships: Array<CareTeamMembership | undefined>;

	relevant: boolean;

	readonly isEncrypted: boolean;

}

export class DecryptedPlanOfAction {

	id: string;

	created: number | undefined = undefined;

	modified: number | undefined = undefined;

	author: string | undefined = undefined;

	responsible: string | undefined = undefined;

	medicalLocationId: string | undefined = undefined;

	tags: Array<CodeStub> = [];

	codes: Array<CodeStub> = [];

	endOfLife: number | undefined = undefined;

	prescriberId: string | undefined = undefined;

	valueDate: number | undefined = undefined;

	openingDate: number | undefined = undefined;

	closingDate: number | undefined = undefined;

	deadlineDate: number | undefined = undefined;

	name: string | undefined = undefined;

	descr: string | undefined = undefined;

	note: string | undefined = undefined;

	idOpeningContact: string | undefined = undefined;

	idClosingContact: string | undefined = undefined;

	status: number = 0;

	documentIds: Array<string> = [];

	numberOfCares: number | undefined = undefined;

	careTeamMemberships: Array<DecryptedCareTeamMembership | undefined> = [];

	relevant: boolean = true;

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedPlanOfAction>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
		this.id = partial.id ?? randomUuid();
		if ('created' in partial) this.created = partial.created;
		if ('modified' in partial) this.modified = partial.modified;
		if ('author' in partial) this.author = partial.author;
		if ('responsible' in partial) this.responsible = partial.responsible;
		if ('medicalLocationId' in partial) this.medicalLocationId = partial.medicalLocationId;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
		if ('prescriberId' in partial) this.prescriberId = partial.prescriberId;
		if ('valueDate' in partial) this.valueDate = partial.valueDate;
		if ('openingDate' in partial) this.openingDate = partial.openingDate;
		if ('closingDate' in partial) this.closingDate = partial.closingDate;
		if ('deadlineDate' in partial) this.deadlineDate = partial.deadlineDate;
		if ('name' in partial) this.name = partial.name;
		if ('descr' in partial) this.descr = partial.descr;
		if ('note' in partial) this.note = partial.note;
		if ('idOpeningContact' in partial) this.idOpeningContact = partial.idOpeningContact;
		if ('idClosingContact' in partial) this.idClosingContact = partial.idClosingContact;
		if ('status' in partial && partial.status !== undefined) this.status = partial.status;
		if ('documentIds' in partial && partial.documentIds !== undefined) this.documentIds = partial.documentIds;
		if ('numberOfCares' in partial) this.numberOfCares = partial.numberOfCares;
		if ('careTeamMemberships' in partial && partial.careTeamMemberships !== undefined) this.careTeamMemberships = partial.careTeamMemberships;
		if ('relevant' in partial && partial.relevant !== undefined) this.relevant = partial.relevant;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

}

export class EncryptedPlanOfAction {

	id: string;

	created: number | undefined = undefined;

	modified: number | undefined = undefined;

	author: string | undefined = undefined;

	responsible: string | undefined = undefined;

	medicalLocationId: string | undefined = undefined;

	tags: Array<CodeStub> = [];

	codes: Array<CodeStub> = [];

	endOfLife: number | undefined = undefined;

	prescriberId: string | undefined = undefined;

	valueDate: number | undefined = undefined;

	openingDate: number | undefined = undefined;

	closingDate: number | undefined = undefined;

	deadlineDate: number | undefined = undefined;

	name: string | undefined = undefined;

	descr: string | undefined = undefined;

	note: string | undefined = undefined;

	idOpeningContact: string | undefined = undefined;

	idClosingContact: string | undefined = undefined;

	status: number = 0;

	documentIds: Array<string> = [];

	numberOfCares: number | undefined = undefined;

	careTeamMemberships: Array<EncryptedCareTeamMembership | undefined> = [];

	relevant: boolean = true;

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedPlanOfAction>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
		this.id = partial.id ?? randomUuid();
		if ('created' in partial) this.created = partial.created;
		if ('modified' in partial) this.modified = partial.modified;
		if ('author' in partial) this.author = partial.author;
		if ('responsible' in partial) this.responsible = partial.responsible;
		if ('medicalLocationId' in partial) this.medicalLocationId = partial.medicalLocationId;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
		if ('prescriberId' in partial) this.prescriberId = partial.prescriberId;
		if ('valueDate' in partial) this.valueDate = partial.valueDate;
		if ('openingDate' in partial) this.openingDate = partial.openingDate;
		if ('closingDate' in partial) this.closingDate = partial.closingDate;
		if ('deadlineDate' in partial) this.deadlineDate = partial.deadlineDate;
		if ('name' in partial) this.name = partial.name;
		if ('descr' in partial) this.descr = partial.descr;
		if ('note' in partial) this.note = partial.note;
		if ('idOpeningContact' in partial) this.idOpeningContact = partial.idOpeningContact;
		if ('idClosingContact' in partial) this.idClosingContact = partial.idClosingContact;
		if ('status' in partial && partial.status !== undefined) this.status = partial.status;
		if ('documentIds' in partial && partial.documentIds !== undefined) this.documentIds = partial.documentIds;
		if ('numberOfCares' in partial) this.numberOfCares = partial.numberOfCares;
		if ('careTeamMemberships' in partial && partial.careTeamMemberships !== undefined) this.careTeamMemberships = partial.careTeamMemberships;
		if ('relevant' in partial && partial.relevant !== undefined) this.relevant = partial.relevant;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

}
