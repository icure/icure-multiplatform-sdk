// auto-generated file
import {HealthcareParty} from '../../HealthcareParty.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';
import {Filter} from '../Filter.mjs';


export class AllHealthcarePartiesFilter implements AbstractFilter<HealthcareParty>, Filter.AllFilter<HealthcareParty> {

  desc: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.hcparty.AllHealthcarePartiesFilter' = 'com.icure.sdk.model.filter.hcparty.AllHealthcarePartiesFilter';

  constructor(partial: Partial<AllHealthcarePartiesFilter>) {
    if ('desc' in partial) this.desc = partial.desc;
  }

}
