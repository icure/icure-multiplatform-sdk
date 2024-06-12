// auto-generated file
import {Predicate} from './Predicate.mjs';


export class OrPredicate {

  predicates: Array<Predicate> = [];

  readonly $ktClass: 'com.icure.sdk.model.filter.predicate.OrPredicate' = 'com.icure.sdk.model.filter.predicate.OrPredicate';

  constructor(partial: Partial<OrPredicate>) {
    if ('predicates' in partial && partial.predicates !== undefined) this.predicates = partial.predicates;
  }

}
