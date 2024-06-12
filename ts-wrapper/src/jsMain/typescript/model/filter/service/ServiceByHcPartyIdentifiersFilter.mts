// auto-generated file
import {Identifier} from '../../base/Identifier.mjs';
import {Service} from '../../embed/Service.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class ServiceByHcPartyIdentifiersFilter implements AbstractFilter<Service> {

  healthcarePartyId: string | undefined = undefined;

  identifiers: Array<Identifier> = [];

  desc: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.service.ServiceByHcPartyIdentifiersFilter' = 'com.icure.sdk.model.filter.service.ServiceByHcPartyIdentifiersFilter';

  constructor(partial: Partial<ServiceByHcPartyIdentifiersFilter>) {
    if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
    if ('identifiers' in partial && partial.identifiers !== undefined) this.identifiers = partial.identifiers;
    if ('desc' in partial) this.desc = partial.desc;
  }

}
