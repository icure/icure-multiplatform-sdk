// auto-generated file
import {Identifiable} from '../base/Identifiable.mjs';
import {AbstractFilter} from './AbstractFilter.mjs';
import {Filter} from './Filter.mjs';


export class IdsFilter<O extends Identifiable<string>> implements AbstractFilter<O>, Filter.IdsFilter<string, O> {

  desc: string | undefined = undefined;

  ids: Array<string>;

  readonly $ktClass: 'com.icure.sdk.model.filter.IdsFilter' = 'com.icure.sdk.model.filter.IdsFilter';

  constructor(partial: Partial<IdsFilter<O>> & Pick<IdsFilter<O>, "ids">) {
    if ('desc' in partial) this.desc = partial.desc;
    this.ids = partial.ids;
  }

}
