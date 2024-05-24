// auto-generated file
import {Patient} from '../../Patient.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class PatientByHcPartyFilter implements AbstractFilter<Patient> {

  desc: string | undefined = undefined;

  healthcarePartyId: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.patient.PatientByHcPartyFilter' = 'com.icure.sdk.model.filter.patient.PatientByHcPartyFilter';

  constructor(partial: Partial<PatientByHcPartyFilter>) {
    if ('desc' in partial) this.desc = partial.desc;
    if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
  }

}
