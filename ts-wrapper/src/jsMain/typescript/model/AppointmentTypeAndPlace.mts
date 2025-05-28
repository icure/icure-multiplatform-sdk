// auto-generated file
import {DecryptedAddress} from './embed/Address.mjs';


export class AppointmentTypeAndPlace {

	calendarItemTypeId: string;

	name: string | undefined = undefined;

	color: string | undefined = undefined;

	duration: number = 0;

	subjectByLanguage: { [ key: string ]: string } | undefined = {};

	placeId: string | undefined = undefined;

	address: DecryptedAddress | undefined = undefined;

	acceptsNewPatients: boolean = true;

	constructor(partial: Partial<AppointmentTypeAndPlace> & Pick<AppointmentTypeAndPlace, "calendarItemTypeId">) {
		this.calendarItemTypeId = partial.calendarItemTypeId;
		if ('name' in partial) this.name = partial.name;
		if ('color' in partial) this.color = partial.color;
		if ('duration' in partial && partial.duration !== undefined) this.duration = partial.duration;
		if ('subjectByLanguage' in partial) this.subjectByLanguage = partial.subjectByLanguage;
		if ('placeId' in partial) this.placeId = partial.placeId;
		if ('address' in partial) this.address = partial.address;
		if ('acceptsNewPatients' in partial && partial.acceptsNewPatients !== undefined) this.acceptsNewPatients = partial.acceptsNewPatients;
	}

}
