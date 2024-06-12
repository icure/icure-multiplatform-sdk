// auto-generated file
import {Code} from '../../Code.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';
import {Filter} from '../Filter.mjs';


export class AllCodesFilter implements AbstractFilter<Code>, Filter.AllFilter<Code> {

  desc: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.code.AllCodesFilter' = 'com.icure.sdk.model.filter.code.AllCodesFilter';

  constructor(partial: Partial<AllCodesFilter>) {
    if ('desc' in partial) this.desc = partial.desc;
  }

}
