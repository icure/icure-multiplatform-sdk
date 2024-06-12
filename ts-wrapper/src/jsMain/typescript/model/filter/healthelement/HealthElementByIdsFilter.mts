// auto-generated file
import {HealthElement} from '../../HealthElement.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';
import {Filter} from '../Filter.mjs';


export class HealthElementByIdsFilter implements AbstractFilter<HealthElement>, Filter.IdsFilter<string, HealthElement> {

  ids: Array<string>;

  desc: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.healthelement.HealthElementByIdsFilter' = 'com.icure.sdk.model.filter.healthelement.HealthElementByIdsFilter';

  constructor(partial: Partial<HealthElementByIdsFilter> & Pick<HealthElementByIdsFilter, "ids">) {
    this.ids = partial.ids;
    if ('desc' in partial) this.desc = partial.desc;
  }

}
