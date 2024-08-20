// auto-generated file
import {randomUuid} from '../utils/Id.mjs';
import {CodeStub} from './base/CodeStub.mjs';
import {HasEncryptionMetadata} from './base/HasEncryptionMetadata.mjs';
import {ICureDocument} from './base/ICureDocument.mjs';
import {Identifier} from './base/Identifier.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {Annotation} from './embed/Annotation.mjs';
import {CareTeamMember, DecryptedCareTeamMember, EncryptedCareTeamMember} from './embed/CareTeamMember.mjs';
import {Delegation} from './embed/Delegation.mjs';
import {Encryptable} from './embed/Encryptable.mjs';
import {DecryptedEpisode, EncryptedEpisode, Episode} from './embed/Episode.mjs';
import {Laterality} from './embed/Laterality.mjs';
import {DecryptedPlanOfAction, EncryptedPlanOfAction, PlanOfAction} from './embed/PlanOfAction.mjs';
import {SecurityMetadata} from './embed/SecurityMetadata.mjs';
import {Base64String} from './specializations/Base64String.mjs';


export interface HealthElement extends StoredDocument, ICureDocument<string>, HasEncryptionMetadata, Encryptable {

	identifiers: Array<Identifier>;

	healthElementId: string | undefined;

	valueDate: number | undefined;

	openingDate: number | undefined;

	closingDate: number | undefined;

	descr: string | undefined;

	note: string | undefined;

	notes: Array<Annotation>;

	relevant: boolean;

	idOpeningContact: string | undefined;

	idClosingContact: string | undefined;

	idService: string | undefined;

	status: number;

	laterality: Laterality | undefined;

	plansOfAction: Array<PlanOfAction>;

	episodes: Array<Episode>;

	careTeam: Array<CareTeamMember>;

	readonly isEncrypted: boolean;

}

export class DecryptedHealthElement {

	id: string;

	identifiers: Array<Identifier> = [];

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

	healthElementId: string | undefined = undefined;

	valueDate: number | undefined = undefined;

	openingDate: number | undefined = undefined;

	closingDate: number | undefined = undefined;

	descr: string | undefined = undefined;

	note: string | undefined = undefined;

	notes: Array<Annotation> = [];

	relevant: boolean = true;

	idOpeningContact: string | undefined = undefined;

	idClosingContact: string | undefined = undefined;

	idService: string | undefined = undefined;

	status: number = 0;

	laterality: Laterality | undefined = undefined;

	plansOfAction: Array<DecryptedPlanOfAction> = [];

	episodes: Array<DecryptedEpisode> = [];

	careTeam: Array<DecryptedCareTeamMember> = [];

	secretForeignKeys: Array<string> = [];

	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	delegations: { [ key: string ]: Array<Delegation> } = {};

	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	encryptedSelf: Base64String | undefined = undefined;

	securityMetadata: SecurityMetadata | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedHealthElement>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
		this.id = partial.id ?? randomUuid();
		if ('identifiers' in partial && partial.identifiers !== undefined) this.identifiers = partial.identifiers;
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
		if ('healthElementId' in partial) this.healthElementId = partial.healthElementId;
		if ('valueDate' in partial) this.valueDate = partial.valueDate;
		if ('openingDate' in partial) this.openingDate = partial.openingDate;
		if ('closingDate' in partial) this.closingDate = partial.closingDate;
		if ('descr' in partial) this.descr = partial.descr;
		if ('note' in partial) this.note = partial.note;
		if ('notes' in partial && partial.notes !== undefined) this.notes = partial.notes;
		if ('relevant' in partial && partial.relevant !== undefined) this.relevant = partial.relevant;
		if ('idOpeningContact' in partial) this.idOpeningContact = partial.idOpeningContact;
		if ('idClosingContact' in partial) this.idClosingContact = partial.idClosingContact;
		if ('idService' in partial) this.idService = partial.idService;
		if ('status' in partial && partial.status !== undefined) this.status = partial.status;
		if ('laterality' in partial) this.laterality = partial.laterality;
		if ('plansOfAction' in partial && partial.plansOfAction !== undefined) this.plansOfAction = partial.plansOfAction;
		if ('episodes' in partial && partial.episodes !== undefined) this.episodes = partial.episodes;
		if ('careTeam' in partial && partial.careTeam !== undefined) this.careTeam = partial.careTeam;
		if ('secretForeignKeys' in partial && partial.secretForeignKeys !== undefined) this.secretForeignKeys = partial.secretForeignKeys;
		if ('cryptedForeignKeys' in partial && partial.cryptedForeignKeys !== undefined) this.cryptedForeignKeys = partial.cryptedForeignKeys;
		if ('delegations' in partial && partial.delegations !== undefined) this.delegations = partial.delegations;
		if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
		if ('securityMetadata' in partial) this.securityMetadata = partial.securityMetadata;
	}

}

export class EncryptedHealthElement {

	id: string;

	identifiers: Array<Identifier> = [];

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

	healthElementId: string | undefined = undefined;

	valueDate: number | undefined = undefined;

	openingDate: number | undefined = undefined;

	closingDate: number | undefined = undefined;

	descr: string | undefined = undefined;

	note: string | undefined = undefined;

	notes: Array<Annotation> = [];

	relevant: boolean = true;

	idOpeningContact: string | undefined = undefined;

	idClosingContact: string | undefined = undefined;

	idService: string | undefined = undefined;

	status: number = 0;

	laterality: Laterality | undefined = undefined;

	plansOfAction: Array<EncryptedPlanOfAction> = [];

	episodes: Array<EncryptedEpisode> = [];

	careTeam: Array<EncryptedCareTeamMember> = [];

	secretForeignKeys: Array<string> = [];

	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	delegations: { [ key: string ]: Array<Delegation> } = {};

	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	encryptedSelf: Base64String | undefined = undefined;

	securityMetadata: SecurityMetadata | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedHealthElement>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
		this.id = partial.id ?? randomUuid();
		if ('identifiers' in partial && partial.identifiers !== undefined) this.identifiers = partial.identifiers;
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
		if ('healthElementId' in partial) this.healthElementId = partial.healthElementId;
		if ('valueDate' in partial) this.valueDate = partial.valueDate;
		if ('openingDate' in partial) this.openingDate = partial.openingDate;
		if ('closingDate' in partial) this.closingDate = partial.closingDate;
		if ('descr' in partial) this.descr = partial.descr;
		if ('note' in partial) this.note = partial.note;
		if ('notes' in partial && partial.notes !== undefined) this.notes = partial.notes;
		if ('relevant' in partial && partial.relevant !== undefined) this.relevant = partial.relevant;
		if ('idOpeningContact' in partial) this.idOpeningContact = partial.idOpeningContact;
		if ('idClosingContact' in partial) this.idClosingContact = partial.idClosingContact;
		if ('idService' in partial) this.idService = partial.idService;
		if ('status' in partial && partial.status !== undefined) this.status = partial.status;
		if ('laterality' in partial) this.laterality = partial.laterality;
		if ('plansOfAction' in partial && partial.plansOfAction !== undefined) this.plansOfAction = partial.plansOfAction;
		if ('episodes' in partial && partial.episodes !== undefined) this.episodes = partial.episodes;
		if ('careTeam' in partial && partial.careTeam !== undefined) this.careTeam = partial.careTeam;
		if ('secretForeignKeys' in partial && partial.secretForeignKeys !== undefined) this.secretForeignKeys = partial.secretForeignKeys;
		if ('cryptedForeignKeys' in partial && partial.cryptedForeignKeys !== undefined) this.cryptedForeignKeys = partial.cryptedForeignKeys;
		if ('delegations' in partial && partial.delegations !== undefined) this.delegations = partial.delegations;
		if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
		if ('securityMetadata' in partial) this.securityMetadata = partial.securityMetadata;
	}

}
