// auto-generated file
import {Patient} from '../../Patient.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class PatientByHcPartyAndActiveFilter implements AbstractFilter<Patient> {

  desc: string | undefined = undefined;

  active: boolean = false;

  healthcarePartyId: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.patient.PatientByHcPartyAndActiveFilter' = 'com.icure.sdk.model.filter.patient.PatientByHcPartyAndActiveFilter';

  constructor(partial: Partial<PatientByHcPartyAndActiveFilter>) {
    if ('desc' in partial) this.desc = partial.desc;
    if ('active' in partial && partial.active !== undefined) this.active = partial.active;
    if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
  }

}
