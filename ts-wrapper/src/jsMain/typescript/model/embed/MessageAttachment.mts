// auto-generated file
import {DocumentLocation} from './DocumentLocation.mjs';


export class MessageAttachment {

	type: DocumentLocation | undefined = undefined;

	ids: Array<string> = [];

	constructor(partial: Partial<MessageAttachment>) {
		if ('type' in partial) this.type = partial.type;
		if ('ids' in partial && partial.ids !== undefined) this.ids = partial.ids;
	}

}
