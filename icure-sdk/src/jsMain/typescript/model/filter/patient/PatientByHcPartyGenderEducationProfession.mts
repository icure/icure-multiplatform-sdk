// auto-generated file
import {Patient} from '../../Patient.mjs';
import {Gender} from '../../embed/Gender.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class PatientByHcPartyGenderEducationProfession implements AbstractFilter<Patient> {

  desc: string | undefined = undefined;

  healthcarePartyId: string | undefined = undefined;

  gender: Gender | undefined = undefined;

  education: string | undefined = undefined;

  profession: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.patient.PatientByHcPartyGenderEducationProfession' = 'com.icure.sdk.model.filter.patient.PatientByHcPartyGenderEducationProfession';

  constructor(partial: Partial<PatientByHcPartyGenderEducationProfession>) {
    if ('desc' in partial) this.desc = partial.desc;
    if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
    if ('gender' in partial) this.gender = partial.gender;
    if ('education' in partial) this.education = partial.education;
    if ('profession' in partial) this.profession = partial.profession;
  }

}
