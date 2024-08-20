// auto-generated file

export class CalendarItemTag {

	code: string | undefined = undefined;

	date: number | undefined = undefined;

	userId: string | undefined = undefined;

	userName: string | undefined = undefined;

	constructor(partial: Partial<CalendarItemTag>) {
		if ('code' in partial) this.code = partial.code;
		if ('date' in partial) this.date = partial.date;
		if ('userId' in partial) this.userId = partial.userId;
		if ('userName' in partial) this.userName = partial.userName;
	}

}
