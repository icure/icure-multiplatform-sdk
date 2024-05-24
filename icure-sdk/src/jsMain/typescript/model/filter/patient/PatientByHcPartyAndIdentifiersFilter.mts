// auto-generated file
import {Patient} from '../../Patient.mjs';
import {Identifier} from '../../base/Identifier.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class PatientByHcPartyAndIdentifiersFilter implements AbstractFilter<Patient> {

  healthcarePartyId: string | undefined = undefined;

  identifiers: Array<Identifier> = [];

  desc: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.patient.PatientByHcPartyAndIdentifiersFilter' = 'com.icure.sdk.model.filter.patient.PatientByHcPartyAndIdentifiersFilter';

  constructor(partial: Partial<PatientByHcPartyAndIdentifiersFilter>) {
    if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
    if ('identifiers' in partial && partial.identifiers !== undefined) this.identifiers = partial.identifiers;
    if ('desc' in partial) this.desc = partial.desc;
  }

}
