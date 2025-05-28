// auto-generated file
import {randomUuid} from '../utils/Id.mjs';


export class AnonymousMedicalLocation {

	id: string;

	publicInformations: { [ key: string ]: string } = {};

	constructor(partial: Partial<AnonymousMedicalLocation>) {
		this.id = partial.id ?? randomUuid();
		if ('publicInformations' in partial && partial.publicInformations !== undefined) this.publicInformations = partial.publicInformations;
	}

}
