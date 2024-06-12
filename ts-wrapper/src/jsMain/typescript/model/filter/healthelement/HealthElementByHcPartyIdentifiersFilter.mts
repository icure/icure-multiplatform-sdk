// auto-generated file
import {HealthElement} from '../../HealthElement.mjs';
import {Identifier} from '../../base/Identifier.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class HealthElementByHcPartyIdentifiersFilter implements AbstractFilter<HealthElement> {

  desc: string | undefined = undefined;

  hcPartyId: string | undefined = undefined;

  identifiers: Array<Identifier> = [];

  readonly $ktClass: 'com.icure.sdk.model.filter.healthelement.HealthElementByHcPartyIdentifiersFilter' = 'com.icure.sdk.model.filter.healthelement.HealthElementByHcPartyIdentifiersFilter';

  constructor(partial: Partial<HealthElementByHcPartyIdentifiersFilter>) {
    if ('desc' in partial) this.desc = partial.desc;
    if ('hcPartyId' in partial) this.hcPartyId = partial.hcPartyId;
    if ('identifiers' in partial && partial.identifiers !== undefined) this.identifiers = partial.identifiers;
  }

}
