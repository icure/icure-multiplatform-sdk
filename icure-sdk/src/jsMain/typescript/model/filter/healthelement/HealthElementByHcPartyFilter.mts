// auto-generated file
import {HealthElement} from '../../HealthElement.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';
import {Filter} from '../Filter.mjs';


export class HealthElementByHcPartyFilter implements AbstractFilter<HealthElement>, Filter.ByHcpartyFilter<HealthElement> {

  hcpId: string;

  desc: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.healthelement.HealthElementByHcPartyFilter' = 'com.icure.sdk.model.filter.healthelement.HealthElementByHcPartyFilter';

  constructor(partial: Partial<HealthElementByHcPartyFilter> & Pick<HealthElementByHcPartyFilter, "hcpId">) {
    this.hcpId = partial.hcpId;
    if ('desc' in partial) this.desc = partial.desc;
  }

}
