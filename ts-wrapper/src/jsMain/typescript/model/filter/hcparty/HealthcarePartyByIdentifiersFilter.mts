// auto-generated file
import {HealthcareParty} from '../../HealthcareParty.mjs';
import {Identifier} from '../../base/Identifier.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class HealthcarePartyByIdentifiersFilter implements AbstractFilter<HealthcareParty> {

  identifiers: Array<Identifier> = [];

  desc: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.hcparty.HealthcarePartyByIdentifiersFilter' = 'com.icure.sdk.model.filter.hcparty.HealthcarePartyByIdentifiersFilter';

  constructor(partial: Partial<HealthcarePartyByIdentifiersFilter>) {
    if ('identifiers' in partial && partial.identifiers !== undefined) this.identifiers = partial.identifiers;
    if ('desc' in partial) this.desc = partial.desc;
  }

}
