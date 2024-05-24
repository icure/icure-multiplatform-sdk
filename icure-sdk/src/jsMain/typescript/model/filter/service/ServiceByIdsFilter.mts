// auto-generated file
import {Service} from '../../embed/Service.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';
import {Filter} from '../Filter.mjs';


export class ServiceByIdsFilter implements AbstractFilter<Service>, Filter.IdsFilter<string, Service> {

  ids: Array<string>;

  desc: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.service.ServiceByIdsFilter' = 'com.icure.sdk.model.filter.service.ServiceByIdsFilter';

  constructor(partial: Partial<ServiceByIdsFilter> & Pick<ServiceByIdsFilter, "ids">) {
    this.ids = partial.ids;
    if ('desc' in partial) this.desc = partial.desc;
  }

}
