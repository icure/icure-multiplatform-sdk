// auto-generated file

export class Suspension {

	beginMoment: number | undefined = undefined;

	endMoment: number | undefined = undefined;

	suspensionReason: string | undefined = undefined;

	lifecycle: string | undefined = undefined;

	constructor(partial: Partial<Suspension>) {
		if ('beginMoment' in partial) this.beginMoment = partial.beginMoment;
		if ('endMoment' in partial) this.endMoment = partial.endMoment;
		if ('suspensionReason' in partial) this.suspensionReason = partial.suspensionReason;
		if ('lifecycle' in partial) this.lifecycle = partial.lifecycle;
	}

}
