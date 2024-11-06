// auto-generated file
import {Operation} from './Operation.mjs';


export class OperationToken {

	tokenHash: string;

	creationTime: number;

	validity: number;

	operation: Operation;

	description: string | undefined = undefined;

	constructor(partial: Partial<OperationToken> & Pick<OperationToken, "tokenHash" | "creationTime" | "validity" | "operation">) {
		this.tokenHash = partial.tokenHash;
		this.creationTime = partial.creationTime;
		this.validity = partial.validity;
		this.operation = partial.operation;
		if ('description' in partial) this.description = partial.description;
	}

}
