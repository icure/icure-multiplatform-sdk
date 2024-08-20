// auto-generated file
import {HexString} from '../specializations/HexString.mjs';


export class Delegation {

	owner: string | undefined = undefined;

	delegatedTo: string | undefined = undefined;

	key: HexString | undefined = undefined;

	tags: Array<string> = [];

	constructor(partial: Partial<Delegation>) {
		if ('owner' in partial) this.owner = partial.owner;
		if ('delegatedTo' in partial) this.delegatedTo = partial.delegatedTo;
		if ('key' in partial) this.key = partial.key;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
	}

}
