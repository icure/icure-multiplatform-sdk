// auto-generated file
import {HealthElement} from '../../HealthElement.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class HealthElementByHcPartySecretForeignKeysFilter implements AbstractFilter<HealthElement> {

  desc: string | undefined = undefined;

  healthcarePartyId: string | undefined = undefined;

  patientSecretForeignKeys: Array<string> = [];

  readonly $ktClass: 'com.icure.sdk.model.filter.healthelement.HealthElementByHcPartySecretForeignKeysFilter' = 'com.icure.sdk.model.filter.healthelement.HealthElementByHcPartySecretForeignKeysFilter';

  constructor(partial: Partial<HealthElementByHcPartySecretForeignKeysFilter>) {
    if ('desc' in partial) this.desc = partial.desc;
    if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
    if ('patientSecretForeignKeys' in partial && partial.patientSecretForeignKeys !== undefined) this.patientSecretForeignKeys = partial.patientSecretForeignKeys;
  }

}
