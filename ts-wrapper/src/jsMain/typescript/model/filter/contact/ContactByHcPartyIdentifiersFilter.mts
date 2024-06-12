// auto-generated file
import {Contact} from '../../Contact.mjs';
import {Identifier} from '../../base/Identifier.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class ContactByHcPartyIdentifiersFilter implements AbstractFilter<Contact> {

  healthcarePartyId: string | undefined = undefined;

  desc: string | undefined = undefined;

  identifiers: Array<Identifier> = [];

  readonly $ktClass: 'com.icure.sdk.model.filter.contact.ContactByHcPartyIdentifiersFilter' = 'com.icure.sdk.model.filter.contact.ContactByHcPartyIdentifiersFilter';

  constructor(partial: Partial<ContactByHcPartyIdentifiersFilter>) {
    if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
    if ('desc' in partial) this.desc = partial.desc;
    if ('identifiers' in partial && partial.identifiers !== undefined) this.identifiers = partial.identifiers;
  }

}
