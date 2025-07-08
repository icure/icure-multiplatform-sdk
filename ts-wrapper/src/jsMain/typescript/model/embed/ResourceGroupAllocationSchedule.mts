// auto-generated file
import {CodeStub} from '../base/CodeStub.mjs';
import {EmbeddedTimeTableItem} from './EmbeddedTimeTableItem.mjs';


export class ResourceGroupAllocationSchedule {

	resourceGroup: CodeStub | undefined = undefined;

	tags: Array<CodeStub> = [];

	codes: Array<CodeStub> = [];

	name: string | undefined = undefined;

	startDateTime: number | undefined = undefined;

	endDateTime: number | undefined = undefined;

	items: Array<EmbeddedTimeTableItem> = [];

	constructor(partial: Partial<ResourceGroupAllocationSchedule>) {
		if ('resourceGroup' in partial) this.resourceGroup = partial.resourceGroup;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('name' in partial) this.name = partial.name;
		if ('startDateTime' in partial) this.startDateTime = partial.startDateTime;
		if ('endDateTime' in partial) this.endDateTime = partial.endDateTime;
		if ('items' in partial && partial.items !== undefined) this.items = partial.items;
	}

}
