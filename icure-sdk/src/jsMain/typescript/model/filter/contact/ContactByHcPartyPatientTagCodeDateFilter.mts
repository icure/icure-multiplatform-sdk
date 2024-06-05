// auto-generated file
import {Contact} from '../../Contact.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class ContactByHcPartyPatientTagCodeDateFilter implements AbstractFilter<Contact> {

  desc: string | undefined = undefined;

  healthcarePartyId: string | undefined = undefined;

  patientSecretForeignKey: string | undefined = undefined;

  patientSecretForeignKeys: Array<string> | undefined = undefined;

  tagType: string | undefined = undefined;

  tagCode: string | undefined = undefined;

  codeType: string | undefined = undefined;

  codeCode: string | undefined = undefined;

  startOfContactOpeningDate: number | undefined = undefined;

  endOfContactOpeningDate: number | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.contact.ContactByHcPartyPatientTagCodeDateFilter' = 'com.icure.sdk.model.filter.contact.ContactByHcPartyPatientTagCodeDateFilter';

  constructor(partial: Partial<ContactByHcPartyPatientTagCodeDateFilter>) {
    if ('desc' in partial) this.desc = partial.desc;
    if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
    if ('patientSecretForeignKey' in partial) this.patientSecretForeignKey = partial.patientSecretForeignKey;
    if ('patientSecretForeignKeys' in partial) this.patientSecretForeignKeys = partial.patientSecretForeignKeys;
    if ('tagType' in partial) this.tagType = partial.tagType;
    if ('tagCode' in partial) this.tagCode = partial.tagCode;
    if ('codeType' in partial) this.codeType = partial.codeType;
    if ('codeCode' in partial) this.codeCode = partial.codeCode;
    if ('startOfContactOpeningDate' in partial) this.startOfContactOpeningDate = partial.startOfContactOpeningDate;
    if ('endOfContactOpeningDate' in partial) this.endOfContactOpeningDate = partial.endOfContactOpeningDate;
  }

}
