// auto-generated file
import {randomUuid} from '../utils/Id.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';


export class EntityTemplate implements StoredDocument {

	id: string;

	rev: string | undefined = undefined;

	deletionDate: number | undefined = undefined;

	userId: string | undefined = undefined;

	descr: string | undefined = undefined;

	keywords: Array<string> | undefined = undefined;

	entityType: string | undefined = undefined;

	subType: string | undefined = undefined;

	defaultTemplate: boolean | undefined = undefined;

	entity: Array<any> = [];

	constructor(partial: Partial<EntityTemplate>) {
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('userId' in partial) this.userId = partial.userId;
		if ('descr' in partial) this.descr = partial.descr;
		if ('keywords' in partial) this.keywords = partial.keywords;
		if ('entityType' in partial) this.entityType = partial.entityType;
		if ('subType' in partial) this.subType = partial.subType;
		if ('defaultTemplate' in partial) this.defaultTemplate = partial.defaultTemplate;
		if ('entity' in partial && partial.entity !== undefined) this.entity = partial.entity;
	}

}
