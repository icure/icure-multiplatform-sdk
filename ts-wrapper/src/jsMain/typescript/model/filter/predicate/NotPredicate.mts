// auto-generated file
import {Predicate} from './Predicate.mjs';


export class NotPredicate {

	predicate: Predicate;

	readonly $ktClass: 'com.icure.sdk.model.filter.predicate.NotPredicate' = 'com.icure.sdk.model.filter.predicate.NotPredicate';

	constructor(partial: Partial<NotPredicate> & Pick<NotPredicate, "predicate">) {
		this.predicate = partial.predicate;
	}

}
