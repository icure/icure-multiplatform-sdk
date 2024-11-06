// auto-generated file
import {CodeStub} from '../base/CodeStub.mjs';


export class Substanceproduct {

	intendedcds: Array<CodeStub> = [];

	deliveredcds: Array<CodeStub> = [];

	intendedname: string | undefined = undefined;

	deliveredname: string | undefined = undefined;

	productId: string | undefined = undefined;

	constructor(partial: Partial<Substanceproduct>) {
		if ('intendedcds' in partial && partial.intendedcds !== undefined) this.intendedcds = partial.intendedcds;
		if ('deliveredcds' in partial && partial.deliveredcds !== undefined) this.deliveredcds = partial.deliveredcds;
		if ('intendedname' in partial) this.intendedname = partial.intendedname;
		if ('deliveredname' in partial) this.deliveredname = partial.deliveredname;
		if ('productId' in partial) this.productId = partial.productId;
	}

}
