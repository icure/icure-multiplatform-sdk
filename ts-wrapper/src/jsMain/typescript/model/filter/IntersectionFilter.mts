// auto-generated file
import {Identifiable} from '../base/Identifiable.mjs';
import {AbstractFilter} from './AbstractFilter.mjs';
import {Filter} from './Filter.mjs';


export class IntersectionFilter<O extends Identifiable<string>> implements AbstractFilter<O>, Filter.IntersectionFilter<O> {

  desc: string | undefined = undefined;

  filters: Array<AbstractFilter<O>> = [];

  readonly $ktClass: 'com.icure.sdk.model.filter.IntersectionFilter' = 'com.icure.sdk.model.filter.IntersectionFilter';

  constructor(partial: Partial<IntersectionFilter<O>>) {
    if ('desc' in partial) this.desc = partial.desc;
    if ('filters' in partial && partial.filters !== undefined) this.filters = partial.filters;
  }

}
