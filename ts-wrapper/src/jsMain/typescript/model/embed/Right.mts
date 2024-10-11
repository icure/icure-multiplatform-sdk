// auto-generated file

export class Right {

	userId: string | undefined = undefined;

	read: boolean = false;

	write: boolean = false;

	administration: boolean = false;

	constructor(partial: Partial<Right>) {
		if ('userId' in partial) this.userId = partial.userId;
		if ('read' in partial && partial.read !== undefined) this.read = partial.read;
		if ('write' in partial && partial.write !== undefined) this.write = partial.write;
		if ('administration' in partial && partial.administration !== undefined) this.administration = partial.administration;
	}

}
