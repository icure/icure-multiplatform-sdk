// auto-generated file
import {EmbeddedTimeTableHour} from './EmbeddedTimeTableHour.mjs';


export class EmbeddedTimeTableItem {

	rrule: string;

	rruleStartDate: number | undefined = undefined;

	notBeforeInMinutes: number | undefined = undefined;

	notAfterInMinutes: number | undefined = undefined;

	hours: Array<EmbeddedTimeTableHour>;

	calendarItemTypesIds: Array<string>;

	availabilities: number = 1;

	reservingRights: Array<string> = [];

	public: boolean = false;

	constructor(partial: Partial<EmbeddedTimeTableItem> & Pick<EmbeddedTimeTableItem, "rrule" | "hours" | "calendarItemTypesIds">) {
		this.rrule = partial.rrule;
		if ('rruleStartDate' in partial) this.rruleStartDate = partial.rruleStartDate;
		if ('notBeforeInMinutes' in partial) this.notBeforeInMinutes = partial.notBeforeInMinutes;
		if ('notAfterInMinutes' in partial) this.notAfterInMinutes = partial.notAfterInMinutes;
		this.hours = partial.hours;
		this.calendarItemTypesIds = partial.calendarItemTypesIds;
		if ('availabilities' in partial && partial.availabilities !== undefined) this.availabilities = partial.availabilities;
		if ('reservingRights' in partial && partial.reservingRights !== undefined) this.reservingRights = partial.reservingRights;
		if ('public' in partial && partial.public !== undefined) this.public = partial.public;
	}

}
