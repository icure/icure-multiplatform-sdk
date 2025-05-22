// auto-generated file
import {randomUuid} from '../../utils/Id.mjs';
import {CodeStub} from '../base/CodeStub.mjs';
import {TimeTableItem} from './TimeTableItem.mjs';


export class EmbeddedTimeTable {

	id: string;

	codes: Array<CodeStub> = [];

	medicalLocationId: string | undefined = undefined;

	endOfLife: number | undefined = undefined;

	name: string | undefined = undefined;

	startTime: number | undefined = undefined;

	endTime: number | undefined = undefined;

	items: Array<TimeTableItem> = [];

	constructor(partial: Partial<EmbeddedTimeTable>) {
		this.id = partial.id ?? randomUuid();
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('medicalLocationId' in partial) this.medicalLocationId = partial.medicalLocationId;
		if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
		if ('name' in partial) this.name = partial.name;
		if ('startTime' in partial) this.startTime = partial.startTime;
		if ('endTime' in partial) this.endTime = partial.endTime;
		if ('items' in partial && partial.items !== undefined) this.items = partial.items;
	}

}
