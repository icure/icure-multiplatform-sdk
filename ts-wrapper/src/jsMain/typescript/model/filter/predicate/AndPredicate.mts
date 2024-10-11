// auto-generated file
import {Predicate} from './Predicate.mjs';


export class AndPredicate {

	predicates: Array<Predicate> = [];

	readonly $ktClass: 'com.icure.cardinal.sdk.model.filter.predicate.AndPredicate' = 'com.icure.cardinal.sdk.model.filter.predicate.AndPredicate';

	constructor(partial: Partial<AndPredicate>) {
		if ('predicates' in partial && partial.predicates !== undefined) this.predicates = partial.predicates;
	}

}
