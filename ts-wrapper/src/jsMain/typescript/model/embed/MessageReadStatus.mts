// auto-generated file

export class MessageReadStatus {

	time: number | undefined = undefined;

	read: boolean = false;

	constructor(partial: Partial<MessageReadStatus>) {
		if ('time' in partial) this.time = partial.time;
		if ('read' in partial && partial.read !== undefined) this.read = partial.read;
	}

}
