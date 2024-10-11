// auto-generated file
import {Launcher} from './Launcher.mjs';
import {State} from './State.mjs';


export class Action {

	launchers: Array<Launcher> | undefined = [];

	expression: string | undefined = undefined;

	states: Array<State> | undefined = [];

	constructor(partial: Partial<Action>) {
		if ('launchers' in partial) this.launchers = partial.launchers;
		if ('expression' in partial) this.expression = partial.expression;
		if ('states' in partial) this.states = partial.states;
	}

}
