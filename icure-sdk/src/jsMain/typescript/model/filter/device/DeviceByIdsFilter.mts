// auto-generated file
import {Device} from '../../Device.mjs';
import {AbstractFilter} from '../AbstractFilter.mjs';
import {Filter} from '../Filter.mjs';


export class DeviceByIdsFilter implements AbstractFilter<Device>, Filter.IdsFilter<string, Device> {

  ids: Array<string>;

  desc: string | undefined = undefined;

  readonly $ktClass: 'com.icure.sdk.model.filter.device.DeviceByIdsFilter' = 'com.icure.sdk.model.filter.device.DeviceByIdsFilter';

  constructor(partial: Partial<DeviceByIdsFilter> & Pick<DeviceByIdsFilter, "ids">) {
    this.ids = partial.ids;
    if ('desc' in partial) this.desc = partial.desc;
  }

}
