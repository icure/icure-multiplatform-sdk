// auto-generated file
import {Identifiable} from '../base/Identifiable.mjs';
import {AbstractFilter} from './AbstractFilter.mjs';
import {Filter} from './Filter.mjs';


export class UnionFilter<O extends Identifiable<string>> implements AbstractFilter<O>, Filter.UnionFilter<O> {

  desc: string | undefined = undefined;

  filters: Array<AbstractFilter<O>> = [];

  readonly $ktClass: 'com.icure.sdk.model.filter.UnionFilter' = 'com.icure.sdk.model.filter.UnionFilter';

  constructor(partial: Partial<UnionFilter<O>>) {
    if ('desc' in partial) this.desc = partial.desc;
    if ('filters' in partial && partial.filters !== undefined) this.filters = partial.filters;
  }

}
