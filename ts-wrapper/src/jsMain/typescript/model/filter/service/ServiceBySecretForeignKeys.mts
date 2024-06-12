// auto-generated file
import {Service} from '../../embed/Service.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class ServiceBySecretForeignKeys implements AbstractFilter<Service> {

  desc: string | undefined = undefined;

  healthcarePartyId: string | undefined = undefined;

  patientSecretForeignKeys: Array<string>;

  readonly $ktClass: 'com.icure.sdk.model.filter.service.ServiceBySecretForeignKeys' = 'com.icure.sdk.model.filter.service.ServiceBySecretForeignKeys';

  constructor(partial: Partial<ServiceBySecretForeignKeys> & Pick<ServiceBySecretForeignKeys, "patientSecretForeignKeys">) {
    if ('desc' in partial) this.desc = partial.desc;
    if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
    this.patientSecretForeignKeys = partial.patientSecretForeignKeys;
  }

}
