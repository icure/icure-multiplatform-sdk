// auto-generated file
import {Patient} from '../../Patient.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class PatientByHcPartyNameContainsFuzzyFilter implements AbstractFilter<Patient> {

  desc: string | undefined = undefined;

  searchString: string | undefined = undefined;

  healthcarePartyId: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.patient.PatientByHcPartyNameContainsFuzzyFilter' = 'com.icure.sdk.model.filter.patient.PatientByHcPartyNameContainsFuzzyFilter';

  constructor(partial: Partial<PatientByHcPartyNameContainsFuzzyFilter>) {
    if ('desc' in partial) this.desc = partial.desc;
    if ('searchString' in partial) this.searchString = partial.searchString;
    if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
  }

}
