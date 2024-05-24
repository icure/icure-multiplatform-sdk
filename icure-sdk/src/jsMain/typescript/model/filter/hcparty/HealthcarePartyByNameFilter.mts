// auto-generated file
import {HealthcareParty} from '../../HealthcareParty.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class HealthcarePartyByNameFilter implements AbstractFilter<HealthcareParty> {

  desc: string | undefined = undefined;

  name: string;

  descending: boolean | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.hcparty.HealthcarePartyByNameFilter' = 'com.icure.sdk.model.filter.hcparty.HealthcarePartyByNameFilter';

  constructor(partial: Partial<HealthcarePartyByNameFilter> & Pick<HealthcarePartyByNameFilter, "name">) {
    if ('desc' in partial) this.desc = partial.desc;
    this.name = partial.name;
    if ('descending' in partial) this.descending = partial.descending;
  }

}
