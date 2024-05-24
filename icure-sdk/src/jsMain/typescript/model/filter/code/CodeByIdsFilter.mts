// auto-generated file
import {Code} from '../../Code.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';
import {Filter} from '../Filter.mjs';


export class CodeByIdsFilter implements AbstractFilter<Code>, Filter.IdsFilter<string, Code> {

  ids: Array<string>;

  desc: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.code.CodeByIdsFilter' = 'com.icure.sdk.model.filter.code.CodeByIdsFilter';

  constructor(partial: Partial<CodeByIdsFilter> & Pick<CodeByIdsFilter, "ids">) {
    this.ids = partial.ids;
    if ('desc' in partial) this.desc = partial.desc;
  }

}
