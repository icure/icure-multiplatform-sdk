// auto-generated file
import {Patient} from '../../Patient.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class PatientByHcPartyNameFilter implements AbstractFilter<Patient> {

  desc: string | undefined = undefined;

  name: string | undefined = undefined;

  healthcarePartyId: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.patient.PatientByHcPartyNameFilter' = 'com.icure.sdk.model.filter.patient.PatientByHcPartyNameFilter';

  constructor(partial: Partial<PatientByHcPartyNameFilter>) {
    if ('desc' in partial) this.desc = partial.desc;
    if ('name' in partial) this.name = partial.name;
    if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
  }

}
