// auto-generated file
import {randomUuid} from '../utils/Id.mjs';


export class GroupDeletionReport {

	type: string;

	id: string;

	server: string;

	constructor(partial: Partial<GroupDeletionReport> & Pick<GroupDeletionReport, "type" | "server">) {
		this.type = partial.type;
		this.id = partial.id ?? randomUuid();
		this.server = partial.server;
	}

}
