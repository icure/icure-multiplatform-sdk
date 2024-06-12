// auto-generated file
import {Patient} from '../../Patient.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class PatientByHcPartyDateOfBirthBetweenFilter implements AbstractFilter<Patient> {

  desc: string | undefined = undefined;

  minDateOfBirth: number | undefined = undefined;

  maxDateOfBirth: number | undefined = undefined;

  healthcarePartyId: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.patient.PatientByHcPartyDateOfBirthBetweenFilter' = 'com.icure.sdk.model.filter.patient.PatientByHcPartyDateOfBirthBetweenFilter';

  constructor(partial: Partial<PatientByHcPartyDateOfBirthBetweenFilter>) {
    if ('desc' in partial) this.desc = partial.desc;
    if ('minDateOfBirth' in partial) this.minDateOfBirth = partial.minDateOfBirth;
    if ('maxDateOfBirth' in partial) this.maxDateOfBirth = partial.maxDateOfBirth;
    if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
  }

}
