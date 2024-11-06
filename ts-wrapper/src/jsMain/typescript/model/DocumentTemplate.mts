// auto-generated file
import {randomUuid} from '../utils/Id.mjs';
import {CodeStub} from './base/CodeStub.mjs';
import {ICureDocument} from './base/ICureDocument.mjs';
import {ReportVersion} from './base/ReportVersion.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {DocumentGroup} from './embed/DocumentGroup.mjs';
import {DocumentType} from './embed/DocumentType.mjs';


export class DocumentTemplate implements StoredDocument, ICureDocument<string> {

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

	attachment: Int8Array | undefined = undefined;

	documentType: DocumentType | undefined = undefined;

	mainUti: string | undefined = undefined;

	name: string | undefined = undefined;

	otherUtis: Array<string> = [];

	attachmentId: string | undefined = undefined;

	version: ReportVersion | undefined = undefined;

	owner: string | undefined = undefined;

	guid: string | undefined = undefined;

	group: DocumentGroup | undefined = undefined;

	descr: string | undefined = undefined;

	disabled: string | undefined = undefined;

	specialty: CodeStub | undefined = undefined;

	constructor(partial: Partial<DocumentTemplate>) {
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
		if ('attachment' in partial) this.attachment = partial.attachment;
		if ('documentType' in partial) this.documentType = partial.documentType;
		if ('mainUti' in partial) this.mainUti = partial.mainUti;
		if ('name' in partial) this.name = partial.name;
		if ('otherUtis' in partial && partial.otherUtis !== undefined) this.otherUtis = partial.otherUtis;
		if ('attachmentId' in partial) this.attachmentId = partial.attachmentId;
		if ('version' in partial) this.version = partial.version;
		if ('owner' in partial) this.owner = partial.owner;
		if ('guid' in partial) this.guid = partial.guid;
		if ('group' in partial) this.group = partial.group;
		if ('descr' in partial) this.descr = partial.descr;
		if ('disabled' in partial) this.disabled = partial.disabled;
		if ('specialty' in partial) this.specialty = partial.specialty;
	}

}
