// auto-generated file
import {Basic} from './Basic.mjs';


export class RemoteAuthentication {

	basic: Basic | undefined = undefined;

	constructor(partial: Partial<RemoteAuthentication>) {
		if ('basic' in partial) this.basic = partial.basic;
	}

}
