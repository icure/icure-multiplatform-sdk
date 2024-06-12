// auto-generated file
import {Service} from '../../embed/Service.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class ServiceByContactsAndSubcontactsFilter implements AbstractFilter<Service> {

  desc: string | undefined = undefined;

  healthcarePartyId: string | undefined = undefined;

  contacts: Array<string>;

  subContacts: Array<string> | undefined = undefined;

  startValueDate: number | undefined = undefined;

  endValueDate: number | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.service.ServiceByContactsAndSubcontactsFilter' = 'com.icure.sdk.model.filter.service.ServiceByContactsAndSubcontactsFilter';

  constructor(partial: Partial<ServiceByContactsAndSubcontactsFilter> & Pick<ServiceByContactsAndSubcontactsFilter, "contacts">) {
    if ('desc' in partial) this.desc = partial.desc;
    if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
    this.contacts = partial.contacts;
    if ('subContacts' in partial) this.subContacts = partial.subContacts;
    if ('startValueDate' in partial) this.startValueDate = partial.startValueDate;
    if ('endValueDate' in partial) this.endValueDate = partial.endValueDate;
  }

}
