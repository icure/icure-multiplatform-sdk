// auto-generated file
import {Service} from '../../embed/Service.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';


export class ServiceByHcPartyFilter implements AbstractFilter<Service> {

  hcpId: string;

  desc: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.service.ServiceByHcPartyFilter' = 'com.icure.sdk.model.filter.service.ServiceByHcPartyFilter';

  constructor(partial: Partial<ServiceByHcPartyFilter> & Pick<ServiceByHcPartyFilter, "hcpId">) {
    this.hcpId = partial.hcpId;
    if ('desc' in partial) this.desc = partial.desc;
  }

}
