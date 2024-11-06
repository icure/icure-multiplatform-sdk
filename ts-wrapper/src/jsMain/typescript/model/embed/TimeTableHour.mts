// auto-generated file

export class TimeTableHour {

	startHour: number | undefined = undefined;

	endHour: number | undefined = undefined;

	constructor(partial: Partial<TimeTableHour>) {
		if ('startHour' in partial) this.startHour = partial.startHour;
		if ('endHour' in partial) this.endHour = partial.endHour;
	}

}
