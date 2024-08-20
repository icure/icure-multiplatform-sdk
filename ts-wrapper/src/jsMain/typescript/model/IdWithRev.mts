// auto-generated file
import {randomUuid} from '../utils/Id.mjs';


export class IdWithRev {

	id: string;

	rev: string | undefined = undefined;

	constructor(partial: Partial<IdWithRev>) {
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
	}

}
