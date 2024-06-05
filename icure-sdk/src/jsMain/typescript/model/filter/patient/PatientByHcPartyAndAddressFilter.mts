// auto-generated file
import {Patient} from '../../Patient.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class PatientByHcPartyAndAddressFilter implements AbstractFilter<Patient> {

  desc: string | undefined = undefined;

  searchString: string | undefined = undefined;

  healthcarePartyId: string | undefined = undefined;

  postalCode: string | undefined = undefined;

  houseNumber: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.patient.PatientByHcPartyAndAddressFilter' = 'com.icure.sdk.model.filter.patient.PatientByHcPartyAndAddressFilter';

  constructor(partial: Partial<PatientByHcPartyAndAddressFilter>) {
    if ('desc' in partial) this.desc = partial.desc;
    if ('searchString' in partial) this.searchString = partial.searchString;
    if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
    if ('postalCode' in partial) this.postalCode = partial.postalCode;
    if ('houseNumber' in partial) this.houseNumber = partial.houseNumber;
  }

}
