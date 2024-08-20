// auto-generated file
import {PaginatedDocumentKeyIdPair} from './PaginatedDocumentKeyIdPair.mjs';


export class PaginatedList<T> {

	rows: Array<T> = [];

	nextKeyPair: PaginatedDocumentKeyIdPair | undefined = undefined;

	constructor(partial: Partial<PaginatedList<T>>) {
		if ('rows' in partial && partial.rows !== undefined) this.rows = partial.rows;
		if ('nextKeyPair' in partial) this.nextKeyPair = partial.nextKeyPair;
	}

}
