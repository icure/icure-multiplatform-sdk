// auto-generated file
import {Contact} from '../../Contact.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';
import {Filter} from '../Filter.mjs';


export class ContactByHcPartyFilter implements AbstractFilter<Contact>, Filter.ByHcpartyFilter<Contact> {

  hcpId: string;

  desc: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.contact.ContactByHcPartyFilter' = 'com.icure.sdk.model.filter.contact.ContactByHcPartyFilter';

  constructor(partial: Partial<ContactByHcPartyFilter> & Pick<ContactByHcPartyFilter, "hcpId">) {
    this.hcpId = partial.hcpId;
    if ('desc' in partial) this.desc = partial.desc;
  }

}
