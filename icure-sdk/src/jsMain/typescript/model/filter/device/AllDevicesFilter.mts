// auto-generated file
import {Device} from '../../Device.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';
import {Filter} from '../Filter.mjs';


export class AllDevicesFilter implements AbstractFilter<Device>, Filter.AllFilter<Device> {

  desc: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.device.AllDevicesFilter' = 'com.icure.sdk.model.filter.device.AllDevicesFilter';

  constructor(partial: Partial<AllDevicesFilter>) {
    if ('desc' in partial) this.desc = partial.desc;
  }

}
