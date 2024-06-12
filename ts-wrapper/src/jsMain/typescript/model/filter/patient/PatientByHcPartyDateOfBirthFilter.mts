// auto-generated file
import {Patient} from '../../Patient.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class PatientByHcPartyDateOfBirthFilter implements AbstractFilter<Patient> {

  desc: string | undefined = undefined;

  dateOfBirth: number;

  healthcarePartyId: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.patient.PatientByHcPartyDateOfBirthFilter' = 'com.icure.sdk.model.filter.patient.PatientByHcPartyDateOfBirthFilter';

  constructor(partial: Partial<PatientByHcPartyDateOfBirthFilter> & Pick<PatientByHcPartyDateOfBirthFilter, "dateOfBirth">) {
    if ('desc' in partial) this.desc = partial.desc;
    this.dateOfBirth = partial.dateOfBirth;
    if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
  }

}
