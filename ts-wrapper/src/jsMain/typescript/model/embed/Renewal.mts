// auto-generated file
import {Duration} from './Duration.mjs';


export class Renewal {

	decimal: number | undefined = undefined;

	duration: Duration | undefined = undefined;

	constructor(partial: Partial<Renewal>) {
		if ('decimal' in partial) this.decimal = partial.decimal;
		if ('duration' in partial) this.duration = partial.duration;
	}

}
