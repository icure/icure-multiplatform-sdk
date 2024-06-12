// auto-generated file
import {Patient} from '../../Patient.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class PatientByHcPartyAndSsinsFilter implements AbstractFilter<Patient> {

  desc: string | undefined = undefined;

  ssins: Array<string> | undefined = undefined;

  healthcarePartyId: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.patient.PatientByHcPartyAndSsinsFilter' = 'com.icure.sdk.model.filter.patient.PatientByHcPartyAndSsinsFilter';

  constructor(partial: Partial<PatientByHcPartyAndSsinsFilter>) {
    if ('desc' in partial) this.desc = partial.desc;
    if ('ssins' in partial) this.ssins = partial.ssins;
    if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
  }

}
