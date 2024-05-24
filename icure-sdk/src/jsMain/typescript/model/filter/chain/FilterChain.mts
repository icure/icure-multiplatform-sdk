// auto-generated file
import {Identifiable} from '../../base/Identifiable.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';
import {Predicate} from '../predicate/Predicate.mjs';


export class FilterChain<O extends Identifiable<string>> {

  filter: AbstractFilter<O>;

  predicate: Predicate | undefined = undefined;

  constructor(partial: Partial<FilterChain<O>> & Pick<FilterChain<O>, "filter">) {
    this.filter = partial.filter;
    if ('predicate' in partial) this.predicate = partial.predicate;
  }

}
