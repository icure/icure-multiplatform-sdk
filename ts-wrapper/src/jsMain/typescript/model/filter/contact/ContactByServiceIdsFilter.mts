// auto-generated file
import {Contact} from '../../Contact.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class ContactByServiceIdsFilter implements AbstractFilter<Contact> {

  desc: string | undefined = undefined;

  ids: Array<string> | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.contact.ContactByServiceIdsFilter' = 'com.icure.sdk.model.filter.contact.ContactByServiceIdsFilter';

  constructor(partial: Partial<ContactByServiceIdsFilter>) {
    if ('desc' in partial) this.desc = partial.desc;
    if ('ids' in partial) this.ids = partial.ids;
  }

}
