// auto-generated file
import {Patient} from '../../Patient.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class PatientByHcPartyAndSsinFilter implements AbstractFilter<Patient> {

  desc: string | undefined = undefined;

  ssin: string;

  healthcarePartyId: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.patient.PatientByHcPartyAndSsinFilter' = 'com.icure.sdk.model.filter.patient.PatientByHcPartyAndSsinFilter';

  constructor(partial: Partial<PatientByHcPartyAndSsinFilter> & Pick<PatientByHcPartyAndSsinFilter, "ssin">) {
    if ('desc' in partial) this.desc = partial.desc;
    this.ssin = partial.ssin;
    if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
  }

}
