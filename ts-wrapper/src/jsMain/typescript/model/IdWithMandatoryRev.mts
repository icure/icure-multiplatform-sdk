// auto-generated file
import {randomUuid} from '../utils/Id.mjs';


export class IdWithMandatoryRev {

	id: string;

	rev: string;

	constructor(partial: Partial<IdWithMandatoryRev> & Pick<IdWithMandatoryRev, "rev">) {
		this.id = partial.id ?? randomUuid();
		this.rev = partial.rev;
	}

}
