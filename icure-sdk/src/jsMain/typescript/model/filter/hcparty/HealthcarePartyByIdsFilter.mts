// auto-generated file
import {HealthcareParty} from '../../HealthcareParty.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';
import {Filter} from '../Filter.mjs';


export class HealthcarePartyByIdsFilter implements AbstractFilter<HealthcareParty>, Filter.IdsFilter<string, HealthcareParty> {

  ids: Array<string>;

  desc: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.hcparty.HealthcarePartyByIdsFilter' = 'com.icure.sdk.model.filter.hcparty.HealthcarePartyByIdsFilter';

  constructor(partial: Partial<HealthcarePartyByIdsFilter> & Pick<HealthcarePartyByIdsFilter, "ids">) {
    this.ids = partial.ids;
    if ('desc' in partial) this.desc = partial.desc;
  }

}
