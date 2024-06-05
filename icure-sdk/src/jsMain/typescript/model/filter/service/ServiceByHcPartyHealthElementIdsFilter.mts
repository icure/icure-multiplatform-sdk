// auto-generated file
import {Service} from '../../embed/Service.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class ServiceByHcPartyHealthElementIdsFilter implements AbstractFilter<Service> {

  desc: string | undefined = undefined;

  healthcarePartyId: string | undefined = undefined;

  healthElementIds: Array<string> = [];

  readonly $ktClass: 'com.icure.sdk.model.filter.service.ServiceByHcPartyHealthElementIdsFilter' = 'com.icure.sdk.model.filter.service.ServiceByHcPartyHealthElementIdsFilter';

  constructor(partial: Partial<ServiceByHcPartyHealthElementIdsFilter>) {
    if ('desc' in partial) this.desc = partial.desc;
    if ('healthcarePartyId' in partial) this.healthcarePartyId = partial.healthcarePartyId;
    if ('healthElementIds' in partial && partial.healthElementIds !== undefined) this.healthElementIds = partial.healthElementIds;
  }

}
