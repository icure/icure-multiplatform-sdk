// auto-generated file
import {Agenda} from './Agenda.mjs';
import {CalendarItemType} from './CalendarItemType.mjs';


export class PublicAgendasAndCalendarItemTypes {

	agendas: Array<Agenda>;

	calendarItemTypes: Array<CalendarItemType>;

	constructor(partial: Partial<PublicAgendasAndCalendarItemTypes> & Pick<PublicAgendasAndCalendarItemTypes, "agendas" | "calendarItemTypes">) {
		this.agendas = partial.agendas;
		this.calendarItemTypes = partial.calendarItemTypes;
	}

}
