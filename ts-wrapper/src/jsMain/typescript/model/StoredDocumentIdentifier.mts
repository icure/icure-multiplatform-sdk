// auto-generated file
import {randomUuid} from '../utils/Id.mjs';
import {Identifiable} from './base/Identifiable.mjs';


export class StoredDocumentIdentifier implements Identifiable<string> {

	id: string;

	rev: string;

	constructor(partial: Partial<StoredDocumentIdentifier> & Pick<StoredDocumentIdentifier, "rev">) {
		this.id = partial.id ?? randomUuid();
		this.rev = partial.rev;
	}

}
