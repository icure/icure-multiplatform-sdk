// auto-generated file
import {Identifiable} from '../base/Identifiable.mjs';
import {AbstractFilter} from './AbstractFilter.mjs';
import {Filter} from './Filter.mjs';


export class ComplementFilter<O extends Identifiable<string>> implements AbstractFilter<O>, Filter.ComplementFilter<O> {

  desc: string | undefined = undefined;

  superSet: AbstractFilter<O>;

  subSet: AbstractFilter<O>;

  readonly $ktClass: 'com.icure.sdk.model.filter.ComplementFilter' = 'com.icure.sdk.model.filter.ComplementFilter';

  constructor(partial: Partial<ComplementFilter<O>> & Pick<ComplementFilter<O>, "superSet" | "subSet">) {
    if ('desc' in partial) this.desc = partial.desc;
    this.superSet = partial.superSet;
    this.subSet = partial.subSet;
  }

}
