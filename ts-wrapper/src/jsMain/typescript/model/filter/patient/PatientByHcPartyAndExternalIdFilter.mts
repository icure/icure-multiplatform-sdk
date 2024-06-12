// auto-generated file
import {Patient} from '../../Patient.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class PatientByHcPartyAndExternalIdFilter implements AbstractFilter<Patient> {

  desc: string | undefined = undefined;

  externalId: string | undefined = undefined;

  healthcarePartyId: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.patient.PatientByHcPartyAndExternalIdFilter' = 'com.icure.sdk.model.filter.patient.PatientByHcPartyAndExternalIdFilter';

  constructor(partial: Partial<PatientByHcPartyAndExternalIdFilter>) {
    if ('desc' in partial) this.desc = partial.desc;
    if ('externalId' in partial) this.externalId = partial.externalId;
    if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
  }

}
