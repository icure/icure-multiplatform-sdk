// auto-generated file
import {Operator} from './Operator.mjs';


export class KeyValuePredicate {

	key: string | undefined = undefined;

	operator: Operator | undefined = undefined;

	value: any | undefined = undefined;

	readonly $ktClass: 'com.icure.cardinal.sdk.model.filter.predicate.KeyValuePredicate' = 'com.icure.cardinal.sdk.model.filter.predicate.KeyValuePredicate';

	constructor(partial: Partial<KeyValuePredicate>) {
		if ('key' in partial) this.key = partial.key;
		if ('operator' in partial) this.operator = partial.operator;
		if ('value' in partial) this.value = partial.value;
	}

}
