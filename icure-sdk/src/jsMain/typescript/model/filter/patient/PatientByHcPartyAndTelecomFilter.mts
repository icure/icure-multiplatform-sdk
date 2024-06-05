// auto-generated file
import {Patient} from '../../Patient.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class PatientByHcPartyAndTelecomFilter implements AbstractFilter<Patient> {

  desc: string | undefined = undefined;

  searchString: string | undefined = undefined;

  healthcarePartyId: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.patient.PatientByHcPartyAndTelecomFilter' = 'com.icure.sdk.model.filter.patient.PatientByHcPartyAndTelecomFilter';

  constructor(partial: Partial<PatientByHcPartyAndTelecomFilter>) {
    if ('desc' in partial) this.desc = partial.desc;
    if ('searchString' in partial) this.searchString = partial.searchString;
    if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
  }

}
